package com.deepsoft.haolifa.model.dto.order;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author murphy.he
 **/
@Data
public class OrderSimpleDTO {
    @ApiModelProperty(value = "订单号")
    private String orderNo;
}
