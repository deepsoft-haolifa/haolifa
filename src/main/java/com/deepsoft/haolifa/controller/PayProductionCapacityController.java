package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayProductCapacityDTO;
import com.deepsoft.haolifa.service.PayProductionCapacityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author liuyaofei
 * @Date create in 下午1:09 2021/9/12
 * @description 生产能力管理
 */
@Api(tags = "绩效生产能力管理")
@RestController
@RequestMapping("/pay-production_capacity")
public class PayProductionCapacityController {
    @Resource
    private PayProductionCapacityService payProductionCapacityService;

    @ApiOperation("列表")
    @GetMapping("/getList")
    public ResultBean getList(@RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                              @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
                              @RequestParam(name = "capacityName", required = false) String capacityName,
                              @RequestParam(name = "capacityCode", required = false) String capacityCode) {
        return payProductionCapacityService.pageInfo(pageSize, pageNumber, capacityName, capacityCode);
    }


    @ApiOperation("保存")
    @PostMapping(value = "/save")
    public ResultBean save(@RequestBody PayProductCapacityDTO model) {
        return payProductionCapacityService.save(model);
    }

    @ApiOperation("查看详情")
    @GetMapping(value = "info/{capacityId}")
    public ResultBean getInfo(@PathVariable("capacityId") Integer capacityId) {
        return payProductionCapacityService.getInfo(capacityId);
    }

    @ApiOperation("修改")
    @PostMapping(value = "/edit")
    public ResultBean edit(@RequestBody PayProductCapacityDTO model) {
        return payProductionCapacityService.edit(model);
    }

    @ApiOperation("删除")
    @GetMapping(value = "del/{capacityId}")
    public ResultBean del(@PathVariable("capacityId") Integer capacityId) {
        return payProductionCapacityService.delete(capacityId);
    }

}
