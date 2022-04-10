package com.deepsoft.haolifa.model.dto.finance.subjectsbalance;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 科目余额表
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BizSubjectsBalanceRSDTO {


    @ApiModelProperty(value = "ID")
    private Integer id;
    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "部门ID")
    private Integer deptId;
    @ApiModelProperty(value = "部门名称")
    private String deptName;

    @ApiModelProperty(value = "科目类别")
    private Integer subjectsTypeCode;
    @ApiModelProperty(value = "科目类别中文")
    private String subjectsTypeName;

    @ApiModelProperty(value = "科目ID （二级科目）")
    private Integer subjectsId;
    @ApiModelProperty(value = "科目名称")
    private String subjectsName;

    @ApiModelProperty(value = "余额")
    private BigDecimal balanceAmount;


}
