package com.deepsoft.haolifa.controller.finance;


import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.standaccount.PurchaseOrderStandAccountRQDTO;
import com.deepsoft.haolifa.model.dto.finance.standaccount.PurchaseOrderStandAccountRSDTO;
import com.deepsoft.haolifa.service.PurcahseOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 财务挂账列表（采购合同）
 */
@RestController
@RequestMapping("/finance/standaccount")
@Api(tags = {"好利财务-财务挂账管理"})
public class StandAccountController {


    @Autowired
    private PurcahseOrderService purcahseOrderService;

    @ApiOperation("查询订单详情")
    @GetMapping("info/{formId}")
    public ResultBean getInfo(@PathVariable("formId") Integer id) {
        return purcahseOrderService.getInfo(id);
    }

    @ApiOperation("查询财务挂账列表")
    @PostMapping("/list")
    public ResultBean<PageDTO<PurchaseOrderStandAccountRSDTO>> list(@RequestBody PurchaseOrderStandAccountRQDTO purchaseOrderDTO) {
        return purcahseOrderService.standAccountList(purchaseOrderDTO);
    }

}
