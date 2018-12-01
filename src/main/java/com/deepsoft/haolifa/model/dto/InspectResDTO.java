package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("质检结果更新实体")
@Data
public class InspectResDTO {

  @ApiModelProperty(value = "不合格数量")
  private Integer unqualifiedNumber;

  @ApiModelProperty(value = "合格数量")
  private Integer qualifiedNumber;

  @ApiModelProperty(value = "处理意见1、退货 2 返修 3 报废 4 让步接受",allowableValues = "1,2,3,4")
  private int dealType;
}
