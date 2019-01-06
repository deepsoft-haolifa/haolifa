package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.sys.DepartmentTree;
import com.deepsoft.haolifa.model.vo.MenuVO;
import com.deepsoft.haolifa.model.vo.QuickStartVO;

import java.util.List;

public interface MenuService {

    List<MenuVO> getMenuList(String menuType);

    MenuVO getMenusById(Integer id, String menuType);

    int updateMenu(MenuVO menuVO);

    int insertMenu(MenuVO menuVO);

    int deleteMenu(Integer id);

    List<MenuVO> selectByRoleId(Integer roleId);

    int insertRoleMenu(Integer roleId, Integer[] menuIds);

    List<DepartmentTree> menuTree();
}
