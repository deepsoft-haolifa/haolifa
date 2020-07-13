package com.deepsoft.haolifa.model.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author murphy.he
 **/
@Data
public class PurchaseAmountStatisticVo {
    /**
     * 合同总金额
     */
    private BigDecimal totalPrice;
    /**
     * 已付货款
     */
    private BigDecimal paidAccount;

}
