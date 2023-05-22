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

    // （1現金 2銀行 3 其他貨幣）
    @ApiModelProperty(value = "转出方式 1 现金、2 电汇、3 其它货币")
    private String transferType;

    @ApiModelProperty(value = "转账金额")
    private BigDecimal payment;

    @ApiModelProperty(value = "备注摘要")
    private String remark;

}
