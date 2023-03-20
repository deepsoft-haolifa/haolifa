package com.deepsoft.haolifa.model.dto.finance.loanapply;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class LoanApplySumRSDTO {

    @ApiModelProperty(value = "借款金额")
    private BigDecimal amountSum;

    @ApiModelProperty(value = "余欠金额 = 借款金额 - 还款总金额")
    private BigDecimal owedAmountSum;

}
