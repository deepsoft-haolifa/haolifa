package com.deepsoft.haolifa.controller;


import com.deepsoft.haolifa.model.dto.PurchaseOrderExDTO;
import com.deepsoft.haolifa.model.dto.PurchaseOrderItemExDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.PurcahseOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.WorkbookUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    Workbook workbook = new HSSFWorkbook();
    Sheet sheet = workbook.createSheet("采购订单");

    for (int i = 0; i < 12; i++) {
      Row row = sheet.createRow(i);
      row.createCell(1);
      row.createCell(1);
      row.createCell(1);
      row.createCell(1);
      row.createCell(1);
      row.createCell(1);
      row.createCell(1);
      row.createCell(1);
      row.createCell(1);
      row.createCell(1);
      row.createCell(1);
      row.createCell(1);
    }
    ((HSSFWorkbook) workbook).write(response.getOutputStream());
  }
}
