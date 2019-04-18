package com.deepsoft.haolifa.model.dto.pressureInspect;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class PressureInspectRecordDTO {
    @ApiModelProperty(required = true, value = "质检记录id（更新时候用）")
    private int id;
    @ApiModelProperty(required = true, value = "订单号")
    private String orderNo;
    @ApiModelProperty(required = true, value = "成品号")
    private String productNo;
    @ApiModelProperty(value = "成品型号")
    private String productModel;
    @ApiModelProperty(value = "成品规格")
    private String productSpecifications;
    @ApiModelProperty( value = "检测数量")
    private Integer testingNumber;
    @ApiModelProperty(value = "复检数量")
    private Integer reinspectNumber;
    @ApiModelProperty(value = "合格数量")
    private Integer qualifiedNumber;
    @ApiModelProperty(value = "不合格数量")
    private Integer unqualifiedNumber;
    @ApiModelProperty(value = "不合格原因")
    private String reason;

}
