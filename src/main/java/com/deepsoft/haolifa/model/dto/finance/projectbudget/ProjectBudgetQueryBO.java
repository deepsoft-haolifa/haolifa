package com.deepsoft.haolifa.model.dto.finance.projectbudget;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;


@Data
@EqualsAndHashCode(callSuper = false)
public class ProjectBudgetQueryBO {

    @ApiModelProperty(value = "项目编号")
    private String code;
    private String name;

    @ApiModelProperty(value = "所属部门")
    private Integer deptId;
//
//    @ApiModelProperty(value = "预算年度")
//    private String year;
//
//    @ApiModelProperty(value = "预算月份")
//    private String month;

    private Date date;

}
