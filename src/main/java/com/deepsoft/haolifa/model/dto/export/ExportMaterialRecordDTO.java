package com.deepsoft.haolifa.model.dto.export;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ExportMaterialRecordDTO {

  @ApiModelProperty("开始时间")
  private String startDate;

  @ApiModelProperty("结束时间")
  private String endDate;

  @ApiModelProperty("操作类型 0 全部 1 出库 2 入库")
  private Integer operationType;

  @ApiModelProperty("订单号")
  private String orderNo;
}
