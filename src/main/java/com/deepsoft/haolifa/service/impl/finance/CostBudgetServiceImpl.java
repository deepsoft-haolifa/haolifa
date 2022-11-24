package com.deepsoft.haolifa.service.impl.finance;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Pair;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.constant.Constant;
import com.deepsoft.haolifa.dao.repository.*;
import com.deepsoft.haolifa.enums.CostBudgetTypeEnum;
import com.deepsoft.haolifa.enums.DictEnum;
import com.deepsoft.haolifa.enums.SubjectEnum;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.BaseException;
import com.deepsoft.haolifa.model.dto.CustomUser;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.costbudget.CostBudget;
import com.deepsoft.haolifa.model.dto.finance.costbudget.CostBudgetQuery;
import com.deepsoft.haolifa.model.dto.finance.costbudget.dept.CostBudgetDeptAddUpDTO;
import com.deepsoft.haolifa.model.dto.finance.costbudget.dept.CostBudgetDeptRQDTO;
import com.deepsoft.haolifa.model.dto.finance.costbudget.dept.CostBudgetDeptTree;
import com.deepsoft.haolifa.model.dto.finance.costbudget.dept.CostBudgetDeptUpDTO;
import com.deepsoft.haolifa.model.dto.finance.costbudget.subjects.*;
import com.deepsoft.haolifa.model.dto.finance.projectbudget.ProjectBudgetQueryBO;
import com.deepsoft.haolifa.model.dto.finance.subjects.BizSubjectsRSDTO;
import com.deepsoft.haolifa.service.DepartmentService;
import com.deepsoft.haolifa.service.SysDictService;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.service.finance.CostBudgetService;
import com.deepsoft.haolifa.service.finance.ProjectBudgetService;
import com.deepsoft.haolifa.service.impl.finance.helper.FinanceConstant;
import com.deepsoft.haolifa.util.TreeUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CostBudgetServiceImpl implements CostBudgetService {

    @Autowired
    private BizCostBudgetDeptMapper bizCostBudgetDeptMapper;

    @Autowired
    private BizCostBudgetSubjectsMapper bizCostBudgetSubjectsMapper;

    @Autowired
    private SysDepartmentMapper departmentMapper;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private BizBillMapper bizBillMapper;

    @Autowired
    private BizOtherBillMapper bizOtherBillMapper;

    @Autowired
    private BizBankBillMapper bizBankBillMapper;

    @Autowired
    private SysDictService sysDictService;
    @Autowired
    private BizSubjectsMapper subjectsMapper;

    @Autowired
    private BizSubjectsBalanceMapper subjectsBalanceMapper;

    @Autowired
    private ProjectBudgetService projectBudgetService;

    @Override
    public ResultBean saveOrUpDeptBudget(CostBudgetDeptAddUpDTO model) {
        log.info("CostBudgetService saveDeptBudget start|{}", JSONObject.toJSON(model));
        if (StringUtils.isAnyBlank()) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        if (model.getCostRatio() > 100 || model.getCostRatio() < 0) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "比例介于0~100之间");
        }

        List<BizCostBudgetDept> bizCostBudgetDeptAllList = bizCostBudgetDeptMapper.selectByExample(new BizCostBudgetDeptExample());


        BizCostBudgetDeptExample bizCostBudgetDeptExample = new BizCostBudgetDeptExample();
        BizCostBudgetDeptExample.Criteria criteria = bizCostBudgetDeptExample.createCriteria();
        criteria.andDeptIdEqualTo(model.getDeptId());
        List<BizCostBudgetDept> bizCostBudgetDepts = bizCostBudgetDeptMapper.selectByExample(bizCostBudgetDeptExample);
        BizCostBudgetDept bizCostBudgetDept = null;
        if (CollectionUtil.isNotEmpty(bizCostBudgetDepts)) {
            bizCostBudgetDept = bizCostBudgetDepts.get(0);
        }

        CustomUser customUser = sysUserService.selectLoginUser();
        int i = 0;
        if (bizCostBudgetDept != null) {
            // 校验总比例不能大于100
            BizCostBudgetDept finalBizCostBudgetDept = bizCostBudgetDept;
            BigDecimal totalCostRatio = bizCostBudgetDeptAllList.stream()
                .filter(c -> c.getCostRatio() != null)
                .filter(c -> !c.getId().equals(finalBizCostBudgetDept.getId()))
                .map(c -> BigDecimal.valueOf(c.getCostRatio()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal currentTotal = totalCostRatio.add(BigDecimal.valueOf(model.getCostRatio()));
            if (currentTotal.compareTo(BigDecimal.valueOf(100)) > 0) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "总比例不能大于100");
            }

            SysDepartment department = departmentMapper.selectByPrimaryKey(model.getDeptId());
            BizCostBudgetDept bizCostBudgetDeptUp = buildBizCostBudgetDept(model, bizCostBudgetDept, customUser, department);
            i = bizCostBudgetDeptMapper.updateByPrimaryKeySelective(bizCostBudgetDeptUp);
        } else {
            // 校验总比例不能大于100
            BigDecimal totalCostRatio = bizCostBudgetDeptAllList.stream()
                .filter(c -> c.getCostRatio() != null)
                .map(c -> BigDecimal.valueOf(c.getCostRatio()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal currentTotal = totalCostRatio.add(BigDecimal.valueOf(model.getCostRatio()));
            if (currentTotal.compareTo(BigDecimal.valueOf(100)) > 0) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "总比例不能大于100");
            }

            BizCostBudgetDept costBudget = buildBizCostBudgetDept(model, customUser);
            i = bizCostBudgetDeptMapper.insertSelective(costBudget);
        }
        return ResultBean.success(i);
    }

    private BizCostBudgetDept buildBizCostBudgetDept(CostBudgetDeptAddUpDTO model, CustomUser customUser) {
        BizCostBudgetDept costBudget = new BizCostBudgetDept();
        BeanUtils.copyProperties(model, costBudget);
        SysDepartment department = departmentMapper.selectByPrimaryKey(model.getDeptId());
        costBudget.setDeptPid(department.getPid());
        costBudget.setName(department.getDeptName());
        costBudget.setDelFlag(CommonEnum.DelFlagEnum.YES.code);
        costBudget.setCreateTime(new Date());
        costBudget.setUpdateTime(new Date());
        costBudget.setCreateUser(customUser.getId());
        costBudget.setUpdateUser(customUser.getId());
        return costBudget;
    }

    private BizCostBudgetDept buildBizCostBudgetDept(CostBudgetDeptAddUpDTO model, BizCostBudgetDept bizCostBudgetDept, CustomUser customUser, SysDepartment department) {
        BizCostBudgetDept bizCostBudgetDeptUp = new BizCostBudgetDept();
        bizCostBudgetDeptUp.setId(bizCostBudgetDept.getId());
        bizCostBudgetDeptUp.setName(department.getDeptName());
        bizCostBudgetDeptUp.setCostRatio(model.getCostRatio());
        bizCostBudgetDeptUp.setRemark(bizCostBudgetDept.getRemark());
        bizCostBudgetDeptUp.setUpdateTime(new Date());
        bizCostBudgetDeptUp.setUpdateUser(customUser.getId());
        return bizCostBudgetDeptUp;
    }

    @Override
    public ResultBean deleteDeptBudget(int id) {
        BizCostBudgetDeptExample bizCostBudgetDeptExample = new BizCostBudgetDeptExample();
        BizCostBudgetDeptExample.Criteria criteria = bizCostBudgetDeptExample.createCriteria();
        criteria.andDeptIdEqualTo(id);
        List<BizCostBudgetDept> bizCostBudgetDepts = bizCostBudgetDeptMapper.selectByExample(bizCostBudgetDeptExample);
        if (CollectionUtil.isEmpty(bizCostBudgetDepts)) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "当前部门没有费用比例数据");
        }
        BizCostBudgetDept bizCostBudgetDept = bizCostBudgetDepts.get(0);
        int delete = bizCostBudgetDeptMapper.deleteByPrimaryKey(bizCostBudgetDept.getId());
        return ResultBean.success(delete);
    }

    @Override
    public ResultBean updateDeptBudget(CostBudgetDeptUpDTO model) {
        if (model.getCostRatio() > 100 || model.getCostRatio() < 0) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "比例介于0~100之间");
        }

        BizCostBudgetDept costBudget = new BizCostBudgetDept();
        BeanUtils.copyProperties(model, costBudget);
        costBudget.setUpdateTime(new Date());
        costBudget.setUpdateUser(sysUserService.selectLoginUser().getId());
        int update = bizCostBudgetDeptMapper.updateByPrimaryKeySelective(costBudget);
        return ResultBean.success(update);
    }

    /***
     * 获取预算
     * @param model
     * @return
     */
    @Override
    public ResultBean<CostBudget> selectCostBudget(CostBudgetQuery model) {

        CostBudgetTypeEnum costBudgetTypeEnum = model.getCostBudgetTypeEnum();
        BigDecimal one_h = new BigDecimal(100);
        // 深度不能超过5层 防止程序&数据bug cpu打满
        AtomicInteger atomicInteger = new AtomicInteger(5);
        List<BizCostBudgetDept> costBudgetDeptList = new ArrayList<>();
        getBizCostBudgetDept(model.getDeptId(), costBudgetDeptList, atomicInteger);
        List<CostBudget.CostBudgetDetail> costBudgetDetailList = costBudgetDeptList.stream()
            .map(bizCostBudgetDept -> {
                CostBudget.CostBudgetDetail costBudgetRS = new CostBudget.CostBudgetDetail();
                costBudgetRS.setCostRatio(new BigDecimal(bizCostBudgetDept.getCostRatio()).divide(one_h));
                costBudgetRS.setDeptId(bizCostBudgetDept.getDeptId());
                costBudgetRS.setDeptName(bizCostBudgetDept.getName());
                costBudgetRS.setCostBudgetTypeEnum(CostBudgetTypeEnum.dept);
                return costBudgetRS;
            })
            .collect(Collectors.toList());

        if (CollectionUtil.isEmpty(costBudgetDetailList)) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "当前部门未配置预算");
        }

        if (StringUtils.equalsIgnoreCase(costBudgetTypeEnum.getCode(), CostBudgetTypeEnum.subjects.getCode())) {

            BizCostBudgetSubjectsExample bizCostBudgetExample = new BizCostBudgetSubjectsExample();
            BizCostBudgetSubjectsExample.Criteria criteria = bizCostBudgetExample.createCriteria();
            criteria.andDelFlagEqualTo(CommonEnum.DelFlagEnum.YES.code);
            criteria.andDeptIdEqualTo(model.getDeptId());
            criteria.andSubjectsIdEqualTo(model.getSubjectsId());

            List<BizCostBudgetSubjects> bizCostBudgetSubjectsList = bizCostBudgetSubjectsMapper.selectByExample(bizCostBudgetExample);
            if (CollectionUtil.isEmpty(bizCostBudgetSubjectsList)) {
                return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "当前科目未配置预算");
            }
            BizCostBudgetSubjects bizCostBudgetSubjects = bizCostBudgetSubjectsList.get(0);
            CostBudget.CostBudgetDetail costBudgetRS = new CostBudget.CostBudgetDetail();
            costBudgetRS.setCostRatio(new BigDecimal(bizCostBudgetSubjects.getCostRatio()).divide(one_h));
            costBudgetRS.setSubjectsName(bizCostBudgetSubjects.getName());
            costBudgetRS.setSubjectsId(bizCostBudgetSubjects.getSubjectsId());
            costBudgetRS.setCostBudgetTypeEnum(CostBudgetTypeEnum.subjects);
            costBudgetDetailList.add(costBudgetRS);
        }

        CostBudget costBudget = new CostBudget();
        BigDecimal totalCostRatio = costBudgetDetailList.stream()
            .map(CostBudget.CostBudgetDetail::getCostRatio)
            .reduce(BigDecimal.ONE, BigDecimal::multiply);

        // 日记账总金额
        BizBill lastRecordBill = bizBillMapper.getLastRecord();
        BigDecimal lastBalanceBill = lastRecordBill == null || lastRecordBill.getBalance() == null
            ? BigDecimal.ZERO : lastRecordBill.getBalance();


        List<String> stringList = sysDictService.getSysDictByTypeCode(DictEnum.PAY_ACCOUNT.getCode()).stream()
            .map(SysDict::getName)
            .collect(Collectors.toList());

        List<BizBankBill> lastRecordBankBillList = new ArrayList<>();
        List<BizOtherBill> lastRecordOtherBillList = new ArrayList<>();

        for (String c : stringList) {
            BizBankBill lastRecordBankBill = bizBankBillMapper.getLastRecord(Constant.company, c);
            BizOtherBill lastRecordOtherBill = bizOtherBillMapper.getLastRecord(Constant.company, c);
            lastRecordBankBillList.add(lastRecordBankBill);
            lastRecordOtherBillList.add(lastRecordOtherBill);
        }

        BigDecimal lastBalanceBankBill = lastRecordBankBillList.stream()
            .filter(Objects::nonNull)
            .map(BizBankBill::getBalance)
            .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal lastBalanceOtherBill = lastRecordOtherBillList.stream()
            .filter(Objects::nonNull)
            .map(BizOtherBill::getBalance)
            .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalAmount = lastBalanceBill.add(lastBalanceBankBill).add(lastBalanceOtherBill);
        BigDecimal totalAmountCostRatio = totalAmount.multiply(totalCostRatio);
        costBudget.setAmount(totalAmountCostRatio);
        costBudget.setCostRatio(totalCostRatio);
        costBudget.setCostBudgetDetailList(costBudgetDetailList);

        return ResultBean.success(costBudget);
    }

    private void getBizCostBudgetDept(Integer id, List<BizCostBudgetDept> costBudgetDeptList, AtomicInteger atomicInteger) {
        int incrementAndGet = atomicInteger.decrementAndGet();
        if (incrementAndGet == 0) {
            return;
        }
        BizCostBudgetDeptExample bizCostBudgetDeptExample = new BizCostBudgetDeptExample();
        BizCostBudgetDeptExample.Criteria criteria = bizCostBudgetDeptExample.createCriteria();
        criteria.andDeptIdEqualTo(id);
        bizCostBudgetDeptExample.setOrderByClause("create_time desc limit 1");
        List<BizCostBudgetDept> bizCostBudgetDeptList = bizCostBudgetDeptMapper.selectByExample(bizCostBudgetDeptExample);
        if (CollectionUtil.isEmpty(bizCostBudgetDeptList)) {
            return;
        }
        BizCostBudgetDept bizCostBudgetDept = bizCostBudgetDeptList.get(0);
        if (bizCostBudgetDept.getDeptPid() != null && bizCostBudgetDept.getDeptPid() != 0) {
            getBizCostBudgetDept(bizCostBudgetDept.getDeptPid(), costBudgetDeptList, atomicInteger);
        }
        costBudgetDeptList.add(bizCostBudgetDept);
    }


    @Override
    public ResultBean<List<CostBudgetDeptTree>> getDeptBudgetListTree(CostBudgetDeptRQDTO model) {

        // 1 查询所有部门
        List<SysDepartment> sysDepartments = departmentMapper.selectByExample(new SysDepartmentExample());

        List<BizCostBudgetDept> costBudgetDeptList = bizCostBudgetDeptMapper.selectByExample(new BizCostBudgetDeptExample());
        Map<Integer, BizCostBudgetDept> bizCostBudgetDeptMap = costBudgetDeptList.stream().collect(Collectors.toMap(BizCostBudgetDept::getDeptId, Function.identity(), (a, b) -> a));

        List<CostBudgetDeptTree> departmentTrees = new ArrayList<>();
        sysDepartments.stream().forEach(e -> {
            CostBudgetDeptTree departmentTree = new CostBudgetDeptTree();
            departmentTree.setId(String.valueOf(e.getId()));
            departmentTree.setName(e.getDeptName());
            departmentTree.setParentId(String.valueOf(e.getPid()));
            departmentTree.setNo(e.getDeptNo());
            departmentTree.setDescription(e.getDescription());

            BizCostBudgetDept bizCostBudgetDept = bizCostBudgetDeptMap.get(e.getId());
            if (bizCostBudgetDept != null) {
                departmentTree.setCostRatio(bizCostBudgetDept.getCostRatio());
                departmentTree.setCostRatioFormula(bizCostBudgetDept.getCostRatio() + "%");
                departmentTree.setCostRatioFormulaCN(bizCostBudgetDept.getCostRatio() + "%");
                departmentTree.setRemark(bizCostBudgetDept.getRemark());
            } else {
                departmentTree.setCostRatio(0.0);
                departmentTree.setCostRatioFormula(null);
                departmentTree.setCostRatioFormulaCN(null);
            }
            departmentTrees.add(departmentTree);
        });
        List<CostBudgetDeptTree> treeList = TreeUtils.getTreeList("0", departmentTrees);
        return ResultBean.success(treeList);
    }

    @Override
    public ResultBean saveSubjectsBudget(CostBudgetSubjectsAddDTO model) {

        log.info("CostBudgetService saveSubjectsBudget start|{}", JSONObject.toJSON(model));
        if (model.getCostRatio() > 100 || model.getCostRatio() < 0) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "比例介于0~100之间");
        }

        if (StringUtils.isAnyBlank()) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }

        BizCostBudgetSubjectsExample bizCostBudgetExample = new BizCostBudgetSubjectsExample();
        BizCostBudgetSubjectsExample.Criteria criteria = bizCostBudgetExample.createCriteria();
        criteria.andDelFlagEqualTo(CommonEnum.DelFlagEnum.YES.code);
        criteria.andDeptIdEqualTo(model.getDeptId());
        List<BizCostBudgetSubjects> costBudgetSubjectsList = bizCostBudgetSubjectsMapper.selectByExample(bizCostBudgetExample);
        double doubleValue = costBudgetSubjectsList.stream()
            .map(c -> BigDecimal.valueOf(c.getCostRatio()))
            .reduce(BigDecimal.ZERO, BigDecimal::add)
            .doubleValue();
        double t = model.getCostRatio() + doubleValue;
        if (t > 100) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "当前部门下总比例不能大于100");
        }

        BizSubjects bizSubjects = subjectsMapper.selectByPrimaryKey(model.getSubjectsId());

        BizCostBudgetSubjects costBudget = new BizCostBudgetSubjects();
        BeanUtils.copyProperties(model, costBudget);
        costBudget.setName(bizSubjects.getName());
        costBudget.setCreateTime(new Date());
        costBudget.setUpdateTime(new Date());
        costBudget.setSubjectsType(bizSubjects.getType());
        costBudget.setCreateUser(sysUserService.selectLoginUser().getId());
        costBudget.setUpdateUser(sysUserService.selectLoginUser().getId());
        int insertId = bizCostBudgetSubjectsMapper.insertSelective(costBudget);
        return ResultBean.success(insertId);
    }

    @Override
    public ResultBean deleteSubjectsBudget(int id) {
        int delete = bizCostBudgetSubjectsMapper.deleteByPrimaryKey(id);
//        BizCostBudget costBudget = new BizCostBudget();
//        costBudget.setId(id);
//        costBudget.setDelFlag("1");
//        costBudget.setUpdateTime(new Date());
//        costBudget.setUpdateUser(sysUserService.selectLoginUser().getId());
//        int update = bizCostBudgetMapper.updateByPrimaryKeySelective(costBudget);
        return ResultBean.success(delete);
    }

    @Override
    public ResultBean updateSubjectsBudget(CostBudgetSubjectsUpDTO model) {
        if (model.getCostRatio() > 100 || model.getCostRatio() < 0) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "比例介于0~100之间");
        }
        BizSubjects bizSubjects = subjectsMapper.selectByPrimaryKey(model.getSubjectsId());

        BizCostBudgetSubjects costBudget = new BizCostBudgetSubjects();
        BeanUtils.copyProperties(model, costBudget);
        costBudget.setName(bizSubjects.getName());
        costBudget.setUpdateTime(new Date());
        costBudget.setUpdateUser(sysUserService.selectLoginUser().getId());
        int update = bizCostBudgetSubjectsMapper.updateByPrimaryKeySelective(costBudget);
        return ResultBean.success(update);
    }

    @Override
    public ResultBean<PageDTO<CostBudgetSubjectsRSDTO>> getSubjectsBudgetList(CostBudgetSubjectsRQDTO model) {
        if (model.getPageNum() == null || model.getPageNum() == 0) {
            model.setPageNum(1);
        }
        if (model.getPageSize() == null || model.getPageSize() == 0) {
            model.setPageSize(10);
        }
        BizCostBudgetSubjectsExample bizCostBudgetExample = new BizCostBudgetSubjectsExample();
        BizCostBudgetSubjectsExample.Criteria criteria = bizCostBudgetExample.createCriteria();
        criteria.andDelFlagEqualTo(CommonEnum.DelFlagEnum.YES.code);

        // 名称 like
        if (StringUtils.isNotEmpty(model.getName())) {
            criteria.andNameLike("%" + model.getName() + "%");
        }
        //科目id==
        if (model.getSubjectsId() != null) {
            criteria.andSubjectsIdEqualTo(model.getSubjectsId());
        }
        if (model.getDeptId() != null) {
            criteria.andDeptIdEqualTo(model.getDeptId());
        }
        // 科目类别
        if (StringUtils.isNotEmpty(model.getSubjectsTypeCode())) {
            criteria.andSubjectsTypeEqualTo(model.getSubjectsTypeCode());
        }
        if (StringUtils.isNotEmpty(model.getDeptName())) {
            SysDepartmentExample departmentExample = new SysDepartmentExample();
            departmentExample.createCriteria().andDeptNameLike("%" + model.getDeptName() + "%");
            List<SysDepartment> sysDepartments = departmentMapper.selectByExample(departmentExample);
            List<Integer> didList = sysDepartments.stream().map(SysDepartment::getId).collect(Collectors.toList());
            criteria.andDeptIdIn(didList);
        }

        bizCostBudgetExample.setOrderByClause("id desc");
        Page<BizCostBudgetSubjects> pageData = PageHelper
            .startPage(model.getPageNum(), model.getPageSize())
            .doSelectPage(() -> {
                bizCostBudgetSubjectsMapper.selectByExample(bizCostBudgetExample);
            });
        PageDTO<CostBudgetSubjectsRSDTO> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);


        List<SysDepartment> sysDepartments = departmentMapper.selectByExample(new SysDepartmentExample());
        Map<Integer, SysDepartment> sysDepartmentMap = sysDepartments.stream().collect(Collectors.toMap(SysDepartment::getId, Function.identity()));


        Map<String, String> subjects_type_map = sysDictService.getSysDictByTypeCode(DictEnum.SUBJECTS_TYPE.getCode()).stream()
            .collect(Collectors.toMap(SysDict::getCode, SysDict::getName, (a, b) -> a));


        BizSubjectsBalanceExample bizSubjectsBalanceExample = new BizSubjectsBalanceExample();
        List<BizSubjectsBalance> bizSubjectsBalanceList = subjectsBalanceMapper.selectByExample(bizSubjectsBalanceExample);

        Map<String, BigDecimal> bigDecimalMap = bizSubjectsBalanceList.stream()
            .map(bizSubjectsBalance -> {
                String k = bizSubjectsBalance.getDeptId() + "_" + bizSubjectsBalance.getSubjectsId();
                return new Pair<>(k, bizSubjectsBalance.getBalanceAmount());
            })
            .collect(Collectors.toMap(Pair::getKey, Pair::getValue, (a, b) -> a));


        List<CostBudgetSubjectsRSDTO> rqdtoList = pageData.getResult().stream()
            .map(bizCostBudgetSubjects -> {
                return buildCostBudgetSubjectsRSDTO(sysDepartmentMap, subjects_type_map, bigDecimalMap, bizCostBudgetSubjects);
            })
            .collect(Collectors.toList());

        pageDTO.setList(rqdtoList);
        return ResultBean.success(pageDTO);
    }

    @Override
    public ResultBean deleteSubjectsBudgetBatch(List<Integer> ids) {
        BizCostBudgetSubjectsExample bizCostBudgetExample = new BizCostBudgetSubjectsExample();
        BizCostBudgetSubjectsExample.Criteria criteria = bizCostBudgetExample.createCriteria();
        criteria.andIdIn(ids);
        int c = bizCostBudgetSubjectsMapper.deleteByExample(bizCostBudgetExample);
        return ResultBean.success(c);
    }


    @Override
    public ResultBean<List<CostBudgetSubjectsTypeRSDTO>> getCurUserSubjectsTypeList() {
        CustomUser customUser = sysUserService.selectLoginUser();
        SysUser sysUser = sysUserService.getSysUser(customUser.getId());

        // 查询部门预算
        BizCostBudgetSubjectsExample bizCostBudgetExample = new BizCostBudgetSubjectsExample();
        BizCostBudgetSubjectsExample.Criteria criteria = bizCostBudgetExample.createCriteria();
        criteria.andDeptIdEqualTo(sysUser.getDepartId());
        List<BizCostBudgetSubjects> costBudgetSubjectsList = bizCostBudgetSubjectsMapper.selectByExample(bizCostBudgetExample);

        List<SysDepartment> sysDepartments = departmentMapper.selectByExample(new SysDepartmentExample());
        Map<Integer, SysDepartment> sysDepartmentMap = sysDepartments.stream().collect(Collectors.toMap(SysDepartment::getId, Function.identity()));

        Map<String, String> dictMap = sysDictService.getSysDictByTypeCode(DictEnum.SUBJECTS_TYPE.getCode()).stream()
            .collect(Collectors.toMap(SysDict::getCode, SysDict::getName, (a, b) -> a));

        List<CostBudgetSubjectsTypeRSDTO> costBudgetSubjectsRSDTOList = costBudgetSubjectsList.stream()
            .map(bizCostBudgetSubjects -> {
                CostBudgetSubjectsTypeRSDTO costBudgetSubjectsRQDTO = new CostBudgetSubjectsTypeRSDTO();
                BeanUtils.copyProperties(bizCostBudgetSubjects, costBudgetSubjectsRQDTO);
                // todo 公式待补充
                SysDepartment sysDepartment = sysDepartmentMap.get(bizCostBudgetSubjects.getDeptId());
                costBudgetSubjectsRQDTO.setDeptName(sysDepartment.getDeptName());

                costBudgetSubjectsRQDTO.setSubjectsTypeCode(bizCostBudgetSubjects.getSubjectsType());
                costBudgetSubjectsRQDTO.setSubjectsTypeName(dictMap.get(bizCostBudgetSubjects.getSubjectsType()));
                return costBudgetSubjectsRQDTO;
            })
            .collect(Collectors.toMap(CostBudgetSubjectsTypeRSDTO::getSubjectsTypeCode, Function.identity(), (a, b) -> a))
            .values().stream()
            .collect(Collectors.toList());

        return ResultBean.success(costBudgetSubjectsRSDTOList);
    }

    @Override
    public ResultBean<List<CostBudgetSubjectsRSDTO>> getCurUserSubjectsBudgetList(String subjectType) {
        CustomUser customUser = sysUserService.selectLoginUser();
        SysUser sysUser = sysUserService.getSysUser(customUser.getId());

        // 查询部门预算
        BizCostBudgetSubjectsExample bizCostBudgetExample = new BizCostBudgetSubjectsExample();
        BizCostBudgetSubjectsExample.Criteria criteria = bizCostBudgetExample.createCriteria();
        criteria.andDeptIdEqualTo(sysUser.getDepartId());
        criteria.andSubjectsTypeEqualTo(subjectType);
        List<BizCostBudgetSubjects> costBudgetSubjectsList = bizCostBudgetSubjectsMapper.selectByExample(bizCostBudgetExample);

        List<SysDepartment> sysDepartments = departmentMapper.selectByExample(new SysDepartmentExample());
        Map<Integer, SysDepartment> sysDepartmentMap = sysDepartments.stream().collect(Collectors.toMap(SysDepartment::getId, Function.identity()));


        Map<String, String> dictMap = sysDictService.getSysDictByTypeCode(DictEnum.SUBJECTS_TYPE.getCode()).stream()
            .collect(Collectors.toMap(SysDict::getCode, SysDict::getName, (a, b) -> a));


        BizSubjectsBalanceExample bizSubjectsBalanceExample = new BizSubjectsBalanceExample();
        List<BizSubjectsBalance> bizSubjectsBalanceList = subjectsBalanceMapper.selectByExample(bizSubjectsBalanceExample);

        Map<String, BigDecimal> bigDecimalMap = bizSubjectsBalanceList.stream()
            .map(bizSubjectsBalance -> {
                String k = bizSubjectsBalance.getDeptId() + "_" + bizSubjectsBalance.getSubjectsId();
                return new Pair<>(k, bizSubjectsBalance.getBalanceAmount());
            })
            .collect(Collectors.toMap(Pair::getKey, Pair::getValue, (a, b) -> a));

        List<CostBudgetSubjectsRSDTO> costBudgetSubjectsRSDTOList = costBudgetSubjectsList.stream()
            .map(bizCostBudgetSubjects -> {
                return buildCostBudgetSubjectsRSDTO(sysDepartmentMap, dictMap, bigDecimalMap, bizCostBudgetSubjects);
            })
            .collect(Collectors.toList());


        return ResultBean.success(costBudgetSubjectsRSDTOList);
    }

    @Override
    public BizSubjectsBalance getCurUserSubjectsBudget(Integer subjectId, String subjectName) {
        CustomUser customUser = sysUserService.selectLoginUser();
        SysUser sysUser = sysUserService.getSysUser(customUser.getId());

        // 查询科目预算
        BizCostBudgetSubjectsExample bizCostBudgetExample = new BizCostBudgetSubjectsExample();
        BizCostBudgetSubjectsExample.Criteria criteria = bizCostBudgetExample.createCriteria();
        criteria.andDeptIdEqualTo(sysUser.getDepartId());
        if (subjectId != null) {
            criteria.andSubjectsIdEqualTo(subjectId);
        }
        if (subjectName != null) {
            criteria.andNameEqualTo(subjectName);
        }
        bizCostBudgetExample.setOrderByClause("id desc limit 1");
        List<BizCostBudgetSubjects> costBudgetSubjectsList = bizCostBudgetSubjectsMapper.selectByExample(bizCostBudgetExample);
        if (CollectionUtil.isEmpty(costBudgetSubjectsList)) {
            return null;
        }
        BizCostBudgetSubjects bizCostBudgetSubjects = costBudgetSubjectsList.get(0);

        BizSubjectsBalanceExample bizSubjectsBalanceExample = new BizSubjectsBalanceExample();
        BizSubjectsBalanceExample.Criteria balanceExampleCriteria = bizSubjectsBalanceExample.createCriteria();
        balanceExampleCriteria.andSubjectsIdEqualTo(bizCostBudgetSubjects.getSubjectsId());
        balanceExampleCriteria.andDeptIdEqualTo(sysUser.getDepartId());
        List<BizSubjectsBalance> bizSubjectsBalanceList = subjectsBalanceMapper.selectByExample(bizSubjectsBalanceExample);

        if (CollectionUtil.isEmpty(bizSubjectsBalanceList)) {
            return null;
        }
        return bizSubjectsBalanceList.get(0);
    }

    @Override
    public BizSubjectsBalance getSubjectsBudgetByUserId(Integer userId, Integer subjectId, String subjectName) {
        SysUser sysUser = sysUserService.getSysUser(userId);

        // 查询科目预算
        BizCostBudgetSubjectsExample bizCostBudgetExample = new BizCostBudgetSubjectsExample();
        BizCostBudgetSubjectsExample.Criteria criteria = bizCostBudgetExample.createCriteria();
        criteria.andDeptIdEqualTo(sysUser.getDepartId());
        if (subjectId != null) {
            criteria.andSubjectsIdEqualTo(subjectId);
        }
        if (subjectName != null) {
            criteria.andNameEqualTo(subjectName);
        }
        bizCostBudgetExample.setOrderByClause("id desc limit 1");
        List<BizCostBudgetSubjects> costBudgetSubjectsList = bizCostBudgetSubjectsMapper.selectByExample(bizCostBudgetExample);
        if (CollectionUtil.isEmpty(costBudgetSubjectsList)) {
            return null;
        }
        BizCostBudgetSubjects bizCostBudgetSubjects = costBudgetSubjectsList.get(0);

        BizSubjectsBalanceExample bizSubjectsBalanceExample = new BizSubjectsBalanceExample();
        BizSubjectsBalanceExample.Criteria balanceExampleCriteria = bizSubjectsBalanceExample.createCriteria();
        balanceExampleCriteria.andSubjectsIdEqualTo(bizCostBudgetSubjects.getSubjectsId());
        balanceExampleCriteria.andDeptIdEqualTo(sysUser.getDepartId());
        List<BizSubjectsBalance> bizSubjectsBalanceList = subjectsBalanceMapper.selectByExample(bizSubjectsBalanceExample);

        if (CollectionUtil.isEmpty(bizSubjectsBalanceList)) {
            // 账户不存在 先创建账户
            BizSubjectsBalance bizSubjectsBalance = new BizSubjectsBalance();
            bizSubjectsBalance.setDeptId(sysUser.getDepartId());
            bizSubjectsBalance.setSubjectsId(bizCostBudgetSubjects.getSubjectsId());
            bizSubjectsBalance.setBalanceAmount(BigDecimal.ZERO);
            bizSubjectsBalance.setCreateTime(new Date());
            bizSubjectsBalance.setUpdateTime(new Date());
            bizSubjectsBalance.setCreateUser(sysUserService.selectLoginUser().getId());
            bizSubjectsBalance.setUpdateUser(sysUserService.selectLoginUser().getId());
            int insertId = subjectsBalanceMapper.insertSelective(bizSubjectsBalance);
            bizSubjectsBalanceList = subjectsBalanceMapper.selectByExample(bizSubjectsBalanceExample);
        }
        return bizSubjectsBalanceList.get(0);
    }

    @Override
    public ResultBean<CostBudgetSubjectsRSDTO> getCurUserClfSubjectsBudget() {
        CustomUser customUser = sysUserService.selectLoginUser();
        SysUser sysUser = sysUserService.getSysUser(customUser.getId());

//        // 查询部门预算
//        BizCostBudgetSubjectsExample bizCostBudgetExample = new BizCostBudgetSubjectsExample();
//        BizCostBudgetSubjectsExample.Criteria criteria = bizCostBudgetExample.createCriteria();
//        criteria.andDeptIdEqualTo(sysUser.getDepartId());
//        criteria.andSubjectsIdEqualTo(SubjectEnum.clf_id.getCode());
//        List<BizCostBudgetSubjects> costBudgetSubjectsList = bizCostBudgetSubjectsMapper.selectByExample(bizCostBudgetExample);
//
//        List<SysDepartment> sysDepartments = departmentMapper.selectByExample(new SysDepartmentExample());
//        Map<Integer, SysDepartment> sysDepartmentMap = sysDepartments.stream().collect(Collectors.toMap(SysDepartment::getId, Function.identity()));
//
//
//        Map<String, String> dictMap = sysDictService.getSysDictByTypeCode(DictEnum.SUBJECTS_TYPE.getCode()).stream()
//            .collect(Collectors.toMap(SysDict::getCode, SysDict::getName, (a, b) -> a));
//
//
//        BizSubjectsBalanceExample bizSubjectsBalanceExample = new BizSubjectsBalanceExample();
//        List<BizSubjectsBalance> bizSubjectsBalanceList = subjectsBalanceMapper.selectByExample(bizSubjectsBalanceExample);
//
//        Map<String, BigDecimal> bigDecimalMap = bizSubjectsBalanceList.stream()
//            .map(bizSubjectsBalance -> {
//                String k = bizSubjectsBalance.getDeptId() + "_" + bizSubjectsBalance.getSubjectsId();
//                return new Pair<>(k, bizSubjectsBalance.getBalanceAmount());
//            })
//            .collect(Collectors.toMap(Pair::getKey, Pair::getValue, (a, b) -> a));
//
//        List<CostBudgetSubjectsRSDTO> costBudgetSubjectsRSDTOList = costBudgetSubjectsList.stream()
//            .map(bizCostBudgetSubjects -> {
//                return buildCostBudgetSubjectsRSDTO(sysDepartmentMap, dictMap, bigDecimalMap, bizCostBudgetSubjects);
//            })
//            .collect(Collectors.toList());

//        CostBudgetSubjectsRSDTO costBudgetSubjectsRSDTO =
//            CollectionUtil.isNotEmpty(costBudgetSubjectsRSDTOList) ? costBudgetSubjectsRSDTOList.get(0) : new CostBudgetSubjectsRSDTO();

        ProjectBudgetQueryBO queryBO = new ProjectBudgetQueryBO();
        queryBO.setName(FinanceConstant.cai_liao_f_cn);
        queryBO.setDeptId(sysUser.getDepartId());
        queryBO.setDate(new Date());
        // 校验当月项目预算
        BizProjectBudget bizProjectBudget = projectBudgetService.queryCurMonthBudget(queryBO);
        //  当月未维护
        if (ObjectUtil.isNull(bizProjectBudget)) {
            throw new BaseException("当月项目" + FinanceConstant.cai_liao_f_cn + "预算未维护");
        }

        CostBudgetSubjectsRSDTO costBudgetSubjectsRSDTO = new CostBudgetSubjectsRSDTO();
        costBudgetSubjectsRSDTO.setBalanceAmount(bizProjectBudget.getBalanceQuota());
        return ResultBean.success(costBudgetSubjectsRSDTO);
    }

    private CostBudgetSubjectsRSDTO buildCostBudgetSubjectsRSDTO(Map<Integer, SysDepartment> sysDepartmentMap, Map<String, String> dictMap, Map<String, BigDecimal> bigDecimalMap, BizCostBudgetSubjects bizCostBudgetSubjects) {
        CostBudgetSubjectsRSDTO costBudgetSubjectsRQDTO = new CostBudgetSubjectsRSDTO();
        BeanUtils.copyProperties(bizCostBudgetSubjects, costBudgetSubjectsRQDTO);
        // todo 公式待补充
        costBudgetSubjectsRQDTO.setCostRatioFormula(bizCostBudgetSubjects.getCostRatio() + "%");
        costBudgetSubjectsRQDTO.setCostRatioFormulaCN(bizCostBudgetSubjects.getCostRatio() + "%");
        SysDepartment sysDepartment = sysDepartmentMap.get(bizCostBudgetSubjects.getDeptId());
        if (sysDepartment != null) {
            costBudgetSubjectsRQDTO.setDeptName(sysDepartment.getDeptName());
        }

        costBudgetSubjectsRQDTO.setSubjectsTypeCode(bizCostBudgetSubjects.getSubjectsType());
        costBudgetSubjectsRQDTO.setSubjectsTypeName(dictMap.get(bizCostBudgetSubjects.getSubjectsType()));
        costBudgetSubjectsRQDTO.setSubjectsName(dictMap.get(bizCostBudgetSubjects.getSubjectsType()));
        String k = bizCostBudgetSubjects.getDeptId() + "_" + bizCostBudgetSubjects.getSubjectsId();
        BigDecimal bigDecimal = bigDecimalMap.getOrDefault(k, BigDecimal.ZERO);
        costBudgetSubjectsRQDTO.setBalanceAmount(bigDecimal);
        return costBudgetSubjectsRQDTO;
    }
}
