package com.deepsoft.haolifa.model.dto.finance.loanapply;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class LoanApplyAddDTO {
    @ApiModelProperty(value = "借款部门id")
    private Integer deptId;

    @ApiModelProperty(value = "支付类型 1 对公 2 对私 三期新增字段")
    private String payType;

    @ApiModelProperty(value = "项目编号 三期新增字段")
    private String projectCode;

    @ApiModelProperty(value = "是否差旅借款 1 是 2 否 三期新增字段")
    private String travelFlag;

    @ApiModelProperty(value = "出差地点 三期新增字段")
    private String travelArrAddress;

    @ApiModelProperty(value = "出差天数 三期新增字段")
    private Integer travelDays;

    @ApiModelProperty(value = "出差人数 三期新增字段")
    private Integer travelPeoNum;



    @ApiModelProperty(value = "借款日期")
    private Date loanDate;

    @ApiModelProperty(value = "预计还款日期")
    private Date expectRepaymentDate;

    @ApiModelProperty(value = "借款金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "用途")
    private String purpose;

    @ApiModelProperty(value = "资金性质（1現金 2支票）")
    private String amountType;

    @ApiModelProperty(value = "户名")
    private String accountName;

    @ApiModelProperty(value = "卡号")
    private String cardNumber;

    @ApiModelProperty(value = "开户行")
    private String bankOfDeposit;

    @ApiModelProperty(value = "备注摘要")
    private String remark;

}
