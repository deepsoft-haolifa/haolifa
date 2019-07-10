package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("流程节点审核人分配")
@Data
public class AllotPersonsDTO {

  @ApiModelProperty(required = true,value = "流程id")
  private Integer flowId;

  @ApiModelProperty(required = true,value = "流程节点id")
  private Integer stepId;

  @ApiModelProperty(required = true,value = "分配的角色id")
  private Integer roleId;

  @ApiModelProperty(required = true,value = "分配的审核人，可以有多个,逗号隔开")
  private String userIds;
}
