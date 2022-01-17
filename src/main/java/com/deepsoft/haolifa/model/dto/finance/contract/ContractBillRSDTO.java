package com.deepsoft.haolifa.model.dto.finance.contract;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/***
 * 日记账
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ContractBillRSDTO {

    @ApiModelProperty(value = "记账类型 0||null 全部 2.银行日记账；3.其他货币日记账")
    private String billType;
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "公司（收款是收款公司，付款是付款公司")
    private String company;
    @ApiModelProperty(value = "账户（公司下面的某个银行)用来计算余额")
    private String account;
    @ApiModelProperty(value = "序号")
    private String serialNo;
    @ApiModelProperty(value = "日期")
    private Date operateDate;
    @ApiModelProperty(value = "凭证号")
    private String certificateNumber;
    @ApiModelProperty(value = "收付款方式")
    private String payWay;
    @ApiModelProperty(value = "收付款账户")
    private String payAccount;
    @ApiModelProperty(value = "付款单位")
    private String payCompany;
    @ApiModelProperty(value = "付款单位Id")
    private String payCompanyId;
    @ApiModelProperty(value = "收款单位")
    private String collectCompany;
    @ApiModelProperty(value = "收款")
    private BigDecimal collectionMoney;
    @ApiModelProperty(value = "收款类别")
    private String collectionType;
    @ApiModelProperty(value = "付款")
    private BigDecimal payment;
    @ApiModelProperty(value = "上月结转")
    private BigDecimal preMonthMoney;
    @ApiModelProperty(value = "余额")
    private BigDecimal balance;

    @ApiModelProperty(value = "付款类别")
    private String paymentType;
    @ApiModelProperty(value = "类型 1.收款；2.付款")
    private String type;
    @ApiModelProperty(value = "部门ID")
    private Integer deptId;
    @ApiModelProperty(value = "备注摘要")
    private String remark;
    @ApiModelProperty(value = "收款合同分解状态；0未完成；1.完成")
    private String contractStatus;
    @ApiModelProperty(value = "")
    private Integer contractUser;

    private Integer createUser;

    private Date createTime;

    private Integer updateUser;

    private Date updateTime;

}
