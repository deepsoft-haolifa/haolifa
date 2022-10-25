package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ExpensesDTO {

    private Integer id;

    @ApiModelProperty(required = true, value = "费用类别")
    private String expensesClassify;

    @ApiModelProperty(required = true, value = "二级费用类别")
    private String secondClassify;

    @ApiModelProperty(required = true, value = "凭证号")
    private String voucherNo;

    @ApiModelProperty(required = true, value = "总费用")
    private BigDecimal totalAmount;

    @ApiModelProperty(required = true, value = "提交人")
    private String commitUser;

    @ApiModelProperty(value = "报销部门")
    private String department;
    @ApiModelProperty(value = "报销摘要")
    private String summary;
    @ApiModelProperty(value = "备注or 内容")
    private String remark;

    @ApiModelProperty(value = "费用产生时间（年-月）")
    private String dataDate;
}
