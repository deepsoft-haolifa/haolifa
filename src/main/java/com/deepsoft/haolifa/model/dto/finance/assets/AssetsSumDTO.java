package com.deepsoft.haolifa.model.dto.finance.assets;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = false)
public class AssetsSumDTO {


    /**
     * 采购总金额
     */
    @ApiModelProperty(value = "资产合计 (采购金额的合计)")
    private BigDecimal totalPrice;


    @ApiModelProperty(value = "累计折旧 (累计折旧合计)")
    private BigDecimal accumulatedDepreciation;


    @ApiModelProperty(value = "资产净值 (净值的合计)")
    private BigDecimal netWorth;


}
