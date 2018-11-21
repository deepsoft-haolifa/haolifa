package com.deepsoft.haolifa.model.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ApplyBuyUpdateDTO {

    @NotNull
    @ApiModelProperty(required = true,value = "单项itemId")
    private Integer itemId;
    @ApiModelProperty(value = "物料名称")
    private String materialName;
    @ApiModelProperty(value = "物料图号")
    private String materialGraphNo;
    @ApiModelProperty(value = "数量")
    private Integer number;
    @ApiModelProperty(value = "估价")
    private Double valuation;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "用途")
    private String purpose;
    @ApiModelProperty(value = "单位")
    private String unit;
}
