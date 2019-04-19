package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel("站内信")
@Data
public class HlMailDTO {


  @ApiModelProperty(required = true,value = "标题")
  private String title;

  @ApiModelProperty(required = true,value = "内容")
  private String content;

  @ApiModelProperty(required = true,value = "收件人,收件人角色-名称并以逗号分隔")
  private String users;

 }
