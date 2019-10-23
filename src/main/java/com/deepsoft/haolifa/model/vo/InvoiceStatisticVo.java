package com.deepsoft.haolifa.model.vo;

import lombok.Data;

/**
 * @author murphy.he
 **/
@Data
public class InvoiceStatisticVo {
    /**
     * 全部金额
     */
    private Double totalAmount;
    /**
     * 未开票金额
     */
    private Double notInvoicedAmount;
    /**
     * 开票金额
     */
    private Double invoicedAmount;
}
