package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.dao.repository.ProductionDailyPlanMapper;
import com.deepsoft.haolifa.model.domain.ProductionDailyPlan;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.productionPlan.ProductionDailyPlanConditionDto;
import com.deepsoft.haolifa.model.dto.productionPlan.ProductionDailyPlanReqDto;
import com.deepsoft.haolifa.model.dto.valveSeat.ValveSeatEntrustConditionDto;
import com.deepsoft.haolifa.service.ProductionDailyPlanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 生产日计划
 *
 * @author murphy.he
 **/
@Api(tags = "生产日计划")
@RequestMapping("production-daily-plan")
@RestController
public class ProductionDailyPlanController {

    @Resource
    private ProductionDailyPlanService productionDailyPlanService;
    @Resource
    private ProductionDailyPlanMapper productionDailyPlanMapper;

    @PostMapping("/add")
    @ApiOperation("添加")
    public ResultBean add(@RequestBody ProductionDailyPlanReqDto reqDto) {
        int add = productionDailyPlanService.add(reqDto);
        return ResultBean.convertResult(add);
    }

    @PostMapping("/update")
    @ApiOperation("更新")
    public ResultBean update(@RequestBody ProductionDailyPlanReqDto reqDto) {
        int update = productionDailyPlanService.update(reqDto);
        return ResultBean.convertResult(update);
    }

    @PostMapping("/del/{id}")
    @ApiOperation("删除")
    public ResultBean del(@PathVariable Integer id) {
        int del = productionDailyPlanService.delete(id);
        return ResultBean.convertResult(del);

    }

    @PostMapping("/detail/{id}")
    @ApiOperation("获取详情")
    public ResultBean<ProductionDailyPlan> detail(@PathVariable Integer id) {
        ProductionDailyPlan plan = productionDailyPlanMapper.selectByPrimaryKey(id);
        return ResultBean.success(plan);
    }

    @PostMapping("/page")
    @ApiOperation("分页列表")
    public ResultBean<PageDTO<ProductionDailyPlan>> pageList(@RequestBody ProductionDailyPlanConditionDto pageDto) {
        return ResultBean.success(productionDailyPlanService.pageList(pageDto));
    }
}
