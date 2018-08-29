package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SupplierListDTO {

    @ApiModelProperty(required = true,value = "页码")
    private Integer pageNum;
    @ApiModelProperty(required = true,value = "显示数量，默认10条")
    private Integer pageSize;
    @ApiModelProperty(value = "供应商编号")
    private String supplierNo;
    @ApiModelProperty(value = "供应商名称")
    private String supplierName;
}
