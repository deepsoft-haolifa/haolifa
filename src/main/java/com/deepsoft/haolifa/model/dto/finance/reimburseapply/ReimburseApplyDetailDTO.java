package com.deepsoft.haolifa.model.dto.finance.reimburseapply;

import com.deepsoft.haolifa.model.dto.finance.FileUrlDTO;
import com.deepsoft.haolifa.model.dto.finance.reimburseapply.cost.ReimburseCostDetailRSDTO;
import com.deepsoft.haolifa.model.dto.finance.reimburseapply.travel.ReimburseTravelDetailRSDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class ReimburseApplyDetailDTO {

    @ApiModelProperty(value = "ID")
    private Integer id;

    @ApiModelProperty(value = "编号")
    private String serialNo;

    @ApiModelProperty(value = "支付类型 1 对公 2 对私 三期新增字段")
    private String payType;

    @ApiModelProperty(value = "支付类型 1 对公 2 对私 三期新增字段")
    private String payTypeCN;

    @ApiModelProperty(value = "项目编号 三期新增字段")
    private String projectCode;

    @ApiModelProperty(value = "项目编号 三期新增字段")
    private String projectCodeName;

    @ApiModelProperty(value = "报销部门id")
    private Integer deptId;

    @ApiModelProperty(value = "报销部门名称")
    private String deptName;

    @ApiModelProperty(value = "报销金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "类型 1 差旅报销 2 费用报销")
    private String type;

    @ApiModelProperty(value = "类型 1 差旅报销 2 费用报销")
    private String typeCN;

    @ApiModelProperty(value = "报销方式	1普通报销 2借款冲抵")
    private String reimburseType;

    @ApiModelProperty(value = "报销方式	1普通报销 2借款冲抵")
    private String reimburseTypeCN;


    @ApiModelProperty(value = "借款冲抵  借款ID")
    private Integer loanId;

    @ApiModelProperty(value = "借款金额")
    private BigDecimal loanAmount;

    @ApiModelProperty(value = "借款冲抵")
    private BigDecimal offsetAmount;



    @ApiModelProperty(value = "报销日期")
    private Date reimburseDate;
    @ApiModelProperty(value = "报销人")
    private Integer reimburseUser;
    @ApiModelProperty(value = "报销人No")
    private String reimburseUserNo;

    @ApiModelProperty(value = "报销人名称")
    private String reimburseUserName;

    @ApiModelProperty(value = "出差人名称")
    private String travelUserName;

    @ApiModelProperty(value = "户名")
    private String accountName;

    @ApiModelProperty(value = "卡号")
    private String cardNumber;

    @ApiModelProperty(value = "开户行")
    private String bankOfDeposit;

    @ApiModelProperty(value = "审批节点")
    private String applyStatus;

    @ApiModelProperty(value = "审批节点中文")
    private String applyStatusCN;

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

    @ApiModelProperty(value = "付款状态中文")
    private String payStatusCN;

    @ApiModelProperty(value = "备注摘要")
    private String remark;


    @ApiModelProperty(value = "费用报销")
    List<ReimburseCostDetailRSDTO> reimburseCostDetailRSDTOList;

    @ApiModelProperty(value = "差旅报销")
    List<ReimburseTravelDetailRSDTO> reimburseTravelDetailRSDTOList;


    @ApiModelProperty(value = "文件 三期新增字段")
    private List<FileUrlDTO> fileUrlList;
}
