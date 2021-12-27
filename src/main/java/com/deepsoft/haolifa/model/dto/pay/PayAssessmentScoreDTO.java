package com.deepsoft.haolifa.model.dto.pay;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
@ApiModel(description = "考核打分DTO")
@Data
@EqualsAndHashCode()
public class PayAssessmentScoreDTO {
    @ApiModelProperty(name = "id")
    private Integer id;
    @ApiModelProperty(name = "考核ID")
    private Integer assessmentId;
    @ApiModelProperty(name = "人员ID")
    private Integer userId;
    @ApiModelProperty(name = "人员名称")
    private String userName;
    @ApiModelProperty(name = "得分")
    private Integer score;

}
