package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum.ResponseEnum;
import com.deepsoft.haolifa.dao.repository.OrderProductMapper;
import com.deepsoft.haolifa.dao.repository.PaymentManagementMapper;
import com.deepsoft.haolifa.dao.repository.PurchaseOrderMapper;
import com.deepsoft.haolifa.model.domain.OrderProduct;
import com.deepsoft.haolifa.model.domain.OrderProductExample;
import com.deepsoft.haolifa.model.domain.PaymentManagement;
import com.deepsoft.haolifa.model.domain.PaymentManagementExample;
import com.deepsoft.haolifa.model.domain.PurchaseOrder;
import com.deepsoft.haolifa.model.domain.PurchaseOrderExample;
import com.deepsoft.haolifa.model.dto.BaseException;
import com.deepsoft.haolifa.model.dto.PaymentDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.PaymentService;
import com.deepsoft.haolifa.util.DateFormatterUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentManagementMapper paymentManagementMapper;
    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;
    @Autowired
    private OrderProductMapper orderProductMapper;

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

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultBean save(PaymentDTO model) {
        if (validateIsEmpty(model)) {
            return ResultBean.error(ResponseEnum.PARAM_ERROR);
        }

        // 获取已付 or 已收货款
        PaymentManagementExample managementExample = new PaymentManagementExample();
        managementExample.createCriteria().andOrderNoEqualTo(model.getOrderNo());
        List<PaymentManagement> paymentManagements = paymentManagementMapper.selectByExample(managementExample);
        double hasRecordCount = 0.0;
        if (!CollectionUtils.isEmpty(paymentManagements)) {
            hasRecordCount = paymentManagements.stream().map(PaymentManagement::getAmount).reduce(BigDecimal.valueOf(0), (a, b) -> a.add(b)).doubleValue();
        }

        PaymentManagement paymentManagement = new PaymentManagement();
        paymentManagement.setAmount(new BigDecimal(model.getAmount()));
        paymentManagement.setOrderNo(model.getOrderNo());
        Date payTime = DateFormatterUtils.parseDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, model.getPayTime());
        paymentManagement.setPayTime(payTime);

        // 同步更新已付/已收货款
        if (model.getOrderType() == 1) {
            // 采购
            PurchaseOrderExample orderExample = new PurchaseOrderExample();
            orderExample.createCriteria().andPurchaseOrderNoEqualTo(model.getOrderNo());
            List<PurchaseOrder> purchaseOrders = purchaseOrderMapper.selectByExample(orderExample);
            if (!CollectionUtils.isEmpty(purchaseOrders)) {
                PurchaseOrder purchaseOrder = purchaseOrders.get(0);
//                if (purchaseOrder.getTotalPrice().doubleValue() < (hasRecordCount + model.getAmount())) {
//                    throw new BaseException(ResponseEnum.PAY_TOTAL_COUNT_ERROR);
//                }
                paymentManagementMapper.insertSelective(paymentManagement);
                PurchaseOrder update = new PurchaseOrder();
                update.setPaidAccount(new BigDecimal(purchaseOrder.getPaidAccount().doubleValue() + model.getAmount()));
                update.setId(purchaseOrder.getId());
                purchaseOrderMapper.updateByPrimaryKeySelective(update);
            }
        }
        if (model.getOrderType() == 2) {
            // 生产
            OrderProductExample example = new OrderProductExample();
            example.createCriteria().andOrderNoEqualTo(model.getOrderNo());
            List<OrderProduct> orderProducts = orderProductMapper.selectByExample(example);
            if (!CollectionUtils.isEmpty(orderProducts)) {
                OrderProduct orderProduct = orderProducts.get(0);
//                if (orderProduct.getTotalPrice().doubleValue() < (hasRecordCount + model.getAmount())) {
//                    throw new BaseException(ResponseEnum.PAY_TOTAL_COUNT_ERROR);
//                }
                paymentManagementMapper.insertSelective(paymentManagement);
                OrderProduct update = new OrderProduct();
                update.setId(orderProduct.getId());
                update.setReceivedAccount(new BigDecimal(model.getAmount() + orderProduct.getReceivedAccount().doubleValue()));
                orderProductMapper.updateByPrimaryKeySelective(update);
            } else {

            }
        }
        return ResultBean.success(1);
    }

    private boolean validateIsEmpty(PaymentDTO model) {
        if (model.getAmount() == null || model.getOrderType() == null || model.getAmount() == 0) {
            return true;
        }
        if (StringUtils.isAnyEmpty(model.getPayTime(), model.getOrderNo())) {
            return true;
        }
        return false;
    }
}
