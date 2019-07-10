package com.deepsoft.haolifa.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.StoreRoomMapper;
import com.deepsoft.haolifa.model.domain.StoreRoom;
import com.deepsoft.haolifa.model.domain.StoreRoomExample;
import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.model.dto.stormRoom.StoreRoomListDTO;
import com.deepsoft.haolifa.model.dto.stormRoom.StoreRoomRequestDTO;
import com.deepsoft.haolifa.service.StoreRoomService;
import com.deepsoft.haolifa.service.SysUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.deepsoft.haolifa.constant.CommonEnum.Consts.NO;

@Service
@Slf4j
public class StoreRoomServiceImpl implements StoreRoomService {

    @Autowired
    private StoreRoomMapper storeRoomMapper;
    @Autowired
    private SysUserService sysUserService;

    @Override
    public ResultBean saveInfo(StoreRoomRequestDTO model) {
        log.info("StoreRoomServiceImpl saveInfo start|{}", JSONObject.toJSON(model));
        final String roomNo = model.getRoomNo();
        if (StringUtils.isAnyBlank(model.getName(), roomNo)) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        StoreRoom storeRoom = new StoreRoom();
        BeanUtils.copyProperties(model, storeRoom);
        storeRoom.setCreateUser(sysUserService.selectLoginUser().getId());

        // 判断库房号是否存在
        StoreRoomExample storeRoomExample = new StoreRoomExample();
        storeRoomExample.or().andRoomNoEqualTo(roomNo);
        long count = storeRoomMapper.countByExample(storeRoomExample);
        if (count > 0) {
            return ResultBean.error(CommonEnum.ResponseEnum.STORE_ROOM_NO_EXISTS);
        }

        int insert = storeRoomMapper.insertSelective(storeRoom);
        return ResultBean.success(insert);
    }

    @Override
    public ResultBean updateInfo(StoreRoomRequestDTO model) {
        log.info("StoreRoomServiceImpl updateInfo start|{}", JSONObject.toJSON(model));
        if (model.getId() == 0) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        // 判断库房号是否存在
        StoreRoomExample storeRoomExample = new StoreRoomExample();
        storeRoomExample.or().andRoomNoEqualTo(model.getRoomNo()).andIdNotEqualTo(model.getId());
        long count = storeRoomMapper.countByExample(storeRoomExample);
        if (count > 0) {
            return ResultBean.error(CommonEnum.ResponseEnum.STORE_ROOM_NO_EXISTS);
        }

        StoreRoom storeRoom = new StoreRoom();
        BeanUtils.copyProperties(model, storeRoom);
        storeRoom.setUpdateTime(new Date());
        storeRoom.setUpdateUser(sysUserService.selectLoginUser().getId());

        StoreRoomExample example = new StoreRoomExample();
        example.or().andIdEqualTo(model.getId());
        int update = storeRoomMapper.updateByExampleSelective(storeRoom, example);
        return ResultBean.success(update);
    }

    @Override
    public ResultBean delete(int id) {
        StoreRoom record = new StoreRoom() {{
            setId(id);
            setIsDelete(CommonEnum.Consts.YES.code);
        }};
        int update = storeRoomMapper.updateByPrimaryKeySelective(record);
        return ResultBean.success(update);
    }

    @Override
    public StoreRoom getInfo(int id) {
        log.info("StoreRoomServiceImpl getInfo start|id={}", id);
        if (id == 0) {
            return null;
        }
        StoreRoom storeRoom = storeRoomMapper.selectByPrimaryKey(id);
        return storeRoom;
    }

    @Override
    public StoreRoom getInfoByNo(String roomNo) {
        log.info("StoreRoomServiceImpl getInfo start|roomNo={}", roomNo);
        if (StringUtils.isBlank(roomNo)) {
            return null;
        }
        StoreRoomExample example = new StoreRoomExample();
        example.or().andRoomNoEqualTo(roomNo);
        List<StoreRoom> storeRooms = storeRoomMapper.selectByExample(example);
        if (storeRooms.size() > 0) {
            return storeRooms.get(0);
        }
        return null;
    }

    @Override
    public ResultBean listInfo(int type) {
        StoreRoomExample example = new StoreRoomExample();
        StoreRoomExample.Criteria criteria = example.createCriteria();
        if (type > 0) {
            criteria.andTypeEqualTo((byte) type);
        }
        criteria.andIsDeleteEqualTo(NO.code);
        List<StoreRoom> storeRooms = storeRoomMapper.selectByExample(example);
        if (storeRooms.size() > 0) {
            List<StoreRoomListDTO> storeRoomListDTOS = JSON.parseArray(JSON.toJSONString(storeRooms), StoreRoomListDTO.class);
            return ResultBean.success(storeRoomListDTOS);
        } else {
            return ResultBean.success(null);
        }
    }

    @Override
    public ResultBean pageInfo(Integer currentPage, Integer pageSize, String nameLike, Byte type) {
        currentPage = currentPage == null ? 1 : currentPage;
        pageSize = pageSize == null ? 20 : pageSize;

        StoreRoomExample example = new StoreRoomExample();
        StoreRoomExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("create_time desc");
        criteria.andIsDeleteEqualTo(CommonEnum.Consts.NO.code);
        if (StringUtils.isNotBlank(nameLike)) {
            criteria.andNameLike("%" + nameLike + "%");
        }
        if (type != null && type > 0) {
            criteria.andTypeEqualTo(type);
        }
        Page<StoreRoom> storeRooms = PageHelper.startPage(currentPage, pageSize)
                .doSelectPage(() -> storeRoomMapper.selectByExample(example));

        PageDTO<StoreRoom> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(storeRooms, pageDTO);
        pageDTO.setList(storeRooms);
        return ResultBean.success(pageDTO);
    }
}
