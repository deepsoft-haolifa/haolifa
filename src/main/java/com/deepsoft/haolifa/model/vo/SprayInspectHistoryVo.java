package com.deepsoft.haolifa.model.vo;

import com.deepsoft.haolifa.model.domain.SprayInspectHistory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author murphy.he
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class SprayInspectHistoryVo extends SprayInspectHistory {

    @ApiModelProperty(value = "批次号")
    private String batchNumber;

    @ApiModelProperty(value = "委托单类型")
    private Byte busType;
}
