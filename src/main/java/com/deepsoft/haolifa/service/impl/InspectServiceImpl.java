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
import com.deepsoft.haolifa.constant.CommonEnum.InspectHistoryStatus;
import com.deepsoft.haolifa.constant.CommonEnum.InspectStatus;
import com.deepsoft.haolifa.constant.CommonEnum.ResponseEnum;
import com.deepsoft.haolifa.dao.repository.*;
import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.service.InspectService;
import com.deepsoft.haolifa.util.DateFormatterUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Map.Entry;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                InspectItem inspectItem = new InspectItem();
                BeanUtils.copyProperties(items.get(i), inspectItem);
                inspectItem.setInspectId(inspect.getId());
                inspectItem.setPurchasePrice(new BigDecimal(items.get(i).getPurchasePrice()));
                inspectItem.setPurchaseNo(model.getPurchaseNo());
                inspectItemMapper.insertSelective(inspectItem);
                totalCount += items.get(i).getDeliveryNumber();
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
                InspectItem inspectItem = new InspectItem();
                BeanUtils.copyProperties(items.get(i), inspectItem);
                inspectItem.setPurchasePrice(new BigDecimal(items.get(i).getPurchasePrice()));
                inspectItem.setInspectId(inspect.getId());
                inspectItemMapper.insertSelective(inspectItem);
                totalCount += items.get(i).getDeliveryNumber();
            }
            Inspect inspectCount = new Inspect();
            inspectCount.setId(inspect.getId());
            inspectCount.setTotalCount(totalCount);
            inspectMapper.updateByPrimaryKeySelective(inspectCount);
        }
        return ResultBean.success(1);
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
    public ResultBean getList(int type, int pageNum, int pageSize, String inspectNo, String purchaseOrderNo) {
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
        if (StringUtils.isNotEmpty(purchaseOrderNo)) {
            criteria.andPurchaseNoLike("%" + purchaseOrderNo + "%");
        }
        if (StringUtils.isNotEmpty(inspectNo)) {
            criteria.andInspectNoLike("%" + inspectNo + "%");
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
        String orderNo = "";
        if (model.getType() == PURCHASE_MATERIAL_TYPE_1.getCode()) {
            // 采购零件 质检
            InspectExample example = new InspectExample();
            example.createCriteria().andInspectNoEqualTo(model.getInspectNo());
            List<Inspect> inspectList = inspectMapper.selectByExample(example);
            Inspect inspect = new Inspect();
            if (!CollectionUtils.isEmpty(inspectList) && inspectList.size() > 0) {
                Inspect inspectRecord = inspectList.get(0);
                inspect.setQualifiedNumber(inspectRecord.getQualifiedNumber() + model.getQualifiedNumber());
                inspect.setUnqualifiedNumber(inspectRecord.getUnqualifiedNumber() + model.getUnqualifiedNumber());
                if (inspectRecord.getTotalCount() < inspect.getQualifiedNumber()) {
                    throw new BaseException(ResponseEnum.INSPECT_QUALIFIED_NUMBER_ERROR);
                }
                inspectMapper.updateByExampleSelective(inspect, example);
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
                    purchaseOrderMapper.updateByExampleSelective(order, orderExample);
                }
            }
        }
        if (model.getType() == ENTRUST_MATERIAL_TYPE_2.getCode()) {
            // 机加工 质检
            EntrustExample entrustExample = new EntrustExample();
            entrustExample.createCriteria().andEntrustNoEqualTo(model.getInspectNo());
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
        PageDTO pageDTO = new PageDTO();
        BeanUtils.copyProperties(histories, pageDTO);
        pageDTO.setList(histories.getResult());
        return ResultBean.success(pageDTO);
    }

    @Override
    public ResultBean updateHistoryStatus(Integer historyId) {
        InspectHistory inspectHistory = new InspectHistory();
        inspectHistory.setId(historyId);
        inspectHistory.setStatus(InspectHistoryStatus.BEEN_STORE_2.code);
        historyMapper.updateByPrimaryKeySelective(inspectHistory);
        return ResultBean.success(1);
    }
}
