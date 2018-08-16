package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.service.ApplyBuyService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"请购申请"})
@RestController
@RequestMapping("applyBuy")
public class ApplyBuyController {

    @Autowired
    private ApplyBuyService applyBuyService;

}
