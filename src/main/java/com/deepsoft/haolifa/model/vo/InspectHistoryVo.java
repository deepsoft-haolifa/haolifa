package com.deepsoft.haolifa.model.vo;

import com.deepsoft.haolifa.model.domain.InspectHistory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class InspectHistoryVo extends InspectHistory{

    @ApiModelProperty(value = "委托单类型")
    private Byte busType;
}
