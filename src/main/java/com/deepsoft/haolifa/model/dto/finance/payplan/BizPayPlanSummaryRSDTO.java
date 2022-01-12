package com.deepsoft.haolifa.model.dto.finance.payplan;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/***
 *  应付汇总 rs
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BizPayPlanSummaryRSDTO {

    @ApiModelProperty(value = "供应商")
    private String supplierName;
    @ApiModelProperty(value = "需求方")
    private String  demander;
    @ApiModelProperty(value = "累计订货额")
    private BigDecimal     totalPrice;
    @ApiModelProperty(value = "累计欠款额")
    private BigDecimal    arrearPrice;
    @ApiModelProperty(value = "累计入账额")
    private BigDecimal   entryPrice;
    @ApiModelProperty(value = "已付货款")
    private BigDecimal    paidAccount;
    @ApiModelProperty(value = "计划付款额")
    private BigDecimal    applyAmount;

}
