package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.PayHourQuota;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayHourQuotaDTO;

import java.util.List;

public interface PayHourQuotaService {
    ResultBean pageInfo(PayHourQuotaDTO model);

    ResultBean save(PayHourQuotaDTO model);

    ResultBean getInfo(Integer id);

    ResultBean edit(PayHourQuotaDTO model);

    ResultBean delete(Integer id);

    List<PayHourQuota> getList(PayHourQuotaDTO model);
}

