package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.StoreRoom;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.StoreRoomRequestDTO;

public interface StoreRoomService {

    /**
     * 添加库房配置
     * @param model
     * @return
     */
    ResultBean saveInfo(StoreRoomRequestDTO model);


    /**
     * 更新库房配置
     * @param model
     * @return
     */
    ResultBean updateInfo(StoreRoomRequestDTO model);


    /**
     * 获取主键Id库房详情
     * @return
     */
    ResultBean getInfo(int id);

    /**
     * 获取库房列表
     * @param type 0.所有库；1.原料库；2：成品库；3.既有原料，又有成品;
     * @return
     */
    ResultBean listInfo(int type);
}
