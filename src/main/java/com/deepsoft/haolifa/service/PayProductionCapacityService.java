package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayAssessmentQuotaDTO;
import com.deepsoft.haolifa.model.dto.pay.PayAssessmentQuotaVO;
import com.deepsoft.haolifa.model.dto.pay.PayProductionCapacityDTO;

public interface PayProductionCapacityService {

    ResultBean save(PayProductionCapacityDTO model);

    ResultBean getInfo(Integer capacityId);

    ResultBean edit(PayProductionCapacityDTO model);

    ResultBean pageInfo(Integer pageSize, Integer pageNumber, String capacityName, String capacityCode);

    ResultBean delete(Integer capacityId);
}
