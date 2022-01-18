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
public class CostBudgetDeptAddDTO {

    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "部门ID")
    private Integer deptId;
    @ApiModelProperty(value = "父部门ID")
    private Integer deptPid;
    @ApiModelProperty(value = "比例 1~100")
    private Integer costRatio;

    private String costRatioFormulaCN;
    @ApiModelProperty(value = "状态 1 正常 2 禁用")
    private String status;
    @ApiModelProperty(value = "备注")
    private String remark;

}
