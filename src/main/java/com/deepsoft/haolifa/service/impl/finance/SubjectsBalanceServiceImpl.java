package com.deepsoft.haolifa.service.impl.finance;

import cn.hutool.core.lang.Pair;
import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.*;
import com.deepsoft.haolifa.enums.DictEnum;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.BaseException;
import com.deepsoft.haolifa.model.dto.CustomUser;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.costbudget.subjects.CostBudgetSubjectsRSDTO;
import com.deepsoft.haolifa.model.dto.finance.subjectsbalance.BizSubjectsBalanceAddDTO;
import com.deepsoft.haolifa.model.dto.finance.subjectsbalance.BizSubjectsBalanceRQDTO;
import com.deepsoft.haolifa.model.dto.finance.subjectsbalance.BizSubjectsBalanceRSDTO;
import com.deepsoft.haolifa.model.dto.finance.subjectsbalance.BizSubjectsBalanceUpDTO;
import com.deepsoft.haolifa.service.SysDictService;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.service.finance.SubjectBalanceService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SubjectsBalanceServiceImpl implements SubjectBalanceService {

    @Autowired
    private BizSubjectsBalanceMapper subjectsBalanceMapper;

    @Autowired
    private BizSubjectsBalanceFlowMapper subjectsBalanceFlowMapper;

    @Autowired
    private BizCostBudgetSubjectsMapper costBudgetSubjectsMapper;

    @Autowired
    private BizCostBudgetDeptMapper costBudgetDeptMapper;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysDictService sysDictService;
    @Autowired
    private SysDepartmentMapper departmentMapper;


    @Override
    public void increaseAmountBatch( BigDecimal amount) {

        // 查询所有已经配备比例的部门
        List<BizCostBudgetDept> costBudgetDeptList = costBudgetDeptMapper.selectByExample(new BizCostBudgetDeptExample());
        if (CollectionUtils.isEmpty(costBudgetDeptList)) {
            return;
        }

        for (BizCostBudgetDept bizCostBudgetDept : costBudgetDeptList) {
            Integer deptId = bizCostBudgetDept.getDeptId();

            if (bizCostBudgetDept.getCostRatio()==null || bizCostBudgetDept.getCostRatio()<=0) {
                continue;
            }

            // 根据部门查询科目预算
            BizCostBudgetSubjectsExample bizCostBudgetSubjectsExample = new BizCostBudgetSubjectsExample();
            bizCostBudgetSubjectsExample.createCriteria().andDeptIdEqualTo(deptId);
            List<BizCostBudgetSubjects> bizCostBudgetSubjectsList = costBudgetSubjectsMapper.selectByExample(bizCostBudgetSubjectsExample);
            if (CollectionUtils.isEmpty(bizCostBudgetSubjectsList)) {
                continue;
            }
            // 批量添加
            for (BizCostBudgetSubjects bizCostBudgetSubjects : bizCostBudgetSubjectsList) {
                BizSubjectsBalanceUpDTO bizSubjectsBalanceUpDTO = new BizSubjectsBalanceUpDTO();
                bizSubjectsBalanceUpDTO.setDeptId(deptId);
                bizSubjectsBalanceUpDTO.setSubjectsId(bizCostBudgetSubjects.getSubjectsId());

                BigDecimal deptCostRatio = BigDecimal.valueOf(bizCostBudgetDept.getCostRatio()).divide(BigDecimal.valueOf(100));
                BigDecimal subCostRatio = BigDecimal.valueOf(bizCostBudgetSubjects.getCostRatio()).divide(BigDecimal.valueOf(100));

                BigDecimal am = amount.multiply(deptCostRatio).multiply(subCostRatio);

                bizSubjectsBalanceUpDTO.setAmount(am);
                increaseAmount(bizSubjectsBalanceUpDTO);
            }
        }
    }

    @Override
    public void decreaseAmountBatch( BigDecimal amount) {
//        // 根据部门查询部门预算
//        BizCostBudgetDeptExample bizCostBudgetDeptExample = new BizCostBudgetDeptExample();
//        bizCostBudgetDeptExample.createCriteria().andDeptIdEqualTo(deptId);
//        List<BizCostBudgetDept> bizCostBudgetDepts = costBudgetDeptMapper.selectByExample(bizCostBudgetDeptExample);
//        if (CollectionUtils.isEmpty(bizCostBudgetDepts)) {
//            return;
//        }
//        BizCostBudgetDept bizCostBudgetDept = bizCostBudgetDepts.get(0);
//
//        // 根据部门查询科目预算
//        BizCostBudgetSubjectsExample bizCostBudgetSubjectsExample = new BizCostBudgetSubjectsExample();
//        bizCostBudgetSubjectsExample.createCriteria().andDeptIdEqualTo(deptId);
//        List<BizCostBudgetSubjects> bizCostBudgetSubjectsList = costBudgetSubjectsMapper.selectByExample(bizCostBudgetSubjectsExample);
//        if (CollectionUtils.isEmpty(bizCostBudgetSubjectsList)) {
//            return;
//        }
//
//        // 批量添加
//        for (BizCostBudgetSubjects bizCostBudgetSubjects : bizCostBudgetSubjectsList) {
//            BizSubjectsBalanceUpDTO bizSubjectsBalanceUpDTO = new BizSubjectsBalanceUpDTO();
//            bizSubjectsBalanceUpDTO.setDeptId(deptId);
//            bizSubjectsBalanceUpDTO.setSubjectsId(bizCostBudgetSubjects.getSubjectsId());
//
//            BigDecimal deptCostRatio = BigDecimal.valueOf(bizCostBudgetDept.getCostRatio()).divide(BigDecimal.valueOf(100));
//            BigDecimal subCostRatio = BigDecimal.valueOf(bizCostBudgetSubjects.getCostRatio()).divide(BigDecimal.valueOf(100));
//
//            BigDecimal am = amount.multiply(deptCostRatio).multiply(subCostRatio);
//
//            bizSubjectsBalanceUpDTO.setAmount(am);
//            increaseAmount(bizSubjectsBalanceUpDTO);
//        }
    }

    @Override
    public ResultBean increaseAmount(BizSubjectsBalanceUpDTO bizSubjectsUp) {
        BizSubjectsBalanceExample bizSubjectsBalanceExample = new BizSubjectsBalanceExample();
        BizSubjectsBalanceExample.Criteria criteria = bizSubjectsBalanceExample.createCriteria();
        criteria.andDeptIdEqualTo(bizSubjectsUp.getDeptId());
        criteria.andSubjectsIdEqualTo(bizSubjectsUp.getSubjectsId());
        bizSubjectsBalanceExample.setOrderByClause("id desc limit 1");
        List<BizSubjectsBalance> bizSubjectsBalanceList = subjectsBalanceMapper.selectByExample(bizSubjectsBalanceExample);
        if (CollectionUtils.isEmpty(bizSubjectsBalanceList)) {
            // 账户不存在 先创建账户
            BizSubjectsBalance bizSubjectsBalance = new BizSubjectsBalance();
            BeanUtils.copyProperties(bizSubjectsUp, bizSubjectsBalance);
            bizSubjectsBalance.setBalanceAmount(BigDecimal.ZERO);
            bizSubjectsBalance.setCreateTime(new Date());
            bizSubjectsBalance.setUpdateTime(new Date());
            bizSubjectsBalance.setCreateUser(sysUserService.selectLoginUser().getId());
            bizSubjectsBalance.setUpdateUser(sysUserService.selectLoginUser().getId());
            int insertId = subjectsBalanceMapper.insertSelective(bizSubjectsBalance);
            bizSubjectsBalanceList = subjectsBalanceMapper.selectByExample(bizSubjectsBalanceExample);
        }

        BizCostBudgetSubjectsExample bizCostBudgetSubjectsExample = new BizCostBudgetSubjectsExample();
        BizCostBudgetSubjectsExample.Criteria costBudgetSubjectsExampleCriteria = bizCostBudgetSubjectsExample.createCriteria();
        costBudgetSubjectsExampleCriteria.andDeptIdEqualTo(bizSubjectsUp.getDeptId());
        costBudgetSubjectsExampleCriteria.andSubjectsIdEqualTo(bizSubjectsUp.getSubjectsId());

        List<BizCostBudgetSubjects> costBudgetSubjectsList = costBudgetSubjectsMapper.selectByExample(bizCostBudgetSubjectsExample);
        BizCostBudgetSubjects bizCostBudgetSubjects = costBudgetSubjectsList.get(0);


        // 更新余额表
        BizSubjectsBalance bizSubjectsBalance = bizSubjectsBalanceList.get(0);
        BigDecimal add = bizSubjectsBalance.getBalanceAmount().add(bizSubjectsUp.getAmount());
        BizSubjectsBalance subjectsBalanceUp = new BizSubjectsBalance();
        subjectsBalanceUp.setId(bizSubjectsBalance.getId());
        subjectsBalanceUp.setBalanceAmount(add);
        subjectsBalanceUp.setUpdateTime(new Date());
        subjectsBalanceUp.setUpdateUser(sysUserService.selectLoginUser().getId());
        int update = subjectsBalanceMapper.updateByPrimaryKeySelective(subjectsBalanceUp);

        // 添加流水
        BizSubjectsBalanceFlow bizSubjectsBalanceFlow = new BizSubjectsBalanceFlow();
        bizSubjectsBalanceFlow.setBalanceAmount(add);
        bizSubjectsBalanceFlow.setAmount(bizSubjectsUp.getAmount());
        bizSubjectsBalanceFlow.setDeptId(bizSubjectsUp.getDeptId());
        bizSubjectsBalanceFlow.setSubjectsId(bizSubjectsUp.getSubjectsId());
        bizSubjectsBalanceFlow.setCostRatio(bizCostBudgetSubjects.getCostRatio());
        bizSubjectsBalanceFlow.setType("1");
        bizSubjectsBalanceFlow.setCreateTime(new Date());
        bizSubjectsBalanceFlow.setUpdateTime(new Date());
        bizSubjectsBalanceFlow.setCreateUser(sysUserService.selectLoginUser().getId());
        bizSubjectsBalanceFlow.setUpdateUser(sysUserService.selectLoginUser().getId());
        subjectsBalanceFlowMapper.insertSelective(bizSubjectsBalanceFlow);

        return ResultBean.success(update);
    }


    @Override
    public ResultBean decreaseAmount(BizSubjectsBalanceUpDTO bizSubjectsUp) {
        BizSubjectsBalanceExample bizSubjectsBalanceExample = new BizSubjectsBalanceExample();
        BizSubjectsBalanceExample.Criteria criteria = bizSubjectsBalanceExample.createCriteria();
        criteria.andDeptIdEqualTo(bizSubjectsUp.getDeptId());
        criteria.andSubjectsIdEqualTo(bizSubjectsUp.getSubjectsId());
        bizSubjectsBalanceExample.setOrderByClause("id desc limit 1");
        List<BizSubjectsBalance> bizSubjectsBalanceList = subjectsBalanceMapper.selectByExample(bizSubjectsBalanceExample);
        if (CollectionUtils.isEmpty(bizSubjectsBalanceList)){
            throw new BaseException("当前科目未配置预算");
        }

        // 更新余额表
        BizSubjectsBalance bizSubjectsBalance = bizSubjectsBalanceList.get(0);
        BigDecimal subtract = bizSubjectsBalance.getBalanceAmount().subtract(bizSubjectsUp.getAmount());
        if (subtract.compareTo(BigDecimal.ZERO) < 0) {
            throw new BaseException("当前科目余额不足");
        }

        BizSubjectsBalance subjectsBalanceUp = new BizSubjectsBalance();
        subjectsBalanceUp.setId(bizSubjectsBalance.getId());
        subjectsBalanceUp.setBalanceAmount(subtract);
        subjectsBalanceUp.setUpdateTime(new Date());
        subjectsBalanceUp.setUpdateUser(sysUserService.selectLoginUser().getId());
        int update = subjectsBalanceMapper.updateByPrimaryKeySelective(subjectsBalanceUp);


        BizCostBudgetSubjectsExample bizCostBudgetSubjectsExample = new BizCostBudgetSubjectsExample();
        BizCostBudgetSubjectsExample.Criteria costBudgetSubjectsExampleCriteria = bizCostBudgetSubjectsExample.createCriteria();
        costBudgetSubjectsExampleCriteria.andDeptIdEqualTo(bizSubjectsUp.getDeptId());
        costBudgetSubjectsExampleCriteria.andSubjectsIdEqualTo(bizSubjectsUp.getSubjectsId());
        List<BizCostBudgetSubjects> costBudgetSubjectsList = costBudgetSubjectsMapper.selectByExample(bizCostBudgetSubjectsExample);
        BizCostBudgetSubjects bizCostBudgetSubjects = costBudgetSubjectsList.get(0);
        // 添加流水
        BizSubjectsBalanceFlow bizSubjectsBalanceFlow = new BizSubjectsBalanceFlow();
        bizSubjectsBalanceFlow.setBalanceAmount(subtract);
        bizSubjectsBalanceFlow.setAmount(bizSubjectsUp.getAmount());
        bizSubjectsBalanceFlow.setDeptId(bizSubjectsUp.getDeptId());
        bizSubjectsBalanceFlow.setSubjectsId(bizSubjectsUp.getSubjectsId());
        bizSubjectsBalanceFlow.setCostRatio(bizCostBudgetSubjects.getCostRatio());
        bizSubjectsBalanceFlow.setType("2");
        bizSubjectsBalanceFlow.setCreateTime(new Date());
        bizSubjectsBalanceFlow.setUpdateTime(new Date());
        bizSubjectsBalanceFlow.setCreateUser(sysUserService.selectLoginUser().getId());
        bizSubjectsBalanceFlow.setUpdateUser(sysUserService.selectLoginUser().getId());
        subjectsBalanceFlowMapper.insertSelective(bizSubjectsBalanceFlow);

        return ResultBean.success(update);
    }

    @Override
    public ResultBean<BizSubjectsBalanceRSDTO> getInfo(Integer deptId, Integer subjectsId) {
        BizSubjectsBalanceExample bizSubjectsBalanceExample = new BizSubjectsBalanceExample();
        BizSubjectsBalanceExample.Criteria criteria = bizSubjectsBalanceExample.createCriteria();
        criteria.andDeptIdEqualTo(deptId);
        criteria.andSubjectsIdEqualTo(subjectsId);
        bizSubjectsBalanceExample.setOrderByClause("id desc limit 1");
        List<BizSubjectsBalance> bizSubjectsBalanceList = subjectsBalanceMapper.selectByExample(bizSubjectsBalanceExample);
        if (CollectionUtils.isEmpty(bizSubjectsBalanceList)) {
            return ResultBean.success(null);
        }

        BizSubjectsBalance bizSubjectsBalance = bizSubjectsBalanceList.get(0);
        BizSubjectsBalanceRSDTO bizSubjectsRSDTO = new BizSubjectsBalanceRSDTO();
        BeanUtils.copyProperties(bizSubjectsBalance, bizSubjectsRSDTO);

        return ResultBean.success(bizSubjectsRSDTO);
    }

    @Override
    public ResultBean<PageDTO<BizSubjectsBalanceRSDTO>> getList(BizSubjectsBalanceRQDTO model) {
        if (model.getPageNum() == null || model.getPageNum() == 0) {
            model.setPageNum(1);
        }
        if (model.getPageSize() == null || model.getPageSize() == 0) {
            model.setPageSize(10);
        }
        BizSubjectsBalanceExample bizSubjectsBalanceExample = new BizSubjectsBalanceExample();
        BizSubjectsBalanceExample.Criteria criteria = bizSubjectsBalanceExample.createCriteria();
        bizSubjectsBalanceExample.setOrderByClause("id desc");
        Page<BizSubjectsBalance> pageData = PageHelper.startPage(model.getPageNum(), model.getPageSize()).doSelectPage(() -> {
            subjectsBalanceMapper.selectByExample(bizSubjectsBalanceExample);
        });

        Map<String, String> dictMap = sysDictService.getSysDictByTypeCode(DictEnum.SUBJECTS_TYPE.getCode()).stream()
            .collect(Collectors.toMap(SysDict::getCode, SysDict::getName, (a, b) -> a));


        List<SysDepartment> sysDepartments = departmentMapper.selectByExample(new SysDepartmentExample());
        Map<Integer, SysDepartment> sysDepartmentMap = sysDepartments.stream().collect(Collectors.toMap(SysDepartment::getId, Function.identity()));


        PageDTO<BizSubjectsBalanceRSDTO> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);
        List<BizSubjectsBalanceRSDTO> bizSubjectsRSDTOList = pageData.getResult().stream()
            .map(subject -> {
                BizSubjectsBalanceRSDTO bizSubjectsRSDTO = new BizSubjectsBalanceRSDTO();
                BeanUtils.copyProperties(subject, bizSubjectsRSDTO);
                bizSubjectsRSDTO.setSubjectsTypeName(dictMap.get(subject.getSubjectsTypeCode()));

                SysDepartment sysDepartment = sysDepartmentMap.get(subject.getDeptId());
                bizSubjectsRSDTO.setDeptName(sysDepartment == null ? "" : sysDepartment.getDeptName());

                return bizSubjectsRSDTO;
            })
            .collect(Collectors.toList());

        pageDTO.setList(bizSubjectsRSDTOList);
        return ResultBean.success(pageDTO);
    }

    @Override
    public Map<String, BigDecimal>  getSubjectsBalanceAll(){
        BizSubjectsBalanceExample bizSubjectsBalanceExample = new BizSubjectsBalanceExample();
        List<BizSubjectsBalance> bizSubjectsBalanceList = subjectsBalanceMapper.selectByExample(bizSubjectsBalanceExample);

        Map<String, BigDecimal> bigDecimalMap = bizSubjectsBalanceList.stream()
            .map(bizSubjectsBalance -> {
                String k = bizSubjectsBalance.getDeptId() + "_" + bizSubjectsBalance.getSubjectsId();
                return new cn.hutool.core.lang.Pair<>(k, bizSubjectsBalance.getBalanceAmount());
            })
            .collect(Collectors.toMap(cn.hutool.core.lang.Pair::getKey, Pair::getValue, (a, b) -> a));

        return bigDecimalMap;
    }


    @Override
    public ResultBean<List<BizSubjectsBalanceRSDTO>> getSubjectsListAll() {
        BizSubjectsBalanceExample bizSubjectsExample = new BizSubjectsBalanceExample();
        bizSubjectsExample.setOrderByClause("id desc");
        List<BizSubjectsBalance> bizSubjects = subjectsBalanceMapper.selectByExample(bizSubjectsExample);

        Map<String, String> dictMap = sysDictService.getSysDictByTypeCode(DictEnum.SUBJECTS_TYPE.getCode()).stream()
            .collect(Collectors.toMap(SysDict::getCode, SysDict::getName, (a, b) -> a));

        List<SysDepartment> sysDepartments = departmentMapper.selectByExample(new SysDepartmentExample());
        Map<Integer, SysDepartment> sysDepartmentMap = sysDepartments.stream().collect(Collectors.toMap(SysDepartment::getId, Function.identity()));


        List<BizSubjectsBalanceRSDTO> bizSubjectsRSDTOList = bizSubjects.stream().map(subject -> {
            BizSubjectsBalanceRSDTO bizSubjectsRSDTO = new BizSubjectsBalanceRSDTO();
            BeanUtils.copyProperties(subject, bizSubjectsRSDTO);
            bizSubjectsRSDTO.setSubjectsTypeName(dictMap.get(subject.getSubjectsTypeCode()));

            SysDepartment sysDepartment = sysDepartmentMap.get(subject.getDeptId());
            bizSubjectsRSDTO.setDeptName(sysDepartment == null ? "" : sysDepartment.getDeptName());

            return bizSubjectsRSDTO;
        }).collect(Collectors.toList());
        return ResultBean.success(bizSubjectsRSDTOList);
    }

    @Override
    public ResultBean<BizSubjectsBalanceRSDTO> getCurUserSubjectsBalance(Integer subjectId) {
        CustomUser customUser = sysUserService.selectLoginUser();
        SysUser sysUser = sysUserService.getSysUser(customUser.getId());
        BizSubjectsBalanceExample bizSubjectsExample = new BizSubjectsBalanceExample();
        BizSubjectsBalanceExample.Criteria criteria = bizSubjectsExample.createCriteria();
        criteria.andDeptIdEqualTo(sysUser.getDepartId());
        criteria.andSubjectsIdEqualTo(subjectId);
        bizSubjectsExample.setOrderByClause("id desc limit 1");

        List<BizSubjectsBalance> bizSubjects = subjectsBalanceMapper.selectByExample(bizSubjectsExample);
        if (CollectionUtils.isEmpty(bizSubjects)){
            return ResultBean.success(null);
        }


        Map<String, String> dictMap = sysDictService.getSysDictByTypeCode(DictEnum.SUBJECTS_TYPE.getCode()).stream()
            .collect(Collectors.toMap(SysDict::getCode, SysDict::getName, (a, b) -> a));

        List<SysDepartment> sysDepartments = departmentMapper.selectByExample(new SysDepartmentExample());
        Map<Integer, SysDepartment> sysDepartmentMap = sysDepartments.stream().collect(Collectors.toMap(SysDepartment::getId, Function.identity()));


        List<BizSubjectsBalanceRSDTO> bizSubjectsRSDTOList = bizSubjects.stream().map(subject -> {
            BizSubjectsBalanceRSDTO bizSubjectsRSDTO = new BizSubjectsBalanceRSDTO();
            BeanUtils.copyProperties(subject, bizSubjectsRSDTO);
            bizSubjectsRSDTO.setSubjectsTypeName(dictMap.get(subject.getSubjectsTypeCode()));
            SysDepartment sysDepartment = sysDepartmentMap.get(subject.getDeptId());
            bizSubjectsRSDTO.setDeptName(sysDepartment == null ? "" : sysDepartment.getDeptName());
            return bizSubjectsRSDTO;
        }).collect(Collectors.toList());
        return ResultBean.success(bizSubjectsRSDTOList.get(0));

    }
}
