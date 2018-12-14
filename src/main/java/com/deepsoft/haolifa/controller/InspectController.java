package com.deepsoft.haolifa.controller;


import com.deepsoft.haolifa.model.dto.InspectDTO;
import com.deepsoft.haolifa.model.dto.InspectItemDTO;
import com.deepsoft.haolifa.model.dto.InspectItemUpdateDTO;
import com.deepsoft.haolifa.model.dto.InspectListDTO;
import com.deepsoft.haolifa.model.dto.InspectResDTO;
import com.deepsoft.haolifa.model.dto.InspectUpdateDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.InspectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = {"零件送检管理"})
@RestController
@RequestMapping("material-inspect")
public class InspectController {

  @Autowired
  private InspectService inspectService;

  @ApiOperation("创建送检单")
  @PostMapping("save")
  public ResultBean save(@RequestBody InspectDTO model) {
    return inspectService.save(model);
  }

  @ApiOperation("删除送检单")
  @GetMapping("delete/{inspectId}")
  public ResultBean delete(@ApiParam("送检单id") @PathVariable("inspectId") int inspectId) {
    return inspectService.delete(inspectId);
  }

  @ApiOperation("删除送检单单项")
  @GetMapping("deleteItem/{itemId}")
  public ResultBean deleteItem(@ApiParam("送检单单项id") @PathVariable("itemId") int itemId) {
    return inspectService.deleteItem(itemId);
  }

  @ApiOperation("更新送检单")
  @PostMapping("update/{inspectId}")
  public ResultBean update(@ApiParam("送检单id")@PathVariable("inspectId") int inspectId,
      @RequestBody InspectUpdateDTO model) {
    return inspectService.update(inspectId,model);
  }

  @ApiOperation("更新送检单单项")
  @PostMapping("updateItem/{itemId}")
  public ResultBean updateItem(@ApiParam("送检单id")@PathVariable("itemId") int itemId,
      @RequestBody InspectItemUpdateDTO model) {
    return inspectService.updateItem(itemId,model);
  }

  @ApiOperation("查询送检单详情")
  @GetMapping("info/{inspectId}")
  public ResultBean getInfo(@PathVariable("inspectId") int inspectId) {
    return inspectService.getInfo(inspectId);
  }

  @ApiOperation("查询送检单列表(采购员、质检员、库管员)")
  @GetMapping("purchase-list/{type}")
  public ResultBean purchaseList(@ApiParam("查询类型 0 采购员 1 质检员 2 库管员") @PathVariable("type") int type,
      @ApiParam("页码") @RequestParam(defaultValue = "1") int pageNum,
      @ApiParam("展示数量") @RequestParam(defaultValue = "10") int pageSize) {
    return inspectService.getList(type,pageNum,pageSize);
  }

  @ApiOperation("更新送检单状态")
  @PostMapping("updateStatus/{inspectId}")
  public ResultBean updateStatus(@ApiParam("送检单id")@PathVariable("inspectId") int inspectId,
      @ApiParam("发起质检：2 质检完成：3,发起入库：4 入库完成: 5")@RequestParam Integer status) {
    return inspectService.updateStatus(inspectId, status);
  }

  @ApiOperation("更新质检结果")
  @PostMapping("inspect-res/{itemId}")
  public ResultBean inspectRes(@ApiParam("单项Id") @PathVariable("itemId") int itemId,@RequestBody InspectResDTO model) {
    return inspectService.inspectRes(itemId,model);
  }
}
