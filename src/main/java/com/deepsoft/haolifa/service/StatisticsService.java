package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.InvoiceListDTO;
import com.deepsoft.haolifa.model.dto.PurchaseOrderConditionDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.order.OrderConditionDTO;
import com.deepsoft.haolifa.model.dto.order.OrderStatisticDTO;
import com.deepsoft.haolifa.model.vo.InvoiceStatisticVo;
import com.deepsoft.haolifa.model.vo.OrderProductStatisticVo;

public interface StatisticsService {

    ResultBean totalInventory();

    Double totalOrders(OrderConditionDTO model);

    Double totalPurchase(PurchaseOrderConditionDTO model);

    InvoiceStatisticVo totalInvoice(Byte type, InvoiceListDTO dto);

    OrderProductStatisticVo totalOrderProduct(OrderStatisticDTO dto);
}
