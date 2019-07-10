package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("更新送检单")
@Data
public class InspectUpdateDTO {

  @ApiModelProperty(required = true,value = "到货日期")
  private String arrivalTime;

  @ApiModelProperty(required = true,value = "供应商名称")
  private String supplierName;

}
