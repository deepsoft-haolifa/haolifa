package com.deepsoft.haolifa.model.dto.pay;

import com.deepsoft.haolifa.model.dto.BaseCondition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
@ApiModel(description = "生产能力DTO")
@Data
@EqualsAndHashCode(callSuper=false)
public class PayProductCapacityDTO extends BaseCondition {
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "用户名称")
    private String userName;
    @ApiModelProperty(value = "班组ID")
    private Integer teamId;
    @ApiModelProperty(value = "部门ID")
    private Integer departId;
    @ApiModelProperty(value = "部门名称")
    private String departName;
    @ApiModelProperty(value = "能力代码")
    private String capacityCode;

}
