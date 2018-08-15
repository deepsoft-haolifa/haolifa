package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel
public class PurchasePlanDTO {

    private String PurchasePlanNo;
    @ApiModelProperty(required = true,value = "生产订单编号")
    private String productOrderNo;
    @ApiModelProperty(required = true,value = "期望到货时间")
    private String expectedTime;
    @ApiModelProperty(required = true,value = "采购物料列表")
    private List<PurchasePlanItem> materialList;

}




