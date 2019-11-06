package com.deepsoft.haolifa.dao.repository.extend;

import org.apache.ibatis.annotations.Select;

/**
 * 统计
 *
 * @author murphy.he
 **/
public interface StatisticsExtendMapper {

    /**
     * 生产订单总金额
     */
    @Select("SELECT ROUND(sum(total_price),2) FROM `order_product`")
    Double sumOrderTotal();
    /**
     * 采购订单总金额
     */
    @Select("SELECT ROUND(sum(total_price),2) FROM `purchase_order`")
    Double sumPurchaseTotal();
}
