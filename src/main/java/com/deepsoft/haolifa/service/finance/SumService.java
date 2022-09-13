package com.deepsoft.haolifa.service.finance;

import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.sum.ProcurementSummaryRSDTO;
import com.deepsoft.haolifa.model.dto.finance.sum.SaleSummaryRQDTO;
import com.deepsoft.haolifa.model.dto.finance.sum.SaleSummaryRSDTO;
import com.deepsoft.haolifa.model.dto.finance.sum.SummaryRQDTO;

public interface SumService {


    /**
     * 采购合同汇总（按照供应商）
     */
    ResultBean<PageDTO<ProcurementSummaryRSDTO>> selectProcurementSummary(SummaryRQDTO reqVo);

    /**
     * 销售合同汇总（按照客户）
     */
    ResultBean<PageDTO<SaleSummaryRSDTO>> selectSaleContractSummary(SaleSummaryRQDTO reqVo);


}
