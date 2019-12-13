package com.deepsoft.haolifa.listener;

import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.model.domain.SysLoginLog;
import com.deepsoft.haolifa.model.dto.InvoiceCreateDTO;
import com.deepsoft.haolifa.model.dto.order.OrderProductDTO;
import com.deepsoft.haolifa.service.InvoiceService;
import com.deepsoft.haolifa.service.OrderProductService;
import com.deepsoft.haolifa.service.SysLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 异步监听事件
 *
 * @author: murphy.he
 **/
@Component
@Slf4j
public class SyncEventListener {

    @Autowired
    private SysLogService sysLogService;

    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private OrderProductService orderProductService;

    /**
     * 异步添加登录操作 日志
     */
    @EventListener
    @Async
    public void addLoginLog(SysLoginLog sysLoginLog) {
        sysLogService.saveLogin(sysLoginLog);
    }

    /**
     * 发货完成，异步添加 开发票信息 到发票列表
     */
    @EventListener
    @Async
    public void addInvoice(InvoiceCreateDTO invoiceCreateDTO) {
        log.info("delivery complete async add invoice record orderNo:{}", invoiceCreateDTO.getOrderNo());
        // 根据orderNo 获取需方
        OrderProductDTO orderProductInfo = orderProductService.getOrderProductInfo(invoiceCreateDTO.getOrderNo());
        if (orderProductInfo != null) {
            String demandName = orderProductInfo.getDemandName();
            String supplyName = orderProductInfo.getSupplyName();
            invoiceCreateDTO.setInvoiceCompany(demandName);
            invoiceCreateDTO.setInvoiceIssuing(supplyName);
            invoiceCreateDTO.setTotalAmount(orderProductInfo.getTotalPrice().doubleValue());
            invoiceCreateDTO.setType(1);

            log.info("delivery complete async add invoice record model:{}", JSONObject.toJSONString(invoiceCreateDTO));

            invoiceService.save(invoiceCreateDTO);
        }
    }

}
