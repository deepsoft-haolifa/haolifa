package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.vo.MessageVO;

import java.util.List;

public interface MessageService {

    PageDTO<MessageVO> getMessagesByType(Byte type, Integer pageNUm, Integer pageSize);

    int insertMessage(MessageVO messageVO);

    int updateMessage(MessageVO messageVO);

    MessageVO messageInfo(Integer id);

    int deleteMessage(Integer id);

}
