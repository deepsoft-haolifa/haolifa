package com.deepsoft.haolifa.model.vo;

import com.deepsoft.haolifa.model.domain.Spray;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author murphy.he
 **/
@Data
public class SprayVo extends Spray {

    @ApiModelProperty(value = "加工前图号")
    private String orignGraphNo;
    @ApiModelProperty(value = "加工后图号")
    private String sprayedGraphNo;
    @ApiModelProperty(value = "批次号")
    private String batchNumber;
    @ApiModelProperty(value = "出库状态（1未出库；2已出库）")
    private Byte outRoomStatus;
}
