package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.model.domain.PayWages;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayWagesDTO;
import com.deepsoft.haolifa.service.PayWagesService;
import com.deepsoft.haolifa.util.ExcelUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author liuyaofei
 * @Date create in 上午11:37 2021/9/11
 * @description 工资管理
 */
@Api(tags = "绩效工资管理")
@RestController
@RequestMapping("/pay-wages")
public class PayWagesController {

    @Resource
    private PayWagesService payWagesService;

    @ApiOperation("列表")
    @PostMapping("/getList")
    public ResultBean getList(@RequestBody PayWagesDTO model) {
        return payWagesService.pageInfo(model);
    }


    @ApiOperation("保存")
    @PostMapping(value = "/save")
    public ResultBean save(@RequestBody PayWages model) {
        return payWagesService.save(model);
    }

    @ApiOperation("查看详情")
    @GetMapping(value = "info/{wagesId}")
    public ResultBean getInfo(@PathVariable("wagesId") Integer wagesId) {
        return payWagesService.getInfo(wagesId);
    }

    @ApiOperation("修改")
    @PostMapping(value = "/edit")
    public ResultBean edit(@RequestBody PayWages model) {
        return payWagesService.edit(model);
    }

    @ApiOperation("删除")
    @GetMapping(value = "del/{wagesId}")
    public ResultBean del(@PathVariable("wagesId") Integer wagesId) {
        return payWagesService.delete(wagesId);
    }

    @ApiOperation("导入工资数据")
    @PostMapping(value = "/import", headers = "content-type=multipart/form-data")
    public ResultBean uploadMaterial(@ApiParam(value = "工资Excel表格", required = true) MultipartFile file) {
        try {
            if (file == null) {
                return ResultBean.error(CommonEnum.ResponseEnum.FILE_IS_NULL);
            }
            List<PayWages> objects = (List<PayWages>) ExcelUtils.importExcelReadColumn(file.getInputStream(), PayWages.class);
            payWagesService.insert(objects);
            return ResultBean.success(1);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }

}
