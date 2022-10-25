package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayProductionWorkshopDTO;
import com.deepsoft.haolifa.model.dto.pay.PayProductionWorkshopVO;
import com.deepsoft.haolifa.service.PayProductionWorkShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author liuyaofei
 * @Date create in 上午11:37 2021/9/11
 * @description 绩效岗位管理
 */
@Api(tags = "绩效岗位管理")
@RestController
@RequestMapping("/pay-production-work-shop")
public class PayProductionWorkShopController {

    @Resource
    private PayProductionWorkShopService payProductionWorkShopService;

    @ApiOperation("列表")
    @PostMapping("/getList")
    public ResultBean getList(@RequestBody PayProductionWorkshopVO model) {
        return payProductionWorkShopService.pageInfo(model);
    }

    @ApiOperation("保存")
    @PostMapping(value = "/save")
    public ResultBean save(@RequestBody PayProductionWorkshopDTO model) {
        return payProductionWorkShopService.save(model);
    }

    @ApiOperation("查看详情")
    @GetMapping(value = "info/{workId}")
    public ResultBean getInfo(@PathVariable("workId") Integer workId) {
        return payProductionWorkShopService.getInfo(workId);
    }

    @ApiOperation("修改")
    @PostMapping(value = "/edit")
    public ResultBean edit(@RequestBody PayProductionWorkshopDTO model) {
        return payProductionWorkShopService.edit(model);
    }

    @ApiOperation("删除")
    @GetMapping(value = "del/{workId}")
    public ResultBean del(@PathVariable("workId") Integer workId) {
        return payProductionWorkShopService.delete(workId);
    }

    @ApiOperation("全部列表")
    @PostMapping("/getAllList")
    public ResultBean getAllList() {
        return payProductionWorkShopService.getList();
    }
}
