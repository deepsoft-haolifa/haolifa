package com.deepsoft.haolifa.model.vo;

import lombok.Data;

/**
 * @author murphy.he
 **/
@Data
public class OrderProductStatisticVo {
    /**
     * 订单数量
     */
    private Integer orderQty;
    /**
     * 已发货订单数量
     */
    private Integer deliveryOrderQty;

}
