package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.config.CustomGrantedAuthority;
import com.deepsoft.haolifa.dao.repository.SysUserMapper;
import com.deepsoft.haolifa.dao.repository.extend.MyPermissionMapper;
import com.deepsoft.haolifa.model.domain.SysUser;
import com.deepsoft.haolifa.model.domain.SysUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhaozhihong
 * @create 2018-04-27 10:34
 * @desc customer user
 **/
@Service
public class CustomUserService implements UserDetailsService { //自定义UserDetailsService 接口


    @Autowired
    private SysUserMapper userMapper;
    @Autowired
    private MyPermissionMapper myPermissionMapper;

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
            List<CustomGrantedAuthority> permissions = myPermissionMapper.findByAdminUserId(user.getId());
            return new User(user.getUsername(), user.getPassword(), permissions);
        } else {
            throw new UsernameNotFoundException("admin: " + username + " do not exist!");
        }
    }

}
