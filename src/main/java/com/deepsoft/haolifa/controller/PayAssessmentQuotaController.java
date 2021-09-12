package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayAssessmentQuotaDTO;
import com.deepsoft.haolifa.model.dto.pay.PayAssessmentQuotaVO;
import com.deepsoft.haolifa.service.PayAssessmentQuotaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author liuyaofei
 * @Date create in 上午11:37 2021/9/11
 * @description 考核指标管理
 */
@Api(tags = "考核指标管理")
@RestController
@RequestMapping("/pay-assessment-quota")
public class PayAssessmentQuotaController {

    @Resource
    private PayAssessmentQuotaService payAssessmentQuotaService;

    @ApiOperation("列表")
    @PostMapping("/getList")
    public ResultBean getList(@RequestBody PayAssessmentQuotaVO model) {
        return payAssessmentQuotaService.pageInfo(model);
    }

    @ApiOperation("保存")
    @PostMapping(value = "/save")
    public ResultBean save(@RequestBody PayAssessmentQuotaDTO model) {
        return payAssessmentQuotaService.save(model);
    }

    @ApiOperation("查看详情")
    @GetMapping(value = "info/{quotaId}")
    public ResultBean getInfo(@PathVariable("quotaId") Integer quotaId) {
        return payAssessmentQuotaService.getInfo(quotaId);
    }

    @ApiOperation("修改")
    @PostMapping(value = "/edit")
    public ResultBean edit(@RequestBody PayAssessmentQuotaDTO model) {
        return payAssessmentQuotaService.edit(model);
    }

    @ApiOperation("删除")
    @GetMapping(value = "del/{quotaId}")
    public ResultBean del(@PathVariable("quotaId") Integer quotaId) {
        return payAssessmentQuotaService.delete(quotaId);
    }

}
