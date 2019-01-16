package com.deepsoft.haolifa.model.dto;

import lombok.Data;

@Data
public class Accessory {

  private String fileName;

  private String fileUrl;

  public Accessory(){}
  public Accessory(String fileName, String fileUrl) {
    this.fileName = fileName;
    this.fileUrl = fileUrl;
  }


}
