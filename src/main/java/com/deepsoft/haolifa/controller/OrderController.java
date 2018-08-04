package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.domain.Order;
import com.deepsoft.haolifa.model.dto.ResultBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;

@RestController
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/get")
    public ResultBean getOrder() {
        Order order = new Order();
        order.setDemandName("你好");
        order.setPrice(new BigDecimal("2.13"));
        order.setCreateTime(new Date());
        return ResultBean.success(order);
    }
}
