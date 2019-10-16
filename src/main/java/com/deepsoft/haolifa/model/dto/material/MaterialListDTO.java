package com.deepsoft.haolifa.model.dto.material;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class MaterialListDTO {

    @ApiModelProperty(value = "零件名称")
    private String materialName;

    @ApiModelProperty(value = "零件分类ID")
    private Integer classifyId;
    @ApiModelProperty(value = "获取那种零件（1 正常的，2带M，3带J）")
    private Integer type;

}
