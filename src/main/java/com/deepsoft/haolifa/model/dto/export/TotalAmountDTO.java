package com.deepsoft.haolifa.model.dto.export;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 累计金额
 *
 * @author murphy.he
 **/
@Data
public class TotalAmountDTO {

    @ApiModelProperty("累计合同金额")
    private BigDecimal totalSaleAmount;
    @ApiModelProperty("累计回款金额")
    private BigDecimal totalCollectAmount;
    @ApiModelProperty("累计欠款金额")
    private BigDecimal totalOwedAmount;

}
