package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.PaymentDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;

public interface PaymentService {

  ResultBean list(String orderNo);

  ResultBean delete(int id);

  ResultBean save(PaymentDTO model);
}
