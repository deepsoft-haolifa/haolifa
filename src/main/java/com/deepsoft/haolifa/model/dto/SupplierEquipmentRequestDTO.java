package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "供应商设备新增，修改")
public class SupplierEquipmentRequestDTO {

    private Integer id;
    @ApiModelProperty(required = true,value = "设备名称")
    private String name;
    @ApiModelProperty(required = true,value = "型号规格")
    private String specification;
    @ApiModelProperty(required = true,value = "数量")
    private Integer number;
    @ApiModelProperty(value = "生产厂家")
    private String productFactory;
    @ApiModelProperty(value = "服役年限")
    private String serviceYears;
    @ApiModelProperty(required = true,value = "设备类型： 0  制造设备 1 检测设备",allowableValues = "0,1")
    private Byte type;

}
