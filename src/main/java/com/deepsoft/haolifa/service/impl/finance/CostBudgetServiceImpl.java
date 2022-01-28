package com.deepsoft.haolifa.service.impl.finance;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.BizCostBudgetDeptMapper;
import com.deepsoft.haolifa.dao.repository.BizCostBudgetSubjectsMapper;
import com.deepsoft.haolifa.dao.repository.SysDepartmentMapper;
import com.deepsoft.haolifa.enums.CostBudgetTypeEnum;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.costbudget.CostBudget;
import com.deepsoft.haolifa.model.dto.finance.costbudget.CostBudgetQuery;
import com.deepsoft.haolifa.model.dto.finance.costbudget.dept.CostBudgetDeptAddUpDTO;
import com.deepsoft.haolifa.model.dto.finance.costbudget.dept.CostBudgetDeptRQDTO;
import com.deepsoft.haolifa.model.dto.finance.costbudget.dept.CostBudgetDeptTree;
import com.deepsoft.haolifa.model.dto.finance.costbudget.dept.CostBudgetDeptUpDTO;
import com.deepsoft.haolifa.model.dto.finance.costbudget.subjects.CostBudgetSubjectsAddDTO;
import com.deepsoft.haolifa.model.dto.finance.costbudget.subjects.CostBudgetSubjectsRQDTO;
import com.deepsoft.haolifa.model.dto.finance.costbudget.subjects.CostBudgetSubjectsRSDTO;
import com.deepsoft.haolifa.model.dto.finance.costbudget.subjects.CostBudgetSubjectsUpDTO;
import com.deepsoft.haolifa.service.DepartmentService;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.service.finance.CostBudgetService;
import com.deepsoft.haolifa.util.TreeUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
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

    @Override
    public ResultBean saveOrUpDeptBudget(CostBudgetDeptAddUpDTO model) {
        log.info("CostBudgetService saveDeptBudget start|{}", JSONObject.toJSON(model));
        if (StringUtils.isAnyBlank()) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        if (model.getCostRatio() > 100 || model.getCostRatio() < 0) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "比例介于0~100之间");
        }

        BizCostBudgetDeptExample bizCostBudgetDeptExample = new BizCostBudgetDeptExample();
        BizCostBudgetDeptExample.Criteria criteria = bizCostBudgetDeptExample.createCriteria();
        criteria.andDeptIdEqualTo(model.getDeptId());
        List<BizCostBudgetDept> bizCostBudgetDepts = bizCostBudgetDeptMapper.selectByExample(bizCostBudgetDeptExample);
        BizCostBudgetDept bizCostBudgetDept = null;
        if (CollectionUtil.isNotEmpty(bizCostBudgetDepts)) {
            bizCostBudgetDept = bizCostBudgetDepts.get(0);
        }

        int i = 0;
        if (bizCostBudgetDept != null) {
            SysDepartment department = departmentMapper.selectByPrimaryKey(model.getDeptId());

            BizCostBudgetDept bizCostBudgetDeptUp = new BizCostBudgetDept();
            bizCostBudgetDeptUp.setId(bizCostBudgetDept.getId());
            bizCostBudgetDeptUp.setName(department.getDeptName());
            bizCostBudgetDeptUp.setCostRatio(bizCostBudgetDept.getCostRatio());
            bizCostBudgetDeptUp.setRemark(bizCostBudgetDept.getRemark());
            bizCostBudgetDeptUp.setUpdateTime(new Date());
            bizCostBudgetDeptUp.setUpdateUser(sysUserService.selectLoginUser().getId());
            i = bizCostBudgetDeptMapper.updateByPrimaryKeySelective(bizCostBudgetDeptUp);
        } else {
            BizCostBudgetDept costBudget = new BizCostBudgetDept();
            BeanUtils.copyProperties(model, costBudget);
            SysDepartment department = departmentMapper.selectByPrimaryKey(model.getDeptId());
            costBudget.setDeptPid(department.getPid());
            costBudget.setName(department.getDeptName());
            costBudget.setDelFlag(CommonEnum.DelFlagEnum.YES.code);
            costBudget.setCreateTime(new Date());
            costBudget.setUpdateTime(new Date());
            costBudget.setCreateUser(sysUserService.selectLoginUser().getId());
            costBudget.setUpdateUser(sysUserService.selectLoginUser().getId());
            i = bizCostBudgetDeptMapper.insertSelective(costBudget);
        }
        return ResultBean.success(i);
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
    public List<CostBudget> selectCostBudget(CostBudgetQuery model) {

        CostBudgetTypeEnum costBudgetTypeEnum = model.getCostBudgetTypeEnum();
        List<CostBudget> costBudgetList = new ArrayList<>();
        switch (costBudgetTypeEnum) {
            case dept:
                // 深度不能超过5层 防止程序&数据bug cpu打满
                AtomicInteger atomicInteger = new AtomicInteger(5);
                List<BizCostBudgetDept> costBudgetDeptList = new ArrayList<>();
                getBizCostBudgetDept(model.getDeptId(), costBudgetDeptList, atomicInteger);
                costBudgetList = costBudgetDeptList.stream()
                    .map(bizCostBudgetDept -> {
                        CostBudget costBudgetRS = new CostBudget();
                        costBudgetRS.setCostRatio(bizCostBudgetDept.getCostRatio());
                        return costBudgetRS;
                    })
                    .collect(Collectors.toList());
                break;
            case subjects:

                break;
        }
        return costBudgetList;
    }

    private void getBizCostBudgetDept(Integer id, List<BizCostBudgetDept> costBudgetDeptList, AtomicInteger atomicInteger) {
        int incrementAndGet = atomicInteger.decrementAndGet();
        if (incrementAndGet == 0) {
            return;
        }
        BizCostBudgetDept bizCostBudgetDept = bizCostBudgetDeptMapper.selectByPrimaryKey(id);
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
                departmentTree.setCostRatio(0);
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
        BizCostBudgetSubjects costBudget = new BizCostBudgetSubjects();
        BeanUtils.copyProperties(model, costBudget);
        costBudget.setCreateTime(new Date());
        costBudget.setUpdateTime(new Date());
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

        BizCostBudgetSubjects costBudget = new BizCostBudgetSubjects();
        BeanUtils.copyProperties(model, costBudget);
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
            criteria.andNameLike(model.getName());
        }
        //科目id==
        if (model.getSubjectsId() != null) {
            criteria.andSubjectsIdEqualTo(model.getSubjectsId());
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

        List<CostBudgetSubjectsRSDTO> rqdtoList = pageData.getResult().stream()
            .map(bizCostBudgetSubjects -> {
                CostBudgetSubjectsRSDTO costBudgetSubjectsRQDTO = new CostBudgetSubjectsRSDTO();
                BeanUtils.copyProperties(bizCostBudgetSubjects, costBudgetSubjectsRQDTO);
                // todo 公式待补充
                costBudgetSubjectsRQDTO.setCostRatioFormula(bizCostBudgetSubjects.getCostRatio() + "%");
                costBudgetSubjectsRQDTO.setCostRatioFormulaCN(bizCostBudgetSubjects.getCostRatio() + "%");
                SysDepartment sysDepartment = sysDepartmentMap.get(bizCostBudgetSubjects.getDeptId());
                costBudgetSubjectsRQDTO.setDeptName(sysDepartment.getDeptName());
                return costBudgetSubjectsRQDTO;
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


}
