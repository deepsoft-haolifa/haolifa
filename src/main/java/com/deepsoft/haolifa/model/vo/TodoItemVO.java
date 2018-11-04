package com.deepsoft.haolifa.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("待办事项")
public class TodoItemVO {

    @ApiModelProperty("流程id")
    private Integer flowId;
    @ApiModelProperty("流程名")
    private String flowName;
    @ApiModelProperty("流程节点id")
    private Integer stepId;
    @ApiModelProperty("节点名")
    private String stepName;
    @ApiModelProperty("创建人用户名")
    private String createUser;
    @ApiModelProperty("创建人真名")
    private String createUserRealName;
    @ApiModelProperty("创建时间")
    private Date createTime;

}
