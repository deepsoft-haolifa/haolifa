package com.deepsoft.haolifa.service.impl;


import com.deepsoft.haolifa.dao.repository.HlMailReveMapper;
import com.deepsoft.haolifa.model.domain.HlMail;
import com.deepsoft.haolifa.model.domain.HlMailReve;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.HlMailReseService;
import com.deepsoft.haolifa.service.HlMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HlMailReveServiceImpl implements HlMailReseService {
    @Autowired
    private HlMailReveMapper hlMailReveMapper;


    @Override
    public ResultBean save(HlMailReve model) {
        int insert = hlMailReveMapper.insert(model);
        return ResultBean.success(insert);
    }

    @Override
    public  List<HlMailReve> selectHlMailReves(Integer mailId) {
        List<HlMailReve> hlMailReves = hlMailReveMapper.selectHlMailReves(mailId);
        return hlMailReves;
    }
}
