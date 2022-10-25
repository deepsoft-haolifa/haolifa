package com.deepsoft.haolifa.model.dto.autoControl;

import com.deepsoft.haolifa.model.domain.AutoControlInspectHistory;
import com.deepsoft.haolifa.model.dto.Accessory;
import com.deepsoft.haolifa.model.dto.InspectReason;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
public class AutoControlInspectHistoryDto extends AutoControlInspectHistory {

    @ApiModelProperty("附件列表")
    private List<Accessory> accessoryList;
    @ApiModelProperty("原因列表")
    private List<InspectReason> reasonList;

}
