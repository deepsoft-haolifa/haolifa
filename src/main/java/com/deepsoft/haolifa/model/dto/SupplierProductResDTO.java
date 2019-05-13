package com.deepsoft.haolifa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

public class SupplierProductResDTO {

  private Long id;

  private String supplierNo;

  private Integer materialType;

  private String materialGraphNo;

  private String materialName;

  private String supplierName;

  public SupplierProductResDTO(Long id, String supplierNo, Integer materialType, String materialGraphNo,
      String materialName, String supplierName) {
    this.id = id;
    this.supplierNo = supplierNo;
    this.materialType = materialType;
    this.materialGraphNo = materialGraphNo;
    this.materialName = materialName;
    this.supplierName = supplierName;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSupplierNo() {
    return supplierNo;
  }

  public void setSupplierNo(String supplierNo) {
    this.supplierNo = supplierNo;
  }

  public Integer getMaterialType() {
    return materialType;
  }

  public void setMaterialType(Integer materialType) {
    this.materialType = materialType;
  }

  public String getMaterialGraphNo() {
    return materialGraphNo;
  }

  public void setMaterialGraphNo(String materialGraphNo) {
    this.materialGraphNo = materialGraphNo;
  }

  public String getMaterialName() {
    return materialName;
  }

  public void setMaterialName(String materialName) {
    this.materialName = materialName;
  }

  public String getSupplierName() {
    return supplierName;
  }

  public void setSupplierName(String supplierName) {
    this.supplierName = supplierName;
  }
}
