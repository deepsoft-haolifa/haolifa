package com.deepsoft.haolifa.model.dto.finance.reimburseapply.travel;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class ReimburseTravelDetailUpDTO {
    @ApiModelProperty(value = "ID")
    private  Integer id;

    @ApiModelProperty(value = "出发日期")
    private Date depTime;
    @ApiModelProperty(value = "出发地")
    private String depAddress;
    @ApiModelProperty(value = "到达日期")
    private Date arrTime;
    @ApiModelProperty(value = "到达地")
    private String arrAddress;
    @ApiModelProperty(value = "交通工具")
    private Integer vehicle;
    @ApiModelProperty(value = "交通单据张数")
    private Integer vehicleDocNum;
    @ApiModelProperty(value = "交通金额")
    private BigDecimal vehicleAmount;
    @ApiModelProperty(value = "出差天数")
    private Double travelDays;
    @ApiModelProperty(value = "出差补贴金额")
    private BigDecimal travelSubsidyAmount;
    @ApiModelProperty(value = "项目")
    private Integer projectType;
    @ApiModelProperty(value = "单据张数")
    private Integer projectDocNum;
    @ApiModelProperty(value = "金额")
    private BigDecimal projectAmount;
    @ApiModelProperty(value = "类型 1 费用报销 2 费用报销")
    private String type;

    @ApiModelProperty(value = "付款状态（1未付款 2付款中 3付款完成")
    private  String payStatus;

    @ApiModelProperty(value = "备注摘要")
    private  String remark;



}
