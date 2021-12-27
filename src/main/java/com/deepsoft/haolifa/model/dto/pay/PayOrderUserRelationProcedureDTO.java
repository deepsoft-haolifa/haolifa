package com.deepsoft.haolifa.model.dto.pay;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Author liuyaofei
 * @Date create in 下午10:45 2021/11/8
 * @description 订单人员工序关联表DTO
 */
@Data
@EqualsAndHashCode()
@ApiModel(description = "工序保存")
public class PayOrderUserRelationProcedureDTO {
    @ApiModelProperty(value = "工序ID")
    private Integer id;
    @ApiModelProperty(value = "订单ID")
    private String orderId;
    @ApiModelProperty(value = "产品ID")
    private Integer productId;
    @ApiModelProperty(value = "用户ID")
    private Integer userId;
}
