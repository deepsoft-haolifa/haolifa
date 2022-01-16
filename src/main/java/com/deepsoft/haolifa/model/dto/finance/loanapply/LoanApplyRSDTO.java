package com.deepsoft.haolifa.model.dto.finance.loanapply;

import com.deepsoft.haolifa.model.dto.DepartmentDTO;
import com.deepsoft.haolifa.model.dto.UserBaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class LoanApplyRSDTO {
    @ApiModelProperty(value = "ID")
    private Integer id;

    @ApiModelProperty(value = "编号")
    private String serialNo;

    @ApiModelProperty(value = "借款部门id")
    private Integer deptId;
    @ApiModelProperty(value = "部门")
    private DepartmentDTO departmentDTO;


    @ApiModelProperty(value = "借款日期")
    private Date loanDate;

    @ApiModelProperty(value = "预计还款日期")
    private Date expectRepaymentDate;

    @ApiModelProperty(value = "借款金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "用途")
    private String purpose;

    @ApiModelProperty(value = "借款人id")
    private Integer loanUser;

    @ApiModelProperty(value = "借款人")
    private UserBaseDTO loanUserDTO;

    @ApiModelProperty(value = "资金性质（1現金 2支票）")
    private String amountType;

    @ApiModelProperty(value = "记账方式（1現金 2銀行 3 其他貨幣）")
    private String billNature;

    @ApiModelProperty(value = "户名")
    private String accountName;

    @ApiModelProperty(value = "卡号")
    private String cardNumber;

    @ApiModelProperty(value = "开户行")
    private String bankOfDeposit;

    @ApiModelProperty(value = "审批节点")
    private String applyStatus;

    @ApiModelProperty(value = "付款单位")
    private String payCompany;

    @ApiModelProperty(value = "付款单位Id")
    private String payCompanyId;

    @ApiModelProperty(value = "付款账户")
    private String payAccount;

    @ApiModelProperty(value = "付款日期")
    private Date payTime;

    @ApiModelProperty(value = "付款状态（1未付款 2付款中 3付款完成）")
    private String payStatus;

    @ApiModelProperty(value = "备注摘要")
    private String remark;

    @ApiModelProperty(value = "删除标志（0代表存在 1代表删除）")
    private String delFlag;

    @ApiModelProperty(value = "创建者")
    private Integer createUser;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新者")
    private Integer updateUser;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}
