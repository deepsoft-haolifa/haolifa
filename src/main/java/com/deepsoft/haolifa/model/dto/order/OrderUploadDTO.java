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
}
