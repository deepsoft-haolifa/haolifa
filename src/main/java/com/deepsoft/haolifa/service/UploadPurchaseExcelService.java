package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.dao.repository.PurchaseOrderMapper;
import com.deepsoft.haolifa.model.domain.PurchaseOrder;
import com.deepsoft.haolifa.model.domain.PurchaseOrderExample;
import com.deepsoft.haolifa.model.dto.PurchaseOrderExDTO;
import com.deepsoft.haolifa.model.dto.PurchaseOrderItemExDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.util.DateFormatterUtils;
import com.deepsoft.haolifa.util.QiniuUtil;
import com.deepsoft.haolifa.util.UpperMoney;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UploadPurchaseExcelService {

  @Autowired
  private PurcahseOrderService purcahseOrderService;
  @Autowired
  private PurchaseOrderMapper purchaseOrderMapper;

  @Async("threadPoolTaskExecutor")
  public void uploadPurchaseOrderExcel(Integer formId) {
    ResultBean resultBean = purcahseOrderService.getInfo(formId);
    Map result = (Map<String, Object>) resultBean.getResult();
    PurchaseOrderExDTO orderExDTO = (PurchaseOrderExDTO) result.get("order");
    List<PurchaseOrderItemExDTO> itemExDTO = (List<PurchaseOrderItemExDTO>) result.get("items");
    HSSFWorkbook workbook = new HSSFWorkbook();
    HSSFSheet sheet;
    if (orderExDTO.getOrderType() == 0) {
      sheet = workbook.createSheet("采购订单");
    } else {
      sheet = workbook.createSheet("机加工订单");
    }

    int rowIdx = 0;
    HSSFRow rowTitle = sheet.createRow(rowIdx);
    rowTitle.setHeightInPoints(45);
    CellRangeAddress cra1 = new CellRangeAddress(rowIdx, rowIdx, 2, 11);
    sheet.addMergedRegion(cra1);
    rowTitle.createCell(0);
    rowTitle.createCell(1);
    HSSFCell cellTitle = rowTitle.createCell(2);
    cellTitle.setCellValue("山西好利阀机械制造有限公司");
    CellStyle titleStyle = workbook.createCellStyle();
    HSSFFont font = workbook.createFont();
    font.setFontName("宋体");
    font.setFontHeightInPoints((short)24);
    font.setUnderline(HSSFFont.U_SINGLE);
    font.setBold(true);
    titleStyle.setFont(font);
    titleStyle.setAlignment(HorizontalAlignment.LEFT);
    titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);
    cellTitle.setCellStyle(titleStyle);

    HSSFRow rowDesc = sheet.createRow(++rowIdx);
    rowDesc.setHeightInPoints(21);
    CellRangeAddress cra2 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra2);
    HSSFCell cellDesc = rowDesc.createCell(0);
    cellDesc.setCellValue("产 品 订 购 合 同");
    CellStyle secondStyle = workbook.createCellStyle();
    HSSFFont secondFont = workbook.createFont();
    secondFont.setFontName("宋体");
    secondFont.setFontHeightInPoints((short)18);
    secondFont.setBold(true);
    secondStyle.setFont(secondFont);
    secondStyle.setVerticalAlignment(VerticalAlignment.CENTER);
    secondStyle.setAlignment(HorizontalAlignment.CENTER);
    cellDesc.setCellStyle(secondStyle);
    // 空行
    HSSFRow  nullRow = sheet.createRow(++rowIdx);
    nullRow.setHeightInPoints(21);

    //供需方
    HSSFRow row_1 = sheet.createRow(++rowIdx);
    row_1.setHeightInPoints(25);
    CellRangeAddress cra3 = new CellRangeAddress(rowIdx, rowIdx, 0, 5);
    CellRangeAddress cra4 = new CellRangeAddress(rowIdx, rowIdx, 6, 11);
    sheet.addMergedRegion(cra3);
    sheet.addMergedRegion(cra4);
    HSSFCellStyle style = workbook.createCellStyle();
    style.setVerticalAlignment(VerticalAlignment.CENTER);
    style.setAlignment(HorizontalAlignment.LEFT);
    HSSFFont thirdFont = workbook.createFont();
    thirdFont.setFontName("宋体");
    thirdFont.setFontHeightInPoints((short)12);
    thirdFont.setBold(true);
    style.setFont(thirdFont);
    style.setWrapText(true);
    HSSFCell cell_0 = row_1.createCell(0);
    cell_0.setCellValue("供方："+orderExDTO.getSupplierName());
    cell_0.setCellStyle(style);
    HSSFCell cell_6 = row_1.createCell(6);
    cell_6.setCellValue("合同编号："+orderExDTO.getPurchaseOrderNo());
    cell_6.setCellStyle(style);
    // 需方
    HSSFRow row_2 = sheet.createRow(++rowIdx);
    row_2.setHeightInPoints(25);
    CellRangeAddress cra5 = new CellRangeAddress(rowIdx, rowIdx, 0, 5);
    CellRangeAddress cra6 = new CellRangeAddress(rowIdx, rowIdx, 6, 11);
    sheet.addMergedRegion(cra5);
    sheet.addMergedRegion(cra6);
    HSSFCell cell_20 = row_2.createCell(0);
    cell_20.setCellValue("需方："+orderExDTO.getDemander());
    cell_20.setCellStyle(style);
    HSSFCell cell_26 = row_2.createCell(6);
    String confirmDate = DateFormatterUtils.formatterDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, orderExDTO.getConfirmTime());
    cell_26.setCellValue("签订日期："+confirmDate);
    cell_26.setCellStyle(style);
    // 说明
    HSSFRow row_3 = sheet.createRow(++rowIdx);
    row_3.setHeightInPoints(50);
    CellRangeAddress cra7 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra7);
    HSSFCell cell_30 = row_3.createCell(0);
    HSSFCellStyle cell30Style = workbook.createCellStyle();
    cell30Style.setFont(thirdFont);
    cell30Style.setVerticalAlignment(VerticalAlignment.CENTER);
    cell30Style.setAlignment(HorizontalAlignment.LEFT);
//    cell30Style.setIndention((short)2);
    cell_30.setCellValue("    为保障供需双方的合法权益,根据《中华人民共和国合同法》及相关法律规定,经友好协商,双方一致同意依下列条款签订本合同。");
    cell_30.setCellStyle(cell30Style);
//    HSSFRow row_4 = sheet.createRow(++rowIdx);
//    row_4.setHeightInPoints(25);
//    CellRangeAddress cra8 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
//    sheet.addMergedRegion(cra8);
//    HSSFCell cell_40 = row_4.createCell(0);
//    cell_40.setCellValue("协商,双方一致同意依下列条款签订本合同。");
//    cell_40.setCellStyle(style);
    // 一、供货内容
    HSSFRow row_5 = sheet.createRow(++rowIdx);
    row_5.setHeightInPoints(25);
    CellRangeAddress cra9 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra9);
    HSSFCell cell_50 = row_5.createCell(0);
    cell_50.setCellValue("一、供货内容（备库）");
    cell_50.setCellStyle(style);

    HSSFCellStyle border = workbook.createCellStyle();
    border.setBorderBottom(BorderStyle.THIN);
    border.setBorderLeft(BorderStyle.THIN);
    border.setBorderRight(BorderStyle.THIN);
    border.setBorderTop(BorderStyle.THIN);
    border.setWrapText(true);
    border.setAlignment(HorizontalAlignment.CENTER);
    border.setVerticalAlignment(VerticalAlignment.CENTER);
    border.setFont(thirdFont);

    for (int i = 0; i < itemExDTO.size() + 1; i++) {
      if (i == 0) {
        HSSFRow row = sheet.createRow(++rowIdx);
        row.setHeightInPoints(30);
        HSSFCell cell1 = row.createCell(0);
        cell1.setCellValue("序号");
        cell1.setCellStyle(border);
        HSSFCell cell2 = row.createCell(1);
        cell2.setCellValue("产品名称");
        cell2.setCellStyle(border);
        HSSFCell cell3 = row.createCell(2);
        cell3.setCellValue("图号");
        cell3.setCellStyle(border);
        HSSFCell cell4 = row.createCell(3);
        cell4.setCellValue("规格");
        cell4.setCellStyle(border);
        HSSFCell cell5 = row.createCell(4);
        cell5.setCellValue("材质");
        cell5.setCellStyle(border);
        HSSFCell cell6 = row.createCell(5);
        cell6.setCellValue("单位");
        cell6.setCellStyle(border);
        HSSFCell cell7 = row.createCell(6);
        cell7.setCellValue("数量");
        cell7.setCellStyle(border);
        HSSFCell cell8 = row.createCell(7);
        cell8.setCellValue("单重");
        cell8.setCellStyle(border);
        HSSFCell cell9 = row.createCell(8);
        cell9.setCellValue("总重");
        cell9.setCellStyle(border);
        HSSFCell cell10 = row.createCell(9);
        cell10.setCellValue("单价(元)");
        cell10.setCellStyle(border);
        HSSFCell cell011 = row.createCell(10);
        cell011.setCellValue("金额");
        cell011.setCellStyle(border);
        HSSFCell cell012 = row.createCell(11);
        cell012.setCellValue("备注");
        cell012.setCellStyle(border);
      } else {
        PurchaseOrderItemExDTO itemExDTO1 = itemExDTO.get(i - 1);
        HSSFRow row = sheet.createRow(++rowIdx);
        row.setHeightInPoints(30);
        HSSFCell cell1 = row.createCell(0);
        cell1.setCellValue(i);
        cell1.setCellStyle(border);
        HSSFCell cell2 = row.createCell(1);
        cell2.setCellValue(itemExDTO1.getMaterialName());
        cell2.setCellStyle(border);
        HSSFCell cell3 = row.createCell(2);
        cell3.setCellValue(itemExDTO1.getMaterialGraphNo());
        cell3.setCellStyle(border);
        HSSFCell cell4 = row.createCell(3);
        cell4.setCellValue(itemExDTO1.getSpecification());
        cell4.setCellStyle(border);
        HSSFCell cell5 = row.createCell(4);
        cell5.setCellValue(itemExDTO1.getMaterial());
        cell5.setCellStyle(border);
        HSSFCell cell6 = row.createCell(5);
        cell6.setCellValue(itemExDTO1.getUnit());
        cell6.setCellStyle(border);
        HSSFCell cell7 = row.createCell(6);
        cell7.setCellValue(itemExDTO1.getNumber());
        cell7.setCellStyle(border);
        HSSFCell cell8 = row.createCell(7);
        cell8.setCellValue(itemExDTO1.getUnitWeight().doubleValue());
        cell8.setCellStyle(border);
        HSSFCell cell9 = row.createCell(8);
        cell9.setCellValue(itemExDTO1.getTotalWeight());
        cell9.setCellStyle(border);
        HSSFCell cell10 = row.createCell(9);
        cell10.setCellValue(itemExDTO1.getUnitPrice().doubleValue());
        cell10.setCellStyle(border);
        HSSFCell cell011 = row.createCell(10);
        cell011.setCellValue(itemExDTO1.getTotalAmount());
        cell011.setCellStyle(border);
        HSSFCell cell012 = row.createCell(11);
        cell012.setCellValue(itemExDTO1.getRemark());
        cell012.setCellStyle(border);
      }
    }
    HSSFRow row7 = sheet.createRow(++rowIdx);
    row7.setHeightInPoints(30);
    CellRangeAddress cra15 = new CellRangeAddress(rowIdx, rowIdx, 0, 2);
    CellRangeAddress cra16 = new CellRangeAddress(rowIdx, rowIdx, 3, 5);
    sheet.addMergedRegion(cra15);
    sheet.addMergedRegion(cra16);
    HSSFCell cell71 = row7.createCell(0);
    cell71.setCellValue("合  计：");
    HSSFCellStyle totalStyle = workbook.createCellStyle();
    totalStyle.setBorderBottom(BorderStyle.THIN);
    totalStyle.setBorderLeft(BorderStyle.THIN);
    totalStyle.setBorderRight(BorderStyle.THIN);
    totalStyle.setBorderTop(BorderStyle.THIN);
    totalStyle.setWrapText(true);
    totalStyle.setAlignment(HorizontalAlignment.RIGHT);
    totalStyle.setVerticalAlignment(VerticalAlignment.CENTER);
    totalStyle.setFont(thirdFont);
    cell71.setCellStyle(totalStyle);
    HSSFCell cell72 = row7.createCell(6);
    HSSFCell cell73 = row7.createCell(7);
    cell73.setCellStyle(border);
    HSSFCell cell74 = row7.createCell(8);
    HSSFCell cell75 = row7.createCell(9);
    cell75.setCellStyle(border);
    HSSFCell cell76 = row7.createCell(10);
    HSSFCell cell77 = row7.createCell(11);
    cell72.setCellValue(orderExDTO.getOrderNumber());
    cell72.setCellStyle(border);
    cell74.setCellValue(orderExDTO.getTotalWeight());
    cell74.setCellStyle(border);
    cell76.setCellValue(orderExDTO.getTotalPrice());
    cell76.setCellStyle(border);
    cell77.setCellValue("按图纸加工");
    cell77.setCellStyle(border);
    HSSFRow row8 = sheet.createRow(++rowIdx);
    row8.setHeightInPoints(30);
    CellRangeAddress cra17 = new CellRangeAddress(rowIdx, rowIdx, 0, 2);
    CellRangeAddress cra18 = new CellRangeAddress(rowIdx, rowIdx, 3, 10);
    sheet.addMergedRegion(cra17);
    sheet.addMergedRegion(cra18);
    HSSFCell cell81 = row8.createCell(0);
    cell81.setCellValue("人 民 币 大 写：");
    cell81.setCellStyle(totalStyle);
    HSSFCell cell82 = row8.createCell(3);
    String totalAmount = UpperMoney.upper(String.valueOf(orderExDTO.getTotalPrice()));
    cell82.setCellValue(totalAmount);
    cell82.setCellStyle(border);
    HSSFCell cell83 = row8.createCell(11);
    cell83.setCellValue("以上含税价");
    cell83.setCellStyle(border);

    RegionUtil.setBorderBottom(BorderStyle.THIN, cra15, sheet);
    RegionUtil.setBorderLeft(BorderStyle.THIN, cra15, sheet);

    RegionUtil.setBorderBottom(BorderStyle.THIN, cra16, sheet);
    RegionUtil.setBorderRight(BorderStyle.THIN, cra16, sheet);

    RegionUtil.setBorderBottom(BorderStyle.THIN, cra17, sheet);
    RegionUtil.setBorderLeft(BorderStyle.THIN, cra17, sheet);
    RegionUtil.setBorderRight(BorderStyle.THIN, cra17, sheet);

    RegionUtil.setBorderBottom(BorderStyle.THIN, cra18, sheet);
    RegionUtil.setBorderLeft(BorderStyle.THIN, cra18, sheet);
    RegionUtil.setBorderRight(BorderStyle.THIN, cra18, sheet);

    // 二、
    HSSFFont hssfFont = workbook.createFont();
    hssfFont.setFontName("宋体");
    hssfFont.setFontHeightInPoints((short)14);
    hssfFont.setBold(true);
    // style left
    HSSFCellStyle leftStyle = workbook.createCellStyle();
    leftStyle.setVerticalAlignment(VerticalAlignment.CENTER);
    leftStyle.setAlignment(HorizontalAlignment.LEFT);
    leftStyle.setWrapText(true);
    leftStyle.setFont(hssfFont);
    // style right
    HSSFCellStyle rightStyle = workbook.createCellStyle();
    rightStyle.setVerticalAlignment(VerticalAlignment.CENTER);
    rightStyle.setAlignment(HorizontalAlignment.RIGHT);
    rightStyle.setFont(hssfFont);

    HSSFRow row3 = sheet.createRow(++rowIdx);
    row3.setHeightInPoints(25);
    CellRangeAddress cra19 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra19);
    HSSFCell cell31 = row3.createCell(0);
    cell31.setCellValue("二、交货时间、地点、方式:");
    cell31.setCellStyle(leftStyle);
    //1 2
    HSSFRow row4 = sheet.createRow(++rowIdx);
    row4.setHeightInPoints(25);
    CellRangeAddress cra20 = new CellRangeAddress(rowIdx, rowIdx, 0, 5);
    CellRangeAddress cra21 = new CellRangeAddress(rowIdx, rowIdx, 6, 11);
    sheet.addMergedRegion(cra20);
    sheet.addMergedRegion(cra21);
    HSSFCell cell41 = row4.createCell(0);
    String deliveryDate = DateFormatterUtils.formatterDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, orderExDTO.getDeliveryTime());
    cell41.setCellValue("1、到货日期："+deliveryDate);
    cell41.setCellStyle(leftStyle);
    HSSFCell cell46 = row4.createCell(6);
    cell46.setCellValue("2、交货方式：送货上门至山西工厂");
    cell46.setCellStyle(leftStyle);
    // 3 4
    HSSFRow row5 = sheet.createRow(++rowIdx);
    row5.setHeightInPoints(25);
    CellRangeAddress cra22 = new CellRangeAddress(rowIdx, rowIdx, 0, 5);
    CellRangeAddress cra23 = new CellRangeAddress(rowIdx, rowIdx, 6, 11);
    sheet.addMergedRegion(cra22);
    sheet.addMergedRegion(cra23);
    HSSFCell cell50 = row5.createCell(0);
    cell50.setCellValue("3、运输费用承担：供方");
    cell50.setCellStyle(leftStyle);
    HSSFCell cell56 = row5.createCell(6);
    cell56.setCellValue("4、收货人："+orderExDTO.getDemanderLinkman()+"（"+orderExDTO.getDemanderPhone()+"）");
    cell56.setCellStyle(leftStyle);
    HSSFRow row6 = sheet.createRow(++rowIdx);
    row6.setHeightInPoints(25);
    CellRangeAddress cra24 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra24);
    HSSFCell cell60 = row6.createCell(0);
    cell60.setCellValue("5、供方在需方检验合格后开具等值发票，需方于收到发票后60天内付清货款。");
    cell60.setCellStyle(leftStyle);
    HSSFRow row10 = sheet.createRow(++rowIdx);
    row10.setHeightInPoints(25);
    CellRangeAddress cra25 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra25);
    HSSFCell cell70 = row10.createCell(0);
    cell70.setCellValue("6、合同盖章后扫描回传。");
    cell70.setCellStyle(leftStyle);
    // 三、
    HSSFRow row11 = sheet.createRow(++rowIdx);
    row11.setHeightInPoints(25);
    CellRangeAddress cra26 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra26);
    HSSFCell cell110 = row11.createCell(0);
    cell110.setCellValue("三、质量保证：");
    cell110.setCellStyle(leftStyle);

    HSSFRow row12 = sheet.createRow(++rowIdx);
    row12.setHeightInPoints(25);
    CellRangeAddress cra27 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra27);
    HSSFCell cell120 = row12.createCell(0);
    cell120.setCellValue("1、产品执行企业技术标准，严格按生产图纸及技术要求组织生产及验收。");
    cell120.setCellStyle(leftStyle);

    HSSFRow row13 = sheet.createRow(++rowIdx);
    row13.setHeightInPoints(25);
    CellRangeAddress cra28 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra28);
    HSSFCell cell130 = row13.createCell(0);
    cell130.setCellValue("2、供方应提供产品材质报告单、机械性能报告及产品合格证，确保产品质量。");
    cell130.setCellStyle(leftStyle);

    HSSFRow row14 = sheet.createRow(++rowIdx);
    row14.setHeightInPoints(25);
    CellRangeAddress cra29 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra29);
    HSSFCell cell140 = row14.createCell(0);
    cell140.setCellValue("3、供方对所供产品质量负责，因供方产品质量问题产生的相关费用及损失由供方承担。");
    cell140.setCellStyle(leftStyle);

    HSSFRow row15 = sheet.createRow(++rowIdx);
    row15.setHeightInPoints(25);
    CellRangeAddress cra30 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra30);
    HSSFCell cell150 = row15.createCell(0);
    cell150.setCellValue("4、本合同一式两份,双方各执一份，如有争议双方协商解决，协商不果可向需方所在地人民法院提请诉讼。");
    cell150.setCellStyle(leftStyle);

    HSSFRow row16 = sheet.createRow(++rowIdx);
    row16.setHeightInPoints(25);
    CellRangeAddress cra31 = new CellRangeAddress(rowIdx, rowIdx, 0, 5);
    CellRangeAddress cra32 = new CellRangeAddress(rowIdx, rowIdx, 6, 11);
    sheet.addMergedRegion(cra31);
    sheet.addMergedRegion(cra32);
    HSSFCell cell160 = row16.createCell(0);
    cell160.setCellValue("需  方："+orderExDTO.getDemander());
    cell160.setCellStyle(leftStyle);
    HSSFCell cell166 = row16.createCell(6);
    cell166.setCellValue("供  方："+orderExDTO.getSupplierName());
    cell166.setCellStyle(leftStyle);

    HSSFRow row17 = sheet.createRow(++rowIdx);
    row17.setHeightInPoints(25);
    CellRangeAddress cra33 = new CellRangeAddress(rowIdx, rowIdx, 0, 5);
    CellRangeAddress cra34 = new CellRangeAddress(rowIdx, rowIdx, 6, 11);
    sheet.addMergedRegion(cra33);
    sheet.addMergedRegion(cra34);
    HSSFCell cell170 = row17.createCell(0);
    cell170.setCellValue("法定代表人：");
    cell170.setCellStyle(leftStyle);
    HSSFCell cell176 = row17.createCell(6);
    cell176.setCellValue("法定代表人：");
    cell176.setCellStyle(leftStyle);

    HSSFRow row18 = sheet.createRow(++rowIdx);
    row18.setHeightInPoints(25);
    CellRangeAddress cra35 = new CellRangeAddress(rowIdx, rowIdx, 0, 5);
    CellRangeAddress cra36 = new CellRangeAddress(rowIdx, rowIdx, 6, 11);
    sheet.addMergedRegion(cra35);
    sheet.addMergedRegion(cra36);
    HSSFCell cell180 = row18.createCell(0);
    cell180.setCellValue("委托代理人：");
    cell180.setCellStyle(leftStyle);
    HSSFCell cell186 = row18.createCell(6);
    cell186.setCellValue("委托代理人：");
    cell186.setCellStyle(leftStyle);

    HSSFRow row19 = sheet.createRow(++rowIdx);
    row19.setHeightInPoints(25);
    CellRangeAddress cra37 = new CellRangeAddress(rowIdx, rowIdx, 0, 5);
    CellRangeAddress cra38 = new CellRangeAddress(rowIdx, rowIdx, 6, 11);
    sheet.addMergedRegion(cra37);
    sheet.addMergedRegion(cra38);
    HSSFCell cell190 = row19.createCell(0);
    cell190.setCellValue("电  话:"+orderExDTO.getDemanderPhone());
    cell190.setCellStyle(leftStyle);
    HSSFCell cell196 = row19.createCell(6);
    cell196.setCellValue("电  话:"+orderExDTO.getSuppilerPhone());
    cell196.setCellStyle(leftStyle);

    HSSFRow row20 = sheet.createRow(++rowIdx);
    row20.setHeightInPoints(25);
    CellRangeAddress cra39 = new CellRangeAddress(rowIdx, rowIdx, 0, 5);
    CellRangeAddress cra40 = new CellRangeAddress(rowIdx, rowIdx, 6, 11);
    sheet.addMergedRegion(cra39);
    sheet.addMergedRegion(cra40);
    HSSFCell cell200 = row20.createCell(0);
    cell200.setCellValue("传  真: ");
    cell200.setCellStyle(leftStyle);
    HSSFCell cell206 = row20.createCell(6);
    cell206.setCellValue("传  真: ");
    cell206.setCellStyle(leftStyle);

    HSSFRow row21 = sheet.createRow(++rowIdx);
    row21.setHeightInPoints(25);
    CellRangeAddress cra41 = new CellRangeAddress(rowIdx, rowIdx, 0, 5);
    CellRangeAddress cra42 = new CellRangeAddress(rowIdx, rowIdx, 6, 11);
    sheet.addMergedRegion(cra41);
    sheet.addMergedRegion(cra42);
    HSSFCell cell210 = row21.createCell(0);
    cell210.setCellValue("地  址:"+orderExDTO.getDemanderAddr());
    cell210.setCellStyle(leftStyle);
    HSSFCell cell216 = row21.createCell(6);
    cell216.setCellValue("地  址:"+ orderExDTO.getSupplierAddr());
    cell216.setCellStyle(leftStyle);

    HSSFRow row22 = sheet.createRow(++rowIdx);
    row22.setHeightInPoints(25);
    CellRangeAddress cra43 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra43);
    HSSFCell cell220 = row22.createCell(0);
    cell220.setCellValue("本订购合同供方、需方签字、盖章生效。");
    HSSFCellStyle tailStyle = workbook.createCellStyle();
    tailStyle.setAlignment(HorizontalAlignment.CENTER);
    tailStyle.setVerticalAlignment(VerticalAlignment.CENTER);
    HSSFFont tailFont = workbook.createFont();
    tailFont.setBold(true);
    tailFont.setFontHeightInPoints((short)16);
    tailFont.setFontName("宋体");
    tailStyle.setFont(tailFont);
    cell220.setCellStyle(tailStyle);


    // 单元格自动列宽
    sheet.autoSizeColumn(0, true);
    sheet.autoSizeColumn(1, true);
    sheet.autoSizeColumn(2, true);
    sheet.autoSizeColumn(3, true);
    sheet.autoSizeColumn(4, true);
    sheet.autoSizeColumn(5, true);
    sheet.autoSizeColumn(6, true);
    sheet.autoSizeColumn(7, true);
    sheet.autoSizeColumn(8, true);
    sheet.autoSizeColumn(9, true);
    sheet.autoSizeColumn(10, true);
    sheet.autoSizeColumn(11, true);

    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    String fileUrl = "";
    try {
      workbook.write(bos);
      byte[] bytes = bos.toByteArray();
      fileUrl = QiniuUtil
          .uploadFile(bytes, System.currentTimeMillis() + "_" + orderExDTO.getPurchaseOrderNo() + ".xlsx");
    } catch (IOException e) {
      log.error("create excel workbook fail.", e);
    }

    PurchaseOrder purchaseOrder = new PurchaseOrder();
    purchaseOrder.setFileUrl(fileUrl);
    PurchaseOrderExample example = new PurchaseOrderExample();
    example.createCriteria().andIdEqualTo(formId);
    purchaseOrderMapper.updateByExampleSelective(purchaseOrder, example);
  }


}
