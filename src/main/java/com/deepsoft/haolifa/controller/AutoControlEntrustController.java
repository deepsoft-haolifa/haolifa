package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.AutoControlEntrustMapper;
import com.deepsoft.haolifa.model.domain.AutoControlEntrust;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.autoControl.AutoControlEntrustConditionDto;
import com.deepsoft.haolifa.model.dto.autoControl.AutoControlEntrustReqDto;
import com.deepsoft.haolifa.model.dto.autoControl.AutoControlInspectDto;
import com.deepsoft.haolifa.model.dto.autoControl.AutoControlInspectHistoryDto;
import com.deepsoft.haolifa.service.AutoControlEntrustService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 自控委托单
 *
 * @author murphy.he
 **/
@Api(tags = "自控委托单")
@RequestMapping("auto-control-entrust")
@RestController
public class AutoControlEntrustController {

    @Autowired
    private AutoControlEntrustService autoControlEntrustService;
    @Autowired
    private AutoControlEntrustMapper autoControlEntrustMapper;

    @PostMapping("/add")
    @ApiOperation("添加")
    public ResultBean add(@RequestBody AutoControlEntrustReqDto reqDto) {
        int add = autoControlEntrustService.add(reqDto);
        if (add > 0) {
            return ResultBean.success(add);
        } else {
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }

    @PostMapping("/update")
    @ApiOperation("更新")
    public ResultBean update(@RequestBody AutoControlEntrustReqDto reqDto) {
        int update = autoControlEntrustService.update(reqDto);
        if (update > 0) {
            return ResultBean.success(update);
        } else {
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }

    @PostMapping("/del/{id}")
    @ApiOperation("删除")
    public ResultBean del(@PathVariable Integer id) {
        int del = autoControlEntrustMapper.deleteByPrimaryKey(id);
        if (del > 0) {
            return ResultBean.success(del);
        } else {
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }

    @PostMapping("/detail/{id}")
    @ApiOperation("获取详情")
    public ResultBean<AutoControlEntrust> detail(@PathVariable Integer id) {
        AutoControlEntrust autoControlEntrust = autoControlEntrustMapper.selectByPrimaryKey(id);
        return ResultBean.success(autoControlEntrust);
    }

    @PostMapping("/page")
    @ApiOperation("分页列表")
    public ResultBean<PageDTO<AutoControlEntrust>> pageList(@RequestBody AutoControlEntrustConditionDto pageDto) {
        return ResultBean.success(autoControlEntrustService.pageList(pageDto));
    }

    @ApiOperation("更新喷涂加工单状态")
    @PutMapping("status/{id}/{status}")
    public ResultBean updateStatus(@PathVariable("id") Integer id, @ApiParam("0 创建 1 加工中 2 质检完成 3 加工完成 4 暂停加工") @PathVariable("status") int status) {
        int update = autoControlEntrustService.updateStatus(id, status);
        if (update > 0) {
            return ResultBean.success(update);
        } else {
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }


    @ApiOperation("更新喷涂加工单质检状态")
    @PutMapping("inspectStatus/{id}/{status}")
    public ResultBean updateInspectStatus(@PathVariable("id") Integer id, @ApiParam("0 待质检 1 质检中 2 质检完成") @PathVariable("status") int status) {
        int update = autoControlEntrustService.updateInspectStatus(id, status);
        if (update > 0) {
            return ResultBean.success(update);
        } else {
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }

    @ApiOperation("保存喷涂加工质检记录")
    @PostMapping("inspect")
    public ResultBean saveInspect(@RequestBody AutoControlInspectDto autoControlInspectDto) {
        int update = autoControlEntrustService.saveInspect(autoControlInspectDto);
        if (update > 0) {
            return ResultBean.success(update);
        } else {
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }

    @ApiOperation("查询检验记录")
    @GetMapping("inspect/list/{no}")
    public ResultBean<List<AutoControlInspectHistoryDto>> getInspectList(@PathVariable("no") String no) {
        return ResultBean.success(autoControlEntrustService.getInspectList(no));
    }
}
