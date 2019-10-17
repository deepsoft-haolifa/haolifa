package com.deepsoft.haolifa.model.dto.entrust;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@ApiModel
public class EntrustRelationDto {

  @ApiModelProperty(required = true, value = "原图号名称")
  private String materialName;
  @ApiModelProperty(required = true, value = "原图号")
  private String originalGraphNo;
  @ApiModelProperty(required = true, value = "加工后图号")
  private String processedGraphNo;
}
