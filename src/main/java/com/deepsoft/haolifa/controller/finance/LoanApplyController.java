package com.deepsoft.haolifa.controller.finance;


import com.deepsoft.haolifa.config.CustomGrantedAuthority;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.*;
import com.deepsoft.haolifa.dao.repository.extend.MyPermissionMapper;
import com.deepsoft.haolifa.enums.RoleEnum;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.CustomUser;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.UserPipLineDTO;
import com.deepsoft.haolifa.model.dto.finance.loanapply.*;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.service.finance.LoanApplyService;
import com.deepsoft.haolifa.service.impl.CustomUserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * 借款申请
 */
@RestController
@RequestMapping("/finance/loanapply")
@Api(tags = {"好利财务-借款申请管理"})
public class LoanApplyController {
    @Autowired
    private LoanApplyService loanApplyService;

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserMapper userMapper;
    @Autowired
    private PayUserMapper payUserMapper;
    @Resource
    private PayProductionWorkshopMapper payProductionWorkshopMapper;
    @Resource
    private PayTeamMapper payTeamMapper;
    @Autowired
    private CustomUserServiceImpl customUserService;

    @ApiOperation("添加节点(借款申請列表使用)")
    @PostMapping("/save")
    @Transactional(rollbackFor = Exception.class)
    public ResultBean save(@RequestBody LoanApplyAddDTO model) {
        return loanApplyService.save(model);
    }

    @ApiOperation("删除节点(借款申請列表使用)")
    @GetMapping("/delete/{id}")
    @Transactional(rollbackFor = Exception.class)
    public ResultBean delete(@PathVariable("id") int id) {
        return loanApplyService.delete(id);
    }

      @ApiOperation("详情")
    @GetMapping("/info/{id}")
    @Transactional(rollbackFor = Exception.class)
    public ResultBean<LoanApplyInfoRSDTO> info(@PathVariable("id") int id) {
        return loanApplyService.getInfo(id);
    }

    @ApiOperation("更新节点(借款申請列表使用)")
    @PostMapping("/updateLoan")
    @Transactional(rollbackFor = Exception.class)
    public ResultBean updateLoan(@RequestBody LoanApplyUpDTO model) {
        return loanApplyService.update(model);
    }

    @ApiOperation("获取节点列表(借款申請列表&出纳付款列表共用)")
    @PostMapping("/getLoanList")
    public ResultBean<PageDTO<LoanApplyRSDTO>> getBankBillList(@RequestBody LoanApplyRQDTO model) {
        return loanApplyService.getList(model);
    }


    @ApiOperation("获取我的借款申請列表-不分页")
    @GetMapping("/getLoanList")
    public ResultBean<List<LoanApplyRSDTO>> getLoanApplyList() {
        LoanApplyRQDTO model = new LoanApplyRQDTO();
        model.setPayStatus("3");
        model.setType("1");
        return loanApplyService.getLoanApplyList(model);
    }

    @ApiOperation("发起审批(借款申請列表使用)")
    @GetMapping("/approve/{id}")
    @Transactional(rollbackFor = Exception.class)
    public ResultBean approve(@ApiParam("借款申请ID") @PathVariable("id") Integer id) {
        return loanApplyService.approve(id);
    }

//    @ApiOperation("查询审批记录(借款申請列表&出纳付款列表共用)")
//    @GetMapping("/selectFlowInfo/{id}")
//    @Transactional(rollbackFor = Exception.class)
//    public ResultBean selectFlowInfo(@PathVariable("id") int id) {
//        return loanApplyService.delete(id);
//    }

    @ApiOperation("付款(出纳付款列表使用)")
    @PostMapping("/pay")
    @Transactional(rollbackFor = Exception.class)
    public ResultBean pay(@RequestBody LoanApplyPayDTO loanApplyPayDTO) {
        return loanApplyService.pay(loanApplyPayDTO);
    }


}
