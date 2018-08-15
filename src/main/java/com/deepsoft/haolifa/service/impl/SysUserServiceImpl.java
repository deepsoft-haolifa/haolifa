package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.SysUserMapper;
import com.deepsoft.haolifa.model.domain.SysUser;
import com.deepsoft.haolifa.model.domain.SysUserExample;
import com.deepsoft.haolifa.model.dto.BaseException;
import com.deepsoft.haolifa.model.dto.CustomUser;
import com.deepsoft.haolifa.model.dto.UserBaseDTO;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.util.UUIDGenerator;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.deepsoft.haolifa.constant.CommonEnum.ResponseEnum.PARAM_ERROR;

@Service
@Slf4j
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

    @Override
    public com.deepsoft.haolifa.model.dto.Page<SysUser> getUserList(Integer pageNum, Integer pageSize) {
        Page<SysUser> users = PageHelper.startPage(pageNum, pageSize)
                .doSelectPage(() -> userMapper.selectByExample(new SysUserExample()));
        com.deepsoft.haolifa.model.dto.Page<SysUser> page = new com.deepsoft.haolifa.model.dto.Page<>();
        BeanUtils.copyProperties(users, page);
        page.setList(users);
        return page;
    }


    @Override
    public int updateSysUser(UserBaseDTO user) {
        if(user.getId() == null){
            throw new BaseException(PARAM_ERROR.code, "用户id不能为空");
        }
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(user, sysUser);
        return userMapper.updateByPrimaryKeySelective(sysUser);
    }

    @Override
    public int deleteSysUser(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }
}
