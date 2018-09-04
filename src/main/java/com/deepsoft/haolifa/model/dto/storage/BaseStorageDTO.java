package com.deepsoft.haolifa.model.dto.storage;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BaseStorageDTO {

    @ApiModelProperty(value = "库房Id")
    private Integer storeRoomId;

    @ApiModelProperty(value = "库房货位Id")
    private Integer storeRoomRackId;

    @ApiModelProperty(value = "库房货位号")
    private String storeRoomRackNo;

    @ApiModelProperty(value = "订单号")
    private String orderNo;
}
