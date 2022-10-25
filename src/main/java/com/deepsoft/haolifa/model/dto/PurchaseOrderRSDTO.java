package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PurchaseOrderRSDTO {
    private Integer id;

    private String purchaseOrderNo;

    private String supplierNo;

    private String supplierName;

    private String demander;

    private String supplierLinkman;

    private String demanderLinkman;

    private String supplierAddr;

    private String demanderAddr;

    private String suppilerPhone;

    private String demanderPhone;

    private Date deliveryTime;

    private String operatorUserName;

    private Date operateTime;

    private String supplierConfirmer;

    private Date confirmTime;

    private Date createTime;

    private Date updateTime;

    private Byte isDelete;

    private Integer createUserId;

    private BigDecimal wreckAmount;

    private String wreckReason;

    private Byte status;

    private Byte payStatus;

    private String payType;

    private Byte orderType;

    private String fileUrl;

    private Integer totalCount;


    private Integer acceptCount;

    private Integer backCount;

    private Integer processCount;

    private BigDecimal processCharges;

    private Integer qualifiedNumber;


    private BigDecimal totalPrice;

    private BigDecimal paidAccount;

    // 开票金额
    private BigDecimal invoiceAccount;


}
