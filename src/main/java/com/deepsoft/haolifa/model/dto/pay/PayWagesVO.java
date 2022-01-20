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
    @ApiModelProperty(value = "年, 格式：1970")
    @NonNull
    private String year;

    @ApiModelProperty(value = "月份，格式：01")
    @NonNull
    private String month;

}
