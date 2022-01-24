package com.deepsoft.haolifa.model.dto.finance.reimburseapply;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ReimburseApplyPayDTO {
    @ApiModelProperty(value = "ID")
    private Integer id;

    @ApiModelProperty(value = "记账方式（1現金 2銀行 3 其他貨幣）")
    private String billNature;

    @ApiModelProperty(value = "付款单位")
    private String payCompany;

//    @ApiModelProperty(value = "付款单位Id")
//    private String payCompanyId;

    @ApiModelProperty(value = "付款账户")
    private String payAccount;



}
