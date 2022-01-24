package com.deepsoft.haolifa.model.dto.finance.loanapply;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class LoanApplyUpDTO {
    @ApiModelProperty(value = "ID")
    private Integer id;

    @ApiModelProperty(value = "借款部门id")
    private Integer deptId;

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
