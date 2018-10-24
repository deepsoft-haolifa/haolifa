package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.SysMessageMapper;
import com.deepsoft.haolifa.model.domain.SysMessage;
import com.deepsoft.haolifa.model.domain.SysMessageExample;
import com.deepsoft.haolifa.model.dto.BaseException;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.vo.MessageVO;
import com.deepsoft.haolifa.service.MessageService;
import com.deepsoft.haolifa.service.SysUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private SysMessageMapper sysMessageMapper;
    @Autowired
    private SysUserService userService;

    @Override
    public PageDTO<MessageVO> getMessagesByType(Byte type, Integer pageNum, Integer pageSize) {
        SysMessageExample messageExample = new SysMessageExample();
        messageExample.or().andTypeEqualTo(type);
        messageExample.setOrderByClause("show_time desc");
        Page<SysMessage> messages = PageHelper.startPage(pageNum, pageSize)
                .doSelectPage(() -> sysMessageMapper.selectByExampleWithBLOBs(messageExample));
        List<MessageVO> messageVOS = messages.stream().map(m -> {
            return new MessageVO() {{
                setId(m.getId());
                setShowTime(m.getShowTime());
                setContent(m.getContent());
            }};
        }).collect(Collectors.toList());
        PageDTO<MessageVO> messageDTOs = new PageDTO<>();
        BeanUtils.copyProperties(messages, messageDTOs);
        messageDTOs.setList(messageVOS);
        return messageDTOs;
    }

    @Override
    public int insertMessage(MessageVO messageVO) {
        SysMessage sysMessage = new SysMessage();
        BeanUtils.copyProperties(messageVO, sysMessage);
        sysMessage.setCreateUser(userService.selectLoginUser().getId());
        return sysMessageMapper.insertSelective(sysMessage);
    }

    @Override
    public int updateMessage(MessageVO messageVO) {
        if(messageVO.getId() == null){
            throw new BaseException("id 不能为空");
        }
        SysMessage sysMessage = new SysMessage();
        BeanUtils.copyProperties(messageVO, sysMessage);
        return sysMessageMapper.updateByPrimaryKeySelective(sysMessage);
    }

    @Override
    public int deleteMessage(Integer id) {
        return sysMessageMapper.deleteByPrimaryKey(id);
    }
}
