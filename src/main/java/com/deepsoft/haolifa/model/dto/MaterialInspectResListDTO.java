package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MaterialInspectResListDTO {
    @ApiModelProperty(required = true,value = "页码")
    private Integer pageNum;
    @ApiModelProperty(required = true,value = "显示数量")
    private Integer pageSize;
    @ApiModelProperty(required = true,value = "送检单号")
    private String inspectNo;

}
