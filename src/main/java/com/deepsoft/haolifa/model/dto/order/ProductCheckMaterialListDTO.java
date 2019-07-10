package com.deepsoft.haolifa.model.dto.order;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 产品核料时候的阀体，阀座，阀板的选择
 */
@Data
public class ProductCheckMaterialListDTO {
    @ApiModelProperty(value = "订单关联成品ID")
    private Integer id;
    @ApiModelProperty(value = "成品号")
    private String productNo;
    @ApiModelProperty(value = "成品型号")
    private String productModel;
    @ApiModelProperty(value = "规格")
    private String specifications;
    @ApiModelProperty(value = "成品数量")
    private Integer productNumber;
    @ApiModelProperty(value = "标签属性")
    private String lable;
    @ApiModelProperty(value = "颜色")
    private String productColor;
    @ApiModelProperty(value = "材质")
    private String materialDescription;
    @ApiModelProperty(value = "备注")
    private String productRemark;

    @ApiModelProperty(value = "可选零件列表")
    private List<MaterialTypeListDTO> listDTOS;
}
