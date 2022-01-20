package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.request.PayWagesSearchReqVO;
import com.deepsoft.haolifa.model.dto.pay.response.PayWagesSearchResVO;
import com.deepsoft.haolifa.service.PayWagesSearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author liuyaofei
 * @Date create in 上午11:37 2021/9/11
 * @description 工资管理
 */
@Api(tags = "绩效工资查询管理")
@RestController
@RequestMapping("/pay-wages-search")
public class PayWagesSearchController {

    @Resource
    private PayWagesSearchService payWagesSearchService;

    @ApiOperation("列表")
    @PostMapping("/getList")
    public ResultBean<PageDTO<PayWagesSearchResVO>> getList(@RequestBody PayWagesSearchReqVO model) {
        return payWagesSearchService.pageInfo(model);
    }

}
