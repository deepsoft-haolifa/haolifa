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
@EqualsAndHashCode(callSuper=false)
public class CostBudgetSubjectsTypeRSDTO {

    @ApiModelProperty(value = "部门ID")
    private Integer deptId;
    @ApiModelProperty(value = "部门名称")
    private String deptName;

    @ApiModelProperty(value = "科目类别")
    private String subjectsTypeCode;
    @ApiModelProperty(value = "科目类别中文")
    private String subjectsTypeName;

}
