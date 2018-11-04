package com.deepsoft.haolifa.controller;


import com.deepsoft.haolifa.model.dto.InvoiceDTO;
import com.deepsoft.haolifa.model.dto.InvoiceListDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.InvoiceService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"发票管理"})
@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @ApiOperation("添加发票记录")
    @PostMapping("save")
    public ResultBean save(@RequestBody InvoiceDTO model) {

        return invoiceService.save(model);
    }


    @ApiOperation("删除发票记录")
    @GetMapping("delete/{id}")
    public ResultBean delete(@PathVariable("id") Integer id) {
        return invoiceService.delete(id);
    }

    @ApiOperation("更新发票记录")
    @PostMapping("update")
    public ResultBean update(@RequestBody InvoiceDTO model) {
        return invoiceService.update(model);
    }

    @ApiOperation("流程中审批完成-填写发票编号")
    @GetMapping("updateInvoiceNo/{id}/{invoiceNo}")
    public ResultBean updateInvoiceNo(@PathVariable(value = "id") Integer id, @PathVariable("invoiceNo") String invoiceNo) {
        return invoiceService.updateInvoiceNo(id, invoiceNo);
    }


    @ApiOperation("查询发票记录列表")
    @PostMapping("list")
    public ResultBean getList(@RequestBody InvoiceListDTO modelList) {
        return invoiceService.getList(modelList);
    }


}
