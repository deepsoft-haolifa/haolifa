package com.deepsoft.haolifa.model.dto.export;

import com.deepsoft.haolifa.model.domain.QualityProductReport;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 质量报表
 */
@Data
public class TotalQualityReportDto {
    @ApiModelProperty("日期")
    private String createTime;
    @ApiModelProperty("采购零件合格")
    private QualityProductReport purchasePass;
    @ApiModelProperty("零件机加工合格")
    private QualityProductReport inspectPass;
    @ApiModelProperty("零件喷涂合格")
    private QualityProductReport sprayPass;
    @ApiModelProperty("阀门装配合格")
    private QualityProductReport proInspectPass;
}
