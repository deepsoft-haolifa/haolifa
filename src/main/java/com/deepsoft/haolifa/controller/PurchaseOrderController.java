package com.deepsoft.haolifa.controller;


import com.deepsoft.haolifa.service.PurcahseOrderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"采购订单管理"})
@RestController
@RequestMapping("purchase-order")
public class PurchaseOrderController {

    @Autowired
    private PurcahseOrderService purcahseOrderService;
}
