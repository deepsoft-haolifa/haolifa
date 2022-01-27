package com.deepsoft.haolifa.model.dto.finance.reimburseapply.cost;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

public class ReimburseCostDetailAddDTO {


    @ApiModelProperty(value = "日期")
    private  Date time;

    @ApiModelProperty(value = "单据张数")
    private  Integer docNum;

    @ApiModelProperty(value = "金额")
    private  BigDecimal amount;

    @ApiModelProperty(value = "类型 1 费用报销 2 费用报销")
    private  String type;

    @ApiModelProperty(value = "备注摘要")
    private  String remark;

}