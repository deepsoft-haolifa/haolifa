package com.deepsoft.haolifa.model.dto.finance.reimburseapply.cost;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class ReimburseCostDetailRSDTO {
    @ApiModelProperty(value = "ID")
    private  Integer id;

    @ApiModelProperty(value = "报销申请ID")
    private  Integer reimburseId;

    @ApiModelProperty(value = "编号")
    private  String serialNo;

    @ApiModelProperty(value = "日期")
    private  Date time;

    @ApiModelProperty(value = "单据张数")
    private  Integer docNum;

    @ApiModelProperty(value = "金额")
    private  BigDecimal amount;

    @ApiModelProperty(value = "类型 1 费用报销 2 费用报销")
    private  String type;

    @ApiModelProperty(value = "科目类别")
    private String subjectsType;
    @ApiModelProperty(value = "科目类别名称")
    private String subjectsTypeName;

    @ApiModelProperty(value = "报销科目(费用预算表中的科目ID)")
    private Integer subject;

    @ApiModelProperty(value = "科目余额（余额是动态的）",hidden = true)
    private  BigDecimal balanceAmount;

    @ApiModelProperty(value = "报销科目")
    private String subjectCN;

    @ApiModelProperty(value = "付款状态（1未付款 2付款中 3付款完成")
    private  String payStatus;

    @ApiModelProperty(value = "备注摘要")
    private  String remark;



}
