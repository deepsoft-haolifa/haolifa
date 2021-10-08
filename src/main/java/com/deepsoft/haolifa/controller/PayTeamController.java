package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayTeamDTO;
import com.deepsoft.haolifa.model.dto.pay.PayTeamVO;
import com.deepsoft.haolifa.model.dto.pay.PayUserDTO;
import com.deepsoft.haolifa.service.PayTeamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author liuyaofei
 * @Date create in 上午11:37 2021/9/11
 * @description 班组管理
 */
@Api(tags = "绩效班组管理")
@RestController
@RequestMapping("/pay-team")
public class PayTeamController {

    @Resource
    private PayTeamService payTeamService;

    @ApiOperation("列表")
    @PostMapping("/getList")
    public ResultBean getList(@RequestBody PayTeamVO model) {
        return payTeamService.pageInfo(model);
    }


    @ApiOperation("保存")
    @PostMapping(value = "/save")
    public ResultBean save(@RequestBody PayTeamDTO model) {
        return payTeamService.save(model);
    }

    @ApiOperation("查看详情")
    @GetMapping(value = "info/{teamId}")
    public ResultBean getInfo(@PathVariable("teamId") Integer teamId) {
        return payTeamService.getInfo(teamId);
    }

    @ApiOperation("修改")
    @PostMapping(value = "/edit")
    public ResultBean edit(@RequestBody PayTeamDTO model) {
        return payTeamService.edit(model);
    }

    @ApiOperation("删除")
    @GetMapping(value = "del/{teamId}")
    public ResultBean del(@PathVariable("teamId") Integer teamId) {
        return payTeamService.delete(teamId);
    }

}
