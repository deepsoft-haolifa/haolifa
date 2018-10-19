package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class EquipmentBaseDTO {

    private Integer id;
    @ApiModelProperty(required = true,value = "设备名称")
    private String name;
    @ApiModelProperty(required = true,value = "设备数量")
    private Integer number;
    @ApiModelProperty(value = "生产厂家")
    private String productFactory;
    @ApiModelProperty(value = "服役年限")
    private Integer servicedYears;

}
