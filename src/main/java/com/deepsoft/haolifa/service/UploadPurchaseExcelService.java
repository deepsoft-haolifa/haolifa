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
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet;
    if (orderExDTO.getOrderType() == 0) {
      sheet = workbook.createSheet("采购订单");
    } else {
      sheet = workbook.createSheet("机加工订单");
    }

    // 单元格样式
    CellStyle center = workbook.createCellStyle();
    center.setAlignment(HorizontalAlignment.CENTER);

    CellStyle right = workbook.createCellStyle();
    right.setAlignment(HorizontalAlignment.RIGHT);

    CellStyle border = workbook.createCellStyle();
    border.setBorderBottom(BorderStyle.THIN);
    border.setBorderLeft(BorderStyle.THIN);
    border.setBorderRight(BorderStyle.THIN);
    border.setBorderTop(BorderStyle.THIN);

//    sheet.setDefaultRowHeightInPoints(40);
//    sheet.setDefaultColumnStyle(0, border);
//    sheet.setDefaultColumnStyle(1, border);
//    sheet.setDefaultColumnStyle(2, border);
//    sheet.setDefaultColumnStyle(3, border);
//    sheet.setDefaultColumnStyle(4, border);
//    sheet.setDefaultColumnStyle(5, border);
//    sheet.setDefaultColumnStyle(6, border);
//    sheet.setDefaultColumnStyle(7, border);
//    sheet.setDefaultColumnStyle(8, border);
//    sheet.setDefaultColumnStyle(9, border);
//    sheet.setDefaultColumnStyle(10, border);
//    sheet.setDefaultColumnStyle(11, border);

    CellStyle cellStyle = workbook.createCellStyle();
    cellStyle.setWrapText(true);

    int rowIdx = 0;
    XSSFRow rowTitle = sheet.createRow(rowIdx);
    CellRangeAddress cra1 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra1);
    XSSFCell cellTitle = rowTitle.createCell(0);
    cellTitle.setCellValue("山西好利阀机械制造有限公司");
    cellTitle.setCellStyle(center);
    cellTitle.setCellStyle(border);

    XSSFRow rowDesc = sheet.createRow(++rowIdx);
    CellRangeAddress cra2 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra2);
    XSSFCell cellDesc = rowDesc.createCell(0);
    cellDesc.setCellValue("山西省临汾市侯马经济技术开发区旺旺北至路东侧");
    cellTitle.setCellStyle(center);

    XSSFRow rowType = sheet.createRow(++rowIdx);
    CellRangeAddress cra3 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra3);
    XSSFCell cellType = rowType.createCell(0);
    if(orderExDTO.getOrderType() == 0) {
      cellType.setCellValue("采 购 订 单");
    } else {
      cellType.setCellValue("机 加 工 订 单");
    }
    cellTitle.setCellStyle(center);

    XSSFRow row1 = sheet.createRow(++rowIdx);
    CellRangeAddress cra4 = new CellRangeAddress(rowIdx, rowIdx, 0, 5);
    sheet.addMergedRegion(cra4);
    XSSFCell cell11 = row1.createCell(0);
    cell11.setCellValue("订单号：" + orderExDTO.getPurchaseOrderNo());
    CellRangeAddress cra5 = new CellRangeAddress(rowIdx, rowIdx, 6, 11);
    sheet.addMergedRegion(cra5);
    XSSFCell cell12 = row1.createCell(6);
    Date createTime = orderExDTO.getCreateTime();
    String createDateValue = "";
    if (createTime != null) {
      createDateValue = DateFormatterUtils.formatterDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, createTime);
    }
    cell12.setCellValue("下单日期：" + createDateValue);

    XSSFRow row2 = sheet.createRow(++rowIdx);
    CellRangeAddress cra6 = new CellRangeAddress(rowIdx, rowIdx, 0, 5);
    sheet.addMergedRegion(cra6);
    XSSFCell cell21 = row2.createCell(0);
    cell21.setCellValue("供方：" + orderExDTO.getSupplierName());
    CellRangeAddress cra7 = new CellRangeAddress(rowIdx, rowIdx, 6, 11);
    sheet.addMergedRegion(cra7);
    XSSFCell cell22 = row2.createCell(6);
    cell22.setCellValue("需方：" + orderExDTO.getDemander());

    XSSFRow row3 = sheet.createRow(++rowIdx);
    CellRangeAddress cra8 = new CellRangeAddress(rowIdx, rowIdx, 0, 5);
    sheet.addMergedRegion(cra8);
    XSSFCell cell31 = row3.createCell(0);
    cell31.setCellValue("联系人：" + orderExDTO.getSupplierLinkman());
    CellRangeAddress cra9 = new CellRangeAddress(rowIdx, rowIdx, 6, 11);
    sheet.addMergedRegion(cra9);
    XSSFCell cell32 = row3.createCell(6);
    cell32.setCellValue("联系人：" + orderExDTO.getDemander());

    XSSFRow row4 = sheet.createRow(++rowIdx);
    CellRangeAddress cra10 = new CellRangeAddress(rowIdx, rowIdx, 0, 5);
    sheet.addMergedRegion(cra10);
    XSSFCell cell41 = row4.createCell(0);
    cell41.setCellValue("联系电话：" + orderExDTO.getSuppilerPhone());

    CellRangeAddress cra11 = new CellRangeAddress(rowIdx, rowIdx, 6, 11);
    sheet.addMergedRegion(cra11);
    XSSFCell cell42 = row4.createCell(6);
    cell42.setCellValue("联系电话：" + orderExDTO.getDemanderPhone());

    XSSFRow row5 = sheet.createRow(++rowIdx);
    CellRangeAddress cra12 = new CellRangeAddress(rowIdx, rowIdx, 0, 5);
    sheet.addMergedRegion(cra12);
    XSSFCell cell51 = row5.createCell(0);
    cell51.setCellValue("供方地址：" + orderExDTO.getSupplierAddr());

    CellRangeAddress cra13 = new CellRangeAddress(rowIdx, rowIdx, 6, 11);
    sheet.addMergedRegion(cra13);
    XSSFCell cell52 = row5.createCell(6);
    cell52.setCellValue("需方地址：" + orderExDTO.getDemanderAddr());

    XSSFRow row6 = sheet.createRow(++rowIdx);
    CellRangeAddress cra14 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra14);
    XSSFCell cell61 = row6.createCell(0);
    cell61.setCellValue("兹向贵公司订购以下货品（如下表所列），请于24小时内签字回传！");

    for (int i = 0; i < itemExDTO.size() + 1; i++) {
      if (i == 0) {
        XSSFRow row = sheet.createRow(++rowIdx);
        XSSFCell cell1 = row.createCell(0);
        cell1.setCellValue("序号");
        XSSFCell cell2 = row.createCell(1);
        cell2.setCellValue("产品名称");
        XSSFCell cell3 = row.createCell(2);
        cell3.setCellValue("图号");
        XSSFCell cell4 = row.createCell(3);
        cell4.setCellValue("规格");
        XSSFCell cell5 = row.createCell(4);
        cell5.setCellValue("材质");
        XSSFCell cell6 = row.createCell(5);
        cell6.setCellValue("单位");
        XSSFCell cell7 = row.createCell(6);
        cell7.setCellValue("数量");
        XSSFCell cell8 = row.createCell(7);
        cell8.setCellValue("单重");
        XSSFCell cell9 = row.createCell(8);
        cell9.setCellValue("总重");
        XSSFCell cell10 = row.createCell(9);
        cell10.setCellValue("单价");
        XSSFCell cell011 = row.createCell(10);
        cell011.setCellValue("金额");
        XSSFCell cell012 = row.createCell(11);
        cell012.setCellValue("备注");
      } else {
        PurchaseOrderItemExDTO itemExDTO1 = itemExDTO.get(i - 1);
        XSSFRow row = sheet.createRow(++rowIdx);
        XSSFCell cell1 = row.createCell(0);
        cell1.setCellValue(i);
        XSSFCell cell2 = row.createCell(1);
        cell2.setCellValue(itemExDTO1.getMaterialName());
        XSSFCell cell3 = row.createCell(2);
        cell3.setCellValue(itemExDTO1.getMaterialGraphNo());
        XSSFCell cell4 = row.createCell(3);
        cell4.setCellValue(itemExDTO1.getSpecification());
        XSSFCell cell5 = row.createCell(4);
        cell5.setCellValue(itemExDTO1.getMaterial());
        XSSFCell cell6 = row.createCell(5);
        cell6.setCellValue(itemExDTO1.getUnit());
        XSSFCell cell7 = row.createCell(6);
        cell7.setCellValue(itemExDTO1.getNumber());
        XSSFCell cell8 = row.createCell(7);
        cell8.setCellValue(itemExDTO1.getUnitWeight().doubleValue());
        XSSFCell cell9 = row.createCell(8);
        cell9.setCellValue(itemExDTO1.getTotalWeight());
        XSSFCell cell10 = row.createCell(9);
        cell10.setCellValue(itemExDTO1.getUnitPrice().doubleValue());
        XSSFCell cell011 = row.createCell(10);
        cell011.setCellValue(itemExDTO1.getTotalAmount());
        XSSFCell cell012 = row.createCell(11);
        cell012.setCellValue(itemExDTO1.getRemark());
      }
    }
    XSSFRow row7 = sheet.createRow(++rowIdx);
    CellRangeAddress cra15 = new CellRangeAddress(rowIdx, rowIdx, 0, 5);
    sheet.addMergedRegion(cra15);
    XSSFCell cell71 = row7.createCell(0);
    cell71.setCellValue("合计");
    XSSFCell cell72 = row7.createCell(6);
    XSSFCell cell73 = row7.createCell(7);
    XSSFCell cell74 = row7.createCell(8);
    XSSFCell cell75 = row7.createCell(9);
    XSSFCell cell76 = row7.createCell(10);
    XSSFCell cell77 = row7.createCell(11);
    cell72.setCellValue(orderExDTO.getOrderNumber());
    cell74.setCellValue(orderExDTO.getTotalWeight());
    cell76.setCellValue(orderExDTO.getTotalAmount());
    XSSFRow row8 = sheet.createRow(++rowIdx);
    CellRangeAddress cra16 = new CellRangeAddress(rowIdx, rowIdx, 0, 5);
    sheet.addMergedRegion(cra16);
    XSSFCell cell81 = row8.createCell(0);
    cell81.setCellValue("人民币大写");
    XSSFCell cell82 = row8.createCell(10);
    cell82.setCellValue(UpperMoney.upper(String.valueOf(orderExDTO.getTotalAmount())));
    XSSFRow row9 = sheet.createRow(++rowIdx);
    CellRangeAddress cra17 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra17);
    row9.setHeightInPoints(35);
    XSSFCell cell91 = row9.createCell(0);
    Date deliveryTime = orderExDTO.getDeliveryTime();
    String dateValue = "";
    if (deliveryTime != null) {
      dateValue = DateFormatterUtils.formatterDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, deliveryTime);
    }
    cell91.setCellValue("1、交货日期：" + dateValue + "。供方须严格按交期交货，如需调整日期，须及时知会本公司并经本公司批准，否则延误交货须扣除该批货款10%。");
    cell91.setCellStyle(cellStyle);
    XSSFRow row10 = sheet.createRow(++rowIdx);
    CellRangeAddress cra18 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra18);
    row10.setHeightInPoints(35);
    XSSFCell cell101 = row10.createCell(0);
    cell101.setCellValue("2、品质：供方所供产品，应完全依照本公司提供的图纸及相关标准制造，本公司将依照同一标准抽样检查，拒收未经技术管理中心确认的任何来货；");
    cell101.setCellStyle(cellStyle);
    XSSFRow row11 = sheet.createRow(++rowIdx);
    CellRangeAddress cra19 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra19);
    XSSFCell cell111 = row11.createCell(0);
    cell111.setCellValue("3、付款方式：" + orderExDTO.getPayType());

    XSSFRow row12 = sheet.createRow(++rowIdx);
    CellRangeAddress cra20 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra20);
    XSSFCell cell121 = row12.createCell(0);
    cell121.setCellValue("4、付款条件：交货验收合格后，本公司于收到发票之日起60日内结清货款，每月25日以后交付货品拨归次月账项，请于本月30日前将对账单快递至本公司采购部，逾期送单将延至次月对账；");
    cell121.setCellStyle(cellStyle);
    row12.setHeightInPoints(55);
    XSSFRow row13 = sheet.createRow(++rowIdx);
    CellRangeAddress cra21 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra21);
    XSSFCell cell131 = row13.createCell(0);
    cell131.setCellValue("5、送货单须规范注明订单编号、产品名称、规格等，同时要注明欠货数量及补货日期；");
    cell131.setCellStyle(cellStyle);
    XSSFRow row14 = sheet.createRow(++rowIdx);
    CellRangeAddress cra22 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra22);
    XSSFCell cell141 = row14.createCell(0);
    cell141.setCellValue("6、送货时须附上相应的“机械性能报告”、“材质证明书”等相关证明；");
    cell141.setCellStyle(cellStyle);
    XSSFRow row15 = sheet.createRow(++rowIdx);
    CellRangeAddress cra23 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra23);
    XSSFCell cell151 = row15.createCell(0);
    cell151.setCellValue("7、如因来料品质不符或因交期延误，致使需方蒙受损失，责任全部由供方承担；");
    cell151.setCellStyle(cellStyle);
    XSSFRow row16 = sheet.createRow(++rowIdx);
    CellRangeAddress cra24 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra24);
    XSSFCell cell161 = row16.createCell(0);
    cell161.setCellValue("8、以上计划价格仅供参考，如有疑义，则以合同金额为准。");

    XSSFRow row17 = sheet.createRow(++rowIdx);
    CellRangeAddress cra25 = new CellRangeAddress(rowIdx, rowIdx, 0, 2);
    CellRangeAddress cra26 = new CellRangeAddress(rowIdx, rowIdx, 3, 6);
    CellRangeAddress cra27 = new CellRangeAddress(rowIdx, rowIdx, 7, 9);
    CellRangeAddress cra28 = new CellRangeAddress(rowIdx, rowIdx, 10, 11);
    sheet.addMergedRegion(cra25);
    sheet.addMergedRegion(cra26);
    sheet.addMergedRegion(cra27);
    sheet.addMergedRegion(cra28);
    XSSFCell cell171 = row17.createCell(0);
    XSSFCell cell172 = row17.createCell(3);
    XSSFCell cell173 = row17.createCell(7);
    XSSFCell cell174 = row17.createCell(10);
    cell171.setCellValue("供方确认：");
    cell172.setCellValue("批准：");
    cell173.setCellValue("审核：");
    cell174.setCellValue("经办：");

    XSSFRow row18 = sheet.createRow(++rowIdx);
    CellRangeAddress cra29 = new CellRangeAddress(rowIdx, rowIdx, 0, 2);
    CellRangeAddress cra30 = new CellRangeAddress(rowIdx, rowIdx, 3, 6);
    CellRangeAddress cra31 = new CellRangeAddress(rowIdx, rowIdx, 7, 9);
    CellRangeAddress cra32 = new CellRangeAddress(rowIdx, rowIdx, 10, 11);
    sheet.addMergedRegion(cra29);
    sheet.addMergedRegion(cra30);
    sheet.addMergedRegion(cra31);
    sheet.addMergedRegion(cra32);
    XSSFCell cell181 = row18.createCell(0);
    XSSFCell cell182 = row18.createCell(3);
    XSSFCell cell183 = row18.createCell(6);
    XSSFCell cell184 = row18.createCell(10);
    cell181.setCellValue("年  月  日");
    cell182.setCellValue("年  月  日");
    cell183.setCellValue("年  月  日");
    cell184.setCellValue("年  月  日");
    cell181.setCellStyle(right);
    cell182.setCellStyle(right);
    cell183.setCellStyle(right);
    cell184.setCellStyle(right);

//    sheet.autoSizeColumn(0, true);
//    sheet.autoSizeColumn(1, true);
//    sheet.autoSizeColumn(2, true);
//    sheet.autoSizeColumn(3, true);
//    sheet.autoSizeColumn(4, true);
//    sheet.autoSizeColumn(5, true);
//    sheet.autoSizeColumn(6, true);
//    sheet.autoSizeColumn(7, true);
//    sheet.autoSizeColumn(8, true);
//    sheet.autoSizeColumn(9, true);
//    sheet.autoSizeColumn(10, true);
//    sheet.autoSizeColumn(11, true);

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
