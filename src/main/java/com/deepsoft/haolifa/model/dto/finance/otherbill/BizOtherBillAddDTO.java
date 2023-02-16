package com.deepsoft.haolifa.model.dto.finance.otherbill;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/***
 * 其他货币资金日记账-添加
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BizOtherBillAddDTO {

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
    @ApiModelProperty(value = "创建者")
    private Integer contractUser;


    @ApiModelProperty(value = "项目编号 三期新增字段")
    private String projectCode;

    @ApiModelProperty(value = "科目(费用预算表中的科目ID)")
    private Integer subject;

}
