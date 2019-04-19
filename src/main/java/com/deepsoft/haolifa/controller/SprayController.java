package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.spray.SprayDto;
import com.deepsoft.haolifa.model.dto.spray.SprayInspectDto;
import com.deepsoft.haolifa.model.dto.spray.SprayListDto;
import com.deepsoft.haolifa.service.SprayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "喷涂加工")
@RequestMapping("spray")
@RestController
public class SprayController {

  @Autowired
  private SprayService sprayService;

  @ApiOperation("添加喷涂加工")
  @PostMapping("form")
  public ResultBean save(@RequestBody SprayDto sprayDto) {
    return sprayService.save(sprayDto);
  }

  @ApiOperation("删除喷涂加工")
  @DeleteMapping("form/{sprayNo}")
  public ResultBean delete(@PathVariable("sprayNo") String sprayNo) {
    return sprayService.delete(sprayNo);
  }

  @ApiOperation("更新喷涂加工")
  @PutMapping("form")
  public ResultBean update(@RequestBody SprayDto sprayDto) {
    return sprayService.update(sprayDto);
  }

  @ApiOperation("获取喷涂加工详情")
  @GetMapping("form/{sprayNo}")
  public ResultBean getSprayInfo(@PathVariable("sprayNo") String sprayNo) {
    return sprayService.getSprayInfo(sprayNo);
  }

  @ApiOperation("获取喷涂加工列表")
  @PostMapping("forms")
  public ResultBean getFormsList(@RequestBody SprayListDto listDto) {
    return sprayService.forms(listDto);
  }

  @ApiOperation("更新喷涂加工单状态")
  @PutMapping("status/{sprayNo}/{status}")
  public ResultBean updateStatus(@PathVariable("sprayNo") String sprayNo, @PathVariable("status") int status) {
    return sprayService.updateStatus(sprayNo, status);
  }

  @ApiOperation("保存喷涂加工质检记录")
  @PostMapping("inspect")
  public ResultBean saveInspect(@RequestBody SprayInspectDto inspectDto) {
    return sprayService.saveInspect(inspectDto);
  }

  @ApiOperation("查询检验记录")
  @GetMapping("inspect/list/{sprayNo}")
  public ResultBean getInspectList(@PathVariable("sprayNo") String sprayNo) {
    return sprayService.getInspectList(sprayNo);
  }

  @ApiOperation("查询喷涂单项列表")
  @GetMapping("items/list/{sprayNo}")
  public ResultBean getItemsList(@PathVariable("sprayNo") String sprayNo) {
    return sprayService.getItemsList(sprayNo);
  }


}
