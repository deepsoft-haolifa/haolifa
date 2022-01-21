package com.deepsoft.haolifa.model.dto.finance.costbudget.subjects;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 科目预算
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CostBudgetSubjectsDelBatchDTO {

    @ApiModelProperty(value = "ids")
    private List<Integer> ids;

}
