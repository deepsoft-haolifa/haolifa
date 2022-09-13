package com.deepsoft.haolifa.model.dto.finance.projectbudget;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;


@Data
@EqualsAndHashCode(callSuper = false)
public class ProjectBudgetQueryBO {

    @ApiModelProperty(value = "项目编号")
    private String code;

    @ApiModelProperty(value = "所属部门")
    private Integer deptId;

    @ApiModelProperty(value = "预算年度")
    private String year;

    @ApiModelProperty(value = "预算月份")
    private String month;

}
