package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.PurchasePlanDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;

public interface PurchasePlanService {
    /**
     * 创建采购计划
     * @param model
     * @return
     */
    ResultBean save(PurchasePlanDTO model);

    /**
     * 删除采购计划
     * @param purchasePlanNo
     * @return
     */
    ResultBean delete(String purchasePlanNo);

    /**
     * 删除采购计划子项
     * @param purchasePlanNo
     * @param ,materialGraphNo
     * @return
     */
    ResultBean deleteItem(String purchasePlanNo,String materialGraphNo);

    /**
     * 获取列表
     * @param currentPage
     * @param pageSize
     * @param productOrderNo
     * @return
     */
    ResultBean getList(Integer currentPage, Integer pageSize, String productOrderNo);

    /**
     * 获取详情
     * @param purchasePlanNo
     * @return
     */
    ResultBean getInfo(String purchasePlanNo);

    /**
     * 更新采购期望时间
     * @param model
     * @return
     */
    ResultBean updateExpectedTime(PurchasePlanDTO model);

    /**
     * 更新采购单项
     * @param model
     * @return
     */
    ResultBean updatePurchaseItem(PurchasePlanDTO model);
}
