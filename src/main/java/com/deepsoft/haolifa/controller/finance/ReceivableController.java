package com.deepsoft.haolifa.controller.finance;


import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.receivable.ReceivableOrderRQDTO;
import com.deepsoft.haolifa.model.dto.finance.receivable.ReceivableOrderRSDTO;
import com.deepsoft.haolifa.service.OrderProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 应收货款(销售合同列表)
 */
@RestController
@RequestMapping("/finance/receivable")
@Api(tags = {"好利财务-应收货款管理"})
public class ReceivableController {

    @Autowired
    private OrderProductService orderProductService;

//    @ApiOperation("查询订单详情")
//    @GetMapping("info/{formId}")
//    public ResultBean getInfo(@PathVariable("formId") Integer id) {
////        return orderProductService.getInfo(id);
//        return null;
//    }

    @ApiOperation("查询应收货款列表")
    @PostMapping("/list")
    public ResultBean<PageDTO<ReceivableOrderRSDTO>> list(@RequestBody ReceivableOrderRQDTO model) {
        return orderProductService.receivableOrderList(model);
    }


}
