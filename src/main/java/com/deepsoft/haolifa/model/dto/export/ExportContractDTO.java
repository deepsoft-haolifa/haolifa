package com.deepsoft.haolifa.model.dto.export;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 销售报表-合同报表
 */
@Data
public class ExportContractDTO {

  @ApiModelProperty("时间")
  private int year;

  @ApiModelProperty("需方名称")
  private String demandName;

  @ApiModelProperty("总金额")
  private double totalPrice;



}
