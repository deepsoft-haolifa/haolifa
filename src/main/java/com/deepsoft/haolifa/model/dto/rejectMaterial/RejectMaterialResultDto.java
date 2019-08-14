package com.deepsoft.haolifa.model.dto.rejectMaterial;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@ApiModel
public class RejectMaterialResultDto {

  @ApiModelProperty(value = "记录编号")
  private String recordNo;
  @ApiModelProperty(value = "不合格总数量")
  private Integer number;
  @ApiModelProperty(value = "退回数量")
  private Integer backNumber;
  @ApiModelProperty(value = "让步接受数量")
  private Integer acceptNumber;
  @ApiModelProperty(value = "加工数量")
  private Integer entrustNumber;
}
