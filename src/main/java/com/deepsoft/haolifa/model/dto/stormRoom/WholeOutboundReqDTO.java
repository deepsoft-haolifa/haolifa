package com.deepsoft.haolifa.model.dto.stormRoom;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 整单出库
 *
 * @author murphy.he
 **/
@Data
public class WholeOutboundReqDTO {
    @ApiModelProperty(value = "单据号")
    private String busNo;
    @ApiModelProperty(value = "出库类型（1.领料单出库；2.机加工委托；3.喷涂委托）")
    private Byte type;
}
