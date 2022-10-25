package com.deepsoft.haolifa.model.dto.finance.payplan;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


/***
 * 付款计划-确认
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BizPayPlanConfirmRQDTO {

    @ApiModelProperty(value = "付款计划ids")
    private List<Integer> ids;
}
