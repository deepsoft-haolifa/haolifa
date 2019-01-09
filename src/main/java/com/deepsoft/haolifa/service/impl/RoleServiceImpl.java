package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.SysRoleMapper;
import com.deepsoft.haolifa.dao.repository.extend.MyPermissionMapper;
import com.deepsoft.haolifa.model.domain.SysPermission;
import com.deepsoft.haolifa.model.domain.SysPermissionExample;
import com.deepsoft.haolifa.model.domain.SysRole;
import com.deepsoft.haolifa.model.domain.SysRoleExample;
import com.deepsoft.haolifa.model.dto.BaseException;
import com.deepsoft.haolifa.model.dto.RoleDTO;
import com.deepsoft.haolifa.model.dto.sys.DepartmentTree;
import com.deepsoft.haolifa.model.vo.UserPageVO;
import com.deepsoft.haolifa.service.DepartmentService;
import com.deepsoft.haolifa.service.RoleService;
import com.deepsoft.haolifa.util.TreeUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private SysRoleMapper roleMapper;
    @Autowired
    private MyPermissionMapper myPermissionMapper;
    @Autowired
    private DepartmentService departmentService;

    @Override
    public List<RoleDTO> getRoles() {
        return roleMapper.selectByExample(null).stream().map(r -> {
            RoleDTO role = new RoleDTO();
            BeanUtils.copyProperties(r, role);
            role.setDepartment(departmentService.selectDepartmentById(r.getDeptId()));
            return role;
        }).collect(Collectors.toList());
    }

    @Override
    public List<RoleDTO> getRolesByUserId(Integer userId) {
        Set<SysRole> rolesByUserId = myPermissionMapper.findRolesByUserId(userId);
        rolesByUserId.remove(null);
        return rolesByUserId.stream().map(r -> {
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
        sysRole.setDeptId(role.getDepartment().getId());
        return roleMapper.insertSelective(sysRole);
    }

    @Override
    public int updateRole(RoleDTO role) {
        if(null != role || role.getId() == null){
            throw new BaseException(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(role, sysRole);
        sysRole.setDeptId(role.getDepartment().getId());
        return roleMapper.updateByPrimaryKeySelective(sysRole);
    }

    @Override
    public List<UserPageVO> getBuyers() {
        return myPermissionMapper.selectUserByRole("ROLE_CGY");
    }

    @Override
    public List<DepartmentTree> roleTree() {
        List<SysRole> sysRoles = roleMapper.selectByExample(new SysRoleExample());
        List<DepartmentTree> departmentTrees = new ArrayList<>();
        sysRoles.stream().forEach(e -> {
            DepartmentTree departmentTree = new DepartmentTree();
            departmentTree.setId(String.valueOf(e.getId()));
            departmentTree.setNo(String.valueOf(e.getRoleNo()));
            departmentTree.setName(e.getDescription());
            departmentTree.setParentId(String.valueOf(e.getPid()));
            departmentTrees.add(departmentTree);
        });
        return TreeUtils.getTreeList("0", departmentTrees);
    }
}
