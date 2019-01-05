package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class AllotEntrustDTO {

  @ApiModelProperty(required = true, value = "唯一标示")
  private Integer id;

  @ApiModelProperty(required = true,value = "车间类型，内部 1 外部2")
  private Integer workShopType;

  @ApiModelProperty(value = "外部车间名称")
  private String supplierName;

  @ApiModelProperty(value = "外部车间编号")
  private String supplierNo;

}
