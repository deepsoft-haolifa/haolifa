package com.deepsoft.haolifa.model.dto.finance.contract;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class ContractListRSDTO {


    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "rs-合同编号")
    private String orderContractNo;

    @ApiModelProperty(value = "s-订单状态")
    private Byte orderStatus;



    @ApiModelProperty(value = "rs-需求方名称")
    private String demandName;

    @ApiModelProperty(value = "需求方代理人")
    private String demandAgentName;

    @ApiModelProperty(value = "需求方电话")
    private String demandPhone;

    @ApiModelProperty(value = "需求方传真")
    private String demandFax;

    @ApiModelProperty(value = "需求开户银行")
    private String demandBankName;

    @ApiModelProperty(value = "需求开户银行账号")
    private String demandBankCardNo;



    @ApiModelProperty(value = "rs-合同签订日期")
    private String contractSignDate;



    @ApiModelProperty(value = "rs-供应方")
    private String supplyName;

    @ApiModelProperty(value = "rs-供应方代理人")
    private String supplyAgentName;

    @ApiModelProperty(value = "供应方电话")
    private String supplyPhone;

    @ApiModelProperty(value = "供应方传真")
    private String supplyFax;

    @ApiModelProperty(value = "供应方开户银行")
    private String supplyBankName;

    @ApiModelProperty(value = "供应方开户银行账号")
    private String contractBankCardNo;



    @ApiModelProperty(value = "交货地点")
    private String deliveryPlace;

    @ApiModelProperty(value = "交货日期")
    private String deliveryDate;


    @ApiModelProperty(value = "s-数量合计")
    private Integer totalCount;

    @ApiModelProperty(value = "s-已发货数量")
    private Integer deliveredNumber;

    @ApiModelProperty(value = "s-总价")
    private BigDecimal totalPrice;

    @ApiModelProperty(value = "s-已收货款")
    private BigDecimal receivedAccount;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "发货状态：0 待发货（默认） 1 部分发货 2 发货完成")
    private Byte deliverStatus;

    @ApiModelProperty(value = "任务状态 0：未分配；1：已分配")
    private Byte taskStatus;
}
