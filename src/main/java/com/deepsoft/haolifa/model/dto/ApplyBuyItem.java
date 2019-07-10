package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ApplyBuyItem {

    @ApiModelProperty(required = true,value = "物料名称")
    private String materialName;
    @ApiModelProperty(required = true,value = "物料图号")
    private String materialGraphNo;
    @ApiModelProperty(required = true,value = "采购数量")
    private Integer purchaseNumber;
}
