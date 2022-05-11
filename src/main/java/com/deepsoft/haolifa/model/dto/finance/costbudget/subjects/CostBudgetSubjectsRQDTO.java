package com.deepsoft.haolifa.model.dto.finance.costbudget.subjects;


import com.deepsoft.haolifa.model.dto.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 科目预算
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CostBudgetSubjectsRQDTO  extends PageParam {

    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "部门ID")
    private Integer deptId;
    @ApiModelProperty(value = "部门名称")
    private String deptName;
    @ApiModelProperty(value = "科目ID （二级科目）")
    private Integer subjectsId;

    @ApiModelProperty(value = "科目类别")
    private String subjectsTypeCode;
}
