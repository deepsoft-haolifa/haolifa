package com.deepsoft.haolifa.model.dto.finance.projectbudget;

import com.deepsoft.haolifa.model.dto.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProjectBudgetRQDTO  extends PageParam {

    @ApiModelProperty(value = "项目编号")
    private String code;

    @ApiModelProperty(value = "项目名称")
    private String name;

    @ApiModelProperty(value = "所属部门")
    private Integer deptId;

    @ApiModelProperty(value = "所属部门")
    private String deptName;

    @ApiModelProperty(value = "预算年度")
    private String year;

    @ApiModelProperty(value = "预算月份")
    private String month;


}
