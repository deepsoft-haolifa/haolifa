package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.PayOrderUserRelationProcedure;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayOrderUserRelationProcedureDTO;

import java.util.List;

public interface PayOrderUserRelationProcedureService {
    List<PayOrderUserRelationProcedure> getPayOrderUserRelationProcedureList();

    ResultBean insertSelective(PayOrderUserRelationProcedureDTO record);

}