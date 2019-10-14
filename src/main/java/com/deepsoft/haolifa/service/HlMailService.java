package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.HlMail;
import com.deepsoft.haolifa.model.dto.InvoiceCreateDTO;
import com.deepsoft.haolifa.model.dto.InvoiceDTO;
import com.deepsoft.haolifa.model.dto.InvoiceListDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;

import java.util.List;

public interface HlMailService {
    /**
     * 添加站内信
     * @param model
     * @return
     */
    ResultBean save(HlMail model);


    /**
     * 获取站内信列表

     * @return
     */
    List<HlMail> selectHlMails();
    /**
     * 获取站内信列表

     * @return
     */
    List<HlMail> selectHlMailsByUserId(String param);
    /**
     * 获取已发送站内信列表

     * @return
     */
    List<HlMail> selectsendHlMails(String userName);

}
