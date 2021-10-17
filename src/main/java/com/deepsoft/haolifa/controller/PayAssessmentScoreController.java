package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayAssessmentScoreDTO;
import com.deepsoft.haolifa.service.PayAssessmentScoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author liuyaofei
 * @Date create in 上午11:37 2021/9/11
 * @description 打分管理
 */
@Api(tags = "绩效打分管理")
@RestController
@RequestMapping("/pay-assessment-score")
public class PayAssessmentScoreController {

    @Resource
    private PayAssessmentScoreService payAssessmentScoreService;

    @ApiOperation("列表")
    @PostMapping("/getList")
    public ResultBean getList(@RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
                              @RequestParam(value = "pageSize", required = true, defaultValue = "20") Integer pageSize) {
        return payAssessmentScoreService.pageInfo(pageNum, pageSize);
    }

    @ApiOperation("保存")
    @PostMapping(value = "/save")
    public ResultBean save(@RequestBody PayAssessmentScoreDTO model) {
        return payAssessmentScoreService.save(model);
    }

    @ApiOperation("查看详情")
    @GetMapping(value = "info/{scoreId}")
    public ResultBean getInfo(@PathVariable("scoreId") Integer scoreId) {
        return payAssessmentScoreService.getInfo(scoreId);
    }

    @ApiOperation("修改")
    @PostMapping(value = "/edit")
    public ResultBean edit(@RequestBody PayAssessmentScoreDTO model) {
        return payAssessmentScoreService.edit(model);
    }

    @ApiOperation("删除")
    @GetMapping(value = "del/{scoreId}")
    public ResultBean del(@PathVariable("scoreId") Integer scoreId) {
        return payAssessmentScoreService.delete(scoreId);
    }
}
