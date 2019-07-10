package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.HlMail;
import com.deepsoft.haolifa.model.domain.HlMailReve;
import com.deepsoft.haolifa.model.dto.ResultBean;

import java.util.List;

public interface HlMailReseService {
    /**
     * 添加站内信回执
     * @param model
     * @return
     */
    ResultBean save(HlMailReve model);


    /**
     * 获取站内信回执列表

     * @return
     */
    List<HlMailReve> selectHlMailReves(Integer mailId);


}
