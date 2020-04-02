package com.deepsoft.haolifa.model.dto.export;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 阀门装配不合格原因统计报表
 *
 * @author murphy.he
 **/
@Data
public class ReportAssemblingReasonDto {

    @ApiModelProperty("不合格原因")
    private String reason;
    @ApiModelProperty("数量")
    private Integer qty;

}
