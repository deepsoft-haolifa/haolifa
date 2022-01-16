package com.deepsoft.haolifa.model.dto.pay;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@ApiModel(description = "计算工资VO")
@Data
@NoArgsConstructor
public class PayWagesVO {
    @ApiModelProperty(value = "计算开始时间")
    @NonNull
    private String calculateTime;

}
