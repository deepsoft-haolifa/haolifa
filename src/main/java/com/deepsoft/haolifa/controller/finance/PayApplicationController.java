package com.deepsoft.haolifa.controller.finance;


import com.deepsoft.haolifa.model.domain.BizPayPlan;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.payapp.PayAppAddDTO;
import com.deepsoft.haolifa.model.dto.finance.payapp.PayAppDTO;
import com.deepsoft.haolifa.service.finance.PayPlanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 付款申请
 */
@RestController
@RequestMapping("/finance/payapp")
@Api(tags = {"付款计划管理"})
public class PayApplicationController {
    @Autowired
    private PayPlanService payPlanService;


    @ApiOperation("创建付款申请")
    @PostMapping("/savePayApp")
    public ResultBean savePayApp(@RequestBody PayAppAddDTO model) {
        return payPlanService.savePayApp(model);
    }


    @ApiOperation("发起审批")
    @GetMapping("approve/{id}")
    public ResultBean approve(@ApiParam("付款申请ID") @PathVariable("id") Integer id) {
        return payPlanService.approve(id);
    }


    @ApiOperation("查询付款申请列表")
    @PostMapping("/getPayAppList")
    public ResultBean getPayAppList(@RequestBody PayAppDTO payAppDTO) {
        return payPlanService.getPayAppDTOList(payAppDTO);
    }



    @ApiOperation("删除节点")
    @GetMapping("/delete/{id}")
    public ResultBean delete(@PathVariable("id") int id) {
        return payPlanService.delete(id);
    }

    @ApiOperation("更新节点")
    @PostMapping("/updatePayApp")
    public ResultBean updatePayAppn(@RequestBody BizPayPlan payPlan) {
        return payPlanService.update(payPlan);
    }


}
