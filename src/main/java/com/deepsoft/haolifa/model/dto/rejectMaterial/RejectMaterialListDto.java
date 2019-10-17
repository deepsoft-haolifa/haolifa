package com.deepsoft.haolifa.model.dto.rejectMaterial;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@ApiModel
@Data
@ToString
public class RejectMaterialListDto {

  @ApiModelProperty(value = "拉取数量")
  private int pageSize;
  @ApiModelProperty(value = "页码")
  private int pageNum;
  @ApiModelProperty(value = "图号")
  private String materialGraphNo;
  @ApiModelProperty(value = "批次号")
  private String batchNumber;
  @ApiModelProperty(value = "采购订单号")
  private String purchaseOrderNo;

}
