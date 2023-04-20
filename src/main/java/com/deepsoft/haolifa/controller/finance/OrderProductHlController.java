package com.deepsoft.haolifa.controller.finance;


import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.receivable.ReceivableOrderRQDTO;
import com.deepsoft.haolifa.model.dto.finance.receivable.ReceivableOrderRSDTO;
import com.deepsoft.haolifa.model.dto.finance.sum.ProcurementSummaryRSDTO;
import com.deepsoft.haolifa.model.dto.finance.sum.SaleSummaryRQDTO;
import com.deepsoft.haolifa.model.dto.finance.sum.SaleSummaryRSDTO;
import com.deepsoft.haolifa.model.dto.finance.sum.SummaryRQDTO;
import com.deepsoft.haolifa.service.OrderProductService;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.service.finance.SumService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/finance")
@Api(tags = {"好利财务-销售订单"})
public class OrderProductHlController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SumService sumService;


    @Autowired
    private OrderProductService orderProductService;


    /**
     * 销售合同的汇总统计（销售合同）
     */
    @ApiOperation("销售合同的汇总统计（销售合同）")
    @PostMapping("/sum/saleContract/summary/list")
    @ResponseBody
    public ResultBean<PageDTO<SaleSummaryRSDTO>>  saleContractSummaryList(@RequestBody SaleSummaryRQDTO reqVo) {
        ResultBean<PageDTO<SaleSummaryRSDTO>> pageDTOResultBean = sumService.selectSaleContractSummary(reqVo);
        return pageDTOResultBean;
    }

    /**
     * 应收货款列表（销售合同）
     */
    @ApiOperation("应收货款列表（销售合同）")
    @PostMapping("/receivable/list")
    public ResultBean<PageDTO<ReceivableOrderRSDTO>> list(@RequestBody ReceivableOrderRQDTO model) {
        return orderProductService.receivableOrderList(model);
    }
    /**
     * 应收货款列表（销售合同）
     */
    @ApiOperation("应收货款列表（销售合同）")
    @PostMapping("/receivable/listSummary")
    public ResultBean<BigDecimal> listSummary(@RequestBody ReceivableOrderRQDTO model) {
        return orderProductService.receivableOrderListSummary(model);
    }



}
