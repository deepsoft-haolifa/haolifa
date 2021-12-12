package com.deepsoft.haolifa.model.dto.finance.receivable;

import com.deepsoft.haolifa.model.dto.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/***
 * 应收货款
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PurchaseOrderReceivableDTO extends PageParam {

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "Query-订单编号")
    private String purchaseOrderNo;

    @ApiModelProperty(value = "Query-供应商编号")
    private String supplierNo;

    @ApiModelProperty(value = "Query-提供方")
    private String supplierName;

    @ApiModelProperty(value = "需方")
    private String demander;

    @ApiModelProperty(value = "供方联系人")
    private String supplierLinkman;

    @ApiModelProperty(value = "需方联系人")
    private String demanderLinkman;

    @ApiModelProperty(value = "供方地址")
    private String supplierAddr;

    @ApiModelProperty(value = "需方地址")
    private String demanderAddr;

    @ApiModelProperty(value = "供方联系人电话")
    private String suppilerPhone;

    @ApiModelProperty(value = "需方联系人电话")
    private String demanderPhone;

    @ApiModelProperty(value = "Query-交货日期")
    private Date deliveryTime;

    @ApiModelProperty(value = "Query-订单经办人")
    private String operatorUserName;

    @ApiModelProperty(value = "Query-经办日期")
    private Date operateTime;

    @ApiModelProperty(value = "供方确认人")
    private String supplierConfirmer;

    @ApiModelProperty(value = "确认时间")
    private Date confirmTime;

    @ApiModelProperty(value = "创建日期")
    private Date createTime;

    @ApiModelProperty(value = "更新日期")
    private Date updateTime;


    @ApiModelProperty(value = "创建者id")
    private Integer createUserId;

    @ApiModelProperty(value = "折损金额")
    private BigDecimal wreckAmount;

    @ApiModelProperty(value = "折损原因")
    private String wreckReason;

    @ApiModelProperty(value = "订单状态：1 待审批 2 审批中 3 采购中 4 审批不通过 5 采购完成")
    private Byte status;

    @ApiModelProperty(value = "付款方式")
    private String payType;

    @ApiModelProperty(value = "0 采购订单 1 外部机加工订单")
    private Byte orderType;

    @ApiModelProperty(value = "订单附件下载地址")
    private String fileUrl;

    @ApiModelProperty(value = "合同采购总数量")
    private Integer totalCount;

    @ApiModelProperty(value = "让步接收数量")
    private Integer acceptCount;

    @ApiModelProperty(value = "退货数量")
    private Integer backCount;

    @ApiModelProperty(value = "加工数量")
    private Integer processCount;

    @ApiModelProperty(value = "加工费用")
    private BigDecimal processCharges;

    @ApiModelProperty(value = "检验合格数量")
    private Integer qualifiedNumber;

    @ApiModelProperty(value = "合同总金额")
    private BigDecimal totalPrice;

    @ApiModelProperty(value = "已付货款")
    private BigDecimal paidAccount;
}
