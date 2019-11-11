package com.deepsoft.haolifa.model.dto.export;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 采购报表
 */
@Data
public class ExportpPurchaseDTO {

  @ApiModelProperty("供应商名称")
  private String supplierName;

  @ApiModelProperty("创建时间")
  private String createTime;

  @ApiModelProperty("总费用")
  private String total;

  @ApiModelProperty("付款金额")
  private String payTotal;

  @ApiModelProperty("未付款")
  private String unpay;

}
