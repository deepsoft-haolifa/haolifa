package com.deepsoft.haolifa.controller.finance;


import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.receivable.PurchaseOrderReceivableRQDTO;
import com.deepsoft.haolifa.model.dto.finance.receivable.PurchaseOrderReceivableRSDTO;
import com.deepsoft.haolifa.service.PurcahseOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//
///**
// * 应收货款(销售合同列表)
// */
//@RestController
//@RequestMapping("/finance/receivable")
//@Api(tags = {"应收货款管理"})
//public class ReceivableController {
//
//    @Autowired
//    private PurcahseOrderService purcahseOrderService;
//
//    @ApiOperation("查询订单详情")
//    @GetMapping("info/{formId}")
//    public ResultBean getInfo(@PathVariable("formId") Integer id) {
//        return purcahseOrderService.getInfo(id);
//    }
//
//    @ApiOperation("查询应收货款列表")
//    @PostMapping("/list")
//    public ResultBean<PurchaseOrderReceivableRSDTO> list(@RequestBody PurchaseOrderReceivableRQDTO purchaseOrderDTO) {
//        return null;
//    }
//
//
//}
