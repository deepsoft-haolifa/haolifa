package com.deepsoft.haolifa.service.impl;


import com.deepsoft.haolifa.dao.repository.HlMailMapper;
import com.deepsoft.haolifa.model.domain.HlMail;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.HlMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HlMailServiceImpl implements HlMailService {
    @Autowired
    private HlMailMapper hlMailMapper;

    @Override
    public ResultBean save(HlMail model) {

        int insert = hlMailMapper.insert(model);
        return ResultBean.success(insert);
    }

    @Override
    public  List<HlMail> selectHlMails() {
        List<HlMail> hlMails = hlMailMapper.selectHlMails();
        return hlMails;
    }

    @Override
    public List<HlMail> selectHlMailsByUserId(String param) {
        List<HlMail> hlMails = hlMailMapper.selectHlMailsByUserId(param);
        return hlMails;
    }

}
