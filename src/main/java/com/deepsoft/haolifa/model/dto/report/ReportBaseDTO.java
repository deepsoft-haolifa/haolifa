package com.deepsoft.haolifa.model.dto.report;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 基础配置
 *
 * @author murphy.he
 **/
@Data
public class ReportBaseDTO {



    @ApiModelProperty("开始时间")
    private String startDate;

    @ApiModelProperty("结束时间")
    private String endDate;

    @ApiModelProperty("部门名称")
    private String department;

    @ApiModelProperty("年")
    private String year;

    @ApiModelProperty("月")
    private String month;
}
