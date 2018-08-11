package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("设备维修入参")
@Data
public class EquipRepairedRecordDTO {

    @ApiModelProperty(required = true,value = "维修原因")
    private String maintainReason;
    @ApiModelProperty(required = true,value = "被维修设备编号")
    private String equipmentNo;
    @ApiModelProperty(required = true,value = "维修者")
    private String maintainer;
    @ApiModelProperty(value = "备注")
    private String remark;
}
