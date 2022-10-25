package com.deepsoft.haolifa.model.dto.finance.payapp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/***
 * 付款申请-详情
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PayApplyDetailRSDTO {

    @ApiModelProperty(value = "ID")
    private Integer id;
    @ApiModelProperty(value = "付款申请ID")
    private Long payApplyId;
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
    @ApiModelProperty(value = "删除标志（0代表存在 2代表删除）")
    private String delFlag;
    @ApiModelProperty(value = "创建者")
    private Integer createUser;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "更新者")
    private Integer updateUser;
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}
