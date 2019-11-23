package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.export.ExportSaleDTO;
import com.deepsoft.haolifa.service.ExpensesService;
import com.deepsoft.haolifa.service.ReportService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Api(tags = {"报表"})
@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ExpensesService expensesService;

    @Autowired
    private ReportService reportService;


    @ApiOperation("费用每月汇总--一级部门")
    @GetMapping("/expense/classify")
    public ResultBean getcClassify() {
        return expensesService.getClassify();
    }
    @ApiOperation("费用每月汇总--部门明细")
    @GetMapping("/expense/classifyByDepartment")
    public ResultBean classifyByDepartment() {
        return expensesService.classifyByDepartment();
    }
    @ApiOperation("费用每月汇总--二级部门")
    @GetMapping("/expense/classifyBySecondDepartment")
    public ResultBean classifyBySecondDepartment() {
        return expensesService.classifyByDepartment();
    }

    @ApiOperation("费用整体分类汇总")
    @GetMapping("/expense/getAllClassify")
    public ResultBean getAllClassify() {
        return expensesService.getAllClassify();
    }
    @ApiOperation("费用整体部门汇总")
    @GetMapping("/expense/classifyByDepartmentAll")
    public ResultBean classifyByDepartmentAll() {
        return expensesService.classifyByDepartmentAll();
    }
    @ApiOperation("某个部门下面的分类统计")
    @RequestMapping(value = "/expense/getAllClassifyWithDepartment",method = RequestMethod.GET)
    public ResultBean getAllClassifyWithDepartment(@RequestParam(value ="department") String department) {
        return expensesService.getAllClassifyWithDepartment(department);
    }
    @ApiOperation("每项费用中费用二级占比")
    @RequestMapping(value = "/expense/getAllClassifyWithFirstClassify",method = RequestMethod.GET)
    public ResultBean getAllClassifyWithFirstClassify(@RequestParam(value ="classify") String classify) {
        System.out.println(classify);
        return expensesService.getAllClassifyWithFirstClassify(classify);
    }
    @ApiOperation("根据供应商查询采购报表")
    @RequestMapping(value = "/purchase/selectBySupplierName",method = RequestMethod.GET)
    public ResultBean selectBySupplierName(@RequestParam(value ="purchase") String purchase) {

        return reportService.selectBySupplierName(purchase);
    }
    @ApiOperation("采购报表")
    @RequestMapping(value = "/purchase/getPurchases",method = RequestMethod.GET)
    public ResultBean getPurchases() {

        return reportService.selectPurchase();
    }
    @ApiOperation("销售报表-目前生产总金额")
    @RequestMapping(value = "/sale/getSaleAll",method = RequestMethod.GET)
    public ResultBean getSaleAll() {

       List<ExportSaleDTO>  exportSaleDTOS = reportService.selectAll();
       return  ResultBean.success(exportSaleDTOS);
    }
    @ApiOperation("销售报表-每月生产总金额")
    @RequestMapping(value = "/sale/getSaleAllByMonth",method = RequestMethod.GET)
    public ResultBean getSaleAllByMonth(@RequestParam(value ="year") String year) {
        Calendar cal = Calendar.getInstance();
        List list = new ArrayList();
        int month = cal.get(Calendar.MONTH) + 1;
        Map map = new HashMap();
        for(int i= 1;i<month;i++){
            JsonObject jsonObject = new JsonObject();
            String startTime = "";
            String endTime = "";
            if(i<10){
                startTime = year+"-0"+i+"-26";
                int j = i+1;
                if(j<10){
                    endTime = year+"-0"+j+"-25";
                }else {
                    endTime = year+"-"+j+"-25";
                }

            }else {
                startTime = year+"-"+i+"-26";
                int j=i+1;
                endTime = year+"-"+j+"-25";
            }
            List<ExportSaleDTO>  exportSaleDTOS = reportService.selectByMonth(startTime,endTime);
            if(exportSaleDTOS != null && exportSaleDTOS.get(0)!=null){
                System.out.println(exportSaleDTOS);
                map.put(i,exportSaleDTOS);
            }
        }
        return  ResultBean.success(map);
    }

    @ApiOperation("销售报表-根据产品型号统计生产金额")
    @RequestMapping(value = "/sale/getSaleByModel",method = RequestMethod.GET)
    public ResultBean getSaleByModel() {

        List<ExportSaleDTO>  exportSaleDTOS = reportService.selectByModel();
        return  ResultBean.success(exportSaleDTOS);
    }
    @ApiOperation("销售报表-目前合同总金额")
    @RequestMapping(value = "/sale/getSaleAllContract",method = RequestMethod.GET)
    public ResultBean getSaleAllContract() {

        List<ExportSaleDTO>  exportSaleDTOS = reportService.selectAllContract();
        return  ResultBean.success(exportSaleDTOS);
    }
    @ApiOperation("销售报表-每月合同总金额")
    @RequestMapping(value = "/sale/getSaleAllByMonthContract",method = RequestMethod.GET)
    public ResultBean getSaleAllByMonthContract(@RequestParam(value ="year") String year) {
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;
        Map map = new HashMap();
        for(int i= 1;i<month;i++){
            String startTime;
            String endTime;
            if(i<10){
                startTime = year+"-0"+i+"-26";
                int j = i+1;
                if(j<10){
                    endTime = year+"-0"+j+"-25";
                }else {
                    endTime = year+"-"+j+"-25";
                }

            }else {
                startTime = year+"-"+i+"-26";
                int j=i+1;
                endTime = year+"-"+j+"-25";
            }
            List<ExportSaleDTO>  exportSaleDTOS = reportService.selectByMonthContract(startTime,endTime);
            if(exportSaleDTOS != null && exportSaleDTOS.get(0)!=null){
                System.out.println(exportSaleDTOS);
                map.put(i,exportSaleDTOS);
            }
        }
        return  ResultBean.success(map);
    }

    @ApiOperation("销售报表-根据产品型号统计合同金额")
    @RequestMapping(value = "/sale/getSaleByModelContract",method = RequestMethod.GET)
    public ResultBean getSaleByModelContract() {

        List<ExportSaleDTO>  exportSaleDTOS = reportService.selectByModelContract();
        return  ResultBean.success(exportSaleDTOS);
    }

    @ApiOperation("喷涂质量报表")
    @RequestMapping(value = "/quality/getSpray",method = RequestMethod.GET)
    public ResultBean getSpray() {

       QualitySprayReport qualitySprayReport = reportService.selectSpray();
        return  ResultBean.success(qualitySprayReport);
    }
    @ApiOperation("采购质量报表")
    @RequestMapping(value = "/quality/getInspect",method = RequestMethod.GET)
    public ResultBean getInspect() {

        QualityInspectReport qualityInspectReport = reportService.selectInspect();
        return  ResultBean.success(qualityInspectReport);
    }
    @ApiOperation("压力质量报表")
    @RequestMapping(value = "/quality/getPressure",method = RequestMethod.GET)
    public ResultBean getPressure() {

        QualityPressureReport qualityPressureReport = reportService.selectPressure();
        return  ResultBean.success(qualityPressureReport);
    }
    @ApiOperation("根据机加工类型查询 1 内部 2外部")
    @RequestMapping(value = "/expense/getEntrustt",method = RequestMethod.GET)
    public ResultBean getEntrustt(@RequestParam(value ="type") Integer type) {
        QualityEntrustReport qualityEntrustReport = reportService.selectByType(type);
        return ResultBean.success(qualityEntrustReport);
    }
    @ApiOperation("更换料质量报表")
    @RequestMapping(value = "/quality/getAudit",method = RequestMethod.GET)
    public ResultBean getAudit() {

        List<QualityAuditReport> qualityAuditReports = reportService.selectAudit();
        return  ResultBean.success(qualityAuditReports);
    }
}
