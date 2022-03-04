package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayHourQuotaDTO;
import com.deepsoft.haolifa.model.dto.pay.PayManagerCalDTO;
import com.deepsoft.haolifa.model.dto.pay.PayManagerCalPageDTO;
import com.deepsoft.haolifa.model.dto.pay.response.PayManagerCalVO;
import com.deepsoft.haolifa.model.dto.pay.response.PayWagesSearchResVO;
import com.deepsoft.haolifa.service.PayManagerCalService;
import com.deepsoft.haolifa.service.impl.PayManagerServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author ：liuyaofei
 * @date ：Created in 2022/3/4 3:07 下午
 * @description：绩效管理-管理人员计提方式
 */
@Api(tags = "绩效管理-管理人员计提方式")
@RestController
@RequestMapping("/pay-manager_cal")
public class PayManagerCalController {

    @Resource
    private PayManagerCalService payManagerCalService;

    @ApiOperation("列表")
    @PostMapping("/getList")
    public ResultBean<PageDTO<PayManagerCalVO>> getList(@RequestBody PayManagerCalPageDTO model) {
        return payManagerCalService.pageInfo(model);
    }

    @ApiOperation("保存")
    @PostMapping(value = "/save")
    public ResultBean save(@RequestBody PayManagerCalDTO model) {
        return payManagerCalService.save(model);
    }

    @ApiOperation("查看详情")
    @GetMapping(value = "info/{id}")
    public ResultBean<PayManagerCalVO> getInfo(@PathVariable("id") Integer id) {
        return payManagerCalService.getInfo(id);
    }

    @ApiOperation("修改")
    @PostMapping(value = "/edit")
    public ResultBean edit(@RequestBody PayManagerCalDTO model) {
        return payManagerCalService.edit(model);
    }

    @ApiOperation("删除")
    @GetMapping(value = "del/{id}")
    public ResultBean del(@PathVariable("id") Integer id) {
        return payManagerCalService.delete(id);
    }

}
