package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 库房配置请求实体
 */
@Data
@ApiModel(value="库房配置对象",description="新增，更新库房实体")
public class StoreRoomRequestDTO {

    private Integer id;

    @ApiModelProperty(value="库房名称",name="name",required=true)
    private String name;
    @ApiModelProperty(value="库房编号（全局唯一）",name="roomNo",required=true)
    private String roomNo;
    @ApiModelProperty(value="库房类型（1：成品库；2：原料库）",name="type",required=true)
    private Byte type;
    @ApiModelProperty(value="库房状态（1：正常；0删除；）",name="status",required=true)
    private Byte status;
    @ApiModelProperty(value="库房地址",name="address")
    private String address;
    @ApiModelProperty(value="备注",name="remark")
    private String remark;
}
