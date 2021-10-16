package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayWorkingProcedureDTO;

public interface PayWorkingProcedureService {

    ResultBean pageInfo(PayWorkingProcedureDTO model);

    ResultBean save(PayWorkingProcedureDTO model);

    ResultBean getInfo(Integer id);

    ResultBean edit(PayWorkingProcedureDTO model);

    ResultBean delete(Integer id);
}
