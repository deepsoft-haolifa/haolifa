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

    @ApiModelProperty(value = "付款状态（1未付款 2付款中 3付款完成")
    private  String payStatus;

    @ApiModelProperty(value = "备注摘要")
    private  String remark;

    @ApiModelProperty(value = "删除标志（0代表存在 1代表删除）")
    private  String delFlag;

    @ApiModelProperty(value = "创建者")
    private  Integer createUser;

    @ApiModelProperty(value = "创建时间")
    private  Date createTime;

    @ApiModelProperty(value = "更新者'")
    private  Integer updateUser;

    @ApiModelProperty(value = "更新时间")
    private  Date updateTime;

}
