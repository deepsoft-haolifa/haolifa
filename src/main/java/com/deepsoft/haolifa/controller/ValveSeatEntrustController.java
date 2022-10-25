package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.ValveSeatEntrustMapper;
import com.deepsoft.haolifa.model.domain.ValveSeatEntrust;
import com.deepsoft.haolifa.model.domain.ValveSeatInspectHistory;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;

import com.deepsoft.haolifa.model.dto.valveSeat.*;
import com.deepsoft.haolifa.service.ValveSeatEntrustService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 阀座委托单
 *
 * @author murphy.he
 **/
@Api(tags = "阀座委托单")
@RequestMapping("valve-seat-entrust")
@RestController
public class ValveSeatEntrustController {

    @Resource
    private ValveSeatEntrustService valveSeatEntrustService;
    @Resource
    private ValveSeatEntrustMapper valveSeatEntrustMapper;

    @PostMapping("/add")
    @ApiOperation("添加")
    public ResultBean add(@RequestBody ValveSeatEntrustReqDto reqDto) {
        int add = valveSeatEntrustService.add(reqDto);
        if (add > 0) {
            return ResultBean.success(add);
        } else {
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }

    @PostMapping("/update")
    @ApiOperation("更新")
    public ResultBean update(@RequestBody ValveSeatEntrustReqDto reqDto) {
        int update = valveSeatEntrustService.update(reqDto);
        if (update > 0) {
            return ResultBean.success(update);
        } else {
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }

    @PostMapping("/del/{id}")
    @ApiOperation("删除")
    public ResultBean del(@PathVariable Integer id) {
        int del = valveSeatEntrustService.delete(id);
        if (del > 0) {
            return ResultBean.success(del);
        } else {
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }

    @PostMapping("/detail/{id}")
    @ApiOperation("获取详情")
    public ResultBean<ValveSeatEntrust> detail(@PathVariable Integer id) {
        ValveSeatEntrust autoControlEntrust = valveSeatEntrustMapper.selectByPrimaryKey(id);
        return ResultBean.success(autoControlEntrust);
    }

    @PostMapping("/page")
    @ApiOperation("分页列表")
    public ResultBean<PageDTO<ValveSeatEntrust>> pageList(@RequestBody ValveSeatEntrustConditionDto pageDto) {
        return ResultBean.success(valveSeatEntrustService.pageList(pageDto));
    }

    @ApiOperation("更新状态")
    @PutMapping("status/{id}/{status}")
    public ResultBean updateStatus(@PathVariable("id") Integer id, @ApiParam("0 创建 1 加工中 2 质检完成 3 加工完成 4 暂停加工") @PathVariable("status") int status) {
        int update = valveSeatEntrustService.updateStatus(id, status);
        if (update > 0) {
            return ResultBean.success(update);
        } else {
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }


    @ApiOperation("更新质检状态")
    @PutMapping("inspectStatus/{id}/{status}")
    public ResultBean updateInspectStatus(@PathVariable("id") Integer id, @ApiParam("0 待质检 1 质检中 2 质检完成") @PathVariable("status") int status) {
        int update = valveSeatEntrustService.updateInspectStatus(id, status);
        if (update > 0) {
            return ResultBean.success(update);
        } else {
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }

    @ApiOperation("保存质检记录")
    @PostMapping("inspect")
    public ResultBean saveInspect(@RequestBody ValveSeatInspectDto autoControlInspectDto) {
        int update = valveSeatEntrustService.saveInspect(autoControlInspectDto);
        if (update > 0) {
            return ResultBean.success(update);
        } else {
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }

    @ApiOperation("查询检验记录")
    @GetMapping("inspect/list/{no}")
    public ResultBean<List<ValveSeatInspectHistoryDto>> getInspectList(@PathVariable("no") String no) {
        return ResultBean.success(valveSeatEntrustService.getInspectList(no));
    }


    @ApiOperation("阀座待入库")
    @PostMapping("history/list")
    public ResultBean<PageDTO<ValveSeatInspectHistory>> historyList(@RequestBody HistoryConditionDto pageDto) {
        return ResultBean.success(valveSeatEntrustService.historyList(pageDto));
    }

    @ApiOperation("阀座入库更新已入库状态")
    @PostMapping("history/status/{id}")
    public ResultBean historyStatus(@PathVariable("id") Integer id) {
        int update = valveSeatEntrustService.updateHistoryStatus(id);
        if (update > 0) {
            return ResultBean.success(update);
        } else {
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }
}
