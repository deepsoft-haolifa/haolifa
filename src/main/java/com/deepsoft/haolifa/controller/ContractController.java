package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.ContractService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"合同管理"})
@RestController
@RequestMapping("contract")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @ApiOperation("查询合同列表")
    @GetMapping("list")
    public ResultBean list(String orderNo, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        return contractService.list(orderNo, pageNum, pageSize);
    }

    @ApiOperation("查询合同详情")
    @GetMapping("info")
    public ResultBean info(@RequestParam String orderNo) {
        return contractService.info(orderNo);
    }
}
