package com.deepsoft.haolifa.model.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;

@Data
public class ExpensesReport {
    @ApiModelProperty("金额")
    private BigDecimal totalAmount;

    @ApiModelProperty("费用类别")
    private String expensesClassify;

    @ApiModelProperty("二级费用类别")
    private String secondClassify;

    @DateTimeFormat(pattern = "yyyy-MM")
    @ApiModelProperty("创建时间")
    private String createTime;

    @ApiModelProperty("月")
    private String dataMonth;

    @ApiModelProperty("年")
    private String dataYear;

    @ApiModelProperty("年-月")
    private String dateStr;

    @ApiModelProperty("部门")
    private String department;


}
