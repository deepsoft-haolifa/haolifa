package com.deepsoft.haolifa.model.dto.file;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 文件列表查询条件
 */
@Data
public class FileRecordConditionDTO {
    @ApiModelProperty(value = "页码，从1开始")
    private Integer pageNum = 1;
    @ApiModelProperty(value = "页面大小")
    private Integer pageSize = 20;

    @ApiModelProperty(value = "文件名称")
    private String fileName;
    @ApiModelProperty(value = "类型(0.全部;1.零件图纸；)")
    private byte type;
}
