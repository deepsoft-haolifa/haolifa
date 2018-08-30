package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PurchasePlanListDTO {

    @ApiModelProperty(required = true,value = "页码")
    private Integer pageNum;
    @ApiModelProperty(required = true,value = "显示数量")
    private Integer pageSize;
    @ApiModelProperty(value = "生产订单号")
    private String productOrderNo;
}
