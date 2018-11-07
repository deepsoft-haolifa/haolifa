package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

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
    @ApiModelProperty(value = "产品编号")
    private String productNo;
    @ApiModelProperty(value = "产品名称")
    private String productName;
    @ApiModelProperty(value = "型号")
    private String productModel;
    @ApiModelProperty(value = "标签属性")
    private String lable;
    @ApiModelProperty(value = "规格")
    private String specifications;
    @ApiModelProperty(value = "颜色")
    private String productColor;
    @ApiModelProperty(value = "产品数量")
    private Integer productNumber;
    @ApiModelProperty(value = "产品备注")
    private String productRemark;
    @ApiModelProperty(value = "运输方式")
    private String transportType;
    @ApiModelProperty(value = "运费付费方式")
    private String freight;
    @ApiModelProperty(value = "是否送货")
    private String isDelivery;
    @ApiModelProperty(value = "备注")
    private String remark;
}
