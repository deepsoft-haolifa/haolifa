package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.SysRoleMapper;
import com.deepsoft.haolifa.model.domain.SysRole;
import com.deepsoft.haolifa.model.domain.SysRoleExample;
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

    @Override
    public PageDTO<RoleDTO> getRoles(Integer pageNum, Integer pageSize) {
        Page<SysRole> roles = PageHelper.startPage(pageNum, pageSize)
                .doSelectPage(() -> roleMapper.selectByExample(new SysRoleExample()));
        PageDTO<RoleDTO> page = new PageDTO<>();
        BeanUtils.copyProperties(roles, page);
        List<RoleDTO> roleDTOs = roles.stream().map(r -> {
            RoleDTO role = new RoleDTO();
            BeanUtils.copyProperties(r, role);
            return role;
        }).collect(Collectors.toList());
        page.setList(roleDTOs);
        return page;
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
        return 0;
    }

    @Override
    public int updateRole(RoleDTO role) {
        return 0;
    }
}
