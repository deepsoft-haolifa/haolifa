package com.deepsoft.haolifa.service.impl.finance.helper;


import cn.hutool.core.util.ObjectUtil;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.BizBankBillMapper;
import com.deepsoft.haolifa.dao.repository.BizSubjectsMapper;
import com.deepsoft.haolifa.dao.repository.SysDepartmentMapper;
import com.deepsoft.haolifa.enums.DictEnum;
import com.deepsoft.haolifa.model.domain.BizProjectBudget;
import com.deepsoft.haolifa.model.domain.BizSubjects;
import com.deepsoft.haolifa.model.domain.SysDict;
import com.deepsoft.haolifa.model.domain.SysUser;
import com.deepsoft.haolifa.model.dto.BaseException;
import com.deepsoft.haolifa.model.dto.DepartmentDTO;
import com.deepsoft.haolifa.model.dto.ExpensesDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.projectbudget.ProjectBudgetDecDTO;
import com.deepsoft.haolifa.model.dto.finance.projectbudget.ProjectBudgetQueryBO;
import com.deepsoft.haolifa.model.dto.finance.subjectsbalance.BizSubjectsBalanceUpDTO;
import com.deepsoft.haolifa.service.DepartmentService;
import com.deepsoft.haolifa.service.ExpensesService;
import com.deepsoft.haolifa.service.SysDictService;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.service.finance.ProjectBudgetService;
import com.deepsoft.haolifa.service.finance.SubjectBalanceService;
import com.deepsoft.haolifa.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Slf4j
public class BillHelper {

    @Resource
    private BizBankBillMapper bizBankBillMapper;
    @Resource
    private SysUserService sysUserService;
    @Resource
    private SubjectBalanceService subjectBalanceService;
    @Resource
    private ProjectBudgetService projectBudgetService;
    @Resource
    private ExpensesService expensesService;
    @Resource
    private SysDictService sysDictService;

    @Resource
    private SysDepartmentMapper departmentMapper;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private BizSubjectsMapper bizSubjectsMapper;

    public void decreact(String projectCode, Integer deptId, Integer subjectId, String remark, String serialNo,
                                       BigDecimal payment) {

        if (StringUtils.isEmpty(projectCode)|| ObjectUtil.isEmpty(deptId)||ObjectUtil.isEmpty(subjectId)){
            throw new BaseException("projectCode deptId subjectId 参数不能为空");
        }


        // -- 扣减项目预算
        ProjectBudgetQueryBO queryBO = new ProjectBudgetQueryBO();
        queryBO.setCode(projectCode);
        queryBO.setDeptId(deptId);
        queryBO.setDate(new Date());
        // 校验当月项目预算
        BizProjectBudget bizProjectBudget = projectBudgetService.queryCurMonthBudget(queryBO);
        // 金额不足
        if (bizProjectBudget.getBalanceQuota().compareTo(payment) < 0) {
            throw new BaseException("当月项目预算金额不足");
        }
        // 扣减预算
        ProjectBudgetDecDTO budgetUpDTO = new ProjectBudgetDecDTO();
        budgetUpDTO.setId(bizProjectBudget.getId());
        budgetUpDTO.setBalanceQuota(bizProjectBudget.getBalanceQuota().subtract(payment));
        projectBudgetService.decrement(budgetUpDTO);

        // -- 扣减科目预算
        BizSubjectsBalanceUpDTO bizSubjects = new BizSubjectsBalanceUpDTO();
        bizSubjects.setSubjectsId(subjectId);
        bizSubjects.setDeptId(deptId);
        bizSubjects.setAmount(payment);
        ResultBean resultBean = subjectBalanceService.decreaseAmount(bizSubjects);
        if (!StringUtils.equalsIgnoreCase(CommonEnum.ResponseEnum.SUCCESS.code, resultBean.getCode())) {
            log.error("报销支付：", resultBean.getMessage());
            throw new BaseException(resultBean.getMessage());
        }

        // -- 财务管理->费用管理
        ExpensesDTO expensesDTO = new ExpensesDTO();

        Map<String, String> dictByTypeCodeMap =
            sysDictService.getSysDictByTypeCode(DictEnum.SUBJECTS_TYPE.getCode()).stream()
                .collect(Collectors.toMap(SysDict::getCode, SysDict::getName, (a, b) -> a));
        // 科目
        BizSubjects subject = bizSubjectsMapper.selectByPrimaryKey(subjectId);
        String expensesClassify = dictByTypeCodeMap.getOrDefault(subject.getType(), "");
        String secondClassify = subject.getName();
        expensesDTO.setExpensesClassify(expensesClassify);
        expensesDTO.setSecondClassify(secondClassify);
        expensesDTO.setVoucherNo(serialNo);
        expensesDTO.setTotalAmount(payment.setScale(2, 4));
        SysUser sysUser = sysUserService.getSysUser(sysUserService.selectLoginUser().getId());
        expensesDTO.setCommitUser(sysUser.getRealName());
        DepartmentDTO departmentDTO = departmentService.selectDepartmentById(deptId);
        expensesDTO.setDepartment(departmentDTO.getDeptName());
        expensesDTO.setSummary(remark);
        expensesDTO.setRemark(remark);
        expensesDTO.setDataDate(DateUtils.getDate());

        ResultBean save = expensesService.save(expensesDTO);
        if (!StringUtils.equalsIgnoreCase(CommonEnum.ResponseEnum.SUCCESS.code, save.getCode())) {
            log.error("报销支付：", save.getMessage());
            throw new BaseException(save.getMessage());
        }
    }


}
