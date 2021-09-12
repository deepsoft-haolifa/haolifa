package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.PayWages;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayWagesDTO;

import java.util.List;

public interface PayWagesService {
    ResultBean pageInfo(PayWagesDTO model);

    ResultBean save(PayWages model);

    ResultBean getInfo(Integer wagesId);

    ResultBean edit(PayWages model);

    ResultBean delete(Integer wagesId);

    void insert(List<PayWages> objects);
}
