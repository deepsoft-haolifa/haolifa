package com.deepsoft.haolifa.model.dto.export;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 销售报表
 */
@Data
public class ExportSaleDTO {

  @ApiModelProperty("总数量")
  private int tatalNum;

  @ApiModelProperty("产品号")
  private String productNo;

  @ApiModelProperty("产品类型")
  private String productModel;

  @ApiModelProperty("总金额")
  private double totalPrice;



}
