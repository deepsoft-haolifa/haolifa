package com.deepsoft.haolifa.model.dto.spray;

import com.deepsoft.haolifa.model.domain.SprayInspectHistory;
import com.deepsoft.haolifa.model.dto.Accessory;
import java.util.List;

import com.deepsoft.haolifa.model.dto.InspectReason;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(callSuper=false)
public class SprayInspectHistoryDto extends SprayInspectHistory {

  private List<Accessory> accessoryList;

  private List<InspectReason> reasonList;

}
