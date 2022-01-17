package com.deepsoft.haolifa.model.dto.finance.loanapply;

import com.deepsoft.haolifa.model.dto.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class LoanApplyRQDTO extends PageParam {

    @ApiModelProperty(value = "编号")
    private String serialNo;

    @ApiModelProperty(value = "状态 1 代办 2 已办")
    private Integer status;

    @ApiModelProperty(value = "借款部门名称")
    private String deptName;

    @ApiModelProperty(value = "借款人名称")
    private String loanUserName;

    @ApiModelProperty(value = "付款单位")
    private String payCompany;

    @ApiModelProperty(value = "付款状态（1未付款 2付款中 3付款完成）")
    private String payStatus;

}
