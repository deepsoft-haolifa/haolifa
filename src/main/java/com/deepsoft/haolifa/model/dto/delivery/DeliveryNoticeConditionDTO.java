package com.deepsoft.haolifa.model.dto.delivery;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @className: DeliveryNoticeConditionDTO
 * @description: 发货通知单
 * @author: hedong@ibeesaas.com
 * @date: 2018-11-29 20:54
 **/
@Data
public class DeliveryNoticeConditionDTO {
    @ApiModelProperty(value = "页码，从1开始")
    private Integer pageNum = 1;
    @ApiModelProperty(value = "页面大小")
    private Integer pageSize = 20;

    @ApiModelProperty(value = "发货通知单号")
    private String deliveryNo;
    @ApiModelProperty(value = "订单号")
    private String contractOrderNo;
    @ApiModelProperty(value = "发货状态:-1 全部 0 待发货（默认） 1 部分发货 2 发货完成")
    private Byte deliverStatus = -1;
}
