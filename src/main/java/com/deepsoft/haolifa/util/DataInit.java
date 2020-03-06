package com.deepsoft.haolifa.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.math.BigDecimal;


public class DataInit {

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

    public static void main(String[] args) throws IOException {
        BufferedWriter bw=new BufferedWriter(new FileWriter(new File("d://123.sql")));
        String path = "d://111.xlsx";
        String fileType = path.substring(path.lastIndexOf(".") + 1);
        InputStream is = null;
        try {
            is = new FileInputStream(path);
            //获取工作薄
            Workbook wb = null;
            if (fileType.equals("xls")) {
                wb = new HSSFWorkbook(is);
            } else if (fileType.equals("xlsx")) {
                wb = new XSSFWorkbook(is);
            }
            //读取第一个工作页sheet
            Sheet sheet = wb.getSheetAt(0);
            //第一行为标题
            for (int i = 1; i < sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                Cell cell1 = row.getCell(1);
                String name = getCellValue(cell1);
                Cell cell2 = row.getCell(2);
                String classifyName= getCellValue(cell2);
                Cell cell3 = row.getCell(3);
                String model= getCellValue(cell3);
                Cell cell4 = row.getCell(4);
                String guige= getCellValue(cell4);
                Cell cell6 = row.getCell(6);
                String unit= getCellValue(cell6);
                Cell cell7 = row.getCell(7);
                String price= getCellValue(cell7);
                Cell cell8 = row.getCell(8);
                String count= getCellValue(cell8);
                String no="lx_" + RandomUtils.orderNoStr();
                String str="INSERT INTO `sporadic_material` (`graph_no`,`classify_name`, `material_name`,  `unit`, `model`, `price`, `specifications`, `quantity`) " +
                    "VALUES ( '"+no+"','"+classifyName+"','"+name+"','"+unit+"','"+model+"',"+price+",'"+guige+"',"+count+");\r\n";
                bw.write(str);
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bw.close();
            try {
                if (is != null) is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
