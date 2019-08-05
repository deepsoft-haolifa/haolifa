package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("新增收付款")
public class PaymentDTO {

  @ApiModelProperty(required = true,value = "金额")
  private Double amount;

  @ApiModelProperty(required = true,value = "订单合同号")
  private String orderNo;

  @ApiModelProperty(required = true, value="订单类型：1 采购 2 生产")
  private Integer orderType;

  @ApiModelProperty(required = true,value = "收付款时间")
  private String payTime;
}
