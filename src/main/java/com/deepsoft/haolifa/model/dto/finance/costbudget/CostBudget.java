package com.deepsoft.haolifa.model.dto.finance.costbudget;


import com.deepsoft.haolifa.model.dto.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 费用预算
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class CostBudget  {

    @ApiModelProperty(value = "比例 1~100")
    private Integer costRatio;
    @ApiModelProperty(value = "计算公式")
    private String costRatioFormula;
    @ApiModelProperty(value = "计算公式中文")
    private String costRatioFormulaCN;
}
