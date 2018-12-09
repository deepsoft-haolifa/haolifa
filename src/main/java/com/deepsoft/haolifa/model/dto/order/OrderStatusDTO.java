package com.deepsoft.haolifa.model.dto.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @className: OrderUpdateDTO
 * @description: 订单状态
 * @author: hedong@ibeesaas.com
 * @date: 2018-11-27 20:09
 **/
@Data
@ApiModel
public class OrderStatusDTO {

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "状态(0-创建；1-完成；2-审核中；3-核料中；4-待领料；5-待生产；6-生产中；7-生产暂停；8-质检中；)")
    private Byte status;
}
