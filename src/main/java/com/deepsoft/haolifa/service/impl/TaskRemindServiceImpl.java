package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.TaskRemindMapper;
import com.deepsoft.haolifa.dao.repository.extend.MyPermissionMapper;
import com.deepsoft.haolifa.model.domain.SysRole;
import com.deepsoft.haolifa.model.domain.TaskRemind;
import com.deepsoft.haolifa.model.domain.TaskRemindExample;
import com.deepsoft.haolifa.model.dto.CustomUser;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.PageParam;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.service.TaskRemindService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author murphy.he
 **/
@Service
public class TaskRemindServiceImpl implements TaskRemindService {

    @Resource
    private TaskRemindMapper taskRemindMapper;
    @Resource
    private SysUserService sysUserService;
    @Resource
    private MyPermissionMapper myPermissionMapper;

    @Override
    public int taskRemindCount() {
        CustomUser customUser = sysUserService.selectLoginUser();
        Integer userId = customUser.getId();
        Set<SysRole> roles = myPermissionMapper.findRolesByUserId(userId);
        List<Integer> roleList = roles.stream()
            .map(SysRole::getId).collect(Collectors.toList());
        TaskRemindExample taskRemindExample = new TaskRemindExample();
        taskRemindExample.or().andRoleIdIn(roleList);
        int count = taskRemindMapper.countByExample(taskRemindExample);
        return count;
    }

    @Override
    public PageDTO<TaskRemind> taskRemindList(PageParam pageParam) {
        CustomUser customUser = sysUserService.selectLoginUser();
        Integer userId = customUser.getId();
        Set<SysRole> roles = myPermissionMapper.findRolesByUserId(userId);
        List<Integer> roleList = roles.stream()
            .map(SysRole::getId).collect(Collectors.toList());
        TaskRemindExample taskRemindExample = new TaskRemindExample();
        taskRemindExample.or().andRoleIdIn(roleList);
        Page<TaskRemind> page = PageHelper
            .startPage(pageParam.getPageNum(), pageParam.getPageSize(), "id desc")
            .doSelectPage(() -> taskRemindMapper.selectByExample(taskRemindExample));

        PageDTO<TaskRemind> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(page, pageDTO);
        return pageDTO;
    }

    @Override
    public void addTask(TaskRemind taskRemind) {
        taskRemindMapper.insertSelective(taskRemind);
    }
}
