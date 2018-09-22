package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.vo.MenuVO;

import java.util.List;

public interface MenuService {

    List<MenuVO> getMenuList();

    MenuVO getMenusById(Integer id);

    int updateMenu(MenuVO menuVO);

    int insertMenu(MenuVO menuVO);

    int deleteMenu(Integer id);

    List<MenuVO> selectByRoleId(Integer roleId);

    int insertRoleMenu(Integer roleId, Integer[] menuIds);
}
