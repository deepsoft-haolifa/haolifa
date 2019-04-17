package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.SprayService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("spray")
public class SprayController {

  @Autowired
  private SprayService sprayService;

  @PostMapping("form")
  public ResultBean save() {
    return null;
  }

  @DeleteMapping("form")
  public ResultBean delete() {
    return null;
  }

  @PutMapping("form")
  public ResultBean update(){
    return null;
  }

  @GetMapping("form")
  public ResultBean getSprayInfo() {
    return null;
  }

  @GetMapping("forms")
  public ResultBean getFormsList() {
    return null;
  }

  @PutMapping("status")
  public ResultBean updateStatus(){
    return null;
  }

  @PostMapping("inspect")
  public ResultBean saveInspect() {
    return null;
  }

  @ApiOperation("查询检验记录")
  @GetMapping("inspect/list")
  public ResultBean getInspectList() {
    return null;
  }

  @ApiOperation("查询喷涂单项列表")
  @GetMapping("items/list")
  public ResultBean getItemsList() {
    return null;
  }


}
