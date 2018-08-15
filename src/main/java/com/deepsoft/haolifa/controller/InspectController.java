package com.deepsoft.haolifa.controller;


import com.deepsoft.haolifa.service.InspectService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"送检管理"})
@RestController
@RequestMapping("inspect")
public class InspectController {

    @Autowired
    private InspectService inspectService;
}
