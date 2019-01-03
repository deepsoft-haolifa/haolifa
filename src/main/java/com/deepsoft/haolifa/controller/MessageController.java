package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.vo.MessageVO;
import com.deepsoft.haolifa.service.MessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = {"新闻/消息管理"})
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/{messageType}")
    @ApiImplicitParam(name = "messageType", value = "1:新闻，2：消息", dataType = "Byte", required = true)
    @ApiOperation("获取新闻/消息列表")
    public ResultBean getMessages(@PathVariable("messageType") Byte messageType,
                                  @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                                  @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return ResultBean.success(messageService.getMessagesByType(messageType, pageNum, pageSize));
    }

    @PostMapping("")
    @ApiOperation("添加新闻/消息")
    public ResultBean addMessage(@RequestBody MessageVO messageVO) {
        return ResultBean.success(messageService.insertMessage(messageVO));
    }

    @PutMapping("")
    @ApiOperation("修改新闻/消息")
    public ResultBean modifyMessage(@RequestBody MessageVO messageVO) {
        return ResultBean.success(messageService.updateMessage(messageVO));
    }

    @DeleteMapping("")
    @ApiOperation("删除新闻/消息")
    public ResultBean deleteMessage(@RequestParam("id") Integer id) {
        return ResultBean.success(messageService.deleteMessage(id));
    }


}
