package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class EntrustListDTO extends PageParam {
    @ApiModelProperty(required = true, value = "机加委托单号")
    private String entrustNo;
    @ApiModelProperty(required = true, value = "查询类别：0 全部 1 调度 2 车间 3 质检")
    private Integer type;
    @ApiModelProperty(value = "状态 0 未提交 1 审批中 2 审批通过，待处理 3 处理中 4 已完成 5 审批不通过 6 全部")
    private Integer status;
    @ApiModelProperty(value = "质检状态 1质检中 2质检完成")
    private Integer inspectStatus;
    @ApiModelProperty(value = "批次号")
    private String batchNumber;
}
