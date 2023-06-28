package com.deepsoft.haolifa.model.dto.productionPlan;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author murphy.he
 **/
@Data
public class ProductionDailyPlanReqDto {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("订单号")
    @NotNull(message = "订单号不能为空")
    private String orderNo;

    @ApiModelProperty("计划日期")
    @NotNull(message = "计划日期")
    @JsonFormat(pattern = "yyyy-MM-dd",  timezone="GMT+8")
    private Date planDate;

    @ApiModelProperty("计划完成日期")
    @NotNull(message = "计划完成日期")
    @JsonFormat(pattern = "yyyy-MM-dd",  timezone="GMT+8")
    private Date planFinishDate;

    @ApiModelProperty("备注")
    private String remark;
}
