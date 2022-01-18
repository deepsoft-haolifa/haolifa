package com.deepsoft.haolifa.model.dto.finance.costbudget.dept;

import com.deepsoft.haolifa.util.TreeEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class CostBudgetDeptTree implements TreeEntity<CostBudgetDeptTree> {
    public String id;
    public String name;
    public String parentId;
    public String no;
    public String description;
    @ApiModelProperty(value = "比例 1~100")
    private Integer costRatio;
    @ApiModelProperty(value = "计算公式")
    private String costRatioFormula;
    @ApiModelProperty(value = "计算公式中文")
    private String costRatioFormulaCN;
    public List<CostBudgetDeptTree> childList;

}
