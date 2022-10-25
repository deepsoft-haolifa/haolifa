package com.deepsoft.haolifa.model.dto.finance.projectbudget;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProjectBudgetUpDTO {

    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "项目编号")
    private String code;

    @ApiModelProperty(value = "项目名称")
    private String name;

    @ApiModelProperty(value = "所属部门")
    private Integer deptId;

    @ApiModelProperty(value = "预算年度")
    private String year;

    @ApiModelProperty(value = "预算月份")
    private String month;

    @ApiModelProperty(value = "预算经费总额度")
    private BigDecimal totalQuota;

//    @ApiModelProperty(value = "剩余额度")
    private BigDecimal balanceQuota;

    @ApiModelProperty(value = "状态（1正常 2停用）")
    private String status;

    @ApiModelProperty(value = "备注")
    private String remark;

}
