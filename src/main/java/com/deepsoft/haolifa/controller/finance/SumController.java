package com.deepsoft.haolifa.controller.finance;


import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.sum.ProcurementSummaryRSDTO;
import com.deepsoft.haolifa.model.dto.finance.sum.SaleSummaryRSDTO;
import com.deepsoft.haolifa.model.dto.finance.sum.SummaryRQDTO;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.service.finance.SumService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/finance/sum")
@Api(tags = {"好利财务-采购销售汇总"})
public class SumController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SumService sumService;



    /**
     * 采购合同的汇总统计
     */
    @PostMapping("/procurement/summary/list")
    @ResponseBody
    public ResultBean<PageDTO<ProcurementSummaryRSDTO>>  procurementSummaryList(SummaryRQDTO reqVo) {
        ResultBean<PageDTO<ProcurementSummaryRSDTO>> pageDTOResultBean = sumService.selectProcurementSummary(reqVo);
        return pageDTOResultBean;
    }


    /**
     * 销售合同的汇总统计
     */
//    @PostMapping("/saleContract/summary/list")
//    @ResponseBody
//    public ResultBean<PageDTO<SaleSummaryRSDTO>>  saleContractSummaryList(SummaryRQDTO reqVo) {
//        ResultBean<PageDTO<SaleSummaryRSDTO>> pageDTOResultBean = sumService.selectSaleContractSummary(reqVo);
//        return pageDTOResultBean;
//    }

}
