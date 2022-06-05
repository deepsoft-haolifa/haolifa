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
public class ContractBillDecomposeAmountRQDTO {

    @ApiModelProperty(value = "记账类型 0||null 全部 2.银行日记账；3.其他货币日记账")
    private String billType;
    @ApiModelProperty(value = "billId")
    private Integer billId;


}
