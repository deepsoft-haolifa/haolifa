package com.deepsoft.haolifa.model.dto.valveSeat;

import com.deepsoft.haolifa.model.domain.ValveSeatInspectHistory;
import com.deepsoft.haolifa.model.dto.Accessory;
import com.deepsoft.haolifa.model.dto.InspectReason;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class ValveSeatInspectHistoryDto extends ValveSeatInspectHistory {

    @ApiModelProperty("附件列表")
    private List<Accessory> accessoryList;
    @ApiModelProperty("原因列表")
    private List<InspectReason> reasonList;

}
