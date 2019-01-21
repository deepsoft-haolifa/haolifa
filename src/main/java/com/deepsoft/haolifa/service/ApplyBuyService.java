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
     * @param formNo
     * @return
     */
    ResultBean getInfo(String formNo);

    /**
     * 删除请购单单项
     * @param itemId
     * @return
     */
    ResultBean deleteItem(int itemId);

    /**
     * 填写采购完成日期
     * @param itemId
     * @param arrivalTime
     * @return
     */
    ResultBean updateArrivalTime(int itemId, String arrivalTime);

    /**
     * 更新待采购单项状态
     * @param itemId
     * @return
     */
    ResultBean updateStatus(int itemId);

    /**
     * 列表
     */
    ResultBean list(int pageNum, int pageSize, int status);

    /**
     * 生产订单 关联的请购列表
     * @param orderNo
     * @return
     */
  ResultBean list(String orderNo);
}
