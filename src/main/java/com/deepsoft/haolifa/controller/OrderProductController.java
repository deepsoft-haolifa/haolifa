package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.service.OrderProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @ApiOperation("成品订单信息添加")
    @PostMapping("/save")
    public ResultBean save(@RequestBody OrderProductDTO orderProduct) {
        return orderProductService.saveOrderProductInfo(orderProduct);
    }

    @ApiOperation("成品订单信息更新")
    @PostMapping("/updateInfo")
    public ResultBean updateInfo(@RequestBody OrderUpdateDTO orderUpdateDTO) {
        return orderProductService.updateOrderInfo(orderUpdateDTO);
    }

    @ApiOperation("成品订单状态更新")
    @PostMapping("/updateStatus")
    public ResultBean updateStatus(@RequestBody OrderStatusDTO orderStatusDTO) {
        return ResultBean.success(orderProductService.updateOrderProductStatus(orderStatusDTO.getOrderNo(), orderStatusDTO.getStatus()));
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
        return orderProductService.pageOrderProduct(currentPage, pageSize, orderNo, orderStatus);
    }

    @ApiOperation("核料时的零件选择")
    @ApiImplicitParam(name = "orderNo", value = "订单号", dataType = "String", paramType = "path", required = true)
    @GetMapping("/pre-check-material/{orderNo}")
    public ResultBean preCheckMaterial(@PathVariable String orderNo) {
        return ResultBean.success(orderProductService.getCheckOrderProductList(orderNo));
    }

    @ApiOperation("核料")
    @PostMapping("/check-material/")
    public ResultBean checkMaterial(@RequestBody List<OrderCheckMaterialDTO> orderCheckMaterialDTOS) {
        return ResultBean.success(orderProductService.checkMaterial(orderCheckMaterialDTOS));
    }

    @ApiOperation("核料成功")
    @PostMapping("/pass-check-material/")
    public ResultBean passCheckMaterial(@RequestBody List<OrderCheckMaterialDTO> orderCheckMaterialDTOS) {
        return ResultBean.success(orderProductService.checkPass(orderCheckMaterialDTOS));
    }


    @ApiOperation("生成领料单")
    @PostMapping("/material-requisition/save")
    public ResultBean saveMaterialRequisition(@RequestBody MaterialRequisitionDTO model) {
        return ResultBean.success(orderProductService.saveMaterialRequisition(model));
    }

    @ApiOperation("获取领料单详情")
    @GetMapping("/material-requisition/info")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, value = "订单号", name = "orderNo", dataType = "string", paramType = "query"),
            @ApiImplicitParam(value = "领料单号", name = "receiveNo", dataType = "string", paramType = "query")
    })
    public ResultBean infoMaterialRequisition(String orderNo, String receiveNo) {
        return ResultBean.success(orderProductService.infoMaterialRequisition(orderNo, receiveNo));
    }

}
