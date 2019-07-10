package com.deepsoft.haolifa.model.dto.pressureInspect;

import com.deepsoft.haolifa.model.dto.BaseCondition;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @className: ProInspectCondition
 * @description:
 * @author: hedong@ibeesaas.com
 * @date: 2018-12-13 14:58
 **/
@Data
public class PressureInspectConditionDTO extends BaseCondition {
    @ApiModelProperty(value = "送检单号")
    private String inspectNo;
    @ApiModelProperty(value = "订单号")
    private String orderNo;
}
