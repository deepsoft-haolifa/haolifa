package com.deepsoft.haolifa.model.dto.autoControlEntrust;

import com.deepsoft.haolifa.model.domain.AutoControlInspectHistory;
import com.deepsoft.haolifa.model.dto.Accessory;
import com.deepsoft.haolifa.model.dto.InspectReason;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@EqualsAndHashCode(callSuper=false)
public class InspectHistoryDto extends AutoControlInspectHistory {

  private List<Accessory> accessoryList;

  private List<InspectReason> reasonList;

}
