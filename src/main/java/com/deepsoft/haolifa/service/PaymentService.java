package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.PaymentDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.order.OrderConditionDTO;
import com.deepsoft.haolifa.model.dto.order.OrderListRespDTO;

import java.math.BigDecimal;

public interface PaymentService {

  ResultBean list(String orderNo);

  ResultBean delete(int id);

  ResultBean save(PaymentDTO model);

}
