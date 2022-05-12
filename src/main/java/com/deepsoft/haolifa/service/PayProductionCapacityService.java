package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayProductCapacityDTO;
import com.deepsoft.haolifa.model.vo.pay.ProcedureUserVO;

import java.util.List;

public interface PayProductionCapacityService {

    ResultBean save(PayProductCapacityDTO model);

    ResultBean getInfo(Integer capacityId);

    ResultBean edit(PayProductCapacityDTO model);

    ResultBean pageInfo(PayProductCapacityDTO model);

    ResultBean delete(Integer capacityId);

    List<ProcedureUserVO> getListByCapacityCode(String postCode);
}
