package com.deepsoft.haolifa.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.StoreRoomMapper;
import com.deepsoft.haolifa.model.domain.StoreRoom;
import com.deepsoft.haolifa.model.domain.StoreRoomExample;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.StoreRoomRequestDTO;
import com.deepsoft.haolifa.service.StoreRoomService;
import com.deepsoft.haolifa.util.BeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class StoreRoomServiceImpl implements StoreRoomService {

    @Autowired
    private StoreRoomMapper storeRoomMapper;

    @Override
    public ResultBean saveInfo(StoreRoomRequestDTO model) {
        log.info("StoreRoomServiceImpl saveInfo start|{}", JSONObject.toJSON(model));
        if (StringUtils.isAnyBlank(model.getName(), model.getRoomNo())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        StoreRoom storeRoom = new StoreRoom();
        BeanUtils.copyProperties(model, storeRoom);
        storeRoom.setStatus(CommonEnum.Consts.YES.code);
        storeRoom.setCreateUser(1);
        int insert = storeRoomMapper.insertSelective(storeRoom);
        return ResultBean.success(insert);
    }

    @Override
    public ResultBean updateInfo(StoreRoomRequestDTO model) {
        log.info("StoreRoomServiceImpl updateInfo start|{}", JSONObject.toJSON(model));
        if (model.getId() == 0) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        StoreRoom storeRoom = new StoreRoom();
        BeanUtils.copyProperties(model, storeRoom);
        storeRoom.setUpdateTime(new Date());

        StoreRoomExample example = new StoreRoomExample();
        example.or().andIdEqualTo(model.getId());
        int update = storeRoomMapper.updateByExampleSelective(storeRoom, example);
        return ResultBean.success(update);
    }

    @Override
    public ResultBean getInfo(int id) {
        log.info("StoreRoomServiceImpl getInfo start|id={}", id);
        if (id == 0) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        StoreRoom storeRoom = storeRoomMapper.selectByPrimaryKey(id);
        return ResultBean.success(storeRoom);
    }

    @Override
    public ResultBean listInfo(int type) {
        StoreRoomExample example = new StoreRoomExample();
        StoreRoomExample.Criteria criteria = example.createCriteria();
        if (type > 0) {
            criteria.andIdEqualTo(type);
        }
        List<StoreRoom> storeRooms = storeRoomMapper.selectByExample(example);
        return ResultBean.success(storeRooms);
    }
}
