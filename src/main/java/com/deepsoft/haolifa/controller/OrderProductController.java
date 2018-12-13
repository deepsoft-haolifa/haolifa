package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.constant.Constant;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.order.*;
import com.deepsoft.haolifa.service.OrderProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
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

//    @ApiOperation("成品excel上传接口")
//    @PostMapping("/uploadExcel")
//    @ApiImplicitParam(name = "base64Source", value = "上传excel文件的base64编码", dataType = "String", required = true)
//    public ResultBean uploadOrderProductExcel(@RequestParam String base64Source) {
//        return orderProductService.uploadOrderProductExcel(base64Source);
//    }

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
    @PostMapping("/pageInfo")
    public ResultBean pageInfoClassify(@RequestBody OrderConditionDTO model) {
        return orderProductService.pageOrderProduct(model);
    }

    @ApiOperation("核料时的零件选择")
    @ApiImplicitParam(name = "orderNo", value = "订单号", dataType = "String", paramType = "path", required = true)
    @GetMapping("/pre-check-material/{orderNo}")
    public ResultBean preCheckMaterial(@PathVariable String orderNo) {
        return ResultBean.success(orderProductService.getCheckOrderProductList(orderNo));
    }

    @ApiOperation("核料（生成初步核料清单）")
    @PostMapping("/check-material/{orderNo}")
    public ResultBean checkMaterial(@PathVariable("orderNo") String orderNo, @RequestBody List<ProductCheckMaterialListDTO> productCheckMaterialListDTOList) {
        return ResultBean.success(orderProductService.checkMaterial(orderNo, productCheckMaterialListDTOList));
    }

    @ApiOperation("替换料核料")
    @PostMapping("/check-replace-material/{orderNo}")
    public ResultBean checkReplaceMaterial(@PathVariable("orderNo") String orderNo, @RequestBody List<OrderCheckMaterialDTO> orderCheckMaterialDTOS) {
        return ResultBean.success(orderProductService.checkReplaceMaterial(orderNo, orderCheckMaterialDTOS));
    }

    @ApiOperation("核料成功(核料清单保存数据库)")
    @PostMapping("/pass-check-material/")
    public ResultBean passCheckMaterial(@RequestBody List<OrderCheckMaterialDTO> orderCheckMaterialDTOS) {
        return ResultBean.success(orderProductService.checkPass(orderCheckMaterialDTOS));
    }

    @ApiOperation("释放锁住的零件（综合计划不同意）")
    @PostMapping("/release-material/{orderNo}")
    public ResultBean releaseMaterial(@PathVariable("orderNo") String orderNo) {
        return ResultBean.success(orderProductService.releaseMaterial(orderNo));
    }

    @ApiOperation("获取核料清单")
    @GetMapping("/order-material/{orderNo}")
    public ResultBean getOrderMaterialDetail(@PathVariable("orderNo") String orderNo) {
        return ResultBean.success(orderProductService.listOrderMaterial(orderNo));
    }

    @ApiOperation("获取订单号列表")
    @GetMapping("/order-no-list/{orderStatus}")
    @ApiImplicitParam(name = "orderStatus", value = Constant.ORDER_STATUS_DESC, dataType = "int", paramType = "path", required = true)
    public ResultBean getOrderMaterialDetail(@PathVariable("orderStatus") byte orderStatus) {
        return ResultBean.success(orderProductService.listOrderNo(orderStatus));
    }

//    @ApiOperation("生成领料单")
//    @PostMapping("/material-requisition/save")
//    public ResultBean saveMaterialRequisition(@RequestBody MaterialRequisitionDTO model) {
//        return ResultBean.success(orderProductService.saveMaterialRequisition(model));
//    }
//
//    @ApiOperation("获取领料单详情")
//    @GetMapping("/material-requisition/info")
//    @ApiImplicitParams({
//            @ApiImplicitParam(required = true, value = "订单号", name = "orderNo", dataType = "string", paramType = "query"),
//            @ApiImplicitParam(value = "领料单号", name = "receiveNo", dataType = "string", paramType = "query")
//    })
//    public ResultBean infoMaterialRequisition(String orderNo, String receiveNo) {
//        return ResultBean.success(orderProductService.infoMaterialRequisition(orderNo, receiveNo));
//    }

}
