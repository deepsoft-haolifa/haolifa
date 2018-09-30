package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ExpensesDTO {

    private Integer id;

    @ApiModelProperty(required = true,value = "费用类别")
    private String expensesClassify;

    @ApiModelProperty(required = true,value = "总费用")
    private Double totalAmount;

    @ApiModelProperty(required = true,value = "提交人")
    private String commitUser;
}