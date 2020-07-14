package com.deepsoft.haolifa.service.impl;

import static com.deepsoft.haolifa.constant.CacheKey.BATCH_NUM_KEY;
import static com.deepsoft.haolifa.constant.CacheKey.INSPECT_NO_KEY;
import static com.deepsoft.haolifa.constant.CommonEnum.FlowId.ENTRUST_FLOW;
import static com.deepsoft.haolifa.constant.CommonEnum.FlowId.PURCHASE_FLOW;
import static com.deepsoft.haolifa.constant.CommonEnum.FormType.ENTRUST_TYPE;
import static com.deepsoft.haolifa.constant.CommonEnum.FormType.PURCHASE_TYPE;
import static com.deepsoft.haolifa.constant.Constant.PurchaseOrderType.ORDER_TYPE_ENTRUST_1;
import static com.deepsoft.haolifa.constant.Constant.PurchaseOrderType.ORDER_TYPE_PURCHASE_0;
import static com.deepsoft.haolifa.constant.Constant.SerialNumberPrefix.BATCH_NUMBER_PREFIX_PC;
import static com.deepsoft.haolifa.constant.Constant.SerialNumberPrefix.INSPECT_NO_PREFIX_BJ;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.deepsoft.haolifa.cache.redis.RedisDao;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.constant.CommonEnum.ResponseEnum;
import com.deepsoft.haolifa.dao.repository.*;
import com.deepsoft.haolifa.dao.repository.extend.PurchaseOrderItemExtendMapper;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.domain.PurchaseOrderItem;
import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.service.*;
import com.deepsoft.haolifa.util.DateFormatterUtils;
import com.deepsoft.haolifa.util.UpperMoney;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import java.math.RoundingMode;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Service
@Slf4j
public class PurcahseOrderServiceImpl extends BaseService implements PurcahseOrderService {

    @Autowired
    private RedisDao redisDao;

    @Autowired
    private UploadPurchaseExcelService uploadPurchaseExcelService;

    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;
    @Autowired
    private PurchaseOrderItemMapper purchaseOrderItemMapper;
    @Autowired
    private PurchaseOrderItemExtendMapper itemExtendMapper;
    @Lazy
    @Autowired
    private FlowInstanceService flowInstanceService;

    @Autowired
    private InspectMapper inspectMapper;

    @Autowired
    private InspectItemMapper inspectItemMapper;

    @Autowired
    private ApplyBuyService applyBuyService;

    @Autowired
    private SupplierMapper supplierMapper;

    @Autowired
    private PriceMaterialMapper priceMaterialMapper;

    @Autowired
    private MaterialService materialService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultBean save(PurchaseOrderDTO model, Integer orderType) {
        PurchaseOrderExample example = new PurchaseOrderExample();
        example.or().andPurchaseOrderNoEqualTo(model.getOrderNo());
        List<PurchaseOrder> orders = purchaseOrderMapper.selectByExample(example);
        if (orders != null && orders.size() > 0) {
            return ResultBean.error(ResponseEnum.PURCHASE_NO_EXIST);
        }
        model.setId(null);
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        BeanUtils.copyProperties(model, purchaseOrder);
        purchaseOrder.setOrderType(orderType.byteValue());
        purchaseOrder.setPurchaseOrderNo(model.getOrderNo());
        purchaseOrder.setCreateUserId(getLoginUserId());
        if (StrUtil.isNotBlank(model.getDeliveryTime())) {
            purchaseOrder.setDeliveryTime(
                DateFormatterUtils.parseDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, model.getDeliveryTime()));
        }
        if (StrUtil.isNotBlank(model.getDeliveryTime())) {
            purchaseOrder.setOperateTime(
                DateFormatterUtils.parseDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, model.getOperateTime()));
        }
        if (StrUtil.isNotBlank(model.getDeliveryTime())) {
            purchaseOrder.setConfirmTime(
                DateFormatterUtils.parseDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, model.getConfirmTime()));
        }
        // 插入单项
        double totalPrice = 0.0;
        int totalCount = 0;
        List<PurchaseOrderItem> items = new ArrayList<>();
        for (int i = 0; i < model.getItemList().size(); i++) {
            PurchaseOrderItem orderItem = new PurchaseOrderItem();
            com.deepsoft.haolifa.model.dto.PurchaseOrderItem item = model.getItemList().get(i);
            String graphNo = item.getMaterialGraphNo();
            if (!materialService.existsGraphNo(graphNo)) {
                throw new BaseException(CommonEnum.ResponseEnum.MATERIAL_GRAPH_NO_NOT_EXIST_1.code, graphNo);
            }
            BeanUtils.copyProperties(item, orderItem);
            orderItem.setUnitPrice(new BigDecimal(item.getUnitPrice()));
            orderItem.setUnitWeight(new BigDecimal(item.getUnitWeight()));
            orderItem.setPurchaseOrderNo(model.getOrderNo());
            items.add(orderItem);
            totalPrice += item.getUnitPrice() * item.getNumber();
            totalCount += item.getNumber();
        }
        purchaseOrder.setTotalPrice(new BigDecimal(totalPrice));
        purchaseOrder.setTotalCount(totalCount);
        log.info("添加订单内容：{}", JSON.toJSONString(purchaseOrder));
        purchaseOrderMapper.insertSelective(purchaseOrder);
        log.info("添加订单单项：{}", JSON.toJSONString(items));
        itemExtendMapper.batchInsertPurchaseOrderItem(items);
        uploadPurchaseExcelService.uploadPurchaseOrderExcel(purchaseOrder.getId());
        // 如果带了待采购的Id，将其更新成已完成
        List<Integer> applyBuyIds = model.getApplyBuyIds();
        if (!CollectionUtils.isEmpty(applyBuyIds)) {
            for (Integer applyBuyId : applyBuyIds) {
                applyBuyService.updateStatus(applyBuyId);
            }
        }

        Map<String, Object> result = new HashMap<>(8);
        result.put("formId", purchaseOrder.getId());
        result.put("formType", PURCHASE_TYPE.code);
        result.put("formNo", purchaseOrder.getPurchaseOrderNo());
        return ResultBean.success(result);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultBean delete(String purchaseOrderNo) {
        // 删除采购订单
        PurchaseOrderExample purchaseOrderExample = new PurchaseOrderExample();
        purchaseOrderExample.or().andPurchaseOrderNoEqualTo(purchaseOrderNo);
        purchaseOrderMapper.deleteByExample(purchaseOrderExample);
        // 删除子项
        PurchaseOrderItemExample purchaseOrderItemExample = new PurchaseOrderItemExample();
        purchaseOrderItemExample.or().andPurchaseOrderNoEqualTo(purchaseOrderNo);
        purchaseOrderItemMapper.deleteByExample(purchaseOrderItemExample);
        flowInstanceService.deleteFlowInstance(purchaseOrderNo);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean deleteItem(String purchaseOrderNo, String materialGraphNo) {
        PurchaseOrderItemExample purchaseOrderItemExample = new PurchaseOrderItemExample();
        purchaseOrderItemExample.or().andPurchaseOrderNoEqualTo(purchaseOrderNo).andMaterialGraphNoEqualTo(materialGraphNo);
        purchaseOrderItemMapper.deleteByExample(purchaseOrderItemExample);
        return ResultBean.success(1);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultBean update(PurchaseOrderDTO model) {
        if (model.getId() == null || model.getId() == 0) {
            return ResultBean.error(ResponseEnum.PARAM_ERROR);
        }
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        BeanUtils.copyProperties(model, purchaseOrder);
        purchaseOrder.setPurchaseOrderNo(model.getOrderNo());
        purchaseOrder.setDeliveryTime(
            DateFormatterUtils.parseDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, model.getDeliveryTime()));
        purchaseOrder.setOperateTime(
            DateFormatterUtils.parseDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, model.getOperateTime()));
        purchaseOrder.setConfirmTime(
            DateFormatterUtils.parseDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, model.getConfirmTime()));
        PurchaseOrderItemExample example = new PurchaseOrderItemExample();
        example.or().andPurchaseOrderNoEqualTo(model.getOrderNo());
        purchaseOrderItemMapper.deleteByExample(example);
        // 插入单项
        double totalPrice = 0.0;
        int totalCount = 0;
        List<PurchaseOrderItem> items = new ArrayList<>();
        for (int i = 0; i < model.getItemList().size(); i++) {
            PurchaseOrderItem orderItem = new PurchaseOrderItem();
            com.deepsoft.haolifa.model.dto.PurchaseOrderItem item = model.getItemList().get(i);
            BeanUtils.copyProperties(item, orderItem);
            orderItem.setUnitPrice(new BigDecimal(item.getUnitPrice()));
            orderItem.setUnitWeight(new BigDecimal(item.getUnitWeight()));
            orderItem.setPurchaseOrderNo(model.getOrderNo());
            items.add(orderItem);
            totalPrice += item.getUnitPrice() * item.getNumber();
            totalCount += item.getNumber();
        }
        purchaseOrder.setTotalPrice(new BigDecimal(totalPrice));
        purchaseOrder.setTotalCount(totalCount);
        purchaseOrderMapper.updateByPrimaryKeySelective(purchaseOrder);
        log.info("添加订单单项：{}", JSON.toJSONString(items));
        itemExtendMapper.batchInsertPurchaseOrderItem(items);
        uploadPurchaseExcelService.uploadPurchaseOrderExcel(model.getId());
        return ResultBean.success(1);
    }

    @Override
    public ResultBean getInfo(Integer id) {
        PurchaseOrder purchaseOrder = purchaseOrderMapper.selectByPrimaryKey(id);
        if (purchaseOrder == null) {
            return ResultBean.success(CommonEnum.ResponseEnum.PURCHASE_NO_NOT_EXIST);
        }
        PurchaseOrderExDTO purchaseOrderExDTO = new PurchaseOrderExDTO();
        BeanUtils.copyProperties(purchaseOrder, purchaseOrderExDTO);
        purchaseOrderExDTO.setOrderType(purchaseOrder.getOrderType().intValue());
        PurchaseOrderItemExample purchaseOrderItemExample = new PurchaseOrderItemExample();
        purchaseOrderItemExample.or().andPurchaseOrderNoEqualTo(purchaseOrder.getPurchaseOrderNo());
        List<PurchaseOrderItem> purchaseOrderItemList = purchaseOrderItemMapper.selectByExample(purchaseOrderItemExample);
        if (purchaseOrderItemList == null) {
            purchaseOrderItemList = new ArrayList<>();
        }
        List<PurchaseOrderItemExDTO> exDTOS = new ArrayList<>();
        double orderTotalAmount = 0;
        int orderTotalNumber = 0;
        double orderTotalWeight = 0;
        for (int i = 0; i < purchaseOrderItemList.size(); i++) {
            PurchaseOrderItem item = purchaseOrderItemList.get(i);
            PurchaseOrderItemExDTO itemExDTO = new PurchaseOrderItemExDTO();
            BeanUtils.copyProperties(item, itemExDTO);
            double tempAmount = item.getUnitPrice().multiply(new BigDecimal(item.getNumber())).doubleValue();
            double tempWeight = item.getUnitWeight().multiply(new BigDecimal(item.getNumber())).doubleValue();
            itemExDTO.setTotalAmount(tempAmount);
            itemExDTO.setTotalWeight(tempWeight);
            orderTotalAmount += tempAmount;
            orderTotalWeight += tempWeight;
            orderTotalNumber += item.getNumber();
            exDTOS.add(itemExDTO);
        }
        purchaseOrderExDTO.setTotalPrice(orderTotalAmount);
        purchaseOrderExDTO.setTotalPriceCN(UpperMoney.upper(String.valueOf(orderTotalAmount)));
        purchaseOrderExDTO.setTotalWeight(orderTotalWeight);
        purchaseOrderExDTO.setOrderNumber(orderTotalNumber);
        Map<String, Object> result = new HashMap<>(2);
        result.put("order", purchaseOrderExDTO);
        result.put("items", exDTOS);
        return ResultBean.success(result);
    }

    @Override
    public ResultBean getList(PurchaseOrderListDTO model) {
        if (model.getPageNum() == null || model.getPageNum() == 0) {
            model.setPageNum(1);
        }
        if (model.getPageSize() == null || model.getPageSize() == 0) {
            model.setPageSize(10);
        }
        PurchaseOrderExample purchaseOrderExample = new PurchaseOrderExample();
        PurchaseOrderExample.Criteria criteria = purchaseOrderExample.createCriteria();
        if (StringUtils.isNotEmpty(model.getPurchaseOrderNo())) {
            criteria.andPurchaseOrderNoLike("%" + model.getPurchaseOrderNo() + "%");
        }
        Page<PurchaseOrder> purchaseOrderList = PageHelper.startPage(model.getPageNum(), model.getPageSize())
            .doSelectPage(() -> purchaseOrderMapper.selectByExample(purchaseOrderExample));
        PageDTO<PurchaseOrder> purchaseOrderPageDTO = new PageDTO<>();
        BeanUtils.copyProperties(purchaseOrderList, purchaseOrderPageDTO);
        purchaseOrderPageDTO.setList(purchaseOrderList.getResult());
        return ResultBean.success(purchaseOrderPageDTO);
    }

    @Override
    public ResultBean list(int pageNum, int pageSize, String orderNo, int createUserId, int status, Integer orderType,
                           String supplierName, String startDate, String endDate) {
        List<String> supplierNoList = new ArrayList<>();
        if (StringUtils.isNotEmpty(supplierName)) {
            SupplierExample supplierExample = new SupplierExample();
            supplierExample.createCriteria().andSuppilerNameLike("%" + supplierName + "%");
            List<Supplier> suppliers = supplierMapper.selectByExample(supplierExample);
            supplierNoList = suppliers.stream().map(Supplier::getSuppilerNo).collect(Collectors.toList());
        }
        PurchaseOrderExample purchaseOrderExample = new PurchaseOrderExample();
        PurchaseOrderExample.Criteria criteria = purchaseOrderExample.createCriteria();
        if (orderType != -1) {
            criteria.andOrderTypeEqualTo(orderType.byteValue());
        }
        if (StringUtils.isNotEmpty(orderNo)) {
            criteria.andPurchaseOrderNoLike("%" + orderNo + "%");
        }
        if (createUserId != 0) {
            criteria.andCreateUserIdEqualTo(createUserId);
        }
        if (status != 0) {
            criteria.andStatusEqualTo((byte) status);
        }
        if (StrUtil.isNotBlank(startDate)) {
            DateTime startParse = DateUtil.parse(startDate, "yyyy-MM-dd");
            criteria.andCreateTimeGreaterThanOrEqualTo(startParse);
        }
        if (StrUtil.isNotBlank(endDate)) {
            DateTime endParse = DateUtil.parse(endDate, "yyyy-MM-dd");
            criteria.andCreateTimeLessThanOrEqualTo(endParse);
        }
        PageDTO<PurchaseOrder> purchaseOrderPageDTO;
        if (supplierNoList.size() > 0) {
            criteria.andSupplierNoIn(supplierNoList);
        } else if (StringUtils.isNotEmpty(supplierName)) {
            purchaseOrderPageDTO = new PageDTO<>();
            purchaseOrderPageDTO.setList(new ArrayList<>());
            return ResultBean.success(purchaseOrderPageDTO);
        }
        Page<PurchaseOrder> purchaseOrderList = PageHelper.startPage(pageNum, pageSize, "create_time desc")
            .doSelectPage(() -> purchaseOrderMapper.selectByExample(purchaseOrderExample));
        purchaseOrderPageDTO = new PageDTO<>();
        BeanUtils.copyProperties(purchaseOrderList, purchaseOrderPageDTO);
        purchaseOrderPageDTO.setList(purchaseOrderList.getResult());
        return ResultBean.success(purchaseOrderPageDTO);
    }

    @Override
    public ResultBean complete(PurchaseOrderCompleteDTO model) {
        PurchaseOrderExample example = new PurchaseOrderExample();
        PurchaseOrderExample.Criteria criteria = example.createCriteria();
        criteria.andPurchaseOrderNoEqualTo(model.getOrderNo());
        PurchaseOrder order = new PurchaseOrder();
        order.setStatus((byte) 5);
        if (StringUtils.isNotEmpty(model.getWreckReason())) {
            order.setWreckReason(model.getWreckReason());
        }
        if (model.getWreckAmount() != 0) {
            order.setWreckAmount(new BigDecimal(model.getWreckAmount()));
        }
        purchaseOrderMapper.updateByExampleSelective(order, example);
        return ResultBean.success(1);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultBean approve(String orderNo, Integer orderType) {
        PurchaseOrderExample existExample = new PurchaseOrderExample();
        existExample.or().andPurchaseOrderNoEqualTo(orderNo);
        PurchaseOrder purchaseOrder = purchaseOrderMapper.selectByExample(existExample).get(0);
        PurchaseOrderExample example = new PurchaseOrderExample();
        PurchaseOrderExample.Criteria criteria = example.createCriteria();
        criteria.andPurchaseOrderNoEqualTo(orderNo);
        PurchaseOrder order = new PurchaseOrder();
        order.setStatus((byte) 2);
        purchaseOrderMapper.updateByExampleSelective(order, example);
        FlowInstanceDTO flowInstanceDTO = new FlowInstanceDTO();
        if (ORDER_TYPE_PURCHASE_0 == orderType) {
            flowInstanceDTO.setFlowId(PURCHASE_FLOW.id);
            flowInstanceDTO.setSummary("采购订单审批");
            flowInstanceDTO.setFormType(PURCHASE_TYPE.code);
        } else if (ORDER_TYPE_ENTRUST_1 == orderType) {
            flowInstanceDTO.setFlowId(ENTRUST_FLOW.id);
            flowInstanceDTO.setSummary("机加工订单审批");
            flowInstanceDTO.setFormType(ENTRUST_TYPE.code);
        }

        flowInstanceDTO.setFormNo(orderNo);
        flowInstanceDTO.setFormId(purchaseOrder.getId());
        flowInstanceService.create(flowInstanceDTO);
        uploadPurchaseExcelService.uploadPurchaseOrderExcel(purchaseOrder.getId());
        return ResultBean.success(1);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultBean createInspect(Integer formId) {
        PurchaseOrder purchaseOrder = purchaseOrderMapper.selectByPrimaryKey(formId);
        PurchaseOrderExDTO purchaseOrderExDTO = new PurchaseOrderExDTO();
        BeanUtils.copyProperties(purchaseOrder, purchaseOrderExDTO);
        PurchaseOrderItemExample purchaseOrderItemExample = new PurchaseOrderItemExample();
        purchaseOrderItemExample.or().andPurchaseOrderNoEqualTo(purchaseOrder.getPurchaseOrderNo());
        List<PurchaseOrderItem> purchaseOrderItemList = purchaseOrderItemMapper.selectByExample(purchaseOrderItemExample);

        int createUserId = getLoginUserId();
        String inspectNo = createSerialNumber(INSPECT_NO_PREFIX_BJ, INSPECT_NO_KEY);
        String batchNumer = createSerialNumber(BATCH_NUMBER_PREFIX_PC, BATCH_NUM_KEY);
        Inspect inspect = new Inspect();
        inspect.setCreateUserId(createUserId);
        inspect.setInspectNo(inspectNo);
        inspect.setSupplierNo(purchaseOrder.getSupplierNo());
        inspect.setSupplierName(purchaseOrder.getSupplierName());
        inspect.setPurchaseNo(purchaseOrder.getPurchaseOrderNo());
        inspect.setBatchNumber(batchNumer);
        inspect.setStatus((byte) 1);
        inspect.setArrivalTime(new Date());
        inspectMapper.insertSelective(inspect);
        if (purchaseOrderItemList != null && purchaseOrderItemList.size() > 0) {
            for (int i = 0; i < purchaseOrderItemList.size(); i++) {
                InspectItem inspectItem = new InspectItem();
                PurchaseOrderItem orderItem = purchaseOrderItemList.get(i);
                inspectItem.setPurchaseNumber(orderItem.getNumber());
                inspectItem.setPurchaseNo(purchaseOrder.getPurchaseOrderNo());
                inspectItem.setMaterialGraphNo(orderItem.getMaterialGraphNo());
                inspectItem.setMaterialName(orderItem.getMaterialName());
                inspectItem.setSpecification(orderItem.getSpecification());
                inspectItem.setRequirements(orderItem.getMaterial());
                inspectItem.setUnit(orderItem.getUnit());
                inspectItem.setSupplierName(purchaseOrder.getSupplierName());
                inspectItem.setSupplierNo(purchaseOrder.getSupplierNo());
                inspectItem.setPurchasePrice(orderItem.getUnitPrice());
                inspectItem.setInspectId(inspect.getId());
                inspectItem.setInspectNo(inspect.getInspectNo());
                inspectItemMapper.insertSelective(inspectItem);
            }
        }
        return ResultBean.success(inspect.getId());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateOrderStatus(Integer formId, Integer status) {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setId(formId);
        purchaseOrder.setStatus(status.byteValue());
        purchaseOrderMapper.updateByPrimaryKeySelective(purchaseOrder);

        // 如果采购流程审核完成，将这个采购订单中高于零件库的价格，进行更新
        if (status.equals(3)) {
            PurchaseOrder order = purchaseOrderMapper.selectByPrimaryKey(formId);
            String purchaseOrderNo = order.getPurchaseOrderNo();
            PurchaseOrderItemExample itemExample = new PurchaseOrderItemExample();
            itemExample.or().andPurchaseOrderNoEqualTo(purchaseOrderNo);
            List<PurchaseOrderItem> purchaseOrderItems = purchaseOrderItemMapper.selectByExample(itemExample);
            if (CollectionUtil.isNotEmpty(purchaseOrderItems)) {
                List<String> graphNoList = purchaseOrderItems.stream().map(PurchaseOrderItem::getMaterialGraphNo).collect(Collectors.toList());
                PriceMaterialExample priceMaterialExample = new PriceMaterialExample();
                priceMaterialExample.or().andGraphNoIn(graphNoList);
                List<PriceMaterial> priceMaterialList = priceMaterialMapper.selectByExample(priceMaterialExample);
                Map<String, PriceMaterial> priceMap = priceMaterialList.stream().collect(Collectors.toMap(PriceMaterial::getGraphNo, Function.identity()));
                purchaseOrderItems.forEach(item -> {
                    BigDecimal unitPrice = item.getUnitPrice();
                    PriceMaterial priceMaterial = priceMap.get(item.getMaterialGraphNo());
                    if (unitPrice != null && priceMaterial != null && priceMaterial.getPrice() != null) {
                        // 如果采购订单中的价格高于零件库中的价格
                        if (unitPrice.compareTo(priceMaterial.getPrice()) == 1) {
                            PriceMaterial updatePrice = new PriceMaterial();
                            updatePrice.setId(priceMaterial.getId());
                            updatePrice.setPriceTax(unitPrice);
                            String taxRate = priceMaterial.getTaxRate();
                            BigDecimal taxRateBig = BigDecimal.valueOf(0.13).add(BigDecimal.ONE);
                            if (StrUtil.isNotBlank(taxRate)) {
                                taxRateBig = BigDecimal.valueOf(Long.parseLong(taxRate)).divide(BigDecimal.valueOf(100)).add(BigDecimal.ONE);
                            }
                            updatePrice.setPrice(unitPrice.divide(taxRateBig, 2, RoundingMode.HALF_UP));
                            if (priceMaterialMapper.updateByPrimaryKeySelective(updatePrice) > 0) {
                                materialService.updateMaterialPrice(priceMaterial.getGraphNo(), updatePrice.getPrice());
                            }
                        }
                    }
                });
            }
        }
    }
}


