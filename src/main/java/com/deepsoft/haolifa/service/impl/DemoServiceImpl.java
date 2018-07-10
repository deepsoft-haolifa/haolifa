package com.deepsoft.haolifa.service.impl;


import com.deepsoft.haolifa.dao.repository.SysUserMapper;
import com.deepsoft.haolifa.dao.repository.extend.SysUserExtendMapper;
import com.deepsoft.haolifa.model.domain.SysUser;
import com.deepsoft.haolifa.model.domain.SysUserExample;
import com.deepsoft.haolifa.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class DemoServiceImpl implements DemoService {

    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private SysUserExtendMapper sysUserExtendMapper;

    @Override
    public List<SysUser> list() {
        SysUserExample example = new SysUserExample();
        return sysUserMapper.selectByExample(example);
    }

    @Override
    public int add(SysUser sysUser) {
        sysUser.setCtime(new Date());
        sysUser.setUtime(new Date());
        return sysUserMapper.insertSelective(sysUser);
    }

    @Override
    public int update(SysUser sysUser) {
        return sysUserMapper.updateByPrimaryKey(sysUser);
    }

    @Override
    public SysUser sysUserInfo(String loginName) {
        return sysUserExtendMapper.selectByLoginName(loginName);
    }
}
