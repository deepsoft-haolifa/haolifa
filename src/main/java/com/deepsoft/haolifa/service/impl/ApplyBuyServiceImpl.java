package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.ApplyBuyMapper;
import com.deepsoft.haolifa.dao.repository.MaterialMapper;
import com.deepsoft.haolifa.dao.repository.ProductPurchaseRecordMapper;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.ApplyBuyDTO;
import com.deepsoft.haolifa.model.dto.ApplyBuyUpdateDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.StoreKeeperApplyBuyDTO;
import com.deepsoft.haolifa.service.ApplyBuyService;
import com.deepsoft.haolifa.util.RandomUtils;
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
    MaterialMapper materialMapper;
    @Autowired
    ProductPurchaseRecordMapper productPurchaseRecordMapper;

    @Override
    public ResultBean saveByPurchasePlan(List<ApplyBuyDTO> modelList) {
        String applyBuyNo = "ap_" + RandomUtils.orderNoStr();
        // 获取物料信息
        List<String> materialGraphNoList = modelList.stream()
                .map(ApplyBuyDTO::getMaterialGraphNo)
                .distinct()
                .collect(Collectors.toList());
        MaterialExample materialExample = new MaterialExample();
        materialExample.or().andGraphNoIn(materialGraphNoList);
        List<Material> materialList = materialMapper.selectByExample(materialExample);
        Map<String, Material> tempMaterial = new HashMap<>();
        materialList.stream().map(material -> {
            tempMaterial.put(material.getGraphNo(), material);
            return null;
        });
        // 封装持久化数据
        int createUserId = getLoginUserId();
        List<ApplyBuy> applyBuyList = modelList.stream().map(applyBuyDTO -> {
            ApplyBuy applyBuy = new ApplyBuy();
            Material material = tempMaterial.get(applyBuyDTO.getMaterialGraphNo());
            applyBuy.setApplyNo(applyBuyNo);
            applyBuy.setMaterialGraphNo(applyBuyDTO.getMaterialGraphNo());
            applyBuy.setUnit(material.getUnit());
            applyBuy.setValuation(material.getPrice().multiply(new BigDecimal(applyBuyDTO.getNumber())));
            applyBuy.setCreateUserId(createUserId);
            return applyBuy;
        }).collect(Collectors.toList());
        applyBuyMapper.batchInsertApplyBuy(applyBuyList);
        // 更新record记录
        List<ProductPurchaseRecord> productPurchaseRecordList = modelList.stream().map(applyBuyDTO -> {
            ProductPurchaseRecord productPurchaseRecord = new ProductPurchaseRecord();
            productPurchaseRecord.setMaterialGraphNo(applyBuyDTO.getMaterialGraphNo());
            productPurchaseRecord.setPurchasePlanNo(applyBuyDTO.getPurchasePlanNo());
            productPurchaseRecord.setApplyBuyNo(applyBuyNo);
            return productPurchaseRecord;
        }).collect(Collectors.toList());
        productPurchaseRecordMapper.batchUpdateApplyBuyNo(productPurchaseRecordList);
        return ResultBean.success(applyBuyNo);
    }

    @Override
    public ResultBean saveByStoreKeeper(List<StoreKeeperApplyBuyDTO> modelList) {
        String applyBuyNo = "ap_" + RandomUtils.orderNoStr();
        int createUserId = getLoginUserId();
        List<ApplyBuy> applyBuyList = modelList.stream().map(t -> {
            ApplyBuy applyBuy = new ApplyBuy();
            BeanUtils.copyProperties(t, applyBuy);
            applyBuy.setApplyNo(applyBuyNo);
            applyBuy.setCreateUserId(createUserId);
            applyBuy.setValuation(new BigDecimal(t.getValuation()));
            return applyBuy;
        }).collect(Collectors.toList());
        applyBuyMapper.batchInsertApplyBuy(applyBuyList);
        // 添加请求采购记录
        List<ProductPurchaseRecord> productPurchaseRecordList = modelList.stream().map(t -> {
            ProductPurchaseRecord productPurchaseRecord = new ProductPurchaseRecord();
            productPurchaseRecord.setApplyBuyNo(applyBuyNo);
            productPurchaseRecord.setMaterialGraphNo(t.getMaterialGraphNo());
            return productPurchaseRecord;
        }).collect(Collectors.toList());
        productPurchaseRecordMapper.batchInsertProductPurchaseRecord(productPurchaseRecordList);
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
        ApplyBuy applyBuy = new ApplyBuy();
        applyBuy.setIsDelete(CommonEnum.Consts.YES.code);
        ApplyBuyExample applyBuyExample = new ApplyBuyExample();
        applyBuyExample.or().andApplyNoEqualTo(applyBuyNo).andMaterialGraphNoEqualTo(materialGraphNo);
        applyBuyMapper.updateByExampleSelective(applyBuy, applyBuyExample);
        // 删除采购记录
        ProductPurchaseRecordExample productPurchaseRecordExample = new ProductPurchaseRecordExample();
        productPurchaseRecordExample.or().andApplyBuyNoEqualTo(applyBuyNo).andMaterialGraphNoEqualTo(materialGraphNo);
        productPurchaseRecordMapper.deleteByExample(productPurchaseRecordExample);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean update(ApplyBuyUpdateDTO model) {
        if (StringUtils.isAnyEmpty(model.getApplyNo(), model.getMaterialGraphNo())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        if (model.getNumber() == 0) {
            return ResultBean.error(CommonEnum.ResponseEnum.PURCHASE_NUMBER_NOT_ZERO);
        }
        ApplyBuyExample applyBuyExample = new ApplyBuyExample();
        applyBuyExample.or().andApplyNoEqualTo(model.getApplyNo())
                .andMaterialGraphNoEqualTo(model.getMaterialGraphNo());
        ApplyBuy applyBuy = new ApplyBuy();
        applyBuy.setNumber(model.getNumber());
        applyBuy.setPurpose(model.getPurpose());
        applyBuy.setRemark(model.getRemark());
        // 获取单价
        MaterialExample materialExample = new MaterialExample();
        materialExample.or().andGraphNoEqualTo(model.getMaterialGraphNo());
        Material material = materialMapper.selectByExample(materialExample).get(0);
        applyBuy.setValuation(material.getPrice().multiply(new BigDecimal(model.getNumber())));
        applyBuyMapper.updateByExampleSelective(applyBuy,applyBuyExample);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean getInfo(String applyBuyNo) {
        ApplyBuyExample applyBuyExample = new ApplyBuyExample();
        applyBuyExample.or().andApplyNoEqualTo(applyBuyNo);
        List<ApplyBuy> applyBuyList = applyBuyMapper.selectByExample(applyBuyExample);
        return ResultBean.success(applyBuyList);
    }
    // TODO 暂未实现
    @Override
    public ResultBean getList(Integer currentPage, Integer pageSize) {
        return null;
    }
}
