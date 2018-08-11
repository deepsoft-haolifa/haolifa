package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.EquipmentMaintainRecordMapper;
import com.deepsoft.haolifa.dao.repository.EquipmentMapper;
import com.deepsoft.haolifa.model.domain.Equipment;
import com.deepsoft.haolifa.model.domain.EquipmentMaintainRecord;
import com.deepsoft.haolifa.model.domain.EquipmentMaintainRecordExample;
import com.deepsoft.haolifa.model.dto.EquipRepairedRecordDTO;
import com.deepsoft.haolifa.model.dto.EquipmentRequestDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
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
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    EquipmentMapper equipmentMapper;
    @Autowired
    EquipmentMaintainRecordMapper equipmentMaintainRecordMapper;

    @Override
    public ResultBean save(Equipment model) {
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
    public ResultBean getList(Integer currentPage, Integer pageSize, String name, String equipmentNo) {
        PageHelper.startPage(currentPage, pageSize);
        Page<Equipment> pageData = equipmentMapper.selectListByPage(name, equipmentNo);
        Map<String, Object> result = new HashMap<>(4);
        result.put("totalCount", pageData.getTotal());
        result.put("pageSize", pageData.getPageSize());
        result.put("pages", pageData.getPages());
        result.put("list", pageData.getResult());
        return ResultBean.success(result);
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
