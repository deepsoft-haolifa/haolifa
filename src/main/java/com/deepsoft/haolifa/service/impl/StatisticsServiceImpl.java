package com.deepsoft.haolifa.service.impl;

import static com.deepsoft.haolifa.constant.CacheKey.TOTAL_INVENTORY_MATERIAL;
import static com.deepsoft.haolifa.constant.CacheKey.TOTAL_MONEY_ORDER;

import com.deepsoft.haolifa.cache.redis.RedisDaoImpl;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.constant.CommonEnum.Consts;
import com.deepsoft.haolifa.dao.repository.InvoiceMapper;
import com.deepsoft.haolifa.dao.repository.MaterialMapper;
import com.deepsoft.haolifa.dao.repository.OrderProductMapper;
import com.deepsoft.haolifa.dao.repository.extend.StatisticsExtendMapper;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.InvoiceListDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.vo.InvoiceStatisticVo;
import com.deepsoft.haolifa.service.StatisticsService;

import java.math.BigDecimal;
import java.util.List;
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
            redisDao.set(TOTAL_INVENTORY_MATERIAL, totalInvertory.toString(), 12L, TimeUnit.HOURS);
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
    public InvoiceStatisticVo totalInvoice(Byte type) {
        InvoiceStatisticVo invoiceStatisticVo = new InvoiceStatisticVo();
        InvoiceExample invoiceExample = new InvoiceExample();
        InvoiceExample.Criteria criteria = invoiceExample.createCriteria();
        // 经管 查 生产订单， 财务查所有
        if (type != null && type == 1) {
            criteria.andTypeEqualTo(type);
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
}
