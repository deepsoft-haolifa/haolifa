package com.deepsoft.haolifa.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.cache.CacheKeyManager;
import com.deepsoft.haolifa.cache.redis.RedisDao;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.SysRoleUserMapper;
import com.deepsoft.haolifa.dao.repository.SysUserMapper;
import com.deepsoft.haolifa.dao.repository.extend.MyUserMapper;
import com.deepsoft.haolifa.model.domain.SysRoleUser;
import com.deepsoft.haolifa.model.domain.SysRoleUserExample;
import com.deepsoft.haolifa.model.domain.SysUser;
import com.deepsoft.haolifa.model.domain.SysUserExample;
import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.model.vo.UserInfoVO;
import com.deepsoft.haolifa.model.vo.UserPageVO;
import com.deepsoft.haolifa.service.DepartmentService;
import com.deepsoft.haolifa.service.PermissionService;
import com.deepsoft.haolifa.service.RoleService;
import com.deepsoft.haolifa.service.SysUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleService roleService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private RedisDao redisDao;
    @Autowired
    private MyUserMapper myUserMapper;

    @Override
    public CustomUser selectLoginUser() {
        //return (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Object principal = null;
        try {
            principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        if ("anonymousUser".equals(principal))
            return (CustomUser) customUserService.loadUserByUsername("admin");
        else
            return (CustomUser) principal;
    }

    @Override
    public UserInfoVO selectUserInfo() {
        CustomUser customUser = selectLoginUser();
        UserInfoVO userInfoVO = new UserInfoVO(customUser.getUsername(), customUser.getRealName(),
            customUser.getId(), customUser.getAuthorities(), permissionService.getMenu("m"));
        return userInfoVO;
    }

    @Override
    public SysUser getSysUser(Integer userId) {
        String userKey = CacheKeyManager.cacheKeyUserCache(userId).key;
        //暂时不用缓存
        redisDao.del(userKey);
        String userCacheStr = redisDao.get(userKey);
        if (StringUtils.isNotBlank(userCacheStr)) {
            return JSONObject.parseObject(userCacheStr, UserCacheDTO.class);
        }
        SysUserExample userExample = new SysUserExample();
        userExample.or().andIdEqualTo(userId);
        List<SysUser> sysUsers = userMapper.selectByExample(userExample);
        List<RoleDTO> rolesByUserId = roleService.getRolesByUserId(userId);
        UserCacheDTO userCacheDTO = new UserCacheDTO();
        if (sysUsers.size() > 0) {
            BeanUtils.copyProperties(sysUsers.get(0), userCacheDTO);
            userCacheDTO.setRoles(rolesByUserId);
        }
        redisDao.set(userKey, JSON.toJSONString(userCacheDTO));
        return userCacheDTO;
    }

    @Override
    public int insertSysUser(UserBaseDTO user) {
        // 判断username 不能重复
        String username = user.getUsername();
        SysUserExample example = new SysUserExample();
        example.or().andUsernameEqualTo(username);
        long count = userMapper.countByExample(example);
        if (count > 0) {
            ResultBean.error(CommonEnum.ResponseEnum.USER_NAME_EXISTS);
        }

        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(user, sysUser);
        if (StringUtils.isNotBlank(user.getPassword())) {
            sysUser.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return userMapper.insertSelective(sysUser);
    }

    @Override
    public PageDTO<UserPageVO> getUserList(Integer pageNum, Integer pageSize) {
        Page<SysUser> users = PageHelper.startPage(pageNum, pageSize)
            .doSelectPage(() -> userMapper.selectByExample(new SysUserExample()));
        log.info("users:{}", users);
        List<UserPageVO> userPageVOS = users.stream().map(u -> {
            UserCacheDTO sysUser = (UserCacheDTO) getSysUser(u.getId());
            UserPageVO userPageVO = new UserPageVO();
            BeanUtils.copyProperties(sysUser, userPageVO);
            return userPageVO;
        }).collect(Collectors.toList());
        PageDTO<UserPageVO> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(users, pageDTO);
        pageDTO.setList(userPageVOS);
        return pageDTO;
    }


    @Override
    public int updateSysUser(UserBaseDTO user) {
        if (user.getId() == null) {
            throw new BaseException(PARAM_ERROR.code, "用户id不能为空");
        }
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(user, sysUser);
        if (StringUtils.isNotBlank(user.getPassword())) {
            sysUser.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        int count = userMapper.updateByPrimaryKeySelective(sysUser);
//        String userKey = CacheKeyManager.cacheKeyUserCache(user.getId()).key;
//        //暂时不用缓存
//        redisDao.del(userKey);
        return count;
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
        for (Integer roleId : roleIds) {
            SysRoleUser roleUser = new SysRoleUser();
            roleUser.setSysUserId(userId);
            roleUser.setSysRoleId(roleId);
            count += roleUserMapper.insertSelective(roleUser);
        }
        return count;
    }

    @Override
    public int closeUser(Integer id) {
        return myUserMapper.closeOrOpenUser(id);
    }


    @Override
    public String initPwd(Integer id) {
        UserBaseDTO userBaseDTO = new UserBaseDTO();
        userBaseDTO.setId(id);
        userBaseDTO.setPassword(DEFAULT_PASSWORD);
        updateSysUser(userBaseDTO);
        return DEFAULT_PASSWORD;
    }

    @Override
    public String changePwd(String newPassword) {
        CustomUser customUser = selectLoginUser();
        UserBaseDTO userBaseDTO = new UserBaseDTO();
        userBaseDTO.setId(customUser.getId());
        userBaseDTO.setPassword(newPassword);
        updateSysUser(userBaseDTO);
        return newPassword;
    }
}
