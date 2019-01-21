package com.deepsoft.haolifa.controller;


import com.deepsoft.haolifa.annotation.LogNotPrint;
import com.deepsoft.haolifa.model.dto.PurchaseOrderExDTO;
import com.deepsoft.haolifa.model.dto.PurchaseOrderItemExDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.PurcahseOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
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
    sheet.setDefaultColumnStyle(0,border);
    sheet.setDefaultColumnStyle(1,border);
    sheet.setDefaultColumnStyle(2,border);
    sheet.setDefaultColumnStyle(3,border);
    sheet.setDefaultColumnStyle(4,border);
    sheet.setDefaultColumnStyle(5,border);
    sheet.setDefaultColumnStyle(6,border);
    sheet.setDefaultColumnStyle(7,border);
    sheet.setDefaultColumnStyle(8,border);
    sheet.setDefaultColumnStyle(9,border);
    sheet.setDefaultColumnStyle(10,border);
    sheet.setDefaultColumnStyle(11,border);



    int rowIdx = 0;
    Row rowTitle = sheet.createRow(rowIdx);
    CellRangeAddress cra1 = new CellRangeAddress(rowIdx,rowIdx,0,11);
    sheet.addMergedRegion(cra1);
    Cell cellTitle = rowTitle.createCell(0);
    cellTitle.setCellValue("山西好利阀机械制造有限公司");
    cellTitle.setCellStyle(center);
    cellTitle.setCellStyle(border);

    Row rowDesc = sheet.createRow(++rowIdx);
    CellRangeAddress cra2 = new CellRangeAddress(rowIdx,rowIdx,0,11);
    sheet.addMergedRegion(cra2);
    Cell cellDesc = rowDesc.createCell(0);
    cellDesc.setCellValue("山西省临汾市侯马经济技术开发区旺旺北至路东侧");
    cellTitle.setCellStyle(center);

    Row rowType = sheet.createRow(++rowIdx);
    CellRangeAddress cra3 = new CellRangeAddress(rowIdx,rowIdx,0,11);
    sheet.addMergedRegion(cra3);
    Cell cellType = rowType.createCell(0);
    cellType.setCellValue("采 购 订 单");
    cellTitle.setCellStyle(center);

    Row row1 = sheet.createRow(++rowIdx);
    CellRangeAddress cra4 = new CellRangeAddress(rowIdx,rowIdx,0,5);
    sheet.addMergedRegion(cra4);
    Cell cell11 = row1.createCell(0);
    cell11.setCellValue("订单号："+orderExDTO.getPurchaseOrderNo());
    CellRangeAddress cra5 = new CellRangeAddress(rowIdx,rowIdx,6,11);
    sheet.addMergedRegion(cra5);
    Cell cell12  = row1.createCell(6);
    cell12.setCellValue("下单日期："+orderExDTO.getCreateTime());

    Row row2 = sheet.createRow(++rowIdx);
    CellRangeAddress cra6 = new CellRangeAddress(rowIdx,rowIdx,0,5);
    sheet.addMergedRegion(cra6);
    Cell cell21 = row2.createCell(0);
    cell21.setCellValue("供方："+orderExDTO.getSupplierName());
    CellRangeAddress cra7 = new CellRangeAddress(rowIdx,rowIdx,6,11);
    sheet.addMergedRegion(cra7);
    Cell cell22  = row2.createCell(6);
    cell22.setCellValue("需方："+orderExDTO.getDemander());

    Row row3 = sheet.createRow(++rowIdx);
    CellRangeAddress cra8 = new CellRangeAddress(rowIdx,rowIdx,0,5);
    sheet.addMergedRegion(cra8);
    Cell cell31 = row3.createCell(0);
    cell31.setCellValue("联系人："+orderExDTO.getSupplierLinkman());
    CellRangeAddress cra9 = new CellRangeAddress(rowIdx,rowIdx,6,11);
    sheet.addMergedRegion(cra9);
    Cell cell32  = row3.createCell(6);
    cell32.setCellValue("联系人："+orderExDTO.getDemander());

    Row row4 = sheet.createRow(++rowIdx);
    CellRangeAddress cra10 = new CellRangeAddress(rowIdx,rowIdx,0,5);
    sheet.addMergedRegion(cra10);
    Cell cell41 = row4.createCell(0);
    cell41.setCellValue("联系电话："+orderExDTO.getSuppilerPhone());

    CellRangeAddress cra11 = new CellRangeAddress(rowIdx,rowIdx,6,11);
    sheet.addMergedRegion(cra11);
    Cell cell42  = row4.createCell(6);
    cell42.setCellValue("联系电话："+orderExDTO.getDemanderPhone());

    Row row5 = sheet.createRow(++rowIdx);
    CellRangeAddress cra12 = new CellRangeAddress(rowIdx,rowIdx,0,5);
    sheet.addMergedRegion(cra12);
    Cell cell51 = row5.createCell(0);
    cell51.setCellValue("供方地址："+orderExDTO.getSupplierAddr());

    CellRangeAddress cra13 = new CellRangeAddress(rowIdx,rowIdx,6,11);
    sheet.addMergedRegion(cra13);
    Cell cell52  = row5.createCell(6);
    cell52.setCellValue("需方地址："+orderExDTO.getDemanderAddr());

    Row row6 = sheet.createRow(++rowIdx);
    CellRangeAddress cra14 = new CellRangeAddress(rowIdx,rowIdx,0,11);
    sheet.addMergedRegion(cra14);
    Cell cell61 = row6.createCell(0);
    cell61.setCellValue("兹向贵公司订购以下货品（如下表所列），请于24小时内签字回传！");

    for (int i = 0; i < itemExDTO.size()+1; i++) {
      if(i==0) {
        Row row = sheet.createRow(++rowIdx);
        Cell cell1 =  row.createCell(0);
        cell1.setCellValue("序号");
        Cell cell2 =  row.createCell(1);
        cell2.setCellValue("产品名称");
        Cell cell3 =  row.createCell(2);
        cell3.setCellValue("图号");
        Cell cell4 =  row.createCell(3);
        cell4.setCellValue("规格");
        Cell cell5 =  row.createCell(4);
        cell5.setCellValue("材质");
        Cell cell6 =  row.createCell(5);
        cell6.setCellValue("单位");
        Cell cell7 =  row.createCell(6);
        cell7.setCellValue("数量");
        Cell cell8 =  row.createCell(7);
        cell8.setCellValue("单重");
        Cell cell9 =  row.createCell(8);
        cell9.setCellValue("总重");
        Cell cell10 =  row.createCell(9);
        cell10.setCellValue("单价");
        Cell cell011 =  row.createCell(10);
        cell011.setCellValue("金额");
        Cell cell012 =  row.createCell(11);
        cell012.setCellValue("备注");
      } else {
        PurchaseOrderItemExDTO itemExDTO1 = itemExDTO.get(i-1);
        Row row = sheet.createRow(++rowIdx);
        Cell cell1 =  row.createCell(0);
        cell1.setCellValue(i);
        Cell cell2 =  row.createCell(1);
        cell2.setCellValue(itemExDTO1.getMaterialName());
        Cell cell3 =  row.createCell(2);
        cell3.setCellValue(itemExDTO1.getMaterialGraphNo());
        Cell cell4 =  row.createCell(3);
        cell4.setCellValue(itemExDTO1.getSpecification());
        Cell cell5 =  row.createCell(4);
        cell5.setCellValue(itemExDTO1.getMaterial());
        Cell cell6 =  row.createCell(5);
        cell6.setCellValue(itemExDTO1.getUnit());
        Cell cell7 =  row.createCell(6);
        cell7.setCellValue(itemExDTO1.getNumber());
        Cell cell8 =  row.createCell(7);
        cell8.setCellValue(itemExDTO1.getUnitWeight().doubleValue());
        Cell cell9 =  row.createCell(8);
        cell9.setCellValue(itemExDTO1.getTotalWeight());
        Cell cell10 =  row.createCell(9);
        cell10.setCellValue(itemExDTO1.getUnitPrice().doubleValue());
        Cell cell011 =  row.createCell(10);
        cell011.setCellValue(itemExDTO1.getTotalAmount());
        Cell cell012 =  row.createCell(11);
        cell012.setCellValue(itemExDTO1.getRemark());
      }
    }
    Row row7 = sheet.createRow(++rowIdx);
    CellRangeAddress cra15 = new CellRangeAddress(rowIdx,rowIdx,0,5);
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
    cell76.setCellValue(orderExDTO.getTotalAmount());
    Row row8 = sheet.createRow(++rowIdx);
    CellRangeAddress cra16 = new CellRangeAddress(rowIdx,rowIdx,0,5);
    sheet.addMergedRegion(cra16);
    Cell cell81 = row8.createCell(0);
    cell81.setCellValue("人民币大写");
    Cell cell82 = row8.createCell(6);
    cell82.setCellValue("");

    Row row9 = sheet.createRow(++rowIdx);
    CellRangeAddress cra17 = new CellRangeAddress(rowIdx,rowIdx,0,11);
    sheet.addMergedRegion(cra17);
    Cell cell91 = row9.createCell(0);
    cell91.setCellValue("1、交货日期："+orderExDTO.getDeliveryTime()+"。供方须严格按交期交货，如需调整日期，须及时知会本公司并经本公司批准，否则延误交货须扣除该批货款10%。");

    Row row10 = sheet.createRow(++rowIdx);
    CellRangeAddress cra18 = new CellRangeAddress(rowIdx,rowIdx,0,11);
    sheet.addMergedRegion(cra18);
    Cell cell101 = row10.createCell(0);
    cell101.setCellValue("2、品质：供方所供产品，应完全依照本公司提供的图纸及相关标准制造，本公司将依照同一标准抽样检查，拒收未经技术管理中心确认的任何来货；");

    Row row11 = sheet.createRow(++rowIdx);
    CellRangeAddress cra19 = new CellRangeAddress(rowIdx,rowIdx,0,11);
    sheet.addMergedRegion(cra19);
    Cell cell111 = row11.createCell(0);
    cell111.setCellValue("3、付款方式："+orderExDTO.getPayType());

    Row row12 = sheet.createRow(++rowIdx);
    CellRangeAddress cra20 = new CellRangeAddress(rowIdx,rowIdx,0,11);
    sheet.addMergedRegion(cra20);
    Cell cell121 = row12.createCell(0);
    cell121.setCellValue("4、付款条件：交货验收合格后，本公司于收到发票之日起60日内结清货款，每月25日以后交付货品拨归次月账项，请于本月30日前将对账单快递至本公司采购部，逾期送单将延至次月对账；");

    Row row13 = sheet.createRow(++rowIdx);
    CellRangeAddress cra21 = new CellRangeAddress(rowIdx,rowIdx,0,11);
    sheet.addMergedRegion(cra21);
    Cell cell131 = row13.createCell(0);
    cell131.setCellValue("5、送货单须规范注明订单编号、产品名称、规格等，同时要注明欠货数量及补货日期；");

    Row row14 = sheet.createRow(++rowIdx);
    CellRangeAddress cra22 = new CellRangeAddress(rowIdx,rowIdx,0,11);
    sheet.addMergedRegion(cra22);
    Cell cell141 = row14.createCell(0);
    cell141.setCellValue("6、送货时须附上相应的“机械性能报告”、“材质证明书”等相关证明；");

    Row row15 = sheet.createRow(++rowIdx);
    CellRangeAddress cra23 = new CellRangeAddress(rowIdx,rowIdx,0,11);
    sheet.addMergedRegion(cra23);
    Cell cell151 = row15.createCell(0);
    cell151.setCellValue("7、如因来料品质不符或因交期延误，致使需方蒙受损失，责任全部由供方承担；");

    Row row16 = sheet.createRow(++rowIdx);
    CellRangeAddress cra24 = new CellRangeAddress(rowIdx,rowIdx,0,11);
    sheet.addMergedRegion(cra24);
    Cell cell161 = row16.createCell(0);
    cell161.setCellValue("8、以上计划价格仅供参考，如有疑义，则以合同金额为准。");

    Row row17 = sheet.createRow(++rowIdx);
    CellRangeAddress cra25 = new CellRangeAddress(rowIdx,rowIdx,0,2);
    CellRangeAddress cra26 = new CellRangeAddress(rowIdx,rowIdx,3,6);
    CellRangeAddress cra27 = new CellRangeAddress(rowIdx,rowIdx,7,9);
    CellRangeAddress cra28 = new CellRangeAddress(rowIdx,rowIdx,10,11);
    sheet.addMergedRegion(cra25);
    sheet.addMergedRegion(cra26);
    sheet.addMergedRegion(cra27);
    sheet.addMergedRegion(cra28);
    Cell cell171= row17.createCell(0);
    Cell cell172= row17.createCell(3);
    Cell cell173= row17.createCell(6);
    Cell cell174= row17.createCell(10);
    cell171.setCellValue("供方确认：");
    cell172.setCellValue("批准：");
    cell173.setCellValue("审核：");
    cell174.setCellValue("经办：");

    Row row18 = sheet.createRow(++rowIdx);
    CellRangeAddress cra29 = new CellRangeAddress(rowIdx,rowIdx,0,2);
    CellRangeAddress cra30 = new CellRangeAddress(rowIdx,rowIdx,3,6);
    CellRangeAddress cra31 = new CellRangeAddress(rowIdx,rowIdx,7,9);
    CellRangeAddress cra32 = new CellRangeAddress(rowIdx,rowIdx,10,11);
    sheet.addMergedRegion(cra29);
    sheet.addMergedRegion(cra30);
    sheet.addMergedRegion(cra31);
    sheet.addMergedRegion(cra32);
    Cell cell181= row18.createCell(0);
    Cell cell182= row18.createCell(3);
    Cell cell183= row18.createCell(6);
    Cell cell184= row18.createCell(10);
    cell181.setCellValue("年  月  日");
    cell182.setCellValue("年  月  日");
    cell183.setCellValue("年  月  日");
    cell184.setCellValue("年  月  日");
    cell181.setCellStyle(right);
    cell182.setCellStyle(right);
    cell183.setCellStyle(right);
    cell184.setCellStyle(right);

    sheet.autoSizeColumn(0,true);
    sheet.autoSizeColumn(1,true);
    sheet.autoSizeColumn(2,true);
    sheet.autoSizeColumn(3,true);
    sheet.autoSizeColumn(4,true);
    sheet.autoSizeColumn(5,true);
    sheet.autoSizeColumn(6,true);
    sheet.autoSizeColumn(7,true);
    sheet.autoSizeColumn(8,true);
    sheet.autoSizeColumn(9,true);
    sheet.autoSizeColumn(10,true);
    sheet.autoSizeColumn(11,true);


    OutputStream outputStream = response.getOutputStream();
    workbook.write(outputStream);
    outputStream.flush();
    outputStream.close();

  }
}
