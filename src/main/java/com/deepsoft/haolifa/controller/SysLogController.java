package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.SysLogConditionDTO;
import com.deepsoft.haolifa.service.SysLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = {"系统日志管理"})
@RestController
@RequestMapping("/sys-log")
public class SysLogController {
    @Resource
    private SysLogService sysLogService;

    @PostMapping("page-list")
    @ApiOperation("获取登录日志分页列表")
    public ResultBean pageList(@RequestBody SysLogConditionDTO sysLogConditionDTO) {
        sysLogConditionDTO.setType((byte) 1);
        return ResultBean.success(sysLogService.pageList(sysLogConditionDTO));
    }
}
