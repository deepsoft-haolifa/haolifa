package com.deepsoft.haolifa.model.dto.finance.contract;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/***
 * 日记账
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ContractBillDecomposeAmountRSDTO {

    @ApiModelProperty(value = "记账类型 0||null 全部 2.银行日记账；3.其他货币日记账")
    private String billType;
    @ApiModelProperty(value = "billId")
    private Integer billId;

    @ApiModelProperty(value = "收款合同分解状态；0未完成；1.完成")
    private String contractStatus;
    @ApiModelProperty(value = "收款合同分解状态；0未完成；1.完成")
    private String contractStatusCN;

    @ApiModelProperty(value = "总金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "已分解金额")
    private BigDecimal decomposeAmount;

    @ApiModelProperty(value = "剩余分解金额")
    private BigDecimal surplusAmount;

}
