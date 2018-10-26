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
        return ResultBean.success(applyBuyNo);
    }

    @Override
    public ResultBean delete(String applyBuyNo) {
        ApplyBuy applyBuy = new ApplyBuy();
        applyBuy.setIsDelete(CommonEnum.Consts.YES.code);
        ApplyBuyExample applyBuyExample = new ApplyBuyExample();
        applyBuyExample.or().andApplyNoEqualTo(applyBuyNo);
        applyBuyMapper.updateByExampleSelective(applyBuy, applyBuyExample);
        // 删除采购记录
        ProductPurchaseRecordExample productPurchaseRecordExample = new ProductPurchaseRecordExample();
        productPurchaseRecordExample.or().andApplyBuyNoEqualTo(applyBuyNo);
        productPurchaseRecordMapper.deleteByExample(productPurchaseRecordExample);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean deleteItem(String applyBuyNo, String materialGraphNo) {
//        ApplyBuy applyBuy = new ApplyBuy();
//        applyBuy.setIsDelete(CommonEnum.Consts.YES.code);
//        ApplyBuyExample applyBuyExample = new ApplyBuyExample();
//        applyBuyExample.or().andApplyNoEqualTo(applyBuyNo).andMaterialGraphNoEqualTo(materialGraphNo);
//        applyBuyMapper.updateByExampleSelective(applyBuy, applyBuyExample);
//        // 删除采购记录
//        ProductPurchaseRecordExample productPurchaseRecordExample = new ProductPurchaseRecordExample();
//        productPurchaseRecordExample.or().andApplyBuyNoEqualTo(applyBuyNo).andMaterialGraphNoEqualTo(materialGraphNo);
//        productPurchaseRecordMapper.deleteByExample(productPurchaseRecordExample);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean update(ApplyBuyUpdateDTO model) {
//        if (StringUtils.isAnyEmpty(model.getApplyNo(), model.getMaterialGraphNo())) {
//            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
//        }
//        if (model.getNumber() == 0) {
//            return ResultBean.error(CommonEnum.ResponseEnum.PURCHASE_NUMBER_NOT_ZERO);
//        }
//        ApplyBuyExample applyBuyExample = new ApplyBuyExample();
//        applyBuyExample.or().andApplyNoEqualTo(model.getApplyNo())
//                .andMaterialGraphNoEqualTo(model.getMaterialGraphNo());
//        ApplyBuy applyBuy = new ApplyBuy();
//        applyBuy.setNumber(model.getNumber());
//        applyBuy.setPurpose(model.getPurpose());
//        applyBuy.setRemark(model.getRemark());
//        // 获取单价
//        MaterialExample materialExample = new MaterialExample();
//        materialExample.or().andGraphNoEqualTo(model.getMaterialGraphNo());
//        Material material = materialMapper.selectByExample(materialExample).get(0);
//        applyBuy.setValuation(material.getPrice().multiply(new BigDecimal(model.getNumber())));
//        applyBuyMapper.updateByExampleSelective(applyBuy, applyBuyExample);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean getInfo(String applyBuyNo) {
        if (StringUtils.isEmpty(applyBuyNo)) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        ApplyBuyExample applyBuyExample = new ApplyBuyExample();
        applyBuyExample.or().andApplyNoEqualTo(applyBuyNo);
        List<ApplyBuy> applyBuyList = applyBuyMapper.selectByExample(applyBuyExample);
        if (applyBuyList == null || applyBuyList.size() == 0) {
            return ResultBean.error(CommonEnum.ResponseEnum.RESOURCE_NOT_EXIST);
        }
        Map<String, Object> result = new HashMap<>(2);
        ApplyBuy applyBuy = applyBuyList.get(0);
        result.put("order", applyBuy);
        result.put("items", applyBuyList);
        return ResultBean.success(result);
    }


    @Override
    public ResultBean getList(ApplyBuyListDTO model) {
        if (model.getPageNum() == null || model.getPageNum() == 0) {
            model.setPageNum(1);
        }
        if (model.getPageSize() == null || model.getPageSize() == 0) {
            model.setPageSize(10);
        }
        Page<ApplyBuy> pageData = PageHelper.startPage(model.getPageNum(), model.getPageSize())
                .doSelectPage(() -> applyBuyExtendMapper.selectByGroup(model));
        PageDTO<ApplyBuy> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);
        pageDTO.setList(pageData.getResult());
        return ResultBean.success(pageDTO);
    }
}
