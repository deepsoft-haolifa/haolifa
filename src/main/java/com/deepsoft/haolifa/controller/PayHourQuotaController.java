package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayHourQuotaDTO;
import com.deepsoft.haolifa.service.PayHourQuotaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author liuyaofei
 * @Date create in 上午9:29 2021/10/17
 * @description 绩效工时定额管理
 */
@Api(tags = "绩效工时定额管理")
@RestController
@RequestMapping("/pay-hour_quota")
public class PayHourQuotaController {
    @Resource
    private PayHourQuotaService payHourQuotaService;

    @ApiOperation("列表")
    @PostMapping("/getList")
    public ResultBean getList(@RequestBody PayHourQuotaDTO model) {
        return payHourQuotaService.pageInfo(model);
    }

    @ApiOperation("保存")
    @PostMapping(value = "/save")
    public ResultBean save(@RequestBody PayHourQuotaDTO model) {
        return payHourQuotaService.save(model);
    }

    @ApiOperation("查看详情")
    @GetMapping(value = "info/{id}")
    public ResultBean getInfo(@PathVariable("id") Integer id) {
        return payHourQuotaService.getInfo(id);
    }

    @ApiOperation("修改")
    @PostMapping(value = "/edit")
    public ResultBean edit(@RequestBody PayHourQuotaDTO model) {
        return payHourQuotaService.edit(model);
    }

    @ApiOperation("删除")
    @GetMapping(value = "del/{id}")
    public ResultBean del(@PathVariable("id") Integer id) {
        return payHourQuotaService.delete(id);
    }
}
