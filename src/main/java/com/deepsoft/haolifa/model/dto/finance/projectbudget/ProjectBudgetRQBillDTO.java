package com.deepsoft.haolifa.model.dto.finance.projectbudget;

import com.deepsoft.haolifa.model.dto.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProjectBudgetRQBillDTO {
    @ApiModelProperty(value = "所属部门")
    private Integer deptId;
}
