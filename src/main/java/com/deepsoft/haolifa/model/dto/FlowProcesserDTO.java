package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class FlowProcesserDTO {

  @ApiModelProperty("流程实例id")
  private Integer instanceId;

  @ApiModelProperty("节点id")
  private Integer stepId;

  @ApiModelProperty("节点名称")
  private String stepName;

  @ApiModelProperty("节点审核角色")
  private String roleName;

  @ApiModelProperty("节点审核角色id")
  private Integer roleId;

  @ApiModelProperty("节点审核人姓名：未审核时，为空")
  private String auditUserName;

  @ApiModelProperty("审核结果： 0 审核不通过 1 审核通过 3 流程初始化（不展示节点审核角色 roleName） 4 未审核")
  private Integer auditResult;
  @ApiModelProperty("分支节点，目前只有生产流程有一个分支，且节点只有一个。stepId=55是合并的节点")
  private List<FlowProcesserDTO> child;

  @ApiModelProperty("审核时间")
  private Date auditTime;

}
