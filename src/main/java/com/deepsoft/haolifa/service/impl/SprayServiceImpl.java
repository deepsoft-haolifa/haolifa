package com.deepsoft.haolifa.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSON;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.constant.CommonEnum.ResponseEnum;
import com.deepsoft.haolifa.dao.repository.PayOrderUserRelationProcedureMapper;
import com.deepsoft.haolifa.dao.repository.SprayInspectHistoryMapper;
import com.deepsoft.haolifa.dao.repository.SprayItemMapper;
import com.deepsoft.haolifa.dao.repository.SprayMapper;
import com.deepsoft.haolifa.dao.repository.extend.SparyExtendMapper;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.model.dto.order.CheckMaterialLockDTO;
import com.deepsoft.haolifa.model.dto.pay.PayCalculateDTO;
import com.deepsoft.haolifa.model.dto.spray.*;
import com.deepsoft.haolifa.model.vo.SprayInspectHistoryVo;
import com.deepsoft.haolifa.model.vo.SprayVo;
import com.deepsoft.haolifa.service.CheckMaterialLockService;
import com.deepsoft.haolifa.service.SprayService;
import com.deepsoft.haolifa.util.DateFormatterUtils;
import com.deepsoft.haolifa.util.DateUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

import static com.deepsoft.haolifa.constant.CacheKey.SPRAY_NO_KEY;
import static com.deepsoft.haolifa.constant.CommonEnum.Inspect2Status.handling;
import static com.deepsoft.haolifa.constant.CommonEnum.SprayStatus.SPRAY_MACHINE;
import static com.deepsoft.haolifa.constant.Constant.SerialNumberPrefix.SPRAY_NO_PREFIX_PT;

@Service
@Slf4j
public class SprayServiceImpl extends BaseService implements SprayService {


    @Autowired
    private SprayMapper sprayMapper;

    @Autowired
    private SprayItemMapper sprayItemMapper;
    @Autowired
    private SparyExtendMapper sparyExtendMapper;

    @Autowired
    private SprayInspectHistoryMapper inspectHistoryMapper;

    @Autowired
    private ValidateService validateService;
    @Autowired
    private CheckMaterialLockService checkMaterialLockService;
    @Resource
    private PayOrderUserRelationProcedureMapper payOrderUserRelationProcedureMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultBean save(SprayDto sprayDto) {
        if (sprayDto.getItems().isEmpty()) {
            return ResultBean.error(ResponseEnum.PARAM_ERROR);
        }
        for (int i = 0; i < sprayDto.getItems().size(); i++) {
            validateService.validateIsExistMaterialGraphNo(sprayDto.getItems().get(i).getMaterialGraphNo());
            validateService.validIsEmpty(sprayDto.getItems().get(i).getBatchNumber());
        }
        String sprayNo = createSerialNumber(SPRAY_NO_PREFIX_PT, SPRAY_NO_KEY);
        Spray spray = new Spray();
        spray.setSprayNo(sprayNo);
        spray.setPlanner(sprayDto.getPlanner());
        spray.setTotalNumber(0);
        spray.setBusType(sprayDto.getBusType());
        int sum = sprayDto.getItems().stream().mapToInt(SprayItemDto::getNumber).sum();
        spray.setTotalNumber(sum);
        sprayMapper.insertSelective(spray);
        sprayDto.getItems().forEach(sprayItemDto -> {
            SprayItem sprayItem = new SprayItem();
            BeanUtils.copyProperties(sprayItemDto, sprayItem);
            sprayItem.setSprayNo(sprayNo);
            sprayItem.setOutRoomStatus(CommonEnum.OutRoomStatus.NOT_OUT.type);
            sprayItemMapper.insertSelective(sprayItem);
        });
        return ResultBean.success(sprayNo);
    }

    @Async("threadPoolTaskExecutor")
    public void createSprayFormFile(SprayDto sprayDto) {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("喷涂委托单");
//    QiniuUtil.uploadFile();

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultBean delete(String sprayNo) {
        SprayExample sprayExample = new SprayExample();
        sprayExample.createCriteria().andSprayNoEqualTo(sprayNo);
        sprayMapper.deleteByExample(sprayExample);
        SprayItemExample itemExample = new SprayItemExample();
        itemExample.createCriteria().andSprayNoEqualTo(sprayNo);
        sprayItemMapper.deleteByExample(itemExample);
        return ResultBean.success(1);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultBean update(SprayDto sprayDto) {
        SprayItemExample itemExample = new SprayItemExample();
        itemExample.createCriteria().andSprayNoEqualTo(sprayDto.getSprayNo());
        Spray spray = new Spray();
        spray.setPlanner(sprayDto.getPlanner());
        SprayExample example = new SprayExample();
        example.createCriteria().andSprayNoEqualTo(sprayDto.getSprayNo());
        sprayItemMapper.deleteByExample(itemExample);
        spray.setTotalNumber(0);
        sprayDto.getItems().forEach(sprayItemDto -> {
            SprayItem sprayItem = new SprayItem();
            BeanUtils.copyProperties(sprayItemDto, sprayItem);
            sprayItem.setSprayNo(sprayDto.getSprayNo());
            spray.setTotalNumber(spray.getTotalNumber() + sprayItemDto.getNumber());
            sprayItemMapper.insertSelective(sprayItem);
        });
        sprayMapper.updateByExampleSelective(spray, example);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean getSprayInfo(String sprayNo) {
        SprayExample sprayExample = new SprayExample();
        sprayExample.createCriteria().andSprayNoEqualTo(sprayNo);
        Spray spray = sprayMapper.selectByExample(sprayExample).get(0);
        SprayDto sprayDto = new SprayDto();
        BeanUtils.copyProperties(spray, sprayDto);
        SprayItemExample itemExample = new SprayItemExample();
        itemExample.createCriteria().andSprayNoEqualTo(spray.getSprayNo());
        List<SprayItem> sprayItems = sprayItemMapper.selectByExample(itemExample);
        List<SprayItemDto> sprayItemDtos = new ArrayList<>();
        sprayItems.forEach(sprayItem -> {
            SprayItemDto sprayItemDto = new SprayItemDto();
            BeanUtils.copyProperties(sprayItem, sprayItemDto);
            sprayItemDtos.add(sprayItemDto);
        });
        sprayDto.setItems(sprayItemDtos);
        return ResultBean.success(sprayDto);
    }

    @Override
    public ResultBean forms(SprayListDto listDto) {
        SprayExample example = new SprayExample();
        SprayExample.Criteria criteria = example.createCriteria();
        if (listDto.getStatus() != -1) {
            criteria.andStatusEqualTo(listDto.getStatus().byteValue());
        }
        // 计划管理 type=0

        // 质检管理 type =1 status in (加工中，质检完成， 加工完成)
        if (listDto.getType() == 1) {
            criteria.andStatusIn(Arrays.asList((byte) 1, (byte) 2, (byte) 3));
        }
        if (StringUtils.isNotEmpty(listDto.getSprayNo())) {
            criteria.andSprayNoLike("%" + listDto.getSprayNo() + "%");
        }
        Page<Spray> sprayList = PageHelper.startPage(listDto.getPageNum(), listDto.getPageSize(), "id desc")
            .doSelectPage(() -> sprayMapper.selectByExample(example));
        List<Spray> result = sprayList.getResult();
        List<SprayVo> resultList = new ArrayList<>();

        if (!CollectionUtils.isEmpty(result)) {
            for (Spray spray : result) {
                String sprayNo = spray.getSprayNo();
                SprayItemExample sprayItemExample = new SprayItemExample();
                sprayItemExample.or().andSprayNoEqualTo(sprayNo);
                List<SprayItem> sprayItems = sprayItemMapper.selectByExample(sprayItemExample);
                SprayItem sprayItem = CollectionUtils.isEmpty(sprayItems) ? new SprayItem() : sprayItems.get(0);
                String originGraphNo = sprayItem.getMaterialGraphNo();
                String sprayedGraphNo = sprayItem.getSprayedGraphNo();
                String batchNumber = sprayItem.getBatchNumber();
                SprayVo sprayVo = new SprayVo();
                BeanUtils.copyProperties(spray, sprayVo);
                sprayVo.setOrignGraphNo(originGraphNo);
                sprayVo.setSprayedGraphNo(sprayedGraphNo);
                sprayVo.setBatchNumber(batchNumber);
                sprayVo.setOutRoomStatus(sprayItem.getOutRoomStatus());
                resultList.add(sprayVo);
            }
        }

        PageDTO<SprayVo> sprayPageDTOs = new PageDTO<>();
        BeanUtils.copyProperties(sprayList, sprayPageDTOs);
        sprayPageDTOs.setList(resultList);
        return ResultBean.success(sprayPageDTOs);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultBean updateStatus(String sprayNo, int status) {
        SprayExample example = new SprayExample();
        SprayExample.Criteria criteria = example.createCriteria();
        criteria.andSprayNoEqualTo(sprayNo);
        Spray spray = new Spray();
        if (status == SPRAY_MACHINE.code) {
            spray.setInspectStatus(handling.code);
        }
        spray.setStatus(Integer.valueOf(status).byteValue());
        sprayMapper.updateByExampleSelective(spray, example);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean getInspectList(String sprayNo) {
        SprayInspectHistoryExample inspectHistoryExample = new SprayInspectHistoryExample();
        inspectHistoryExample.createCriteria().andSprayNoEqualTo(sprayNo);
        List<SprayInspectHistory> inspectHistories = inspectHistoryMapper.selectByExample(inspectHistoryExample);
        List<SprayInspectHistoryDto> sprayInspectHistoryDtos = new ArrayList<>(inspectHistories.size());
        for (SprayInspectHistory history : inspectHistories) {
            SprayInspectHistoryDto dto = new SprayInspectHistoryDto();
            BeanUtils.copyProperties(history, dto);
            if (StringUtils.isNotEmpty(history.getAccessory())) {
                dto.setAccessoryList(JSON.parseArray(history.getAccessory(), Accessory.class));
            }
            if (StringUtils.isNotEmpty(history.getReasons())) {
                dto.setReasonList(JSON.parseArray(history.getReasons(), InspectReason.class));
            } else if (history.getUnqualifiedNumber() > 0) {
                dto.setReasonList(Arrays.asList(new InspectReason(history.getRemark(), history.getUnqualifiedNumber())));
            } else {
                dto.setReasonList(Collections.emptyList());
            }
            sprayInspectHistoryDtos.add(dto);
        }
        return ResultBean.success(sprayInspectHistoryDtos);
    }

    @Override
    public ResultBean getItemsList(String sprayNo) {
        SprayItemExample itemExample = new SprayItemExample();
        itemExample.createCriteria().andSprayNoEqualTo(sprayNo);
        List<SprayItem> sprayItems = sprayItemMapper.selectByExample(itemExample);
        return ResultBean.success(sprayItems);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultBean saveInspect(SprayInspectDto inspectDto) {

        SprayExample example = new SprayExample();
        example.createCriteria().andSprayNoEqualTo(inspectDto.getSprayNo());
        List<Spray> sprays = sprayMapper.selectByExample(example);
        if (sprays != null && sprays.size() > 0) {
            Spray sss = sprays.get(0);
            PayOrderUserRelationProcedureExample payExample = new PayOrderUserRelationProcedureExample();
            payExample.createCriteria().andOrderIdEqualTo(inspectDto.getSprayNo());
            List<PayOrderUserRelationProcedure> payOrderUserRelationProcedureList = payOrderUserRelationProcedureMapper.selectByExample(payExample);
            if (org.apache.commons.collections4.CollectionUtils.isEmpty(payOrderUserRelationProcedureList) && DateUtils.checkTimeMoreThan26(sss.getCreateTime())) {
                return ResultBean.error(CommonEnum.ResponseEnum.ORDER_NOT_ASSIGN_TASK);
            }
        }

        if (inspectDto.getTestNumber() == 0) {
            return ResultBean.error(ResponseEnum.INSPECT_TESTNUMBER_IS_ZERO);
        }
        // 不合格原因
        SprayInspectHistory history = new SprayInspectHistory();
        BeanUtils.copyProperties(inspectDto, history);
        if (CollectionUtil.isNotEmpty(inspectDto.getReasonList())) {
            int unqualifiedNum = inspectDto.getReasonList().stream().map(InspectReason::getNumber).reduce(0, Integer::sum);
            inspectDto.setUnqualifiedNumber(unqualifiedNum);
            history.setUnqualifiedNumber(unqualifiedNum);
            history.setReasons(JSON.toJSONString(inspectDto.getReasonList()));
        } else {
            inspectDto.setUnqualifiedNumber(0);
            history.setUnqualifiedNumber(0);
        }

        if (inspectDto.getQualifiedNumber() + inspectDto.getUnqualifiedNumber() != inspectDto.getTestNumber()) {
            return ResultBean.error(ResponseEnum.INSPECT_RECORD_DATA_ERROR);
        }


        // 质检附件
        if (!CollectionUtils.isEmpty(inspectDto.getAccessoryList())) {
            history.setAccessory(JSON.toJSONString(inspectDto.getAccessoryList()));
        }
        inspectHistoryMapper.insertSelective(history);
        if (sprays != null && sprays.size() > 0) {
            Spray spray = sprays.get(0);
            spray.setQualifiedNumber(spray.getQualifiedNumber() + inspectDto.getQualifiedNumber());
            if (spray.getTotalNumber() < spray.getQualifiedNumber()) {
                throw new BaseException(ResponseEnum.SPRAY_QUALIFIED_NUMBER_ERROR);
            }
            // 如果喷涂质检合格数量+不合格数量等于总数，则加工完成
            SprayInspectHistoryExample historyExample = new SprayInspectHistoryExample();
            historyExample.createCriteria().andSprayNoEqualTo(inspectDto.getSprayNo());
            List<SprayInspectHistory> sprayInspectHistorys = inspectHistoryMapper.selectByExample(historyExample);
            int qualifiedSum = sprayInspectHistorys.stream().mapToInt(SprayInspectHistory::getQualifiedNumber).sum();
            int unQualifiedSum = sprayInspectHistorys.stream().mapToInt(SprayInspectHistory::getUnqualifiedNumber).sum();
            if (qualifiedSum + unQualifiedSum >= spray.getTotalNumber()) {
                spray.setInspectStatus(CommonEnum.Inspect2Status.handled.code);
            }
            sprayMapper.updateByExampleSelective(spray, example);
        }
        return ResultBean.success(history.getId());
    }

    @Override
    public ResultBean getInspectToRooms(SprayInspectListDto inspectListDto) {
        SprayInspectHistoryExample historyExample = new SprayInspectHistoryExample();
        SprayInspectHistoryExample.Criteria criteria = historyExample.createCriteria();
        if (StringUtils.isNotEmpty(inspectListDto.getSprayNo())) {
            criteria.andSprayNoLike("%" + inspectListDto.getSprayNo() + "%");
        }
        // 0 全部
        if (inspectListDto.getStatus() != 0) {
            criteria.andStatusEqualTo(inspectListDto.getStatus().byteValue());
        }
        criteria.andQualifiedNumberGreaterThan(0);
        Page<SprayInspectHistory> page = PageHelper
            .startPage(inspectListDto.getPageNum(), inspectListDto.getPageSize(), "id desc")
            .doSelectPage(() -> inspectHistoryMapper.selectByExample(historyExample));

        List<SprayInspectHistoryVo> resultList = new ArrayList<>();
        // 将批次号返回，从spray_item 表中获取，根据spray_no 和 图号
        List<SprayInspectHistory> result = page.getResult();
        if (!CollectionUtils.isEmpty(result)) {
            for (SprayInspectHistory sprayInspectHistory : result) {
                String materialGraphNo = sprayInspectHistory.getOriginalGraphNo();
                String sprayNo = sprayInspectHistory.getSprayNo();
                SprayItemExample sprayItemExample = new SprayItemExample();
                sprayItemExample.or().andSprayNoEqualTo(sprayNo).andMaterialGraphNoEqualTo(materialGraphNo);
                List<SprayItem> sprayItems = sprayItemMapper.selectByExample(sprayItemExample);
                String batchNo = CollectionUtils.isEmpty(sprayItems) ? "" : sprayItems.get(0).getBatchNumber();
                SprayInspectHistoryVo inspectHistoryVo = new SprayInspectHistoryVo();
                BeanUtils.copyProperties(sprayInspectHistory, inspectHistoryVo);
                inspectHistoryVo.setBatchNumber(batchNo);

                // 从spray 获取busType字段
                SprayExample sprayExample = new SprayExample();
                sprayExample.or().andSprayNoEqualTo(sprayNo);
                List<Spray> sprays = sprayMapper.selectByExample(sprayExample);
                Byte busType = CollectionUtils.isEmpty(sprays) ? (byte) 0 : sprays.get(0).getBusType();
                inspectHistoryVo.setBusType(busType);

                resultList.add(inspectHistoryVo);
            }
        }

        PageDTO<SprayInspectHistoryVo> sprayInspectHistoryPageDTO = new PageDTO<>();
        BeanUtils.copyProperties(page, sprayInspectHistoryPageDTO);
        sprayInspectHistoryPageDTO.setList(resultList);
        return ResultBean.success(sprayInspectHistoryPageDTO);
    }

    @Override
    public ResultBean updateHistoryStatus(Integer historyId) {
        SprayInspectHistory sprayInspectHistory = new SprayInspectHistory();
        sprayInspectHistory.setId(historyId);
        // 2 已入库
        sprayInspectHistory.setStatus((byte) 2);
        int update = inspectHistoryMapper.updateByPrimaryKeySelective(sprayInspectHistory);
        if (update > 0) {
            // 入库成功,释放锁定的料
            SprayInspectHistory historyInfo = this.getHistoryInfo(historyId);
            if (historyInfo != null) {
                CheckMaterialLockDTO checkMaterialLockDTO = new CheckMaterialLockDTO();
                checkMaterialLockDTO.setType(CommonEnum.CheckMaterialLockType.SPRAY.type);
                checkMaterialLockDTO.setMaterialGraphNo(historyInfo.getMaterialGraphNo());
                checkMaterialLockDTO.setLockQuantity(historyInfo.getQualifiedNumber());
                checkMaterialLockService.updateLockQuantity(checkMaterialLockDTO);
            }
        }
        return ResultBean.success(1);
    }

    @Override
    public ResultBean updateInspectStatus(String sprayNo, int status) {
        // 点击质检完成的时候，判断是否提交了检验记录，不能点击
        if (status == CommonEnum.Inspect2Status.handled.code) {
            SprayInspectHistoryExample example = new SprayInspectHistoryExample();
            example.or().andSprayNoEqualTo(sprayNo);
            int count = inspectHistoryMapper.countByExample(example);
            if (count == 0) {
                throw new BaseException(ResponseEnum.ADD_INSPECT_RECORD);
            }
        }

        SprayExample example = new SprayExample();
        SprayExample.Criteria criteria = example.createCriteria();
        criteria.andSprayNoEqualTo(sprayNo);
        Spray spray = new Spray();
        spray.setInspectStatus(Integer.valueOf(status).byteValue());
        sprayMapper.updateByExampleSelective(spray, example);
        return ResultBean.success(1);
    }

    @Override
    public int obtainNumber(String materialGraphNo) {
        int number = 0;
        if (StringUtils.isBlank(materialGraphNo)) {
            return number;
        }
        // 根据查出状态为 加工中和暂停加工的spray
        SprayExample example = new SprayExample();
        example.or().andBusTypeEqualTo(CommonEnum.BusType.PRODUCT_INVENTORY.type)
            .andStatusIn(Arrays.asList(CommonEnum.SprayStatus.SPRAY_MACHINE.code, CommonEnum.SprayStatus.SPRAY_STOP_MACHINE.code));
        List<Spray> sprays = sprayMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(sprays)) {
            List<String> sprayNoList = sprays.stream().map(Spray::getSprayNo).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(sprayNoList)) {
                // 根据喷涂号，图号 查出 这个图号喷涂的总数量
                SprayItemExample sprayItemExample = new SprayItemExample();
                sprayItemExample.or().andMaterialGraphNoEqualTo(materialGraphNo).andSprayNoIn(sprayNoList);
                List<SprayItem> sprayItemList = sprayItemMapper.selectByExample(sprayItemExample);
                if (!CollectionUtils.isEmpty(sprayItemList)) {
                    // 获取正在机加工的总数量
                    number = sprayItemList.stream().map(SprayItem::getNumber).reduce(0, (a, b) -> a + b);
                    log.info("obtainNumber 1 materialGraphNo:{},number:{}", materialGraphNo, number);
                    if (number > 0) {
                        // 获取 喷涂历史记录的合格数量
                        SprayInspectHistoryExample sprayInspectHistoryExample = new SprayInspectHistoryExample();
                        sprayInspectHistoryExample.or().andSprayNoIn(sprayNoList).andOriginalGraphNoEqualTo(materialGraphNo).andStatusEqualTo(CommonEnum.InspectHistoryStatus.BEEN_STORE_2.code);
                        List<SprayInspectHistory> sprayInspectHistories = inspectHistoryMapper.selectByExample(sprayInspectHistoryExample);
                        // 已经入库的数量
                        Integer storeCount = Optional.of(sprayInspectHistories).orElse(new ArrayList<>()).stream().map(SprayInspectHistory::getQualifiedNumber).reduce(0, (a, b) -> a + b);
                        log.info("obtainNumber 2 materialGraphNo:{},storeCount:{}", materialGraphNo, storeCount);
                        // 正在喷涂的数据，需要减去已经入库的数量
                        number = number - storeCount;
                        if (number > 0) {
                            // 获取已经核料锁定的数量
                            List<CheckMaterialLock> checkMaterialLocks = checkMaterialLockService.findByMaterialAndType(materialGraphNo, CommonEnum.CheckMaterialLockType.SPRAY.type);
                            if (!CollectionUtils.isEmpty(checkMaterialLocks)) {
                                Integer lockCount = checkMaterialLocks.stream().map(CheckMaterialLock::getLockQuantity).reduce(0, (a, b) -> a + b);
                                log.info("obtainNumber 3 materialGraphNo:{},lockCount:{}", materialGraphNo, lockCount);
                                number = number - lockCount;
                            }
                        }
                    }
                }
            }
        }
        if (number < 0) {
            log.info("obtainNumber 4 materialGraphNo:{},number:{}", materialGraphNo, number);
            number = 0;
        }
        return number;
    }

    @Override
    public SprayInspectHistory getHistoryInfo(Integer historyId) {
        return inspectHistoryMapper.selectByPrimaryKey(historyId);
    }

    @Override
    public List<SprayInspectHistory> getSprayInspectHistoryList(PayCalculateDTO payCalculateDTO) {
        SprayInspectHistoryExample inspectHistoryExample = new SprayInspectHistoryExample();
        SprayInspectHistoryExample.Criteria criteria = inspectHistoryExample.createCriteria();
        if (StringUtils.isNotBlank(payCalculateDTO.getOrderNo())) {
            criteria.andSprayNoEqualTo(payCalculateDTO.getOrderNo());
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
        List<SprayInspectHistory> inspectHistories = inspectHistoryMapper.selectByExample(inspectHistoryExample);
        return inspectHistories;
    }

    @Override
    public void updateTaskStatus(String sprayNo, int taskStatus) {
        SprayExample example = new SprayExample();
        SprayExample.Criteria criteria = example.createCriteria();
        criteria.andSprayNoEqualTo(sprayNo);
        Spray spray = new Spray();
        spray.setTaskStatus(Integer.valueOf(taskStatus).byteValue());
        sprayMapper.updateByExampleSelective(spray, example);
    }
}
