package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class EntrustListDTO {
    @ApiModelProperty(required = true, value = "页码")
    private Integer pageNum;
    @ApiModelProperty(required = true, value = "显示数量")
    private Integer pageSize;
    @ApiModelProperty(required = true, value = "申请单状态: 0 未提交 1 待处理 2 处理中 3 已完成", allowableValues = "0,1,2,3")
    private Integer status;
    @ApiModelProperty(required = true, value = "机加委托单号")
    private String entrustNo;
}
