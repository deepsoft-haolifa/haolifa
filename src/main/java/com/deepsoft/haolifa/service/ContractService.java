package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.ResultBean;

public interface ContractService {

    ResultBean list(String orderNo, Integer pageNum, Integer pageSize);

    ResultBean info(String orderNo);
}
