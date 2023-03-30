package com.deepsoft.haolifa.model.dto.finance.bill;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 现金日记账
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BizBillAddDTO {


    @ApiModelProperty(value = "序号")
    private String xh;
    @ApiModelProperty(value = "日期")
    private Date d;
    @ApiModelProperty(value = "凭证号")
    private String certificateNumber;
    @ApiModelProperty(value = "结算类别")
    private String settlementType;
    @ApiModelProperty(value = "结算票号")
    private String clearingBanks;
    @ApiModelProperty(value = "上月结转")
    private BigDecimal preMonthMoney;
    @ApiModelProperty(value = "收款")
    private BigDecimal collectionMoney;
    @ApiModelProperty(value = "收款类别")
    private String collectionType;
    @ApiModelProperty(value = "付款")
    private BigDecimal payment;
    @ApiModelProperty(value = "付款类别")
    private String paymentType;
    @ApiModelProperty(value = "余额")
    private BigDecimal balance;
    @ApiModelProperty(value = "类型 1=现金日记账 2=银行日记账")
    private String type;
    @ApiModelProperty(value = "部门ID")
    private String deptId;
    @ApiModelProperty(value = "备用")
    private String string1;
    @ApiModelProperty(value = "备用")
    private String string2;
    @ApiModelProperty(value = "备用")
    private String string3;
    @ApiModelProperty(value = "备用")
    private String string4;
    @ApiModelProperty(value = "备用")
    private String string5;
    @ApiModelProperty(value = "备用")
    private String string6;
    @ApiModelProperty(value = "备用")
    private String string7;
    @ApiModelProperty(value = "备用")
    private String string8;
    @ApiModelProperty(value = "备用")
    private String string9;
    @ApiModelProperty(value = "备用")
    private String string10;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "状态（0正常 1停用）")
    private String status;


    @ApiModelProperty(value = "项目编号")
    private String projectCode;

    @ApiModelProperty(value = "科目ID")
    private Integer subject;

}
