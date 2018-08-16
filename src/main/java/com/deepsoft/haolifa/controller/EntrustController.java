package com.deepsoft.haolifa.controller;


import com.deepsoft.haolifa.service.EntrustService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"机加委托管理"})
@RestController
@RequestMapping("entrust")
public class EntrustController {

    @Autowired
    private EntrustService entrustService;

}
