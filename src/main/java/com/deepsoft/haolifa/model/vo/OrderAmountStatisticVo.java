package com.deepsoft.haolifa.model.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author murphy.he
 **/
@Data
public class OrderAmountStatisticVo {
    /**
     * 合同总金额
     */
    private BigDecimal orderAmount;
    /**
     * 已收货款
     */
    private BigDecimal receivedAmount;

}
