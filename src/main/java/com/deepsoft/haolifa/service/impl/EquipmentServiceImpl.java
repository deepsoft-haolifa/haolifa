package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.EquipmentMaintainRecordMapper;
import com.deepsoft.haolifa.dao.repository.EquipmentMapper;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.service.EquipmentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class EquipmentServiceImpl extends BaseService implements EquipmentService {

    @Autowired
    EquipmentMapper equipmentMapper;
    @Autowired
    EquipmentMaintainRecordMapper equipmentMaintainRecordMapper;

    @Override
    public ResultBean save(Equipment model) {
        model.setCreateUserId(1);
        int insert = equipmentMapper.insertSelective(model);
        return ResultBean.success(insert);
    }

    @Override
    public ResultBean delete(Integer id) {
        int delete = equipmentMapper.deleteByPrimaryKey(id);
        return ResultBean.success(delete);
    }

    @Override
    public ResultBean update(Equipment model) {
        int update = equipmentMapper.updateByPrimaryKeySelective(model);
        return ResultBean.success(update);
    }

    @Override
    public ResultBean getInfo(Integer id) {
        Equipment equipment = equipmentMapper.selectByPrimaryKey(id);
        return ResultBean.success(equipment);
    }

    @Override
    public ResultBean getList(EquipmentListDTO model) {
        if (model.getPageNum() == null || model.getPageNum() == 0) {
            model.setPageNum(1);
        }
        if (model.getPageSize() == null || model.getPageSize() == 0) {
            model.setPageSize(10);
        }
        EquipmentExample equipmentExample = new EquipmentExample();
        EquipmentExample.Criteria criteria = equipmentExample.createCriteria();
        if (model.getType() == 1 && model.getSupplierNo() != null) {
            criteria.andSupplierNoLike("%" + model.getSupplierNo() + "%");
        }
        if (model.getType() == 2) {
            criteria.andSupplierNoEqualTo("0");
        }
        if (model.getEquipmentNo() != null) {
            criteria.andEquipmentNoLike("%" + model.getEquipmentNo() + "%");
        }
        if (model.getName() != null) {
            criteria.andNameLike("%" + model.getName() + "%");
        }
        Page<Equipment> pageData = PageHelper.startPage(model.getPageNum(),model.getPageSize())
                .doSelectPage(()->{
                   equipmentMapper.selectByExample(equipmentExample);
                });
        PageDTO<Equipment> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData,pageDTO);
        pageDTO.setList(pageData.getResult());
        return ResultBean.success(pageDTO);
    }

    @Override
    public ResultBean saveMaintainRecord(EquipRepairedRecordDTO model) {
        EquipmentMaintainRecord equipmentMaintainRecord = new EquipmentMaintainRecord();
        BeanUtils.copyProperties(model, equipmentMaintainRecord);
        // TODO, 替换真实userId
        equipmentMaintainRecord.setCreateUserId(1);
        int insert = equipmentMaintainRecordMapper.insertSelective(equipmentMaintainRecord);
        return ResultBean.success(insert);
    }

    @Override
    public ResultBean getMaintainRecordList(String equipmentNo) {
        EquipmentMaintainRecordExample equipmentMaintainRecordExample = new EquipmentMaintainRecordExample();
        equipmentMaintainRecordExample.createCriteria().andEquipmentNoEqualTo(equipmentNo);
        List<EquipmentMaintainRecord> list = equipmentMaintainRecordMapper.selectByExample(equipmentMaintainRecordExample);
        return ResultBean.success(list);
    }
}
