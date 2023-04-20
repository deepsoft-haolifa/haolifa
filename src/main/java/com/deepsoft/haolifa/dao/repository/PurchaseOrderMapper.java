package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.PurchaseOrder;
import com.deepsoft.haolifa.model.domain.PurchaseOrderExample;
import com.deepsoft.haolifa.model.dto.PurchaseOrderRQParam;
import com.deepsoft.haolifa.model.dto.finance.standaccount.PurchaseOrderStandAccountRQDTO;
import com.deepsoft.haolifa.model.dto.finance.sum.ProcurementSummaryRSDTO;
import com.deepsoft.haolifa.model.dto.finance.sum.SaleSummaryRQDTO;
import com.deepsoft.haolifa.model.dto.finance.sum.SaleSummaryRSDTO;
import com.deepsoft.haolifa.model.dto.finance.sum.SummaryRQDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PurchaseOrderMapper {
    int countByExample(PurchaseOrderExample example);

    int deleteByExample(PurchaseOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PurchaseOrder record);

    int insertSelective(PurchaseOrder record);

    List<PurchaseOrder> selectByExample(PurchaseOrderExample example);

    PurchaseOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PurchaseOrder record, @Param("example") PurchaseOrderExample example);

    int updateByExample(@Param("record") PurchaseOrder record, @Param("example") PurchaseOrderExample example);

    int updateByPrimaryKeySelective(PurchaseOrder record);

    int updateByPrimaryKey(PurchaseOrder record);

    List<PurchaseOrder> selectListBy(PurchaseOrderStandAccountRQDTO example);

    List<PurchaseOrder>  selectPayPlanlistList(@Param("query") PurchaseOrderRQParam query);


    List<ProcurementSummaryRSDTO>  selectProcurementSummary(@Param("query") SummaryRQDTO query);

}
