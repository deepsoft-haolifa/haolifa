package com.deepsoft.haolifa.model.dto.spray;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SprayInspectDto {


  private String sprayNo;

  private String materialGraphNo;

  private String originalGraphNo;

  private String materialGraphName;

  private Integer testNumber;

  private Integer qualifiedNumber;

  private Integer unqualifiedNumber;

  private String handlingSuggestion;

  private String remark;

}
