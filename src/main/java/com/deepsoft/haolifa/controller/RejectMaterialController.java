package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.rejectMaterial.RejectMaterialListDto;
import com.deepsoft.haolifa.model.dto.rejectMaterial.RejectMaterialSaveDto;
import com.deepsoft.haolifa.service.RejectMaterialService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rejectMaterial")
@Api(tags = {"不合格品管理"})
public class RejectMaterialController {

  @Autowired
  private RejectMaterialService rejectMaterialService;

  @ApiOperation("创建不合格审批记录")
  @PostMapping("record")
  public ResultBean saveRecord(@RequestBody RejectMaterialSaveDto dto) {
    return rejectMaterialService.save(dto);
  }

  @ApiOperation("删除不合格审批记录")
  @DeleteMapping("record/{recordNo}")
  public ResultBean delRecord(@PathVariable("recordNo") String recordNo) {
    return rejectMaterialService.delete(recordNo);
  }

  @ApiOperation("更新不合格审批记录状态")
  @PutMapping("record/{recordNo}")
  public ResultBean updateRecordStatus(@PathVariable("recordNo") String recordNo,@RequestParam(defaultValue = "0") int status) {
    return rejectMaterialService.updateRecordStatus(recordNo, status);
  }

  @ApiOperation("查看不合格审批记录")
  @GetMapping("record/{recordNo}")
  public ResultBean getRecord(@PathVariable("recordNo") String recordNo) {
    return rejectMaterialService.info(recordNo);
  }

  @ApiOperation("查看不合格审批记录列表")
  @PostMapping("records")
  public ResultBean getRecordList(@RequestBody RejectMaterialListDto listDto) {
    return rejectMaterialService.list(listDto);
  }






}
