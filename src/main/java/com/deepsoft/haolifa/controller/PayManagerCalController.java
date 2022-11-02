package com.deepsoft.haolifa.controller;

import cn.hutool.poi.excel.ExcelWriter;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.model.domain.PayHourQuota;
import com.deepsoft.haolifa.model.domain.PayManagerCal;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayManagerCalDTO;
import com.deepsoft.haolifa.model.dto.pay.PayManagerCalPageDTO;
import com.deepsoft.haolifa.model.dto.pay.response.PayManagerCalVO;
import com.deepsoft.haolifa.service.PayManagerCalService;
import com.deepsoft.haolifa.util.ExcelUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.Objects;

/**
 * @author ：liuyaofei
 * @date ：Created in 2022/3/4 3:07 下午
 * @description：绩效管理-管理人员计提方式
 */
@Slf4j
@Api(tags = "绩效管理-管理人员计提方式")
@RestController
@RequestMapping("/pay-manager_cal")
public class PayManagerCalController {

    @Resource
    private PayManagerCalService payManagerCalService;

    @ApiOperation("列表")
    @PostMapping("/getList")
    public ResultBean<PageDTO<PayManagerCalVO>> getList(@RequestBody PayManagerCalPageDTO model) {
        return payManagerCalService.pageInfo(model);
    }

    @ApiOperation("保存")
    @PostMapping(value = "/save")
    public ResultBean save(@RequestBody PayManagerCalDTO model) {
        return payManagerCalService.save(model);
    }

    @ApiOperation("查看详情")
    @GetMapping(value = "info/{id}")
    public ResultBean<PayManagerCalVO> getInfo(@PathVariable("id") Integer id) {
        return payManagerCalService.getInfo(id);
    }

    @ApiOperation("修改")
    @PostMapping(value = "/edit")
    public ResultBean edit(@RequestBody PayManagerCalDTO model) {
        return payManagerCalService.edit(model);
    }

    @ApiOperation("删除")
    @GetMapping(value = "del/{id}")
    public ResultBean del(@PathVariable("id") Integer id) {
        return payManagerCalService.delete(id);
    }

    @ApiOperation("导入管理人员计提")
    @PostMapping(value = "/import", headers = "content-type=multipart/form-data")
    public ResultBean uploadMaterial(@ApiParam(value = "导入管理人员计提", required = true) MultipartFile file) {
        try {
            log.info("导入管理人员计提开始~~~~");
//            File file = new File("/Users/liuyaofei/haolifa/管理人员计提新20221027（系统上传）(1).xlsx");
//            FileInputStream fileInputStream = new FileInputStream(file);

            List<PayManagerCalDTO> objects = (List<PayManagerCalDTO>) ExcelUtils.importExcelReadColumn(file.getInputStream(), PayManagerCalDTO.class);
            payManagerCalService.save(objects);
            log.info("导入管理人员计提结束~~~~");
            return ResultBean.success(1);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }

    @ApiOperation("导出管理人员计提")
    @GetMapping(value = "export")
    public ResultBean export(HttpServletResponse response) {
        ExcelWriter writer = null;
        try {
            writer = payManagerCalService.export(new PayManagerCalDTO());
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("管理人员计提", "utf-8") + ".xls");
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
        return ResultBean.success(1);
    }

    @ApiOperation(value = "查询所有")
    @GetMapping(value = "getAllList")
    public ResultBean getList() {
        List<PayManagerCal> list = payManagerCalService.getList(new PayManagerCalDTO());
        return ResultBean.success(list);
    }

    @ApiOperation(value = "同步计提部门关联数据")
    @GetMapping(value = "syncData")
    public ResultBean syncData() {
        payManagerCalService.syncData();
        return ResultBean.success(null);
    }
}
