package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class EntrustDTO {

    private String entrustNo;
    @ApiModelProperty(required = true,value = "采购订单号")
    private String purchaseOrderNo;
    @ApiModelProperty(required = true,value = "物料图号")
    private String materialGraphNo;
    @ApiModelProperty(required = true,value = "委托数量")
    private Integer number;
    @ApiModelProperty(required = true,value = "委托人")
    private String entrustPerson;

}
