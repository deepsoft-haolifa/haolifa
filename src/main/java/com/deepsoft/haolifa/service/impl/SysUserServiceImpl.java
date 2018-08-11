package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.SysUserMapper;
import com.deepsoft.haolifa.model.domain.SysUser;
import com.deepsoft.haolifa.model.domain.SysUserExample;
import com.deepsoft.haolifa.model.dto.CustomUser;
import com.deepsoft.haolifa.model.dto.UserBaseDTO;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.util.UUIDGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper userMapper;

    @Override
    public CustomUser selectLoginUser() {
        return (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }


    @Override
    public SysUser getSysUser(Integer userId) {
        SysUserExample userExample = new SysUserExample();
        userExample.or().andIdEqualTo(selectLoginUser().getId());
        List<SysUser> sysUsers = userMapper.selectByExample(userExample);
        return sysUsers.size()>0?sysUsers.get(0):null;
    }

    @Override
    public int insertSysUser(UserBaseDTO user) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(user, sysUser);
        sysUser.setUserId(UUIDGenerator.getUUID32());
        return userMapper.insertSelective(sysUser);
    }
}
