package com.deepsoft.haolifa.model.dto.condition;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class OrderConditionDTO {
    @ApiModelProperty(value = "页码，从1开始")
    private Integer pageNum = 1;
    @ApiModelProperty(value = "页面大小")
    private Integer pageSize = 20;

    @ApiModelProperty(value = "订单号")
    private String orderNo;
    @ApiModelProperty(value = "订单状态")
    private byte orderStatus;
}
