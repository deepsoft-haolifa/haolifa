package com.deepsoft.haolifa.model.dto.export;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ExportProductEntryRoomDTO {

  @ApiModelProperty("开始时间")
  private String startDate;

  @ApiModelProperty("结束时间")
  private String endDate;

  @ApiModelProperty("记录类型 0 全部 1 待入库 2 已入库")
  private Integer entryStatus;

  @ApiModelProperty("订单号")
  private String orderNo;

  

}
