package com.deepsoft.haolifa.model.dto.spray;

import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
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

  @ApiModelProperty(value = "1订单需求;2生产库存",allowableValues = "1,2")
  private Byte busType;

}
