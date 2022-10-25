package com.deepsoft.haolifa.model.dto.pay;

import com.deepsoft.haolifa.model.dto.BaseCondition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@ApiModel(description = "考核指标表VO")
@Data
@EqualsAndHashCode(callSuper=true)
public class PayAssessmentQuotaVO extends BaseCondition {
    @ApiModelProperty(name = "项目名称")
    private String projectName;
    @ApiModelProperty(name = "岗位名称")
    private String departName;
    @ApiModelProperty(name = "岗位ID")
    private Integer departId;
    }
