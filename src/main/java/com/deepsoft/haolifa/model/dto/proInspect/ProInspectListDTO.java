package com.deepsoft.haolifa.model.dto.proInspect;

import com.deepsoft.haolifa.model.domain.ProInspectRecord;
import com.deepsoft.haolifa.model.dto.Accessory;
import java.util.List;

import com.deepsoft.haolifa.model.dto.InspectReason;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString
public class ProInspectListDTO extends ProInspectRecord {

  private List<InspectReason> reasonList;

  private List<Accessory> accessoryList;


}
