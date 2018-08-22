package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

@Data
public class InspectDTO {

    @ApiModelProperty(required = true,value = "关联单号（采购单、订单、机加委托单）")
    private String orderNo;
    @ApiModelProperty(value = "送检单号")
    private String inspectNo;
    @ApiModelProperty(required = true,value = "orderNo类型：0 采购单 1 机加委托订单号 2 生产订单号",allowableValues = "0,1,2")
    private Integer type;
    @ApiModelProperty(value = "物料（原料）图号 type=0,1 必填")
    private String materialGraphNo;
    @ApiModelProperty(value = "产品型号 type = 2 必填")
    private String productModel;
    @ApiModelProperty(required = true,value = "产品数量")
    private Integer number;
}
