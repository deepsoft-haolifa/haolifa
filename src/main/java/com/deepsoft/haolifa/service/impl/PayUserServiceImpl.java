package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.*;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.CustomUser;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.RoleDTO;
import com.deepsoft.haolifa.model.dto.pay.PayUserDTO;
import com.deepsoft.haolifa.model.vo.pay.PayUserVO;
import com.deepsoft.haolifa.model.vo.pay.UserDetailVo;
import com.deepsoft.haolifa.service.PayUserService;
import com.deepsoft.haolifa.service.PayWagesRelationUserService;
import com.deepsoft.haolifa.service.RoleService;
import com.deepsoft.haolifa.util.CommonUtil;
import com.deepsoft.haolifa.util.DateFormatterUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author liuyaofei
 * @Date create in 下午4:51 2021/9/11
 * @description 人员管理
 */
@Service
public class PayUserServiceImpl extends BaseService implements PayUserService {
    @Resource
    private PayUserMapper payUserMapper;
    @Resource
    private PayUserRelationProcedureMapper payUserRelationProcedureMapper;
    @Resource
    private SysDepartmentMapper departmentMapper;
    @Resource
    private PayWagesMapper payWagesMapper;
    @Resource
    private PayProductionWorkshopMapper payProductionWorkshopMapper;
    @Resource
    private PayWagesRelationUserMapper payWagesRelationUserMapper;
    @Resource
    private PayWagesRelationUserService payWagesRelationUserService;
    @Resource
    private PayTeamMapper payTeamMapper;
    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private SysUserMapper userMapper;
    @Resource
    private RoleService roleService;
    @Resource
    private SysDepartmentMapper sysDepartmentMapper;
    @Override
    public ResultBean pageInfo(PayUserDTO model) {
        PayUserExample example = new PayUserExample();
        PayUserExample.Criteria criteria = example.createCriteria();

        // 获取当前登录人的岗位ID作为人员列表的直属上级ID。
//        CustomUser customUser = sysUserService.selectLoginUser();
//        if (Objects.nonNull(customUser) && Objects.nonNull(customUser.getId())) {
//            List<RoleDTO> rolesByUserId = roleService.getRolesByUserId(customUser.getId());
//            if (!rolesByUserId.stream().map(RoleDTO::getRoleName)
//                .collect(Collectors.toList()).contains("ROLE_ADMIN")) {
//                Set<Integer> postList = new HashSet<>();
//                SysUser sysUser = sysUserService.getSysUser(customUser.getId());
//                postList.add(sysUser.getPostId());
//                querySubordinates(sysUser.getPostId(), postList);
//                criteria.andPostIdIn(new ArrayList<>(postList));
//            }
            // 当前人员的 下级
//            if (!rolesByUserId.stream().map(RoleDTO::getRoleName)
//                .collect(Collectors.toList()).contains("ROLE_ADMIN")) {
//                SysUser sysUser = sysUserService.getSysUser(customUser.getId());
//                criteria.andSuperiorIdEqualTo(sysUser.getPostId());
//            }
//        }
        if (StringUtils.isNotBlank(model.getPostName())) {
            PayProductionWorkshopExample payProductionWorkshopExample = new PayProductionWorkshopExample();
            payProductionWorkshopExample.createCriteria().andPostNameEqualTo(model.getPostName());
            List<PayProductionWorkshop> list = payProductionWorkshopMapper.selectByExample(payProductionWorkshopExample);
            if (CollectionUtils.isNotEmpty(list)) {
                List<Integer> collect = list.stream().map(pp -> pp.getId()).collect(Collectors.toList());
                criteria.andPostIdIn(collect);
            }
        }
        if (StringUtils.isNotBlank(model.getSuperiorName())) {
            PayProductionWorkshopExample payProductionWorkshopExample = new PayProductionWorkshopExample();
            payProductionWorkshopExample.createCriteria().andPostNameEqualTo(model.getSuperiorName());
            List<PayProductionWorkshop> list = payProductionWorkshopMapper.selectByExample(payProductionWorkshopExample);
            if (CollectionUtils.isNotEmpty(list)) {
                List<Integer> collect = list.stream().map(pp -> pp.getId()).collect(Collectors.toList());
                criteria.andSuperiorIdIn(collect);
            }
        }
        if (StringUtils.isNotBlank(model.getDepartName())) {
            SysDepartmentExample sysDepartmentExample = new SysDepartmentExample();
            SysDepartmentExample.Criteria crit = sysDepartmentExample.createCriteria();
            crit.andDeptNameLike("%" + model.getDepartName() + "%");
            List<SysDepartment> sysDepartments = sysDepartmentMapper.selectByExample(sysDepartmentExample);
            if (CollectionUtils.isNotEmpty(sysDepartments)) {
                List<Integer> collect = sysDepartments.stream().map(ss -> ss.getId()).collect(Collectors.toList());
                criteria.andDepartIdIn(collect);
            }
        }
        if (StringUtils.isNotBlank(model.getUserNo())) {
            criteria.andUserNoLike("%" + model.getUserNo() + "%");
        }
        if (StringUtils.isNotBlank(model.getUserName())) {
            criteria.andUserNameLike("%" + model.getUserName() + "%");
        }
        if (null != model.getSex() && model.getSex() > 0) {
            criteria.andSexEqualTo(model.getSex());
        }
        if (StringUtils.isNotBlank(model.getUserType())) {
            criteria.andUserTypeEqualTo(model.getUserType());
        }
        if (StringUtils.isNotBlank(model.getNation())) {
            criteria.andNationLike("%" + model.getNation() + "%");
        }
        if (StringUtils.isNotBlank(model.getPoliticalOutlook())) {
            criteria.andPoliticalOutlookLike("%" + model.getPoliticalOutlook() + "%");
        }
        if (StringUtils.isNotBlank(model.getBloodType())) {
            criteria.andBloodTypeEqualTo(model.getBloodType());
        }
        if (StringUtils.isNotBlank(model.getHealth())) {
            criteria.andHealthLike("%" + model.getHealth() + "%");
        }
        if (Objects.nonNull(model.getMarryStatus()) && model.getMarryStatus() > 0) {
            criteria.andMarryStatusEqualTo(model.getMarryStatus());
        }
        if (StringUtils.isNotBlank(model.getUniversityFrom())) {
            criteria.andUniversityFromLike("%" + model.getUniversityFrom() + "%");
        }
        if (StringUtils.isNotBlank(model.getMajor())) {
            criteria.andMajorLike("%" + model.getMajor() + "%");
        }
        if (Objects.nonNull(model.getEducation()) && model.getEducation() > 0) {
            criteria.andEducationEqualTo(model.getMarryStatus());
        }
        if (StringUtils.isNotEmpty(model.getStartGraduationTime())) {
            Date startDate = DateFormatterUtils.parseDateString(DateFormatterUtils.THREE_FORMATTERPATTERN, model.getStartGraduationTime());
            criteria.andGraduationTimeGreaterThan(startDate);
        }
        if (StringUtils.isNotEmpty(model.getEndGraduationTime())) {
            Date endDate = DateFormatterUtils.parseDateString(DateFormatterUtils.THREE_FORMATTERPATTERN, model.getEndGraduationTime());
            criteria.andGraduationTimeLessThan(endDate);
        }
        if (StringUtils.isNotEmpty(model.getStartWorkingTime())) {
            Date startDate = DateFormatterUtils.parseDateString(DateFormatterUtils.THREE_FORMATTERPATTERN, model.getStartWorkingTime());
            criteria.andWorkingTimeGreaterThan(startDate);
        }
        if (StringUtils.isNotEmpty(model.getEndWorkingTime())) {
            Date endDate = DateFormatterUtils.parseDateString(DateFormatterUtils.THREE_FORMATTERPATTERN, model.getEndWorkingTime());
            criteria.andWorkingTimeLessThan(endDate);
        }
        if (StringUtils.isNotBlank(model.getPhone())) {
            criteria.andPhoneEqualTo(model.getPhone());
        }
        if (Objects.nonNull(model.getTeamId())) {
            criteria.andTeamIdEqualTo(model.getTeamId());
        }
        if (StringUtils.isNotEmpty(model.getStartCreateTime())) {
            Date startDate = DateFormatterUtils.parseDateString(DateFormatterUtils.THREE_FORMATTERPATTERN, model.getStartCreateTime());
            criteria.andCreateTimeGreaterThan(startDate);
        }
        if (StringUtils.isNotEmpty(model.getEndCreateTime())) {
            Date endDate = DateFormatterUtils.parseDateString(DateFormatterUtils.THREE_FORMATTERPATTERN, model.getEndCreateTime());
            criteria.andCreateTimeLessThan(endDate);
        }
        example.setOrderByClause("id desc");
        Page<PayUser> payUsers = PageHelper.startPage(model.getPageNum(), model.getPageSize())
            .doSelectPage(() -> payUserMapper.selectByExample(example));
        List<PayUserDTO> list = Lists.newArrayList();
        payUsers.forEach(payUser -> {
            PayUserDTO payUserDTO = new PayUserDTO();
            BeanUtils.copyProperties(payUser, payUserDTO);
            PayTeam payTeam = payTeamMapper.selectByPrimaryKey(payUser.getTeamId());
            payUserDTO.setTeamName(Objects.isNull(payTeam) ? "" : payTeam.getTeamName());
            PayProductionWorkshop payProductionWorkshop = payProductionWorkshopMapper.selectByPrimaryKey(payUser.getPostId());
            payUserDTO.setPostName(Objects.isNull(payProductionWorkshop) ? "" : payProductionWorkshop.getPostName());
                PayProductionWorkshop workshop = payProductionWorkshopMapper.selectByPrimaryKey(payUser.getSuperiorId());
            payUserDTO.setSuperiorName(Objects.isNull(workshop) ? "" : workshop.getPostName());
            PayUser parentUser = payUserMapper.selectByPrimaryKey(payUser.getParentId());
            payUserDTO.setParentUserName(Objects.isNull(parentUser) ? "" : parentUser.getUserName());
            SysDepartment sysDepartment = departmentMapper.selectByPrimaryKey(payUser.getDepartId());
            payUserDTO.setDepartName(Objects.isNull(sysDepartment) ? "" : sysDepartment.getDeptName());

            payUserDTO.setParentId(Objects.isNull(payUser.getParentId()) ? "" : String.valueOf(payUser.getParentId()));
            payUserDTO.setPostId(Objects.isNull(payUser.getPostId()) ? "" : String.valueOf(payUser.getPostId()));
            payUserDTO.setSuperiorId(Objects.isNull(payUser.getSuperiorId()) ? "" : String.valueOf(payUser.getSuperiorId()));
            list.add(payUserDTO);
        });
        PageDTO<PayUserDTO> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(payUsers, pageDTO);
        pageDTO.setList(list);
        return ResultBean.success(pageDTO);
    }

    /**
     * 通过岗位ID查他自己的下级的下级
     * @param postId
     * @param postList
     */
    private void querySubordinates(Integer postId, Set<Integer> postList) {
        PayUserExample userExample = new PayUserExample();
        PayUserExample.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andSuperiorIdEqualTo(postId);
        List<PayUser> payUsers = payUserMapper.selectByExample(userExample);
        for (PayUser payUser : payUsers) {
            SysUser sys = userMapper.selectByPhoneOrIdCard(payUser.getPhone(), payUser.getIdCard());
            if (Objects.isNull(sys)) {
                continue;
            }
            postList.add(sys.getPostId());
            querySubordinates(sys.getPostId(), postList);
        }
    }

    @Override
    @Transactional
    public ResultBean save(PayUserDTO model) {
        String s = CommonUtil.IDCardValidate(model.getIdCard());
        if (StringUtils.isNotBlank(s)) {
            return ResultBean.error(CommonEnum.ResponseEnum.ID_CARD_INVALID, s);
        }
        PayUserExample example = new PayUserExample();
        example.createCriteria().andPhoneEqualTo(model.getPhone())
            .andIdCardEqualTo(model.getIdCard());
        List<PayUser> payUsers = payUserMapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(payUsers)) {
            return ResultBean.error(CommonEnum.ResponseEnum.ID_CARD_OR_PHONE_REPEAT);
        }
        PayUser payUser = new PayUser();
        SysDepartment sysDepartments = departmentMapper.selectByPrimaryKey(model.getDepartId());
        if (Objects.nonNull(sysDepartments)) {
            model.setDepartName(sysDepartments.getDeptName());
        }
        BeanUtils.copyProperties(model, payUser);
        payUser.setCreateTime(new Date());
        payUser.setUpdateTime(new Date());
        payUser.setCreateUser(getLoginUserName());
        payUser.setUpdateUser(getLoginUserName());
        payUserMapper.insert(payUser);
        // 同步工资表
        PayWages payWages = new PayWages();
        payWages.setUserName(payUser.getUserName());
        payWages.setUserId(payUser.getId());
        payWages.setDepartment(payUser.getDepartName());
        payWages.setMinLiveSecurityFund(payUser.getBasePay());
        payWages.setWagesMonth(DateFormatterUtils.getCurrentMonth(LocalDate.now()));
        payWages.setWagesYear(DateFormatterUtils.getCurrentYear(LocalDate.now()));
        payWagesMapper.insertSelective(payWages);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean getInfo(Integer userId) {
        PayUser payUser = payUserMapper.selectByPrimaryKey(userId);
        UserDetailVo userDetailVo = new UserDetailVo();
        BeanUtils.copyProperties(payUser, userDetailVo);
        userDetailVo.setParentId(Objects.isNull(payUser.getParentId()) ? "" : String.valueOf(payUser.getParentId()));
        userDetailVo.setPostId(Objects.isNull(payUser.getPostId()) ? "" : String.valueOf(payUser.getPostId()));
        userDetailVo.setSuperiorId(Objects.isNull(payUser.getSuperiorId()) ? "" : String.valueOf(payUser.getSuperiorId()));
        return ResultBean.success(userDetailVo);
    }

    @Override
    public ResultBean edit(PayUserDTO model) {
        String s = CommonUtil.IDCardValidate(model.getIdCard());
        if (StringUtils.isNotBlank(s)) {
            return ResultBean.error(CommonEnum.ResponseEnum.ID_CARD_INVALID, s);
        }
        PayUserExample payUserExample = new PayUserExample();
        payUserExample.createCriteria().andPhoneEqualTo(model.getPhone())
            .andIdCardEqualTo(model.getIdCard());
        List<PayUser> payUsers = payUserMapper.selectByExample(payUserExample);
        if (CollectionUtils.isNotEmpty(payUsers)) {
            Iterator<PayUser> iterator = payUsers.iterator();
            while (iterator.hasNext()) {
                PayUser next = iterator.next();
                if (next.getId().equals(model.getId())) {
                    iterator.remove();
                }
            }
            if (CollectionUtils.isNotEmpty(payUsers)) {
                return ResultBean.error(CommonEnum.ResponseEnum.ID_CARD_OR_PHONE_REPEAT);
            }
        }
        SysDepartment sysDepartments = departmentMapper.selectByPrimaryKey(model.getDepartId());
        if (Objects.nonNull(sysDepartments)) {
            model.setDepartName(sysDepartments.getDeptName());
        }
        PayUser payUser = new PayUser();
        BeanUtils.copyProperties(model, payUser);
        payUser.setUpdateTime(new Date());
        payUser.setUpdateUser(getLoginUserName());
        payUserMapper.updateByPrimaryKeySelective(payUser);
        PayWagesExample payWagesExample = new PayWagesExample();
        payWagesExample.createCriteria().andUserIdEqualTo(payUser.getId());
        List<PayWages> list = payWagesMapper.selectByExample(payWagesExample);
        if (CollectionUtils.isNotEmpty(list)) {
            // 同步工资表
            PayWages payWages = new PayWages();
            payWages.setUserName(payUser.getUserName());
            payWages.setUserId(payUser.getId());
            payWages.setDepartment(payUser.getDepartName());
            payWages.setMinLiveSecurityFund(payUser.getBasePay());
            payWages.setId(list.get(0).getId());
            payWages.setWagesMonth(DateFormatterUtils.getCurrentMonth(LocalDate.now()));
            payWages.setWagesYear(DateFormatterUtils.getCurrentYear(LocalDate.now()));
            payWagesMapper.updateByPrimaryKeySelective(payWages);
        }
        // 同步用户管理列表数据
        SysUser sys = userMapper.selectByPhoneOrIdCard(payUser.getPhone(), payUser.getIdCard());
        if (Objects.nonNull(sys)) {
            sys.setDepartId(payUser.getDepartId());
            sys.setPostId(payUser.getPostId());
            sys.setPhone(payUser.getPhone());
            sys.setIdCard(payUser.getIdCard());
            sys.setUserNo(payUser.getUserNo());
            sys.setRealName(payUser.getUserName());
            sys.setNativePlace(payUser.getAddress());
            sys.setSex(payUser.getSex());
            sysUserMapper.updateByPrimaryKeySelective(sys);
        }
        return ResultBean.success(1);
    }

    @Override
    public ResultBean delete(Integer userId) {
        payUserMapper.deleteByPrimaryKey(userId);
        // 工资人员
        PayWagesExample payWagesExample = new PayWagesExample();
        payWagesExample.createCriteria().andUserIdEqualTo(userId);
        List<PayWages> list = payWagesMapper.selectByExample(payWagesExample);
        if (CollectionUtils.isNotEmpty(list)) {
            payWagesMapper.deleteByPrimaryKey(list.get(0).getId());
        }
        return ResultBean.success(1);
    }

    @Override
    public ResultBean saveUserRelationProcedure(Integer userId, List<Integer> procedureIdList) {
        for (Integer procedureId : procedureIdList) {
            PayUserRelationProcedure payUserRelationProcedure = new PayUserRelationProcedure();
            payUserRelationProcedure.setUserId(userId);
            payUserRelationProcedure.setProcedureId(procedureId);
            payUserRelationProcedure.setCreateUser(getLoginUserName());
            payUserRelationProcedure.setUpdateUser(getLoginUserName());
            payUserRelationProcedure.setCreateTime(new Date());
            payUserRelationProcedure.setUpdateTime(new Date());
            payUserRelationProcedureMapper.insert(payUserRelationProcedure);
        }
        return ResultBean.success(1);
    }

    @Override
    public ResultBean getAllList(PayUserVO payUserVO) {
        PayUserExample example = new PayUserExample();
        PayUserExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(payUserVO.getUserType())) {
            criteria.andUserTypeEqualTo(payUserVO.getUserType());
        }
        if (StringUtils.isNotBlank(payUserVO.getDepartName())) {
            criteria.andDepartNameEqualTo(payUserVO.getDepartName());
        }
        List<PayUser> payUsers = payUserMapper.selectByExample(example);
        List<PayUserDTO> list = Lists.newArrayList();
        payUsers.forEach(payUser -> {
            PayUserDTO payUserDTO = new PayUserDTO();
            BeanUtils.copyProperties(payUser, payUserDTO);
            PayTeam payTeam = payTeamMapper.selectByPrimaryKey(payUser.getTeamId());
            payUserDTO.setTeamName(Objects.isNull(payTeam) ? "" : payTeam.getTeamName());
            PayProductionWorkshop payProductionWorkshop = payProductionWorkshopMapper.selectByPrimaryKey(payUser.getPostId());
            payUserDTO.setPostName(Objects.isNull(payProductionWorkshop) ? "" : payProductionWorkshop.getPostName());
            SysDepartment sysDepartment = departmentMapper.selectByPrimaryKey(payUser.getDepartId());
            payUserDTO.setDepartName(Objects.isNull(sysDepartment) ? "" : sysDepartment.getDeptName());
            list.add(payUserDTO);
        });
        return ResultBean.success(list);
    }

    @Override
    public ResultBean getScoreUserList(PayUserDTO model) {
        PayUserExample example = new PayUserExample();
        PayUserExample.Criteria criteria = example.createCriteria();

        // 获取当前登录人的岗位ID作为人员列表的直属上级ID。
        CustomUser customUser = sysUserService.selectLoginUser();
        if (Objects.nonNull(customUser) && Objects.nonNull(customUser.getId())) {
            List<RoleDTO> rolesByUserId = roleService.getRolesByUserId(customUser.getId());
//            if (!rolesByUserId.stream().map(RoleDTO::getRoleName)
//                .collect(Collectors.toList()).contains("ROLE_ADMIN")) {
//                Set<Integer> postList = new HashSet<>();
//                SysUser sysUser = sysUserService.getSysUser(customUser.getId());
//                postList.add(sysUser.getPostId());
//                querySubordinates(sysUser.getPostId(), postList);
//                criteria.andPostIdIn(new ArrayList<>(postList));
//            }
        // 当前人员的 下级
            if (!rolesByUserId.stream().map(RoleDTO::getRoleName)
                .collect(Collectors.toList()).contains("ROLE_ADMIN")) {
                SysUser sysUser = sysUserService.getSysUser(customUser.getId());
                criteria.andSuperiorIdEqualTo(sysUser.getPostId());
            }
        }
        if (StringUtils.isNotBlank(model.getPostName())) {
            PayProductionWorkshopExample payProductionWorkshopExample = new PayProductionWorkshopExample();
            payProductionWorkshopExample.createCriteria().andPostNameEqualTo(model.getPostName());
            List<PayProductionWorkshop> list = payProductionWorkshopMapper.selectByExample(payProductionWorkshopExample);
            if (CollectionUtils.isNotEmpty(list)) {
                List<Integer> collect = list.stream().map(pp -> pp.getId()).collect(Collectors.toList());
                criteria.andPostIdIn(collect);
            }
        }
        if (StringUtils.isNotBlank(model.getSuperiorName())) {
            PayProductionWorkshopExample payProductionWorkshopExample = new PayProductionWorkshopExample();
            payProductionWorkshopExample.createCriteria().andPostNameEqualTo(model.getSuperiorName());
            List<PayProductionWorkshop> list = payProductionWorkshopMapper.selectByExample(payProductionWorkshopExample);
            if (CollectionUtils.isNotEmpty(list)) {
                List<Integer> collect = list.stream().map(pp -> pp.getId()).collect(Collectors.toList());
                criteria.andSuperiorIdIn(collect);
            }
        }
        if (StringUtils.isNotBlank(model.getDepartName())) {
            criteria.andDepartNameEqualTo(model.getDepartName());
        }
        if (StringUtils.isNotBlank(model.getUserName())) {
            criteria.andUserNameLike("%" + model.getUserName() + "%");
        }
        if (null != model.getSex() && model.getSex() > 0) {
            criteria.andSexEqualTo(model.getSex());
        }
        if (StringUtils.isNotBlank(model.getUserType())) {
            criteria.andUserTypeEqualTo(model.getUserType());
        }
        if (StringUtils.isNotBlank(model.getNation())) {
            criteria.andNationLike("%" + model.getNation() + "%");
        }
        if (StringUtils.isNotBlank(model.getPoliticalOutlook())) {
            criteria.andPoliticalOutlookLike("%" + model.getPoliticalOutlook() + "%");
        }
        if (StringUtils.isNotBlank(model.getBloodType())) {
            criteria.andBloodTypeEqualTo(model.getBloodType());
        }
        if (StringUtils.isNotBlank(model.getHealth())) {
            criteria.andHealthLike("%" + model.getHealth() + "%");
        }
        if (Objects.nonNull(model.getMarryStatus()) && model.getMarryStatus() > 0) {
            criteria.andMarryStatusEqualTo(model.getMarryStatus());
        }
        if (StringUtils.isNotBlank(model.getUniversityFrom())) {
            criteria.andUniversityFromLike("%" + model.getUniversityFrom() + "%");
        }
        if (StringUtils.isNotBlank(model.getMajor())) {
            criteria.andMajorLike("%" + model.getMajor() + "%");
        }
        if (Objects.nonNull(model.getEducation()) && model.getEducation() > 0) {
            criteria.andEducationEqualTo(model.getMarryStatus());
        }
        if (StringUtils.isNotEmpty(model.getStartGraduationTime())) {
            Date startDate = DateFormatterUtils.parseDateString(DateFormatterUtils.THREE_FORMATTERPATTERN, model.getStartGraduationTime());
            criteria.andGraduationTimeGreaterThan(startDate);
        }
        if (StringUtils.isNotEmpty(model.getEndGraduationTime())) {
            Date endDate = DateFormatterUtils.parseDateString(DateFormatterUtils.THREE_FORMATTERPATTERN, model.getEndGraduationTime());
            criteria.andGraduationTimeLessThan(endDate);
        }
        if (StringUtils.isNotEmpty(model.getStartWorkingTime())) {
            Date startDate = DateFormatterUtils.parseDateString(DateFormatterUtils.THREE_FORMATTERPATTERN, model.getStartWorkingTime());
            criteria.andWorkingTimeGreaterThan(startDate);
        }
        if (StringUtils.isNotEmpty(model.getEndWorkingTime())) {
            Date endDate = DateFormatterUtils.parseDateString(DateFormatterUtils.THREE_FORMATTERPATTERN, model.getEndWorkingTime());
            criteria.andWorkingTimeLessThan(endDate);
        }
        if (StringUtils.isNotBlank(model.getPhone())) {
            criteria.andPhoneEqualTo(model.getPhone());
        }
        if (Objects.nonNull(model.getTeamId())) {
            criteria.andTeamIdEqualTo(model.getTeamId());
        }
        if (Objects.nonNull(model.getPostId())) {
            criteria.andPostIdEqualTo(Integer.valueOf(model.getPostId()));
        }
        if (StringUtils.isNotEmpty(model.getStartCreateTime())) {
            Date startDate = DateFormatterUtils.parseDateString(DateFormatterUtils.THREE_FORMATTERPATTERN, model.getStartCreateTime());
            criteria.andCreateTimeGreaterThan(startDate);
        }
        if (StringUtils.isNotEmpty(model.getEndCreateTime())) {
            Date endDate = DateFormatterUtils.parseDateString(DateFormatterUtils.THREE_FORMATTERPATTERN, model.getEndCreateTime());
            criteria.andCreateTimeLessThan(endDate);
        }
        example.setOrderByClause("id desc");
        Page<PayUser> payUsers = PageHelper.startPage(model.getPageNum(), model.getPageSize())
            .doSelectPage(() -> payUserMapper.selectByExample(example));
        List<PayUserDTO> list = Lists.newArrayList();
        payUsers.forEach(payUser -> {
            PayUserDTO payUserDTO = new PayUserDTO();
            BeanUtils.copyProperties(payUser, payUserDTO);
            PayTeam payTeam = payTeamMapper.selectByPrimaryKey(payUser.getTeamId());
            payUserDTO.setTeamName(Objects.isNull(payTeam) ? "" : payTeam.getTeamName());
            PayProductionWorkshop payProductionWorkshop = payProductionWorkshopMapper.selectByPrimaryKey(payUser.getPostId());
            payUserDTO.setPostName(Objects.isNull(payProductionWorkshop) ? "" : payProductionWorkshop.getPostName());
            PayProductionWorkshop workshop = payProductionWorkshopMapper.selectByPrimaryKey(payUser.getSuperiorId());
            payUserDTO.setSuperiorName(Objects.isNull(workshop) ? "" : workshop.getPostName());
            PayUser parentUser = payUserMapper.selectByPrimaryKey(payUser.getParentId());
            payUserDTO.setParentUserName(Objects.isNull(parentUser) ? "" : parentUser.getUserName());
            list.add(payUserDTO);
        });
        PageDTO<PayUserDTO> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(payUsers, pageDTO);
        pageDTO.setList(list);
        return ResultBean.success(pageDTO);


    }

    @Override
    public ResultBean syncUser() {
        List<PayUser> payUsers = payUserMapper.selectByExample(new PayUserExample());
        for (PayUser payUser : payUsers) {
            PayWagesExample payWagesExample = new PayWagesExample();
            payWagesExample.createCriteria().andUserNameEqualTo(payUser.getUserName());
            List<PayWages> payWages = payWagesMapper.selectByExample(payWagesExample);
            PayWages payWages1 = payWages.get(0);
            payWages1.setUserId(payUser.getId());
            payWagesMapper.updateByPrimaryKeySelective(payWages1);
        }
        return null;
    }
}
