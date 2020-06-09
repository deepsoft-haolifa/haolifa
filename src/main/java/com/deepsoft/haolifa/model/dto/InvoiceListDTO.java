package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class InvoiceListDTO {

    @ApiModelProperty(value = "页码")
    private Integer pageNum;
    @ApiModelProperty(value = "显示数量")
    private Integer pageSize;
    @ApiModelProperty(value = "订单编号")
    private String orderNo;
    @ApiModelProperty(value = "发票状态：-1全部，0 待开票 1 已申请 2 已开票")
    private Byte status;
    @ApiModelProperty(value = "发票状态：-1全部，0 待开票 1 已申请 2 已开票")
    private List<Byte> statusList;
    @ApiModelProperty(value = "发票类型：类型：0 全部 1 开出（销项发票） 2 开入（进项发票）")
    private Integer type;
    @ApiModelProperty(value = "合同方")
    private String constractParty;
    @ApiModelProperty(value = "开票日期开始时间")
    private Date startInvoiceDate;
    @ApiModelProperty(value = "开票日期结束时间")
    private Date endInvoiceDate;
}
