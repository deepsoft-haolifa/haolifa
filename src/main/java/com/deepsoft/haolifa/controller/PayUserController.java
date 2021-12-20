package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayUserDTO;
import com.deepsoft.haolifa.model.vo.pay.PayUserVO;
import com.deepsoft.haolifa.service.PayUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @Author liuyaofei
 * @Date create in 上午11:37 2021/9/11
 * @description 人员管理
 */
@Api(tags = "绩效人员管理")
@RestController
@RequestMapping("/pay-user")
public class PayUserController {

    @Resource
    private PayUserService payUserService;

    @ApiOperation("列表")
    @PostMapping("/getList")
    public ResultBean getList(@RequestBody PayUserDTO model) {
        return payUserService.pageInfo(model);
    }

    @ApiOperation("列表")
    @PostMapping("/getAllList")
    public ResultBean getAllList(@RequestBody PayUserVO payUserVO) {
        return payUserService.getAllList(payUserVO);
    }

    @ApiOperation("保存")
    @PostMapping(value = "/save")
    public ResultBean save(@RequestBody PayUserDTO model) {
        return payUserService.save(model);
    }

    @ApiOperation("查看详情")
    @GetMapping(value = "info/{userId}")
    public ResultBean getInfo(@PathVariable("userId") Integer userId) {
        return payUserService.getInfo(userId);
    }

    @ApiOperation("修改")
    @PostMapping(value = "/edit")
    public ResultBean edit(@RequestBody PayUserDTO model) {
        return payUserService.edit(model);
    }

    @ApiOperation("删除")
    @GetMapping(value = "del/{userId}")
    public ResultBean del(@PathVariable("userId") Integer userId) {
        return payUserService.delete(userId);
    }

    @ApiOperation("保存人员工序关联表")
    @PostMapping(value = "/saveUserRelationProcedure")
    public ResultBean saveUserRelationProcedure(@RequestParam(value = "userId", required = true) Integer userId,
                           @RequestParam(value = "procedureIdList", required = true) List<Integer> procedureIdList) {
        if (Objects.isNull(userId) || Objects.isNull(procedureIdList)) {
            throw new RuntimeException("userId or procedureId is null");
        }
        return payUserService.saveUserRelationProcedure(userId, procedureIdList);
    }
}
