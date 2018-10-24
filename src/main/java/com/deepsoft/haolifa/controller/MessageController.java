package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.vo.MessageVO;
import com.deepsoft.haolifa.service.MessageService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/{messageType}")
    @ApiImplicitParam(name = "messageType", value = "'news':新闻，'notice'：消息", dataType = "string", required = true)
    @ApiOperation("获取新闻/消息列表")
    public ResultBean getMessages(@PathVariable("messageType") String messageType,
                                  @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                                  @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize ){
        switch (messageType){
            case "news": return ResultBean.success(messageService.getMessagesByType((byte)1, pageNum, pageSize));
            case "notices": return ResultBean.success(messageService.getMessagesByType((byte)1, pageNum, pageSize));
            default: return ResultBean.success("不支持的类型");
        }

    }

    @PostMapping("")
    @ApiOperation("添加新闻/消息列表")
    public ResultBean addMessage(@RequestBody MessageVO messageVO){
        return ResultBean.success(messageService.insertMessage(messageVO));
    }

    @PutMapping("")
    @ApiOperation("修改新闻/消息列表")
    public ResultBean modifyMessage(@RequestBody MessageVO messageVO){
        return ResultBean.success(messageService.insertMessage(messageVO));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除新闻/消息列表")
    public ResultBean deleteMessage(@PathVariable("id")Integer id){
        return ResultBean.success(messageService.deleteMessage(id));
    }


}
