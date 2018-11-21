package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.ApplyBuyMapper;
import com.deepsoft.haolifa.dao.repository.MaterialMapper;
import com.deepsoft.haolifa.dao.repository.ProductPurchaseRecordMapper;
import com.deepsoft.haolifa.dao.repository.PurchaseOrderItemMapper;
import com.deepsoft.haolifa.dao.repository.extend.ApplyBuyExtendMapper;
import com.deepsoft.haolifa.dao.repository.extend.PurchaseOrderItemExtendMapper;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.domain.PurchaseOrderItem;
import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.service.ApplyBuyService;
import com.deepsoft.haolifa.util.DateFormatterUtils;
import com.deepsoft.haolifa.util.RandomUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ApplyBuyServiceImpl extends BaseService implements ApplyBuyService {

    @Autowired
    ApplyBuyMapper applyBuyMapper;
    @Autowired
    PurchaseOrderItemExtendMapper ItemExtendMapper;
    @Autowired
    ApplyBuyExtendMapper applyBuyExtendMapper;
    @Autowired
    MaterialMapper materialMapper;
    @Autowired
    ProductPurchaseRecordMapper productPurchaseRecordMapper;
    @Autowired
    PurchaseOrderItemMapper orderItemMapper;

    @Override
    public ResultBean save(ApplyBuyDTO model) {
        String applyBuyNo = "ap_" + RandomUtils.orderNoStr();
        int createUserId = getLoginUserId();
        ApplyBuy applyBuy = new ApplyBuy();
        applyBuy.setApplyNo(applyBuyNo);
        applyBuy.setProductOrderNo(model.getProductOrderNo());
        applyBuy.setTargetTime(DateFormatterUtils.parseDateString(DateFormatterUtils.TWO_FORMATTERPATTERN,model.getTargetDate()));
        applyBuy.setCreateUserId(createUserId);
        applyBuyMapper.insertSelective(applyBuy);
        // 添加采购单项：
        List<PurchaseOrderItem> items = model.getItemList().stream().map(applyBuyItem -> {
            PurchaseOrderItem item = new PurchaseOrderItem();
            item.setMaterialName(applyBuyItem.getMaterialName());
            item.setMaterialGraphNo(applyBuyItem.getMaterialGraphNo());
            item.setNumber(applyBuyItem.getNumber());
            item.setValuation(applyBuyItem.getValuation());
            item.setRemark(applyBuyItem.getRemark());
            item.setPurpose(applyBuyItem.getPurpose());
            item.setUnit(applyBuyItem.getUnit());
            item.setApplyNo(applyBuyNo);
            return item;
        }).collect(Collectors.toList());
        ItemExtendMapper.batchInsertPurchaseOrderItem(items);
        // 添加请求采购记录
//        List<ProductPurchaseRecord> productPurchaseRecordList = modelList.stream().map(t -> {
//            ProductPurchaseRecord productPurchaseRecord = new ProductPurchaseRecord();
//            productPurchaseRecord.setApplyBuyNo(applyBuyNo);
//            productPurchaseRecord.setMaterialGraphNo(t.getMaterialGraphNo());
//            return productPurchaseRecord;
//        }).collect(Collectors.toList());
//        productPurchaseRecordMapper.batchInsertProductPurchaseRecord(productPurchaseRecordList);
        Map<String,Object> result = new HashMap<>(8);
        result.put("formId",applyBuy.getId());
        result.put("formType",CommonEnum.FormType.APPLYBUY_TYPE.code);
        result.put("formNo",applyBuy.getApplyNo());
        return ResultBean.success(result);
    }


    @Override
    public ResultBean deleteItem(String applyBuyNo, String materialGraphNo) {
        PurchaseOrderItemExample itemExample = new PurchaseOrderItemExample();
        itemExample.createCriteria().andApplyNoEqualTo(applyBuyNo).andMaterialGraphNoEqualTo(materialGraphNo);
        orderItemMapper.deleteByExample(itemExample);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean update(ApplyBuyUpdateDTO model) {
        PurchaseOrderItem purchaseOrderItem = new PurchaseOrderItem();
        BeanUtils.copyProperties(model,purchaseOrderItem);
        purchaseOrderItem.setId(model.getItemId());
        orderItemMapper.updateByPrimaryKeySelective(purchaseOrderItem);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean getInfo(Integer applyBuyId) {
        ApplyBuy applyBuy = applyBuyMapper.selectByPrimaryKey(applyBuyId);
        PurchaseOrderItemExample itemExample = new PurchaseOrderItemExample();
        itemExample.createCriteria().andApplyNoEqualTo(applyBuy.getApplyNo());
        List<PurchaseOrderItem> items = orderItemMapper.selectByExample(itemExample);
        Map<String, Object> result = new HashMap<>(2);
        result.put("order", applyBuy);
        result.put("items", items);
        return ResultBean.success(result);
    }
}
