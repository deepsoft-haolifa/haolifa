package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.PayWages;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayWagesDTO;
import com.deepsoft.haolifa.model.dto.pay.PayWagesSaveVO;
import com.deepsoft.haolifa.model.dto.pay.PayWagesVO;

import java.util.List;

public interface PayWagesService {
    ResultBean pageInfo(PayWagesDTO model);

    ResultBean save(PayWagesSaveVO model);

    ResultBean getInfo(Integer wagesId);

    ResultBean edit(PayWagesSaveVO model);

    ResultBean delete(Integer wagesId);

    void insert(List<PayWages> objects);

    ResultBean calculateSalary(PayWagesVO payWagesVO) throws Exception;

    public ResultBean test (Integer userId);

    }
