package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "好利阀新增，更新设备信息")
public class EquipmentRequestDTO extends EquipmentBaseDTO {

    @ApiModelProperty(value = "设备编号")
    private String equipmentNo;
    @ApiModelProperty(required = true, value = "设备状态 0 正常 1 损坏待处理 2 处理中 3 处理完成", allowableValues = "0,1,2,3")
    private Byte equipmentStatus;

}
