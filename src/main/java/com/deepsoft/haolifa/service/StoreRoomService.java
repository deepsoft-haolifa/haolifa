package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.StoreRoom;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.StoreRoomConditionDTO;
import com.deepsoft.haolifa.model.dto.StoreRoomRequestDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface StoreRoomService {

    /**
     * 添加库房配置
     *
     * @param model
     * @return
     */
    ResultBean saveInfo(StoreRoomRequestDTO model);


    /**
     * 更新库房配置
     *
     * @param model
     * @return
     */
    ResultBean updateInfo(StoreRoomRequestDTO model);

    /**
     * 删除库房配置
     *
     * @return
     */
    ResultBean delete(int id);


    /**
     * 获取主键Id库房详情
     *
     * @return
     */
    StoreRoom getInfo(int id);

    /**
     * 获取库房列表
     *
     * @param type 0.所有库；1.原料库；2：成品库；3.既有原料，又有成品;
     * @return
     */
    ResultBean listInfo(int type);


    /**
     * 获取库房分页列表
     * @param currentPage
     * @param pageSize
     * @param nameLike 名称模糊查询
     * @param type 类型查询
     * @return
     */
    ResultBean pageInfo(Integer currentPage, Integer pageSize, String nameLike, Byte type);
}
