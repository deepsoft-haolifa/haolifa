package com.deepsoft.haolifa.service.impl.finance;

import cn.hutool.core.collection.CollectionUtil;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.BizProjectBudgetMapper;
import com.deepsoft.haolifa.dao.repository.SysDepartmentMapper;
import com.deepsoft.haolifa.dao.repository.SysUserMapper;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.projectbudget.*;
import com.deepsoft.haolifa.service.DepartmentService;
import com.deepsoft.haolifa.service.SysDictService;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.service.finance.ProjectBudgetService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ProjectBudgetServiceImpl implements ProjectBudgetService {


    @Autowired
    private SysDepartmentMapper departmentMapper;

    @Resource
    private BizProjectBudgetMapper bizProjectBudgetMapper;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private SysDictService sysDictService;


    @Autowired
    private SysUserMapper sysUserMapper;


    @Override
    public ResultBean save(ProjectBudgetAddDTO model) {
        ResultBean<Object> PARAM_ERROR = validate(model);
        if (PARAM_ERROR != null) {
            return PARAM_ERROR;
        }

        BizProjectBudget bizProjectBudget = new BizProjectBudget();
        BeanUtils.copyProperties(model, bizProjectBudget);
        bizProjectBudget.setBalanceQuota(model.getTotalQuota());

        bizProjectBudget.setStatus("1");
        bizProjectBudget.setCreateTime(new Date());
        bizProjectBudget.setUpdateTime(new Date());
        bizProjectBudget.setUpdateBy(sysUserService.selectLoginUser().getId().toString());
        bizProjectBudget.setCreateBy(sysUserService.selectLoginUser().getId().toString());
        int insertId = bizProjectBudgetMapper.insertSelective(bizProjectBudget);
        return ResultBean.success(insertId);
    }

    @Override
    public ResultBean delete(int id) {
        int i = bizProjectBudgetMapper.deleteByPrimaryKey((long) id);
        return ResultBean.success(i);
    }

    @Override
    public ResultBean update(ProjectBudgetUpDTO assetsUpDTO) {

//        if (StringUtils.isEmpty(assetsUpDTO.getName())) {
//            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "code");
//        }
//        if (StringUtils.isEmpty(assetsUpDTO.getCode())) {
//            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "name");
//        }

        BizProjectBudget bizProjectBudget = new BizProjectBudget();
        BeanUtils.copyProperties(assetsUpDTO, bizProjectBudget);
        bizProjectBudget.setUpdateTime(new Date());
        bizProjectBudget.setUpdateBy(sysUserService.selectLoginUser().getId().toString());
        int i = bizProjectBudgetMapper.updateByPrimaryKeySelective(bizProjectBudget);
        return ResultBean.success(i);
    }

    @Override
    public ResultBean<PageDTO<ProjectBudgetRSDTO>> getList(ProjectBudgetRQDTO model) {
        if (model.getPageNum() == null || model.getPageNum() == 0) {
            model.setPageNum(1);
        }
        if (model.getPageSize() == null || model.getPageSize() == 0) {
            model.setPageSize(10);
        }
        BizProjectBudgetExample bizProjectBudgetExample = new BizProjectBudgetExample();
        BizProjectBudgetExample.Criteria criteria = bizProjectBudgetExample.createCriteria();
        criteria.andDelFlagEqualTo(CommonEnum.DelFlagEnum.YES.code);

        if (StringUtils.isNotEmpty(model.getName())) {
            criteria.andNameLike("%" + model.getName() + "%");
        }
        if (StringUtils.isNotEmpty(model.getCode())) {
            criteria.andCodeLike("%" + model.getCode() + "%");
        }

        if (StringUtils.isNotEmpty(model.getYear())) {
            criteria.andYearEqualTo(model.getYear());
        }

        if (StringUtils.isNotEmpty(model.getMonth())) {
            criteria.andMonthEqualTo(model.getMonth());
        }

        if (StringUtils.isNotEmpty(model.getDeptName())) {
            SysDepartmentExample departmentExample = new SysDepartmentExample();
            departmentExample.createCriteria().andDeptNameLike("%" + model.getDeptName() + "%");
            List<SysDepartment> sysDepartments = departmentMapper.selectByExample(departmentExample);
            if (CollectionUtil.isNotEmpty(sysDepartments)) {
                List<Integer> integerList = sysDepartments.stream().map(SysDepartment::getId).collect(Collectors.toList());
                criteria.andDeptIdIn(integerList);
            } else {
                criteria.andDeptIdEqualTo(-1);
            }
        }

        Page<BizProjectBudget> pageData = PageHelper
            .startPage(model.getPageNum(), model.getPageSize())
            .doSelectPage(() -> {
                bizProjectBudgetMapper.selectByExample(bizProjectBudgetExample);
            });


        List<SysDepartment> sysDepartments = departmentMapper.selectByExample(new SysDepartmentExample());
        Map<Integer, SysDepartment> sysDepartmentMap = sysDepartments.stream()
            .collect(Collectors.toMap(SysDepartment::getId, Function.identity()));

        List<ProjectBudgetRSDTO> assetsRSDTOList = pageData.getResult().stream()
            .map(assets -> {
                ProjectBudgetRSDTO assetsRSDTO = new ProjectBudgetRSDTO();
                BeanUtils.copyProperties(assets, assetsRSDTO);
                SysDepartment sysDepartment = sysDepartmentMap.get(assets.getDeptId());
                assetsRSDTO.setDeptName(sysDepartment.getDeptName());
                return assetsRSDTO;
            })
            .collect(Collectors.toList());

        PageDTO<ProjectBudgetRSDTO> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);
        pageDTO.setList(assetsRSDTOList);
        return ResultBean.success(pageDTO);
    }


    @Override
    public ResultBean<PageDTO<ProjectBudgetRSDTO>> getCurUserProjectBudgetList(ProjectBudgetRQDTO model) {
        if (model.getPageNum() == null || model.getPageNum() == 0) {
            model.setPageNum(1);
        }
        if (model.getPageSize() == null || model.getPageSize() == 0) {
            model.setPageSize(10);
        }


        BizProjectBudgetExample bizProjectBudgetExample = new BizProjectBudgetExample();
        BizProjectBudgetExample.Criteria criteria = bizProjectBudgetExample.createCriteria();
        criteria.andDelFlagEqualTo(CommonEnum.DelFlagEnum.YES.code);

        // todo 只能查询自己部门的
        Integer sysUserId = sysUserService.selectLoginUser().getId();
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(sysUserId);
        Integer departId = sysUser.getDepartId();
        criteria.andDeptIdEqualTo(departId);

        if (StringUtils.isNotEmpty(model.getName())) {
            criteria.andNameLike("%" + model.getName() + "%");
        }
        if (StringUtils.isNotEmpty(model.getCode())) {
            criteria.andCodeLike("%" + model.getCode() + "%");
        }

        Page<BizProjectBudget> pageData = PageHelper
            .startPage(model.getPageNum(), model.getPageSize())
            .doSelectPage(() -> {
                bizProjectBudgetMapper.selectByExample(bizProjectBudgetExample);
            });


        List<ProjectBudgetRSDTO> assetsRSDTOList = pageData.getResult().stream()
            .map(assets -> {
                ProjectBudgetRSDTO assetsRSDTO = new ProjectBudgetRSDTO();
                BeanUtils.copyProperties(assets, assetsRSDTO);
                return assetsRSDTO;
            })
            .collect(Collectors.toList());

        PageDTO<ProjectBudgetRSDTO> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);
        pageDTO.setList(assetsRSDTOList);
        return ResultBean.success(pageDTO);
    }

    @Override
    public BizProjectBudget queryCurMonthBudget(ProjectBudgetQueryBO model) {
        BizProjectBudgetExample bizProjectBudgetExample = new BizProjectBudgetExample();
        BizProjectBudgetExample.Criteria criteria = bizProjectBudgetExample.createCriteria();
        criteria.andDelFlagEqualTo(CommonEnum.DelFlagEnum.YES.code);

        criteria.andCodeEqualTo(model.getCode());
        criteria.andDeptIdEqualTo(model.getDeptId());
        criteria.andYearEqualTo(model.getYear());
        criteria.andMonthEqualTo(model.getMonth());

        bizProjectBudgetExample.setOrderByClause("create_time desc limit 1");
        List<BizProjectBudget> projectBudgetList = bizProjectBudgetMapper.selectByExample(bizProjectBudgetExample);
        BizProjectBudget bizProjectBudget = projectBudgetList.stream()
            .findFirst()
            .orElse(null);
        return bizProjectBudget;
    }

    private ResultBean<Object> validate(ProjectBudgetAddDTO model) {
        if (StringUtils.isEmpty(model.getName())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "code");
        }
        if (StringUtils.isEmpty(model.getCode())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "name");
        }
        return null;
    }
}
