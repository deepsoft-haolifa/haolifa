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
import com.deepsoft.haolifa.service.PayUserService;
import com.deepsoft.haolifa.service.PayWagesRelationUserService;
import com.deepsoft.haolifa.service.RoleService;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.util.CommonUtil;
import com.deepsoft.haolifa.util.DateFormatterUtils;
import com.deepsoft.haolifa.util.DateUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import io.swagger.models.auth.In;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
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
    private RoleService roleService;
    @Resource
    private SysUserService sysUserService;
    @Resource
    private SysUserMapper userMapper;
    @Override
    public ResultBean pageInfo(PayUserDTO model) {
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
            criteria.andPostIdEqualTo(model.getPostId());
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
        SysDepartmentExample sysDepartmentExample = new SysDepartmentExample();
        sysDepartmentExample.createCriteria().andDeptNameEqualTo(model.getDepartName());
        List<SysDepartment> sysDepartments = departmentMapper.selectByExample(sysDepartmentExample);
        if (CollectionUtils.isNotEmpty(sysDepartments)) {
            SysDepartment sysDepartment = sysDepartments.get(0);
            model.setDepartId(sysDepartment.getId());
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
        payWages.setDepartment(payUser.getDepartName());
        payWages.setMinLiveSecurityFund(payUser.getBasePay());
        payWagesMapper.insertSelective(payWages);
        // 人员工资关联表
        PayWagesRelationUser payWagesRelationUser = new PayWagesRelationUser();
        payWagesRelationUser.setUserId(payUser.getId());
        payWagesRelationUser.setWagesId(payWages.getId());
        payWagesRelationUser.setCreateTime(new Date());
        payWagesRelationUser.setUpdateTime(new Date());
        payWagesRelationUser.setCreateUser(getLoginUserName());
        payWagesRelationUser.setUpdateUser(getLoginUserName());
        payWagesRelationUserMapper.insert(payWagesRelationUser);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean getInfo(Integer userId) {
        return ResultBean.success(payUserMapper.selectByPrimaryKey(userId));
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
        SysDepartmentExample sysDepartmentExample = new SysDepartmentExample();
        sysDepartmentExample.createCriteria().andDeptNameEqualTo(model.getDepartName());
        List<SysDepartment> sysDepartments = departmentMapper.selectByExample(sysDepartmentExample);
        if (CollectionUtils.isNotEmpty(sysDepartments)) {
            SysDepartment sysDepartment = sysDepartments.get(0);
            model.setDepartId(sysDepartment.getId());
        }
        PayUser payUser = new PayUser();
        BeanUtils.copyProperties(model, payUser);
        payUser.setUpdateTime(new Date());
        payUser.setUpdateUser(getLoginUserName());
        payUserMapper.updateByPrimaryKeySelective(payUser);
        PayWagesRelationUser relationUser = new PayWagesRelationUser();
        relationUser.setUserId(payUser.getId());
        List<PayWagesRelationUser> list = payWagesRelationUserService.getList(relationUser);
        if (CollectionUtils.isNotEmpty(list)) {
            // 同步工资表
            PayWages payWages = new PayWages();
            payWages.setUserName(payUser.getUserName());
            payWages.setDepartment(payUser.getDepartName());
            payWages.setMinLiveSecurityFund(payUser.getBasePay());
            payWages.setId(list.get(0).getWagesId());
            payWagesMapper.updateByPrimaryKeySelective(payWages);
        }
        return ResultBean.success(1);
    }

    @Override
    public ResultBean delete(Integer userId) {
        payUserMapper.deleteByPrimaryKey(userId);
        // 工资人员
        PayWagesRelationUser relationUser = new PayWagesRelationUser();
        relationUser.setUserId(userId);
        List<PayWagesRelationUser> list = payWagesRelationUserService.getList(relationUser);
        if (CollectionUtils.isNotEmpty(list)) {
            payWagesMapper.deleteByPrimaryKey(list.get(0).getWagesId());
            payWagesRelationUserService.delete(list.get(0).getId());
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
            list.add(payUserDTO);
        });
        return ResultBean.success(list);
    }
}
