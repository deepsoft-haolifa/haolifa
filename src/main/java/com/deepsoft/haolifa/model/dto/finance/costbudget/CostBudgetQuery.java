package com.deepsoft.haolifa.model.dto.finance.costbudget;


import com.deepsoft.haolifa.enums.CostBudgetTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 费用预算
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class CostBudgetQuery {

    @ApiModelProperty(value = "预算类型")
    private CostBudgetTypeEnum costBudgetTypeEnum;

    @ApiModelProperty(value = "部门ID")
    private Integer deptId;

    @ApiModelProperty(value = "科目ID （二级科目）")
    private Integer subjectsId;

}
