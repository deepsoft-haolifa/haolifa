package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

@ApiModel("流程节点列表")
@Data
public class FlowStepListDTO {

  private Integer id;

  private Date createTime;

  private Date updateTime;

  private Integer createUserId;

  private Integer flowId;

  private Integer stepId;

  private String userId;

  private Integer roleId;

  private Integer prevStepId;

  private Integer conditionTrue;

  private Integer conditionFalse;

  private String formShowStepId;

  private String roleName;

  private String userNames;

  private String stepName;

}
