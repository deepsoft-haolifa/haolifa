package com.deepsoft.haolifa.model.dto.pay;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@ApiModel(description = "考核指标表DTO")
@Data
@EqualsAndHashCode(callSuper = false)
public class PayAssessmentQuotaDTO {
    @ApiModelProperty(name = "id")
    private Integer id;
    @ApiModelProperty(name = "项目名称")
    private String projectName;
    @ApiModelProperty(name = "考核指标")
    private String quotaName;
    @ApiModelProperty(name = "指标内容")
    private String quotaContent;
    @ApiModelProperty(name = "对应分值")
    private Integer score;
    @ApiModelProperty(name = "考核标准")
    private String standard;
    @ApiModelProperty(name = "备注")
    private String remark;
    @ApiModelProperty(name = "部门ID")
    private Integer departId;
    @ApiModelProperty(name = "部门名称")
    private String departName;
    }
