package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.model.domain.PayHourQuota;
import com.deepsoft.haolifa.model.domain.PayWorkAttendance;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayHourQuotaDTO;
import com.deepsoft.haolifa.service.PayHourQuotaService;
import com.deepsoft.haolifa.util.ExcelUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

/**
 * @Author liuyaofei
 * @Date create in 上午9:29 2021/10/17
 * @description 绩效工时定额管理
 */
@Api(tags = "绩效工时定额管理")
@RestController
@RequestMapping("/pay-hour_quota")
public class PayHourQuotaController {
    @Resource
    private PayHourQuotaService payHourQuotaService;

    @ApiOperation("列表")
    @PostMapping("/getList")
    public ResultBean getList(@RequestBody PayHourQuotaDTO model) {
        return payHourQuotaService.pageInfo(model);
    }

    @ApiOperation("保存")
    @PostMapping(value = "/save")
    public ResultBean save(@RequestBody PayHourQuotaDTO model) {
        return payHourQuotaService.save(model);
    }

    @ApiOperation("查看详情")
    @GetMapping(value = "info/{id}")
    public ResultBean getInfo(@PathVariable("id") Integer id) {
        return payHourQuotaService.getInfo(id);
    }

    @ApiOperation("修改")
    @PostMapping(value = "/edit")
    public ResultBean edit(@RequestBody PayHourQuotaDTO model) {
        return payHourQuotaService.edit(model);
    }

    @ApiOperation("删除")
    @GetMapping(value = "del/{id}")
    public ResultBean del(@PathVariable("id") Integer id) {
        return payHourQuotaService.delete(id);
    }

    @ApiOperation("获取全部list")
    @PostMapping(value = "getAllList")
    public ResultBean getAllList(@RequestBody PayHourQuotaDTO payHourQuotaDTO) {
        return ResultBean.success(payHourQuotaService.getList(payHourQuotaDTO));
    }

    @ApiOperation("导入工时定额")
    @PostMapping(value = "/import")
    public ResultBean uploadMaterial() {
        try {
            File file2 =new File("/Users/liuyaofei/haolifa/各车间工时定额汇总表（第一版终表）(2).xlsx");
            FileInputStream fileInputStream = new FileInputStream(file2);
            List<PayHourQuota> objects = (List<PayHourQuota>) ExcelUtils.importExcelReadColumn(fileInputStream, PayHourQuota.class);
            payHourQuotaService.save(objects);
            return ResultBean.success(1);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }
}
