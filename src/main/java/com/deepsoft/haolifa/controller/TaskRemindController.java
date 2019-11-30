package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.PageParam;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.TaskRemindService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author murphy.he
 **/
@Api(tags = {"任务提醒"})
@RestController
@RequestMapping("/task-remind")
public class TaskRemindController {
    @Resource
    private TaskRemindService taskRemindService;

    @PostMapping("page-list")
    @ApiOperation("获取任务提醒分页列表")
    public ResultBean pageLoginList(@RequestBody PageParam pageParam) {
        return ResultBean.success(taskRemindService.taskRemindList(pageParam));
    }

    @PostMapping("count")
    @ApiOperation("获取任务提醒数量")
    public ResultBean count() {
        return ResultBean.success(taskRemindService.taskRemindCount());
    }
}
