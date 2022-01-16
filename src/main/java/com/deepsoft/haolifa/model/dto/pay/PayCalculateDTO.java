package com.deepsoft.haolifa.model.dto.pay;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import java.util.Date;

@ApiModel(description = "计算工资DTO")
@Data
@EqualsAndHashCode()
public class PayCalculateDTO {
    @ApiModelProperty(value = "订单号")
    private String orderNo;
    @ApiModelProperty(value = "产品编号")
    private String productNo;
    @ApiModelProperty(value = "入库状态")
    private Byte storageStatus;
    @ApiModelProperty(value = "计算开始时间")
    private Date startTime;
    @ApiModelProperty(value = "计算结束时间")
    private Date endTime;

}
