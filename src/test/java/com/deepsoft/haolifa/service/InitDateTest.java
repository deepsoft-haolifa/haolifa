package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.util.DateFormatterUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.math.BigDecimal;

/**
 * 初始化数据
 *
 * @author murphy.he
 **/
public class InitDateTest {

    public static void main(String[] args) throws IOException {
        priceMaterial();
    }

    /**
     * 成品价格初始
     */
    public static void priceProduct() throws IOException {
        BufferedWriter userBw = new BufferedWriter(new FileWriter(new File("D://priceProduct.sql")));

        String filePath = "D:/def.xlsx";
        File file = new File(filePath);
        Workbook workbook = null;
        FileInputStream fis = new FileInputStream(file);
        String extString = filePath.substring(filePath.lastIndexOf("."));
        if (".xls".equals(extString)) {
            workbook = new HSSFWorkbook(fis);
        } else if (".xlsx".equals(extString)) {
            workbook = new XSSFWorkbook(fis);
        } else {
            workbook = null;
        }
        try {
            int numberOfSheets = workbook.getNumberOfSheets();
            Sheet sheet = workbook.getSheetAt(0);
            for (int i = 2; i < sheet.getLastRowNum() + 1; i++) {
                Row row = sheet.getRow(i);
                if (null != row) {
                    Cell cell1 = row.getCell(1);
                    String model = getCellValue(cell1);
                    Cell cell2 = row.getCell(2);
                    String no = getCellValue(cell2);
                    Cell cell3 = row.getCell(3);
                    String price = getCellValue(cell3);

                    StringBuilder sb = new StringBuilder();
                    sb.append("insert into price_product (product_no,product_model,ex_factory_price) values ('")
                            .append(no).append("','")
                            .append(model).append("',")
                            .append(price).append(");").append("\r\n");
                    userBw.write(sb.toString());
                    userBw.flush();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        userBw.close();
    }

    /**
     * 零件价格初始
     * @throws IOException
     */
    public static void priceMaterial() throws IOException {
        BufferedWriter userBw = new BufferedWriter(new FileWriter(new File("D://priceMaterial.sql")));

        String filePath = "D:/gg.xlsx";
        File file = new File(filePath);
        Workbook workbook = null;
        FileInputStream fis = new FileInputStream(file);
        String extString = filePath.substring(filePath.lastIndexOf("."));
        if (".xls".equals(extString)) {
            workbook = new HSSFWorkbook(fis);
        } else if (".xlsx".equals(extString)) {
            workbook = new XSSFWorkbook(fis);
        } else {
            workbook = null;
        }
        try {
            int numberOfSheets = workbook.getNumberOfSheets();
            Sheet sheet = workbook.getSheetAt(0);
            for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
                Row row = sheet.getRow(i);
                if (null != row) {
                    Cell cell1 = row.getCell(1);
                    String graphNo = getCellValue(cell1);
                    Cell cell2 = row.getCell(2);
                    String name = getCellValue(cell2);
                    Cell cell3 = row.getCell(3);
                    String specifications = getCellValue(cell3);
                    Cell cell4 = row.getCell(4);
                    String model = getCellValue(cell4);
                    Cell cell5 = row.getCell(5);
                    String classifyName = getCellValue(cell5);
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
                    Cell cell6 = row.getCell(6);
                    String material = getCellValue(cell6);
                    Cell cell7 = row.getCell(7);
                    String unit = getCellValue(cell7);
                    Cell cell8 = row.getCell(8);
                    String actualWeight = getCellValue(cell8);
                    Cell cell9 = row.getCell(9);
                    String tontPrice = getCellValue(cell9);
                    Cell cell10 = row.getCell(10);
                    String taxRate = getCellValue(cell10);
                    Cell cell11 = row.getCell(11);
                    String blank_costStr = getCellValue(cell11);
                    BigDecimal blank_cost= new BigDecimal(blank_costStr).setScale(2,BigDecimal.ROUND_HALF_UP);
                    Cell cell12 = row.getCell(12);
                    String blank_cost_tax = getCellValue(cell12);
//                    BigDecimal blank_cost_tax= new BigDecimal(blank_cost_taxStr).setScale(2,BigDecimal.ROUND_HALF_UP);
                    Cell cell13 = row.getCell(13);
                    String process_cost = getCellValue(cell13);
//                    BigDecimal process_cost= new BigDecimal(process_costStr).setScale(2,BigDecimal.ROUND_HALF_UP);
                    Cell cell14 = row.getCell(14);
                    String spray_cost = getCellValue(cell14);
//                    BigDecimal spray_cost= new BigDecimal(spray_costStr).setScale(2,BigDecimal.ROUND_HALF_UP);
                    Cell cell15 = row.getCell(15);
                    String price_taxStr = getCellValue(cell15);
                    BigDecimal price_tax= new BigDecimal(price_taxStr).setScale(2,BigDecimal.ROUND_HALF_UP);
                    Cell cell16 = row.getCell(16);
                    String priceStr = getCellValue(cell16);
                    BigDecimal price= new BigDecimal(priceStr).setScale(2,BigDecimal.ROUND_HALF_UP);
                    StringBuilder sb = new StringBuilder();
                    sb.append("INSERT INTO `price_material`(`material_classify_id`, `material_classify_name`, `name`, `graph_no`, `model`, " +
                            "`specifications`, `material`, `unit`, `actual_weight`, `tax_rate`, `ton_price`, `blank_cost`, `blank_cost_tax`," +
                            " `process_cost`, `spray_cost`, `price`, `price_tax`) VALUES ('")
                            .append(clasifyId).append("','")
                            .append(classifyName).append("','")
                            .append(name).append("','")
                            .append(graphNo).append("','")
                            .append(model).append("','")
                            .append(specifications).append("','")
                            .append(material).append("','")
                            .append(unit).append("',")
                            .append(actualWeight).append(",")
                            .append(taxRate).append(",")
                            .append(tontPrice).append(",")
                            .append(blank_cost).append(",")
                            .append(blank_cost_tax).append(",")
                            .append(process_cost).append(",")
                            .append(spray_cost).append(",")
                            .append(price).append(",")
                            .append(price_tax).append(");").append("\r\n");
                    userBw.write(sb.toString());
                    userBw.flush();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        userBw.close();
    }


    private static String getCellValue(Cell cell) {
        String cellValue = "";
        if (cell != null) {
            CellType cellTypeEnum = cell.getCellTypeEnum();
            switch (cellTypeEnum) {
                case STRING:
                     cellValue = cell.getStringCellValue();
//                    boolean number = NumberUtils.isNumber(stringCellValue);
//                    cellValue = number ? new Double(stringCellValue).toString() : stringCellValue;
//                    boolean digits = NumberUtils.isDigits(stringCellValue);
//                    cellValue = digits ? stringCellValue : cellValue;
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

}
