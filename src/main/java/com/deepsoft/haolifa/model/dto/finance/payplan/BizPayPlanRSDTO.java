package com.deepsoft.haolifa.model.dto.finance.payplan;

import com.deepsoft.haolifa.model.dto.PageParam;
import com.deepsoft.haolifa.model.dto.finance.payplanlog.BizPayPlanPayLogDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/***
 * 付款计划
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BizPayPlanRSDTO {


    @ApiModelProperty(value = "ID")
    private Integer id;

    @ApiModelProperty(value = "付款申请Id")
    private Long payDataId;

    @ApiModelProperty(value = "申请编号")
    private String applyNo;

    @ApiModelProperty(value = "申请日期")
    private Date applyDate;

    @ApiModelProperty(value = "采购合同ID")
    private String contractId;

    @ApiModelProperty(value = "采购合同号")
    private String contractNo;

    @ApiModelProperty(value = "采购合同付款方式")
    private String contractPayWay;

    @ApiModelProperty(value = "申请付款单位")
    private String applyPayCompany;

    @ApiModelProperty(value = "收款单位")
    private String applyCollectionCompany;

    @ApiModelProperty(value = "付款金额")
    private BigDecimal applyAmount;

    @ApiModelProperty(value = "付款单位")
    private String payCompany;

    @ApiModelProperty(value = "付款账号")
    private String payAccount;

    @ApiModelProperty(value = "付款类型:默认是货款")
    private String paymentType;

    @ApiModelProperty(value = "付款日期")
    private Date payDate;

    @ApiModelProperty(value = "付款方式;")
    private String payWay;

    @ApiModelProperty(value = "记账方式：1.现金日记账；2.银行日记账；")
    private String bookingType;

    @ApiModelProperty(value = "付款方式list")
    private List<BizPayPlanPayLogDTO> payWayList;

    @ApiModelProperty(value = "记账方式list：1.现金日记账；2.银行日记账；")
    private List<String> bookingTypeList;


    @ApiModelProperty(value = "付款状态 0.未付；1.付款中 2已付款")
    private String status;

    /***
     *    //1 待审批 2 审批中 3 付款中 4 审批不通过 5 付款完成
     *     PENDING_APPROVAL("1", "待审批"),
     *     UNDER_APPROVAL("2", "审批中"),
     *     IN_PAYMENT("3", "付款中"),
     *     APPROVAL_FAILED("4", "审批不通过"),
     *     PAYMENT_COMPLETED("5", "付款完成");
     */
    @ApiModelProperty(value = "审核状态 1 待审批 2 审批中 3 付款中 4 审批不通过 5 付款完成")
    private String applyStatus;

    @ApiModelProperty(value = "数据状态：0财务主管选择；1.出纳付款")
    private String dataStatus;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "删除标志（0代表存在 2代表删除）")
    private String delFlag;
    @ApiModelProperty(value = "创建者")
    private Integer createUser;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "更新者")
    private Integer updateUser;
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
    @ApiModelProperty(value = "按钮权限")
    private Permission permission;

    @ApiModelProperty(value = "是否出纳角色付款（出纳角色可显示付款按钮）")
    private Boolean isCN = false;
    @ApiModelProperty(value = "是否可确认")
    private Boolean canConfirm = false;


    @Data
    public static class Permission {
        @ApiModelProperty(value = "是否可付款（出纳角色可显示付款按钮）")
        private Boolean canPay = false;

        @ApiModelProperty(value = "是否可确认")
        private Boolean canConfirm = false;
    }

}
