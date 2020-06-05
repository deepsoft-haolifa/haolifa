package com.deepsoft.haolifa.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class FlowHistoryAccessoryDTO {

    @ApiModelProperty(required = true, value = "流程historyId")
    private Integer historyId;

    @ApiModelProperty(value = "附件信息")
    private List<Accessory> accessorys;
}
