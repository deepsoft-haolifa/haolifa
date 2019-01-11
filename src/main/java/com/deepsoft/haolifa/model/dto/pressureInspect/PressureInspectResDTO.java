package com.deepsoft.haolifa.model.dto.pressureInspect;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class PressureInspectResDTO {
    @ApiModelProperty(value = "主键ID（更新的时候需要传）")
    private Integer id;
    @ApiModelProperty(value = "质检号（更新的时候需要传）")
    private String inspectNo;
    @ApiModelProperty(required = true, value = "订单号")
    private String orderNo;
    @ApiModelProperty(required = true, value = "检测数量")
    private Integer testingNumber;
    @ApiModelProperty(value = "复检数量")
    private Integer reinspectNumber;
    @ApiModelProperty(value = "合格数量")
    private Integer qualifiedNumber;
    @ApiModelProperty(value = "不合格数量")
    private Integer unqualifiedNumber;
    @ApiModelProperty(value = "不合格列表")
    private List<PressureInspectUnqualifiedDTO> unqualifiedList;

}
