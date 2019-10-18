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
        priceProduct();
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

    private static String getCellValue(Cell cell) {
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

}
