package com.deepsoft.haolifa.model.dto.export;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class ExportSprayEntryRoomDTO {

  @ApiModelProperty("开始时间")
  private String startDate;

  @ApiModelProperty("结束时间")
  private String endDate;

  @ApiModelProperty("记录类型 0 全部 1 待入库 2 已入库")
  private Integer entryStatus;

  @ApiModelProperty("喷涂加工号")
  private String sprayNo;

}
