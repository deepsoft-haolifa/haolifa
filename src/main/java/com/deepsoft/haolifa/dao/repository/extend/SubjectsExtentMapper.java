package com.deepsoft.haolifa.dao.repository.extend;

import com.deepsoft.haolifa.model.dto.finance.BizSubjectsDTO;
import com.deepsoft.haolifa.model.dto.finance.BizSubjectsListDTO;

import java.util.List;

public interface SubjectsExtentMapper {

  List<BizSubjectsDTO> getSubjects(BizSubjectsListDTO params);

}
