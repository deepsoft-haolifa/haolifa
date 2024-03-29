package com.deepsoft.haolifa.service.impl.finance;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
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
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Slf4j
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

        BizProjectBudget projectBudget = bizProjectBudgetMapper.selectByPrimaryKey(assetsUpDTO.getId());

        BigDecimal updateAmount = assetsUpDTO.getTotalQuota().subtract(projectBudget.getTotalQuota());

        BigDecimal balance = updateAmount.add(projectBudget.getBalanceQuota());
        if (balance.compareTo(BigDecimal.ZERO)<0){
            return ResultBean.error("修改后余额不能小于0");
        }

        log.info("ProjectBudgetService update 修改金额 = "+updateAmount);

        BizProjectBudget bizProjectBudget = new BizProjectBudget();
        BeanUtils.copyProperties(assetsUpDTO, bizProjectBudget);
        bizProjectBudget.setBalanceQuota(balance);
        bizProjectBudget.setUpdateTime(new Date());
        bizProjectBudget.setUpdateBy(sysUserService.selectLoginUser().getId().toString());
        int i = bizProjectBudgetMapper.updateByPrimaryKeySelective(bizProjectBudget);
        return ResultBean.success(i);
    }

    @Override
    public ResultBean decrement(ProjectBudgetDecDTO assetsUpDTO) {
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

        if (ObjectUtil.isNotEmpty(model.getDeptId())) {
            criteria.andDeptIdEqualTo(model.getDeptId());
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
        bizProjectBudgetExample.setOrderByClause("create_time desc");

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
        model.setPageNum(1);
        model.setPageSize(Integer.MAX_VALUE);

        BizProjectBudgetExample bizProjectBudgetExample = new BizProjectBudgetExample();
        BizProjectBudgetExample.Criteria criteria = bizProjectBudgetExample.createCriteria();
        criteria.andDelFlagEqualTo(CommonEnum.DelFlagEnum.YES.code);

        // todo 只能查询自己部门的
        Integer sysUserId = sysUserService.selectLoginUser().getId();
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(sysUserId);
        Integer departId = sysUser.getDepartId();
        criteria.andDeptIdEqualTo(departId);

        // 当前年
        Date currentDate = new Date();
        String year = DateUtil.year(currentDate) + "";
        criteria.andYearEqualTo(year);
        // 当前月
        Integer dd = Integer.parseInt(DateUtil.format(currentDate, "dd"));
        if (dd < 26) {
            int month = DateUtil.month(currentDate) + 1;
            if (month<9){
                criteria.andMonthEqualTo("0"+month + "");
            }else {
                criteria.andMonthEqualTo(month + "");
            }
        } else {
            int month = DateUtil.month(currentDate) + 2;
            if (month<9){
                criteria.andMonthEqualTo("0"+month + "");
            }else {
                criteria.andMonthEqualTo(month + "");
            }
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
    public ResultBean<List<ProjectBudgetRSDTO>> getCurProjectBudgetList(ProjectBudgetRQBillDTO model) {

        BizProjectBudgetExample bizProjectBudgetExample = new BizProjectBudgetExample();
        BizProjectBudgetExample.Criteria criteria = bizProjectBudgetExample.createCriteria();
        criteria.andDelFlagEqualTo(CommonEnum.DelFlagEnum.YES.code);
        criteria.andDeptIdEqualTo(model.getDeptId());

        // 当前年
        Date currentDate = new Date();
        String year = DateUtil.year(currentDate) + "";
        criteria.andYearEqualTo(year);
        // 当前月
        Integer dd = Integer.parseInt(DateUtil.format(currentDate, "dd"));
        if (dd < 26) {
            int month = DateUtil.month(currentDate) + 1;
            if (month<9){
                criteria.andMonthEqualTo("0"+month + "");
            }else {
                criteria.andMonthEqualTo(month + "");
            }
        } else {
            int month = DateUtil.month(currentDate) + 2;
            if (month<9){
                criteria.andMonthEqualTo("0"+month + "");
            }else {
                criteria.andMonthEqualTo(month + "");
            }
        }


        List<BizProjectBudget> projectBudgetList = bizProjectBudgetMapper.selectByExample(bizProjectBudgetExample);

        List<ProjectBudgetRSDTO> assetsRSDTOList = projectBudgetList.stream()
            .map(assets -> {
                ProjectBudgetRSDTO assetsRSDTO = new ProjectBudgetRSDTO();
                BeanUtils.copyProperties(assets, assetsRSDTO);
                return assetsRSDTO;
            })
            .collect(Collectors.toList());

        return ResultBean.success(assetsRSDTOList);
    }

    @Override
    public BizProjectBudget queryCurMonthBudget(ProjectBudgetQueryBO model) {
        BizProjectBudgetExample bizProjectBudgetExample = new BizProjectBudgetExample();
        BizProjectBudgetExample.Criteria criteria = bizProjectBudgetExample.createCriteria();
        criteria.andDelFlagEqualTo(CommonEnum.DelFlagEnum.YES.code);

        if (StringUtils.isNotEmpty(model.getCode())){
            criteria.andCodeEqualTo(model.getCode());
        }else {
            criteria.andNameEqualTo(model.getName());
        }
        criteria.andDeptIdEqualTo(model.getDeptId());

        String year = DateUtil.year(model.getDate()) + "";
        criteria.andYearEqualTo(year);
        Integer dd = Integer.parseInt(DateUtil.format(model.getDate(), "dd"));

        Date currentDate = model.getDate();

        if (dd < 26) {
            int month = DateUtil.month(currentDate) + 1;
            if (month<9){
                criteria.andMonthEqualTo("0"+month + "");
            }else {
                criteria.andMonthEqualTo(month + "");
            }
        } else {
            int month = DateUtil.month(currentDate) + 2;
            if (month<9){
                criteria.andMonthEqualTo("0"+month + "");
            }else {
                criteria.andMonthEqualTo(month + "");
            }
        }

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
        if (ObjectUtil.isNull(model.getDeptId())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "部门必选");
        }
        return null;
    }
}
