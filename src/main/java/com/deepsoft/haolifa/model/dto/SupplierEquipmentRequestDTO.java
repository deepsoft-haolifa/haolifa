package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "供应商设备新增，修改")
public class SupplierEquipmentRequestDTO extends EquipmentBaseDTO {
    @ApiModelProperty(required = true, value = "型号规格")
    private String specification;
    @ApiModelProperty(required = true, value = "设备类型： 0  制造设备 1 检测设备", allowableValues = "0,1")
    private Byte type;

}
