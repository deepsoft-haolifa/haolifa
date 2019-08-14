package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.rejectMaterial.RejectMaterialListDto;
import com.deepsoft.haolifa.model.dto.rejectMaterial.RejectMaterialResultDto;
import com.deepsoft.haolifa.model.dto.rejectMaterial.RejectMaterialSaveDto;

public interface RejectMaterialService {

  ResultBean save(RejectMaterialSaveDto dto);

  ResultBean delete(String recordNo);

  ResultBean updateRecordStatus(String recordNo, Integer status);

  ResultBean info(String recordNo);

  ResultBean list(RejectMaterialListDto listDto);

  ResultBean updateRecordResult(RejectMaterialResultDto resultDto);
}
