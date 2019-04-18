package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.spray.SprayDto;
import com.deepsoft.haolifa.model.dto.spray.SprayInspectDto;
import com.deepsoft.haolifa.model.dto.spray.SprayListDto;

public interface SprayService {

  ResultBean save(SprayDto sprayDto);

  ResultBean delete(String sprayNo);

  ResultBean update(SprayDto sprayDto);

  ResultBean getSprayInfo(int id);

  ResultBean forms(SprayListDto listDto);

  ResultBean updateStatus(String sprayNo, int status);

  ResultBean getInspectList(String sprayNo);

  ResultBean getItemsList(String sprayNo);

  ResultBean saveInspect(SprayInspectDto inspectDto);
}
