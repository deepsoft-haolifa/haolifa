package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.StoreRoomRack;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.StoreRoomRackRequestDTO;

import java.util.List;

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
     * 获取库房库位详情
     *
     * @param id
     * @return
     */
    StoreRoomRack getInfo(int id);

    /**
     * 根据库房No获取库位列表
     *
     * @param stormNo
     * @return
     */
    List<StoreRoomRack> getListByStormNo(String stormNo);

    /**
     * 获取库房货位列表
     *
     * @return
     */
    ResultBean pageRackInfo(Integer currentPage, Integer pageSize, String roomNo, String rackNameLike);

}
