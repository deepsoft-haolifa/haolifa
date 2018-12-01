package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("分配流程节点角色实体")
@Data
public class AllotRolesDTO {

  @ApiModelProperty(required = true,value = "角色id")
  private Integer roleId;

  @ApiModelProperty(required = true,value = "流程id")
  private Integer flowId;

  @ApiModelProperty(required = true,value = "节点id")
  private Integer stepId;

}
