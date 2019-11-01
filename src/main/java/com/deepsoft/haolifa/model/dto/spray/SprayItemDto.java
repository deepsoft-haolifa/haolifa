package com.deepsoft.haolifa.model.dto.spray;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SprayItemDto {

  private String materialGraphNo;

  private String specifications;

  private String model;

  private String materialClassifyName;

  private String material;

  private String specialRequires;

  private String sprayColor;

  @ApiModelProperty("喷涂颜色编号")
  private String relationNo;

  private Integer number;

  private String remark;

  private String completeTime;

  private String batchNumber;

  @ApiModelProperty("喷涂后的图号")
  private String sprayedGraphNo;
}
