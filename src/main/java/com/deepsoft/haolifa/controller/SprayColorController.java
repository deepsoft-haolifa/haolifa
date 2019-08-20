package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.spraycolor.SprayColorDto;
import com.deepsoft.haolifa.service.SprayColorService;
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

@Api(tags = "喷涂颜色管理")
@RequestMapping("spray")
@RestController
public class SprayColorController {

  @Autowired
  private SprayColorService sprayColorService;

  @ApiOperation(value = "添加喷涂颜色对照")
  @PostMapping("/color")
  public ResultBean save(@RequestBody SprayColorDto dto) {
    return sprayColorService.save(dto);
  }

  @ApiOperation(value = "删除对照关系")
  @DeleteMapping("/color/{id}")
  public ResultBean delete(@PathVariable("id") Integer id) {
    return sprayColorService.delete(id);
  }

  @ApiOperation("查询全部喷涂颜色对照列表")
  @GetMapping("color/all")
  public ResultBean getAll() {
    return sprayColorService.getAll();
  }

  @ApiOperation("查询颜色对照分页列表")
  @GetMapping("/color/pages")
  public ResultBean getList(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
      @RequestParam(required = false, defaultValue = "20") Integer pageSize) {
    return sprayColorService.getList(pageNum, pageSize);
  }


}
