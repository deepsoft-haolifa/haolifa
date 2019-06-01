package com.deepsoft.haolifa.model.dto.export;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ExportExpensesDTO {

  @ApiModelProperty("开始时间")
  private String startDate;

  @ApiModelProperty("结束时间")
  private String endDate;

  @ApiModelProperty("部门")
  private String department;

  @ApiModelProperty("一级分类")
  private String firstClassifyName;

  @ApiModelProperty("二级分类")
  private String secondClassifyName;

}
