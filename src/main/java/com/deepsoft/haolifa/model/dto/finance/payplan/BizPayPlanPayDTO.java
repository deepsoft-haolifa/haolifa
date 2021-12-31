package com.deepsoft.haolifa.model.dto.finance.payplan;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/***
 * 付款计划-付款
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BizPayPlanPayDTO {

    @ApiModelProperty(value = "ID")
    private Integer id;

    @ApiModelProperty(value = "申请付款单位")
    private String applyPayCompany;

    @ApiModelProperty(value = "总付款金额")
    private BigDecimal applyAmount;

    @ApiModelProperty(value = "付款单位")
    private String payCompany;

    @ApiModelProperty(value = "付款账号 字典PAY_ACCOUNT")
    private String payAccount;

    @ApiModelProperty(value = "付款方式; 字典PAY_WAY")
    private List<PayWayDTO> payWayList;

    //@ApiModelProperty(value = "付款类型:默认是货款")
    // private String paymentType;

    @ApiModelProperty(value = "付款状态 0.未付； 2已付款")
    private String status;

    @ApiModelProperty(value = "付款日期")
    private Date payDate;

    @ApiModelProperty(value = "备注")
    private String remark;

    @Data
    public static class PayWayDTO {

        @ApiModelProperty(value = "记账方式")
        private String bookingType;

        @ApiModelProperty(value = "付款方式")
        private String code;

        @ApiModelProperty(value = "支付金额")
        private BigDecimal amount;
    }


}
