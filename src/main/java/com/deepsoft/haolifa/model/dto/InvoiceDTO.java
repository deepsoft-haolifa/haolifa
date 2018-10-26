package com.deepsoft.haolifa.model.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class InvoiceDTO {

    private Integer id;
    @ApiModelProperty(required = true,value = "合同编号")
    private String orderNo;
    @ApiModelProperty(required = true,value = "类型 0 流程申请 1 财务填写" ,allowableValues = "0,1")
    private Integer type;
    @ApiModelProperty(value = "发票编号：流程中,即type=0，该字段不是必填；菜单中新增字段必填,type=1")
    private String invoiceNo;
    @ApiModelProperty(required = true,value = "合同金额")
    private Double totalAmount;
    @ApiModelProperty(required = true,value = "单位")
    private String company;
    @ApiModelProperty(required = true,value = "联系人")
    private String linkman;
    @ApiModelProperty(required = true,value = "邮寄地址")
    private String mialingAddress;
    @ApiModelProperty(value = "明细")
    private String details;
}
