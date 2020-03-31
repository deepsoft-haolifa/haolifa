package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.dto.export.ExportContractDTO;
import com.deepsoft.haolifa.model.dto.export.ExportSaleDTO;
import com.deepsoft.haolifa.model.dto.export.ExportpPurchaseDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SaleReportMapper {
    //获取目前生产总金额总数量
    List<ExportSaleDTO> selectAll(@Param("year") String year);
    //根据月份获取生产总金额 总数量
    List<ExportSaleDTO> selectByMonth(@Param("startTime") String startTime,@Param("endTime") String endTime);
    List<ExportContractDTO> selectContractByDemandName(@Param("year") String year);
    List<ExportContractDTO> selectshouhuiContractByDemandName(@Param("year") String year);

    //根据产品型号获取生产金额数量
    List<ExportSaleDTO> selectByModel(@Param("year") String year);

    //获取目前合同总金额总数量
    List<ExportSaleDTO> selectAllContract();
    //根据月份获取生产总金额 总数量
    List<ExportSaleDTO> selectByMonthContract(@Param("startTime") String startTime,@Param("endTime") String endTime);

    //根据产品型号获取生产金额数量
    List<ExportSaleDTO> selectByModelContract();

    /**
     * 按需方统计的开票总金额
     */
    List<ExportContractDTO> selectInvoiceAmountByDemandName(@Param("year") String year);
    /**
     * 按需方统计的发货总金额
     */
    List<ExportContractDTO> selectDeliveryAmountByDemandName(@Param("year") String year);
}
