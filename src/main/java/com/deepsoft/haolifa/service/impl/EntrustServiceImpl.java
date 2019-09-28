package com.deepsoft.haolifa.service.impl;

import static com.deepsoft.haolifa.constant.CacheKey.BATCH_NUM_KEY;
import static com.deepsoft.haolifa.constant.CacheKey.ENTRUST_NO_KEY;
import static com.deepsoft.haolifa.constant.Constant.SerialNumberPrefix.BATCH_NUMBER_PREFIX_PC;
import static com.deepsoft.haolifa.constant.Constant.SerialNumberPrefix.ENTRUST_NO_PREFIX_JJ;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.constant.CommonEnum.Consts;
import com.deepsoft.haolifa.constant.CommonEnum.EntrustStatus;
import com.deepsoft.haolifa.constant.CommonEnum.Inspect2Status;
import com.deepsoft.haolifa.constant.CommonEnum.ResponseEnum;
import com.deepsoft.haolifa.dao.repository.EntrustMapper;
import com.deepsoft.haolifa.model.domain.CheckMaterialLock;
import com.deepsoft.haolifa.model.domain.Entrust;
import com.deepsoft.haolifa.model.domain.EntrustExample;
import com.deepsoft.haolifa.model.domain.InspectHistory;
import com.deepsoft.haolifa.model.dto.AllotEntrustDTO;
import com.deepsoft.haolifa.model.dto.EntrustDTO;
import com.deepsoft.haolifa.model.dto.EntrustListDTO;
import com.deepsoft.haolifa.model.dto.FlowInstanceDTO;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.CheckMaterialLockService;
import com.deepsoft.haolifa.service.EntrustService;
import com.deepsoft.haolifa.service.FlowInstanceService;
import com.deepsoft.haolifa.service.InspectService;
import com.deepsoft.haolifa.util.RandomUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Slf4j
@Service
public class EntrustServiceImpl extends BaseService implements EntrustService {

    @Autowired
    EntrustMapper entrustMapper;
    @Autowired
    InspectService inspectService;
    @Lazy
    @Autowired
    FlowInstanceService flowInstanceService;
    @Autowired
    private ValidateService validateService;
    @Autowired
    private CheckMaterialLockService checkMaterialLockService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultBean save(EntrustDTO model) {
        if (model.getNumber() == null || model.getNumber() == 0) {
            return ResultBean.error(ResponseEnum.ENTRUST_PARAMS_NUMBER_ERROR);
        }
        if (StringUtils.isAnyBlank(model.getMaterialGraphName(), model.getMaterialGraphNo(), model.getProcessedGraphNo(),
                model.getBatchNumber())) {
            return ResultBean.error(ResponseEnum.ENTRUST_PARAMS_VALIDATE_ERROR);
        }
        validateService.validateIsExistMaterialGraphNo(model.getProcessedGraphNo());
        String entrustNo = createSerialNumber(ENTRUST_NO_PREFIX_JJ, ENTRUST_NO_KEY);
        Entrust entrust = new Entrust();
        BeanUtils.copyProperties(model, entrust);
        entrust.setCreateUserId(getLoginUserId());
        entrust.setEntrustNo(entrustNo);
        if (model.getActionType() == 1) {
            entrust.setStatus((byte) 0);
        } else {
            entrust.setStatus((byte) 1);
        }
//    entrust.setBatchNumber(createSerialNumber(BATCH_NUMBER_PREFIX_PC, BATCH_NUM_KEY));
        entrustMapper.insertSelective(entrust);
        return ResultBean.success(entrustNo);
    }

    @Override
    public ResultBean delete(String entrustNo) {
        Entrust entrust = new Entrust();
        entrust.setIsDelete(CommonEnum.Consts.YES.code);
        EntrustExample entrustExample = new EntrustExample();
        entrustExample.or().andEntrustNoEqualTo(entrustNo);
        entrustMapper.updateByExampleSelective(entrust, entrustExample);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean update(String entrustNo, EntrustDTO model) {
        if (model.getNumber() == null || model.getNumber() == 0) {
            return ResultBean.error(ResponseEnum.ENTRUST_PARAMS_NUMBER_ERROR);
        }
        if (StringUtils.isAnyBlank(model.getMaterialGraphName(), model.getMaterialGraphNo(), model.getProcessedGraphNo(),
                model.getBatchNumber())) {
            return ResultBean.error(ResponseEnum.ENTRUST_PARAMS_VALIDATE_ERROR);
        }
        Entrust entrust = new Entrust();
        BeanUtils.copyProperties(model, entrust);
        EntrustExample entrustExample = new EntrustExample();
        entrustExample.or().andEntrustNoEqualTo(entrustNo);
        entrustMapper.updateByExampleSelective(entrust, entrustExample);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean getInfo(String entrustNo) {
        EntrustExample entrustExample = new EntrustExample();
        entrustExample.or().andEntrustNoEqualTo(entrustNo);
        List<Entrust> entrustList = entrustMapper.selectByExample(entrustExample);
        if (entrustList == null || entrustList.size() == 0) {
            return ResultBean.success(new HashMap<>());
        }
        return ResultBean.success(entrustList.get(0));
    }

    @Override
    public ResultBean getList(EntrustListDTO model) {
        if (model.getPageNum() == null || model.getPageNum() == 0) {
            model.setPageNum(1);
        }
        if (model.getPageSize() == null || model.getPageSize() == 0) {
            model.setPageSize(10);
        }
        EntrustExample entrustExample = new EntrustExample();
        EntrustExample.Criteria criteria = entrustExample.createCriteria();
        criteria.andIsDeleteEqualTo(Consts.NO.code);
        if (StringUtils.isNotEmpty(model.getEntrustNo())) {
            criteria.andEntrustNoLike("%" + model.getEntrustNo() + "%");
        }
        if (model.getType() == 1) {
            // 调度
            criteria.andStatusNotEqualTo(EntrustStatus.NO_COMMIT_0.code);
        }
        if (model.getType() == 2) {
            // 车间
            List<Byte> statusList = Arrays
                    .asList(EntrustStatus.NO_COMMIT_0.code, EntrustStatus.AUDITING_1.code, EntrustStatus.AUDIT_NO_PASS_5.code);
            criteria.andStatusNotIn(statusList);
            criteria.andWorkshopTypeEqualTo((byte) 1);// 内部车间
        }
        if (model.getType() == 3) {
            // 质检
            List<Byte> statusList = Arrays
                    .asList(EntrustStatus.NO_COMMIT_0.code, EntrustStatus.AUDITING_1.code, EntrustStatus.AUDIT_NO_PASS_5.code,
                            EntrustStatus.AUDIT_PASS_WAITING_2.code);
            criteria.andStatusNotIn(statusList);
            criteria.andWorkshopTypeEqualTo((byte) 1);// 内部车间
        }
        if (model.getStatus() != -1) {
            criteria.andStatusEqualTo(model.getStatus().byteValue());
        }
        Page<Entrust> pageData = PageHelper.startPage(model.getPageNum(), model.getPageSize(), "create_time desc")
                .doSelectPage(() ->
                        entrustMapper.selectByExample(entrustExample));
        PageDTO<Entrust> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);
        pageDTO.setList(pageData.getResult());
        return ResultBean.success(pageDTO);
    }

    @Override
    public ResultBean updateStatus(String entrustNo, Integer status) {
        if (StringUtils.isEmpty(entrustNo) || status == null) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }

        Entrust entrust = new Entrust();
        if (status.byteValue() == EntrustStatus.DEALING_3.code) {
            entrust.setInspectStatus(Inspect2Status.handling.code);
        }
        entrust.setStatus(status.byteValue());
        EntrustExample entrustExample = new EntrustExample();
        entrustExample.or().andEntrustNoEqualTo(entrustNo);
        entrustMapper.updateByExampleSelective(entrust, entrustExample);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean allotEntrust(AllotEntrustDTO allotEntrustDTO) {
        Entrust entrust = new Entrust();
        BeanUtils.copyProperties(allotEntrustDTO, entrust);
        entrust.setWorkshopType(allotEntrustDTO.getWorkShopType().byteValue());
        entrust.setStatus(EntrustStatus.AUDIT_PASS_WAITING_2.code);
        entrustMapper.updateByPrimaryKeySelective(entrust);
        return ResultBean.success(1);
    }

    @Override
    public int obtainEntrustNumber(String materialGraphNo, String processedGraphNo) {
        if (StringUtils.isEmpty(materialGraphNo)) {
            return 0;
        }
        EntrustExample entrustExample = new EntrustExample();
        EntrustExample.Criteria criteria = entrustExample.createCriteria();
        if (materialGraphNo.endsWith("J") || materialGraphNo.endsWith("j")) {
            int index = materialGraphNo.lastIndexOf("-");
            criteria.andMaterialGraphNoLike(materialGraphNo.substring(0, index) + "%");
        } else {
            criteria.andMaterialGraphNoEqualTo(materialGraphNo);
        }
        if (StringUtils.isNotBlank(processedGraphNo)) {
            criteria.andProcessedGraphNoEqualTo(processedGraphNo);
        }

        criteria.andStatusIn(Arrays
                .asList(EntrustStatus.DEALING_3.code, EntrustStatus.INSPECT_COMPLETE.code));
        List<Entrust> entrusts = entrustMapper.selectByExample(entrustExample);
        int number = entrusts.stream().map(Entrust::getNumber).reduce(0, (a, b) -> a + b);

        // 获取 机加工质检完成的合格数量
        if (number > 0) {
            List<String> noList = entrusts.stream().map(Entrust::getEntrustNo).collect(Collectors.toList());
            List<InspectHistory> inspectHistories = inspectService.historyList(noList, CommonEnum.InspectHistoryStatus.BEEN_STORE_2.code, CommonEnum.InspectHistoryType.ENTRUST.code);
            if (CollectionUtils.isEmpty(inspectHistories)) {
                // 已经入库的数量
                Integer storeCount = inspectHistories.stream().map(InspectHistory::getQualifiedNumber).reduce(0, (a, b) -> a + b);
                // 正在机加工的数据，需要减去已经入库的数量
                number = number - storeCount;

                if (number > 0) {
                    // 获取已经核料锁定的数量
                    List<CheckMaterialLock> checkMaterialLocks = checkMaterialLockService.findByMaterialAndType(materialGraphNo, CommonEnum.CheckMaterialLockType.ENTRUST.type);
                    if (!CollectionUtils.isEmpty(checkMaterialLocks)) {
                        Integer lockCount = checkMaterialLocks.stream().map(CheckMaterialLock::getLockQuantity).reduce(0, (a, b) -> a + b);
                        number = number - lockCount;
                    }
                }
            }
        }
        return number;
    }

    @Override
    public ResultBean updateInspectStatus(String entrustNo, Integer status) {
        if (StringUtils.isEmpty(entrustNo) || status == null || status < 0 || status > 3) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        Entrust entrust = new Entrust();
        entrust.setInspectStatus(status.byteValue());
        EntrustExample entrustExample = new EntrustExample();
        entrustExample.or().andEntrustNoEqualTo(entrustNo);
        entrustMapper.updateByExampleSelective(entrust, entrustExample);
        return ResultBean.success(1);
    }
}
