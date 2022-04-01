package com.deepsoft.haolifa.model.dto.finance.reimburseapply.cost;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;
@Data
@EqualsAndHashCode(callSuper = false)
public class ReimburseCostDetailUpDTO {
    @ApiModelProperty(value = "ID")
    private  Integer id;

    @ApiModelProperty(value = "日期")
    private  Date time;

    @ApiModelProperty(value = "单据张数")
    private  Integer docNum;

    @ApiModelProperty(value = "金额")
    private  BigDecimal amount;

    @ApiModelProperty(value = "类型 1 费用报销 2 费用报销")
    private  String type;

    @ApiModelProperty(value = "报销科目(费用预算表中的ID)")
    private Integer subject;

    @ApiModelProperty(value = "备注摘要")
    private  String remark;

}
