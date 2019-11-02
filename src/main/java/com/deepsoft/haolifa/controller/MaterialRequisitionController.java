package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.SysLogConditionDTO;
import com.deepsoft.haolifa.service.MaterialRequisitionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 领料表Controller
 *
 * @author murphy.he
 **/
@Api(tags = {"领料单管理"})
@RestController
@RequestMapping("/material-requisition")
public class MaterialRequisitionController {

    @Resource
    private MaterialRequisitionService materialRequisitionService;

    @PostMapping("page-list")
    @ApiOperation("获取登录日志分页列表")
    public ResultBean pageList(@RequestBody SysLogConditionDTO sysLogConditionDTO) {
        return null;
    }

}
