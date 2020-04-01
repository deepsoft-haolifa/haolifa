package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.export.DemandAmountDto;
import com.deepsoft.haolifa.model.dto.export.ExportContractDTO;
import com.deepsoft.haolifa.model.dto.export.ExportSaleDTO;
import com.deepsoft.haolifa.model.dto.export.DemandAmountDto;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReportService {

    //获取采购合同报表
    ResultBean selectBySupplierName(String purchase,String year);

    /**
     * 采购报表--采购统计
     * @return
     */
    ResultBean selectPurchase(String year);

    //销售报表
    //获取目前总金额总数量
    List<ExportSaleDTO> selectAll(String year);

    //根据月份获取总金额 总数量
    List<ExportSaleDTO> selectByMonth(String startTime, String endTime);

    List<ExportContractDTO> selectContractByDemandName(String year);

    List<ExportContractDTO> selectshouhuiContractByDemandName(String year);

    /**
     * 按需方统计的开票总金额
     * @param year
     * @return
     */
    List<ExportContractDTO> selectInvoiceAmountByDemandName(String year);
    /**
     * 按需方统计的发货总金额
     * @param year
     * @return
     */
    List<ExportContractDTO> selectDeliveryAmountByDemandName(String year);

    /**
     * 按需方统计的发货总金额,开票总金额，生产总金额，回款总金额
     */
    List<DemandAmountDto> selectAllAmountByDemandName(@Param("year") String year);


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

    //零件采购质量报表
    QualityInspectReport selectInspect();

    List<QualityInspectReport> selectInspectBySupplierName();

    List<QualityInspectReport> selectInspectByMaterialName();

    //成品质量报表
    QualityProductReport selectProduct();

}
