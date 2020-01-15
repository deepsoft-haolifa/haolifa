package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.SporadicEntryOutRecordMapper;
import com.deepsoft.haolifa.dao.repository.SporadicMaterialMapper;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.export.ExportMaterialEntryRoomDTO;
import com.deepsoft.haolifa.model.dto.export.ExportMaterialRecordDTO;
import com.deepsoft.haolifa.model.dto.sporadic.SporadicEntryOutDto;
import com.deepsoft.haolifa.model.dto.sporadic.SporadicEntryOutPage;
import com.deepsoft.haolifa.model.dto.sporadic.SporadicExportDto;
import com.deepsoft.haolifa.model.dto.sporadic.SporadicMaterialPageDto;
import com.deepsoft.haolifa.service.SporadicMaterialService;
import com.deepsoft.haolifa.util.DateFormatterUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
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
import java.util.Date;
import java.util.List;

import static com.deepsoft.haolifa.constant.CommonEnum.StorageType.MATERIAL;

/**
 * @author murphy.he
 **/
@Api(tags = "零星物资管理")
@RequestMapping("sporadic")
@RestController
public class SporadicMaterialController {

    @Autowired
    private SporadicMaterialService sporadicMaterialService;

    @Autowired
    private SporadicMaterialMapper sporadicMaterialMapper;
    @Autowired
    private SporadicEntryOutRecordMapper sporadicEntryOutRecordMapper;

    @PostMapping("/add")
    @ApiOperation("添加")
    public ResultBean add(@RequestBody SporadicMaterial sporadicMaterial) {
        int add = sporadicMaterialService.add(sporadicMaterial);
        if (add > 0) {
            return ResultBean.success(add);
        } else {
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }

    @PostMapping("/update")
    @ApiOperation("更新")
    public ResultBean update(@RequestBody SporadicMaterial sporadicMaterial) {
        int update = sporadicMaterialService.update(sporadicMaterial);
        if (update > 0) {
            return ResultBean.success(update);
        } else {
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }

    @PostMapping("/page")
    @ApiOperation("零星物料分页列表")
    public ResultBean<SporadicMaterial> pageList(@RequestBody SporadicMaterialPageDto sporadicMaterial) {
        return ResultBean.success(sporadicMaterialService.pageList(sporadicMaterial));
    }

    @PostMapping("/entry")
    @ApiOperation("零星物料入库")
    public ResultBean entry(@RequestBody SporadicEntryOutDto entryOutDto) {
        int update = sporadicMaterialService.entry(entryOutDto);
        if (update > 0) {
            return ResultBean.success(update);
        } else {
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }

    @PostMapping("/out")
    @ApiOperation("零星物料出库")
    public ResultBean out(@RequestBody SporadicEntryOutDto entryOutDto) {
        int update = sporadicMaterialService.out(entryOutDto);
        if (update > 0) {
            return ResultBean.success(update);
        } else {
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }

    @PostMapping("/entry-out-page-list")
    @ApiOperation("零星物料 出库/入库详情")
    public ResultBean entryOutPageList(@RequestBody SporadicEntryOutPage page) {
        return ResultBean.success(sporadicMaterialService.entryOutPage(page));
    }

    @ApiOperation("导出零星零件入库记录")
    @GetMapping("material-entry-record")
    public void exportMaterialEntryRoom(HttpServletResponse response, HttpServletRequest request,
                                        SporadicExportDto dto) throws IOException {
        SporadicEntryOutRecordExample example = new SporadicEntryOutRecordExample();
        SporadicEntryOutRecordExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(dto.getStartDate())) {
            Date startDate = DateFormatterUtils.parseDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, dto.getStartDate());
            criteria.andUpdateTimeGreaterThanOrEqualTo(startDate);
        }
        if (StringUtils.isNotEmpty(dto.getEndDate())) {
            Date endDate = DateFormatterUtils.parseDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, dto.getEndDate());
            criteria.andUpdateTimeLessThanOrEqualTo(endDate);
        }
        // 类型为 入库
        criteria.andTypeEqualTo(CommonEnum.OperationType.ENTRY.code);

        List<SporadicEntryOutRecord> sporadicEntryOutRecords = sporadicEntryOutRecordMapper.selectByExample(example);

        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("零星零件入库记录", "utf-8") + ".xls");
        response.setContentType("application/octet-stream;");
        Workbook workbook = new HSSFWorkbook();
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setWrapText(true);
        Sheet sheet = workbook.createSheet("零星零件入库记录");
        // 单元格样式
        CellStyle center = workbook.createCellStyle();
        center.setAlignment(HorizontalAlignment.CENTER);

        Row title_1 = sheet.createRow(0);
        CellRangeAddress cra1 = new CellRangeAddress(0, 0, 0, 9);
        sheet.addMergedRegion(cra1);
        Cell cell_title_1 = title_1.createCell(0);
        cell_title_1.setCellValue("零 星 零 件 入 库 记 录");
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
        cell_17.setCellValue("物料图号");
        cell_17.setCellStyle(center);
        Cell cell_18 = columnTitle.createCell(8);
        cell_18.setCellValue("入库数量");
        cell_18.setCellStyle(center);
        Cell cell_19 = columnTitle.createCell(9);
        cell_19.setCellValue("入库日期");
        cell_19.setCellStyle(center);
        for (int i = 0; i < sporadicEntryOutRecords.size(); i++) {
            SporadicEntryOutRecord record = sporadicEntryOutRecords.get(i);
            Row row_value = sheet.createRow(i + 2);
            Cell cell_0 = row_value.createCell(0);
            cell_0.setCellValue(i + 1);
            cell_0.setCellStyle(center);
            Cell cell_1 = row_value.createCell(1);
            cell_1.setCellValue(record.getInspectNo());
            cell_1.setCellStyle(center);
            Cell cell_2 = row_value.createCell(2);
            cell_2.setCellValue(inspectHistory.getPurchaseNo());
            cell_2.setCellStyle(center);
            Cell cell_3 = row_value.createCell(3);
            cell_3.setCellValue(inspectHistory.getBatchNumber());
            cell_3.setCellStyle(center);
            Cell cell_4 = row_value.createCell(4);
            cell_4.setCellValue(inspectHistory.getType() == 1 ? "采购零件" : "机加工零件");
            cell_4.setCellStyle(center);
            Cell cell_5 = row_value.createCell(5);
            cell_5.setCellValue(inspectHistory.getSupplierName());
            cell_5.setCellStyle(center);
            Cell cell_6 = row_value.createCell(6);
            cell_6.setCellValue(inspectHistory.getMaterialGraphName());
            cell_6.setCellStyle(center);
            Cell cell_7 = row_value.createCell(7);
            cell_7.setCellValue(inspectHistory.getMaterialGraphNo());
            cell_7.setCellStyle(center);
            Cell cell_8 = row_value.createCell(8);
            cell_8.setCellValue(inspectHistory.getQualifiedNumber());
            cell_8.setCellStyle(center);
            Cell cell_9 = row_value.createCell(9);
            cell_9.setCellValue(
                DateFormatterUtils.formatterDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, inspectHistory.getUpdateTime()));
            cell_9.setCellStyle(center);
        }

        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();

    }


    @ApiOperation("导出零星零件出库记录")
    @GetMapping("/material-out-record")
    public void materialRecord(HttpServletResponse response, HttpServletRequest request,
                               ExportMaterialRecordDTO dto) throws IOException {
        EntryOutStoreRecordExample example = new EntryOutStoreRecordExample();
        EntryOutStoreRecordExample.Criteria criteria = example.createCriteria();
        criteria.andTypeEqualTo(MATERIAL.code);
        if (StringUtils.isNotEmpty(dto.getStartDate())) {
            Date startDate = DateFormatterUtils.parseDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, dto.getStartDate());
            criteria.andUpdateTimeGreaterThanOrEqualTo(startDate);
        }
        if (StringUtils.isNotEmpty(dto.getEndDate())) {
            Date endDate = DateFormatterUtils.parseDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, dto.getEndDate());
            criteria.andUpdateTimeLessThanOrEqualTo(endDate);
        }
        if (StringUtils.isNotEmpty(dto.getMaterialGraphNo())) {
            criteria.andMaterialGraphNoLike("%" + dto.getMaterialGraphNo() + "%");
        }
        if (StringUtils.isNotEmpty(dto.getOrderNo())) {
            criteria.andOrderNoLike("%" + dto.getOrderNo() + "%");
        }
        if (dto.getOperationType() != null) {
            criteria.andOperationTypeEqualTo(dto.getOperationType().byteValue());
        }

        List<EntryOutStoreRecord> entryOutStoreRecordList = entryOutStoreRecordMapper.selectByExample(example);

        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("零件出库明细", "utf-8") + ".xls");
        response.setContentType("application/octet-stream;");
        Workbook workbook = new HSSFWorkbook();
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setWrapText(true);
        Sheet sheet = workbook.createSheet("零件出库明细");
        // 单元格样式
        CellStyle center = workbook.createCellStyle();
        center.setAlignment(HorizontalAlignment.CENTER);
        center.setVerticalAlignment(VerticalAlignment.CENTER);
        center.setWrapText(true);

        Row title_1 = sheet.createRow(0);
        CellRangeAddress cra1 = new CellRangeAddress(0, 0, 0, 7);
        sheet.addMergedRegion(cra1);
        Cell cell_title_1 = title_1.createCell(0);
        cell_title_1.setCellValue("零 件 出 库 明 细");
        cell_title_1.setCellStyle(center);

        Row columnTitle = sheet.createRow(1);
        Cell cell_10 = columnTitle.createCell(0);
        cell_10.setCellValue("序号");
        cell_10.setCellStyle(center);
        Cell cell_11 = columnTitle.createCell(1);
        cell_11.setCellValue("零件名称");
        cell_11.setCellStyle(center);
        Cell cell_12 = columnTitle.createCell(2);
        cell_12.setCellValue("零件图号");
        cell_12.setCellStyle(center);
        Cell cell_13 = columnTitle.createCell(3);
        cell_13.setCellValue("零件批次号");
        cell_13.setCellStyle(center);
        Cell cell_14 = columnTitle.createCell(4);
        cell_14.setCellValue("操作类型");
        cell_14.setCellStyle(center);
        Cell cell_15 = columnTitle.createCell(5);
        cell_15.setCellValue("日期");
        cell_15.setCellStyle(center);
        Cell cell_16 = columnTitle.createCell(6);
        cell_16.setCellValue("数量");
        cell_16.setCellStyle(center);
        Cell cell_17 = columnTitle.createCell(7);
        cell_17.setCellValue("领料部门");
        cell_17.setCellStyle(center);
        Cell cell_18 = columnTitle.createCell(8);
        cell_18.setCellValue("单价");
        cell_18.setCellStyle(center);
        Cell cell_19 = columnTitle.createCell(9);
        cell_19.setCellValue("金额");
        cell_19.setCellStyle(center);

        for (int i = 0; i < entryOutStoreRecordList.size(); i++) {
            EntryOutStoreRecord entryOutStoreRecord = entryOutStoreRecordList.get(i);

            Row row_value = sheet.createRow(i + 2);
            Cell cell_0 = row_value.createCell(0);
            cell_0.setCellValue(i + 1);
            cell_0.setCellStyle(center);
            Cell cell_1 = row_value.createCell(1);
            cell_1.setCellValue(materialService.getInfoByGraphNo(entryOutStoreRecord.getMaterialGraphNo()).getName());
            cell_1.setCellStyle(center);
            Cell cell_2 = row_value.createCell(2);
            cell_2.setCellValue(entryOutStoreRecord.getMaterialGraphNo());
            cell_2.setCellStyle(center);
            Cell cell_3 = row_value.createCell(3);
            cell_3.setCellValue(entryOutStoreRecord.getMaterialBatchNo());
            cell_3.setCellStyle(center);
            Cell cell_4 = row_value.createCell(4);
            cell_4.setCellValue(entryOutStoreRecord.getOperationType() == 1 ? "出库" : "入库");
            cell_4.setCellStyle(center);
            Cell cell_5 = row_value.createCell(5);
            cell_5.setCellValue(
                DateFormatterUtils.formatterDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, entryOutStoreRecord.getCreateTime()));
            cell_5.setCellStyle(center);
            Cell cell_6 = row_value.createCell(6);
            cell_6.setCellValue(Math.abs(entryOutStoreRecord.getQuantity()));
            cell_6.setCellStyle(center);
            Cell cell_7 = row_value.createCell(7);
            cell_7.setCellValue(entryOutStoreRecord.getReceiveDepartment());
            cell_7.setCellStyle(center);
            Cell cell_8 = row_value.createCell(8);
            cell_8.setCellValue(String.valueOf(entryOutStoreRecord.getPrice()));
            cell_8.setCellStyle(center);
            BigDecimal amount = entryOutStoreRecord.getPrice().multiply(new BigDecimal(entryOutStoreRecord.getQuantity())).setScale(2, BigDecimal.ROUND_HALF_UP);
            Cell cell_9 = row_value.createCell(9);
            cell_9.setCellValue(String.valueOf(amount));
            cell_9.setCellStyle(center);

        }
        sheet.autoSizeColumn(0, true);
        sheet.autoSizeColumn(1, true);
        sheet.autoSizeColumn(2, true);
        sheet.autoSizeColumn(3, true);
        sheet.autoSizeColumn(4, true);
        sheet.autoSizeColumn(5, true);
        sheet.autoSizeColumn(6, true);
        sheet.autoSizeColumn(7, true);

        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();

    }


    @ApiOperation("导出零星零件结存数据")
    @GetMapping("/material/surplus")
    public void materialSurplus(HttpServletResponse response, HttpServletRequest request)
        throws IOException {
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("零件结存明细", "utf-8") + ".xls");
        response.setContentType("application/octet-stream;");
        Workbook workbook = new HSSFWorkbook();
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setWrapText(true);
        Sheet sheet = workbook.createSheet("零件结存明细");
        // 单元格样式
        CellStyle center = workbook.createCellStyle();
        center.setAlignment(HorizontalAlignment.CENTER);
        center.setVerticalAlignment(VerticalAlignment.CENTER);
        center.setWrapText(true);

        Row title_1 = sheet.createRow(0);
        CellRangeAddress cra1 = new CellRangeAddress(0, 0, 0, 4);
        sheet.addMergedRegion(cra1);
        Cell cell_title_1 = title_1.createCell(0);
        cell_title_1.setCellValue("零 件 结 存 明 细");
        cell_title_1.setCellStyle(center);

        Row columnTitle = sheet.createRow(1);
        Cell cell_10 = columnTitle.createCell(0);
        cell_10.setCellValue("序号");
        cell_10.setCellStyle(center);
        Cell cell_11 = columnTitle.createCell(1);
        cell_11.setCellValue("零件名称");
        cell_11.setCellStyle(center);
        Cell cell_12 = columnTitle.createCell(2);
        cell_12.setCellValue("零件图号");
        cell_12.setCellStyle(center);
        Cell cell_13 = columnTitle.createCell(3);
        cell_13.setCellValue("库存量");
        cell_13.setCellStyle(center);
        Cell cell_14 = columnTitle.createCell(4);
        cell_14.setCellValue("单位");
        cell_14.setCellStyle(center);
        Cell cell_15 = columnTitle.createCell(5);
        cell_15.setCellValue("单价");
        cell_15.setCellStyle(center);
        Cell cell_16 = columnTitle.createCell(6);
        cell_16.setCellValue("金额");
        cell_16.setCellStyle(center);
        List<Material> materials = materialMapper.selectByExample(new MaterialExample());
        for (int i = 0; i < materials.size(); i++) {
            Material material = materials.get(i);
            Row row_value = sheet.createRow(i + 2);
            Cell cell_0 = row_value.createCell(0);
            cell_0.setCellValue(i + 1);
            cell_0.setCellStyle(center);
            Cell cell_1 = row_value.createCell(1);
            cell_1.setCellValue(material.getName());
            cell_1.setCellStyle(center);
            Cell cell_2 = row_value.createCell(2);
            cell_2.setCellValue(material.getGraphNo());
            cell_2.setCellStyle(center);
            Cell cell_3 = row_value.createCell(3);
            cell_3.setCellValue(material.getCurrentQuantity() + material.getLockQuantity());
            cell_3.setCellStyle(center);
            Cell cell_4 = row_value.createCell(4);
            cell_4.setCellValue(material.getUnit());
            cell_4.setCellStyle(center);
            Cell cell_5 = row_value.createCell(5);
            cell_5.setCellValue(String.valueOf(material.getPrice()));
            cell_5.setCellStyle(center);
            BigDecimal amount = material.getPrice().multiply(new BigDecimal(material.getCurrentQuantity())).setScale(2, BigDecimal.ROUND_HALF_UP);
            Cell cell_6 = row_value.createCell(6);
            cell_6.setCellValue(String.valueOf(amount));
            cell_6.setCellStyle(center);
        }

        sheet.autoSizeColumn(1, true);
        sheet.autoSizeColumn(2, true);

        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }


}
