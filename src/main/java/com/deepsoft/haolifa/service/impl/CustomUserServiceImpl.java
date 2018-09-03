package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.config.CustomGrantedAuthority;
import com.deepsoft.haolifa.dao.repository.SysUserMapper;
import com.deepsoft.haolifa.dao.repository.extend.MyPermissionMapper;
import com.deepsoft.haolifa.model.domain.SysRole;
import com.deepsoft.haolifa.model.domain.SysUser;
import com.deepsoft.haolifa.model.domain.SysUserExample;
import com.deepsoft.haolifa.model.dto.CustomPermission;
import com.deepsoft.haolifa.model.dto.CustomUser;
import com.deepsoft.haolifa.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zhaozhihong
 * @create 2018-07-27 10:34
 * @desc customer user
 **/
@Service
public class CustomUserServiceImpl implements UserDetailsService { //自定义UserDetailsService 接口


    @Autowired
    private SysUserMapper userMapper;
    @Autowired
    private MyPermissionMapper myPermissionMapper;
    @Autowired
    private DepartmentService departmentService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        SysUserExample userExample = new SysUserExample();
        userExample.or().andUsernameEqualTo(username);
        List<SysUser> users = userMapper.selectByExample(userExample);
        SysUser user = null;
        if (users.size() > 0) {
            user = users.get(0);
        }
        if (user != null) {
            Set<SysRole> roles = myPermissionMapper.findRolesByUserId(user.getId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (SysRole role :roles) {
                if(null == role){
                    roles.remove(null);
                    continue;
                }
                GrantedAuthority authority = new CustomGrantedAuthority(role.getRoleName(), role.getDescription());
                grantedAuthorities.add(authority);
            }
            List<CustomPermission> permissios = new ArrayList<>();
            if(!roles.isEmpty()) {
                permissios = myPermissionMapper.findPermissiosByRoles(roles.stream().map(SysRole::getRoleName).collect(Collectors.toList()));
            }
            return new CustomUser(user.getId(), user.getUsername(),user.getRealName(), user.getPassword(), grantedAuthorities, permissios);
        } else {
            throw new UsernameNotFoundException("admin: " + username + " do not exist!");
        }
    }

}
