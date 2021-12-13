package com.deepsoft.haolifa.model.dto.finance.bankbill;

import com.deepsoft.haolifa.model.dto.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/***
 * 银行日记账
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BizBankBillDTO extends PageParam {


    // query
    @ApiModelProperty(value = "查询条件-开始日期")
    private Date operateDateStart;
    @ApiModelProperty(value = "查询条件-结束日期")
    private Date operateDateEnd;



    @ApiModelProperty(value = "ID")
    private Integer id;
    @ApiModelProperty(value = "公司（收款是收款公司，付款是付款公司")
    private String company;
    @ApiModelProperty(value = "账户（公司下面的某个银行)用来计算余额")
    private String account;
    @ApiModelProperty(value = "序号")
    private String serialNo;
    @ApiModelProperty(value = "日期")
    private Date operateDate;
    @ApiModelProperty(value = "查询条件-凭证号")
    private String certificateNumber;
    @ApiModelProperty(value = "收付款方式")
    private String payWay;
    @ApiModelProperty(value = "查询条件-收付款账户")
    private String payAccount;
    @ApiModelProperty(value = "付款单位")
    private String payCompany;
    @ApiModelProperty(value = "付款单位Id")
    private String payCompanyId;
    @ApiModelProperty(value = "查询条件-收款单位")
    private String collectCompany;
    @ApiModelProperty(value = "上月结转")
    private BigDecimal preMonthMoney;
    @ApiModelProperty(value = "收款")
    private BigDecimal collectionMoney;
    @ApiModelProperty(value = "收款类别")
    private String collectionType;
    @ApiModelProperty(value = "付款")
    private BigDecimal payment;
    @ApiModelProperty(value = "查询条件-付款类别")
    private String paymentType;
    @ApiModelProperty(value = "余额（某个公司，某个账户下面）")
    private BigDecimal balance;
    @ApiModelProperty(value = "类型 1.收款；2.付款")
    private String type;
    @ApiModelProperty(value = "部门ID")
    private Integer deptId;
    @ApiModelProperty(value = "备注摘要")
    private String remark;
    @ApiModelProperty(value = "删除标志（0代表存在 1代表删除）")
    private String delFlag;
    @ApiModelProperty(value = "收款合同分解状态；0未完成；1.完成")
    private String contractStatus;
    @ApiModelProperty(value = "创建者")
    private Integer contractUser;
    @ApiModelProperty(value = "创建者")
    private Integer createUser;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "更新者")
    private Integer updateUser;
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}
