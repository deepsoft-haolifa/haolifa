package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InspectReason {

  @ApiModelProperty(value = "不合格原因")
  private String reason;

  @ApiModelProperty(value = "不合格数量")
  private Integer number;
}
