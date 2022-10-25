package com.deepsoft.haolifa.controller;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.deepsoft.haolifa.dao.repository.MaterialMapper;
import com.deepsoft.haolifa.dao.repository.StockMapper;
import com.deepsoft.haolifa.dao.repository.extend.CommonExtendMapper;
import com.deepsoft.haolifa.model.domain.Material;
import com.deepsoft.haolifa.model.domain.MaterialExample;
import com.deepsoft.haolifa.model.domain.Stock;
import com.deepsoft.haolifa.model.domain.StockExample;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.SysLogConditionDTO;
import com.deepsoft.haolifa.model.vo.DataRepairVO;
import com.deepsoft.haolifa.service.SysLogService;
import com.deepsoft.haolifa.util.DateFormatterUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Api(tags = {"数据修复"})
@RestController
@RequestMapping("/sys-log")
@Slf4j
public class DataRepairController {
    @Resource
    private CommonExtendMapper commonExtendMapper;

    @Resource
    private StockMapper stockMapper;

    @Resource
    private MaterialMapper materialMapper;

    @PostMapping("init")
    @ApiOperation("初始化库存数据-2022")
    public void initMaterialData() throws IOException {
        List<String> noSystemNoList = new ArrayList<>();
        List<String> excelNoList = new ArrayList<>();
        List<String> systemNoExcelList = new ArrayList<>();
        // 1. 先获取系统中所有的图号（阀体，阀座，阀板，阀杆）
        MaterialExample example = new MaterialExample();
        List<Material> materials = materialMapper.selectByExample(example);
        log.info("stock out material list:{}", materials.size());
        Map<String, Integer> map = materials.stream().collect(Collectors.toMap(Material::getGraphNo, Material::getLockQuantity));

        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File("E://11.xlsx")));
        Sheet sheet = workbook.getSheetAt(0);
        for (int rowNum = 1; rowNum < sheet.getLastRowNum(); rowNum++) {
            Row row = sheet.getRow(rowNum);
            String trueGraphNo = getCellValue(row.getCell(1));
            Integer trueQuantity = Integer.valueOf(getCellValue(row.getCell(2)));
            String batchNo = "PC20220528";
            if (map.containsKey(trueGraphNo)) {
//                Integer localQty = map.getOrDefault(trueGraphNo, 0);
//                if (localQty > 0) {
//                    int caju = trueQuantity - localQty;
//                    if (caju > 0) {
//                        log.info("caju more than 0 graphNo:{},{},{},{}", trueGraphNo, caju, trueQuantity, localQty);
//                        trueQuantity = caju;
//                    } else {
//                        log.info("caju less than 0 graphNo:{},{},{},{}", trueGraphNo, caju, trueQuantity, localQty);
////                        localQty = trueQuantity;
//                        trueQuantity = 0;
//                    }
//                }
//                this.changeStockQty(trueGraphNo, 0, trueQuantity, "Z1", "Z1-1", batchNo);
//                excelNoList.add(trueGraphNo);
            } else {
                log.info("stock out material system no graph no:{}", trueGraphNo);
                noSystemNoList.add(trueGraphNo);
                Material material = new Material();
                material.setGraphNo(trueGraphNo);
                material.setCreateUser(0);
                material.setCurrentQuantity(trueQuantity);
                materialMapper.insertSelective(material);
                if (trueQuantity != 0) {
                    Stock insertStock = new Stock() {{
                        setCreateUser(0);
                        setMaterialGraphNo(trueGraphNo);
                        setMaterialBatchNo(batchNo);
                        setQuantity(trueQuantity);
                        setType((byte) 2);
                        setRemark("2022.5.28初始化新增");
                        setRoomNo("Z1");
                        setRackNo("Z1-1");
                    }};
                    stockMapper.insertSelective(insertStock);
                }
            }
        }
        // 系统中有，盘点表里面没有，则将系统中的图号的库存都清零
//        map.keySet().forEach(e -> {
//            if (!excelNoList.contains(e)) {
//                int trueQuantity = 0;
//                Integer localQty = map.getOrDefault(e, 0);
//                if (localQty > 0) {
//                    trueQuantity = -localQty;
//                }
//                log.info("excel not null bug system exist:{}", e);
//                this.changeStockQty(e, localQty, trueQuantity, "Z1", "Z1-1", "PC20220527");
////                systemNoExcelList.add(e);
//            }
//        });

        // excel中有，系统中没有的数据
        if (CollectionUtil.isNotEmpty(noSystemNoList)) {
            BufferedWriter bw = new BufferedWriter(new FileWriter("E://excelExists.txt"));
            for (String no : noSystemNoList) {
                bw.write(no + "\r\n");
                bw.flush();
            }
            bw.close();
        }
        // 系统中有，excel中没有的数据
//        if (CollectionUtil.isNotEmpty(systemNoExcelList)) {
//            BufferedWriter bw = new BufferedWriter(new FileWriter("E://systemExists.txt"));
//            for (String no : systemNoExcelList) {
//                bw.write(no + "\r\n");
//                bw.flush();
//            }
//            bw.close();
//        }
    }


    @PostMapping("repairStock")
    @ApiOperation("修复批次号库存和主库存不一致的数据")
    public ResultBean repairStock() {
        List<DataRepairVO> dataRepairVOS = commonExtendMapper.checkStock();
        for (DataRepairVO repairVO : dataRepairVOS) {
            log.info("repari:{}", JSONUtil.toJsonStr(repairVO));
            String graphNo = repairVO.getGraphNo();
            StockExample stockExample = new StockExample();
            stockExample.or().andMaterialGraphNoEqualTo(graphNo).andQuantityGreaterThan(0);
            List<Stock> stockList = stockMapper.selectByExample(stockExample);
            for (Stock stock : stockList) {
                Integer quantity = stock.getQuantity();
                if (quantity >= repairVO.getQty()) {
                    Stock updateStock = new Stock();
                    updateStock.setId(stock.getId());
                    updateStock.setQuantity(quantity - repairVO.getQty());
                    stockMapper.updateByPrimaryKeySelective(updateStock);
                    break;
                }
            }
        }

        return null;
    }

    @PostMapping("repairStock-max")
    @ApiOperation("修复批次号库存和主库存不一致的数据")
    public ResultBean repairStockMax() {
        List<DataRepairVO> dataRepairVOS = commonExtendMapper.checkStock();
        for (DataRepairVO repairVO : dataRepairVOS) {
            log.info("repari:{}", JSONUtil.toJsonStr(repairVO));
            String graphNo = repairVO.getGraphNo();
            StockExample stockExample = new StockExample();
            stockExample.or().andMaterialGraphNoEqualTo(graphNo).andQuantityGreaterThan(0);
            List<Stock> stockList = stockMapper.selectByExample(stockExample);
            int qq = repairVO.getQty();
            for (Stock stock : stockList) {
                Integer quantity = stock.getQuantity();
                int cqq = qq - quantity;
                if (cqq > 0) {
                    Stock updateStock = new Stock();
                    updateStock.setId(stock.getId());
                    updateStock.setQuantity(0);
                    stockMapper.updateByPrimaryKeySelective(updateStock);
                    qq = cqq;
                } else {
                    Stock updateStock = new Stock();
                    updateStock.setId(stock.getId());
                    updateStock.setQuantity(-cqq);
                    stockMapper.updateByPrimaryKeySelective(updateStock);
                    break;
                }
            }
        }
        return null;
    }

    private String getCellValue(Cell cell) {
        String cellValue = "";
        if (cell != null) {
            CellType cellTypeEnum = cell.getCellTypeEnum();
            switch (cellTypeEnum) {
                case STRING:
                    String stringCellValue = cell.getStringCellValue();
                    boolean number = NumberUtils.isNumber(stringCellValue);
                    cellValue = number ? new Double(stringCellValue).toString() : stringCellValue;
                    boolean digits = NumberUtils.isDigits(stringCellValue);
                    cellValue = digits ? stringCellValue : cellValue;
                    break;
                case NUMERIC:
                    if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {// 如果是日期格式
                        cellValue = DateFormatterUtils.formatterDateString("yyyy-MM-dd", cell.getDateCellValue());
                    } else {
                        cellValue = new BigDecimal(cell.getNumericCellValue()).toString();
                        if (cellValue.contains(".")) {
                            cellValue = Double.toString(cell.getNumericCellValue());
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        return cellValue;
    }

    @PostMapping("stock-out-material")
    @ApiOperation("盘点零件")
    @Transactional(rollbackFor = Exception.class)
    public void stockOutMaterial() throws IOException {
        Map<String, String> roomMap = new HashMap<>();
        roomMap.put("库房一", "A1");
        roomMap.put("库房二", "B1");
        roomMap.put("库房三", "C1");
        roomMap.put("库房四", "D1");
        roomMap.put("阀门成品库", "CP-1");
        roomMap.put("辅料库", "E1");

        Map<String, String> rackMap = new HashMap<>();
        rackMap.put("阀体毛坯区", "A1-1");
        rackMap.put("阀板毛坯区", "A1-2");
        rackMap.put("阀体半成品库房", "B1-1");
        rackMap.put("阀板半成品库房", "B1-2");
        rackMap.put("阀体成品", "C1-1");
        rackMap.put("阀板成品", "C1-2");
        rackMap.put("阀座", "C1-3");
        rackMap.put("阀轴", "C1-4");
        rackMap.put("阀门通用零部件", "D1-1");
        rackMap.put("阀门成品库区", "CP1-1");
        rackMap.put("辅料库", "E1-1");


        List<String> noSystemNoList = new ArrayList<>();
        List<String> excelNoList = new ArrayList<>();
        List<String> systemNoExcelList = new ArrayList<>();
        // 1. 先获取系统中所有的图号（阀体，阀座，阀板，阀杆）
        MaterialExample example = new MaterialExample();
        example.or().andMaterialClassifyIdIn(Stream.of(1).collect(Collectors.toList()));
        List<Material> materials = materialMapper.selectByExample(example);
        log.info("stock out material list:{}", materials.size());
        Map<String, Integer> map = materials.stream().collect(Collectors.toMap(Material::getGraphNo, Material::getLockQuantity));

        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File("d://fati.xlsx")));
        Sheet sheet = workbook.getSheetAt(0);
        for (int rowNum = 1; rowNum < sheet.getLastRowNum(); rowNum++) {
            Row row = sheet.getRow(rowNum);
            String trueGraphNo = getCellValue(row.getCell(1));
            Integer trueQuantity = Integer.valueOf(getCellValue(row.getCell(2)));
            String room = getCellValue(row.getCell(3));
            String rack = getCellValue(row.getCell(4));
            String batchNo = getCellValue(row.getCell(5));
            String roomNo = roomMap.get(room);
            String rackNo = rackMap.get(rack);
            if (map.containsKey(trueGraphNo)) {
                Integer localQty = map.get(trueGraphNo);
                if (localQty > 0) {
                    int caju = trueQuantity - localQty;
                    if (caju > 0) {
                        log.info("caju more than 0 graphNo:{},{},{},{}", trueGraphNo, caju, trueQuantity, localQty);
                        trueQuantity = caju;
                    } else {
                        log.info("caju less than 0 graphNo:{},{},{},{}", trueGraphNo, caju, trueQuantity, localQty);
                        localQty = trueQuantity;
                        trueQuantity = 0;
                    }
                }
                this.changeStockQty(trueGraphNo, localQty, trueQuantity, roomNo, rackNo, batchNo);
                excelNoList.add(trueGraphNo);
            } else {
                log.info("stock out material system no graph no:{}", trueGraphNo);
                noSystemNoList.add(trueGraphNo);
            }
        }
        // 系统中有，盘点表里面没有，则将系统中的图号的库存都清零
        map.keySet().forEach(e -> {
            if (!excelNoList.contains(e)) {
                log.info("excel not null bug system exist:{}", e);
                this.changeStockQty(e, 0, 0, "", "", "");
                systemNoExcelList.add(e);
            }
        });

        // excel中有，系统中没有的数据
        if (CollectionUtil.isNotEmpty(noSystemNoList)) {
            BufferedWriter bw = new BufferedWriter(new FileWriter("d://excelExists.txt"));
            for (String no : noSystemNoList) {
                bw.write(no + "\r\n");
                bw.flush();
            }
            bw.close();
        }
        // 系统中有，excel中没有的数据
        if (CollectionUtil.isNotEmpty(systemNoExcelList)) {
            BufferedWriter bw = new BufferedWriter(new FileWriter("E://systemExists.txt"));
            for (String no : systemNoExcelList) {
                bw.write(no + "\r\n");
                bw.flush();
            }
            bw.close();
        }
    }


    private void changeStockQty(String graphNo, Integer lockQty, Integer qty, String roomNo, String rackNo, String batchNo) {
//        if (lockQty + qty > 0) {
//            if (StrUtil.isBlank(batchNo)
//                || StrUtil.isBlank(roomNo)
//                || StrUtil.isBlank(rackNo)) {
//                log.info("params is need :{},{},{},{}", graphNo, batchNo, roomNo, rackNo);
//                return;
//            }
//        }
        // 1.更新零件信息库的库存； 可用库存更新为表格的数据； 锁定库存更新为0；
        MaterialExample example = new MaterialExample();
        example.or().andGraphNoEqualTo(graphNo);
        Material update = new Material() {{
            setCurrentQuantity(qty);
            setLockQuantity(lockQty);
        }};
        materialMapper.updateByExampleSelective(update, example);

        // 2.更新原来的库存表数据为0
//        StockExample stockExample = new StockExample();
//        stockExample.or().andMaterialGraphNoEqualTo(graphNo);
//        Stock stockUpdate = new Stock() {{
//            setQuantity(0);
//            setRemark("2021盘点更新库存为0");
//        }};
//        stockMapper.updateByExampleSelective(stockUpdate, stockExample);

        // 3. 插入新的库存数据
//        if (qty + lockQty > 0) {
//            if (StrUtil.isBlank(batchNo)
//                || StrUtil.isBlank(roomNo)
//                || StrUtil.isBlank(rackNo)) {
//                log.info("params is need :{},{},{},{}", graphNo, batchNo, roomNo, rackNo);
//                return;
//            }
        if (qty != 0) {
            Stock insertStock = new Stock() {{
                setCreateUser(0);
                setMaterialGraphNo(graphNo);
                setMaterialBatchNo(batchNo);
                setQuantity(qty);
                setType((byte) 2);
                setRemark("2022.5.28初始化新增");
                setRoomNo(roomNo);
                setRackNo(rackNo);
            }};
            stockMapper.insertSelective(insertStock);
        }
    }
//    }
}
