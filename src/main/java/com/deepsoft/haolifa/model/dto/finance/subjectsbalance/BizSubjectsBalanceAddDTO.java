package com.deepsoft.haolifa.model.dto.finance.subjectsbalance;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 科目表
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BizSubjectsBalanceAddDTO {

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "部门ID")
    private Integer deptId;

    @ApiModelProperty(value = "科目类别")
    private Integer subjectsTypeCode;

    @ApiModelProperty(value = "科目ID （二级科目）")
    private Integer subjectsId;

    @ApiModelProperty(value = "余额")
    private BigDecimal balanceAmount;

}
