package com.deepsoft.haolifa.controller;

import cn.hutool.poi.excel.ExcelWriter;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.model.domain.PayWorkAttendance;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayManagerCalDTO;
import com.deepsoft.haolifa.model.dto.pay.PayWorkAttendancePageDTO;
import com.deepsoft.haolifa.service.PayWorkAttendanceService;
import com.deepsoft.haolifa.util.BeanCopyUtils;
import com.deepsoft.haolifa.util.ExcelUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.Objects;

/**
 * @Author liuyaofei
 * @Date create in 上午11:37 2021/9/11
 * @description 考勤管理
 */
@Api(tags = "绩效考勤管理")
@RestController
@RequestMapping("/pay-work-attendance")
public class PayWorkAttendanceController {

    @Resource
    private PayWorkAttendanceService payWorkAttendanceService;

    @ApiOperation("列表")
    @PostMapping("/getList")
    public ResultBean getList(@RequestBody PayWorkAttendancePageDTO model) {
        return payWorkAttendanceService.pageInfo(model);
    }

    @ApiOperation("保存")
    @PostMapping(value = "/save")
    public ResultBean save(@RequestBody PayWorkAttendancePageDTO model) {
        return payWorkAttendanceService.save(model);
    }

    @ApiOperation("查看详情")
    @GetMapping(value = "info/{id}")
    public ResultBean getInfo(@PathVariable("id") Integer id) {
        return payWorkAttendanceService.getInfo(id);
    }

    @ApiOperation("修改")
    @PostMapping(value = "/edit")
    public ResultBean edit(@RequestBody PayWorkAttendancePageDTO model) {
        return payWorkAttendanceService.edit(model);
    }

    @ApiOperation("删除")
    @GetMapping(value = "del/{id}")
    public ResultBean del(@PathVariable("id") Integer id) {
        return payWorkAttendanceService.delete(id);
    }

    @ApiOperation("导入考勤数据")
    @PostMapping(value = "/import", headers = "content-type=multipart/form-data")
    public ResultBean uploadMaterial(@ApiParam(value = "导入考勤excel", required = true) MultipartFile file)  {
        try {
            if (file == null) {
                return ResultBean.error(CommonEnum.ResponseEnum.FILE_IS_NULL);
            }
            List<PayWorkAttendancePageDTO> objects = (List<PayWorkAttendancePageDTO>) ExcelUtils.importExcelReadColumn(file.getInputStream(), PayWorkAttendancePageDTO.class);
            List<PayWorkAttendance> payWorkAttendances = BeanCopyUtils.copyPropertiesForNewList(objects, () -> new PayWorkAttendance());
            payWorkAttendanceService.insert(payWorkAttendances);
            return ResultBean.success(1);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }

    @ApiOperation("导出考勤")
    @GetMapping(value = "export")
    public void export(HttpServletResponse response, @ApiParam("年份") @RequestParam(name = "attendYear") String attendYear,
                             @ApiParam("月份") @RequestParam(name = "attendMonth") String attendMonth) throws Exception {

        if (StringUtils.isBlank(attendYear) || StringUtils.isBlank(attendMonth)) {
            throw new Exception("年份或月份不能为空");
        }
        ExcelWriter writer = null;
        try {
            PayWorkAttendancePageDTO payWorkAttendancePageDTO = new PayWorkAttendancePageDTO();
            payWorkAttendancePageDTO.setAttendYear(attendYear);
            payWorkAttendancePageDTO.setAttendMonth(attendMonth);
            writer = payWorkAttendanceService.export(payWorkAttendancePageDTO);
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("考勤模板", "utf-8") + ".xls");
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

    @ApiOperation("生成固定月份考勤")
    @GetMapping(value = "createAttendance")
    public ResultBean createAttendance(@ApiParam("年份") @RequestParam(name = "attendYear") String attendYear,
                             @ApiParam("月份") @RequestParam(name = "attendMonth") String attendMonth) throws Exception {

        if (StringUtils.isBlank(attendYear) || StringUtils.isBlank(attendMonth)) {
            throw new Exception("年份或月份不能为空");
        }
        PayWorkAttendancePageDTO payWorkAttendancePageDTO = new PayWorkAttendancePageDTO();
        payWorkAttendancePageDTO.setAttendYear(attendYear);
        payWorkAttendancePageDTO.setAttendMonth(attendMonth);
        payWorkAttendanceService.createAttendance(payWorkAttendancePageDTO);
        return ResultBean.success(1);
    }

}
