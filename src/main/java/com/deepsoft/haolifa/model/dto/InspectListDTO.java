package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.web.bind.annotation.PathVariable;

@Data
public class InspectListDTO {

    @ApiModelProperty(required = true,value = "页码")
    private Integer pageNum;
    @ApiModelProperty(required = true,value = "显示数量")
    private Integer pageSize;
    @ApiModelProperty(value = "送检单号")
    private String inspectNo;
    @ApiModelProperty(value = "关联订单号")
    private String orderNo;
    @ApiModelProperty(value = "订单号类型 0 采购单 1 机加委托订单号 2 生产订单号",allowableValues = "0,1,2")
    private Integer type;
    @ApiModelProperty(value = "送检单状态 0 未送检  1 待处理 2处理中 3处理完成",allowableValues = "0,1,2,3")
    private Integer status;

}
