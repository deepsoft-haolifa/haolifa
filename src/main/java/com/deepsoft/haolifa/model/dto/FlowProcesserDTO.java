package com.deepsoft.haolifa.model.dto;

import java.util.List;
import lombok.Data;

@Data
public class FlowProcesserDTO {

  private Integer instanceId;

  private Integer stepId;

  private String stepName;

  private String auditUserName;

  private Integer auditResult;

  private List<FlowProcesserDTO> child;

}
