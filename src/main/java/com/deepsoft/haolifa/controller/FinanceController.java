package com.deepsoft.haolifa.controller;


import com.deepsoft.haolifa.service.FinanceService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"财务管理"})
@RestController
@RequestMapping("/finance")
public class FinanceController {

    @Autowired
    FinanceService financeService;
}
