package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 产品核料时候的阀体，阀座，阀板的选择
 */
@Data
public class ProductCheckMaterialListDTO {
    @ApiModelProperty(value = "成品型号")
    private String productModel;
    @ApiModelProperty(value = "规格")
    private String specifications;
    @ApiModelProperty(value = "成品数量")
    private Integer productNumber;
    @ApiModelProperty(value = "可选零件列表")
    private List<MaterialTypeListDTO> listDTOS;
}
