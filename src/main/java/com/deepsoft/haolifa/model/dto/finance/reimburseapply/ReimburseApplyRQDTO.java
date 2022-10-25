package com.deepsoft.haolifa.model.dto.finance.reimburseapply;

import com.deepsoft.haolifa.model.dto.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class ReimburseApplyRQDTO extends PageParam {


    @ApiModelProperty(value = "类型 1 差旅报销 2 费用报销")
    private String type;

    @ApiModelProperty(value = "支付类型 1 对公 2 对私 三期新增字段")
    private String payType;

    @ApiModelProperty(value = "项目编号 三期新增字段")
    private String projectCode;


    private String myself;

    @ApiModelProperty(value = "编号")
    private String serialNo;


    @ApiModelProperty(value = "报销部门id")
    private Integer deptId;

    @ApiModelProperty(value = "报销部门")
    private String deptName;

    @ApiModelProperty(value = "报销人")
    private String reimburseUser;

}
