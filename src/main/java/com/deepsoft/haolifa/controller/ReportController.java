package com.deepsoft.haolifa.controller;

import cn.hutool.core.util.StrUtil;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.expenses.ExpensesConditionDTO;
import com.deepsoft.haolifa.model.dto.export.*;
import com.deepsoft.haolifa.model.dto.export.DemandAmountDto;
import com.deepsoft.haolifa.model.dto.report.ReportBaseDTO;
import com.deepsoft.haolifa.service.ExpensesService;
import com.deepsoft.haolifa.service.ReportService;
import com.deepsoft.haolifa.util.CommonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Api(tags = {"报表(2021-12-hd)"})
@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ExpensesService expensesService;

    @Autowired
    private ReportService reportService;

    @ApiOperation("费用报表--按照月份统计总的费用(2021-12-hd)")
    @GetMapping("/expense/total-by-month")
    public ResultBean expenseTotalByMonth(@RequestParam(value = "year") String year) {
        return expensesService.expenseTotalByMonth(year);
    }

    @ApiOperation("费用报表--获取一级费用分类每月的支出")
    @GetMapping("/expense/classify")
    public ResultBean getcClassify(@RequestParam(value = "expensesClassify") String expensesClassify) {
        return expensesService.getClassify(expensesClassify);
    }

    @ApiOperation("费用报表--费用每月汇总--部门明细")
    @GetMapping("/expense/classifyByDepartment")
    public ResultBean classifyByDepartment() {
        return expensesService.classifyByDepartment();
    }

    @ApiOperation("费用报表--费用每月汇总--二级部门")
    @GetMapping("/expense/classifyBySecondDepartment")
    public ResultBean classifyBySecondDepartment() {
        return expensesService.classifyByDepartment();
    }

    @ApiOperation("费用报表--费用整体分类汇总（2021-12-hd）")
    @PostMapping("/expense/getAllClassify")
    public ResultBean<List<ExpensesReport>> getAllClassify(@RequestBody ExpensesConditionDTO reportBaseDTO) {
        return expensesService.getAllClassify(reportBaseDTO);
    }

    @ApiOperation("费用报表--费用整体部门汇总（2021-12-hd）")
    @PostMapping("/expense/classifyByDepartmentAll")
    public ResultBean<List<ExpensesReport>> classifyByDepartmentAll(@RequestBody ExpensesConditionDTO reportBaseDTO){
        return expensesService.classifyByDepartmentAll(reportBaseDTO);
    }

    @ApiOperation("费用报表--某个部门下面的分类统计（2021-12-hd）")
    @PostMapping(value = "/expense/getAllClassifyWithDepartment")
    public ResultBean<List<ExpensesReport>> getAllClassifyWithDepartment(@RequestBody ExpensesConditionDTO reportBaseDTO) {
        return expensesService.getAllClassifyWithDepartment(reportBaseDTO);
    }

    @ApiOperation("费用报表--获取一级部门下面每月的支出")
    @RequestMapping(value = "/expense/getMonthByDepartment", method = RequestMethod.GET)
    public ResultBean getMonthByDepartment(@RequestParam(value = "department") String department) {
        return expensesService.getMonthByDepartment(department);
    }

    @ApiOperation("费用报表--每项费用中费用二级占比")
    @RequestMapping(value = "/expense/getAllClassifyWithFirstClassify", method = RequestMethod.GET)
    public ResultBean getAllClassifyWithFirstClassify(@RequestParam(value = "classify") String classify) {
        return expensesService.getAllClassifyWithFirstClassify(classify);
    }

    @ApiOperation("采购报表--根据供应商查询采购报表")
    @RequestMapping(value = "/purchase/selectBySupplierName", method = RequestMethod.GET)
    public ResultBean selectBySupplierName(@RequestParam(value = "purchase") String purchase,
                                           @RequestParam(value = "year", required = false) String year) {

        return reportService.selectBySupplierName(purchase, year);
    }

    @ApiOperation("采购报表")
    @RequestMapping(value = "/purchase/getPurchases", method = RequestMethod.GET)
    public ResultBean getPurchases(@RequestParam(value = "year", required = false) String year, @RequestParam(value = "month", required = false) String month) {

        return reportService.selectPurchase(year, month);
    }

    @ApiOperation("采购报表--按月查询采购物资")
    @RequestMapping(value = "/purchase/getAllPurchase", method = RequestMethod.GET)
    public ResultBean getAllPurchase(@RequestParam(value = "year", required = false) String year) {

        return reportService.selectAllPurchase(year);
    }

    @ApiOperation("销售报表-目前生产总金额")
    @RequestMapping(value = "/sale/getSaleAll", method = RequestMethod.GET)
    public ResultBean getSaleAll(@RequestParam(value = "year", required = false) String year) {

        List<ExportSaleDTO> exportSaleDTOS = reportService.selectAll(year);
        return ResultBean.success(exportSaleDTOS);
    }

    @ApiOperation("销售报表-每月生产总金额")
    @RequestMapping(value = "/sale/getSaleAllByMonth", method = RequestMethod.GET)
    public ResultBean getSaleAllByMonth(@RequestParam(value = "year") String year) {
        Calendar cal = Calendar.getInstance();
        List list = new ArrayList();
        int month = 12;
        int yearNow = cal.get(Calendar.YEAR);
        if (yearNow == Integer.parseInt(year)) {
            month = cal.get(Calendar.MONTH) + 1;
        }
        Map map = new HashMap();
        for (int i = 1; i <= month; i++) {
            String startTime = "";
            String endTime = "";
            if (i == 1) {
                startTime = Integer.parseInt(year) - 1 + "-12-26";
            } else {
                startTime = year + "-" + (i - 1) + "-26";
            }
            endTime = year + "-" + i + "-25";
//            if (i < 10) {
//                startTime = year + "-0" + i + "-26";
//                int j = i + 1;
//                if (j < 10) {
//                    endTime = year + "-0" + j + "-25";
//                } else {
//                    endTime = year + "-" + j + "-25";
//                }
//
//            } else {
//                startTime = year + "-" + i + "-26";
//                int j = i + 1;
//                endTime = year + "-" + j + "-25";
//            }
            String totalPrice = reportService.selectByMonth(startTime, endTime);
            if (StrUtil.isNotBlank(totalPrice)) {
                map.put(i, totalPrice);
            }
        }
        return ResultBean.success(map);
    }

    @ApiOperation("销售报表-根据产品型号统计生产金额")
    @RequestMapping(value = "/sale/getSaleByModel", method = RequestMethod.GET)
    public ResultBean getSaleByModel(@RequestParam(value = "year", required = false) String year) {

        List<ExportSaleDTO> exportSaleDTOS = reportService.selectByModel(year);
        return ResultBean.success(exportSaleDTOS);
    }

    @ApiOperation("销售报表-目前合同总金额")
    @RequestMapping(value = "/sale/getSaleAllContract", method = RequestMethod.GET)
    public ResultBean getSaleAllContract(@RequestParam(value = "year", required = false) String year) {

        List<ExportSaleDTO> exportSaleDTOS = reportService.selectAllContract(year);
        return ResultBean.success(exportSaleDTOS);
    }

    @ApiOperation("销售报表-每月合同总金额")
    @RequestMapping(value = "/sale/getSaleAllByMonthContract", method = RequestMethod.GET)
    public ResultBean getSaleAllByMonthContract(@RequestParam(value = "year", required = false) String year) {
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;
        Map map = new HashMap();
        for (int i = 1; i < month; i++) {
            String startTime;
            String endTime;
            if (i < 10) {
                startTime = year + "-0" + i + "-26";
                int j = i + 1;
                if (j < 10) {
                    endTime = year + "-0" + j + "-25";
                } else {
                    endTime = year + "-" + j + "-25";
                }

            } else {
                startTime = year + "-" + i + "-26";
                int j = i + 1;
                endTime = year + "-" + j + "-25";
            }
            List<ExportSaleDTO> exportSaleDTOS = reportService.selectByMonthContract(startTime, endTime);
            if (exportSaleDTOS != null && exportSaleDTOS.get(0) != null) {
                System.out.println(exportSaleDTOS);
                map.put(i, exportSaleDTOS);
            }
        }
        return ResultBean.success(map);
    }

    @ApiOperation("销售报表-根据产品型号统计合同金额")
    @RequestMapping(value = "/sale/getSaleByModelContract", method = RequestMethod.GET)
    public ResultBean getSaleByModelContract() {

        List<ExportSaleDTO> exportSaleDTOS = reportService.selectByModelContract();
        return ResultBean.success(exportSaleDTOS);
    }


    @ApiOperation("销售报表-年度客户总额分类统计图(2021-12-hd)")
    @GetMapping(value = "/sale/selectContractByDemandName")
    public ResultBean selectContractByDemandName(@RequestParam(value = "year") String year) {
        return ResultBean.success(reportService.selectContractByDemandName(year));
    }
    @ApiOperation("销售报表-月份客户订货额统计图(2021-12-hd)")
    @PostMapping(value = "/sale/selectContractByDemandNameByMonth")
    public ResultBean<List<ExportContractDTO>> selectContractByDemandNameByMonth(@RequestBody ReportBaseDTO baseDTO) {
        return ResultBean.success(reportService.selectContractByDemandNameByMonth(baseDTO));
    }


    @ApiOperation("销售报表-年度回款总额分类统计图(2021-12-hd)")
    @GetMapping(value = "/sale/selectshouhuiContractByDemandName")
    public ResultBean selectshouhuiContractByDemandName(@RequestParam(value = "year", required = false) String year) {
        return ResultBean.success(reportService.selectshouhuiContractByDemandName(year));
    }
    @ApiOperation("销售报表-月份回款额统计图(2021-12-hd)")
    @PostMapping(value = "/sale/selectshouhuiContractByDemandNameByMonth")
    public ResultBean<List<ExportContractDTO>> selectshouhuiContractByDemandNameByMonth(@RequestBody ReportBaseDTO baseDTO) {
        return ResultBean.success(reportService.selectshouhuiContractByDemandNameByMonth(baseDTO));
    }


    @ApiOperation("销售报表-按需方统计的开票总金额")
    @GetMapping(value = "/sale/selectInvoiceAmountByDemandName")
    public ResultBean selectInvoiceAmountByDemandName(@RequestParam(value = "year", required = false) String year) {
        List<ExportContractDTO> exportSaleDTOS = reportService.selectInvoiceAmountByDemandName(year);
        return ResultBean.success(exportSaleDTOS);
    }

    @ApiOperation("销售报表-按需方统计的发货总金额")
    @GetMapping(value = "/sale/selectDeliveryAmountByDemandName")
    public ResultBean selectDeliveryAmountByDemandName(@RequestParam(value = "year", required = false) String year) {
        List<ExportContractDTO> exportSaleDTOS = reportService.selectDeliveryAmountByDemandName(year);
        return ResultBean.success(exportSaleDTOS);
    }

    @ApiOperation("销售报表-按需方统计的发货总金额,开票总金额,回款总额,销售总金额（2021-12-hd）")
    @PostMapping(value = "/sale/selectAllAmountByDemandName")
    public ResultBean<List<DemandAmountDto>> selectAllAmountByDemandName(@RequestBody ReportBaseDTO baseDTO) {
        return ResultBean.success(reportService.selectAllAmountByDemandName(baseDTO));
    }

    @ApiOperation("质量报表-喷涂")
    @RequestMapping(value = "/quality/getSpray", method = RequestMethod.GET)
    public ResultBean getSpray() {

        QualitySprayReport qualitySprayReport = reportService.selectSpray();
        return ResultBean.success(qualitySprayReport);
    }

    @ApiOperation("质量报表-采购")
    @RequestMapping(value = "/quality/getInspect", method = RequestMethod.GET)
    public ResultBean getInspect() {

        QualityInspectReport qualityInspectReport = reportService.selectInspect();
        return ResultBean.success(qualityInspectReport);
    }

    @ApiOperation("质量报表-采购,不同供应商的数据对比")
    @RequestMapping(value = "/quality/getInspectBysupplierName", method = RequestMethod.GET)
    public ResultBean getInspectBysupplierName() {

        List<QualityInspectReport> qualityInspectReport = reportService.selectInspectBySupplierName();
        return ResultBean.success(qualityInspectReport);
    }

    @ApiOperation("质量报表-采购,不同类型零件的数据对比")
    @RequestMapping(value = "/quality/selectInspectByMaterialName", method = RequestMethod.GET)
    public ResultBean selectInspectByMaterialName() {

        List<QualityInspectReport> qualityInspectReport = reportService.selectInspectByMaterialName();
        return ResultBean.success(qualityInspectReport);
    }

    @ApiOperation("质量报表-压力质量报表")
    @RequestMapping(value = "/quality/getPressure", method = RequestMethod.GET)
    public ResultBean getPressure() {

        QualityPressureReport qualityPressureReport = reportService.selectPressure();
        return ResultBean.success(qualityPressureReport);
    }

    @ApiOperation("质量报表-压力--根据不同原因统计")
    @RequestMapping(value = "/quality/selectPressureByReason", method = RequestMethod.GET)
    public ResultBean selectPressureByReason() {

        List<QualityPressureReport> qualityPressureReport = reportService.selectPressureByReason();
        return ResultBean.success(qualityPressureReport);
    }

    @ApiOperation("机加工质量报表根据机加工类型查询 1 内部 ")
    @RequestMapping(value = "/quality/getEntrust", method = RequestMethod.GET)
    public ResultBean getEntrust(@RequestParam(value = "type") Integer type) {
        QualityEntrustReport qualityEntrustReport = reportService.selectByType(type);
        return ResultBean.success(qualityEntrustReport);
    }

    @ApiOperation("质量报表-更换料质量报表")
    @RequestMapping(value = "/quality/getAudit", method = RequestMethod.GET)
    public ResultBean getAudit() {

        List<QualityAuditReport> qualityAuditReports = reportService.selectAudit();
        return ResultBean.success(qualityAuditReports);
    }

    @ApiOperation("质量报表-成品检验质量报表")
    @RequestMapping(value = "/quality/getProduct", method = RequestMethod.GET)
    public ResultBean getProduct() {

        QualityProductReport qualityProductReport = reportService.selectProduct();
        return ResultBean.success(qualityProductReport);
    }

    @ApiOperation("质量报表-机加工/报检 质量报表")
    @ApiImplicitParam(required = true, value = "1 采购零件送检  2 机加工", name = "type", dataType = "int", paramType = "query")
    @GetMapping(value = "/quality/getInspectByType")
    public ResultBean getInspectByType(@RequestParam(value = "type") Integer type) {

        QualityProductReport qualityProductReport = reportService.selectProduct();
        return ResultBean.success(qualityProductReport);
    }


    @ApiOperation("质量报表-阀门装配不合格原因")
    @RequestMapping(value = "/quality/assemblingReason", method = RequestMethod.GET)
    public ResultBean assemblingReason() {
        List<ReportAssemblingReasonDto> result = reportService.assemblingReason();
        return ResultBean.success(result);
    }

    @ApiOperation("质量报表-质量统计")
    @RequestMapping(value = "/quality/getAllQuality", method = RequestMethod.GET)
    public ResultBean getAllQuality(@RequestParam(value = "year", required = false) String year) {
        List<TotalQualityReportDto> totalQualityReportDtos = reportService.selectAllQuality(year);
        return ResultBean.success(totalQualityReportDtos);
    }


}
