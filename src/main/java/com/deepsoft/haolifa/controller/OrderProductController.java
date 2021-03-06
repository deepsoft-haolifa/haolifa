package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.constant.Constant;
import com.deepsoft.haolifa.model.dto.Accessory;
import com.deepsoft.haolifa.model.dto.FileUploadDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.order.*;
import com.deepsoft.haolifa.service.OrderProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = {"订单成品相关管理"})
@RestController
@RequestMapping("/order-product")
public class OrderProductController {

    @Autowired
    private OrderProductService orderProductService;

    @ApiOperation("生成订单")
    @PostMapping("/generateOrder")
    public ResultBean uploadContract(@RequestBody GenerateOrderDTO generateOrderDTO) {
        return orderProductService.generateOrder(generateOrderDTO);
    }

    @ApiOperation("平台订单文件上传接口（只能是Excel）")
    @PostMapping("/uploadContract")
    public ResultBean uploadContract(@RequestBody OrderUploadDTO orderUploadDTO) {
        return orderProductService.uploadOrderProduct(orderUploadDTO);
    }

    @Deprecated
    @ApiOperation("上传订单附件数据")
    @PostMapping("/uploadOrderFile")
    @ApiImplicitParam(name = "orderNo", value = "订单号", dataType = "String", paramType = "query", required = true)
    public ResultBean uploadOrderFile(String orderNo, @RequestBody List<OrderUploadDTO> orderUploadDTOs) {
        return orderProductService.uploadOrderFiles(orderNo, orderUploadDTOs);
    }

    @Deprecated
    @ApiOperation("删除订单附件数据")
    @DeleteMapping("/delOrderFile/{fileId}")
    public ResultBean uploadOrderFile(@PathVariable int fileId) {
        return orderProductService.delOrderFiles(fileId);
    }

    @Deprecated
    @ApiOperation("获取订单附件列表")
    @GetMapping("/getOrderFiles")
    @ApiImplicitParam(name = "orderNo", value = "订单号", dataType = "String", paramType = "query", required = true)
    public ResultBean getOrderFiles(String orderNo) {
        return orderProductService.getOrderFiles(orderNo);
    }

    @ApiOperation("上传订单附件")
    @PostMapping("/accessory-upload")
    @ApiImplicitParam(name = "orderNo", value = "订单号", dataType = "String", paramType = "query", required = true)
    public ResultBean uploadAccessory(String orderNo, @RequestBody List<Accessory> orderUploadDTOs) {
        return orderProductService.uploadAccessory(orderNo, orderUploadDTOs);
    }

    @ApiOperation("获取订单附件")
    @GetMapping("/accessory")
    @ApiImplicitParam(name = "orderNo", value = "订单号", dataType = "String", paramType = "query", required = true)
    public ResultBean getAccessory(String orderNo) {
        return orderProductService.getAccessory(orderNo);
    }

    @ApiOperation("成品订单信息添加")
    @PostMapping("/save")
    public ResultBean save(@RequestBody OrderProductDTO orderProduct) {
        return orderProductService.saveOrderProductInfo(orderProduct);
    }

    @ApiOperation("成品订单信息删除")
    @DeleteMapping("/delete/{id}")
    @ApiImplicitParam(name = "id", value = "订单id", dataType = "int", paramType = "path", required = true)
    public ResultBean delete(@PathVariable int id) {
        return orderProductService.deleteOrderInfo(id);
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
    @GetMapping("/details")
    @ApiImplicitParam(name = "orderNo", value = "订单号", dataType = "String", paramType = "query", required = true)
    public ResultBean details(String orderNo) {
        return ResultBean.success(orderProductService.getOrderProductInfo(orderNo));
    }


    @ApiOperation("获取成品订单分页列表")
    @PostMapping("/pageInfo")
    public ResultBean pageInfoClassify(@RequestBody OrderConditionDTO model) {
        return orderProductService.pageOrderProduct(model);
    }

    @ApiOperation("核料时的零件选择")
    @ApiImplicitParam(name = "orderNo", value = "订单号", dataType = "String", paramType = "query", required = true)
    @GetMapping("/pre-check-material")
    public ResultBean preCheckMaterial(String orderNo) {
        return ResultBean.success(orderProductService.getCheckOrderProductList(orderNo));
    }

    @ApiOperation("核料（生成初步核料清单）")
    @PostMapping("/check-material")
    @ApiImplicitParam(name = "orderNo", value = "订单号", dataType = "String", paramType = "query", required = true)
    public ResultBean checkMaterial(String orderNo, @RequestBody List<ProductCheckMaterialListDTO> productCheckMaterialListDTOList) {
        return ResultBean.success(orderProductService.checkMaterial(orderNo, productCheckMaterialListDTOList));
    }

//    @ApiOperation("替换料核料")
//    @PostMapping("/check-replace-material")
//    @ApiImplicitParam(name = "orderNo", value = "订单号", dataType = "String", paramType = "query", required = true)
//    public ResultBean checkReplaceMaterial(String orderNo, @RequestBody List<OrderCheckMaterialDTO> orderCheckMaterialDTOS) {
//        return ResultBean.success(orderProductService.checkReplaceMaterial(orderNo, orderCheckMaterialDTOS));
//    }

    @ApiOperation("核料成功(核料清单保存数据库)")
    @PostMapping("/pass-check-material")
    public ResultBean passCheckMaterial(@RequestBody List<OrderCheckMaterialDTO> orderCheckMaterialDTOS) {
        return ResultBean.success(orderProductService.checkPass(orderCheckMaterialDTOS));
    }

    @ApiOperation("释放锁住的零件（综合计划不同意）")
    @PostMapping("/release-material")
    @ApiImplicitParam(name = "orderNo", value = "订单号", dataType = "String", paramType = "query", required = true)
    public ResultBean releaseMaterial(String orderNo) {
        return ResultBean.success(orderProductService.releaseMaterial(orderNo));
    }

    @ApiOperation("获取核料清单")
    @GetMapping("/order-material")
    @ApiImplicitParam(name = "orderNo", value = "订单号", dataType = "String", paramType = "query", required = true)
    public ResultBean getOrderMaterialDetail(String orderNo) {
        return ResultBean.success(orderProductService.listOrderMaterial(orderNo));
    }

    @ApiOperation("获取订单号列表")
    @GetMapping("/order-no-list/{orderStatus}")
    @ApiImplicitParam(name = "orderStatus", value = Constant.ORDER_STATUS_DESC, dataType = "String", paramType = "path", required = true)
    public ResultBean orderNoList(@PathVariable("orderStatus") String orderStatus) {
        return ResultBean.success(orderProductService.listOrderNo(orderStatus));
    }

    @ApiOperation("获取订单的产品列表（只包含产品）")
    @GetMapping("/product-list")
    @ApiImplicitParam(name = "orderNo", value = "订单号", dataType = "String", paramType = "query", required = true)
    public ResultBean productList(String orderNo) {
        return ResultBean.success(orderProductService.getOrderProductList(orderNo));
    }

    @ApiOperation("替换料列表，根据orderNo")
    @GetMapping("/replace-material-list")
    @ApiImplicitParam(required = true, value = "订单号", name = "orderNo", dataType = "string", paramType = "query")
    public ResultBean listReplaceMaterial(String orderNo) {
        return ResultBean.success(orderProductService.listReplaceMaterial(orderNo));
    }

    @ApiOperation("替换料详情，根据主键")
    @GetMapping("/replace-material-detail/{id}")
    @ApiImplicitParam(required = true, value = "主键", name = "id", dataType = "int", paramType = "path")
    public ResultBean infoReplaceMaterial(@PathVariable Integer id) {
        return ResultBean.success(orderProductService.infoReplaceMaterial(id));
    }

    @ApiOperation("替换料审批完的操作")
    @PostMapping("/replace-material-audit/")
    public ResultBean auditReplaceMaterial(@RequestBody CheckReplaceMaterialAuditDTO model) {
        return ResultBean.success(orderProductService.auditReplaceMaterial(model));
    }


    @ApiOperation("获取订单状态列表")
    @GetMapping("/order-status-list")
    public ResultBean orderStatusList() {
        List<Map<String, Object>> list = new ArrayList<>();
        CommonEnum.OrderStatus[] orderStatus = CommonEnum.OrderStatus.values();
        for (CommonEnum.OrderStatus e : orderStatus) {
            Map<String, Object> map = new HashMap<>();
            map.put("code", e.code);
            map.put("desc", e.desc);
            list.add(map);
        }
        return ResultBean.success(list);
    }
    @ApiOperation("更新订单发货状态")
    @PutMapping("/deliver/status")
    public ResultBean updateDeliverStatus(@RequestParam String orderNo, @RequestParam Integer status) {
        return orderProductService.updateOrderDeliverStatus(orderNo, status, null);
    }

    @ApiOperation("更新订单需方字段")
    @GetMapping("/demand/update")
    public ResultBean updateOrderDemand(@RequestParam String orderNo, String demandName) {
        return orderProductService.updateOrderDemand(orderNo, demandName);
    }

    @ApiOperation("查询订单号列表")
    @GetMapping("/list/orderNo/{type}")
    public ResultBean getOrderNoListByquery(@PathVariable("type") Integer type, @RequestParam("订单状态：发货状态 or 流程状态") Integer status, String orderNo) {
        return orderProductService.getOrderNoListByquery(type, status, orderNo);
    }


    @ApiOperation("修改合同价格和数量")
    @PostMapping("/update-associate-info")
    public ResultBean updateAssociateInfo(@RequestBody List<OrderProductAssociateUpdateDTO> models) {
        return ResultBean.success(orderProductService.updateAssociateInfo(models));
    }

    @ApiOperation("修改合同价格和数量后，覆盖原来的excel")
    @PostMapping("/cover-order-excel")
    public ResultBean coverOrderExcel(@RequestBody OrderContractUpdateDTO dto) {
        return ResultBean.success(orderProductService.updateContractUrl(dto));
    }
}
