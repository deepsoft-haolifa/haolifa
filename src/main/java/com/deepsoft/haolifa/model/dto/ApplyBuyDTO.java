package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel
public class ApplyBuyDTO {

    @ApiModelProperty(required = true, value = "生产订单编号")
    private String productOrderNo;

    @ApiModelProperty(required = true,value = "采购物料单项；至少一项")
    private List<ApplyBuyItem> itemList;

}
