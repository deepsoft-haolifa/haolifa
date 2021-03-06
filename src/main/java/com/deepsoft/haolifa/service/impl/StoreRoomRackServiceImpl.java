package com.deepsoft.haolifa.service.impl;

import com.alibaba.fastjson.JSON;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.StoreRoomRackMapper;
import com.deepsoft.haolifa.model.domain.StoreRoom;
import com.deepsoft.haolifa.model.domain.StoreRoomRack;
import com.deepsoft.haolifa.model.domain.StoreRoomRackExample;
import com.deepsoft.haolifa.model.dto.CustomUser;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.stormRoom.StoreRoomListDTO;
import com.deepsoft.haolifa.model.dto.stormRoom.StoreRoomRackListDTO;
import com.deepsoft.haolifa.model.dto.stormRoom.StoreRoomRackRequestDTO;
import com.deepsoft.haolifa.service.StoreRoomRackService;
import com.deepsoft.haolifa.service.StoreRoomService;
import com.deepsoft.haolifa.service.SysUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class StoreRoomRackServiceImpl implements StoreRoomRackService {

    @Autowired
    private StoreRoomRackMapper storeRoomRackMapper;
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private StoreRoomService storeRoomService;

    @Override
    public ResultBean saveRackInfo(StoreRoomRackRequestDTO model) {
        CustomUser customUser = sysUserService.selectLoginUser();
        int createUser = customUser != null ? customUser.getId() : 1;
        // 判断是否有这个仓库
        StoreRoom info = storeRoomService.getInfoByNo(model.getRoomNo());
        if (info == null) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR, "库房不存在");
        }
        // 判断这个仓库是否存在货位号
        String storeRoomNo = model.getRoomNo();
        String rackNo = model.getRackNo();
        boolean existRackNo = judgeRackNo(rackNo, storeRoomNo, 0);
        log.info("saveRackInfo existRackNo roomId:{},stackNo:{},result:{}", storeRoomNo, rackNo, existRackNo);
        if (!existRackNo) {
            return ResultBean.error(CommonEnum.ResponseEnum.STORE_ROOM_RACK_EXISTS);
        }
        StoreRoomRack record = new StoreRoomRack() {{
            setCreateUser(createUser);
            setRoomNo(storeRoomNo);
            setRackNo(rackNo);
            setRackName(model.getRackName());
            setRemark(model.getRemark());
        }};
        int insert = storeRoomRackMapper.insertSelective(record);
        return ResultBean.success(insert);
    }

    @Override
    public ResultBean updateRackInfo(StoreRoomRackRequestDTO model) {
        if (model.getId() == 0) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        // 判断这个仓库是否存在货位号
        String storeRoomNo = model.getRoomNo();
        String rackNo = model.getRackNo();
        boolean existRackNo = judgeRackNo(rackNo, storeRoomNo, model.getId());
        log.info("updateRackInfo existRackNo roomId:{},rackNo:{},result:{}", storeRoomNo, rackNo, existRackNo);
        if (!existRackNo) {
            return ResultBean.error(CommonEnum.ResponseEnum.STORE_ROOM_RACK_EXISTS);
        }
        StoreRoomRack storeRoomRack = new StoreRoomRack();
        BeanUtils.copyProperties(model, storeRoomRack);
        storeRoomRack.setUpdateTime(new Date());
        storeRoomRack.setUpdateUser(sysUserService.selectLoginUser().getId());

        StoreRoomRackExample example = new StoreRoomRackExample();
        example.or().andIdEqualTo(model.getId());
        int update = storeRoomRackMapper.updateByExampleSelective(storeRoomRack, example);
        return ResultBean.success(update);
    }

    @Override
    public ResultBean delete(int id) {
        StoreRoomRack record = new StoreRoomRack() {{
            setId(id);
            setIsDelete(CommonEnum.Consts.YES.code);
        }};
        int update = storeRoomRackMapper.updateByPrimaryKeySelective(record);
        return ResultBean.success(update);
    }

    @Override
    public StoreRoomRack getInfo(int id) {
        StoreRoomRack storeRoomRack = storeRoomRackMapper.selectByPrimaryKey(id);
        return storeRoomRack;
    }

    @Override
    public List<StoreRoomRackListDTO> getListByRoomNo(String roomNo) {
        List<StoreRoomRackListDTO> list = new ArrayList<>();
        StoreRoomRackExample example = new StoreRoomRackExample();
        StoreRoomRackExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(roomNo)) {
            criteria.andRoomNoEqualTo(roomNo);
        }
        List<StoreRoomRack> storeRoomRacks = storeRoomRackMapper.selectByExample(example);
        if (storeRoomRacks.size() > 0) {
            list = JSON.parseArray(JSON.toJSONString(storeRoomRacks), StoreRoomRackListDTO.class);
        }
        return list;
    }

    @Override
    public ResultBean pageRackInfo(Integer currentPage, Integer pageSize, String roomNo, String rackNameLike) {
        currentPage = currentPage == null ? 1 : currentPage;
        pageSize = pageSize == null ? 20 : pageSize;
        StoreRoomRackExample example = new StoreRoomRackExample();
        StoreRoomRackExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("create_time desc");
        criteria.andIsDeleteEqualTo(CommonEnum.Consts.NO.code);
        if (StringUtils.isNotBlank(roomNo)) {
            criteria.andRoomNoEqualTo("%" + roomNo + "%");
        }
        if (StringUtils.isNotBlank(rackNameLike)) {
            criteria.andRackNameLike("%" + rackNameLike + "%");
        }
        Page<StoreRoomRack> storeRoomRacks = PageHelper.startPage(currentPage, pageSize)
                .doSelectPage(() -> storeRoomRackMapper.selectByExample(example));
        PageDTO<StoreRoomRack> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(storeRoomRacks, pageDTO);
        pageDTO.setList(storeRoomRacks);
        return ResultBean.success(pageDTO);
    }

    /**
     * 判断该库房中是否存在相同的货位号
     *
     * @param rackNo
     * @param roomNo
     * @return
     */
    private boolean judgeRackNo(String rackNo, String roomNo, int id) {
        StoreRoomRackExample example = new StoreRoomRackExample();
        StoreRoomRackExample.Criteria criteria = example.createCriteria();
        criteria.andRackNoEqualTo(rackNo).andRoomNoEqualTo(roomNo).andIsDeleteEqualTo(CommonEnum.Consts.NO.code);
        List<StoreRoomRack> storeRoomRacks = storeRoomRackMapper.selectByExample(example);
        if (storeRoomRacks.size() > 0) {
            // 更新的时候传id，如果查出来的id和传过来的id相同，则返回false
            if (id > 0) {
                StoreRoomRack storeRoomRack = storeRoomRacks.get(0);
                if (storeRoomRack.getId() == id) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}
