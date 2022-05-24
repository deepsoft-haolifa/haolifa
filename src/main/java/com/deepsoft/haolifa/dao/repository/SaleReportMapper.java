package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.dto.export.*;
import com.deepsoft.haolifa.model.dto.order.OrderConditionDTO;
import com.deepsoft.haolifa.model.dto.report.ReportBaseDTO;
import com.deepsoft.haolifa.model.dto.report.ReportOrderConditionDTO;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface SaleReportMapper {

    //根据月份获取生产总金额 总数量
    String selectByMonth(@Param("startTime") String startTime,@Param("endTime") String endTime);

    /**
     * 根据年份获取按照需求方的订货总额
     * @param haspMap
     * @return
     */
    List<ExportContractDTO> selectContractByDemandName(Map<String, Object> haspMap);
    /**
     * 根据年-月份获取按照需求方的订货总额
     * @param haspMap
     * @return
     */
    List<ExportContractDTO>  selectContractByDemandNameMonth(Map<String, Object> haspMap);

    List<ExportContractDTO> selectshouhuiContractByDemandName(Map<String, Object> haspMap);

    List<ExportContractDTO>  selectshouhuiContractByDemandNameMonth(Map<String, Object> haspMap);

    //根据产品型号获取生产金额数量
    List<ExportSaleDTO> selectByModel(@Param("year") String year);

    //获取目前合同总金额总数量
    List<ExportSaleDTO> selectAllContract(@Param("year") String year);
    //根据月份获取生产总金额 总数量
    List<ExportSaleDTO> selectByMonthContract(@Param("startTime") String startTime,@Param("endTime") String endTime);

    //根据产品型号获取生产金额数量
    List<ExportSaleDTO> selectByModelContract();

    /**
     * 按需方统计的开票总金额
     */
    List<ExportContractDTO> selectInvoiceAmountByDemandName(Map<String, Object> haspMap);
    /**
     * 按需方统计的发货总金额
     */
    List<ExportContractDTO> selectDeliveryAmountByDemandName(Map<String, Object> haspMap);


    /**
     * 回款订单统计列表
     */
    List<PaymentRespDTO>  selectSaleCollectionList(ReportOrderConditionDTO model);
    /**
     * 回款订单统计数据
     */
    TotalAmountDTO  reportCollectOrderSummary(ReportOrderConditionDTO model);
    /**
     * 订单列表-按需方统计
     */

    List<DemandSaleAmountRespDTO> reportSaleByDemandList(ReportOrderConditionDTO model);
    /**
     * 订单统计-按需方统计
     */
    DemandSaleAmountRespDTO reportSaleByDemandSummary(ReportOrderConditionDTO model);

    /**
     * 销售报表-产值列表
     */

    List<SaleOutputRespDTO> reportOutputList(ReportOrderConditionDTO model);




    // 获取 生产产值和数量
    SaleAllRespDTO selectOutputSummary(ReportOrderConditionDTO model);

      // 获取 订货金额和数量
    SaleAllRespDTO selectSaleSummary(ReportOrderConditionDTO model);

    // 获取 开票金额
    BigDecimal selectInvoiceSummary(ReportOrderConditionDTO model);

    // 获取 回款金额
    BigDecimal selectCollectSummary(ReportOrderConditionDTO model);

    // 获取 发货金额
    BigDecimal selectDeliverySummary(ReportOrderConditionDTO model);

}
