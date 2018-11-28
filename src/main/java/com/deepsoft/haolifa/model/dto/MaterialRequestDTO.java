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
    @ApiModelProperty(value = "分类Id")
    private Integer materialClassifyId;

    @ApiModelProperty(value = "分类名称")
    private String materialClassifyName;

    @ApiModelProperty(value = "原料名称")
    private String name;

    @ApiModelProperty(value = "材料")
    private String material;

    @ApiModelProperty(value = "图号", required = true)
    private String graphNo;

    @ApiModelProperty(value = "单位(如：根，个)")
    private String unit;

    @ApiModelProperty(value = "单价")
    private BigDecimal price;

    @ApiModelProperty(value = "规格")
    private String specifications;

    @ApiModelProperty(value = "实际单重")
    private String actualWeight;

    @ApiModelProperty(value = "理论单重")
    private String theoreticalWeight;

    @ApiModelProperty(value = "型号")
    private String model;

    @ApiModelProperty(value = "税率")
    private String taxRate;

    @ApiModelProperty(value = "安全库存")
    private Integer safeQuantity;

    @ApiModelProperty(value = "安全库存系数")
    private String safetyFactor;

    @ApiModelProperty(value = "当前库存数量")
    private Integer currentQuantity;

    @ApiModelProperty(value = "图纸Url")
    private String graphUrl;
    @ApiModelProperty(value = "可替换的零件，逗号分隔")
        private String replaceGraphNos;

    @ApiModelProperty(value = "备注")
    private String remark;
}
