package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayProductCapacityDTO;

public interface PayProductionCapacityService {

    ResultBean save(PayProductCapacityDTO model);

    ResultBean getInfo(Integer capacityId);

    ResultBean edit(PayProductCapacityDTO model);

    ResultBean pageInfo(Integer pageSize, Integer pageNumber, String capacityName, String capacityCode);

    ResultBean delete(Integer capacityId);
}
