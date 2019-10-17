package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.entrust.EntrustRelationDto;
import com.deepsoft.haolifa.service.EntrustRelationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "委托加工图号关系管理")
@RestController
@RequestMapping("entrust/process")
public class EntrustRelationController {

  @Autowired
  private EntrustRelationService entrustRelationService;

  @ApiOperation("添加对照关系")
  @PostMapping("relation")
  public ResultBean save(@RequestBody EntrustRelationDto dto) {
    return entrustRelationService.save(dto);
  }

  @ApiOperation("删除对照关系")
  @DeleteMapping("relation/{id}")
  public ResultBean delete(@PathVariable("id") Integer id) {
    return entrustRelationService.delete(id);
  }

  @ApiOperation("根据原图号查询加工后图号")
  @GetMapping("relations")
  public ResultBean getRelations(@RequestParam String originalGraphNo) {
    return entrustRelationService.getRelations(originalGraphNo);
  }

  @ApiOperation("查询对照关系列表")
  @GetMapping("relation/list")
  public ResultBean getList(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
      @RequestParam(required = false, defaultValue = "20") Integer pageSize) {
    return entrustRelationService.getList(pageNum, pageSize);
  }

}
