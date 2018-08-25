package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class EquipmentListDTO {
    @ApiModelProperty(required = true,value = "显示数量")
    private Integer pageSize;
    @ApiModelProperty(required =true ,value = "页码")
    private Integer pageNum;
    @ApiModelProperty(required = true,value = "企业类型：1 供应商 2 好利阀",allowableValues = "1,2")
    private Integer type;
    @ApiModelProperty(value = "设备名称")
    private String name;
    @ApiModelProperty(value = "设备编号")
    private String equipmentNo;
    @ApiModelProperty(value = "供应商编号")
    private String supplierNo;
}
