package com.deepsoft.haolifa.model.dto.finance.costbudget.subjects;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 科目预算
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CostBudgetSubjectsAddDTO {

    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "部门ID")
    private Integer deptId;
    @ApiModelProperty(value = "科目ID （二级科目）")
    private Integer subjectsId;
    @ApiModelProperty(value = "比例 1~100")
    private Double costRatio;
//    @ApiModelProperty(value = "状态 1 正常 2 禁用")
//    private String status;
    @ApiModelProperty(value = "备注")
    private String remark;

}
