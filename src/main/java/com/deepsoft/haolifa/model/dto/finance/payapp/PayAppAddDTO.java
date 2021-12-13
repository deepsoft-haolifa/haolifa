package com.deepsoft.haolifa.model.dto.finance.payapp;

import com.deepsoft.haolifa.model.dto.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/***
 * 付款申请-添加
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PayAppAddDTO extends PageParam {



    @ApiModelProperty(value = "付款申请Id")
    private Long payDataId;

    @ApiModelProperty(value = "申请编号")
    private String applyNo;

    @ApiModelProperty(value = "申请日期")
    private Date applyDate;

    @ApiModelProperty(value = "采购合同ID")
    private String contractId;

    @ApiModelProperty(value = "采购合同号")
    private String contractNo;

    @ApiModelProperty(value = "采购合同付款方式")
    private String contractPayWay;

    @ApiModelProperty(value = "申请付款单位")
    private String applyPayCompany;

    @ApiModelProperty(value = "收款单位")
    private String applyCollectionCompany;

    @ApiModelProperty(value = "付款金额")
    private BigDecimal applyAmount;

    @ApiModelProperty(value = "付款单位")
    private String payCompany;

    @ApiModelProperty(value = "付款账号")
    private String payAccount;

    @ApiModelProperty(value = "付款方式;")
    private String payWay;

    @ApiModelProperty(value = "付款类型:默认是货款")
    private String paymentType;

    @ApiModelProperty(value = "付款状态 0.未付；1.付款中 2已付款")
    private String status;

    @ApiModelProperty(value = "付款日期")
    private Date payDate;

    @ApiModelProperty(value = "付款渠道：1.现金日记账；2.银行日记账；")
    private String bookingType;



    @ApiModelProperty(value = "数据状态：1. 老总选择； 2. 财务主管选择；3.出纳付款")
    private String dataStatus;

    @ApiModelProperty(value = "备注")
    private String remark;


}
