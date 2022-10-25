package com.deepsoft.haolifa.model.dto.finance.costbudget.dept;


import com.deepsoft.haolifa.model.dto.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 部门预算
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CostBudgetDeptRQDTO  extends PageParam {

    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "部门ID")
    private Integer deptId;
    @ApiModelProperty(value = "父部门ID")
    private Integer deptPid;

}
