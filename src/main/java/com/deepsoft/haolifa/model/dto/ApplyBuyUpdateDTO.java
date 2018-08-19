package com.deepsoft.haolifa.model.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ApplyBuyUpdateDTO {
    @ApiModelProperty(required = true,value = "请购单号")
    private String applyNo;
    @ApiModelProperty(required = true, value = "物料图号")
    private String materialGraphNo;
    @ApiModelProperty(required = true, value = "数量")
    private Integer number;
    @ApiModelProperty(required = true, value = "备注")
    private String remark;
    @ApiModelProperty(required = true, value = "用途")
    private String purpose;
}
