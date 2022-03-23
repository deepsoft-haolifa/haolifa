package com.deepsoft.haolifa.model.dto.finance.costbudget;


import com.deepsoft.haolifa.enums.CostBudgetTypeEnum;
import com.deepsoft.haolifa.model.dto.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 费用预算
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class CostBudget  {

    @ApiModelProperty(value = "比例 1~100")
    private BigDecimal costRatio;
    @ApiModelProperty(value = "预算金额")
    private BigDecimal amount;
    @ApiModelProperty(value = "计算公式")
    private String costRatioFormula;
    @ApiModelProperty(value = "计算公式中文")
    private String costRatioFormulaCN;

    @ApiModelProperty(value = "预算详情")
    private List<CostBudgetDetail> costBudgetDetailList;
    @Data
    @EqualsAndHashCode(callSuper=false)
    public static class CostBudgetDetail{
        @ApiModelProperty(value = "比例 1~100")
        private BigDecimal costRatio;

        @ApiModelProperty(value = "预算类型")
        private CostBudgetTypeEnum costBudgetTypeEnum;

        private Integer deptId;

        private String deptName;

        private String subjectsName;

        private Integer subjectsId;

    }


}
