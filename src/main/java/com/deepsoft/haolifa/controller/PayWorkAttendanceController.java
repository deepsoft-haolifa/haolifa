package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.model.domain.PayWorkAttendance;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayWorkAttendancePageDTO;
import com.deepsoft.haolifa.service.PayWorkAttendanceService;
import com.deepsoft.haolifa.util.ExcelUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author liuyaofei
 * @Date create in 上午11:37 2021/9/11
 * @description 考勤管理
 */
@Api(tags = "考勤管理")
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


    @ApiOperation("导入考勤数据")
    @PostMapping(value = "/import", headers = "content-type=multipart/form-data")
    public ResultBean uploadMaterial(@ApiParam(value = "考勤Excel表格", required = true) MultipartFile file) {
        try {
            if (file == null) {
                return ResultBean.error(CommonEnum.ResponseEnum.FILE_IS_NULL);
            }
            List<PayWorkAttendance> objects = (List<PayWorkAttendance>) ExcelUtils.importExcelReadColumn(file.getInputStream(), PayWorkAttendance.class);
            payWorkAttendanceService.insert(objects);
            return ResultBean.success(1);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }

}
