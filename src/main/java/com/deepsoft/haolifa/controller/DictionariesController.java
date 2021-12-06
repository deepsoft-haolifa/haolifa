package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.DictionariesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = {"字典表"})
@RestController
@RequestMapping("/dictionaries")
@Slf4j
public class DictionariesController {

    @Resource
    private DictionariesService dictionariesService;
    @ApiOperation("获取绩效人员类型")
    @GetMapping("/getUserType")
    public ResultBean getClassifyList() {
        return ResultBean.success(dictionariesService.getUserType());
    }
}
