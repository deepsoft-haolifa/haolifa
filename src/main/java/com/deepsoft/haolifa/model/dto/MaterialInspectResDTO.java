package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MaterialInspectResDTO {

    private Integer id;

    @ApiModelProperty(required = true,value = "送检单号")
    private String inspectNo;
    @ApiModelProperty(required = true,value = "原料图号")
    private String materialGraphNo;
    @ApiModelProperty(required = true,value = "原料名称")
    private String materialName;
    @ApiModelProperty(required = true,value = "送检数量")
    private Integer inspectNumber;
    @ApiModelProperty(required = true,value = "不合格数量")
    private Integer unqualifiedNumber;
    @ApiModelProperty(required = true,value = "处理结果")
    private String handlingResult;
}
