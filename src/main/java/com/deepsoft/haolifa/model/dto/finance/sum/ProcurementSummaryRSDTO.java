package com.deepsoft.haolifa.model.dto.finance.sum;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 合同汇总的返回实体
 * @author murphy.he
 **/
@Data
public class ProcurementSummaryRSDTO {

    /**
     * 供应商
     */
    @ApiModelProperty(value = "供应商")
    private String supplierName;

    /**
     * 供应商
     */
    @ApiModelProperty(value = "供应商")
    private String supplierId;
    /**
     * 合同额
     */
    @ApiModelProperty(value = "合同额")
    private Double contractAmount;

    /**
     * 入账额
     */
    @ApiModelProperty(value = "入账额")
    private Double entryAmount;

    /**
     * 入账欠款
     */
    @ApiModelProperty(value = "入账欠款")
    private Double entryOweAmount;
    /**
     * 已付款
     */
    @ApiModelProperty(value = "已付款")
    private Double paidAmount;
    /**
     * 回票欠款
     */
    @ApiModelProperty(value = "回票欠款")
    private Double needInvoiceAmount;
    /**
     * 已开票
     */
    @ApiModelProperty(value = "已开票")
    private Double invoicedAmount;

    /**
     * 入账欠票
     */
    @ApiModelProperty(value = "入账欠票")
    private Double entryOweInvoiceAmount;



}
