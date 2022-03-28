package com.deepsoft.haolifa.model.dto.finance.costbudget.dept;

import com.deepsoft.haolifa.util.TreeEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class CostBudgetDeptTree implements TreeEntity<CostBudgetDeptTree> {
    @ApiModelProperty(value = "部门ID")
    public String id;
    @ApiModelProperty(value = "部门名称")
    public String name;
    @ApiModelProperty(value = "父部门ID")
    public String parentId;
    @ApiModelProperty(value = "部门代码")
    public String no;
    @ApiModelProperty(value = "描述")
    public String description;
    @ApiModelProperty(value = "费用预算比例 1~100")
    private Double costRatio;
    @ApiModelProperty(value = "费用预算计算公式")
    private String costRatioFormula;
    @ApiModelProperty(value = "费用预算计算公式中文")
    private String costRatioFormulaCN;
    @ApiModelProperty(value = "子部门")
    public List<CostBudgetDeptTree> childList;
    @ApiModelProperty(value = "备注")
    private String remark;

}
