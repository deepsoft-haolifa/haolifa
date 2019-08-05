package com.deepsoft.haolifa.model.dto.spray;

import com.deepsoft.haolifa.model.domain.SprayInspectHistory;
import com.deepsoft.haolifa.model.dto.Accessory;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class SprayInspectHistoryDto extends SprayInspectHistory {

  private List<Accessory> accessoryList;

}
