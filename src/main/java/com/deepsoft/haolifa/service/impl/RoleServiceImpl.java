package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.SysRoleMapper;
import com.deepsoft.haolifa.dao.repository.extend.MyPermissionMapper;
import com.deepsoft.haolifa.model.domain.SysRole;
import com.deepsoft.haolifa.model.domain.SysRoleExample;
import com.deepsoft.haolifa.model.dto.BaseException;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.RoleDTO;
import com.deepsoft.haolifa.service.RoleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private SysRoleMapper roleMapper;
    @Autowired
    private MyPermissionMapper myPermissionMapper;

    @Override
    public List<RoleDTO> getRoles() {
        return roleMapper.selectByExample(null).stream().map(r -> {
            RoleDTO role = new RoleDTO();
            BeanUtils.copyProperties(r, role);
            return role;
        }).collect(Collectors.toList());
    }

    @Override
    public List<RoleDTO> getRolesByUserId(Integer userId) {
        return myPermissionMapper.findRolesByUserId(userId).stream().map(r -> {
            RoleDTO role = new RoleDTO();
            BeanUtils.copyProperties(r, role);
            return role;
        }).collect(Collectors.toList());
    }

    @Override
    public int deleteRole(Integer id) {
        SysRoleExample sysRoleExample = new SysRoleExample();
        sysRoleExample.or().andIdEqualTo(id);
        return roleMapper.deleteByExample(sysRoleExample);
    }

    @Override
    public int insertRole(RoleDTO role) {
        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(role, sysRole);
        return roleMapper.insertSelective(sysRole);
    }

    @Override
    public int updateRole(RoleDTO role) {
        if(null != role || role.getId() == null){
            throw new BaseException(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(role, sysRole);
        return roleMapper.updateByPrimaryKeySelective(sysRole);
    }
}
