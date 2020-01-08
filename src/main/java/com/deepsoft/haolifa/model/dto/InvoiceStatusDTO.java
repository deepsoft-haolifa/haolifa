package com.deepsoft.haolifa.model.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel
public class InvoiceStatusDTO {
    @ApiModelProperty(value = "主键ID")
    private Integer id;
    @ApiModelProperty(value = "发票编号")
    private String invoiceNo;
    @ApiModelProperty(value = "发票状态：0 待申请 1 待开票 2 已开票",required = true)
    private Byte status;
    @ApiModelProperty(value = "开票日期")
    private Date invoiceDate;
}
