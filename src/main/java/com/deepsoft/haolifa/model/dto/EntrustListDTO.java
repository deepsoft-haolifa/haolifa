package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class EntrustListDTO {
    @ApiModelProperty(required = true, value = "页码")
    private Integer pageNum;
    @ApiModelProperty(required = true, value = "显示数量")
    private Integer pageSize;
    @ApiModelProperty(required = true, value = "机加委托单号")
    private String entrustNo;
    @ApiModelProperty(required = true,value = "查询类别：0 全部 1 调度 2 车间 3 质检")
    private Integer type;
    @ApiModelProperty(required = true,value = "状态 0 未提交 1 审批中 2审批通过，待处理 3 处理中 4 已完成 5 审批不通过 6 全部")
    private Integer status;
}
