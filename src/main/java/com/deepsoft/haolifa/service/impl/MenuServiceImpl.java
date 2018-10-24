package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.SysPermissionMapper;
import com.deepsoft.haolifa.dao.repository.extend.MyPermissionMapper;
import com.deepsoft.haolifa.model.domain.SysPermission;
import com.deepsoft.haolifa.model.domain.SysPermissionExample;
import com.deepsoft.haolifa.model.dto.BaseException;
import com.deepsoft.haolifa.model.vo.MenuVO;
import com.deepsoft.haolifa.service.MenuService;
import io.netty.util.internal.ObjectUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;
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

    private List<MenuVO> PermissionToMenuVo(List<SysPermission> permissions, String menuType){
         return permissions.stream().filter(m ->
                m.getUrl().equals(menuType)).map(m -> {
            MenuVO menuVO = new MenuVO();
            BeanUtils.copyProperties(m, menuVO);
            menuVO.setCode(m.getUrl());
            return menuVO;
        }).collect(Collectors.toList());
    }

    public int updateMenu(MenuVO menuVO){
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

    @Override
    public int insertRoleMenu(Integer roleId, Integer[] menuIds) {
        if(!ObjectUtils.allNotNull(roleId, menuIds)){
            throw new BaseException(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        return myPermissionMapper.inserRoleMenu(roleId, menuIds);
    }
}
