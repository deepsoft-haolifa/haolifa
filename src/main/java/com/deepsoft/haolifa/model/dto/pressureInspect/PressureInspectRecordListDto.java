package com.deepsoft.haolifa.model.dto.pressureInspect;

import com.deepsoft.haolifa.model.domain.PressureInspectRecord;
import com.deepsoft.haolifa.model.dto.Accessory;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
public class PressureInspectRecordListDto extends PressureInspectRecord {

  private List<Accessory> accessoryList;
}
