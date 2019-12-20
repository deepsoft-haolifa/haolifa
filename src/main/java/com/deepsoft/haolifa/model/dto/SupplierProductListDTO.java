package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SupplierProductListDTO extends PageParam{

    @ApiModelProperty(value = "供应商编号")
    private String supplierNo;
    @ApiModelProperty(value = "供应商名称")
    private String supplierName;
    @ApiModelProperty(value = "原料类型 0 供货原料 1 其他原料", allowableValues = "0,1")
    private Integer materialType;
    @ApiModelProperty(value = "原料图号")
    private String materialGraphNo;
    @ApiModelProperty(value = "原料名称")
    private String materialName;
}
