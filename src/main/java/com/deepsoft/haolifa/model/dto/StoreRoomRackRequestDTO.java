package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 库房配置请求实体
 */
@Data
@ApiModel(value="库房货位配置对象",description="新增，更新库房货位实体")
public class StoreRoomRackRequestDTO {

    @ApiModelProperty(value="库房库位主键Id",required=true)
    private Integer id;

    @ApiModelProperty(value="库房Id",required=true)
    private Integer storeRoomId;
    @ApiModelProperty(value="货位编号（全局唯一）",required=true)
    private String stackNo;
    @ApiModelProperty(value="货位状态（1：删除；0；正常）",required=true)
    private Byte status;
    @ApiModelProperty(value="备注")
    private String remark;
}
