package com.deepsoft.haolifa.model.dto.proInspect;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ProInspectReason {

  @ApiModelProperty(value = "不合格原因")
  private String reason;

  @ApiModelProperty(value = "不合格数量")
  private Integer number;
}
