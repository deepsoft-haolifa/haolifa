package com.deepsoft.haolifa.controller;


import static com.deepsoft.haolifa.constant.CommonEnum.StorageType.MATERIAL;
import static com.deepsoft.haolifa.constant.CommonEnum.StorageType.PRODUCT;

import com.deepsoft.haolifa.annotation.LogNotPrint;
import com.deepsoft.haolifa.dao.repository.EntryOutStoreRecordMapper;
import com.deepsoft.haolifa.dao.repository.ExpensesMapper;
import com.deepsoft.haolifa.dao.repository.InspectHistoryMapper;
import com.deepsoft.haolifa.dao.repository.MaterialMapper;
import com.deepsoft.haolifa.dao.repository.ProInspectRecordMapper;
import com.deepsoft.haolifa.dao.repository.SprayInspectHistoryMapper;
import com.deepsoft.haolifa.model.domain.Entrust;
import com.deepsoft.haolifa.model.domain.EntryOutStoreRecord;
import com.deepsoft.haolifa.model.domain.EntryOutStoreRecordExample;
import com.deepsoft.haolifa.model.domain.Expenses;
import com.deepsoft.haolifa.model.domain.ExpensesExample;
import com.deepsoft.haolifa.model.domain.InspectHistory;
import com.deepsoft.haolifa.model.domain.InspectHistoryExample;
import com.deepsoft.haolifa.model.domain.Material;
import com.deepsoft.haolifa.model.domain.MaterialExample;
import com.deepsoft.haolifa.model.domain.ProInspectRecord;
import com.deepsoft.haolifa.model.domain.ProInspectRecordExample;
import com.deepsoft.haolifa.model.domain.SprayInspectHistory;
import com.deepsoft.haolifa.model.domain.SprayInspectHistoryExample;
import com.deepsoft.haolifa.model.dto.PurchaseOrderExDTO;
import com.deepsoft.haolifa.model.dto.PurchaseOrderItemExDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.export.ExportExpensesDTO;
import com.deepsoft.haolifa.model.dto.export.ExportMaterialEntryRoomDTO;
import com.deepsoft.haolifa.model.dto.export.ExportMaterialRecordDTO;
import com.deepsoft.haolifa.model.dto.export.ExportProductEntryRoomDTO;
import com.deepsoft.haolifa.model.dto.export.ExportProductOutRoomDTO;
import com.deepsoft.haolifa.model.dto.export.ExportSprayEntryRoomDTO;
import com.deepsoft.haolifa.model.dto.order.OrderMaterialDTO;
import com.deepsoft.haolifa.model.dto.order.OrderProductDTO;
import com.deepsoft.haolifa.model.dto.spray.SprayDto;
import com.deepsoft.haolifa.model.dto.spray.SprayItemDto;
import com.deepsoft.haolifa.service.EntrustService;
import com.deepsoft.haolifa.service.OrderProductService;
import com.deepsoft.haolifa.service.PurcahseOrderService;
import com.deepsoft.haolifa.service.SprayService;
import com.deepsoft.haolifa.util.DateFormatterUtils;
import com.deepsoft.haolifa.util.UpperMoney;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@LogNotPrint
@RestController
@RequestMapping("/export")
@Api(tags = "excel导出")
public class ExportExcelController {

  @Autowired
  private PurcahseOrderService purcahseOrderService;
  @Autowired
  private OrderProductService orderProductService;
  @Autowired
  private SprayService sprayService;

  @Autowired
  private EntrustService entrustService;

  @Autowired
  private SprayInspectHistoryMapper sprayInspectHistoryMapper;

  @Autowired
  private ExpensesMapper expensesMapper;

  @Autowired
  private InspectHistoryMapper inspectHistoryMapper;

  @Autowired
  private ProInspectRecordMapper proInspectRecordMapper;

  @Autowired
  private EntryOutStoreRecordMapper entryOutStoreRecordMapper;

  @Autowired
  private MaterialMapper materialMapper;

  @ApiOperation("导出采购订单")
  @GetMapping("/purchaseOrder/{formId}")
  public void purchaseOrder(HttpServletResponse response,
      @ApiParam(value = "订单id", required = true) @PathVariable("formId") Integer formId) throws IOException {
    ResultBean resultBean = purcahseOrderService.getInfo(formId);
    Map result = (Map<String, Object>) resultBean.getResult();
    PurchaseOrderExDTO orderExDTO = (PurchaseOrderExDTO) result.get("order");
    List<PurchaseOrderItemExDTO> itemExDTO = (List<PurchaseOrderItemExDTO>) result.get("items");
    response.setHeader("Content-Disposition", "attachment;filename=采购订单.xls");
    response.setContentType("application/octet-stream;");
    Workbook workbook = new HSSFWorkbook();
    Sheet sheet = workbook.createSheet("采购订单");

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
    sheet.setDefaultColumnStyle(0, border);
    sheet.setDefaultColumnStyle(1, border);
    sheet.setDefaultColumnStyle(2, border);
    sheet.setDefaultColumnStyle(3, border);
    sheet.setDefaultColumnStyle(4, border);
    sheet.setDefaultColumnStyle(5, border);
    sheet.setDefaultColumnStyle(6, border);
    sheet.setDefaultColumnStyle(7, border);
    sheet.setDefaultColumnStyle(8, border);
    sheet.setDefaultColumnStyle(9, border);
    sheet.setDefaultColumnStyle(10, border);
    sheet.setDefaultColumnStyle(11, border);

    CellStyle cellStyle = workbook.createCellStyle();
    cellStyle.setWrapText(true);

    int rowIdx = 0;
    Row rowTitle = sheet.createRow(rowIdx);
    CellRangeAddress cra1 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra1);
    Cell cellTitle = rowTitle.createCell(0);
    cellTitle.setCellValue("山西好利阀机械制造有限公司");
    cellTitle.setCellStyle(center);
    cellTitle.setCellStyle(border);

    Row rowDesc = sheet.createRow(++rowIdx);
    CellRangeAddress cra2 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra2);
    Cell cellDesc = rowDesc.createCell(0);
    cellDesc.setCellValue("山西省临汾市侯马经济技术开发区旺旺北至路东侧");
    cellTitle.setCellStyle(center);

    Row rowType = sheet.createRow(++rowIdx);
    CellRangeAddress cra3 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra3);
    Cell cellType = rowType.createCell(0);
    cellType.setCellValue("采 购 订 单");
    cellTitle.setCellStyle(center);

    Row row1 = sheet.createRow(++rowIdx);
    CellRangeAddress cra4 = new CellRangeAddress(rowIdx, rowIdx, 0, 5);
    sheet.addMergedRegion(cra4);
    Cell cell11 = row1.createCell(0);
    cell11.setCellValue("订单号：" + orderExDTO.getPurchaseOrderNo());
    CellRangeAddress cra5 = new CellRangeAddress(rowIdx, rowIdx, 6, 11);
    sheet.addMergedRegion(cra5);
    Cell cell12 = row1.createCell(6);
    Date createTime = orderExDTO.getCreateTime();
    String createDateValue = "";
    if (createTime != null) {
      createDateValue = DateFormatterUtils.formatterDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, createTime);
    }
    cell12.setCellValue("下单日期：" + createDateValue);

    Row row2 = sheet.createRow(++rowIdx);
    CellRangeAddress cra6 = new CellRangeAddress(rowIdx, rowIdx, 0, 5);
    sheet.addMergedRegion(cra6);
    Cell cell21 = row2.createCell(0);
    cell21.setCellValue("供方：" + orderExDTO.getSupplierName());
    CellRangeAddress cra7 = new CellRangeAddress(rowIdx, rowIdx, 6, 11);
    sheet.addMergedRegion(cra7);
    Cell cell22 = row2.createCell(6);
    cell22.setCellValue("需方：" + orderExDTO.getDemander());

    Row row3 = sheet.createRow(++rowIdx);
    CellRangeAddress cra8 = new CellRangeAddress(rowIdx, rowIdx, 0, 5);
    sheet.addMergedRegion(cra8);
    Cell cell31 = row3.createCell(0);
    cell31.setCellValue("联系人：" + orderExDTO.getSupplierLinkman());
    CellRangeAddress cra9 = new CellRangeAddress(rowIdx, rowIdx, 6, 11);
    sheet.addMergedRegion(cra9);
    Cell cell32 = row3.createCell(6);
    cell32.setCellValue("联系人：" + orderExDTO.getDemander());

    Row row4 = sheet.createRow(++rowIdx);
    CellRangeAddress cra10 = new CellRangeAddress(rowIdx, rowIdx, 0, 5);
    sheet.addMergedRegion(cra10);
    Cell cell41 = row4.createCell(0);
    cell41.setCellValue("联系电话：" + orderExDTO.getSuppilerPhone());

    CellRangeAddress cra11 = new CellRangeAddress(rowIdx, rowIdx, 6, 11);
    sheet.addMergedRegion(cra11);
    Cell cell42 = row4.createCell(6);
    cell42.setCellValue("联系电话：" + orderExDTO.getDemanderPhone());

    Row row5 = sheet.createRow(++rowIdx);
    CellRangeAddress cra12 = new CellRangeAddress(rowIdx, rowIdx, 0, 5);
    sheet.addMergedRegion(cra12);
    Cell cell51 = row5.createCell(0);
    cell51.setCellValue("供方地址：" + orderExDTO.getSupplierAddr());

    CellRangeAddress cra13 = new CellRangeAddress(rowIdx, rowIdx, 6, 11);
    sheet.addMergedRegion(cra13);
    Cell cell52 = row5.createCell(6);
    cell52.setCellValue("需方地址：" + orderExDTO.getDemanderAddr());

    Row row6 = sheet.createRow(++rowIdx);
    CellRangeAddress cra14 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra14);
    Cell cell61 = row6.createCell(0);
    cell61.setCellValue("兹向贵公司订购以下货品（如下表所列），请于24小时内签字回传！");

    for (int i = 0; i < itemExDTO.size() + 1; i++) {
      if (i == 0) {
        Row row = sheet.createRow(++rowIdx);
        Cell cell1 = row.createCell(0);
        cell1.setCellValue("序号");
        Cell cell2 = row.createCell(1);
        cell2.setCellValue("产品名称");
        Cell cell3 = row.createCell(2);
        cell3.setCellValue("图号");
        Cell cell4 = row.createCell(3);
        cell4.setCellValue("规格");
        Cell cell5 = row.createCell(4);
        cell5.setCellValue("材质");
        Cell cell6 = row.createCell(5);
        cell6.setCellValue("单位");
        Cell cell7 = row.createCell(6);
        cell7.setCellValue("数量");
        Cell cell8 = row.createCell(7);
        cell8.setCellValue("单重");
        Cell cell9 = row.createCell(8);
        cell9.setCellValue("总重");
        Cell cell10 = row.createCell(9);
        cell10.setCellValue("单价");
        Cell cell011 = row.createCell(10);
        cell011.setCellValue("金额");
        Cell cell012 = row.createCell(11);
        cell012.setCellValue("备注");
      } else {
        PurchaseOrderItemExDTO itemExDTO1 = itemExDTO.get(i - 1);
        Row row = sheet.createRow(++rowIdx);
        Cell cell1 = row.createCell(0);
        cell1.setCellValue(i);
        Cell cell2 = row.createCell(1);
        cell2.setCellValue(itemExDTO1.getMaterialName());
        Cell cell3 = row.createCell(2);
        cell3.setCellValue(itemExDTO1.getMaterialGraphNo());
        Cell cell4 = row.createCell(3);
        cell4.setCellValue(itemExDTO1.getSpecification());
        Cell cell5 = row.createCell(4);
        cell5.setCellValue(itemExDTO1.getMaterial());
        Cell cell6 = row.createCell(5);
        cell6.setCellValue(itemExDTO1.getUnit());
        Cell cell7 = row.createCell(6);
        cell7.setCellValue(itemExDTO1.getNumber());
        Cell cell8 = row.createCell(7);
        cell8.setCellValue(itemExDTO1.getUnitWeight().doubleValue());
        Cell cell9 = row.createCell(8);
        cell9.setCellValue(itemExDTO1.getTotalWeight());
        Cell cell10 = row.createCell(9);
        cell10.setCellValue(itemExDTO1.getUnitPrice().doubleValue());
        Cell cell011 = row.createCell(10);
        cell011.setCellValue(itemExDTO1.getTotalAmount());
        Cell cell012 = row.createCell(11);
        cell012.setCellValue(itemExDTO1.getRemark());
      }
    }
    Row row7 = sheet.createRow(++rowIdx);
    CellRangeAddress cra15 = new CellRangeAddress(rowIdx, rowIdx, 0, 5);
    sheet.addMergedRegion(cra15);
    Cell cell71 = row7.createCell(0);
    cell71.setCellValue("合计");
    Cell cell72 = row7.createCell(6);
    Cell cell73 = row7.createCell(7);
    Cell cell74 = row7.createCell(8);
    Cell cell75 = row7.createCell(9);
    Cell cell76 = row7.createCell(10);
    Cell cell77 = row7.createCell(11);
    cell72.setCellValue(orderExDTO.getOrderNumber());
    cell74.setCellValue(orderExDTO.getTotalWeight());
    cell76.setCellValue(orderExDTO.getTotalPrice());
    Row row8 = sheet.createRow(++rowIdx);
    CellRangeAddress cra16 = new CellRangeAddress(rowIdx, rowIdx, 0, 5);
    sheet.addMergedRegion(cra16);
    Cell cell81 = row8.createCell(0);
    cell81.setCellValue("人民币大写");
    Cell cell82 = row8.createCell(10);
    cell82.setCellValue(UpperMoney.upper(String.valueOf(orderExDTO.getTotalPrice())));
    Row row9 = sheet.createRow(++rowIdx);
    CellRangeAddress cra17 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra17);
    row9.setHeightInPoints(35);
    Cell cell91 = row9.createCell(0);
    Date deliveryTime = orderExDTO.getDeliveryTime();
    String dateValue = "";
    if (deliveryTime != null) {
      dateValue = DateFormatterUtils.formatterDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, deliveryTime);
    }
    cell91.setCellValue("1、交货日期：" + dateValue + "。供方须严格按交期交货，如需调整日期，须及时知会本公司并经本公司批准，否则延误交货须扣除该批货款10%。");
    cell91.setCellStyle(cellStyle);
    Row row10 = sheet.createRow(++rowIdx);
    CellRangeAddress cra18 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra18);
    row10.setHeightInPoints(35);
    Cell cell101 = row10.createCell(0);
    cell101.setCellValue("2、品质：供方所供产品，应完全依照本公司提供的图纸及相关标准制造，本公司将依照同一标准抽样检查，拒收未经技术管理中心确认的任何来货；");
    cell101.setCellStyle(cellStyle);
    Row row11 = sheet.createRow(++rowIdx);
    CellRangeAddress cra19 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra19);
    Cell cell111 = row11.createCell(0);
    cell111.setCellValue("3、付款方式：" + orderExDTO.getPayType());

    Row row12 = sheet.createRow(++rowIdx);
    CellRangeAddress cra20 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra20);
    Cell cell121 = row12.createCell(0);
    cell121.setCellValue("4、付款条件：交货验收合格后，本公司于收到发票之日起60日内结清货款，每月25日以后交付货品拨归次月账项，请于本月30日前将对账单快递至本公司采购部，逾期送单将延至次月对账；");
    cell121.setCellStyle(cellStyle);
    row12.setHeightInPoints(55);
    Row row13 = sheet.createRow(++rowIdx);
    CellRangeAddress cra21 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra21);
    Cell cell131 = row13.createCell(0);
    cell131.setCellValue("5、送货单须规范注明订单编号、产品名称、规格等，同时要注明欠货数量及补货日期；");
    cell131.setCellStyle(cellStyle);
    Row row14 = sheet.createRow(++rowIdx);
    CellRangeAddress cra22 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra22);
    Cell cell141 = row14.createCell(0);
    cell141.setCellValue("6、送货时须附上相应的“机械性能报告”、“材质证明书”等相关证明；");
    cell141.setCellStyle(cellStyle);
    Row row15 = sheet.createRow(++rowIdx);
    CellRangeAddress cra23 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra23);
    Cell cell151 = row15.createCell(0);
    cell151.setCellValue("7、如因来料品质不符或因交期延误，致使需方蒙受损失，责任全部由供方承担；");
    cell151.setCellStyle(cellStyle);
    Row row16 = sheet.createRow(++rowIdx);
    CellRangeAddress cra24 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra24);
    Cell cell161 = row16.createCell(0);
    cell161.setCellValue("8、以上计划价格仅供参考，如有疑义，则以合同金额为准。");

    Row row17 = sheet.createRow(++rowIdx);
    CellRangeAddress cra25 = new CellRangeAddress(rowIdx, rowIdx, 0, 2);
    CellRangeAddress cra26 = new CellRangeAddress(rowIdx, rowIdx, 3, 6);
    CellRangeAddress cra27 = new CellRangeAddress(rowIdx, rowIdx, 7, 9);
    CellRangeAddress cra28 = new CellRangeAddress(rowIdx, rowIdx, 10, 11);
    sheet.addMergedRegion(cra25);
    sheet.addMergedRegion(cra26);
    sheet.addMergedRegion(cra27);
    sheet.addMergedRegion(cra28);
    Cell cell171 = row17.createCell(0);
    Cell cell172 = row17.createCell(3);
    Cell cell173 = row17.createCell(7);
    Cell cell174 = row17.createCell(10);
    cell171.setCellValue("供方确认：");
    cell172.setCellValue("批准：");
    cell173.setCellValue("审核：");
    cell174.setCellValue("经办：");

    Row row18 = sheet.createRow(++rowIdx);
    CellRangeAddress cra29 = new CellRangeAddress(rowIdx, rowIdx, 0, 2);
    CellRangeAddress cra30 = new CellRangeAddress(rowIdx, rowIdx, 3, 6);
    CellRangeAddress cra31 = new CellRangeAddress(rowIdx, rowIdx, 7, 9);
    CellRangeAddress cra32 = new CellRangeAddress(rowIdx, rowIdx, 10, 11);
    sheet.addMergedRegion(cra29);
    sheet.addMergedRegion(cra30);
    sheet.addMergedRegion(cra31);
    sheet.addMergedRegion(cra32);
    Cell cell181 = row18.createCell(0);
    Cell cell182 = row18.createCell(3);
    Cell cell183 = row18.createCell(6);
    Cell cell184 = row18.createCell(10);
    cell181.setCellValue("年  月  日");
    cell182.setCellValue("年  月  日");
    cell183.setCellValue("年  月  日");
    cell184.setCellValue("年  月  日");
    cell181.setCellStyle(right);
    cell182.setCellStyle(right);
    cell183.setCellStyle(right);
    cell184.setCellStyle(right);

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

    OutputStream outputStream = response.getOutputStream();
    workbook.write(outputStream);
    outputStream.flush();
    outputStream.close();

  }

  @ApiOperation("导出机加工订单")
  @GetMapping("/entrustOrder/{orderNo}")
  public void entrustOrder(HttpServletResponse response,
      @ApiParam(value = "订单id", required = true) @PathVariable("formId") Integer formId) throws IOException {
    ResultBean resultBean = purcahseOrderService.getInfo(formId);
    Map result = (Map<String, Object>) resultBean.getResult();
    PurchaseOrderExDTO orderExDTO = (PurchaseOrderExDTO) result.get("order");
    List<PurchaseOrderItemExDTO> itemExDTO = (List<PurchaseOrderItemExDTO>) result.get("items");
    response.setHeader("Content-Disposition", "attachment;filename=机加工订单.xls");
    response.setContentType("application/octet-stream;");
    Workbook workbook = new HSSFWorkbook();
    Sheet sheet = workbook.createSheet("机加工订单");

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
    sheet.setDefaultColumnStyle(0, border);
    sheet.setDefaultColumnStyle(1, border);
    sheet.setDefaultColumnStyle(2, border);
    sheet.setDefaultColumnStyle(3, border);
    sheet.setDefaultColumnStyle(4, border);
    sheet.setDefaultColumnStyle(5, border);
    sheet.setDefaultColumnStyle(6, border);
    sheet.setDefaultColumnStyle(7, border);
    sheet.setDefaultColumnStyle(8, border);
    sheet.setDefaultColumnStyle(9, border);
    sheet.setDefaultColumnStyle(10, border);
    sheet.setDefaultColumnStyle(11, border);

    CellStyle cellStyle = workbook.createCellStyle();
    cellStyle.setWrapText(true);

    int rowIdx = 0;
    Row rowTitle = sheet.createRow(rowIdx);
    CellRangeAddress cra1 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra1);
    Cell cellTitle = rowTitle.createCell(0);
    cellTitle.setCellValue("山西好利阀机械制造有限公司");
    cellTitle.setCellStyle(center);
    cellTitle.setCellStyle(border);

    Row rowDesc = sheet.createRow(++rowIdx);
    CellRangeAddress cra2 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra2);
    Cell cellDesc = rowDesc.createCell(0);
    cellDesc.setCellValue("山西省临汾市侯马经济技术开发区旺旺北至路东侧");
    cellTitle.setCellStyle(center);

    Row rowType = sheet.createRow(++rowIdx);
    CellRangeAddress cra3 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra3);
    Cell cellType = rowType.createCell(0);
    cellType.setCellValue("机 加 工 订 单");
    cellTitle.setCellStyle(center);

    Row row1 = sheet.createRow(++rowIdx);
    CellRangeAddress cra4 = new CellRangeAddress(rowIdx, rowIdx, 0, 5);
    sheet.addMergedRegion(cra4);
    Cell cell11 = row1.createCell(0);
    cell11.setCellValue("订单号：" + orderExDTO.getPurchaseOrderNo());
    CellRangeAddress cra5 = new CellRangeAddress(rowIdx, rowIdx, 6, 11);
    sheet.addMergedRegion(cra5);
    Cell cell12 = row1.createCell(6);
    Date createTime = orderExDTO.getCreateTime();
    String createDateValue = "";
    if (createTime != null) {
      createDateValue = DateFormatterUtils.formatterDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, createTime);
    }
    cell12.setCellValue("下单日期：" + createDateValue);

    Row row2 = sheet.createRow(++rowIdx);
    CellRangeAddress cra6 = new CellRangeAddress(rowIdx, rowIdx, 0, 5);
    sheet.addMergedRegion(cra6);
    Cell cell21 = row2.createCell(0);
    cell21.setCellValue("供方：" + orderExDTO.getSupplierName());
    CellRangeAddress cra7 = new CellRangeAddress(rowIdx, rowIdx, 6, 11);
    sheet.addMergedRegion(cra7);
    Cell cell22 = row2.createCell(6);
    cell22.setCellValue("需方：" + orderExDTO.getDemander());

    Row row3 = sheet.createRow(++rowIdx);
    CellRangeAddress cra8 = new CellRangeAddress(rowIdx, rowIdx, 0, 5);
    sheet.addMergedRegion(cra8);
    Cell cell31 = row3.createCell(0);
    cell31.setCellValue("联系人：" + orderExDTO.getSupplierLinkman());
    CellRangeAddress cra9 = new CellRangeAddress(rowIdx, rowIdx, 6, 11);
    sheet.addMergedRegion(cra9);
    Cell cell32 = row3.createCell(6);
    cell32.setCellValue("联系人：" + orderExDTO.getDemander());

    Row row4 = sheet.createRow(++rowIdx);
    CellRangeAddress cra10 = new CellRangeAddress(rowIdx, rowIdx, 0, 5);
    sheet.addMergedRegion(cra10);
    Cell cell41 = row4.createCell(0);
    cell41.setCellValue("联系电话：" + orderExDTO.getSuppilerPhone());

    CellRangeAddress cra11 = new CellRangeAddress(rowIdx, rowIdx, 6, 11);
    sheet.addMergedRegion(cra11);
    Cell cell42 = row4.createCell(6);
    cell42.setCellValue("联系电话：" + orderExDTO.getDemanderPhone());

    Row row5 = sheet.createRow(++rowIdx);
    CellRangeAddress cra12 = new CellRangeAddress(rowIdx, rowIdx, 0, 5);
    sheet.addMergedRegion(cra12);
    Cell cell51 = row5.createCell(0);
    cell51.setCellValue("供方地址：" + orderExDTO.getSupplierAddr());

    CellRangeAddress cra13 = new CellRangeAddress(rowIdx, rowIdx, 6, 11);
    sheet.addMergedRegion(cra13);
    Cell cell52 = row5.createCell(6);
    cell52.setCellValue("需方地址：" + orderExDTO.getDemanderAddr());

    Row row6 = sheet.createRow(++rowIdx);
    CellRangeAddress cra14 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra14);
    Cell cell61 = row6.createCell(0);
    cell61.setCellValue("兹向贵公司订购以下货品（如下表所列），请于24小时内签字回传！");

    for (int i = 0; i < itemExDTO.size() + 1; i++) {
      if (i == 0) {
        Row row = sheet.createRow(++rowIdx);
        Cell cell1 = row.createCell(0);
        cell1.setCellValue("序号");
        Cell cell2 = row.createCell(1);
        cell2.setCellValue("产品名称");
        Cell cell3 = row.createCell(2);
        cell3.setCellValue("图号");
        Cell cell4 = row.createCell(3);
        cell4.setCellValue("规格");
        Cell cell5 = row.createCell(4);
        cell5.setCellValue("材质");
        Cell cell6 = row.createCell(5);
        cell6.setCellValue("单位");
        Cell cell7 = row.createCell(6);
        cell7.setCellValue("数量");
        Cell cell8 = row.createCell(7);
        cell8.setCellValue("单重");
        Cell cell9 = row.createCell(8);
        cell9.setCellValue("总重");
        Cell cell10 = row.createCell(9);
        cell10.setCellValue("单价");
        Cell cell011 = row.createCell(10);
        cell011.setCellValue("金额");
        Cell cell012 = row.createCell(11);
        cell012.setCellValue("备注");
      } else {
        PurchaseOrderItemExDTO itemExDTO1 = itemExDTO.get(i - 1);
        Row row = sheet.createRow(++rowIdx);
        Cell cell1 = row.createCell(0);
        cell1.setCellValue(i);
        Cell cell2 = row.createCell(1);
        cell2.setCellValue(itemExDTO1.getMaterialName());
        Cell cell3 = row.createCell(2);
        cell3.setCellValue(itemExDTO1.getMaterialGraphNo());
        Cell cell4 = row.createCell(3);
        cell4.setCellValue(itemExDTO1.getSpecification());
        Cell cell5 = row.createCell(4);
        cell5.setCellValue(itemExDTO1.getMaterial());
        Cell cell6 = row.createCell(5);
        cell6.setCellValue(itemExDTO1.getUnit());
        Cell cell7 = row.createCell(6);
        cell7.setCellValue(itemExDTO1.getNumber());
        Cell cell8 = row.createCell(7);
        cell8.setCellValue(itemExDTO1.getUnitWeight().doubleValue());
        Cell cell9 = row.createCell(8);
        cell9.setCellValue(itemExDTO1.getTotalWeight());
        Cell cell10 = row.createCell(9);
        cell10.setCellValue(itemExDTO1.getUnitPrice().doubleValue());
        Cell cell011 = row.createCell(10);
        cell011.setCellValue(itemExDTO1.getTotalAmount());
        Cell cell012 = row.createCell(11);
        cell012.setCellValue(itemExDTO1.getRemark());
      }
    }
    Row row7 = sheet.createRow(++rowIdx);
    CellRangeAddress cra15 = new CellRangeAddress(rowIdx, rowIdx, 0, 5);
    sheet.addMergedRegion(cra15);
    Cell cell71 = row7.createCell(0);
    cell71.setCellValue("合计");
    Cell cell72 = row7.createCell(6);
    Cell cell73 = row7.createCell(7);
    Cell cell74 = row7.createCell(8);
    Cell cell75 = row7.createCell(9);
    Cell cell76 = row7.createCell(10);
    Cell cell77 = row7.createCell(11);
    cell72.setCellValue(orderExDTO.getOrderNumber());
    cell74.setCellValue(orderExDTO.getTotalWeight());
    cell76.setCellValue(orderExDTO.getTotalPrice());
    Row row8 = sheet.createRow(++rowIdx);
    CellRangeAddress cra16 = new CellRangeAddress(rowIdx, rowIdx, 0, 5);
    sheet.addMergedRegion(cra16);
    Cell cell81 = row8.createCell(0);
    cell81.setCellValue("人民币大写");
    Cell cell82 = row8.createCell(10);
    cell82.setCellValue(UpperMoney.upper(String.valueOf(orderExDTO.getTotalPrice())));
    Row row9 = sheet.createRow(++rowIdx);
    CellRangeAddress cra17 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra17);
    row9.setHeightInPoints(35);
    Cell cell91 = row9.createCell(0);
    Date deliveryTime = orderExDTO.getDeliveryTime();
    String dateValue = "";
    if (deliveryTime != null) {
      dateValue = DateFormatterUtils.formatterDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, deliveryTime);
    }
    cell91.setCellValue("1、交货日期：" + dateValue + "。供方须严格按交期交货，如需调整日期，须及时知会本公司并经本公司批准，否则延误交货须扣除该批货款10%。");
    cell91.setCellStyle(cellStyle);
    Row row10 = sheet.createRow(++rowIdx);
    CellRangeAddress cra18 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra18);
    row10.setHeightInPoints(35);
    Cell cell101 = row10.createCell(0);
    cell101.setCellValue("2、品质：供方所供产品，应完全依照本公司提供的图纸及相关标准制造，本公司将依照同一标准抽样检查，拒收未经技术管理中心确认的任何来货；");
    cell101.setCellStyle(cellStyle);
    Row row11 = sheet.createRow(++rowIdx);
    CellRangeAddress cra19 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra19);
    Cell cell111 = row11.createCell(0);
    cell111.setCellValue("3、付款方式：" + orderExDTO.getPayType());

    Row row12 = sheet.createRow(++rowIdx);
    CellRangeAddress cra20 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra20);
    Cell cell121 = row12.createCell(0);
    cell121.setCellValue("4、付款条件：交货验收合格后，本公司于收到发票之日起60日内结清货款，每月25日以后交付货品拨归次月账项，请于本月30日前将对账单快递至本公司采购部，逾期送单将延至次月对账；");
    cell121.setCellStyle(cellStyle);
    row12.setHeightInPoints(55);
    Row row13 = sheet.createRow(++rowIdx);
    CellRangeAddress cra21 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra21);
    Cell cell131 = row13.createCell(0);
    cell131.setCellValue("5、送货单须规范注明订单编号、产品名称、规格等，同时要注明欠货数量及补货日期；");
    cell131.setCellStyle(cellStyle);
    Row row14 = sheet.createRow(++rowIdx);
    CellRangeAddress cra22 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra22);
    Cell cell141 = row14.createCell(0);
    cell141.setCellValue("6、送货时须附上相应的“机械性能报告”、“材质证明书”等相关证明；");
    cell141.setCellStyle(cellStyle);
    Row row15 = sheet.createRow(++rowIdx);
    CellRangeAddress cra23 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra23);
    Cell cell151 = row15.createCell(0);
    cell151.setCellValue("7、如因来料品质不符或因交期延误，致使需方蒙受损失，责任全部由供方承担；");
    cell151.setCellStyle(cellStyle);
    Row row16 = sheet.createRow(++rowIdx);
    CellRangeAddress cra24 = new CellRangeAddress(rowIdx, rowIdx, 0, 11);
    sheet.addMergedRegion(cra24);
    Cell cell161 = row16.createCell(0);
    cell161.setCellValue("8、以上计划价格仅供参考，如有疑义，则以合同金额为准。");

    Row row17 = sheet.createRow(++rowIdx);
    CellRangeAddress cra25 = new CellRangeAddress(rowIdx, rowIdx, 0, 2);
    CellRangeAddress cra26 = new CellRangeAddress(rowIdx, rowIdx, 3, 6);
    CellRangeAddress cra27 = new CellRangeAddress(rowIdx, rowIdx, 7, 9);
    CellRangeAddress cra28 = new CellRangeAddress(rowIdx, rowIdx, 10, 11);
    sheet.addMergedRegion(cra25);
    sheet.addMergedRegion(cra26);
    sheet.addMergedRegion(cra27);
    sheet.addMergedRegion(cra28);
    Cell cell171 = row17.createCell(0);
    Cell cell172 = row17.createCell(3);
    Cell cell173 = row17.createCell(7);
    Cell cell174 = row17.createCell(10);
    cell171.setCellValue("供方确认：");
    cell172.setCellValue("批准：");
    cell173.setCellValue("审核：");
    cell174.setCellValue("经办：");

    Row row18 = sheet.createRow(++rowIdx);
    CellRangeAddress cra29 = new CellRangeAddress(rowIdx, rowIdx, 0, 2);
    CellRangeAddress cra30 = new CellRangeAddress(rowIdx, rowIdx, 3, 6);
    CellRangeAddress cra31 = new CellRangeAddress(rowIdx, rowIdx, 7, 9);
    CellRangeAddress cra32 = new CellRangeAddress(rowIdx, rowIdx, 10, 11);
    sheet.addMergedRegion(cra29);
    sheet.addMergedRegion(cra30);
    sheet.addMergedRegion(cra31);
    sheet.addMergedRegion(cra32);
    Cell cell181 = row18.createCell(0);
    Cell cell182 = row18.createCell(3);
    Cell cell183 = row18.createCell(6);
    Cell cell184 = row18.createCell(10);
    cell181.setCellValue("年  月  日");
    cell182.setCellValue("年  月  日");
    cell183.setCellValue("年  月  日");
    cell184.setCellValue("年  月  日");
    cell181.setCellStyle(right);
    cell182.setCellStyle(right);
    cell183.setCellStyle(right);
    cell184.setCellStyle(right);

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

    OutputStream outputStream = response.getOutputStream();
    workbook.write(outputStream);
    outputStream.flush();
    outputStream.close();

  }


  @ApiOperation("下载领料单")
  @GetMapping("/requisition/{orderNo}")
  public void requisition(HttpServletResponse response,
      @ApiParam(value = "订单No", required = true) @PathVariable("orderNo") String orderNo) throws IOException {
    response.setHeader("Content-Disposition", "attachment;filename=requisition_" + orderNo + ".xls");
    response.setContentType("application/octet-stream;");
    Workbook workbook = new HSSFWorkbook();
    Sheet sheet = workbook.createSheet("领料单");

    CellStyle cellStyle = workbook.createCellStyle();
    cellStyle.setWrapText(true);

    int rowIdx = 0;
    Row rowTitle = sheet.createRow(rowIdx);
    Cell cellTitle = rowTitle.createCell(0);
    cellTitle.setCellValue("订单号");
    Cell cellTitle1 = rowTitle.createCell(1);
    cellTitle1.setCellValue("零件图号");
    Cell cellTitle2 = rowTitle.createCell(2);
    cellTitle2.setCellValue("零件名称");
    Cell cellTitle3 = rowTitle.createCell(3);
    cellTitle3.setCellValue("需要的零件数量");
    Cell cellTitle4 = rowTitle.createCell(4);
    cellTitle4.setCellValue("缺少的零件数量");
//        Cell cellTitle5 = rowTitle.createCell(5);
//        cellTitle5.setCellValue("状态");

    List<OrderMaterialDTO> orderMaterialDTOS = orderProductService.listOrderMaterial(orderNo);
    for (OrderMaterialDTO orderMaterialDTO : orderMaterialDTOS) {
      Row row = sheet.createRow(++rowIdx);
      Cell cell = row.createCell(0);
      cell.setCellValue(orderMaterialDTO.getOrderNo());
      Cell cell1 = row.createCell(1);
      cell1.setCellValue(orderMaterialDTO.getMaterialGraphNo());
      Cell cell2 = row.createCell(2);
      cell2.setCellValue(orderMaterialDTO.getMaterialName());
      Cell cell3 = row.createCell(3);
      cell3.setCellValue(orderMaterialDTO.getMaterialCount());
      Cell cell4 = row.createCell(4);
      cell4.setCellValue(orderMaterialDTO.getLackMaterialCount());
//            Cell cell5 = row.createCell(5);
//            cell5.setCellValue(orderMaterialDTO.getCheckStatus());
    }
    Row rowsp = sheet.createRow(++rowIdx);
    Cell cellsp = rowsp.createCell(0);
    cellsp.setCellValue("审批：");
    CellRangeAddress crasp = new CellRangeAddress(rowIdx, rowIdx, 1, 4);
    sheet.addMergedRegion(crasp);
    Cell cellsp1 = rowsp.createCell(1);

    CellStyle fontStyle = workbook.createCellStyle();
    Font font = workbook.createFont();
    font.setColor(Font.COLOR_RED);
    font.setBold(true);
    fontStyle.setFont(font);

    ++rowIdx;
    Row rowDesc = sheet.createRow(++rowIdx);
    CellRangeAddress cra2 = new CellRangeAddress(rowIdx, rowIdx, 0, 6);
    sheet.addMergedRegion(cra2);
    Cell cellDesc = rowDesc.createCell(0);
    cellDesc.setCellStyle(fontStyle);
    cellDesc.setCellValue("请在打印前认真核对领料单的零件图号，特别是阀体、蝶板的图号一定要按订单要求更改相应的图号");

    OutputStream outputStream = response.getOutputStream();
    workbook.write(outputStream);
    outputStream.flush();
    outputStream.close();

  }

  @ApiOperation("喷涂单下载")
  @GetMapping("spray/excel/{sprayNo}")
  public void sprayExcel(@PathVariable("sprayNo") String sprayNo, HttpServletResponse response) throws IOException {
    response.setHeader("Content-Disposition", "attachment;filename=" + sprayNo + ".xls");
    response.setContentType("application/octet-stream;");
    Workbook workbook = new HSSFWorkbook();
    Sheet sheet = workbook.createSheet("领料单");
    ResultBean resultBean = sprayService.getSprayInfo(sprayNo);
    SprayDto sprayDto = (SprayDto) resultBean.getResult();
    CellStyle cellStyle = workbook.createCellStyle();
    cellStyle.setWrapText(true);

    // 单元格样式
    CellStyle center = workbook.createCellStyle();
    center.setAlignment(HorizontalAlignment.CENTER);

    Row title_1 = sheet.createRow(0);
    CellRangeAddress cra1 = new CellRangeAddress(0, 0, 0, 9);
    sheet.addMergedRegion(cra1);
    Cell cell_title_1 = title_1.createCell(0);
    cell_title_1.setCellValue("山 西 好 利 阀 制 造 有 限 公 司");
    cell_title_1.setCellStyle(center);

    Row title_2 = sheet.createRow(1);
    CellStyle center2 = workbook.createCellStyle();
    center2.setAlignment(HorizontalAlignment.CENTER);
    CellRangeAddress cra2 = new CellRangeAddress(1, 1, 0, 9);
    sheet.addMergedRegion(cra2);
    Cell cell_title_2 = title_2.createCell(0);
    cell_title_2.setCellValue("覆 层 生 产 计 划");
    cell_title_2.setCellStyle(center2);

    CellStyle border = workbook.createCellStyle();
    border.setBorderBottom(BorderStyle.THIN);
    border.setBorderLeft(BorderStyle.THIN);
    border.setBorderRight(BorderStyle.THIN);
    border.setBorderTop(BorderStyle.THIN);

    int rowIdx = 2;
    Row rowTitle = sheet.createRow(rowIdx);
    Cell cellTitle = rowTitle.createCell(0);
    cellTitle.setCellValue("名称");
    cellTitle.setCellStyle(border);
    Cell cellTitle1 = rowTitle.createCell(1);
    cellTitle1.setCellValue("图号");
    cellTitle1.setCellStyle(border);
    Cell cellTitle2 = rowTitle.createCell(2);
    cellTitle2.setCellValue("型号");
    cellTitle2.setCellStyle(border);
    Cell cellTitle3 = rowTitle.createCell(3);
    cellTitle3.setCellValue("规格");
    cellTitle3.setCellStyle(border);
    Cell cellTitle4 = rowTitle.createCell(4);
    cellTitle4.setCellValue("数量");
    cellTitle4.setCellStyle(border);
    Cell cellTitle5 = rowTitle.createCell(5);
    cellTitle5.setCellValue("材质");
    cellTitle5.setCellStyle(border);
    Cell cellTitle6 = rowTitle.createCell(6);
    cellTitle6.setCellValue("喷涂颜色");
    cellTitle6.setCellStyle(border);
    Cell cellTitle7 = rowTitle.createCell(7);
    cellTitle7.setCellValue("特殊要求");
    cellTitle7.setCellStyle(border);
    Cell cellTitle8 = rowTitle.createCell(8);
    cellTitle8.setCellValue("要求完成日期");
    cellTitle8.setCellStyle(border);
    Cell cellTitle9 = rowTitle.createCell(9);
    cellTitle9.setCellValue("备注");
    cellTitle9.setCellStyle(border);

    for (SprayItemDto itemDto : sprayDto.getItems()) {
      Row row = sheet.createRow(++rowIdx);
      Cell cell = row.createCell(0);
      cell.setCellValue(itemDto.getMaterialClassifyName());
      cell.setCellStyle(border);

      Cell cell1 = row.createCell(1);
      cell1.setCellValue(itemDto.getMaterialGraphNo());
      cell1.setCellStyle(border);

      Cell cell2 = row.createCell(2);
      cell2.setCellValue(itemDto.getModel());
      cell2.setCellStyle(border);

      Cell cell3 = row.createCell(3);
      cell3.setCellValue(itemDto.getSpecifications());
      cell3.setCellStyle(border);
      Cell cell4 = row.createCell(4);
      cell4.setCellValue(itemDto.getNumber());
      cell4.setCellStyle(border);
      Cell cell5 = row.createCell(5);
      cell5.setCellValue(itemDto.getMaterial());
      cell5.setCellStyle(border);
      Cell cell6 = row.createCell(6);
      cell6.setCellValue(itemDto.getSprayColor());
      cell6.setCellStyle(border);
      Cell cell7 = row.createCell(7);
      cell7.setCellValue(itemDto.getSpecialRequires());
      cell7.setCellStyle(border);
      Cell cell8 = row.createCell(8);
      cell8.setCellValue(itemDto.getCompleteTime());
      cell8.setCellStyle(border);
      Cell cell9 = row.createCell(9);
      cell9.setCellValue(itemDto.getRemark());
      cell9.setCellStyle(border);
    }

    Row rowsp = sheet.createRow(++rowIdx);
    CellRangeAddress crasp = new CellRangeAddress(rowIdx, rowIdx, 0, 5);
    CellRangeAddress crasC = new CellRangeAddress(rowIdx, rowIdx, 6, 9);
    sheet.addMergedRegion(crasp);
    sheet.addMergedRegion(crasC);
    Cell cellsp = rowsp.createCell(0);
    Cell cellsC = rowsp.createCell(6);

    CellStyle left1 = workbook.createCellStyle();
    left1.setAlignment(HorizontalAlignment.LEFT);
    cellsp.setCellValue("计 划 人：" + sprayDto.getPlanner());
    cellsp.setCellStyle(left1);

    CellStyle left2 = workbook.createCellStyle();
    left2.setAlignment(HorizontalAlignment.LEFT);
    cellsC.setCellValue("日 期：" + DateFormatterUtils
        .formatterDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, sprayDto.getCreateTime()));
    cellsC.setCellStyle(left2);

    OutputStream outputStream = response.getOutputStream();
    workbook.write(outputStream);
    outputStream.flush();
    outputStream.close();
  }

  @ApiOperation("机加委托单下载")
  @GetMapping("entrust/excel/{entrustNo}")
  public void entrustExcel(@PathVariable("entrustNo") String entrustNo, HttpServletResponse response)
      throws IOException {
    response.setHeader("Content-Disposition", "attachment;filename=" + entrustNo + ".xls");
    response.setContentType("application/octet-stream;");
    Workbook workbook = new HSSFWorkbook();
    Sheet sheet = workbook.createSheet("机加工委托单");
    ResultBean resultBean = entrustService.getInfo(entrustNo);
    Entrust entrust = (Entrust) resultBean.getResult();
    CellStyle cellStyle = workbook.createCellStyle();
    cellStyle.setWrapText(true);

    // 单元格样式
    CellStyle center = workbook.createCellStyle();
    center.setAlignment(HorizontalAlignment.CENTER);

    Row title_1 = sheet.createRow(0);
    CellRangeAddress cra1 = new CellRangeAddress(0, 0, 0, 7);
    sheet.addMergedRegion(cra1);
    Cell cell_title_1 = title_1.createCell(0);
    cell_title_1.setCellValue("山 西 好 利 阀 制 造 有 限 公 司");
    cell_title_1.setCellStyle(center);

    Row title_2 = sheet.createRow(1);
    CellStyle center2 = workbook.createCellStyle();
    center2.setAlignment(HorizontalAlignment.CENTER);
    CellRangeAddress cra2 = new CellRangeAddress(1, 1, 0, 7);
    sheet.addMergedRegion(cra2);
    Cell cell_title_2 = title_2.createCell(0);
    cell_title_2.setCellValue("机 加 生 产 计 划");
    cell_title_2.setCellStyle(center2);

    CellStyle border = workbook.createCellStyle();
    border.setBorderBottom(BorderStyle.THIN);
    border.setBorderLeft(BorderStyle.THIN);
    border.setBorderRight(BorderStyle.THIN);
    border.setBorderTop(BorderStyle.THIN);

    int rowIdx = 2;
    Row rowTitle = sheet.createRow(rowIdx);
    Cell cellTitle = rowTitle.createCell(0);
    cellTitle.setCellValue("名称");
    cellTitle.setCellStyle(border);
    Cell cellTitle1 = rowTitle.createCell(1);
    cellTitle1.setCellValue("图号");
    cellTitle1.setCellStyle(border);
    Cell cellTitle2 = rowTitle.createCell(2);
    cellTitle2.setCellValue("采购价格");
    cellTitle2.setCellStyle(border);
    Cell cellTitle3 = rowTitle.createCell(3);
    cellTitle3.setCellValue("批次号");
    cellTitle3.setCellStyle(border);
    Cell cellTitle4 = rowTitle.createCell(4);
    cellTitle4.setCellValue("数量");
    cellTitle4.setCellStyle(border);
    Cell cellTitle5 = rowTitle.createCell(5);
    cellTitle5.setCellValue("采购单号");
    cellTitle5.setCellStyle(border);
    Cell cellTitle6 = rowTitle.createCell(6);
    cellTitle6.setCellValue("加工方式");
    cellTitle6.setCellStyle(border);
    Cell cellTitle7 = rowTitle.createCell(7);
    cellTitle7.setCellValue("机加供应商");
    cellTitle7.setCellStyle(border);

    Row row = sheet.createRow(++rowIdx);
    Cell cell = row.createCell(0);
    cell.setCellValue(entrust.getMaterialGraphName());
    cell.setCellStyle(border);

    Cell cell1 = row.createCell(1);
    cell1.setCellValue(entrust.getMaterialGraphNo());
    cell1.setCellStyle(border);

    Cell cell2 = row.createCell(2);
    cell2.setCellValue(entrust.getPurchasePrice().doubleValue());
    cell2.setCellStyle(border);

    Cell cell3 = row.createCell(3);
    cell3.setCellValue(entrust.getBatchNumber());
    cell3.setCellStyle(border);
    Cell cell4 = row.createCell(4);
    cell4.setCellValue(entrust.getNumber());
    cell4.setCellStyle(border);
    Cell cell5 = row.createCell(5);
    cell5.setCellValue(entrust.getPurchaseNo());
    cell5.setCellStyle(border);
    Cell cell6 = row.createCell(6);
    cell6.setCellValue(entrust.getWorkshopType() == 1 ? "内部加工" : "外部加工");
    cell6.setCellStyle(border);
    Cell cell7 = row.createCell(7);
    cell7.setCellValue(entrust.getSupplierName());
    cell7.setCellStyle(border);

    Row rowsp = sheet.createRow(++rowIdx);
    CellRangeAddress crasp = new CellRangeAddress(rowIdx, rowIdx, 0, 3);
    CellRangeAddress crasC = new CellRangeAddress(rowIdx, rowIdx, 4, 7);
    sheet.addMergedRegion(crasp);
    sheet.addMergedRegion(crasC);
    Cell cellsp = rowsp.createCell(0);
    Cell cellsC = rowsp.createCell(4);

    CellStyle left1 = workbook.createCellStyle();
    left1.setAlignment(HorizontalAlignment.LEFT);
    cellsp.setCellValue("委 托 人：" + entrust.getEntrustPerson());
    cellsp.setCellStyle(left1);

    CellStyle left2 = workbook.createCellStyle();
    left2.setAlignment(HorizontalAlignment.LEFT);
    cellsC.setCellValue("日 期：" + DateFormatterUtils
        .formatterDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, entrust.getCreateTime()));
    cellsC.setCellStyle(left2);

    OutputStream outputStream = response.getOutputStream();
    workbook.write(outputStream);
    outputStream.flush();
    outputStream.close();
  }

  @ApiOperation("导出费用管理")
  @GetMapping("expenses")
  public void exportExpenses(HttpServletResponse response, HttpServletRequest request,
      ExportExpensesDTO dto) throws IOException {
    ExpensesExample expensesExample = new ExpensesExample();
    ExpensesExample.Criteria criteria = expensesExample.createCriteria();
    if (StringUtils.isNotEmpty(dto.getStartDate())) {
      Date startDate = DateFormatterUtils.parseDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, dto.getStartDate());
      criteria.andUpdateTimeGreaterThanOrEqualTo(startDate);
    }
    if (StringUtils.isNotEmpty(dto.getEndDate())) {
      Date endDate = DateFormatterUtils.parseDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, dto.getEndDate());
      criteria.andUpdateTimeLessThanOrEqualTo(endDate);
    }
    if (StringUtils.isNotEmpty(dto.getDepartment())) {
      criteria.andDepartmentLike("%" + dto.getDepartment() + "%");
    }
    if (StringUtils.isNotEmpty(dto.getFirstClassifyName())) {
      criteria.andExpensesClassifyEqualTo(dto.getFirstClassifyName());
    }
    if (StringUtils.isNotEmpty(dto.getSecondClassifyName())) {
      criteria.andSecondClassifyEqualTo(dto.getSecondClassifyName());
    }
    String fileName = URLEncoder.encode("费用报表", "utf-8");
    response.setHeader("Content-Disposition", "attachment;filename="+fileName+".xls");
    response.setContentType("application/octet-stream;");
    response.setCharacterEncoding("utf-8");
    Workbook workbook = new HSSFWorkbook();
    CellStyle cellStyle = workbook.createCellStyle();
    cellStyle.setWrapText(true);
    Sheet sheet = workbook.createSheet("费用报表");
    // 单元格样式
    CellStyle center = workbook.createCellStyle();
    center.setAlignment(HorizontalAlignment.CENTER);

    Row title_1 = sheet.createRow(0);
    CellRangeAddress cra1 = new CellRangeAddress(0, 0, 0, 8);
    sheet.addMergedRegion(cra1);
    Cell cell_title_1 = title_1.createCell(0);
    cell_title_1.setCellValue("费 用 报 表");
    cell_title_1.setCellStyle(center);

    Row columnTitle = sheet.createRow(1);
    Cell cell_10 = columnTitle.createCell(0);
    cell_10.setCellValue("序号");
    cell_10.setCellStyle(center);
    Cell cell_11 = columnTitle.createCell(1);
    cell_11.setCellValue("报销人");
    cell_11.setCellStyle(center);
    Cell cell_12 = columnTitle.createCell(2);
    cell_12.setCellValue("报销部门");
    cell_12.setCellStyle(center);
    Cell cell_13 = columnTitle.createCell(3);
    cell_13.setCellValue("报销摘要");
    cell_13.setCellStyle(center);
    Cell cell_14 = columnTitle.createCell(4);
    cell_14.setCellValue("费用类别");
    cell_14.setCellStyle(center);
    Cell cell_15 = columnTitle.createCell(5);
    cell_15.setCellValue("费用类别明细");
    cell_15.setCellStyle(center);
    Cell cell_16 = columnTitle.createCell(6);
    cell_16.setCellValue("总费用");
    cell_16.setCellStyle(center);
    Cell cell_17 = columnTitle.createCell(7);
    cell_17.setCellValue("备注");
    cell_17.setCellStyle(center);
    Cell cell_18 = columnTitle.createCell(8);
    cell_18.setCellValue("提交日期");
    cell_18.setCellStyle(center);

    List<Expenses> expensesList = expensesMapper.selectByExample(expensesExample);
    for (int i = 0; i < expensesList.size(); i++) {
      Expenses expenses = expensesList.get(i);
      Row row_value = sheet.createRow(i + 2);
      Cell cell_0 = row_value.createCell(0);
      cell_0.setCellValue(i + 1);
      cell_0.setCellStyle(center);
      Cell cell_1 = row_value.createCell(1);
      cell_1.setCellValue(expenses.getCommitUser());
      cell_1.setCellStyle(center);
      Cell cell_2 = row_value.createCell(2);
      cell_2.setCellValue(expenses.getDepartment());
      cell_2.setCellStyle(center);
      Cell cell_3 = row_value.createCell(3);
      cell_3.setCellValue(expenses.getSummary());
      cell_3.setCellStyle(center);
      Cell cell_4 = row_value.createCell(4);
      cell_4.setCellValue(expenses.getExpensesClassify());
      cell_4.setCellStyle(center);
      Cell cell_5 = row_value.createCell(5);
      cell_5.setCellValue(expenses.getSecondClassify());
      cell_5.setCellStyle(center);
      Cell cell_6 = row_value.createCell(6);
      cell_6.setCellValue(expenses.getTotalAmount().doubleValue());
      cell_6.setCellStyle(center);
      Cell cell_7 = row_value.createCell(7);
      cell_7.setCellValue(expenses.getRemark());
      cell_7.setCellStyle(center);
      Cell cell_8 = row_value.createCell(8);
      cell_8.setCellValue(
          DateFormatterUtils.formatterDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, expenses.getCreateTime()));
      cell_8.setCellStyle(center);
    }

    OutputStream outputStream = response.getOutputStream();
    workbook.write(outputStream);
    outputStream.flush();
    outputStream.close();


  }

  @ApiOperation("导出零件待入库")
  @GetMapping("material-entry")
  public void exportMaterialEntryRoom(HttpServletResponse response, HttpServletRequest request,
      ExportMaterialEntryRoomDTO dto) throws IOException {
    InspectHistoryExample example = new InspectHistoryExample();
    InspectHistoryExample.Criteria criteria = example.createCriteria();
    if (StringUtils.isNotEmpty(dto.getStartDate())) {
      Date startDate = DateFormatterUtils.parseDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, dto.getStartDate());
      criteria.andUpdateTimeGreaterThanOrEqualTo(startDate);
    }
    if (StringUtils.isNotEmpty(dto.getEndDate())) {
      Date endDate = DateFormatterUtils.parseDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, dto.getEndDate());
      criteria.andUpdateTimeLessThanOrEqualTo(endDate);
    }
    if (dto.getEntryStatus() != null && dto.getEntryStatus() > 0) {
      criteria.andStatusEqualTo(dto.getEntryStatus().byteValue());
    }
    List<InspectHistory> inspectHistories = inspectHistoryMapper.selectByExample(example);

    response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode("零件入库报表","utf-8")+".xls");
    response.setContentType("application/octet-stream;");
    Workbook workbook = new HSSFWorkbook();
    CellStyle cellStyle = workbook.createCellStyle();
    cellStyle.setWrapText(true);
    Sheet sheet = workbook.createSheet("零件入库报表");
    // 单元格样式
    CellStyle center = workbook.createCellStyle();
    center.setAlignment(HorizontalAlignment.CENTER);

    Row title_1 = sheet.createRow(0);
    CellRangeAddress cra1 = new CellRangeAddress(0, 0, 0, 9);
    sheet.addMergedRegion(cra1);
    Cell cell_title_1 = title_1.createCell(0);
    cell_title_1.setCellValue("零 件 入 库 报 表");
    cell_title_1.setCellStyle(center);

    Row columnTitle = sheet.createRow(1);
    Cell cell_10 = columnTitle.createCell(0);
    cell_10.setCellValue("序号");
    cell_10.setCellStyle(center);
    Cell cell_11 = columnTitle.createCell(1);
    cell_11.setCellValue("报检单号");
    cell_11.setCellStyle(center);
    Cell cell_12 = columnTitle.createCell(2);
    cell_12.setCellValue("采购合同号");
    cell_12.setCellStyle(center);
    Cell cell_13 = columnTitle.createCell(3);
    cell_13.setCellValue("批次号");
    cell_13.setCellStyle(center);
    Cell cell_14 = columnTitle.createCell(4);
    cell_14.setCellValue("零件类型");
    cell_14.setCellStyle(center);
    Cell cell_15 = columnTitle.createCell(5);
    cell_15.setCellValue("供应商");
    cell_15.setCellStyle(center);
    Cell cell_16 = columnTitle.createCell(6);
    cell_16.setCellValue("物料名称");
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
    for (int i = 0; i < inspectHistories.size(); i++) {
      InspectHistory inspectHistory = inspectHistories.get(i);
      Row row_value = sheet.createRow(i + 2);
      Cell cell_0 = row_value.createCell(0);
      cell_0.setCellValue(i + 1);
      cell_0.setCellStyle(center);
      Cell cell_1 = row_value.createCell(1);
      cell_1.setCellValue(inspectHistory.getInspectNo());
      cell_1.setCellStyle(center);
      Cell cell_2 = row_value.createCell(2);
      cell_2.setCellValue(inspectHistory.getPurchaseNo());
      cell_2.setCellStyle(center);
      Cell cell_3 = row_value.createCell(3);
      cell_3.setCellValue(inspectHistory.getBatchNumber());
      cell_3.setCellStyle(center);
      Cell cell_4 = row_value.createCell(4);
      cell_4.setCellValue(inspectHistory.getType() == 1? "采购零件":"机加工零件");
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

  @ApiOperation("导出成品待入库")
  @GetMapping("product-entry")
  public void exportProductEntryRoom(HttpServletResponse response, HttpServletRequest request,
      ExportProductEntryRoomDTO dto) throws IOException {
    ProInspectRecordExample example = new ProInspectRecordExample();
    ProInspectRecordExample.Criteria criteria = example.createCriteria();
    if (StringUtils.isNotEmpty(dto.getStartDate())) {
      Date startDate = DateFormatterUtils.parseDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, dto.getStartDate());
      criteria.andUpdateTimeGreaterThanOrEqualTo(startDate);
    }
    if (StringUtils.isNotEmpty(dto.getEndDate())) {
      Date endDate = DateFormatterUtils.parseDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, dto.getEndDate());
      criteria.andUpdateTimeLessThanOrEqualTo(endDate);
    }
    if (StringUtils.isNotEmpty(dto.getOrderNo())) {
      criteria.andOrderNoLike("%" + dto.getOrderNo() + "%");
    }
    if (dto.getEntryStatus() != null && dto.getEntryStatus() > 0) {
      criteria.andStorageStatusEqualTo(dto.getEntryStatus().byteValue());
    }

    List<ProInspectRecord> proInspectRecordList = proInspectRecordMapper.selectByExample(example);
    response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode("成品入库报表","utf-8")+".xls");
    response.setContentType("application/octet-stream;");
    Workbook workbook = new HSSFWorkbook();
    CellStyle cellStyle = workbook.createCellStyle();
    cellStyle.setWrapText(true);
    Sheet sheet = workbook.createSheet("成品入库报表");
    // 单元格样式
    CellStyle center = workbook.createCellStyle();
    center.setAlignment(HorizontalAlignment.CENTER);

    Row title_1 = sheet.createRow(0);
    CellRangeAddress cra1 = new CellRangeAddress(0, 0, 0, 6);
    sheet.addMergedRegion(cra1);
    Cell cell_title_1 = title_1.createCell(0);
    cell_title_1.setCellValue("成 品 入 库 报 表");
    cell_title_1.setCellStyle(center);

    Row columnTitle = sheet.createRow(1);
    Cell cell_10 = columnTitle.createCell(0);
    cell_10.setCellValue("序号");
    cell_10.setCellStyle(center);
    Cell cell_11 = columnTitle.createCell(1);
    cell_11.setCellValue("订单号");
    cell_11.setCellStyle(center);
    Cell cell_12 = columnTitle.createCell(2);
    cell_12.setCellValue("产品编号");
    cell_12.setCellStyle(center);
    Cell cell_13 = columnTitle.createCell(3);
    cell_13.setCellValue("成品型号");
    cell_13.setCellStyle(center);
    Cell cell_14 = columnTitle.createCell(4);
    cell_14.setCellValue("成品规格");
    cell_14.setCellStyle(center);
    Cell cell_15 = columnTitle.createCell(5);
    cell_15.setCellValue("入库数量");
    cell_15.setCellStyle(center);
    Cell cell_16 = columnTitle.createCell(6);
    cell_16.setCellValue("入库日期");
    cell_16.setCellStyle(center);

    for (int i = 0; i < proInspectRecordList.size(); i++) {
      ProInspectRecord proInspectRecord = proInspectRecordList.get(i);
      Row row_value = sheet.createRow(i + 2);
      Cell cell_0 = row_value.createCell(0);
      cell_0.setCellValue(i + 1);
      cell_0.setCellStyle(center);
      Cell cell_1 = row_value.createCell(1);
      cell_1.setCellValue(proInspectRecord.getOrderNo());
      cell_1.setCellStyle(center);
      Cell cell_2 = row_value.createCell(2);
      cell_2.setCellValue(proInspectRecord.getProductNo());
      cell_2.setCellStyle(center);
      Cell cell_3 = row_value.createCell(3);
      cell_3.setCellValue(proInspectRecord.getProductModel());
      cell_3.setCellStyle(center);
      Cell cell_4 = row_value.createCell(4);
      cell_4.setCellValue(proInspectRecord.getProductSpecifications());
      cell_4.setCellStyle(center);
      Cell cell_5 = row_value.createCell(5);
      cell_5.setCellValue(proInspectRecord.getQualifiedNumber());
      cell_5.setCellStyle(center);
      Cell cell_6 = row_value.createCell(6);
      cell_6.setCellValue(
          DateFormatterUtils.formatterDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, proInspectRecord.getUpdateTime()));
      cell_6.setCellStyle(center);
    }

    OutputStream outputStream = response.getOutputStream();
    workbook.write(outputStream);
    outputStream.flush();
    outputStream.close();
  }

  @ApiOperation("导出喷涂待入库")
  @GetMapping("spray-entry")
  public void exportSprayEntryRoom(HttpServletResponse response, HttpServletRequest request,
      ExportSprayEntryRoomDTO dto) throws IOException {
    SprayInspectHistoryExample example = new SprayInspectHistoryExample();
    SprayInspectHistoryExample.Criteria criteria = example.createCriteria();
    if (StringUtils.isNotEmpty(dto.getStartDate())) {
      Date startDate = DateFormatterUtils.parseDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, dto.getStartDate());
      criteria.andUpdateTimeGreaterThanOrEqualTo(startDate);
    }
    if (StringUtils.isNotEmpty(dto.getEndDate())) {
      Date endDate = DateFormatterUtils.parseDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, dto.getEndDate());
      criteria.andUpdateTimeLessThanOrEqualTo(endDate);
    }
    if (StringUtils.isNotEmpty(dto.getSprayNo())) {
      criteria.andSprayNoLike("%" + dto.getSprayNo() + "%");
    }
    if (dto.getEntryStatus() != null && dto.getEntryStatus() > 0) {
      criteria.andStatusEqualTo(dto.getEntryStatus().byteValue());
    }

    List<SprayInspectHistory> sprayInspectHistoryList = sprayInspectHistoryMapper.selectByExample(example);

    response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode("零件入库报表","utf-8")+".xls");
    response.setContentType("application/octet-stream;");
    Workbook workbook = new HSSFWorkbook();
    CellStyle cellStyle = workbook.createCellStyle();
    cellStyle.setWrapText(true);
    Sheet sheet = workbook.createSheet("喷涂入库报表");
    // 单元格样式
    CellStyle center = workbook.createCellStyle();
    center.setAlignment(HorizontalAlignment.CENTER);

    Row title_1 = sheet.createRow(0);
    CellRangeAddress cra1 = new CellRangeAddress(0, 0, 0, 6);
    sheet.addMergedRegion(cra1);
    Cell cell_title_1 = title_1.createCell(0);
    cell_title_1.setCellValue("喷 涂 入 库 报 表");
    cell_title_1.setCellStyle(center);

    Row columnTitle = sheet.createRow(1);
    Cell cell_10 = columnTitle.createCell(0);
    cell_10.setCellValue("序号");
    cell_10.setCellStyle(center);
    Cell cell_11 = columnTitle.createCell(1);
    cell_11.setCellValue("喷涂单号");
    cell_11.setCellStyle(center);
    Cell cell_12 = columnTitle.createCell(2);
    cell_12.setCellValue("零件名称");
    cell_12.setCellStyle(center);
    Cell cell_13 = columnTitle.createCell(3);
    cell_13.setCellValue("原图号");
    cell_13.setCellStyle(center);
    Cell cell_14 = columnTitle.createCell(4);
    cell_14.setCellValue("加工后图号");
    cell_14.setCellStyle(center);
    Cell cell_15 = columnTitle.createCell(5);
    cell_15.setCellValue("入库数量");
    cell_15.setCellStyle(center);
    Cell cell_16 = columnTitle.createCell(6);
    cell_16.setCellValue("入库日期");
    cell_16.setCellStyle(center);

    for (int i = 0; i < sprayInspectHistoryList.size(); i++) {
      SprayInspectHistory sprayInspectHistory = sprayInspectHistoryList.get(i);
      Row row_value = sheet.createRow(i + 2);
      Cell cell_0 = row_value.createCell(0);
      cell_0.setCellValue(i + 1);
      cell_0.setCellStyle(center);
      Cell cell_1 = row_value.createCell(1);
      cell_1.setCellValue(sprayInspectHistory.getSprayNo());
      cell_1.setCellStyle(center);
      Cell cell_2 = row_value.createCell(2);
      cell_2.setCellValue(sprayInspectHistory.getMaterialGraphName());
      cell_2.setCellStyle(center);
      Cell cell_3 = row_value.createCell(3);
      cell_3.setCellValue(sprayInspectHistory.getOriginalGraphNo());
      cell_3.setCellStyle(center);
      Cell cell_4 = row_value.createCell(4);
      cell_4.setCellValue(sprayInspectHistory.getMaterialGraphNo());
      cell_4.setCellStyle(center);
      Cell cell_5 = row_value.createCell(5);
      cell_5.setCellValue(sprayInspectHistory.getQualifiedNumber());
      cell_5.setCellStyle(center);
      Cell cell_6 = row_value.createCell(6);
      cell_6.setCellValue(
          DateFormatterUtils.formatterDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, sprayInspectHistory.getUpdateTime()));
      cell_6.setCellStyle(center);
    }

    OutputStream outputStream = response.getOutputStream();
    workbook.write(outputStream);
    outputStream.flush();
    outputStream.close();
  }

  @ApiOperation("导出成品出库")
  @GetMapping("product-out")
  public void exportProductOutRoom(HttpServletResponse response, HttpServletRequest request,
      ExportProductOutRoomDTO dto) throws IOException {
    EntryOutStoreRecordExample example = new EntryOutStoreRecordExample();
    EntryOutStoreRecordExample.Criteria criteria = example.createCriteria();
    criteria.andTypeEqualTo(PRODUCT.code);
    if (StringUtils.isNotEmpty(dto.getStartDate())) {
      Date startDate = DateFormatterUtils.parseDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, dto.getStartDate());
      criteria.andUpdateTimeGreaterThanOrEqualTo(startDate);
    }
    if (StringUtils.isNotEmpty(dto.getEndDate())) {
      Date endDate = DateFormatterUtils.parseDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, dto.getEndDate());
      criteria.andUpdateTimeLessThanOrEqualTo(endDate);
    }
    if (StringUtils.isNotEmpty(dto.getOrderNo())) {
      criteria.andOrderNoLike("%" + dto.getOrderNo() + "%");
    }
    if (dto.getOperationType() != null) {
      criteria.andOperationTypeEqualTo(dto.getOperationType().byteValue());
    }

    List<EntryOutStoreRecord> entryOutStoreRecordList = entryOutStoreRecordMapper.selectByExample(example);

    response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode("成品出库明细","utf-8")+".xls");
    response.setContentType("application/octet-stream;");
    Workbook workbook = new HSSFWorkbook();
    CellStyle cellStyle = workbook.createCellStyle();
    cellStyle.setWrapText(true);
    Sheet sheet = workbook.createSheet("成品出库明细");
    // 单元格样式
    CellStyle center = workbook.createCellStyle();
    center.setAlignment(HorizontalAlignment.CENTER);

    Row title_1 = sheet.createRow(0);
    CellRangeAddress cra1 = new CellRangeAddress(0, 0, 0, 9);
    sheet.addMergedRegion(cra1);
    Cell cell_title_1 = title_1.createCell(0);
    cell_title_1.setCellValue("成 品 出 库 明 细");
    cell_title_1.setCellStyle(center);

    Row columnTitle = sheet.createRow(1);
    Cell cell_10 = columnTitle.createCell(0);
    cell_10.setCellValue("序号");
    cell_10.setCellStyle(center);
    Cell cell_11 = columnTitle.createCell(1);
    cell_11.setCellValue("订单号");
    cell_11.setCellStyle(center);
    Cell cell_19 = columnTitle.createCell(2);
    cell_19.setCellValue("需方");
    cell_19.setCellStyle(center);
    Cell cell_12 = columnTitle.createCell(3);
    cell_12.setCellValue("成品ID");
    cell_12.setCellStyle(center);
    Cell cell_13 = columnTitle.createCell(4);
    cell_13.setCellValue("成品型号");
    cell_13.setCellStyle(center);
    Cell cell_14 = columnTitle.createCell(5);
    cell_14.setCellValue("成品规格");
    cell_14.setCellStyle(center);
    Cell cell_15 = columnTitle.createCell(6);
    cell_15.setCellValue("操作类型");
    cell_15.setCellStyle(center);
    Cell cell_16 = columnTitle.createCell(7);
    cell_16.setCellValue("出库日期");
    cell_16.setCellStyle(center);
    Cell cell_17 = columnTitle.createCell(8);
    cell_17.setCellValue("出库数量");
    cell_17.setCellStyle(center);
    Cell cell_18 = columnTitle.createCell(9);
    cell_18.setCellValue("单价");
    cell_18.setCellStyle(center);

    for (int i = 0; i < entryOutStoreRecordList.size(); i++) {
      EntryOutStoreRecord entryOutStoreRecord = entryOutStoreRecordList.get(i);
      OrderProductDTO orderProductDTO = orderProductService.getOrderProductInfo(entryOutStoreRecord.getOrderNo());
      Row row_value = sheet.createRow(i + 2);
      Cell cell_0 = row_value.createCell(0);
      cell_0.setCellValue(i + 1);
      cell_0.setCellStyle(center);
      Cell cell_1 = row_value.createCell(1);
      cell_1.setCellValue(entryOutStoreRecord.getOrderNo());
      cell_1.setCellStyle(center);
      Cell cell_2 = row_value.createCell(2);
      cell_2.setCellValue(orderProductDTO.getDemandName());
      cell_2.setCellStyle(center);
      Cell cell_3 = row_value.createCell(3);
      cell_3.setCellValue(entryOutStoreRecord.getProductNo());
      cell_3.setCellStyle(center);
      Cell cell_4 = row_value.createCell(4);
      cell_4.setCellValue(entryOutStoreRecord.getProductModel());
      cell_4.setCellStyle(center);
      Cell cell_5 = row_value.createCell(5);
      cell_5.setCellValue(entryOutStoreRecord.getProductSpecifications());
      cell_5.setCellStyle(center);
      Cell cell_6 = row_value.createCell(6);
      cell_6.setCellValue(entryOutStoreRecord.getOperationType() == 1? "出库":"入库");
      cell_6.setCellStyle(center);
      Cell cell_7 = row_value.createCell(7);
      cell_7.setCellValue(
          DateFormatterUtils.formatterDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, entryOutStoreRecord.getCreateTime()));
      cell_7.setCellStyle(center);
      Cell cell_8 = row_value.createCell(8);
      cell_8.setCellValue(Math.abs(entryOutStoreRecord.getQuantity()));
      cell_8.setCellStyle(center);
      Cell cell_9 = row_value.createCell(9);
      cell_9.setCellValue(entryOutStoreRecord.getPrice().doubleValue());
      cell_9.setCellStyle(center);
    }

    OutputStream outputStream = response.getOutputStream();
    workbook.write(outputStream);
    outputStream.flush();
    outputStream.close();
  }

  @GetMapping("/material/record")
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
    if (StringUtils.isNotEmpty(dto.getOrderNo())) {
      criteria.andOrderNoLike("%" + dto.getOrderNo() + "%");
    }
    if (dto.getOperationType() != null) {
      criteria.andOperationTypeEqualTo(dto.getOperationType().byteValue());
    }

    List<EntryOutStoreRecord> entryOutStoreRecordList = entryOutStoreRecordMapper.selectByExample(example);

    response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode("零件出库明细","utf-8")+".xls");
    response.setContentType("application/octet-stream;");
    Workbook workbook = new HSSFWorkbook();
    CellStyle cellStyle = workbook.createCellStyle();
    cellStyle.setWrapText(true);
    Sheet sheet = workbook.createSheet("零件出库明细");
    // 单元格样式
    CellStyle center = workbook.createCellStyle();
    center.setAlignment(HorizontalAlignment.CENTER);
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

    for (int i = 0; i < entryOutStoreRecordList.size(); i++) {
      EntryOutStoreRecord entryOutStoreRecord = entryOutStoreRecordList.get(i);

      Row row_value = sheet.createRow(i + 2);
      Cell cell_0 = row_value.createCell(0);
      cell_0.setCellValue(i + 1);
      cell_0.setCellStyle(center);
      Cell cell_1 = row_value.createCell(1);
      cell_1.setCellValue(getMaterial(entryOutStoreRecord.getMaterialGraphNo()).getName());
      cell_1.setCellStyle(center);
      Cell cell_2 = row_value.createCell(2);
      cell_2.setCellValue(entryOutStoreRecord.getMaterialGraphNo());
      cell_2.setCellStyle(center);
      Cell cell_3 = row_value.createCell(3);
      cell_3.setCellValue(entryOutStoreRecord.getMaterialBatchNo());
      cell_3.setCellStyle(center);
      Cell cell_4 = row_value.createCell(4);
      cell_4.setCellValue(entryOutStoreRecord.getOperationType() == 1? "出库":"入库");
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
    }

    OutputStream outputStream = response.getOutputStream();
    workbook.write(outputStream);
    outputStream.flush();
    outputStream.close();

  }

  @GetMapping("/material/surplus")
  public void materialSurplus(HttpServletResponse response, HttpServletRequest request)
      throws IOException {
    response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode("零件结存明细","utf-8")+".xls");
    response.setContentType("application/octet-stream;");
    Workbook workbook = new HSSFWorkbook();
    CellStyle cellStyle = workbook.createCellStyle();
    cellStyle.setWrapText(true);
    Sheet sheet = workbook.createSheet("零件结存明细");
    // 单元格样式
    CellStyle center = workbook.createCellStyle();
    center.setAlignment(HorizontalAlignment.CENTER);
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
    }

    OutputStream outputStream = response.getOutputStream();
    workbook.write(outputStream);
    outputStream.flush();
    outputStream.close();
  }

  private Material getMaterial(String materialGraphNo) {
    MaterialExample example = new MaterialExample();
    example.createCriteria().andGraphNoEqualTo(materialGraphNo);
    List<Material> materials = materialMapper.selectByExample(example);
    if(!CollectionUtils.isEmpty(materials)) {
      return materials.get(0);
    }
    return new Material();
  }





}
