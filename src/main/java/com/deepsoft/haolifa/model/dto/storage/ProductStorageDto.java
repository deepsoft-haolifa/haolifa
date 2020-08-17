package com.deepsoft.haolifa.model.dto.storage;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author murphy.he
 **/
@Data
public class ProductStorageDto {

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "成品号")
    private String productNo;

    @ApiModelProperty(value = "记录Id")
    private Integer recordId;
}
