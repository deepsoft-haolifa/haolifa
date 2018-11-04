package com.deepsoft.haolifa.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class QuickStartVO {

    @ApiModelProperty(value = "发起的流程id")
    private Integer flowId;
    @ApiModelProperty(value = "发起的流程名称")
    private String name;
    @ApiModelProperty(value = "流程描述")
    private String description;

}
