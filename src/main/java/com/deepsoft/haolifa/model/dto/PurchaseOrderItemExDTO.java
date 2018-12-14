package com.deepsoft.haolifa.model.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class PurchaseOrderItemExDTO {
  private Integer id;

  private String purchaseOrderNo;

  private String materialName;

  private String materialGraphNo;

  private String specification;

  private String material;

  private String unit;

  private Integer number;

  private BigDecimal unitWeight;

  private BigDecimal unitPrice;

  private String remark;

  private Double totalAmount;

  private Double totalWeight;
}
