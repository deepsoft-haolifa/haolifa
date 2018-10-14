package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.OrderProductDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.OrderProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"订单成品相关管理"})
@RestController
@RequestMapping("/order-product/")
public class OrderProductController {

    @Autowired
    private OrderProductService orderProductService;

    @ApiOperation("成品excel上传接口")
    @PostMapping("/uploadExcel")
    @ApiImplicitParam(name = "base64Source", value = "上传excel文件的base64编码", dataType = "String", required = true)
    public ResultBean uploadOrderProductExcel(@RequestParam String base64Source) {
        return orderProductService.uploadOrderProductExcel(base64Source);
    }

    @ApiOperation("成品订单合同上传--开发中")
    @PostMapping("/uploadContract")
    @ApiImplicitParam(name = "base64Source", value = "上传成品订单合同的base64编码", dataType = "String", required = true)
    public ResultBean uploadOrderProductContract(@RequestParam String base64Source) {
//        return orderProductService.uploadOrderProductExcel(base64Source);
        return null;
    }

    @ApiOperation("成品订单信息添加")
    @PostMapping("/save")
    public ResultBean save(@RequestBody OrderProductDTO orderProduct) {
        return orderProductService.saveOrderProductInfo(orderProduct);
    }

    @ApiOperation("获取成品订单详情")
    @GetMapping("/details/{orderNo}")
    @ApiImplicitParam(name = "orderNo", value = "订单号", dataType = "String", paramType = "path", required = true)
    public ResultBean details(@PathVariable String orderNo) {
        return ResultBean.success(orderProductService.getOrderProductInfo(orderNo));
    }


    @ApiOperation("获取成品订单分页列表")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, value = "当前页面", name = "currentPage", dataType = "int", paramType = "query"),
            @ApiImplicitParam(required = true, value = "每页数量", name = "pageSize", dataType = "int", paramType = "query"),
            @ApiImplicitParam(value = "订单号", name = "orderNo", dataType = "string", paramType = "query"),
            @ApiImplicitParam(value = "订单状态", name = "orderStatus", dataType = "int", paramType = "query")
    })
    @GetMapping("/pageInfo")
    public ResultBean pageInfoClassify(@RequestParam(defaultValue = "1") Integer currentPage,
                                       @RequestParam(defaultValue = "20") Integer pageSize,
                                       @RequestParam(required = false) String orderNo,
                                       @RequestParam(required = false) int orderStatus) {
        return orderProductService.pageOrderProduct(currentPage, pageSize, orderNo,orderStatus);
    }
}
