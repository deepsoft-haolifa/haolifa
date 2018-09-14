package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 库房配置请求实体
 */
@Data
@ApiModel(value = "库房货位配置对象", description = "新增，更新库房货位实体")
public class StoreRoomRackRequestDTO {

    @ApiModelProperty(value = "库房库位主键Id", required = true)
    private Integer id;

    @ApiModelProperty(value = "库房号", required = true)
    private String storeRoomNo;
    @ApiModelProperty(value = "库位编号（全局唯一）", required = true)
    private String rackNo;
    @ApiModelProperty(value = "库位名称")
    private String rackName;
    @ApiModelProperty(value = "库位状态（1：删除；0；正常）")
    private Byte status;
    @ApiModelProperty(value = "备注")
    private String remark;
}
