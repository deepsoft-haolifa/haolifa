package com.deepsoft.haolifa.model.dto.order;

import com.deepsoft.haolifa.constant.Constant;
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
    @ApiModelProperty(value = Constant.ORDER_STATUS_DESC, name = "订单状态")
    private byte orderStatus;

    @ApiModelProperty(value = Constant.ORDER_STATUS_DESC, name = "订单状态列表(逗号分隔)")
    private byte[] orderStatusList;
}


