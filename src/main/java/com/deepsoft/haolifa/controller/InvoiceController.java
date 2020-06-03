package com.deepsoft.haolifa.controller;


import com.deepsoft.haolifa.model.dto.*;
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

    @ApiOperation("申请 or 添加发票记录")
    @PostMapping("save")
    public ResultBean save(@RequestBody InvoiceCreateDTO model) {
        return invoiceService.save(model);
    }

    @ApiOperation("删除发票记录")
    @GetMapping("delete/{invoiceId}")
    public ResultBean delete(@PathVariable("invoiceId") int id) {
        return invoiceService.delete(id);
    }

    @ApiOperation("流程中财务审批完成-填写发票编号")
    @PostMapping("updateInvoiceNo")
    public ResultBean updateInvoiceNo(@RequestBody InvoiceStatusDTO statusDTO) {
        return invoiceService.updateInvoiceNo(statusDTO);
    }

    @ApiOperation("查询发票详情(formId等同于记录唯一标示id)")
    @GetMapping("/info/{formId}")
    public ResultBean info(@PathVariable(value = "formId") Integer id) {
        return invoiceService.info(id);
    }


    @ApiOperation("查询发票记录列表")
    @PostMapping("list/{origin}")
    public ResultBean getList(@ApiParam("来源 0 经管 1 财务") @PathVariable("origin") int origin, @RequestBody InvoiceListDTO modelList) {
        return ResultBean.success(invoiceService.getList(origin, modelList));
    }

    @ApiOperation("更改发票状态")
    @PostMapping("/updateStatus")
    public ResultBean updateStatus(@RequestBody InvoiceStatusDTO statusDTO) {
        return ResultBean.success(invoiceService.updateStatus(statusDTO));
    }
}
