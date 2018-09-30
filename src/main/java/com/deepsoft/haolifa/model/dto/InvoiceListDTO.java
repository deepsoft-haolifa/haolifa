package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class InvoiceListDTO {

    @ApiModelProperty(required = true,value = "页码")
    private Integer pageNum;
    @ApiModelProperty(required = true,value = "显示数量")
    private Integer pageSize;
    @ApiModelProperty(value = "订单编号")
    private String orderNo;
    @ApiModelProperty(value = "订单类型 0  订单合同编号 1 采购编号")
    private Integer orderType;
    @ApiModelProperty(value = "付款状态 状态： 0 未收款 1 未打款 2 打款中 3 收款中 4 处理完成")
    private Integer orderStatus;
}
