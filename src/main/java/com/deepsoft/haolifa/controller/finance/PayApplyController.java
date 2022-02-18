package com.deepsoft.haolifa.controller.finance;


import com.deepsoft.haolifa.model.domain.BizPayApply;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.payapp.PayApplyAddDTO;
import com.deepsoft.haolifa.model.dto.finance.payapp.PayApplyRQDTO;
import com.deepsoft.haolifa.model.dto.finance.payapp.PayApplyRSDTO;
import com.deepsoft.haolifa.model.dto.finance.payapp.PayApplyUpDTO;
import com.deepsoft.haolifa.service.finance.PayApplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * 付款申请
 */
@RestController
@RequestMapping("/finance/payapply")
@Api(tags = {"好利财务-付款申请管理"})
public class PayApplyController {
    @Autowired
    private PayApplyService payApplyService;


    @ApiOperation("创建付款申请")
    @PostMapping("/savePayApp")
    @Transactional(rollbackFor = Exception.class)
    public ResultBean savePayApp(@RequestBody PayApplyAddDTO model) {
        return payApplyService.save(model);
    }


    @ApiOperation("查询付款详情")
    @PostMapping("/getInfo/{id}")
    public ResultBean<PayApplyRSDTO> getInfo(@ApiParam("付款申请ID") @PathVariable("id") Integer id) {
        return payApplyService.getInfo(id);
    }


    @ApiOperation("发起审批")
    @GetMapping("approve/{id}")
    @Transactional(rollbackFor = Exception.class)
    public ResultBean approve(@ApiParam("付款申请ID") @PathVariable("id") Integer id) {
        return payApplyService.approve(id);
    }


    @ApiOperation("查询付款申请列表")
    @PostMapping("/getPayAppList")
    public ResultBean<PageDTO<PayApplyRSDTO>> getPayAppList(@RequestBody PayApplyRQDTO payAppDTO) {
        return payApplyService.getList(payAppDTO);
    }


    @ApiOperation("删除节点")
    @GetMapping("/delete/{id}")
    public ResultBean delete(@PathVariable("id") int id) {
        return payApplyService.delete(id);
    }

    @ApiOperation("更新节点")
    @PostMapping("/updatePayApp")
    @Transactional(rollbackFor = Exception.class)
    public ResultBean updatePayAppn(@RequestBody PayApplyUpDTO payPlan) {
        return payApplyService.update(payPlan);
    }


}
