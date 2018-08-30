package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SupplierProductListDTO {

    @ApiModelProperty(required = true,value = "页码")
    private Integer pageNum;
    @ApiModelProperty(required = true,value = "页数")
    private Integer pageSize;
    @ApiModelProperty(required = true,value = "供应商编号")
    private String supplierNo;
    @ApiModelProperty(value = "原料类型 0 供货原料 1 其他原料", allowableValues = "0,1")
    private Integer materialType;
    @ApiModelProperty(value = "原料图号")
    private String materialGraphNo;
}
