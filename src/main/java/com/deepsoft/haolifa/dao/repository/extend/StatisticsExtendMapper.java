package com.deepsoft.haolifa.dao.repository.extend;

import com.deepsoft.haolifa.model.vo.InvoiceStatisticVo;
import com.deepsoft.haolifa.model.vo.OrderAmountStatisticVo;
import com.deepsoft.haolifa.model.vo.PurchaseAmountStatisticVo;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 统计
 *
 * @author murphy.he
 **/
public interface StatisticsExtendMapper {

    /**
     * 生产订单总金额
     */
//    @Select("SELECT ROUND(sum(total_price),2) FROM `order_product`")
    OrderAmountStatisticVo sumOrderTotal(Map<String, Object> objectMap);
    /**
     * 采购订单总金额
     */
//    @Select("SELECT ROUND(sum(total_price),2) FROM `purchase_order`")
    PurchaseAmountStatisticVo sumPurchaseTotal(Map<String, Object> objectMap);


    BigDecimal sumInvoiceTotal(Map<String, Object> objectMap);
}
