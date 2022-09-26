package com.deepsoft.haolifa.model.dto.finance.loanapply;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class LoanApplyInfoRSDTO {
    @ApiModelProperty(value = "ID")
    private Integer id;

    @ApiModelProperty(value = "编号")
    private String serialNo;

    @ApiModelProperty(value = "借款部门id")
    private Integer deptId;
    @ApiModelProperty(value = "借款部门名称")
    private String deptName;

    @ApiModelProperty(value = "借款日期")
    private Date loanDate;

    @ApiModelProperty(value = "预计还款日期")
    private Date expectRepaymentDate;

    @ApiModelProperty(value = "借款金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "用途")
    private String purpose;

    @ApiModelProperty(value = "借款人id")
    private Integer loanUser;

    @ApiModelProperty(value = "借款人名称")
    private String loanUserName;

    @ApiModelProperty(value = "借款人编号")
    private String loanUserNo;

    @ApiModelProperty(value = "资金性质（1現金 2支票）")
    private String amountType;

    @ApiModelProperty(value = "资金性质中文")
    private String amountTypeCN;

    @ApiModelProperty(value = "记账方式（1現金 2銀行 3 其他貨幣）")
    private String billNature;

    @ApiModelProperty(value = "记账方式中文")
    private String billNatureCN;

    @ApiModelProperty(value = "户名")
    private String accountName;

    @ApiModelProperty(value = "卡号")
    private String cardNumber;

    @ApiModelProperty(value = "开户行")
    private String bankOfDeposit;

    @ApiModelProperty(value = "审批节点")
    private String applyStatus;

    @ApiModelProperty(value = "审批节点中文")
    private String applyStatusCN;

    @ApiModelProperty(value = "付款单位")
    private String payCompany;

    @ApiModelProperty(value = "付款单位Id")
    private String payCompanyId;

    @ApiModelProperty(value = "付款账户")
    private String payAccount;

    @ApiModelProperty(value = "付款日期")
    private Date payTime;

    @ApiModelProperty(value = "付款状态（1未付款 2付款中 3付款完成）")
    private String payStatus;

    @ApiModelProperty(value = "付款状态中文")
    private String payStatusCN;

    @ApiModelProperty(value = "备注摘要")
    private String remark;


    @ApiModelProperty(value = "支付类型 1 对公 2 对私 三期新增字段")
    private String payType;

    @ApiModelProperty(value = "支付类型 1 对公 2 对私 三期新增字段")
    private String payTypeCN;

    @ApiModelProperty(value = "项目编号 三期新增字段")
    private String projectCode;

    @ApiModelProperty(value = "项目编号 三期新增字段")
    private String projectCodeName;

    @ApiModelProperty(value = "是否差旅借款 1 是 2 否 三期新增字段")
    private String travelFlag;

    @ApiModelProperty(value = "是否差旅借款 1 是 2 否 三期新增字段")
    private String travelFlagCN;

    @ApiModelProperty(value = "出差地点 三期新增字段")
    private String travelArrAddress;

    @ApiModelProperty(value = "出差天数 三期新增字段")
    private Integer travelDays;

    @ApiModelProperty(value = "出差人数 三期新增字段")
    private Integer travelPeoNum;


}
