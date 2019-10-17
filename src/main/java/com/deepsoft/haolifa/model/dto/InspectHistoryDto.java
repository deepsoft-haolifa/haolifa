package com.deepsoft.haolifa.model.dto;

import com.deepsoft.haolifa.model.domain.InspectHistory;
import com.deepsoft.haolifa.model.dto.Accessory;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString
public class InspectHistoryDto extends InspectHistory {

  private List<Accessory> accessoryList;

  private List<InspectReason> reasonList;
}
