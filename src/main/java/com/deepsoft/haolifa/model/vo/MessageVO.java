package com.deepsoft.haolifa.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class MessageVO {

    @ApiModelProperty(value = "信息id")
    private Integer id;
    @ApiModelProperty(value = "展示日期")
    @JsonFormat(pattern = "yyyy-MM-dd",  timezone="GMT+8")
    private Date showTime;
    @ApiModelProperty(value = "标题", required = true)
    private String title;
    @ApiModelProperty(value = "内容", required = true)
    private String content;
    @ApiModelProperty(value = "类型：1-新闻，2-消息", required = true)
    private Byte type;
    @ApiModelProperty(value = "添加时间")
    private Date createTime;
}
