package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.spraycolor.SprayColorDto;

public interface SprayColorService {

  ResultBean save(SprayColorDto dto);

  ResultBean delete(Integer id);

  ResultBean getAll();

  ResultBean getList(Integer pageNum, Integer pageSize);
}
