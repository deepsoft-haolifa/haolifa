package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.request.PayWagesSearchReqVO;

public interface PayWagesSearchService {

    ResultBean pageInfo(PayWagesSearchReqVO model);

}
