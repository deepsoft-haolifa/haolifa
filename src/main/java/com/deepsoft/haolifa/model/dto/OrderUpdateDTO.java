package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @className: OrderUpdateDTO
 * @description: 订单更新的相关字段
 * @author: hedong@ibeesaas.com
 * @date: 2018-11-27 20:09
 **/
@Data
@ApiModel
public class OrderUpdateDTO {

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "技术清单")
    private String technicalRequire;

    @ApiModelProperty(value = "完成时间")
    private String finishFeedbackTime;

    @ApiModelProperty(value = "采购完成时间")
    private String purchaseFeedbackTime;

    @ApiModelProperty(value = "装配车间")
    private String assemblyShop;

    @ApiModelProperty(value = "装配小组")
    private String assemblyGroup;
}
