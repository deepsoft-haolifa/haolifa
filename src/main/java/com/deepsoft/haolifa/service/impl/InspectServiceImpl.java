package com.deepsoft.haolifa.service.impl;

import static com.deepsoft.haolifa.constant.CacheKey.BATCH_NUM_KEY;
import static com.deepsoft.haolifa.constant.CacheKey.INSPECT_NO_KEY;
import static com.deepsoft.haolifa.constant.CommonEnum.InspectMaterialType.ENTRUST_MATERIAL_TYPE_2;
import static com.deepsoft.haolifa.constant.CommonEnum.InspectMaterialType.PURCHASE_MATERIAL_TYPE_1;
import static com.deepsoft.haolifa.constant.CommonEnum.ResponseEnum.MATERIAL_REPORT_IS_NULL;
import static com.deepsoft.haolifa.constant.CommonEnum.ResponseEnum.PURCHASE_PRO_INSPECT_NUM_ERROR;
import static com.deepsoft.haolifa.constant.Constant.SerialNumberPrefix.BATCH_NUMBER_PREFIX_PC;
import static com.deepsoft.haolifa.constant.Constant.SerialNumberPrefix.INSPECT_NO_PREFIX_BJ;

import com.alibaba.fastjson.JSON;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.constant.CommonEnum.InspectHistoryStatus;
import com.deepsoft.haolifa.constant.CommonEnum.InspectStatus;
import com.deepsoft.haolifa.constant.CommonEnum.ResponseEnum;
import com.deepsoft.haolifa.dao.repository.*;
import com.deepsoft.haolifa.dao.repository.extend.CommonExtendMapper;
import com.deepsoft.haolifa.model.domain.PurchaseOrderItem;
import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.order.CheckMaterialLockDTO;
import com.deepsoft.haolifa.model.vo.InspectHistoryVo;
import com.deepsoft.haolifa.model.vo.SprayInspectHistoryVo;
import com.deepsoft.haolifa.service.CheckMaterialLockService;
import com.deepsoft.haolifa.service.InspectService;
import com.deepsoft.haolifa.util.DateFormatterUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import java.math.BigDecimal;
import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Slf4j
@Service
public class InspectServiceImpl extends BaseService implements InspectService {

    @Autowired
    InspectMapper inspectMapper;
    @Autowired
    InspectItemMapper inspectItemMapper;
    @Autowired
    InspectHistoryMapper historyMapper;
    @Autowired
    EntrustMapper entrustMapper;
    @Autowired
    PurchaseOrderMapper purchaseOrderMapper;
    @Autowired
    PurchaseOrderItemMapper purchaseOrderItemMapper;
    @Autowired
    CheckMaterialLockService checkMaterialLockService;
    @Autowired
    CommonExtendMapper commonExtendMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultBean save(InspectDTO model) {
        int createUserId = getLoginUserId();
        String inspectNo = createSerialNumber(INSPECT_NO_PREFIX_BJ, INSPECT_NO_KEY);
        String batchNumer = createSerialNumber(BATCH_NUMBER_PREFIX_PC, BATCH_NUM_KEY);
        Inspect inspect = new Inspect();
        BeanUtils.copyProperties(model, inspect);
        inspect.setBlueprints(model.getAccessorys() == null || model.getAccessorys().size() == 0 ? ""
            : JSON.toJSONString(model.getAccessorys()));
        inspect.setCreateUserId(createUserId);
        inspect.setInspectNo(inspectNo);
        inspect.setBatchNumber(batchNumer);
        inspect.setStatus(model.getStatus().byteValue());
        if (model.getStatus() == 2 && (model.getAccessorys() == null || model.getAccessorys().size() == 0)) {
            return new ResultBean(MATERIAL_REPORT_IS_NULL);
        }
        if (StringUtils.isNotEmpty(model.getArrivalTime())) {
            inspect.setArrivalTime(
                DateFormatterUtils.parseDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, model.getArrivalTime()));
        }
        inspectMapper.insertSelective(inspect);
        List<InspectItemDTO> items = model.getItems();
        int totalCount = 0;
        if (items != null && items.size() > 0) {
            for (int i = 0; i < items.size(); i++) {
                InspectItemDTO inspectItemDTO = items.get(i);
                //判断送检数不能大于合同数
                judgeDeliveryCount(inspectItemDTO);

                InspectItem inspectItem = new InspectItem();
                BeanUtils.copyProperties(inspectItemDTO, inspectItem);
                inspectItem.setInspectId(inspect.getId());
                inspectItem.setInspectNo(inspect.getInspectNo());
                inspectItem.setPurchasePrice(new BigDecimal(inspectItemDTO.getPurchasePrice()));
                inspectItem.setPurchaseNo(model.getPurchaseNo());
                inspectItemMapper.insertSelective(inspectItem);
                totalCount += inspectItemDTO.getDeliveryNumber();
            }
            Inspect inspectCount = new Inspect();
            inspectCount.setId(inspect.getId());
            inspectCount.setTotalCount(totalCount);
            inspectMapper.updateByPrimaryKeySelective(inspectCount);
        }
        return ResultBean.success(inspect.getId());
    }


    @Override
    public ResultBean getInfo(int inspectId) {
        Inspect inspect = inspectMapper.selectByPrimaryKey(inspectId);
        InspectItemExample example = new InspectItemExample();
        example.or().andInspectIdEqualTo(inspectId);
        List<InspectItem> items = inspectItemMapper.selectByExample(example);
        Map<String, Object> result = new HashMap<>(2);
        result.put("inspect", inspect);
        result.put("items", items);
        return ResultBean.success(result);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultBean delete(Integer inspectId) {
        inspectMapper.deleteByPrimaryKey(inspectId);
        InspectItemExample inspectItemExample = new InspectItemExample();
        inspectItemExample.or().andInspectIdEqualTo(inspectId);
        inspectItemMapper.deleteByExample(inspectItemExample);
        return ResultBean.success(1);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultBean update(int inspectId, InspectDTO model) {
        if (model.getStatus() == 2 && (model.getAccessorys() == null || model.getAccessorys().size() == 0)) {
            return new ResultBean(MATERIAL_REPORT_IS_NULL);
        }
        Inspect inspectInfo = inspectMapper.selectByPrimaryKey(inspectId);
        Inspect inspect = new Inspect();
        inspect.setId(inspectId);
        inspect.setSupplierName(model.getSupplierName());
        if (StringUtils.isNotEmpty(model.getArrivalTime())) {
            Date arrivalTime = DateFormatterUtils
                .parseDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, model.getArrivalTime());
            inspect.setArrivalTime(arrivalTime);
        }
        inspect.setBatchNumber(model.getBatchNumber());
        inspect.setBlueprints(model.getAccessorys() == null || model.getAccessorys().size() == 0 ? ""
            : JSON.toJSONString(model.getAccessorys()));
        inspectMapper.updateByPrimaryKeySelective(inspect);
        InspectItemExample itemExample = new InspectItemExample();
        itemExample.or().andInspectIdEqualTo(inspect.getId());
        inspectItemMapper.deleteByExample(itemExample);
        List<InspectItemDTO> items = model.getItems();
        int totalCount = 0;
        if (items != null && items.size() > 0) {
            for (int i = 0; i < items.size(); i++) {
                InspectItemDTO inspectItemDTO = items.get(i);
                // 判断送检数不能大于合同数
                judgeDeliveryCount(inspectItemDTO);
                Integer deliveryNumber = inspectItemDTO.getDeliveryNumber();

                InspectItem inspectItem = new InspectItem();
                BeanUtils.copyProperties(inspectItemDTO, inspectItem);
                inspectItem.setPurchasePrice(new BigDecimal(inspectItemDTO.getPurchasePrice()));
                inspectItem.setInspectId(inspect.getId());
                inspectItem.setInspectNo(inspectInfo.getInspectNo());
                inspectItemMapper.insertSelective(inspectItem);
                totalCount += deliveryNumber;
            }
            Inspect inspectCount = new Inspect();
            inspectCount.setId(inspect.getId());
            inspectCount.setTotalCount(totalCount);
            inspectMapper.updateByPrimaryKeySelective(inspectCount);
        }
        return ResultBean.success(1);
    }

    private void judgeDeliveryCount(InspectItemDTO inspectItemDTO) {
        // 判断 送检数不能大于采购数
        Integer deliveryNumber = inspectItemDTO.getDeliveryNumber();
        // 获取这个合同，这个图号已经送检的数量,不合格数
        InspectItemSumDto inspectItemSumDto = commonExtendMapper.sumDeliveryInspectItem(inspectItemDTO.getPurchaseNo(), inspectItemDTO.getMaterialGraphNo());
        // 获取这个合同，这个图号的采购数量（先从送检单中填写的那个获取，再从采购合同表中获取）
        Integer purchaseNumber = 0;
        PurchaseOrderItemExample example = new PurchaseOrderItemExample();
        example.or().andPurchaseOrderNoEqualTo(inspectItemDTO.getPurchaseNo()).andMaterialGraphNoEqualTo(inspectItemDTO.getMaterialGraphNo());
        List<PurchaseOrderItem> purchaseOrderItems = purchaseOrderItemMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(purchaseOrderItems)) {
            purchaseNumber = purchaseOrderItems.get(0).getNumber();
        }
        // 此次送检数+历史送检数-不合格数 不能大于合同的采购数
        if (deliveryNumber + inspectItemSumDto.getDeliveryNumber() - inspectItemSumDto.getUnqualifiedNumber() > purchaseNumber) {
            throw new BaseException(ResponseEnum.DELIVERY_COUNT_LESS_THAN_PURCHASE_COUNT, (Object) inspectItemDTO.getMaterialGraphNo());
        }
    }

    @Override
    public ResultBean updateItem(int itemId, InspectItemUpdateDTO model) {
        InspectItem inspectItem = new InspectItem();
        BeanUtils.copyProperties(model, inspectItem);
        inspectItem.setId(itemId);
        inspectItemMapper.updateByPrimaryKeySelective(inspectItem);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean getList(int type, int pageNum, int pageSize, String inspectNo, String purchaseOrderNo, String supplierName, String batchNumber, Byte status) {
        InspectExample example = new InspectExample();
        InspectExample.Criteria criteria = example.createCriteria();
//    if (type == 0) {
//      criteria.andCreateUserIdEqualTo(getLoginUserId());
//    }
        if (type == 1) {
            criteria.andStatusNotIn(Arrays.asList(InspectStatus.SAVE.code));
        }
        if (type == 2) {
            criteria.andStatusIn(Arrays.asList(InspectStatus.STOCK_PENDING.code, InspectStatus.STOCKED.code));
        }
        if (status > 0) {
            criteria.andStatusEqualTo(status);
        }
        if (StringUtils.isNotEmpty(purchaseOrderNo)) {
            criteria.andPurchaseNoLike("%" + purchaseOrderNo + "%");
        }
        if (StringUtils.isNotEmpty(batchNumber)) {
            criteria.andBatchNumberLike("%" + batchNumber + "%");
        }
        if (StringUtils.isNotEmpty(inspectNo)) {
            criteria.andInspectNoLike("%" + inspectNo + "%");
        }
        if (StringUtils.isNotEmpty(supplierName)) {
            criteria.andSupplierNameLike("%" + supplierName + "%");
        }
        Page pageData = PageHelper.startPage(pageNum, pageSize, "create_time desc")
            .doSelectPage(() -> inspectMapper.selectByExample(example));
        PageDTO pageDTO = new PageDTO();
        BeanUtils.copyProperties(pageData, pageDTO);
        pageDTO.setList(pageData.getResult());
        return ResultBean.success(pageDTO);
    }

    @Override
    public ResultBean deleteItem(int itemId) {
        inspectItemMapper.deleteByPrimaryKey(itemId);
        return ResultBean.success(1);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultBean updateStatus(Integer inspectId, Integer status) {
        Inspect inspect = new Inspect();
        inspect.setId(inspectId);
        inspect.setStatus(status.byteValue());
        Inspect inspect1 = inspectMapper.selectByPrimaryKey(inspectId);
        if (status == 2 && inspect1.getBlueprints().length() == 0) {
            return new ResultBean(MATERIAL_REPORT_IS_NULL);
        }
        inspectMapper.updateByPrimaryKeySelective(inspect);
        if (status == 2 || status == 3) {
            // 更新单项合格与不合格数量
            InspectHistoryExample historyExample = new InspectHistoryExample();
            historyExample.or().andInspectNoEqualTo(inspect1.getInspectNo());
            List<InspectHistory> histories = historyMapper.selectByExample(historyExample);
            Map<String, InspectItem> updateItem = new HashMap<>();
            for (int i = 0; i < histories.size(); i++) {
                InspectHistory history = histories.get(i);
                if (updateItem.containsKey(history.getMaterialGraphNo())) {
                    InspectItem item = updateItem.get(history.getMaterialGraphNo());
                    item.setUnqualifiedNumber(item.getUnqualifiedNumber() + history.getUnqualifiedNumber());
                    updateItem.put(history.getMaterialGraphNo(), item);
                } else {
                    InspectItem item = new InspectItem();
                    item.setUnqualifiedNumber(history.getUnqualifiedNumber());
                    updateItem.put(history.getMaterialGraphNo(), item);
                }
            }
            for (Entry en : updateItem.entrySet()) {
                InspectItemExample itemExample = new InspectItemExample();
                itemExample.or().andInspectIdEqualTo(inspectId).andMaterialGraphNoEqualTo(en.getKey().toString());
                inspectItemMapper.updateByExampleSelective((InspectItem) en.getValue(), itemExample);
            }
        }
        return ResultBean.success(1);
    }

    @Override
    public ResultBean inspectRes(int itemId, InspectResDTO model) {
        InspectItem inspectItem = new InspectItem();
        inspectItem.setId(itemId);
        inspectItem.setQualifiedNumber(model.getQualifiedNumber());
        inspectItem.setUnqualifiedNumber(model.getUnqualifiedNumber());
        inspectItemMapper.updateByPrimaryKeySelective(inspectItem);
        return ResultBean.success(1);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultBean historySave(InspectHistoryDto model) {
        if (model.getTestNumber() == 0) {
            return ResultBean.error(ResponseEnum.INSPECT_TESTNUMBER_IS_ZERO);
        }
        // 计算不合格数
        boolean isEmpty = CollectionUtils.isEmpty(model.getReasonList());
        if (!isEmpty) {
            int unqualifiedNum = model.getReasonList().stream().map(InspectReason::getNumber).reduce(0, (a, b) -> a + b);
            model.setUnqualifiedNumber(unqualifiedNum);
            model.setReasons(JSON.toJSONString(model.getReasonList()));
        } else {
            model.setUnqualifiedNumber(0);
        }
        if (model.getQualifiedNumber() + model.getUnqualifiedNumber() != model.getTestNumber()) {
            return ResultBean.error(ResponseEnum.INSPECT_RECORD_DATA_ERROR);
        }
        if (!CollectionUtils.isEmpty(model.getAccessoryList())) {
            model.setAccessory(JSON.toJSONString(model.getAccessoryList()));
        }
        InspectHistory inspectHistory = new InspectHistory();
        BeanUtils.copyProperties(model, inspectHistory);
        historyMapper.insertSelective(inspectHistory);
        String inspectNo = model.getInspectNo();
        if (model.getType() == PURCHASE_MATERIAL_TYPE_1.getCode()) {
            // 采购零件 质检
            InspectExample example = new InspectExample();
            example.createCriteria().andInspectNoEqualTo(inspectNo);
            List<Inspect> inspectList = inspectMapper.selectByExample(example);
            if (!CollectionUtils.isEmpty(inspectList) && inspectList.size() > 0) {
                // 更新采购零件送检 inspect 表
                Inspect inspectRecord = inspectList.get(0);
                Inspect updateInspect = new Inspect();
                updateInspect.setQualifiedNumber(inspectRecord.getQualifiedNumber() + model.getQualifiedNumber());
                updateInspect.setUnqualifiedNumber(inspectRecord.getUnqualifiedNumber() + model.getUnqualifiedNumber());
                if (inspectRecord.getTotalCount() < updateInspect.getQualifiedNumber()) {
                    throw new BaseException(ResponseEnum.INSPECT_QUALIFIED_NUMBER_ERROR);
                }
                inspectMapper.updateByExampleSelective(updateInspect, example);
                // 更新采购零件送检子表 inspect_item 表
                InspectItemExample inspectItemExample = new InspectItemExample();
                inspectItemExample.or().andInspectNoEqualTo(inspectNo).andMaterialGraphNoEqualTo(model.getMaterialGraphNo());
                List<InspectItem> inspectItems = inspectItemMapper.selectByExample(inspectItemExample);
                if (!CollectionUtils.isEmpty(inspectItems)) {
                    InspectItem inspectItem = inspectItems.get(0);
                    InspectItem updateInspectItem = new InspectItem();
                    updateInspectItem.setQualifiedNumber(inspectItem.getQualifiedNumber() + model.getQualifiedNumber());
                    updateInspectItem.setUnqualifiedNumber(inspectItem.getUnqualifiedNumber() + model.getUnqualifiedNumber());
                    inspectItemMapper.updateByExampleSelective(updateInspectItem, inspectItemExample);
                }

                // 更新采购合同表
                PurchaseOrderExample orderExample = new PurchaseOrderExample();
                orderExample.createCriteria().andPurchaseOrderNoEqualTo(inspectRecord.getPurchaseNo());
                List<PurchaseOrder> purchaseOrders = purchaseOrderMapper.selectByExample(orderExample);
                if (!CollectionUtils.isEmpty(purchaseOrders)) {
                    PurchaseOrder purchaseOrder = purchaseOrders.get(0);
                    PurchaseOrder order = new PurchaseOrder();
                    order.setQualifiedNumber(purchaseOrder.getQualifiedNumber() + model.getQualifiedNumber());
                    if (purchaseOrder.getTotalCount() < order.getQualifiedNumber()) {
                        throw new BaseException(PURCHASE_PRO_INSPECT_NUM_ERROR);
                    }
                    // 当合同检验合格数等于合同数自动更新采购合同为“完成”状态
                    if (purchaseOrder.getTotalCount().equals(order.getQualifiedNumber())) {
                        order.setStatus((byte) 5);
                    }
                    purchaseOrderMapper.updateByExampleSelective(order, orderExample);
                }
            }
        }
        if (model.getType() == ENTRUST_MATERIAL_TYPE_2.getCode()) {
            // 机加工 质检
            EntrustExample entrustExample = new EntrustExample();
            entrustExample.createCriteria().andEntrustNoEqualTo(inspectNo);
            List<Entrust> entrustList = entrustMapper.selectByExample(entrustExample);
            Entrust entrust = new Entrust();
            if (!CollectionUtils.isEmpty(entrustList) && entrustList.size() > 0) {
                Entrust entrustRecord = entrustList.get(0);
                entrust.setQualifiedNumber(model.getQualifiedNumber() + entrustList.get(0).getQualifiedNumber());
                if (entrustRecord.getNumber() < entrust.getQualifiedNumber()) {
                    throw new BaseException(ResponseEnum.ENTRUST_QUALIFIED_NUMBER_ERROR);
                }
                entrustMapper.updateByExampleSelective(entrust, entrustExample);
            }
        }
        return ResultBean.success(1);
    }

    @Override
    public ResultBean historyDelete(Integer id) {
        historyMapper.deleteByPrimaryKey(id);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean historyList(String inspectNo) {
        InspectHistoryExample historyExample = new InspectHistoryExample();
        historyExample.or().andInspectNoEqualTo(inspectNo);
        List<InspectHistory> histories = historyMapper.selectByExample(historyExample);
        List<InspectHistoryDto> inspectHistoryDtos = new ArrayList<>();
        if (!CollectionUtils.isEmpty(histories)) {
            for (int i = 0; i < histories.size(); i++) {
                InspectHistoryDto dto = new InspectHistoryDto();
                BeanUtils.copyProperties(histories.get(i), dto);
                if (StringUtils.isNotEmpty(histories.get(i).getAccessory())) {
                    dto.setAccessoryList(JSON.parseArray(dto.getAccessory(), Accessory.class));
                }
                if (StringUtils.isNotEmpty(histories.get(i).getReasons())) {
                    dto.setReasonList(JSON.parseArray(dto.getReasons(), InspectReason.class));
                } else if (dto.getUnqualifiedNumber() > 0) {
                    dto.setReasonList(Arrays.asList(new InspectReason(dto.getRemark(), dto.getUnqualifiedNumber())));
                } else {
                    dto.setReasonList(Collections.emptyList());
                }
                inspectHistoryDtos.add(dto);
            }
        }
        return ResultBean.success(inspectHistoryDtos);
    }

    @Override
    public ResultBean historyList(Integer pageNum, Integer pageSize, Integer status) {
        InspectHistoryExample example = new InspectHistoryExample();
        InspectHistoryExample.Criteria criteria = example.createCriteria();
        if (InspectHistoryStatus.BEEN_STORE_2.code == status
            || InspectHistoryStatus.WAITING_STORE_1.code == status) {
            criteria.andStatusEqualTo(status.byteValue());
        }
        criteria.andQualifiedNumberGreaterThan(0);
        Page<InspectHistory> histories = PageHelper.startPage(pageNum, pageSize, "id desc")
            .doSelectPage(() -> historyMapper.selectByExample(example));
        List<InspectHistoryVo> resultList = new ArrayList<>();
        List<InspectHistory> result = histories.getResult();
        if (!CollectionUtils.isEmpty(result)) {
            List<Entrust> entrusts = new ArrayList<>();
            // 从entrust 获取 busType(1.订单需求；2.生产库存)
            List<String> entrustNoSet = result.stream().filter(e -> e.getType().equals(CommonEnum.InspectHistoryType.ENTRUST.code))
                .map(InspectHistory::getInspectNo).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(entrustNoSet)) {
                EntrustExample entrustExample = new EntrustExample();
                entrustExample.or().andEntrustNoIn(entrustNoSet);
                entrusts = entrustMapper.selectByExample(entrustExample);
            }
            Map<String, Byte> entrustMap = Optional.ofNullable(entrusts).orElse(Collections.emptyList()).stream()
                .collect(Collectors.toMap(Entrust::getEntrustNo, Entrust::getBusType));

            for (InspectHistory inspectHistory : result) {
                InspectHistoryVo inspectHistoryVo = new InspectHistoryVo();
                BeanUtils.copyProperties(inspectHistory, inspectHistoryVo);
                inspectHistoryVo.setBusType(entrustMap.get(inspectHistory.getInspectNo()));
                resultList.add(inspectHistoryVo);
            }
        }
        PageDTO pageDTO = new PageDTO();
        BeanUtils.copyProperties(histories, pageDTO);
        pageDTO.setList(resultList);
        return ResultBean.success(pageDTO);
    }

    @Override
    public ResultBean updateHistoryStatus(Integer historyId) {
        InspectHistory inspectHistory = new InspectHistory();
        inspectHistory.setId(historyId);
        inspectHistory.setStatus(InspectHistoryStatus.BEEN_STORE_2.code);
        int update = historyMapper.updateByPrimaryKeySelective(inspectHistory);
        // 入库成功
        if (update > 0) {
            // 如果是机加工入库 ，释放锁定的料
            InspectHistory historyInfo = this.getHistoryInfo(historyId);
            if (historyInfo != null && historyInfo.getType().equals(CommonEnum.InspectHistoryType.ENTRUST.code)) {
                CheckMaterialLockDTO checkMaterialLockDTO = new CheckMaterialLockDTO();
                checkMaterialLockDTO.setType(CommonEnum.CheckMaterialLockType.ENTRUST.type);
                checkMaterialLockDTO.setMaterialGraphNo(historyInfo.getMaterialGraphNo());
                checkMaterialLockDTO.setLockQuantity(historyInfo.getQualifiedNumber());
                checkMaterialLockService.updateLockQuantity(checkMaterialLockDTO);
            }
        }
        return ResultBean.success(1);
    }

    @Override
    public InspectHistory getHistoryInfo(Integer historyId) {
        return historyMapper.selectByPrimaryKey(historyId);
    }

    @Override
    public List<InspectHistory> historyList(List<String> inspectNo, Byte status, Byte type) {
        InspectHistoryExample historyExample = new InspectHistoryExample();
        InspectHistoryExample.Criteria criteria = historyExample.createCriteria();
        if (!CollectionUtils.isEmpty(inspectNo)) {
            criteria.andInspectNoIn(inspectNo);
        }
        if (status != null && status > 0) {
            criteria.andStatusEqualTo(status);
        }
        if (type != null && type > 0) {
            criteria.andTypeEqualTo(type);
        }
        List<InspectHistory> histories = historyMapper.selectByExample(historyExample);
        return histories;
    }
}
