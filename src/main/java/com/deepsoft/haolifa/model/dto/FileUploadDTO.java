package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FileUploadDTO {
    @ApiModelProperty(value = "文件名称（需要带文件后缀）")
    private String fileName;
    @ApiModelProperty(required = true, value = "base64")
    private String base64Source;
}
