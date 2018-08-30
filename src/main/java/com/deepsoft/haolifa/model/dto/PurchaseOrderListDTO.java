package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

@Data
public class PurchaseOrderListDTO {
    @ApiModelProperty(required = true, value = "显示数量")
    private Integer pageSize;
    @ApiModelProperty(required = true, value = "页码")
    private Integer pageNum;
    @ApiModelProperty(value = "采购单号")
    private String purchaseOrderNo;
}
