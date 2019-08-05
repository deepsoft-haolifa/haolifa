package com.deepsoft.haolifa.model.dto.proInspect;

import com.deepsoft.haolifa.model.dto.BaseCondition;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @className: ProInspectCondition
 * @description:
 * @author: hedong@ibeesaas.com
 * @date: 2018-12-13 14:58
 **/
@Data
@EqualsAndHashCode(callSuper = false)
public class ProInspectConditionDTO extends BaseCondition {
    @ApiModelProperty(value = "送检单号")
    private String inspectNo;
    @ApiModelProperty(value = "入库状态（1.待入库;2.已入库）")
    private Byte storageStatus;
    @ApiModelProperty(value = "订单号")
    private String orderNo;
}
