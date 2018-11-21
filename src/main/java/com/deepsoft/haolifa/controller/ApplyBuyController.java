package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.service.ApplyBuyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"请购申请"})
@RestController
@RequestMapping("applyBuy")
public class ApplyBuyController {

    @Autowired
    private ApplyBuyService applyBuyService;

    @ApiOperation("创建请购单")
    @PostMapping("save")
    public ResultBean save(@RequestBody ApplyBuyDTO model) {
        return applyBuyService.save(model);
    }

    @ApiOperation("删除请购单单项")
    @GetMapping("deleteItem/{applyBuyNo}/{materialGraphNo}")
    public ResultBean deleteItem(@PathVariable("applyBuyNo") String applyBuyNo, @PathVariable("materialGraphNo") String materialGraphNo) {
        return applyBuyService.deleteItem(applyBuyNo,materialGraphNo);
    }
    @ApiOperation("修改请购单单项")
    @PostMapping("update")
    public ResultBean update(@RequestBody ApplyBuyUpdateDTO model) {
        return applyBuyService.update(model);
    }

    @ApiOperation("请购单详情")
    @GetMapping("info/{formId}")
    public ResultBean getInfo(@PathVariable(value = "formId") Integer applyBuyId) {
        return applyBuyService.getInfo(applyBuyId);
    }




}
