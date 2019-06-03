package com.deepsoft.haolifa.model.dto.proInspect;

import com.deepsoft.haolifa.model.domain.ProInspectRecord;
import java.util.List;
import lombok.Data;

@Data
public class ProInspectListDTO extends ProInspectRecord {

  private List<ProInspectReason> reasonList;


}
