package com.deepsoft.haolifa.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class MessageVO {

    @ApiModelProperty(value = "信息id", required = false)
    private Integer id;
    @ApiModelProperty(value = "展示日期", required = true)
    private Date showTime;
    @ApiModelProperty(value = "内容", required = true)
    private String content;
    @ApiModelProperty(value = "类型：1-新闻，2-消息", required = true)
    private Byte type;

}
