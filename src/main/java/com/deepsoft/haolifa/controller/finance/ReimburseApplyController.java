package com.deepsoft.haolifa.controller.finance;


import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.reimburseapply.ReimburseApplyAddDTO;
import com.deepsoft.haolifa.model.dto.finance.reimburseapply.ReimburseApplyRQDTO;
import com.deepsoft.haolifa.model.dto.finance.reimburseapply.ReimburseApplyUpDTO;
import com.deepsoft.haolifa.service.finance.ReimburseApplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * 报销申请
 */
@RestController
@RequestMapping("/finance/reimburseapply")
@Api(tags = {"好利财务-报销申请管理"})
public class ReimburseApplyController {
    @Autowired
    private ReimburseApplyService reimburseApplyService;


    @ApiOperation("添加节点")
    @PostMapping("/save")
    @Transactional(rollbackFor = Exception.class)
    public ResultBean save(@RequestBody ReimburseApplyAddDTO model) {
        return reimburseApplyService.save(model);
    }

    @ApiOperation("删除节点")
    @GetMapping("/delete/{id}")
    @Transactional(rollbackFor = Exception.class)
    public ResultBean delete(@PathVariable("id") int id) {
        return reimburseApplyService.delete(id);
    }

    @ApiOperation("更新节点")
    @PostMapping("/updateReimburseApply")
    @Transactional(rollbackFor = Exception.class)
    public ResultBean updateReimburseApply(@RequestBody ReimburseApplyUpDTO model) {
        return reimburseApplyService.update(model);
    }

    @ApiOperation("获取节点列表")
    @PostMapping("/getReimburseApplyList")
    public ResultBean getBankBillList(@RequestBody ReimburseApplyRQDTO model) {
        return reimburseApplyService.getList(model);
    }


    @ApiOperation("发起审批")
    @GetMapping("/approve/{id}")
    @Transactional(rollbackFor = Exception.class)
    public ResultBean approve(@ApiParam("报销申请ID") @PathVariable("id") Integer id) {
        return reimburseApplyService.approve(id);
    }


}
