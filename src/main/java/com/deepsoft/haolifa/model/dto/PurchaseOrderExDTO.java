package com.deepsoft.haolifa.model.dto;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class PurchaseOrderExDTO {

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

  private String payType;

  private Integer orderNumber;

  private Double totalWeight;

  private Double totalPrice;

  private Integer totalCount;

  private Double paidAccount;

  private Integer acceptCount;

  private Integer orderType;

  private String fileUrl;
}
