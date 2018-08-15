package com.deepsoft.haolifa.controller;


import com.deepsoft.haolifa.service.InspectResultService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"送检报告"})
@RestController
@RequestMapping("inspect-result")
public class InspectResultController {

    @Autowired
    private InspectResultService inspectResultService;
}
