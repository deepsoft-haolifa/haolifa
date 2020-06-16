package com.deepsoft.haolifa.service.impl;

import static com.deepsoft.haolifa.constant.CacheKey.TOTAL_INVENTORY_MATERIAL;
import static com.deepsoft.haolifa.constant.CacheKey.TOTAL_MONEY_ORDER;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import com.deepsoft.haolifa.cache.redis.RedisDaoImpl;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.constant.CommonEnum.Consts;
import com.deepsoft.haolifa.dao.repository.InvoiceMapper;
import com.deepsoft.haolifa.dao.repository.MaterialMapper;
import com.deepsoft.haolifa.dao.repository.OrderProductMapper;
import com.deepsoft.haolifa.dao.repository.extend.OrderExtendMapper;
import com.deepsoft.haolifa.dao.repository.extend.StatisticsExtendMapper;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.InvoiceListDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.order.OrderConditionDTO;
import com.deepsoft.haolifa.model.dto.order.OrderStatisticDTO;
import com.deepsoft.haolifa.model.vo.InvoiceStatisticVo;
import com.deepsoft.haolifa.model.vo.OrderProductStatisticVo;
import com.deepsoft.haolifa.service.StatisticsService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private MaterialMapper materialMapper;
    @Autowired
    private OrderProductMapper orderProductMapper;
    @Autowired
    private OrderExtendMapper orderExtendMapper;
    @Autowired
    private InvoiceMapper invoiceMapper;
    @Autowired
    private RedisDaoImpl redisDao;
    @Autowired
    private StatisticsExtendMapper statisticsExtendMapper;

    @Override
    public ResultBean totalInventory() {
        Double totalInvertory = 0.0;
        String redisValue = redisDao.get(TOTAL_INVENTORY_MATERIAL);
        if (StringUtils.isNotEmpty(redisValue)) {
            return ResultBean.success(Double.valueOf(redisValue));
        } else {
            MaterialExample example = new MaterialExample();
            example.createCriteria().andIsDeleteEqualTo(Consts.NO.code);
            List<Material> materials = materialMapper.selectByExample(example);
            for (int i = 0; i < materials.size(); i++) {
                Material material = materials.get(i);
                totalInvertory += material.getPrice().doubleValue() * (material.getCurrentQuantity() + material.getLockQuantity());
            }
            redisDao.set(TOTAL_INVENTORY_MATERIAL, totalInvertory.toString(), 1L, TimeUnit.HOURS);
        }
        return ResultBean.success(totalInvertory);
    }

    @Override
    public Double totalOrders() {
        return statisticsExtendMapper.sumOrderTotal();
    }

    @Override
    public Double totalPurchase() {
        return statisticsExtendMapper.sumPurchaseTotal();
    }

    @Override
    public InvoiceStatisticVo totalInvoice(Byte type, InvoiceListDTO dto) {
        InvoiceStatisticVo invoiceStatisticVo = new InvoiceStatisticVo();
        InvoiceExample invoiceExample = new InvoiceExample();
        InvoiceExample.Criteria criteria = invoiceExample.createCriteria();
        criteria.andIsDeleteEqualTo(CommonEnum.Consts.NO.code);
        // 经管 查 生产订单， 财务查所有
        if (type != null && type == 1) {
            criteria.andTypeEqualTo(type);
        }

        if (StringUtils.isNotEmpty(dto.getOrderNo())) {
            criteria.andOrderNoLike("%" + dto.getOrderNo() + "%");
        }
        if (dto.getStatus() != null && dto.getStatus() > -1) {
            criteria.andStatusEqualTo(dto.getStatus());
        }
        if (CollectionUtil.isNotEmpty(dto.getStatusList())) {
            criteria.andStatusIn(dto.getStatusList());
        }
        if (StringUtils.isNotEmpty(dto.getConstractParty())) {
            criteria.andConstractPartyLike("%" + dto.getConstractParty() + "%");
        }
        // 开票日期
        if (ObjectUtil.isNotNull(dto.getStartInvoiceDate())) {
            criteria.andInvoiceDateGreaterThanOrEqualTo(dto.getStartInvoiceDate());
        }
        if (ObjectUtil.isNotNull(dto.getEndInvoiceDate())) {
            criteria.andInvoiceDateLessThanOrEqualTo(dto.getEndInvoiceDate());
        }
        List<Invoice> invoices = invoiceMapper.selectByExample(invoiceExample);
        BigDecimal totalAmount = BigDecimal.ZERO, notInvoicedAmount = BigDecimal.ZERO, invoicedAmount = BigDecimal.ZERO;
        for (Invoice invoice : invoices) {
            BigDecimal itotalAmount = invoice.getTotalAmount();
            if (itotalAmount != null) {
                totalAmount = totalAmount.add(itotalAmount);
                if (invoice.getStatus().equals((byte) 1)) {
                    notInvoicedAmount = notInvoicedAmount.add(itotalAmount);
                } else if (invoice.getStatus().equals((byte) 2)) {
                    invoicedAmount = invoicedAmount.add(itotalAmount);
                }
            }
        }
        invoiceStatisticVo.setTotalAmount(totalAmount.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        invoiceStatisticVo.setInvoicedAmount(invoicedAmount.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        invoiceStatisticVo.setNotInvoicedAmount(notInvoicedAmount.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        return invoiceStatisticVo;
    }

    @Override
    public OrderProductStatisticVo totalOrderProduct(OrderStatisticDTO model) {
        Map<String, Object> toMap = BeanUtil.beanToMap(model);
        OrderProductStatisticVo statisticVo = new OrderProductStatisticVo();
        // 获取订单的产品数量
        int orderQty = orderExtendMapper.countProduct(toMap);
        statisticVo.setOrderQty(orderQty);
        // 获取订单的发货数量
        int deliveryOrderQty = orderExtendMapper.countDelivery(toMap);
        statisticVo.setDeliveryOrderQty(deliveryOrderQty);
        return statisticVo;
    }

}
