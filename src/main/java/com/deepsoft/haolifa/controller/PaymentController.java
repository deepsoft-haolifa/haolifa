package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.PaymentDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "收付款管理")
@RestController
@RequestMapping("/payment")
public class PaymentController {

  @Autowired
  private PaymentService paymentService;

  @ApiOperation("添加收付款记录")
  @PostMapping("/save")
  public ResultBean save(@RequestBody PaymentDTO model) {
    return paymentService.save(model);
  }

  @ApiOperation("删除收付款记录")
  @PostMapping("/delete/{id}")
  public ResultBean delete(@ApiParam("记录id") @PathVariable("id") int id) {
    return paymentService.delete(id);
  }

  @ApiOperation("记录列表")
  @GetMapping("list")
  @ApiImplicitParam(name = "orderNo", value = "订单号", dataType = "String", paramType = "query", required = true)
  public ResultBean list(String orderNo) {
    return paymentService.list(orderNo);
  }

}
