package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 零件请求实体
 */
@Data
@ApiModel(value = "零件配置对象", description = "新增，更新零件")
public class MaterialRequestDTO {

    @ApiModelProperty(value = "主键", name = "id")
    private Integer id;
    @ApiModelProperty(value = "分类Id", name = "materialClassifyId")
    private Integer materialClassifyId;

    @ApiModelProperty(value = "分类名称", name = "materialClassifyName")
    private String materialClassifyName;

    @ApiModelProperty(value = "原料名称", name = "name")
    private String name;

    @ApiModelProperty(value = "材料", name = "material")
    private String material;

    @ApiModelProperty(value = "图号", name = "graphNo", required = true)
    private String graphNo;

    @ApiModelProperty(value = "单位(如：根，个)", name = "unit")
    private String unit;

    @ApiModelProperty(value = "单价", name = "price")
    private BigDecimal price;

    @ApiModelProperty(value = "规格", name = "specifications")
    private String specifications;

    @ApiModelProperty(value = "实际单重", name = "actualWeight")
    private String actualWeight;

    @ApiModelProperty(value = "理论单重", name = "theoreticalWeight")
    private String theoreticalWeight;

    @ApiModelProperty(value = "型号", name = "model")
    private String model;

    @ApiModelProperty(value = "税率", name = "taxRate")
    private String taxRate;

    @ApiModelProperty(value = "安全库存")
    private Integer safeQuantity;

    @ApiModelProperty(value = "安全库存系数")
    private String safetyFactor;

    @ApiModelProperty(value = "备注", name = "remark")
    private String remark;
}
