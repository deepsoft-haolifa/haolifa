package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("更新送检单项")
public class InspectItemUpdateDTO {

  @ApiModelProperty(value = "合同编号")
  private String purchaseNo;
  @ApiModelProperty(value = "物料图号")
  private String materialGraphNo;
  @ApiModelProperty(value = "物料名称")
  private String materialName;
  @ApiModelProperty(value = "规格")
  private String specification;
  @ApiModelProperty(value = "采购数量")
  private Integer purchaseNumber;
  @ApiModelProperty(value = "到货数量（送检数量）")
  private Integer deliveryNumber;
  @ApiModelProperty(value = "材质要求（技术）")
  private String requirements;
  @ApiModelProperty(value = "单位（个，件）")
  private String unit;
  @ApiModelProperty(value = "备注")
  private String remark;

}
