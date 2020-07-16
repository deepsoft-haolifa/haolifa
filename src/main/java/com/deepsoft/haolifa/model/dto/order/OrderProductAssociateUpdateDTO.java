package com.deepsoft.haolifa.model.dto.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @className: OrderProductAssociateDTO
 * @description: 产品订单关联表
 * @author: hedong@ibeesaas.com
 * @date: 2018-11-08 20:33
 **/
@Data
@ApiModel
public class OrderProductAssociateUpdateDTO {
    @ApiModelProperty(value = "主键Id")
    private String id;
    @ApiModelProperty(value = "订单编号")
    private String orderNo;
    @ApiModelProperty(value = "产品数量")
    private Integer productNumber;
    @ApiModelProperty(value = "单价")
    private BigDecimal price;
    @ApiModelProperty(value = "总计价格")
    private BigDecimal totalPrice;

}
