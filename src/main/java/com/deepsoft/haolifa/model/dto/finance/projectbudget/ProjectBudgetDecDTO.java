package com.deepsoft.haolifa.model.dto.finance.projectbudget;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProjectBudgetDecDTO {

    @ApiModelProperty(value = "ID")
    private Long id;


    @ApiModelProperty(value = "剩余额度")
    private BigDecimal balanceQuota;


}
