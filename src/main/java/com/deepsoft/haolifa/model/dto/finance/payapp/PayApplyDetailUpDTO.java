package com.deepsoft.haolifa.model.dto.finance.payapp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/***
 * 付款申请-详情-添加
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PayApplyDetailUpDTO {

    @ApiModelProperty(value = "ID")
    private Integer id;
    @ApiModelProperty(value = "金额")
    private BigDecimal price;
    @ApiModelProperty(value = "订单ID")
    private Integer purchaseOrderId;
    @ApiModelProperty(value = "订单号")
    private String purchaseOrderNo;
    @ApiModelProperty(value = "付款类型")
    private String payType;
    @ApiModelProperty(value = "付款单位")
    private String applyPayCompany;
    @ApiModelProperty(value = "收款单位")
    private String applyCollectionCompany;
    @ApiModelProperty(value = "备注")
    private String remark;

}
