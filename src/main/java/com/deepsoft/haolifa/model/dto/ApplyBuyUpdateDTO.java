package com.deepsoft.haolifa.model.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ApplyBuyUpdateDTO {

    @ApiModelProperty(required = true,value = "单项itemId")
    private Integer itemId;
    @ApiModelProperty(value = "物料名称")
    private String materialName;
    @ApiModelProperty(value = "物料图号")
    private String materialGraphNo;
    @ApiModelProperty(value = "数量")
    private Integer purchaseNumber;
}
