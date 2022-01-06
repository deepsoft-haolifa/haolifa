package com.deepsoft.haolifa.controller.finance;


import com.deepsoft.haolifa.model.domain.BizOtherBill;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.otherbill.BizOtherBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.otherbill.BizOtherBillDTO;
import com.deepsoft.haolifa.model.dto.finance.otherbill.BizOtherBillUpDTO;
import com.deepsoft.haolifa.service.finance.OtherBillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 其他货币资金日记账
 */
@RestController
@RequestMapping("/finance/otherbill")
@Api(tags = {"其他货币资金日记账管理"})
public class OtherBillController {
    @Autowired
    private OtherBillService otherBillService;


    @ApiOperation("添加节点")
    @PostMapping("/save")
    public ResultBean save(@RequestBody BizOtherBillAddDTO model) {
        return otherBillService.save(model);
    }

    @ApiOperation("删除节点")
    @GetMapping("/delete/{otherBillId}")
    public ResultBean delete(@PathVariable("otherBillId") int id) {
        return otherBillService.delete(id);
    }

    @ApiOperation("更新节点")
    @PostMapping("/updateOtherBill")
    public ResultBean updateOtherBill(@RequestBody BizOtherBillUpDTO otherBillUpDTO) {
        return otherBillService.update(otherBillUpDTO);
    }

    @ApiOperation("获取节点列表")
    @PostMapping("/getOtherBillList")
    public ResultBean getOtherBillList(@RequestBody BizOtherBillDTO otherBillDTO) {
        return otherBillService.getList(otherBillDTO);
    }


}
