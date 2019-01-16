package com.deepsoft.haolifa.model.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PurchaseOrderItem {
    private Integer id;
    @ApiModelProperty(required = true,value = "产品名称")
    private String materialName;
    @ApiModelProperty(required = true,value = "图号")
    private String materialGraphNo;
    @ApiModelProperty(required = true,value = "数量")
    private Integer number;
    @ApiModelProperty(required = true,value = "规格")
    private String specification;
    @ApiModelProperty(required = true,value = "材质")
    private String material;
    @ApiModelProperty(required = true,value = "单重")
    private Double unitWeight;
    @ApiModelProperty(required = true,value = "单价")
    private Double unitPrice;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(required = true,value = "单位")
    private String unit;

}
