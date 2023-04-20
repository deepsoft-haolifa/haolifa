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

@RestController
@RequestMapping("/finance")
@Api(tags = {"好利财务-采购订单"})
public class ProcurementHlController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SumService sumService;


    @Autowired
    private OrderProductService orderProductService;

    /**
     * 采购合同的汇总统计
     */
    @ApiOperation("采购合同的汇总统计")
    @PostMapping("/sum/procurement/summary/list")
    @ResponseBody
    public ResultBean<PageDTO<ProcurementSummaryRSDTO>>  procurementSummaryList(@RequestBody SummaryRQDTO reqVo) {
        ResultBean<PageDTO<ProcurementSummaryRSDTO>> pageDTOResultBean = sumService.selectProcurementSummary(reqVo);
        return pageDTOResultBean;
    }


}
