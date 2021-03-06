package com.deepsoft.haolifa.model.dto.material;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MaterialConditionDTO {
    @ApiModelProperty(value = "页码，从1开始")
    private Integer pageNum = 1;
    @ApiModelProperty(value = "页面大小")
    private Integer pageSize = 20;

    @ApiModelProperty(value = "图号")
    private String graphNo;
    @ApiModelProperty(value = "零件名称")
    private String materialName;

    @ApiModelProperty(value = "零件分类ID")
    private Integer classifyId;
    @ApiModelProperty(value = "规格")
    private String specifications;
    @ApiModelProperty(value = "型号")
    private String model;
}
