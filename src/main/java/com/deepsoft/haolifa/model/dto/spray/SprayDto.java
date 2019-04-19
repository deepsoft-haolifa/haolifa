package com.deepsoft.haolifa.model.dto.spray;

import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SprayDto {

  private Integer id;

  private String sprayNo;

  private String planner;

  private List<SprayItemDto> items;

  private Date createTime;

}
