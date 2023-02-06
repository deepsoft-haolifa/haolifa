package com.deepsoft.haolifa.model.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author murphy.he
 **/
@Data
public class InvoiceStatisticVo {
    /**
     * 全部金额
     */
    private BigDecimal totalAmount;
    /**
     * 未开票金额
     */
    private BigDecimal notInvoicedAmount;
    /**
     * 开票金额
     */
    private BigDecimal invoicedAmount;
}
