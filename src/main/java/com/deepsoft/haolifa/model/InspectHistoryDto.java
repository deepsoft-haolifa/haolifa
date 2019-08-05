package com.deepsoft.haolifa.model;

import com.deepsoft.haolifa.model.domain.InspectHistory;
import com.deepsoft.haolifa.model.dto.Accessory;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
public class InspectHistoryDto extends InspectHistory {

  private List<Accessory> accessoryList;
}
