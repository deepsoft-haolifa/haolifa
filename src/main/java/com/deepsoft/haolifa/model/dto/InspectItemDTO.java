package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

@Data
public class InspectItemDTO {

    private Integer id;

    @ApiModelProperty(required = true,value = "采购合同编号")
    private String purchaseNo;
    @ApiModelProperty(value = "物料（原料）图号")
    private String materialGraphNo;
    @ApiModelProperty(value = "零部件名称")
    private String materialName;
    @ApiModelProperty(required = true,value = "规格")
    private String specification;

    @ApiModelProperty(required = true,value = "材质要求")
    private String requirements;

    @ApiModelProperty(required = true,value = "单位：个")
    private String unit;

    @ApiModelProperty(required = true,value = "备注")
    private String remark;

    @ApiModelProperty(required = true,value = "采购数量")
    private Integer purchaseNumber;

    @ApiModelProperty(required = true,value = "送检数量")
    private Integer deliveryNumber;

    private Double purchasePrice;
}
