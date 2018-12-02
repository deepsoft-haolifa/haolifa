package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("申请发票实体")
public class InvoiceCreateDTO {

  @ApiModelProperty(required = true, value = "合同编号")
  private String orderNo;

  @ApiModelProperty(required = true, value = "开票金额")
  private Double totalAmount;

  @ApiModelProperty(value = "备注")
  private String remark;

  @ApiModelProperty(required = true, value = "类型：1 开出（生产） 2 开入（采购）", allowableValues = "1,2")
  private Integer type;

  @ApiModelProperty(required = true, value = "状态：待开票 1 2 已开票", allowableValues = "1,2")
  private Integer status;
}
