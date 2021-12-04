package com.deepsoft.haolifa.controller.finance;


import com.deepsoft.haolifa.model.domain.BizBill;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.bill.BizBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.bill.BizBillDTO;
import com.deepsoft.haolifa.service.finance.BillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 现金日记账
 */
@RestController
@RequestMapping("/finance/bill")
@Api(tags = {"现金日记账管理"})
public class BillController {
    @Autowired
    private BillService billService;


    @ApiOperation("添加节点")
    @PostMapping("/save")
    public ResultBean save(@RequestBody BizBillAddDTO model) {
        return billService.save(model);
    }

    @ApiOperation("删除节点")
    @GetMapping("/delete/{billId}")
    public ResultBean delete(@PathVariable("billId") int id) {
        return billService.delete(id);
    }

    @ApiOperation("更新节点")
    @PostMapping("/updateBizbill")
    public ResultBean updateBizbill(@RequestBody BizBill bizBill) {
        return billService.update(bizBill);
    }

    @ApiOperation("获取节点列表")
    @PostMapping("/getBillList")
    public ResultBean getBillList(@RequestBody BizBillDTO bizBillDTO) {
        return billService.getList(bizBillDTO);
    }





}
