package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.CustomerInfoMapper;
import com.deepsoft.haolifa.model.domain.AutoControlEntrust;
import com.deepsoft.haolifa.model.domain.CustomerInfo;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.customer.CustomerInfoConditionDto;
import com.deepsoft.haolifa.service.CustomerInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 客户管理
 *
 * @author murphy.he
 **/
@Api(tags = "客户管理")
@RequestMapping("customer-info")
@RestController
public class CustomerInfoController {
    @Autowired
    private CustomerInfoService customerInfoService;
    @Resource
    private CustomerInfoMapper customerInfoMapper;

    @PostMapping("/add")
    @ApiOperation("添加")
    public ResultBean add(@RequestBody CustomerInfo customerInfo) {
        int add = customerInfoMapper.insertSelective(customerInfo);
        if (add > 0) {
            return ResultBean.success(add);
        } else {
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }

    @PostMapping("/update")
    @ApiOperation("更新")
    public ResultBean update(@RequestBody CustomerInfo customerInfo) {
        int update = customerInfoMapper.updateByPrimaryKeySelective(customerInfo);
        if (update > 0) {
            return ResultBean.success(update);
        } else {
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }

    @PostMapping("/del/{id}")
    @ApiOperation("删除")
    public ResultBean del(@PathVariable Integer id) {
        int del = customerInfoMapper.deleteByPrimaryKey(id);
        if (del > 0) {
            return ResultBean.success(del);
        } else {
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }

    @PostMapping("/detail/{id}")
    @ApiOperation("获取详情")
    public ResultBean<CustomerInfo> detail(@PathVariable Integer id) {
        return ResultBean.success(customerInfoMapper.selectByPrimaryKey(id));
    }

    @PostMapping("/page")
    @ApiOperation("分页列表")
    public ResultBean<PageDTO<CustomerInfo>> pageList(@RequestBody CustomerInfoConditionDto pageDto) {
        return ResultBean.success(customerInfoService.pageInfo(pageDto));
    }
}
