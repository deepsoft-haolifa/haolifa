package com.deepsoft.haolifa.model.dto.finance;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class FileUrlDTO {
    @ApiModelProperty(value = "文件名称")
    private String fileName;
    @ApiModelProperty( value = "文件路径")
    private String fileUrl;

}
