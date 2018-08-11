package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class SupplierPorductDTO {

    private Integer id;

    @ApiModelProperty(required = true,value = "供应商编号")
    private String supplierNo;
    @ApiModelProperty(required = true,value = "产品类型 0 供货原料 1 其他原料",allowableValues = "0,1")
    private Integer materialType;
    @ApiModelProperty(value = "materialType = 0 必传；供货物料图号")
    private String materialGraphNo;
    @ApiModelProperty(required = true,value = "产品名称")
    private String materialName;
    @ApiModelProperty(required = true,value = "年产量")
    private Integer annualProdection;
    @ApiModelProperty(required = true,value = "主要客户")
    private String mainCustomer;
}
