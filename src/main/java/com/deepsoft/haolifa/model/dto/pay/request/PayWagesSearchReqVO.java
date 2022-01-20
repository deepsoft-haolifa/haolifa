package com.deepsoft.haolifa.model.dto.pay.request;

import com.deepsoft.haolifa.model.dto.BaseCondition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper=true)
@ApiModel(description = "工资查询入参VO")
public class PayWagesSearchReqVO extends BaseCondition {
    @ApiModelProperty(value = "部门")
    private String department;
    @ApiModelProperty(value = "姓名")
    private String userName;
    @ApiModelProperty(value = "工资月份，格式：01")
    private String wagesMonth;
    @ApiModelProperty(value = "工资年份，格式：1970")
    private String wagesYear;
}
