package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.constant.Constant;
import com.deepsoft.haolifa.dao.repository.AutoControlMaterialMapper;
import com.deepsoft.haolifa.dao.repository.extend.AutoControlMaterialExtendMapper;
import com.deepsoft.haolifa.model.domain.AutoControlMaterial;
import com.deepsoft.haolifa.model.domain.AutoControlMaterialExample;
import com.deepsoft.haolifa.model.dto.ResultBean;

import com.deepsoft.haolifa.model.dto.autoControl.AutoControlEntryOutDto;
import com.deepsoft.haolifa.model.dto.autoControl.AutoControlEntryOutPage;
import com.deepsoft.haolifa.model.dto.autoControl.AutoControlEntryOutRecordRespVo;
import com.deepsoft.haolifa.model.dto.autoControl.AutoControlMaterialPageDto;
import com.deepsoft.haolifa.service.AutoControlMaterialService;
import com.deepsoft.haolifa.util.DateFormatterUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author murphy.he
 **/
@Api(tags = "自控物资管理")
@RequestMapping("auto-control")
@RestController
public class AutoControlMaterialController {

    @Autowired
    private AutoControlMaterialService autoControlMaterialService;

    @Autowired
    private AutoControlMaterialMapper autoControlMaterialMapper;
    @Autowired
    private AutoControlMaterialExtendMapper autoControlMaterialExtendMapper;

    @PostMapping("/add")
    @ApiOperation("添加")
    public ResultBean add(@RequestBody AutoControlMaterial autoControlMaterial) {
        int add = autoControlMaterialService.add(autoControlMaterial);
        if (add > 0) {
            return ResultBean.success(add);
        } else {
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }

    @PostMapping("/update")
    @ApiOperation("更新")
    public ResultBean update(@RequestBody AutoControlMaterial autoControlMaterial) {
        int update = autoControlMaterialService.update(autoControlMaterial);
        if (update > 0) {
            return ResultBean.success(update);
        } else {
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }

    @PostMapping("/del/{id}")
    @ApiOperation("删除")
    public ResultBean del(@PathVariable Integer id) {
        int del = autoControlMaterialService.del(id);
        if (del > 0) {
            return ResultBean.success(del);
        } else {
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }

    @PostMapping("/page")
    @ApiOperation("自控物资分页列表")
    public ResultBean<AutoControlMaterial> pageList(@RequestBody AutoControlMaterialPageDto autoControlMaterial) {
        return ResultBean.success(autoControlMaterialService.pageList(autoControlMaterial));
    }

    @PostMapping("/entry")
    @ApiOperation("自控物资入库")
    public ResultBean entry(@RequestBody AutoControlEntryOutDto entryOutDto) {
        int update = autoControlMaterialService.entry(entryOutDto);
        if (update > 0) {
            return ResultBean.success(update);
        } else {
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }

    @PostMapping("/out")
    @ApiOperation("自控物资出库")
    public ResultBean out(@RequestBody AutoControlEntryOutDto entryOutDto) {
        int update = autoControlMaterialService.out(entryOutDto);
        if (update > 0) {
            return ResultBean.success(update);
        } else {
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }

    @PostMapping("/entry-out-page-list")
    @ApiOperation("自控物资 出库/入库详情")
    public ResultBean entryOutPageList(@RequestBody AutoControlEntryOutPage page) {
        return ResultBean.success(autoControlMaterialService.entryOutPage(page));
    }

    @ApiOperation("导出自控物资入库记录")
    @GetMapping("material-entry-record")
    public void exportMaterialEntryRoom(HttpServletResponse response, HttpServletRequest request,
                                        AutoControlEntryOutPage dto) throws IOException {


        // 类型为 入库
        dto.setType(CommonEnum.OperationType.ENTRY.code);
        dto.setPageNum(1);
        dto.setPageSize(Constant.EXPORT_MAX_COUNT);

        Page<AutoControlEntryOutRecordRespVo> page = PageHelper.startPage(dto.getPageNum(), dto.getPageSize())
            .doSelectPage(() -> autoControlMaterialExtendMapper.pageRecord(dto));
        List<AutoControlEntryOutRecordRespVo> result = page.getResult();
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("自控物资入库记录", "utf-8") + ".xls");
        response.setContentType("application/octet-stream;");
        Workbook workbook = new HSSFWorkbook();
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setWrapText(true);
        Sheet sheet = workbook.createSheet("自控物资入库记录");
        // 单元格样式
        CellStyle center = workbook.createCellStyle();
        center.setAlignment(HorizontalAlignment.CENTER);

        Row title_1 = sheet.createRow(0);
        CellRangeAddress cra1 = new CellRangeAddress(0, 0, 0, 6);
        sheet.addMergedRegion(cra1);
        Cell cell_title_1 = title_1.createCell(0);
        cell_title_1.setCellValue("自 控 物 料 入 库 记 录");
        cell_title_1.setCellStyle(center);

        Row columnTitle = sheet.createRow(1);
        Cell cell_10 = columnTitle.createCell(0);
        cell_10.setCellValue("序号");
        cell_10.setCellStyle(center);
        Cell cell_11 = columnTitle.createCell(1);
        cell_11.setCellValue("分类名称");
        cell_11.setCellStyle(center);
        Cell cell_12 = columnTitle.createCell(2);
        cell_12.setCellValue("零件名称");
        cell_12.setCellStyle(center);
        Cell cell_13 = columnTitle.createCell(3);
        cell_13.setCellValue("规格");
        cell_13.setCellStyle(center);
        Cell cell_14 = columnTitle.createCell(4);
        cell_14.setCellValue("型号");
        cell_14.setCellStyle(center);
        Cell cell_15 = columnTitle.createCell(5);
        cell_15.setCellValue("入库数量");
        cell_15.setCellStyle(center);
        Cell cell_16 = columnTitle.createCell(6);
        cell_16.setCellValue("入库时间");
        cell_16.setCellStyle(center);
        Cell cell_17 = columnTitle.createCell(7);
        cell_17.setCellValue("单价");
        cell_17.setCellStyle(center);
        Cell cell_18 = columnTitle.createCell(8);
        cell_18.setCellValue("金额");
        cell_18.setCellStyle(center);
        for (int i = 0; i < result.size(); i++) {
            AutoControlEntryOutRecordRespVo record = result.get(i);
            Row row_value = sheet.createRow(i + 2);
            Cell cell_0 = row_value.createCell(0);
            cell_0.setCellValue(i + 1);
            cell_0.setCellStyle(center);
            Cell cell_1 = row_value.createCell(1);
            cell_1.setCellValue(record.getClassifyName());
            cell_1.setCellStyle(center);
            Cell cell_2 = row_value.createCell(2);
            cell_2.setCellValue(record.getMaterialName());
            cell_2.setCellStyle(center);
            Cell cell_3 = row_value.createCell(3);
            cell_3.setCellValue(record.getSpecifications());
            cell_3.setCellStyle(center);
            Cell cell_4 = row_value.createCell(4);
            cell_4.setCellValue(record.getModel());
            cell_4.setCellStyle(center);
            Cell cell_5 = row_value.createCell(5);
            cell_5.setCellValue(record.getQuantity());
            cell_5.setCellStyle(center);
            Cell cell_6 = row_value.createCell(6);
            cell_6.setCellValue(DateFormatterUtils.formatterDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, record.getUpdateTime()));
            cell_6.setCellStyle(center);
            Cell cell_7 = row_value.createCell(7);
            cell_7.setCellValue(record.getPrice().doubleValue());
            cell_7.setCellStyle(center);
            Cell cell_8 = row_value.createCell(8);
            BigDecimal totalAmount = record.getPrice().multiply(new BigDecimal(record.getQuantity()));
            cell_8.setCellValue(totalAmount.doubleValue());
            cell_8.setCellStyle(center);
            Cell cell_9 = row_value.createCell(9);
            cell_9.setCellValue(record.getReceiveDepartment());
            cell_9.setCellStyle(center);
        }
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }


    @ApiOperation("导出自控物资出库记录")
    @GetMapping("/material-out-record")
    public void materialRecord(HttpServletResponse response, HttpServletRequest request,
                               AutoControlEntryOutPage dto) throws IOException {

        // 类型为 入库
        dto.setType(CommonEnum.OperationType.OUT.code);
        dto.setPageNum(1);
        dto.setPageSize(Constant.EXPORT_MAX_COUNT);

        Page<AutoControlEntryOutRecordRespVo> page = PageHelper.startPage(dto.getPageNum(), dto.getPageSize())
            .doSelectPage(() -> autoControlMaterialExtendMapper.pageRecord(dto));
        List<AutoControlEntryOutRecordRespVo> result = page.getResult();
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("自控物资出库记录", "utf-8") + ".xls");
        response.setContentType("application/octet-stream;");
        Workbook workbook = new HSSFWorkbook();
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setWrapText(true);
        Sheet sheet = workbook.createSheet("自控物资出库记录");
        // 单元格样式
        CellStyle center = workbook.createCellStyle();
        center.setAlignment(HorizontalAlignment.CENTER);

        Row title_1 = sheet.createRow(0);
        CellRangeAddress cra1 = new CellRangeAddress(0, 0, 0, 6);
        sheet.addMergedRegion(cra1);
        Cell cell_title_1 = title_1.createCell(0);
        cell_title_1.setCellValue("自 控 物 料 出 库 记 录");
        cell_title_1.setCellStyle(center);

        Row columnTitle = sheet.createRow(1);
        Cell cell_10 = columnTitle.createCell(0);
        cell_10.setCellValue("序号");
        cell_10.setCellStyle(center);
        Cell cell_11 = columnTitle.createCell(1);
        cell_11.setCellValue("分类名称");
        cell_11.setCellStyle(center);
        Cell cell_12 = columnTitle.createCell(2);
        cell_12.setCellValue("零件名称");
        cell_12.setCellStyle(center);
        Cell cell_13 = columnTitle.createCell(3);
        cell_13.setCellValue("规格");
        cell_13.setCellStyle(center);
        Cell cell_14 = columnTitle.createCell(4);
        cell_14.setCellValue("型号");
        cell_14.setCellStyle(center);
        Cell cell_15 = columnTitle.createCell(5);
        cell_15.setCellValue("出库数量");
        cell_15.setCellStyle(center);
        Cell cell_16 = columnTitle.createCell(6);
        cell_16.setCellValue("出库时间");
        cell_16.setCellStyle(center);
        Cell cell_17 = columnTitle.createCell(7);
        cell_17.setCellValue("单价");
        cell_17.setCellStyle(center);
        Cell cell_18 = columnTitle.createCell(8);
        cell_18.setCellValue("金额");
        cell_18.setCellStyle(center);
        Cell cell_19 = columnTitle.createCell(9);
        cell_19.setCellValue("领料部门");
        cell_19.setCellStyle(center);
        for (int i = 0; i < result.size(); i++) {
            AutoControlEntryOutRecordRespVo record = result.get(i);
            Row row_value = sheet.createRow(i + 2);
            Cell cell_0 = row_value.createCell(0);
            cell_0.setCellValue(i + 1);
            cell_0.setCellStyle(center);
            Cell cell_1 = row_value.createCell(1);
            cell_1.setCellValue(record.getClassifyName());
            cell_1.setCellStyle(center);
            Cell cell_2 = row_value.createCell(2);
            cell_2.setCellValue(record.getMaterialName());
            cell_2.setCellStyle(center);
            Cell cell_3 = row_value.createCell(3);
            cell_3.setCellValue(record.getSpecifications());
            cell_3.setCellStyle(center);
            Cell cell_4 = row_value.createCell(4);
            cell_4.setCellValue(record.getModel());
            cell_4.setCellStyle(center);
            Cell cell_5 = row_value.createCell(5);
            cell_5.setCellValue(record.getQuantity());
            cell_5.setCellStyle(center);
            Cell cell_6 = row_value.createCell(6);
            cell_6.setCellValue(DateFormatterUtils.formatterDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, record.getUpdateTime()));
            cell_6.setCellStyle(center);
            Cell cell_7 = row_value.createCell(7);
            cell_7.setCellValue(record.getPrice().doubleValue());
            cell_7.setCellStyle(center);
            Cell cell_8 = row_value.createCell(8);
            BigDecimal totalAmount = record.getPrice().multiply(new BigDecimal(record.getQuantity()));
            cell_8.setCellValue(totalAmount.doubleValue());
            cell_8.setCellStyle(center);
            Cell cell_9 = row_value.createCell(9);
            cell_9.setCellValue(record.getReceiveDepartment());
            cell_9.setCellStyle(center);
        }
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();

    }


    @ApiOperation("导出自控物资结存数据")
    @GetMapping("/material/surplus")
    public void materialSurplus(HttpServletResponse response, HttpServletRequest request)
        throws IOException {
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("自控物资结存明细", "utf-8") + ".xls");
        response.setContentType("application/octet-stream;");
        Workbook workbook = new HSSFWorkbook();
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setWrapText(true);
        Sheet sheet = workbook.createSheet("自控物资结存明细");
        // 单元格样式
        CellStyle center = workbook.createCellStyle();
        center.setAlignment(HorizontalAlignment.CENTER);
        center.setVerticalAlignment(VerticalAlignment.CENTER);
        center.setWrapText(true);

        Row title_1 = sheet.createRow(0);
        CellRangeAddress cra1 = new CellRangeAddress(0, 0, 0, 8);
        sheet.addMergedRegion(cra1);
        Cell cell_title_1 = title_1.createCell(0);
        cell_title_1.setCellValue("自 控 物 资 结 存 明 细");
        cell_title_1.setCellStyle(center);

        Row columnTitle = sheet.createRow(1);
        Cell cell_10 = columnTitle.createCell(0);
        cell_10.setCellValue("序号");
        cell_10.setCellStyle(center);
        Cell cell_11 = columnTitle.createCell(1);
        cell_11.setCellValue("分类名称");
        cell_11.setCellStyle(center);
        Cell cell_12 = columnTitle.createCell(2);
        cell_12.setCellValue("零件名称");
        cell_12.setCellStyle(center);
        Cell cell_13 = columnTitle.createCell(3);
        cell_13.setCellValue("规格");
        cell_13.setCellStyle(center);
        Cell cell_14 = columnTitle.createCell(4);
        cell_14.setCellValue("型号");
        cell_14.setCellStyle(center);
        Cell cell_15 = columnTitle.createCell(5);
        cell_15.setCellValue("单位");
        cell_15.setCellStyle(center);
        Cell cell_16 = columnTitle.createCell(6);
        cell_16.setCellValue("库存数量");
        cell_16.setCellStyle(center);
        Cell cell_17 = columnTitle.createCell(7);
        cell_17.setCellValue("单价");
        cell_17.setCellStyle(center);
        Cell cell_18 = columnTitle.createCell(8);
        cell_18.setCellValue("金额");
        cell_18.setCellStyle(center);

        List<AutoControlMaterial> materials = autoControlMaterialMapper.selectByExample(new AutoControlMaterialExample());
        for (int i = 0; i < materials.size(); i++) {
            AutoControlMaterial material = materials.get(i);
            Row row_value = sheet.createRow(i + 2);
            Cell cell_0 = row_value.createCell(0);
            cell_0.setCellValue(i + 1);
            cell_0.setCellStyle(center);
            Cell cell_1 = row_value.createCell(1);
            cell_1.setCellValue(material.getClassifyName());
            cell_1.setCellStyle(center);
            Cell cell_2 = row_value.createCell(2);
            cell_2.setCellValue(material.getMaterialName());
            cell_2.setCellStyle(center);
            Cell cell_3 = row_value.createCell(3);
            cell_3.setCellValue(material.getSpecifications());
            cell_3.setCellStyle(center);
            Cell cell_4 = row_value.createCell(4);
            cell_4.setCellValue(material.getModel());
            cell_4.setCellStyle(center);
            Cell cell_5 = row_value.createCell(5);
            cell_5.setCellValue(material.getUnit());
            cell_5.setCellStyle(center);
            Cell cell_6 = row_value.createCell(6);
            cell_6.setCellValue(material.getQuantity());
            cell_6.setCellStyle(center);
            Cell cell_7 = row_value.createCell(7);
            cell_7.setCellValue(String.valueOf(material.getPrice()));
            cell_7.setCellStyle(center);
            BigDecimal amount = material.getPrice().multiply(new BigDecimal(material.getQuantity())).setScale(2, BigDecimal.ROUND_HALF_UP);
            Cell cell_8 = row_value.createCell(8);
            cell_8.setCellValue(String.valueOf(amount));
            cell_8.setCellStyle(center);
        }

        sheet.autoSizeColumn(1, true);
        sheet.autoSizeColumn(2, true);

        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }


}
