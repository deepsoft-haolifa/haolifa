package com.deepsoft.haolifa.model.dto.finance;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class FileDTO {
    @ApiModelProperty(value = "文件名称（需要带文件后缀）")
    private String fileName;
    @ApiModelProperty(required = true, value = "base64")
    private String base64Source;

}
