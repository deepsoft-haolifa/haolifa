package com.deepsoft.haolifa.model.dto.order;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OrderUploadDTO {
    @ApiModelProperty(value = "文件名称（需要带文件后缀）")
    private String fileName;
    @ApiModelProperty(required = true, value = "base64")
    private String base64Source;
    @ApiModelProperty(value = "发货时间")
    private String deliveryDate;
    @ApiModelProperty(value = "订单是否核料流程；1.走核料；0 不核料")
    private Byte isCheckMaterial;
}
