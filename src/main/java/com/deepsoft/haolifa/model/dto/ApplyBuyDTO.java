package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class ApplyBuyDTO {

    @ApiModelProperty(required = true,value = "采购计划单号")
    private String purchasePlanNo;
    @ApiModelProperty(required = true,value = "物料图号")
    private String materialGraphNo;
    @ApiModelProperty(required = true,value = "数量")
    private Integer number;

}
