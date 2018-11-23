package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.*;

import java.util.List;

public interface ApplyBuyService {
    /**
     * 保存请购单
     * @param model
     * @return
     */
    ResultBean save(ApplyBuyDTO model);


    /**
     * 更新请购单项
     * @param model
     * @return
     */
    ResultBean update(ApplyBuyUpdateDTO model);

    /**
     * 获取请购详情
     * @param applyBuyId
     * @return
     */
    ResultBean getInfo(Integer applyBuyId);

    /**
     * 删除请购单单项
     * @param applyBuyNo
     * @param materialGraphNo
     * @return
     */
    ResultBean deleteItem(String applyBuyNo, String materialGraphNo);
}
