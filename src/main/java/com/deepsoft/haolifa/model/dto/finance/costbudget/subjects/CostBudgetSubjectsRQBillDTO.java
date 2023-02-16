package com.deepsoft.haolifa.model.dto.finance.costbudget.subjects;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CostBudgetSubjectsRQBillDTO {
    @ApiModelProperty(value = "所属部门")
    private Integer deptId;
}
