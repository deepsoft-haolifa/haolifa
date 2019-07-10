package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.HlMailReve;

import java.util.List;

public interface HlMailReveMapper {

    int insert(HlMailReve hlMailReve);

    List<HlMailReve> selectHlMailReves(int mailId);

}