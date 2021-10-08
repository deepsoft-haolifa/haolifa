package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.*;

public interface PayAssessmentQuotaService {
    ResultBean pageInfo(PayAssessmentQuotaVO model);

    ResultBean save(PayAssessmentQuotaDTO model);

    ResultBean getInfo(Integer assessId);

    ResultBean edit(PayAssessmentQuotaDTO model);

    ResultBean delete(Integer quotaId);
}
