package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DeliveryRecordConditionDTO {

    @ApiModelProperty(value = "订单号")
    private String orderNo;
    @ApiModelProperty(value = "发货号")
    private String deliveryNo;
}
