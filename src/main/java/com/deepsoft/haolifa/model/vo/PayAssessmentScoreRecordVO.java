package com.deepsoft.haolifa.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author liuyaofei
 * @Date create in 下午5:58 2022/3/19
 * @description 打分管理详情表VO
 */
@Data
public class PayAssessmentScoreRecordVO {

    @ApiModelProperty(value = "考核指标")
    private String quotaName;
    @ApiModelProperty(value = "指标内容")
    private String quotaContent;
    @ApiModelProperty(value = "考核标准")
    private String standard;
    @ApiModelProperty(value = "扣分")
    private Integer score;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
}
