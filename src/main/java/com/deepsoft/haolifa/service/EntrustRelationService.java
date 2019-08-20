package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.entrust.EntrustRelationDto;

public interface EntrustRelationService {

  ResultBean save(EntrustRelationDto dto);

  ResultBean delete(Integer id);

  ResultBean getRelations(String originalGraphNo);

  ResultBean getList(Integer pageNum, Integer pageSize);
}
