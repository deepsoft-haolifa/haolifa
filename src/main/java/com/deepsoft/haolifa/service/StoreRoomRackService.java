package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.StoreRoomRackRequestDTO;

public interface StoreRoomRackService {

    /**
     * 添加库房货位配置
     *
     * @param model
     * @return
     */
    ResultBean saveRackInfo(StoreRoomRackRequestDTO model);


    /**
     * 更新库房货位配置
     *
     * @param model
     * @return
     */
    ResultBean updateRackInfo(StoreRoomRackRequestDTO model);
    /**
     * 删除库房货位配置
     *
     * @param id
     * @return
     */
    ResultBean delete(int id);


    /**
     * 获取库房货位列表
     *
     * @return
     */
    ResultBean pageRackInfo(Integer currentPage, Integer pageSize, Integer roomId);

}
