package com.deepsoft.haolifa.model.dto.productionPlan;

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
    private Date planDate;

    @ApiModelProperty("计划完成日期")
    @NotNull(message = "计划完成日期")
    private Date planFinishDate;

}
