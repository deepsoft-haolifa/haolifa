package com.deepsoft.haolifa.model.dto.pay;

import com.deepsoft.haolifa.model.dto.BaseCondition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@ApiModel(description = "计算工资VO")
@Data
@EqualsAndHashCode(callSuper=true)
public class PayWagesVO extends BaseCondition {
    @ApiModelProperty(value = "计算开始时间")
    private String startCreateTime;
    @ApiModelProperty(value = "计算结束时间")
    private String endCreateTime;

}
