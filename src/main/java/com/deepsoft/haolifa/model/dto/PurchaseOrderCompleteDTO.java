package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("采购完成更新")
@Data
public class PurchaseOrderCompleteDTO {

  @ApiModelProperty(required = true,value = "采购订单号")
  private String orderNo;

  @ApiModelProperty("折损原因")
  private String wreckReason;

  @ApiModelProperty("折损金额")
  private Double wreckAmount;
}
