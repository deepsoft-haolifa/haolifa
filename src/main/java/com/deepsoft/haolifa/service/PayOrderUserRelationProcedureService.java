package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.PayOrderUserRelationProcedure;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.vo.pay.PayOrderUserRelationProcedureVO;

import java.util.List;

public interface PayOrderUserRelationProcedureService {
    List<PayOrderUserRelationProcedure> getPayOrderUserRelationProcedureList(PayOrderUserRelationProcedure payOrderUserRelationProcedure);

    ResultBean insertSelective(PayOrderUserRelationProcedureVO procedure);

    ResultBean insertEntrustSelective(PayOrderUserRelationProcedureVO procedure);

}
