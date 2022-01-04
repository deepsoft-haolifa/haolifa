package com.deepsoft.haolifa.model.dto.finance.bankbill;

import com.deepsoft.haolifa.model.dto.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

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

    @ApiModelProperty(value = "查询条件-凭证号")
    private String certificateNumber;

    @ApiModelProperty(value = "查询条件-收付款账户")
    private String payAccount;

    @ApiModelProperty(value = "查询条件-收款单位")
    private String collectCompany;

    @ApiModelProperty(value = "查询条件-付款类别")
    private String paymentType;

    @ApiModelProperty(value = "类型 1.收款；2.付款")
    private String type;

}
