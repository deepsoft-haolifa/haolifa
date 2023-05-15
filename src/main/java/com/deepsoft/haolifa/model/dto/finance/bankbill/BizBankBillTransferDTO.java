package com.deepsoft.haolifa.model.dto.finance.bankbill;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/***
 * 银行日记账-转账
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BizBankBillTransferDTO {

    @ApiModelProperty(value = "来源账户")
    private String sourceAccount;

    @ApiModelProperty(value = "目标账户")
    private String targetAccount;

    @ApiModelProperty(value = "转账金额")
    private BigDecimal payment;

    @ApiModelProperty(value = "备注摘要")
    private String remark;

}
