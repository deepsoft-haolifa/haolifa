package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.export.*;
import com.deepsoft.haolifa.model.dto.export.DemandAmountDto;
import com.deepsoft.haolifa.model.dto.report.ReportBaseDTO;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

public interface ReportService {

    //获取采购合同报表
    ResultBean selectBySupplierName(ReportSupplierConditionDTO dto);

    /**
     * 采购报表--采购统计
     *
     * @return
     */
    ResultBean selectPurchase(ReportSupplierConditionDTO baseDTO);

    /**
     * 采购报表--好利公司按月采购统计
     *
     * @return
     */
    ResultBean selectAllPurchase(String year);

    //销售报表
    //获取目前总金额总数量
    List<ExportSaleDTO> selectAll(String year);

    //根据月份获取总金额
    String selectByMonth(String startTime, String endTime);

    /**
     * 销售报表--年度订货
     * @param year
     * @return
     */
    List<ExportSaleMapDTO> selectContractByDemandName(String year);
    /**
     * 销售报表--月度订货
     * @param baseDTO
     * @return
     */
    List<ExportContractDTO> selectContractByDemandNameByMonth(ReportBaseDTO baseDTO);
    /**
     * 销售报表--年度回款
     * @param year
     * @return
     */
    List<ExportSaleMapDTO>   selectshouhuiContractByDemandName(String year);
    /**
     * 销售报表--月度回款
     * @param baseDTO
     * @return
     */
    List<ExportContractDTO> selectshouhuiContractByDemandNameByMonth(ReportBaseDTO baseDTO);


    /**
     * 按需方统计的开票总金额
     *
     * @param year
     * @return
     */
    List<ExportContractDTO> selectInvoiceAmountByDemandName(String year);

    /**
     * 按需方统计的发货总金额
     *
     * @param year
     * @return
     */
    List<ExportContractDTO> selectDeliveryAmountByDemandName(String year);

    /**
     * 按需方统计的发货总金额,开票总金额，生产总金额，回款总金额
     */
    List<DemandAmountDto> selectAllAmountByDemandName(ReportBaseDTO baseDTO);


    //根据产品型号获取金额数量
    List<ExportSaleDTO> selectByModel(String year);

    //获取目前合同总金额总数量
    List<ExportSaleDTO> selectAllContract(String year);

    //根据月份获取合同总金额 总数量
    List<ExportSaleDTO> selectByMonthContract(String startTime, String endTime);

    //根据产品型号合同获取金额数量
    List<ExportSaleDTO> selectByModelContract();


    //根据加工类型查询加工质量报表
    QualityEntrustReport selectByType(Integer type);

    //p喷涂质量报表
    QualitySprayReport selectSpray();

    //压力质量报表
    QualityPressureReport selectPressure();

    List<QualityPressureReport> selectPressureByReason();

    //更换料报表
    List<QualityAuditReport> selectAudit();

    /**
     * 阀门装配不合格报表
     */
    List<ReportAssemblingReasonDto> assemblingReason();

    //零件采购质量报表
    QualityInspectReport selectInspect();

    List<QualityInspectReport> selectInspectBySupplierName();

    List<QualityInspectReport> selectInspectByMaterialName();

    //成品质量报表
    QualityProductReport selectProduct();

    /**
     * 成品质量报表
     */
    QualityProductReport selectInspectByType(int type);

    /**
     * 按月统计质量质量报表
     */
    List<TotalQualityReportDto> selectAllQuality(String year);
}
