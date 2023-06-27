package com.deepsoft.haolifa.model.dto.productionPlan;

import com.deepsoft.haolifa.model.dto.BaseCondition;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author murphy.he
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class ProductionDailyPlanConditionDto extends BaseCondition {
    @ApiModelProperty("订单号")
    private String orderNo;

    @ApiModelProperty("状态：枚举 production_plan_status")
    private String planStatus;

    @ApiModelProperty("计划日期")
    private Date planDate;

    @ApiModelProperty("计划完成日期")
    private Date planFinishDate;
}
