package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum.ResponseEnum;
import com.deepsoft.haolifa.dao.repository.PaymentManagementMapper;
import com.deepsoft.haolifa.model.domain.PaymentManagement;
import com.deepsoft.haolifa.model.domain.PaymentManagementExample;
import com.deepsoft.haolifa.model.dto.PaymentDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.PaymentService;
import com.deepsoft.haolifa.util.DateFormatterUtils;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

  @Autowired
  private PaymentManagementMapper paymentManagementMapper;

  @Override
  public ResultBean list(String orderNo) {
    PaymentManagementExample example = new PaymentManagementExample();
    example.createCriteria().andOrderNoEqualTo(orderNo);
    List<PaymentManagement> pays = paymentManagementMapper.selectByExample(example);
    return ResultBean.success(pays);
  }

  @Override
  public ResultBean delete(int id) {
    paymentManagementMapper.deleteByPrimaryKey(id);
    return ResultBean.success(1);
  }

  @Override
  public ResultBean save(PaymentDTO model) {
    if(validateIsEmpty(model)) {
      return ResultBean.error(ResponseEnum.PARAM_ERROR);
    }
    PaymentManagement paymentManagement = new PaymentManagement();
    paymentManagement.setAmount(new BigDecimal(model.getAmount()));
    paymentManagement.setOrderNo(model.getOrderNo());
    Date payTime = DateFormatterUtils.parseDateString(DateFormatterUtils.TWO_FORMATTERPATTERN,model.getPayTime());
    paymentManagement.setPayTime(payTime);
    paymentManagementMapper.insertSelective(paymentManagement);
    return ResultBean.success(1);
  }

  private boolean validateIsEmpty(PaymentDTO model) {
    if (model.getAmount() == null || model.getAmount() == 0)
      return true;
    if(StringUtils.isAnyEmpty(model.getPayTime(),model.getOrderNo()))
      return true;
    return false;
  }
}
