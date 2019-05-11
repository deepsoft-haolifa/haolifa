package com.deepsoft.haolifa.controller;


import com.deepsoft.haolifa.annotation.LogNotPrint;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.model.domain.Entrust;
import com.deepsoft.haolifa.model.domain.PriceMaterial;
import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.model.dto.order.OrderMaterialDTO;
import com.deepsoft.haolifa.model.dto.spray.SprayDto;
import com.deepsoft.haolifa.model.dto.spray.SprayItemDto;
import com.deepsoft.haolifa.service.*;
import com.deepsoft.haolifa.util.DateFormatterUtils;
import com.deepsoft.haolifa.util.UpperMoney;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@LogNotPrint
@RestController
@RequestMapping("/import")
@Api(tags = "数据导入")
public class importExcelController {

    @Autowired
    private MaterialService materialService;
    @Autowired
    private StockService stockService;

    @ApiOperation("导入零件数据")
    @PostMapping(value="/material/upload",headers="content-type=multipart/form-data")
    public ResultBean uploadMaterial(@ApiParam(value = "零件Excel表格", required = true) MultipartFile file) {
        try {
            if (file != null) {
                String fileName = file.getOriginalFilename();
                String fileType = fileName.substring(fileName.lastIndexOf("."));
                InputStream is = file.getInputStream();
                //获取工作薄
                Workbook wb = null;
                if (fileType.equals(".xls")) {
                    wb = new HSSFWorkbook(is);
                } else if (fileType.equals(".xlsx")) {
                    wb = new XSSFWorkbook(is);
                }
                //读取第一个工作页sheet
                Sheet sheet = wb.getSheetAt(0);
                //第一行为标题
                for (int i = 1; i < sheet.getLastRowNum(); i++) {
                    Row row = sheet.getRow(i);
                    MaterialRequestDTO materialRequestDTO = new MaterialRequestDTO();
                    Cell cell0 = row.getCell(0);
                    String name = getCellValue(cell0);
                    materialRequestDTO.setName(name);
                    Cell cell1 = row.getCell(1);
                    String classifyName = getCellValue(cell1);
                    int clasifyId = 0;
                    if (classifyName.equals("阀体")) {
                        clasifyId = 1;
                    } else if (classifyName.equals("阀板")) {
                        clasifyId = 2;

                    } else if (classifyName.equals("阀座")) {
                        clasifyId = 3;

                    } else if (classifyName.equals("阀杆")) {
                        clasifyId = 4;

                    } else if (classifyName.equals("通用零件")) {
                        clasifyId = 5;

                    } else if (classifyName.equals("驱动")) {
                        clasifyId = 6;
                    }
                    materialRequestDTO.setMaterialClassifyName(classifyName);
                    materialRequestDTO.setMaterialClassifyId(clasifyId);
                    Cell cell2 = row.getCell(2);
                    String graphNo = getCellValue(cell2);
                    materialRequestDTO.setGraphNo(graphNo);
                    // 可替换料
                    Cell cell3 = row.getCell(3);
                    materialRequestDTO.setReplaceGraphNos(getCellValue(cell3));
                    // 型号
                    Cell cell4 = row.getCell(4);
                    String model = getCellValue(cell4);
                    materialRequestDTO.setModel(model);
                    // 规格
                    Cell cell5 = row.getCell(5);
                    String spec = getCellValue(cell5);
                    materialRequestDTO.setSpecifications(spec);
                    // 配套基数
                    Cell cell6 = row.getCell(6);
                    int support = 1;
                    if (StringUtils.isNotBlank(getCellValue(cell6))) {
                        support = Integer.valueOf(getCellValue(cell6));
                    }
                    materialRequestDTO.setSupportQuantity(support);
                    // 配套基数
                    Cell cell7 = row.getCell(7);
                    String unit=getCellValue(cell7);
                    materialRequestDTO.setUnit(unit);
                    // 期初库存
                    Cell cell8 = row.getCell(8);
                    int currentQuantity = 0;
                    if (StringUtils.isNotBlank(getCellValue(cell8))) {
                        currentQuantity = Integer.valueOf(getCellValue(cell8));
                    }
                    materialRequestDTO.setCurrentQuantity(currentQuantity);
                    // 安全库存
                    Cell cell9 = row.getCell(9);
                    int safeCount = 0;
                    if (StringUtils.isNotBlank(getCellValue(cell9))) {
                        safeCount = Integer.valueOf(getCellValue(cell9));
                    }
                    materialRequestDTO.setSafeQuantity(safeCount);
                    // 所在库房
                    Cell cell11 = row.getCell(11);
                    String roomNo = getCellValue(cell11);
                    // 所在库位
                    Cell cell12 = row.getCell(12);
                    String rackNo = getCellValue(cell12);
                    // 批次号
                    Cell cell13 = row.getCell(13);
                    String materialBatchNo = getCellValue(cell13);

                    // 实际单重
                    Cell cell14 = row.getCell(14);
                    String actualWeight = getCellValue(cell14);
                    materialRequestDTO.setActualWeight(actualWeight);
                    // 单价
                    Cell cell16 = row.getCell(16);
                    BigDecimal price = BigDecimal.ZERO;
                    if (getCellValue(cell16) != null) {
                        price = new BigDecimal(getCellValue(cell16));
                    }
                    materialRequestDTO.setPrice(price);
                    // 材料
                    Cell cell18 = row.getCell(18);
                    String material = getCellValue(cell18);
                    materialRequestDTO.setMaterial(material);
                    // 添加零件表
                    materialService.save(materialRequestDTO);

                    // 添加库房库存表
                    EntryOutStorageDTO entryOutStorageDTO = new EntryOutStorageDTO();
                    entryOutStorageDTO.setMaterialBatchNo(materialBatchNo);
                    entryOutStorageDTO.setRoomNo(roomNo);
                    entryOutStorageDTO.setRackNo(rackNo);
                    entryOutStorageDTO.setMaterialGraphNo(graphNo);
                    entryOutStorageDTO.setQuantity(currentQuantity);
                    byte operationType = CommonEnum.OperationType.ENTRY.code;
                    byte storageType = CommonEnum.StorageType.MATERIAL.code;
                    entryOutStorageDTO.setType(storageType);
                    entryOutStorageDTO.setOperationType(operationType);
                    stockService.addStock(entryOutStorageDTO);

//                    // 添加到零件价格表
//                    PriceMaterial priceMaterial = new PriceMaterial() {{
//                        setMaterialClassifyName(classifyName);
//                        setGraphNo(graphNo);
//                        setName(name);
//                        setModel(model);
//                        setSpecifications(spec);
//                        setMaterial(material);
//                        setActualWeight(actualWeight);
//                        // 毛坯价
//                        Cell cell18 = row.getCell(18);
//                        String blankCost = getCellValue(cell18);
//                        setBlankCost(blankCost);
//                        // 机加
//                        Cell cell19 = row.getCell(19);
//                        String processCost = getCellValue(cell19);
//                        setProcessCost(processCost);
//                    }};
//                    priceMaterialService.saveInfo(priceMaterial);
                }
            }
            return ResultBean.success(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultBean.error(null);
        }
    }

    private static String getCellValue(Cell cell) {
        String cellValue = "";
        if (cell != null) {
            CellType cellTypeEnum = cell.getCellTypeEnum();
            switch (cellTypeEnum) {
                case STRING:
                    cellValue = cell.getStringCellValue();
//                    String stringCellValue = cell.getStringCellValue();
//                    boolean number = NumberUtils.isNumber(stringCellValue);
//                    cellValue = number ? new Double(stringCellValue).toString() : stringCellValue;
//                    boolean digits = NumberUtils.isDigits(stringCellValue);
//                    cellValue = digits ? stringCellValue : cellValue;
                    break;
                case NUMERIC:
                    cellValue = new BigDecimal(cell.getNumericCellValue()).toString();
                    if (cellValue.contains(".")) {
                        cellValue = Double.toString(cell.getNumericCellValue());
                    }
                    break;
                default:
                    break;
            }
        }
        return cellValue;
    }
}
