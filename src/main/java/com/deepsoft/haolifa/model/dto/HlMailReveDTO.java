package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("站内信回执")
@Data
public class HlMailReveDTO {


  @ApiModelProperty(required = true,value = "回复的站内信id")
  private Integer mailId;

  @ApiModelProperty(required = true,value = "内容")
  private String content;

  @ApiModelProperty(required = true,value = "回复人的id")
  private Integer userId;
  @ApiModelProperty(required = true,value = "回复人姓名")
  private String userName;

 }
