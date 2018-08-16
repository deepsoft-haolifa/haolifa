package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.ApplyBuyDTO;
import com.deepsoft.haolifa.model.dto.ApplyBuyUpdateDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.StoreKeeperApplyBuyDTO;
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

    @ApiOperation("创建请购单（根据请购计划）")
    @PostMapping("saveByPurchasePlan")
    public ResultBean saveByPurchasePlan(@RequestBody List<ApplyBuyDTO> modelList) {
        return applyBuyService.saveByPurchasePlan(modelList);
    }

    @ApiOperation("创建请购单（库房管理员）")
    @PostMapping("saveByStoreKeeper")
    public ResultBean saveByStoreKeeper(@RequestBody List<StoreKeeperApplyBuyDTO> modelList) {
        return applyBuyService.saveByStoreKeeper(modelList);
    }

    @ApiOperation("删除请购单单项")
    @GetMapping("deleteItem/{applyBuyNo}/{materialGraphNo}")
    public ResultBean deleteItem(@PathVariable("applyBuyNo") String applyBuyNo, @PathVariable("materialGraphNo") String materialGraphNo) {
        return applyBuyService.deleteItem(applyBuyNo,materialGraphNo);
    }

    @ApiOperation("删除请购单")
    @GetMapping("delete/{applyBuyNo}")
    public ResultBean delete(@PathVariable("applyBuyNo") String applyBuyNo) {
        return applyBuyService.delete(applyBuyNo);
    }

    @ApiOperation("修改请购单单项")
    @PostMapping("update")
    public ResultBean update(@RequestBody ApplyBuyUpdateDTO model) {
        return applyBuyService.update(model);
    }

    @ApiOperation("请购单详情")
    @GetMapping("info/{applyBuyNo}")
    public ResultBean getInfo(@PathVariable("applyBuyNo") String applyBuyNo) {
        return applyBuyService.getInfo(applyBuyNo);
    }

    @ApiOperation("请购单列表")
    @GetMapping("list")
    public ResultBean getList(@RequestParam Integer currentPage, @RequestParam Integer pageSize) {
        return applyBuyService.getList(currentPage,pageSize);
    }

    // TODO 涉及流程初始化
    @ApiOperation("发起审批(流程初始化)--接口未实现")
    @GetMapping("initiateApproval/{applyBuyNo}")
    public ResultBean initiateApproval(@PathVariable("applyBuyNo") String applyBuyNo){
        return null;
    }

    @ApiOperation("撤销审批--接口未实现")
    @GetMapping("cancelApproval/{applyBuyNo}")
    public ResultBean cancelApproval(@PathVariable("applyBuyNo") String applyBuyNo){
        return null;
    }




}
