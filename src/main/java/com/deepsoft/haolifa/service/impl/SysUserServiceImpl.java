package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.SysRoleUserMapper;
import com.deepsoft.haolifa.dao.repository.SysUserMapper;
import com.deepsoft.haolifa.model.domain.SysRoleUser;
import com.deepsoft.haolifa.model.domain.SysRoleUserExample;
import com.deepsoft.haolifa.model.domain.SysUser;
import com.deepsoft.haolifa.model.domain.SysUserExample;
import com.deepsoft.haolifa.model.dto.BaseException;
import com.deepsoft.haolifa.model.dto.CustomUser;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.UserBaseDTO;
import com.deepsoft.haolifa.model.vo.UserInfoVO;
import com.deepsoft.haolifa.service.PermissionService;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.util.UUIDGenerator;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.deepsoft.haolifa.constant.CommonEnum.ResponseEnum.PARAM_ERROR;

@Service
@Slf4j
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper userMapper;
    @Autowired
    private CustomUserServiceImpl customUserService;
    @Autowired
    private SysRoleUserMapper roleUserMapper;
    @Autowired
    private PermissionService permissionService;

    @Override
    public CustomUser selectLoginUser() {
        //return (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return  (CustomUser) customUserService.loadUserByUsername("admin");
    }

    @Override
    public UserInfoVO selectUserInfo() {
        CustomUser customUser = selectLoginUser();
        UserInfoVO userInfoVO = new UserInfoVO(customUser.getUsername(), customUser.getRealName(),
                customUser.getAuthorities(), permissionService.getMenu());
        return userInfoVO;
    }

    @Override
    public SysUser getSysUser(Integer userId) {
        SysUserExample userExample = new SysUserExample();
        userExample.or().andIdEqualTo(selectLoginUser().getId());
        List<SysUser> sysUsers = userMapper.selectByExample(userExample);
        return sysUsers.size()>0?sysUsers.get(0):null;
    }

    @Override
    public int insertSysUser(UserBaseDTO user) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(user, sysUser);
        return userMapper.insertSelective(sysUser);
    }

    @Override
    public PageDTO<SysUser> getUserList(Integer pageNum, Integer pageSize) {
        Page<SysUser> users = PageHelper.startPage(pageNum, pageSize)
                .doSelectPage(() -> userMapper.selectByExample(new SysUserExample()));
        PageDTO<SysUser> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(users, pageDTO);
        pageDTO.setList(users);
        return pageDTO;
    }


    @Override
    public int updateSysUser(UserBaseDTO user) {
        if(user.getId() == null){
            throw new BaseException(PARAM_ERROR.code, "用户id不能为空");
        }
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(user, sysUser);
        return userMapper.updateByPrimaryKeySelective(sysUser);
    }

    @Override
    public int deleteSysUser(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }


    @Override
    public int insertUserRole(Integer userId, Integer[] roleIds) {
        SysRoleUserExample sysRoleUserExample = new SysRoleUserExample();
        sysRoleUserExample.createCriteria().andSysUserIdEqualTo(userId);
        roleUserMapper.deleteByExample(sysRoleUserExample);
        int count = 0;
        for (Integer roleId:roleIds) {
            SysRoleUser roleUser = new SysRoleUser();
            roleUser.setSysUserId(userId);
            roleUser.setSysRoleId(roleId);
            count += roleUserMapper.insertSelective(roleUser);
        }
        return count;
    }
}
