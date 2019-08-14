package com.deepsoft.haolifa.model.dto.rejectMaterial;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@ApiModel
public class RejectMaterialSaveDto {

  @ApiModelProperty(value = "采购订单号,质检记录发起必填")
  private String purchaseOrderNo;
  @ApiModelProperty(value = "批次号")
  private String batchNumber ;
  @ApiModelProperty(value = "零件图号")
  private String materialGraphNo;
  @ApiModelProperty(value = "不合格品数量")
  private Integer number;
  @ApiModelProperty(value = "质检记录id")
  private Long inspectId;
  @ApiModelProperty(value = "状态：0 未提交 1 技术审核 2 采购审核 3 处理完成", allowableValues = "0,1")
  private Integer status;
}
