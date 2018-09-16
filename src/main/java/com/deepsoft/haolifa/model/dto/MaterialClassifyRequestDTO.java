package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 零件分类请求实体
 */
@Data
@ApiModel(value = "零件分类配置对象", description = "新增，更新零件分类")
public class MaterialClassifyRequestDTO {

    @ApiModelProperty(value = "主键Id", name = "Id", required = true)
    private Integer id;

    @ApiModelProperty(value = "分类名称", required = true)
    private String classifyName;

    @ApiModelProperty(value = "备注")
    private String remark;
}
