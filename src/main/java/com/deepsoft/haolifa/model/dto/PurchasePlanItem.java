package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PurchasePlanItem {
    @ApiModelProperty(required = true,value = "采购物料图号")
    private String materialGraphNo;
    @ApiModelProperty(required = true,value = "采购数量")
    private Integer number;
}
