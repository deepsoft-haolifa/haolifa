package com.deepsoft.haolifa.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.ValveSeatEntrustMapper;
import com.deepsoft.haolifa.dao.repository.ValveSeatInspectHistoryMapper;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.Accessory;
import com.deepsoft.haolifa.model.dto.BaseException;
import com.deepsoft.haolifa.model.dto.InspectReason;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.pay.PayCalculateDTO;
import com.deepsoft.haolifa.model.dto.valveSeat.*;
import com.deepsoft.haolifa.service.PayOrderUserRelationProcedureService;
import com.deepsoft.haolifa.service.ValveSeatEntrustService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;

import static com.deepsoft.haolifa.constant.CacheKey.VS_ENTRUST_NO_KEY;
import static com.deepsoft.haolifa.constant.Constant.SerialNumberPrefix.VS_NO_PREFIX_AC;

/**
 * @author murphy.he
 **/
@Slf4j
@Service
public class ValveSeatEntrustServiceImpl extends BaseService implements ValveSeatEntrustService {

    @Resource
    private ValveSeatEntrustMapper valveSeatEntrustMapper;
    @Resource
    private ValveSeatInspectHistoryMapper valveSeatInspectHistoryMapper;
    @Resource
    private PayOrderUserRelationProcedureService payOrderUserRelationProcedureService;


    @Override
    public int add(ValveSeatEntrustReqDto reqDto) {
        ValveSeatEntrust model = new ValveSeatEntrust();
        String acNo = createSerialNumber(VS_NO_PREFIX_AC, VS_ENTRUST_NO_KEY);
        BeanUtil.copyProperties(reqDto, model);
        model.setEntrustNo(acNo);
        return valveSeatEntrustMapper.insertSelective(model);
    }

    @Override
    public int update(ValveSeatEntrustReqDto reqDto) {
        ValveSeatEntrust model = valveSeatEntrustMapper.selectByPrimaryKey(reqDto.getId());
        if(!model.getStatus().equals(CommonEnum.SprayStatus.SPRAY_CREATE.code)){
            throw new BaseException("只有待加工才能操作");
        }
        BeanUtil.copyProperties(reqDto, model);
        return valveSeatEntrustMapper.updateByPrimaryKeySelective(model);

    }

    @Override
    public int delete(Integer id) {
        ValveSeatEntrust model = valveSeatEntrustMapper.selectByPrimaryKey(id);
        if(!model.getStatus().equals(CommonEnum.SprayStatus.SPRAY_CREATE.code)){
            throw new BaseException("只有待加工才能操作");
        }
        return valveSeatEntrustMapper.deleteByPrimaryKey(id);

    }

    @Override
    public PageDTO<ValveSeatEntrust> pageList(ValveSeatEntrustConditionDto pageDto) {
        ValveSeatEntrustExample example = new ValveSeatEntrustExample();
        ValveSeatEntrustExample.Criteria criteria = example.createCriteria();
        if (null != pageDto.getStatus() && pageDto.getStatus() != -1) {
            criteria.andStatusEqualTo(pageDto.getStatus());
        }
        if (null != pageDto.getInspectStatus() && pageDto.getInspectStatus() != -1) {
            criteria.andInspectStatusEqualTo(pageDto.getInspectStatus());
        }
        if (null != pageDto.getType() && pageDto.getType() == 1) {
            criteria.andStatusIn(Arrays.asList((byte) 1, (byte) 2, (byte) 3));
        }
        if (StringUtils.isNotEmpty(pageDto.getEntrustNo())) {
            criteria.andEntrustNoEqualTo("%" + pageDto.getEntrustNo() + "%");
        }
        if (StringUtils.isNotEmpty(pageDto.getGraphNo())) {
            criteria.andGraphNoEqualTo("%" + pageDto.getGraphNo() + "%");
        }
        Page<ValveSeatEntrust> pageList = PageHelper.startPage(pageDto.getPageNum(), pageDto.getPageSize(), "id desc")
            .doSelectPage(() -> valveSeatEntrustMapper.selectByExample(example));
        PageDTO<ValveSeatEntrust> pageDtos = new PageDTO<>();
        BeanUtils.copyProperties(pageList, pageDtos);
        pageDtos.setList(pageList);
        return pageDtos;
    }

    @Override
    public int updateStatus(Integer id, int status) {
        ValveSeatEntrust valveSeatEntrust = new ValveSeatEntrust();
        valveSeatEntrust.setId(id);
        valveSeatEntrust.setStatus(Integer.valueOf(status).byteValue());
        return valveSeatEntrustMapper.updateByPrimaryKeySelective(valveSeatEntrust);
    }

    @Override
    public int updateInspectStatus(Integer id, int status) {
        ValveSeatEntrust valveSeatEntrust = new ValveSeatEntrust();
        valveSeatEntrust.setId(id);
        valveSeatEntrust.setInspectStatus(Integer.valueOf(status).byteValue());
        return valveSeatEntrustMapper.updateByPrimaryKeySelective(valveSeatEntrust);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveInspect(ValveSeatInspectDto valveSeatInspectDto) {
        PayOrderUserRelationProcedure payOrderUserRelationProcedure = new PayOrderUserRelationProcedure();
        payOrderUserRelationProcedure.setOrderId(valveSeatInspectDto.getNo());
        List<PayOrderUserRelationProcedure> payOrderUserRelationProcedureList = payOrderUserRelationProcedureService.getPayOrderUserRelationProcedureList(payOrderUserRelationProcedure);
        if (org.apache.commons.collections4.CollectionUtils.isEmpty(payOrderUserRelationProcedureList)) {
            throw new BaseException(CommonEnum.ResponseEnum.ORDER_NOT_ASSIGN_TASK);
        }
        if (valveSeatInspectDto.getTestNumber() == 0) {
            throw new BaseException(CommonEnum.ResponseEnum.INSPECT_TESTNUMBER_IS_ZERO);
        }
        // 不合格原因
        ValveSeatInspectHistory history = new ValveSeatInspectHistory();
        BeanUtils.copyProperties(valveSeatInspectDto, history);
        boolean isEmpty = CollectionUtils.isEmpty(valveSeatInspectDto.getReasonList());
        if (!isEmpty) {
            int unqualifiedNum = valveSeatInspectDto.getReasonList().stream().mapToInt(InspectReason::getNumber).sum();
            valveSeatInspectDto.setUnqualifiedNumber(unqualifiedNum);
            history.setUnqualifiedNumber(unqualifiedNum);
            history.setReasons(JSON.toJSONString(valveSeatInspectDto.getReasonList()));
        } else {
            valveSeatInspectDto.setUnqualifiedNumber(0);
            history.setUnqualifiedNumber(0);
        }
        if (valveSeatInspectDto.getQualifiedNumber() + valveSeatInspectDto.getUnqualifiedNumber() != valveSeatInspectDto.getTestNumber()) {
            throw new BaseException(CommonEnum.ResponseEnum.INSPECT_RECORD_DATA_ERROR);
        }
        // 质检附件
        if (!CollectionUtils.isEmpty(valveSeatInspectDto.getAccessoryList())) {
            history.setAccessory(JSON.toJSONString(valveSeatInspectDto.getAccessoryList()));
        }
        ValveSeatEntrust entrust = valveSeatEntrustMapper.selectByPrimaryKey(valveSeatInspectDto.getValveSeatId());
        entrust.setQualifiedNumber(entrust.getQualifiedNumber() + valveSeatInspectDto.getQualifiedNumber());
        if (entrust.getQty() < entrust.getQualifiedNumber()) {
            throw new BaseException(CommonEnum.ResponseEnum.ENTRUST_QUALIFIED_NUMBER_ERROR);
        }
        valveSeatEntrustMapper.updateByPrimaryKeySelective(entrust);
        return valveSeatInspectHistoryMapper.insertSelective(history);
    }

    @Override
    public List<ValveSeatInspectHistoryDto> getInspectList(String no) {
        ValveSeatInspectHistoryExample inspectHistoryExample = new ValveSeatInspectHistoryExample();
        inspectHistoryExample.createCriteria().andNoEqualTo(no);
        List<ValveSeatInspectHistory> inspectHistories = valveSeatInspectHistoryMapper.selectByExample(inspectHistoryExample);
        List<ValveSeatInspectHistoryDto> valveSeatInspectHistoryDtos = new ArrayList<>(inspectHistories.size());
        for (ValveSeatInspectHistory history : inspectHistories) {
            ValveSeatInspectHistoryDto dto = new ValveSeatInspectHistoryDto();
            BeanUtils.copyProperties(history, dto);
            if (StringUtils.isNotEmpty(history.getAccessory())) {
                dto.setAccessoryList(JSON.parseArray(history.getAccessory(), Accessory.class));
            }
            if (StringUtils.isNotEmpty(history.getReasons())) {
                dto.setReasonList(JSON.parseArray(history.getReasons(), InspectReason.class));
            } else if (history.getUnqualifiedNumber() > 0) {
                dto.setReasonList(Collections.singletonList(new InspectReason(history.getRemark(), history.getUnqualifiedNumber())));
            } else {
                dto.setReasonList(Collections.emptyList());
            }
            valveSeatInspectHistoryDtos.add(dto);
        }
        return valveSeatInspectHistoryDtos;
    }

    @Override
    public PageDTO<ValveSeatInspectHistory> historyList(HistoryConditionDto pageDto) {
        ValveSeatInspectHistoryExample example = new ValveSeatInspectHistoryExample();
        ValveSeatInspectHistoryExample.Criteria criteria = example.createCriteria();
        if (null != pageDto.getStatus() && pageDto.getStatus() > 0) {
            criteria.andStatusEqualTo(pageDto.getStatus());
        }
        if (StrUtil.isNotBlank(pageDto.getGraphNo())) {
            criteria.andMaterialGraphNoLike("%" + pageDto.getGraphNo() + "%");
        }
        if (StrUtil.isNotBlank(pageDto.getEntrustNo())) {
            criteria.andNoLike("%" + pageDto.getEntrustNo() + "%");
        }
        // 合格数大于0
        criteria.andQualifiedNumberGreaterThan(0);
        Page<ValveSeatInspectHistory> histories = PageHelper.startPage(pageDto.getPageNum(), pageDto.getPageSize(), "id desc")
            .doSelectPage(() -> valveSeatInspectHistoryMapper.selectByExample(example));
        PageDTO<ValveSeatInspectHistory> pageDTO = new PageDTO<ValveSeatInspectHistory>();
        BeanUtils.copyProperties(histories, pageDTO);
        pageDTO.setList(histories.getResult());
        return pageDTO;
    }

    @Override
    public int updateHistoryStatus(Integer historyId) {
        ValveSeatInspectHistory history = new ValveSeatInspectHistory();
        history.setId(historyId);
        history.setStatus(CommonEnum.InspectHistoryStatus.BEEN_STORE_2.code);
        return valveSeatInspectHistoryMapper.updateByPrimaryKeySelective(history);
    }

    @Override
    public List<ValveSeatInspectHistory> getInspectHistoryList(PayCalculateDTO payCalculateDTO) {
        ValveSeatInspectHistoryExample inspectHistoryExample = new ValveSeatInspectHistoryExample();
        ValveSeatInspectHistoryExample.Criteria criteria = inspectHistoryExample.createCriteria();
        if (StringUtils.isNotBlank(payCalculateDTO.getOrderNo())) {
            criteria.andNoEqualTo(payCalculateDTO.getOrderNo());
        }
        if (StringUtils.isNotBlank(payCalculateDTO.getProductNo())) {
            criteria.andMaterialGraphNoEqualTo(payCalculateDTO.getProductNo());
        }
        if (Objects.nonNull(payCalculateDTO.getStorageStatus())) {
            criteria.andStatusEqualTo(payCalculateDTO.getStorageStatus());
        }
        if (Objects.nonNull(payCalculateDTO.getStartTime())) {
            criteria.andUpdateTimeGreaterThanOrEqualTo(payCalculateDTO.getStartTime());
        }
        if (Objects.nonNull(payCalculateDTO.getEndTime())) {
            criteria.andUpdateTimeLessThanOrEqualTo(payCalculateDTO.getEndTime());
        }
        List<ValveSeatInspectHistory> inspectHistories = valveSeatInspectHistoryMapper.selectByExample(inspectHistoryExample);
        return inspectHistories;
    }

}
