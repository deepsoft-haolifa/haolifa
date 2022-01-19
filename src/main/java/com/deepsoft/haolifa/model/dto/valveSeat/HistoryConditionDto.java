package com.deepsoft.haolifa.model.dto.valveSeat;

import com.deepsoft.haolifa.model.dto.BaseCondition;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author murphy.he
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class HistoryConditionDto extends BaseCondition {
    @ApiModelProperty("委托单号")
    private String entrustNo;

    @ApiModelProperty("图号")
    private String graphNo;

    @ApiModelProperty("状态：1 待入库 2 已入库")
    private Byte status;

}
