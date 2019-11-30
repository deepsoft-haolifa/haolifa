package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.TaskRemindMapper;
import com.deepsoft.haolifa.model.domain.SysUser;
import com.deepsoft.haolifa.model.domain.TaskRemind;
import com.deepsoft.haolifa.model.dto.CustomUser;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.service.TaskRemindService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author murphy.he
 **/
@Service
public class TaskRemindServiceImpl implements TaskRemindService {

    @Resource
    private TaskRemindMapper taskRemindMapper;
    @Resource
    private SysUserService sysUserService;


    @Override
    public int taskRemindCount() {
        CustomUser customUser = sysUserService.selectLoginUser();
        Integer id = customUser.getId();
        taskRemindMapper.countByExample(customUser);
        return 0;
    }

    @Override
    public List<TaskRemind> taskRemindList() {
        return null;
    }

    @Override
    public void taskRemindList(TaskRemind taskRemind) {

    }
}
