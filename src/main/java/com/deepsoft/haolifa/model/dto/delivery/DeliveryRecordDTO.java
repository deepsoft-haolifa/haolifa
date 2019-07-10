package com.deepsoft.haolifa.model.dto.delivery;

import com.deepsoft.haolifa.model.dto.order.OrderProductAssociateDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class DeliveryRecordDTO {

    @ApiModelProperty(value = "订单号")
    private String orderNo;
    @ApiModelProperty(value = "客户代号")
    private String customerNo;
    @ApiModelProperty(value = "发货日期")
    private String deliveryTime;
    @ApiModelProperty(value = "发往地")
    private String collectAddress;
    @ApiModelProperty(value = "收货人")
    private String collectName;
    @ApiModelProperty(value = "收货人电话")
    private String collectPhone;
    @ApiModelProperty(value = "运输方式")
    private String transportType;
    @ApiModelProperty(value = "运费付费方式")
    private String freight;
    @ApiModelProperty(value = "是否送货")
    private String isDelivery;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "成品列表")
    List<OrderProductAssociateDTO> productList;
}
