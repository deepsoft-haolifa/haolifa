package com.deepsoft.haolifa.model.dto.finance.contract;

import com.deepsoft.haolifa.model.dto.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/***
 * 日记账
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ContractBillRQDTO extends PageParam {

    @ApiModelProperty(value = "记账类型 0||null 全部 1.银行日记账；2.其他货币日记账")
    private String billType;

    // query
    @ApiModelProperty(value = "查询条件-开始日期")
    private Date operateDateStart;
    @ApiModelProperty(value = "查询条件-结束日期")
    private Date operateDateEnd;

    @ApiModelProperty(value = "查询条件-凭证号")
    private String certificateNumber;

    @ApiModelProperty(value = "查询条件-收付款账户")
    private String payAccount;

    @ApiModelProperty(value = "查询条件-收款单位")
    private String collectCompany;

    @ApiModelProperty(value = "查询条件-付款单位")
    private String payCompany;

    @ApiModelProperty(value = "查询条件-付款类别")
    private String paymentType;

}
