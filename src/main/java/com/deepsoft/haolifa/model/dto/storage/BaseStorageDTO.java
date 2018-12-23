package com.deepsoft.haolifa.model.dto.storage;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BaseStorageDTO {

    @ApiModelProperty(value = "库房No")
    private String roomNo;

    @ApiModelProperty(value = "库房货位号")
    private String rackNo;

    @ApiModelProperty(value = "订单号")
    private String orderNo;
}
