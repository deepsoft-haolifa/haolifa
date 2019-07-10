package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;

@ApiModel("送检单")
@Data
public class InspectDTO {

  @ApiModelProperty(required = true,value = "操作：1 保存 2 保存并发起",allowableValues = "1,2")
  private Integer status;

  @ApiModelProperty(required = true,value = "到货日期(yyyy-MM-dd)")
  private String arrivalTime;

  @ApiModelProperty(required = true,value = "供应商名称")
  private String supplierName;

  @ApiModelProperty(required = true,value = "采购合同编号")
  private String purchaseNo;

  @ApiModelProperty(required = true,value = "批次号")
  private String batchNumber;

  @ApiModelProperty(value = "质量保证书附件")
  private List<Accessory> accessorys;

  @ApiModelProperty(required = true,value = "送检列表")
  private List<InspectItemDTO> items;
 }
