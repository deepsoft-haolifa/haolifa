package com.deepsoft.haolifa.model.dto.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @className: OrderUpdateDTO
 * @description: 订单更新的相关字段
 * @author: hedong@ibeesaas.com
 * @date: 2018-11-27 20:09
 **/
@Data
@ApiModel
public class OrderContractUpdateDTO {

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "订单合同Url")
    private String orderContractUrl;

    @ApiModelProperty(value = "type：1修改有价格的；0修改无价格的")
    private Integer type;
}
