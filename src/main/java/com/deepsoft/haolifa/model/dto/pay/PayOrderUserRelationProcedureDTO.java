package com.deepsoft.haolifa.model.dto.pay;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author liuyaofei
 * @Date create in 下午10:45 2021/11/8
 * @description 订单人员工序关联表DTO
 */
@Data
@EqualsAndHashCode()
@ApiModel(description = "工时定额表")
public class PayOrderUserRelationProcedureDTO {
    @ApiModelProperty(value = "用户ID")
    private Integer userId;
    @ApiModelProperty(value = "订单ID")
    private String orderId;
    @ApiModelProperty(value = "工序ID")
    private String procedureId;
}
