package com.deepsoft.haolifa.dao.repository.extend;

import com.deepsoft.haolifa.model.domain.Inspect;
import com.deepsoft.haolifa.model.dto.InspectListDTO;

import java.util.List;

public interface InspectExtendMapper {

    void batchInsertInspect(List<Inspect> inspectList);

    void selectInspectDistinctList(InspectListDTO model);
}
