package com.deepsoft.haolifa.model.dto.spraycolor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@ApiModel
public class SprayColorDto {

  @ApiModelProperty(required = true, value = "颜色")
  private String color;
  @ApiModelProperty(required = true, value = "编号")
  private String colorNo;
}
