package com.deepsoft.haolifa.model.dto.finance.subjectsbalance;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 科目表
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BizSubjectsBalanceUpDTO {

    @ApiModelProperty(value = "部门ID")
    private Integer deptId;

    @ApiModelProperty(value = "科目ID （二级科目）")
    private Integer subjectsId;

    @ApiModelProperty(value = "扣减/增加金额")
    private BigDecimal amount;

}
