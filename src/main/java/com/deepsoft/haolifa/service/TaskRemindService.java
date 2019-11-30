package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.TaskRemind;

import java.util.List;

/**
 * 任务提醒
 *
 * @author murphy.he
 **/
public interface TaskRemindService {

    /**
     * 获取当前用户是否有带处理的消息
     */
    int taskRemindCount();

    /**
     * 获取任务提醒列表(并将未读转为已读状态)
     *
     * @return
     */
    List<TaskRemind> taskRemindList();

    /**
     * 添加任务提醒
     *
     * @return
     */
    void taskRemindList(TaskRemind taskRemind);


}
