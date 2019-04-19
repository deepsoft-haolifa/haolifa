package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.model.domain.HlMail;
import com.deepsoft.haolifa.model.domain.HlMailReve;
import com.deepsoft.haolifa.model.domain.SysUser;
import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Date;

@RestController
@RequestMapping("/hlmail")
@Api(tags = {"站内信管理"})
public class HlMailController {

    @Autowired
    private HlMailService hlMailService;
    @Autowired
    private SysUserService userService;
    @Autowired
    private HlMailReseService hlMailReseService;
//    @Autowired
//    private HlMailReseService hlMailReseService;

    @GetMapping("/getMails")
    @ApiOperation("根据用户id获取某用户的所有角色")
    public ResultBean getHlMails(){
        return ResultBean.success(hlMailService.selectHlMails());
    }
    @ApiOperation("发送站内信")
    @PostMapping("sendMail")
    public ResultBean sendMail(@RequestBody HlMailDTO model) {

        HlMail hlMail = new HlMail();
        hlMail.setContent(model.getContent());
        hlMail.setCreateTime(new Date());
        hlMail.setTitle(model.getTitle());
        hlMail.setUsers(model.getUsers());
        return hlMailService.save(hlMail);
    }
    @GetMapping("/getMails/{userId}")
    @ApiOperation("根据用户id获取某用户的所有站内信")
    public ResultBean getHlMails(@PathParam(value = "userId") Integer userId){
        SysUser sysUser = userService.getSysUser(userId);
        if(sysUser==null){
            return ResultBean.error(CommonEnum.ResponseEnum.RESOURCE_NOT_EXIST);
        }
        String param = sysUser.getRealName()+"-"+sysUser.getUsername();
        return ResultBean.success(hlMailService.selectHlMailsByUserId(param));
    }
    @ApiOperation("站内回执")
    @PostMapping("sendMailReve")
    public ResultBean sendMailReve(@RequestBody HlMailReveDTO model) {

        HlMailReve hlMailReve = new HlMailReve();
        hlMailReve.setContent(model.getContent());
        hlMailReve.setCreateTime(new Date());
        hlMailReve.setMailId(model.getMailId());
        hlMailReve.setUserId(model.getUserId());
        hlMailReve.setUserName(model.getUserName());
        return hlMailReseService.save(hlMailReve);
    }
    @GetMapping("/getHlMailReves/{mailId}")
    @ApiOperation("根据用户id获取某用户的所有站内信")
    public ResultBean getHlMailReves(@PathParam(value = "mailId") Integer mailId){

        return ResultBean.success(hlMailReseService.selectHlMailReves(mailId));
    }

}