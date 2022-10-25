package com.deepsoft.haolifa.model.dto.finance.costbudget.dept;


import com.deepsoft.haolifa.model.domain.BizCostBudgetDept;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 部门预算
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class CostBudgetDeptRSDTO {
    @ApiModelProperty(value = "ID")
    private Integer id;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "部门ID")
    private Integer deptId;
    @ApiModelProperty(value = "父部门ID")
    private Integer deptPid;
    @ApiModelProperty(value = "比例 1~100")
    private Double costRatio;
    @ApiModelProperty(value = "计算公式")
    private String costRatioFormula;
    @ApiModelProperty(value = "计算公式中文")
    private String costRatioFormulaCN;
    @ApiModelProperty(value = "状态 1 正常 2 禁用")
    private String status;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "创建者")
    private Integer createUser;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "更新者")
    private Integer updateUser;
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}
