package com.deepsoft.haolifa.model.dto.file;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FileRecordDTO {
    @ApiModelProperty(value = "主键Id，更新的时候要传")
    private Integer id;

    @ApiModelProperty(value = "文件名称")
    private String fileName;
    @ApiModelProperty(value = "文件url(文件的base64)")
    private String fileBase64;
    @ApiModelProperty(value = "文件url")
    private String fileUrl;
    @ApiModelProperty(value = "类型(1.零件图纸；2.其他)")
    private byte type;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "文件编号")
    private String fileNo;
}
