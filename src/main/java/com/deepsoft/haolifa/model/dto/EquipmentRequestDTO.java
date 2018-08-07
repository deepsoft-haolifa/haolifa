package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "好利阀新增，更新设备信息")
public class EquipmentRequestDTO {

    private Integer id;
    @ApiModelProperty(required = true)
    private String equipmentNo;
    @ApiModelProperty(required = true,value = "设备状态 0 正常 1 损坏待处理 2 处理中 3 处理完成", allowableValues = "0,1,2,3")
    private Byte equipmentStatus;
    @ApiModelProperty(required = true,value = "设备名称")
    private String name;
    @ApiModelProperty(required = true,value = "设备数量")
    private Integer number;
    @ApiModelProperty(value = "生产厂家")
    private String productFactory;
    @ApiModelProperty(value = "服役年限")
    private String serviceYears;

}
