package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.service.ApplyBuyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
  @GetMapping("deleteItem/{itemId}")
  public ResultBean deleteItem(@ApiParam("缺料单项id") @PathVariable("itemId") int itemId) {
    return applyBuyService.deleteItem(itemId);
  }

  @ApiOperation("修改请购单单项")
  @PostMapping("update")
  public ResultBean update(@RequestBody ApplyBuyUpdateDTO model) {
    return applyBuyService.update(model);
  }

  @ApiOperation("填写采购完成日期")
  @PostMapping("/updateArrivalTime/{itemId}")
  public ResultBean updateArrivalTime(@ApiParam("单项id") @PathVariable("itemId") int itemId,
      @RequestBody String arrivalTime) {
    return applyBuyService.updateArrivalTime(itemId, arrivalTime);
  }

  @ApiOperation("更新待采购项状态（已处理）,采购员更新")
  @PostMapping("updateStatus/{itemId}")
  public ResultBean updateStatus(@ApiParam("单项id") @PathVariable("itemId") int itemId) {
    return applyBuyService.updateStatus(itemId);
  }

  @ApiOperation("更新待采购项状态,采购日期,采购员更新")
  @PostMapping("/updateStatusByOrderNo")
  public ResultBean updateStatusByOrderNo(@RequestParam String orderNo,@RequestParam String arriveTime) {
    return applyBuyService.updateStatusByOrderNo(orderNo, arriveTime);
  }

  @ApiOperation("更新待采购项状态,")
  @PostMapping("/updateStatusByOrderNo/{status}")
  public ResultBean updateStatusByOrderNo(@RequestParam String orderNo, @PathVariable("status") Integer status) {
    return applyBuyService.updateStatusByOrderNo(orderNo, status);
  }




  @ApiOperation("生产订单待采购详情")
  @GetMapping("info/{formNo}")
  public ResultBean getInfo(@PathVariable(value = "formNo") String formNo) {
    return applyBuyService.getInfo(formNo);
  }

  @ApiOperation("生产待采购列表")
  @GetMapping("list")
  public ResultBean list(@ApiParam("页码") @RequestParam(defaultValue = "1") int pageNum,
      @ApiParam("展示数量") @RequestParam(defaultValue = "10") int pageSize,
      @ApiParam("查询条件：2 全部 1 已处理 0 未处理（默认）") @RequestParam(defaultValue = "0") int status) {
        return applyBuyService.list(pageNum,pageSize,status);
  }

  @ApiOperation("生产订单关联的待采购列表")
  @GetMapping("product/list")
  public ResultBean list(@RequestParam String orderNo) {
    return applyBuyService.list(orderNo);
  }


}
