package com.deepsoft.haolifa.model.dto.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;


/**
 * @className: CheckMaterialDTO
 * @description: 订单关联零件实体（领料单）
 * @author: hedong@ibeesaas.com
 * @date: 2018-11-19 21:20
 **/
@Data
@ApiModel
public class OrderMaterialDTO {

    @ApiModelProperty(value = "主键Id")
    private Integer id;
    @ApiModelProperty(value = "订单编号")
    private String orderNo;

    @ApiModelProperty(value = "零件号")
    private String materialGraphNo;

    @ApiModelProperty(value = "零件数量")
    private Integer materialCount;

    @ApiModelProperty(value = "核料状态（1成功；2.缺料，需要采购；3.替换 4.释放料）")
    private Byte checkStatus;

    @ApiModelProperty(value = "缺少的零件数量")
    private Integer lackMaterialCount;

    @ApiModelProperty(value = "替换料审核结果")
    private Byte auditResult;

    @ApiModelProperty(value = "零件名称")
    private String materialName;

    @ApiModelProperty(value = "零件型号")
    private String model;

    @ApiModelProperty(value = "零件规格")
    private String specifications;

    @ApiModelProperty(value = "零件单价")
    private BigDecimal price;

    @ApiModelProperty(value = "零件单位")
    private String unit;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "替换料零件名称")
    private String replaceMaterialName;

    @ApiModelProperty(value = "替换料零件号")
    private String replaceMaterialGraphNo;



}
