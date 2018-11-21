package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.PurchaseOrderDTO;
import com.deepsoft.haolifa.model.dto.PurchaseOrderListDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;

public interface PurcahseOrderService {
    /**
     * 创建采购订单
     * @param model
     * @return
     */
    ResultBean save(PurchaseOrderDTO model);

    /**
     * 删除采购订单
     * @param purchaseOrderNo
     * @return
     */
    ResultBean delete(String purchaseOrderNo);

    /**
     * 删除采购订单单项
     * @param purchaseOrderNo
     * @param materialGraphNo
     * @return
     */
    ResultBean deleteItem(String purchaseOrderNo, String materialGraphNo);

    /**
     * 更新采购单
     * @param model
     * @return
     */
    ResultBean update(PurchaseOrderDTO model);

    /**
     * 获取采购订单详情
     * @param id
     * @return
     */
    ResultBean getInfo(Integer id);

    /**
     * 获取列表
     * @param model
     * @return
     */
    ResultBean getList(PurchaseOrderListDTO model);
}
