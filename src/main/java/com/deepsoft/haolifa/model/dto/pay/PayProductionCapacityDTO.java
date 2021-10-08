package com.deepsoft.haolifa.model.dto.pay;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;
@ApiModel(description = "生产能力DTO")
@Data
@EqualsAndHashCode()
public class PayProductionCapacityDTO {
    @ApiModelProperty(name = "id")
    private Integer id;
    @ApiModelProperty(name = "能力名称")
    private String capacityName;
    @ApiModelProperty(name = "能力代码")
    private String capacityCode;
    @ApiModelProperty(name = "价格")
    private BigDecimal capacityPrice;
}
