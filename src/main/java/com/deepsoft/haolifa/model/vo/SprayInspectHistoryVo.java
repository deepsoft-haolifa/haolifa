package com.deepsoft.haolifa.model.vo;

import com.deepsoft.haolifa.model.domain.SprayInspectHistory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author murphy.he
 **/
@Data
public class SprayInspectHistoryVo extends SprayInspectHistory {

    @ApiModelProperty(value = "批次号")
    private String batchNumber;
}
