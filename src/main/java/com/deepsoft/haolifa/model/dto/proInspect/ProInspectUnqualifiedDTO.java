package com.deepsoft.haolifa.model.dto.proInspect;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class ProInspectUnqualifiedDTO {
    @ApiModelProperty(required = true, value = "不合格数量")
    private Integer unqualifiedNumber;
    @ApiModelProperty(value = "不合格原因")
    private String reason;
    @ApiModelProperty(required = true, value = "成品型号")
    private String productModel;
    @ApiModelProperty(required = true, value = "成品规格")
    private String productSpecifications;
}
