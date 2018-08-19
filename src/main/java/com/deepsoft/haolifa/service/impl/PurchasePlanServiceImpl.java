package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.ProductPurchaseRecordMapper;
import com.deepsoft.haolifa.dao.repository.PurchasePlanMapper;
import com.deepsoft.haolifa.model.domain.ProductPurchaseRecord;
import com.deepsoft.haolifa.model.domain.ProductPurchaseRecordExample;
import com.deepsoft.haolifa.model.domain.PurchasePlan;
import com.deepsoft.haolifa.model.domain.PurchasePlanExample;
import com.deepsoft.haolifa.model.dto.CustomUser;
import com.deepsoft.haolifa.model.dto.PurchasePlanDTO;
import com.deepsoft.haolifa.model.dto.PurchasePlanItem;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.PurchasePlanService;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.util.DateFormatterUtils;
import com.deepsoft.haolifa.util.RandomUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PurchasePlanServiceImpl implements PurchasePlanService {

    @Autowired
    PurchasePlanMapper purchasePlanMapper;
    @Autowired
    ProductPurchaseRecordMapper productPurchaseRecordMapper;
    @Autowired
    SysUserService sysUserService;

    @Override
    public ResultBean save(PurchasePlanDTO model) {
        String purchaseNo = "cgjh_" + RandomUtils.orderNoStr();
        List<PurchasePlan> purchasePlanList = new ArrayList<>();
        List<ProductPurchaseRecord> productPurchaseRecordList = new ArrayList<>();
        for (PurchasePlanItem purchasePlanItem : model.getMaterialList()) {
            // 采购计划
            PurchasePlan purchasePlan = new PurchasePlan();
            purchasePlan.setMaterialGraphNo(purchasePlanItem.getMaterialGraphNo());
            purchasePlan.setNumber(purchasePlanItem.getNumber());
            purchasePlan.setExpectedTime(DateFormatterUtils.parseDateString(DateFormatterUtils.ONE_FORMATTERPATTERN, model.getExpectedTime()));
            purchasePlan.setProductOrderNo(model.getProductOrderNo());
            purchasePlan.setPurchasePlanNo(purchaseNo);
            purchasePlan.setCreateUserId(getLoginUserId());
            purchasePlanList.add(purchasePlan);
            // 采购计划记录
            ProductPurchaseRecord productPurchaseRecord = new ProductPurchaseRecord();
            productPurchaseRecord.setMaterialGraphNo(purchasePlanItem.getMaterialGraphNo());
            productPurchaseRecord.setPurchasePlanNo(purchaseNo);
            productPurchaseRecord.setProductOrderNo(model.getProductOrderNo());
            productPurchaseRecordList.add(productPurchaseRecord);
        }
        purchasePlanMapper.insertPurchasePlanBatch(purchasePlanList);
        productPurchaseRecordMapper.batchInsertProductPurchaseRecord(productPurchaseRecordList);
        return ResultBean.success(purchaseNo);
    }

    @Override
    public ResultBean delete(String purchasePlanNo) {
        if(StringUtils.isAnyEmpty(purchasePlanNo)) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        // 删除 采购计划元数据
        PurchasePlanExample purchasePlanExample = new PurchasePlanExample();
        purchasePlanExample.or().andPurchasePlanNoEqualTo(purchasePlanNo);
        PurchasePlan purchasePlan = new PurchasePlan();
        purchasePlan.setIsDelete(CommonEnum.Consts.YES.code);
        int delete = purchasePlanMapper.updateByExampleSelective(purchasePlan, purchasePlanExample);
        // 删除采购记录表记录
        ProductPurchaseRecordExample productPurchaseRecordExample = new ProductPurchaseRecordExample();
        productPurchaseRecordExample.or().andPurchasePlanNoEqualTo(purchasePlanNo);
        productPurchaseRecordMapper.deleteByExample(productPurchaseRecordExample);
        return ResultBean.success(delete);
    }

    @Override
    public ResultBean deleteItem(String purchasePlanNo, String materialGraphNo) {
        if(StringUtils.isAnyEmpty(purchasePlanNo,materialGraphNo)) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        PurchasePlanExample purchasePlanExample = new PurchasePlanExample();
        purchasePlanExample.or().andPurchasePlanNoEqualTo(purchasePlanNo).andMaterialGraphNoEqualTo(materialGraphNo);
        PurchasePlan purchasePlan = new PurchasePlan();
        purchasePlan.setIsDelete(CommonEnum.Consts.YES.code);
        int delete = purchasePlanMapper.updateByExampleSelective(purchasePlan, purchasePlanExample);
        // 删除采购记录表记录
        ProductPurchaseRecordExample productPurchaseRecordExample = new ProductPurchaseRecordExample();
        productPurchaseRecordExample.or().andPurchasePlanNoEqualTo(purchasePlanNo).andMaterialGraphNoEqualTo(materialGraphNo);
        productPurchaseRecordMapper.deleteByExample(productPurchaseRecordExample);
        return ResultBean.success(delete);
    }

    @Override
    public ResultBean updatePurchaseItem(PurchasePlanDTO model) {
        if (StringUtils.isAnyEmpty(model.getPurchasePlanNo()) || null == model.getMaterialList() || 0 == model.getMaterialList().size()) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        PurchasePlanExample purchasePlanExample = new PurchasePlanExample();
        purchasePlanExample.or().andPurchasePlanNoEqualTo(model.getPurchasePlanNo()).andMaterialGraphNoEqualTo(model.getMaterialList().get(0)
                .getMaterialGraphNo());
        PurchasePlan purchasePlan = new PurchasePlan();
        purchasePlan.setNumber(model.getMaterialList().get(0).getNumber());
        int update = purchasePlanMapper.updateByExampleSelective(purchasePlan, purchasePlanExample);
        return ResultBean.success(update);
    }

    @Override
    public ResultBean updateExpectedTime(PurchasePlanDTO model) {
        if (StringUtils.isAnyEmpty(model.getExpectedTime(), model.getPurchasePlanNo())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        PurchasePlanExample purchasePlanExample = new PurchasePlanExample();
        purchasePlanExample.or().andPurchasePlanNoEqualTo(model.getPurchasePlanNo());
        PurchasePlan purchasePlan = new PurchasePlan();
        purchasePlan.setExpectedTime(DateFormatterUtils.parseDateString(DateFormatterUtils.ONE_FORMATTERPATTERN, model.getExpectedTime()));
        int update = purchasePlanMapper.updateByExampleSelective(purchasePlan, purchasePlanExample);
        return ResultBean.success(update);
    }

    /**
     *
     * @param currentPage
     * @param pageSize
     * @param productOrderNo
     * @return
     */
    @Override
    public ResultBean getList(Integer currentPage, Integer pageSize, String productOrderNo) {
        PageInfo<PurchasePlan> pageData = PageHelper.startPage(currentPage, pageSize)
                .doSelectPageInfo(() -> purchasePlanMapper.selectWithGroupBy(productOrderNo));
        return ResultBean.success(pageData);
    }

    @Override
    public ResultBean getInfo(String purchasePlanNo) {
        PurchasePlanExample purchasePlanExample = new PurchasePlanExample();
        purchasePlanExample.or().andPurchasePlanNoEqualTo(purchasePlanNo);
        List<PurchasePlan> purchasePlanList = purchasePlanMapper.selectByExample(purchasePlanExample);
        PurchasePlan purchasePlan = purchasePlanList.get(0);
        PurchasePlanDTO purchasePlanDTO = new PurchasePlanDTO();
        purchasePlanDTO.setExpectedTime(DateFormatterUtils
                .formatterDateString(DateFormatterUtils.ONE_FORMATTERPATTERN, purchasePlan.getExpectedTime()));
        purchasePlanDTO.setProductOrderNo(purchasePlan.getProductOrderNo());
        purchasePlanDTO.setPurchasePlanNo(purchasePlan.getPurchasePlanNo());
        List<PurchasePlanItem> items = new ArrayList<>();
        for (PurchasePlan p : purchasePlanList) {
            PurchasePlanItem purchasePlanItem = new PurchasePlanItem();
            purchasePlanItem.setMaterialGraphNo(p.getMaterialGraphNo());
            purchasePlanItem.setNumber(p.getNumber());
            items.add(purchasePlanItem);
        }
        purchasePlanDTO.setMaterialList(items);
        return ResultBean.success(purchasePlanDTO);
    }

    /**
     * 获取登录用户id
     *
     * @return
     */
    private int getLoginUserId() {
        CustomUser customUser = sysUserService.selectLoginUser();
        return customUser != null ? customUser.getId() : 1;
    }
}
