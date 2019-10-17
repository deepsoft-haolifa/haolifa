package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.model.domain.HlMail;
import com.deepsoft.haolifa.model.domain.HlMailReve;
import com.deepsoft.haolifa.model.domain.SysUser;
import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.model.vo.UserInfoVO;
import com.deepsoft.haolifa.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;

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
    @ApiOperation("获取所有站内信")
    public ResultBean getHlMails(@ApiParam("页码") @RequestParam(defaultValue = "1") int pageNum,
                                 @ApiParam("展示条数") @RequestParam(defaultValue = "10") int pageSize){
        System.out.println(pageNum);
        PageDTO<HlMail> pageDTO = new PageDTO<>();

        List<HlMail> hlMails = hlMailService.selectHlMails();
        pageDTO.setTotal(hlMails.size());
        hlMails = getList(pageNum,pageSize,hlMails);
        pageDTO.setList(hlMails);
        pageDTO.setPageNum(pageNum);
        System.out.println(hlMails.size());
        return ResultBean.success(pageDTO);
    }
    @GetMapping("/getSendMails")
    @ApiOperation("获取已发送站内信")
    public ResultBean getsendMails(@ApiParam("页码") @RequestParam(defaultValue = "1") int pageNum,
                                 @ApiParam("展示条数") @RequestParam(defaultValue = "10") int pageSize){

        PageDTO<HlMail> pageDTO = new PageDTO<>();
        UserInfoVO userInfoVO = userService.selectUserInfo();
        List<HlMail> hlMails = hlMailService.selectsendHlMails(userInfoVO.getRealName());
        pageDTO.setTotal(hlMails.size());
        hlMails = getList(pageNum,pageSize,hlMails);
        pageDTO.setList(hlMails);
        pageDTO.setPageNum(pageNum);

        return ResultBean.success(pageDTO);
    }
    @ApiOperation("发送站内信")
    @PostMapping("sendMail")
    public ResultBean sendMail(@RequestBody HlMailDTO model) {
        UserInfoVO userInfoVO = userService.selectUserInfo();
        HlMail hlMail = new HlMail();
        hlMail.setContent(model.getContent());
        int userId = Integer.valueOf(model.getUsers().split("-")[0]);
        SysUser sysUser = userService.getSysUser(userId);
        hlMail.setCreateTime(new Date());
        hlMail.setTitle(model.getTitle());
        hlMail.setUsers(model.getUsers());
        hlMail.setSendUser(userInfoVO.getRealName());
        hlMail.setRevUser(sysUser.getRealName());
        return hlMailService.save(hlMail);
    }
    @GetMapping("/getMailsByUserId")
    @ApiOperation("根据用户id获取某用户的所有站内信")
    public ResultBean getHlMails(@ApiParam("页码") @RequestParam(defaultValue = "1") int pageNum,
                                 @ApiParam("展示条数") @RequestParam(defaultValue = "10") int pageSize, @ApiParam("userId") @RequestParam(value = "userId") Integer userId){
        SysUser sysUser = userService.getSysUser(userId);
        if(sysUser==null){
            return ResultBean.error(CommonEnum.ResponseEnum.RESOURCE_NOT_EXIST);
        }
        PageDTO<HlMail> pageDTO = new PageDTO<>();
        String param = userId+"-"+sysUser.getUsername();
        List<HlMail> hlMails = hlMailService.selectHlMailsByUserId(param);
        pageDTO.setTotal(hlMails.size());
        hlMails = getList(pageNum,pageSize,hlMails);
        pageDTO.setList(hlMails);
        pageDTO.setPageNum(pageNum);
        System.out.println(hlMails.size());
        return ResultBean.success(pageDTO);
    }
    public static List<HlMail> getList(int pageNo,int pageSize,List<HlMail> list){
         pageNo=(pageNo-1)*pageSize;   //每页的起始索引
         Integer sum = list.size(); //记录总数

        if (pageNo+pageSize > sum) {
            list = list.subList(pageNo,sum );
        }else {
            list = list.subList(pageNo,pageNo+pageSize);
        }
        return list;
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
    @GetMapping("/getHlMailRevesByMailId")
    @ApiOperation("站内信详情")
    public ResultBean getHlMailReves(@ApiParam("mailId") @RequestParam(value = "mailId") Integer mailId){

        return ResultBean.success(hlMailReseService.selectHlMailReves(mailId));
    }

}