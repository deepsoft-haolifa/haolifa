package com.deepsoft.haolifa.model.dto.finance.costbudget.dept;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 部门预算
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CostBudgetDeptAddUpDTO {
    @ApiModelProperty(value = "部门ID")
    private Integer deptId;
    @ApiModelProperty(value = "比例 1~100")
    private Double costRatio;
    @ApiModelProperty(value = "备注")
    private String remark;
}
