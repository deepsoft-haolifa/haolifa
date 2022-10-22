package com.deepsoft.haolifa.controller.finance;


import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSON;
import com.deepsoft.haolifa.enums.ReimburseTypeEnum;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.loanapply.LoanApplyInfoRSDTO;
import com.deepsoft.haolifa.model.dto.finance.loanapply.LoanApplyPayDTO;
import com.deepsoft.haolifa.model.dto.finance.loanapply.LoanApplyRQDTO;
import com.deepsoft.haolifa.model.dto.finance.loanapply.LoanApplyRSDTO;
import com.deepsoft.haolifa.model.dto.finance.reimburseapply.*;
import com.deepsoft.haolifa.service.finance.LoanApplyService;
import com.deepsoft.haolifa.service.finance.ReimburseApplyService;
import com.deepsoft.haolifa.service.impl.finance.helper.RemiburseBXPrint;
import com.deepsoft.haolifa.service.impl.finance.helper.RemiburseCLPrint;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 报销申请
 */
@RestController
@RequestMapping("/finance/reimburseapply")
@Api(tags = {"好利财务-报销申请管理"})
public class ReimburseApplyController {
    @Autowired
    private ReimburseApplyService reimburseApplyService;
    @Autowired
    private LoanApplyService loanApplyService;


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

    @ApiOperation("报销申请-获取节点列表")
    @PostMapping("/getReimburseApplyBillList")
    public ResultBean<PageDTO<ReimburseApplyRSDTO>> getReimburseApplyBillList(@RequestBody ReimburseApplyRQDTO model) {
        model.setMyself("1");
        return reimburseApplyService.getList(model);
    }

    @ApiOperation("报销支付-获取节点列表")
    @PostMapping("/getReimburseApplyPayBillList")
    @Transactional(rollbackFor = Exception.class)
    public ResultBean<PageDTO<ReimburseApplyRSDTO>> getReimburseApplyPayBillList(@RequestBody ReimburseApplyRQDTO model) {
        return reimburseApplyService.getList(model);
    }


    @ApiOperation("详情")
    @GetMapping("/info/{id}")
    public ResultBean<ReimburseApplyDetailDTO> info(@PathVariable("id") int id) {
        return reimburseApplyService.getInfo(id);
    }


    @ApiOperation("打印")
    @GetMapping("/printPDF/{id}")
    public void printPDF(@PathVariable("id") int id, HttpServletResponse response) throws Exception {
        // todo 校验

        ResultBean<ReimburseApplyDetailDTO> info = reimburseApplyService.getInfo(id);
        ReimburseApplyDetailDTO reimburseApplyDetailDTO =info.getResult();
        if (CollectionUtil.isEmpty(reimburseApplyDetailDTO.getFileUrlList())){
            ResultBean<Object> error = ResultBean.error("请先上传附件");
            response.getOutputStream().write(JSON.toJSONBytes(error));
        }


        if (StringUtils.equalsIgnoreCase(reimburseApplyDetailDTO.getType(), ReimburseTypeEnum.travle.getCode())){
            RemiburseCLPrint.print(reimburseApplyDetailDTO,response);
        }else {
            RemiburseBXPrint.print(reimburseApplyDetailDTO,response);
        }
    }


    @ApiOperation("打印")
    @GetMapping("/printEmptyCL")
    public void printEmptyCL( HttpServletResponse response) throws Exception {
        ReimburseApplyDetailDTO reimburseApplyDetailDTO = new ReimburseApplyDetailDTO();
        reimburseApplyDetailDTO.setReimburseTravelDetailRSDTOList(new ArrayList<>());
        reimburseApplyDetailDTO.setType(ReimburseTypeEnum.travle.getCode());
        reimburseApplyDetailDTO.setDeptName("");
        reimburseApplyDetailDTO.setProjectCode("");
        reimburseApplyDetailDTO.setProjectCodeName("");
        reimburseApplyDetailDTO.setAccountName("");
        reimburseApplyDetailDTO.setBankOfDeposit("");
        reimburseApplyDetailDTO.setCardNumber("");
        reimburseApplyDetailDTO.setPayTypeCN("");

        RemiburseCLPrint.print(reimburseApplyDetailDTO,response);
    }


    @ApiOperation("打印")
    @GetMapping("/printEmptyBX")
    public void printEmptyBX( HttpServletResponse response) throws Exception {
        ReimburseApplyDetailDTO reimburseApplyDetailDTO = new ReimburseApplyDetailDTO();
        reimburseApplyDetailDTO.setReimburseCostDetailRSDTOList(new ArrayList<>());
        reimburseApplyDetailDTO.setType(ReimburseTypeEnum.cost.getCode());
        reimburseApplyDetailDTO.setDeptName("");
        reimburseApplyDetailDTO.setProjectCode("");
        reimburseApplyDetailDTO.setProjectCodeName("");
        reimburseApplyDetailDTO.setAccountName("");
        reimburseApplyDetailDTO.setBankOfDeposit("");
        reimburseApplyDetailDTO.setCardNumber("");
        reimburseApplyDetailDTO.setPayTypeCN("");


        RemiburseBXPrint.print(reimburseApplyDetailDTO,response);
    }


    @ApiOperation("发起审批")
    @GetMapping("/approve/{id}")
    @Transactional(rollbackFor = Exception.class)
    public ResultBean approve(@ApiParam("报销申请ID") @PathVariable("id") Integer id) {
        return reimburseApplyService.approve(id);
    }

    @ApiOperation("付款(出纳付款列表使用)")
    @PostMapping("/pay")
    @Transactional(rollbackFor = Exception.class)
    public ResultBean pay(@RequestBody ReimburseApplyPayDTO payDTO) {
        return reimburseApplyService.pay(payDTO);
    }



}
