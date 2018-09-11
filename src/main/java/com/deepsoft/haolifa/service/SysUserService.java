package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.SysUser;
import com.deepsoft.haolifa.model.dto.CustomUser;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.UserBaseDTO;
import com.deepsoft.haolifa.model.vo.UserInfoVO;
import com.deepsoft.haolifa.model.vo.UserPageVO;

public interface SysUserService {

    /**
     * 获取当前用户的认证信息，角色 权限等
     * @return
     */
    CustomUser selectLoginUser();

    /**
     * 获取当前用户信息
     * @return
     */
    UserInfoVO selectUserInfo();

    /**
     * 获取用户详细信息
     * @param userId
     * @return
     */
    SysUser getSysUser(Integer userId);

    /**
     * 添加用户
     * @param user
     * @return
     */
    int insertSysUser(UserBaseDTO user);

    /**
     * 获取用户列表
     * @return
     */
    PageDTO<UserPageVO> getUserList(Integer pageNum, Integer pageSize);

    /**
     * 修改用户
     * @param user
     * @return
     */
    int updateSysUser(UserBaseDTO user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int deleteSysUser(Integer id);

    /**
     * 给用户分配角色
     * @param userId
     * @param roleId
     * @return
     */
    int insertUserRole(Integer userId, Integer[] roleId);

}
