package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.ApplyBuyDTO;
import com.deepsoft.haolifa.model.dto.ApplyBuyUpdateDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.StoreKeeperApplyBuyDTO;

import java.util.List;

public interface ApplyBuyService {
    /**
     * 保存请购单by请购计划
     * @param modelList
     * @return
     */
    ResultBean saveByPurchasePlan(List<ApplyBuyDTO> modelList);

    /**
     * 保存请购单by库管
     * @param modelList
     * @return
     */
    ResultBean saveByStoreKeeper(List<StoreKeeperApplyBuyDTO> modelList);

    /**
     * 删除请购单
     * @param applyBuyNo
     * @return
     */
    ResultBean delete(String applyBuyNo);

    /**
     * 更新请购单项
     * @param model
     * @return
     */
    ResultBean update(ApplyBuyUpdateDTO model);

    /**
     * 获取请购详情
     * @param applyBuyNo
     * @return
     */
    ResultBean getInfo(String applyBuyNo);

    /**
     * 获取请购单列表
     * @param currentPage
     * @param pageSize
     * @return
     */
    ResultBean getList(Integer currentPage, Integer pageSize);

    /**
     * 删除请购单单项
     * @param applyBuyNo
     * @param materialGraphNo
     * @return
     */
    ResultBean deleteItem(String applyBuyNo, String materialGraphNo);
}
