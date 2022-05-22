package com.deepsoft.haolifa.model.dto.report;

import com.deepsoft.haolifa.constant.Constant;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class ReportCostConditionDTO {
    @ApiModelProperty(value = "开始时间")
    private String startDate;
    @ApiModelProperty(value = "结束时间")
    private String endDate;
    @ApiModelProperty(value = "年")
    private String year;
}


