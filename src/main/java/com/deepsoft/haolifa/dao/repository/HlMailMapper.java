package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.HlMail;

import java.util.List;

public interface HlMailMapper {

    int insert(HlMail hlMail);

    List<HlMail> selectHlMails();
    List<HlMail> selectsendHlMails(String userName);
    List<HlMail> selectHlMailsByUserId(String param);

}