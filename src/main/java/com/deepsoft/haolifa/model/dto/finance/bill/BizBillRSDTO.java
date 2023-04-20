package com.deepsoft.haolifa.model.dto.finance.bill;


import com.deepsoft.haolifa.model.dto.DepartmentDTO;
import com.deepsoft.haolifa.model.dto.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 现金日记账
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class BizBillRSDTO {


    @ApiModelProperty(value = "ID")
    private Integer id;
    @ApiModelProperty(value = "序号")
    private String xh;
    @ApiModelProperty(value = "日期")
    private Date d;
    @ApiModelProperty(value = "凭证号")
    private String certificateNumber;
    @ApiModelProperty(value = "结算类别")
    private String settlementType;
    @ApiModelProperty(value = "结算票号")
    private String clearingBanks;
    @ApiModelProperty(value = "上月结转")
    private BigDecimal preMonthMoney;
    @ApiModelProperty(value = "收款")
    private BigDecimal collectionMoney;
    @ApiModelProperty(value = "收款类别")
    private String collectionType;
    @ApiModelProperty(value = "收款单位")
    private String collectionCompany;
    @ApiModelProperty(value = "付款")
    private BigDecimal payment;
    @ApiModelProperty(value = "付款类别")
    private String paymentType;
    @ApiModelProperty(value = "付款单位")
    private String paymentCompany;
    @ApiModelProperty(value = "余额")
    private BigDecimal balance;
    @ApiModelProperty(value = "类型 1=现金日记账 2=银行日记账")
    private String type;
    @ApiModelProperty(value = "部门ID")
    private String deptId;
    @ApiModelProperty(value = "部门")
    private DepartmentDTO departmentDTO;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "状态（0正常 1停用）")
    private String status;
    @ApiModelProperty(value = "删除标志（0代表存在 2代表删除）")
    private String delFlag;
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

    @ApiModelProperty(value = "收款单位")
    private String string1;

    @ApiModelProperty(value = "付款单位")
    private String string2;

    private String string3;

    private String string4;

    private String string5;

    private String string6;

    private String string7;

    private String string8;

    private String string9;

    private String string10;


    @ApiModelProperty(value = "项目编号 三期新增字段")
    private String projectCode;
    @ApiModelProperty(value = "项目编号 三期新增字段")
    private String projectCodeName;

    @ApiModelProperty(value = "科目(一级科目)")
    private String subjectType;
    @ApiModelProperty(value = "科目(一级科目)")
    private String subjectTypeName;

    @ApiModelProperty(value = "科目(费用预算表中的科目ID)")
    private Integer subject;
}
