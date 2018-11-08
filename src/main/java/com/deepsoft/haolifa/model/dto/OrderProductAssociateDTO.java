package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @className: OrderProductAssociateDTO
 * @description: 产品订单关联表
 * @author: hedong@ibeesaas.com
 * @date: 2018-11-08 20:33
 **/
@Data
public class OrderProductAssociateDTO {

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

}
