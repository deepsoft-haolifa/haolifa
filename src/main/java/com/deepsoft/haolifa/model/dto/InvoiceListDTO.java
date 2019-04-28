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
    @ApiModelProperty(value = "发票状态：0 全部 待开票 1 2 已开票")
    private Integer status;
    @ApiModelProperty(value = "发票类型：类型：0 全部 1 开出（生产） 2 开入（采购）")
    private Integer type;
    @ApiModelProperty(value = "合同方")
    private String contractParty;

}
