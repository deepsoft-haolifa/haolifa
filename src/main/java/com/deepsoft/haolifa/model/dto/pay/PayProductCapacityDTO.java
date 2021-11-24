package com.deepsoft.haolifa.model.dto.pay;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
@ApiModel(description = "生产能力DTO")
@Data
@EqualsAndHashCode(callSuper=false)
public class PayProductCapacityDTO {
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "能力名称")
    private String capacityName;
    @ApiModelProperty(value = "能力代码")
    private String capacityCode;
    @ApiModelProperty(value = "价格")
    private BigDecimal capacityPrice;
}
