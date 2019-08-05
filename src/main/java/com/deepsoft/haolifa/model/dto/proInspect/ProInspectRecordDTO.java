package com.deepsoft.haolifa.model.dto.proInspect;

import com.deepsoft.haolifa.model.dto.Accessory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class ProInspectRecordDTO {
    @ApiModelProperty(required = true, value = "质检记录id（更新时候用）")
    private int id;
    @ApiModelProperty(required = true, value = "订单号")
    private String orderNo;
    @ApiModelProperty(required = true, value = "成品号")
    private String productNo;
    @ApiModelProperty(required = true, value = "成品型号")
    private String productModel;
    @ApiModelProperty(required = true, value = "成品规格")
    private String productSpecifications;
    @ApiModelProperty(required = true, value = "检测数量")
    private Integer testingNumber;
    @ApiModelProperty(value = "合格数量")
    private Integer qualifiedNumber;
    @ApiModelProperty(value = "不合格数量")
    private Integer unqualifiedNumber;
    @ApiModelProperty(value = "不合格原因")
    private String reason;
    @ApiModelProperty(value = "不合格原因列表")
    private List<ProInspectReason> unqualifiedList;
    @ApiModelProperty(value = "质检记录附件")
    private List<Accessory> accessoryList;

}
