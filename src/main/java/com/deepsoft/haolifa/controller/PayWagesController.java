package com.deepsoft.haolifa.controller;

import cn.hutool.poi.excel.ExcelWriter;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.model.domain.PayWages;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayWagesDTO;
import com.deepsoft.haolifa.model.dto.pay.PayWagesSaveVO;
import com.deepsoft.haolifa.model.dto.pay.PayWagesVO;
import com.deepsoft.haolifa.model.dto.pay.PayWorkAttendancePageDTO;
import com.deepsoft.haolifa.service.PayWagesService;
import com.deepsoft.haolifa.util.ExcelUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.Objects;

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
    public ResultBean save(@RequestBody PayWagesSaveVO model) {
        return payWagesService.save(model);
    }

    @ApiOperation("查看详情")
    @GetMapping(value = "info/{wagesId}")
    public ResultBean getInfo(@PathVariable("wagesId") Integer wagesId) {
        return payWagesService.getInfo(wagesId);
    }

    @ApiOperation("修改")
    @PostMapping(value = "/edit")
    public ResultBean edit(@RequestBody PayWagesSaveVO model) {
        return payWagesService.edit(model);
    }

    @ApiOperation("删除")
    @GetMapping(value = "del/{wagesId}")
    public ResultBean del(@PathVariable("wagesId") Integer wagesId) {
        return payWagesService.delete(wagesId);
    }

    @ApiOperation("计算工资")
    @PostMapping("/calculateSalary")
    public ResultBean calculateSalary(@RequestBody PayWagesVO payWagesVO) throws Exception {
        payWagesService.calculateSalary(payWagesVO);
        return ResultBean.success("ok");
    }

    @ApiOperation("生成工资列表")
    @PostMapping("/createWages")
    public ResultBean createWages(@RequestBody PayWagesVO payWagesVO) throws Exception {
        payWagesService.createWages(payWagesVO);
        return ResultBean.success("ok");
    }

    @ApiOperation("test")
    @PostMapping("/test")
    public ResultBean test(@RequestParam(value = "userId") Integer userId) {
        return payWagesService.test(userId);
    }
    @ApiOperation("导入工资数据")
    @PostMapping(value = "/import", headers = "content-type=multipart/form-data")
    public ResultBean importWages(@ApiParam(value = "工资Excel表格", required = true) MultipartFile file) {
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

    @ApiOperation("导出工资数据")
    @GetMapping(value = "/export")
    public void export(HttpServletResponse response) {
        ExcelWriter writer = null;
        try {
            writer = payWagesService.export();
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("工资模板", "utf-8") + ".xls");
            response.setContentType("application/octet-stream;");
            OutputStream outputStream = response.getOutputStream();
            writer.flush(outputStream, true);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(writer)) {
                writer.close();
            }
        }
    }

}
