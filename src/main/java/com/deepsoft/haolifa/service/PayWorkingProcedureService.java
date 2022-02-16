package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayWorkingProcedureDTO;

import java.util.List;

public interface PayWorkingProcedureService {

    ResultBean pageInfo(PayWorkingProcedureDTO model);

    ResultBean getAllList(PayWorkingProcedureDTO model);

    ResultBean save(PayWorkingProcedureDTO model);

    ResultBean save(List<PayWorkingProcedureDTO> list);

    ResultBean getInfo(Integer id);

    ResultBean edit(PayWorkingProcedureDTO model);

    ResultBean delete(Integer id);

    ResultBean assignTask(String orderNo, String type);
}
