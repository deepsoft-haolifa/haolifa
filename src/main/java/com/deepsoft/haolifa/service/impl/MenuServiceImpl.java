package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.SysPermissionMapper;
import com.deepsoft.haolifa.dao.repository.SysPermissionRoleMapper;
import com.deepsoft.haolifa.dao.repository.extend.MyPermissionMapper;
import com.deepsoft.haolifa.model.domain.SysPermission;
import com.deepsoft.haolifa.model.domain.SysPermissionExample;
import com.deepsoft.haolifa.model.domain.SysPermissionRoleExample;
import com.deepsoft.haolifa.model.dto.BaseException;
import com.deepsoft.haolifa.model.dto.sys.DepartmentTree;
import com.deepsoft.haolifa.model.vo.MenuVO;
import com.deepsoft.haolifa.service.MenuService;
import com.deepsoft.haolifa.util.TreeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MenuServiceImpl implements MenuService {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;
    @Autowired
    private SysPermissionRoleMapper sysPermissionRoleMapper;
    @Autowired
    private MyPermissionMapper myPermissionMapper;


    @Override
    public List<MenuVO> getMenuList(String menuType) {
        return PermissionToMenuVo(sysPermissionMapper.selectByExample(null), menuType);
    }

    @Override
    public MenuVO getMenusById(Integer id, String menuType) {
        SysPermissionExample permissionExample = new SysPermissionExample();
        permissionExample.or().andIdEqualTo(id);
        List<MenuVO> menuVOS = PermissionToMenuVo(sysPermissionMapper.selectByExample(permissionExample), menuType);
        return menuVOS.isEmpty() ? null : menuVOS.get(0);
    }

    private List<MenuVO> PermissionToMenuVo(List<SysPermission> permissions, String menuType) {
        return permissions.stream().filter(m ->
                m.getPermName().equals(menuType)).map(m -> {
            MenuVO menuVO = new MenuVO();
            BeanUtils.copyProperties(m, menuVO);
            menuVO.setCode(m.getUrl());
            log.info("menu:{}", menuVO);
            return menuVO;
        }).collect(Collectors.toList());
    }

    public int updateMenu(MenuVO menuVO) {
        SysPermission sysPermission = new SysPermission();
        BeanUtils.copyProperties(menuVO, sysPermission);
        sysPermission.setUrl(menuVO.getCode());
        return sysPermissionMapper.updateByPrimaryKey(sysPermission);
    }

    @Override
    public int insertMenu(MenuVO menuVO) {
        SysPermission sysPermission = new SysPermission();
        BeanUtils.copyProperties(menuVO, sysPermission);
        sysPermission.setUrl(menuVO.getCode());
        return sysPermissionMapper.insertSelective(sysPermission);
    }

    @Override
    public int deleteMenu(Integer id) {
        return sysPermissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<MenuVO> selectByRoleId(Integer roleId) {
        List<MenuVO> permissiosByRoleId = myPermissionMapper.findPermissiosByRoleId(roleId);
        permissiosByRoleId.remove(null);
        return permissiosByRoleId;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertRoleMenu(Integer roleId, Integer[] menuIds) {
        if (!ObjectUtils.allNotNull(roleId)) {
            throw new BaseException(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        // 现将之前的删除
        SysPermissionRoleExample example = new SysPermissionRoleExample();
        example.or().andRoleIdEqualTo(roleId);
        sysPermissionRoleMapper.deleteByExample(example);
        if (menuIds != null && menuIds.length > 0) {
            myPermissionMapper.inserRoleMenu(roleId, menuIds);
        }
        return 1;
    }

    @Override
    public List<DepartmentTree> menuTree() {
        SysPermissionExample sysPermissionExample = new SysPermissionExample();
        SysPermissionExample.Criteria criteria = sysPermissionExample.createCriteria();
        criteria.andPermNameEqualTo("m");
        List<SysPermission> sysPermissions = sysPermissionMapper.selectByExample(sysPermissionExample);
        List<DepartmentTree> departmentTrees = new ArrayList<>();
        sysPermissions.stream().forEach(e -> {
            DepartmentTree departmentTree = new DepartmentTree();
            departmentTree.setId(String.valueOf(e.getId()));
            departmentTree.setName(e.getDescription());
            departmentTree.setParentId(String.valueOf(e.getPid()));
            departmentTrees.add(departmentTree);

        });
        return TreeUtils.getTreeList("0", departmentTrees);
    }
}
