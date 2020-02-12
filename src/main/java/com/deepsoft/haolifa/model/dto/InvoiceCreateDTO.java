package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("申请发票实体")
public class InvoiceCreateDTO {

  private Integer id;

  private String invoiceNo;

  @ApiModelProperty(required = true, value = "合同编号")
  private String orderNo;

  @ApiModelProperty(required = true, value = "开票金额")
  private Double totalAmount;

  @ApiModelProperty(value = "备注")
  private String remark;

  @ApiModelProperty(required = true, value = "类型：1 开出（生产） 2 开入（采购）", allowableValues = "1,2")
  private Integer type;

  @ApiModelProperty(required = true, value = "状态：0 待开票 ； 1 已申请 ； 2 已开票", allowableValues = "0,1,2")
  private Integer status;

  @ApiModelProperty(value = "开票单位")
  private String invoiceIssuing;

  @ApiModelProperty(value = "需方单位")
  private String invoiceCompany;

    @ApiModelProperty(value = "开票日期")
    private Date invoiceDate;
}
