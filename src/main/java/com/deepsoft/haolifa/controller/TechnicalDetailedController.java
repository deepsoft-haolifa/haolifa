package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.dao.repository.TechnicalDetailedMapper;
import com.deepsoft.haolifa.model.domain.TechnicalDetailed;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.technicalDetailed.TechnicalDetailedConditionDTO;
import com.deepsoft.haolifa.service.impl.TechnicalDetailedService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"技术清单"})
@RestController
@RequestMapping("/technical_detailed")
public class TechnicalDetailedController {
    @Autowired
    TechnicalDetailedService technicalDetailedService;
    @Autowired
    TechnicalDetailedMapper technicalDetailedMapper;

    @ApiOperation("添加")
    @PostMapping("/save")
    public ResultBean save(@RequestBody TechnicalDetailed model) {
        int i = technicalDetailedMapper.insertSelective(model);
        if (i > 0) {
            return ResultBean.success(null);
        }
        return ResultBean.error("添加失败");
    }


    @ApiOperation("详情")
    @GetMapping("/info/{id}")
    public ResultBean info(@PathVariable("id") int id) {
        return ResultBean.success(technicalDetailedMapper.selectByPrimaryKey(id));
    }

    @ApiOperation("更新")
    @PostMapping("/update")
    public ResultBean update(@RequestBody TechnicalDetailed model) {
        int i = technicalDetailedService.update(model);
        if (i > 0) {
            return ResultBean.success(null);
        }
        return ResultBean.error("更新失败");
    }

    @ApiOperation("删除")
    @DeleteMapping("/del/{id}")
    public ResultBean del(@PathVariable("id") int id) {
        int i = technicalDetailedMapper.deleteByPrimaryKey(id);
        if (i > 0) {
            return ResultBean.success(null);
        }
        return ResultBean.error("刪除失败");
    }


    @ApiOperation("列表（分页）")
    @PostMapping("/pageInfo")
    public ResultBean<PageDTO<TechnicalDetailed>> pageInfo(@RequestBody TechnicalDetailedConditionDTO model) {
        return ResultBean.success(technicalDetailedService.pageList(model));
    }


}
