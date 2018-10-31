package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FlowHandleStepDTO {

    @ApiModelProperty(required = true, value = "流程实例id")
    private Integer id;

    @ApiModelProperty(required = true, value = "当前处理节点id")
    private Integer stepId;

    @ApiModelProperty(value = "审核意见")
    private String auditInfo;

    @ApiModelProperty(value = "节点分配的人员id")
    private Integer allotUserId;

    @ApiModelProperty(required = true, value = "审核结果 0 终止 1 通过 2 退回")
    private Integer auditResult;
}
