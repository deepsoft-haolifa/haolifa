package com.deepsoft.haolifa.model.dto.spray;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SprayListDto {

  private String sprayNo;

  private Integer pageNum;

  private Integer pageSize;

  private Integer status;

  private Integer type;
}
