package com.deepsoft.haolifa.model.dto.report;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;


@Data
public class ReportCostRespDTO {
    @ApiModelProperty(value = "年(2022)")
    private String year;
    @ApiModelProperty(value = "月(5)")
    private String month;
    @ApiModelProperty(value = "金额")
    private BigDecimal totalAmount;
}


