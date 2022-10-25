package com.deepsoft.haolifa.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.AutoControlEntryOutRecordMapper;
import com.deepsoft.haolifa.dao.repository.AutoControlMaterialMapper;
import com.deepsoft.haolifa.dao.repository.extend.AutoControlMaterialExtendMapper;
import com.deepsoft.haolifa.model.domain.AutoControlEntryOutRecord;
import com.deepsoft.haolifa.model.domain.AutoControlEntryOutRecordExample;
import com.deepsoft.haolifa.model.domain.AutoControlMaterial;
import com.deepsoft.haolifa.model.domain.AutoControlMaterialExample;
import com.deepsoft.haolifa.model.dto.BaseException;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.autoControl.AutoControlEntryOutDto;
import com.deepsoft.haolifa.model.dto.autoControl.AutoControlEntryOutPage;
import com.deepsoft.haolifa.model.dto.autoControl.AutoControlEntryOutRecordRespVo;
import com.deepsoft.haolifa.model.dto.autoControl.AutoControlMaterialPageDto;
import com.deepsoft.haolifa.service.AutoControlMaterialService;
import com.deepsoft.haolifa.util.RandomUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author murphy.he
 **/
@Service
@Slf4j
public class AutoControlMaterialServiceImpl extends BaseService implements AutoControlMaterialService {

    @Autowired
    private AutoControlMaterialMapper autoControlMaterialMapper;
    @Autowired
    private AutoControlEntryOutRecordMapper autoControlEntryOutRecordMapper;
    @Autowired
    private AutoControlMaterialExtendMapper autoControlMaterialExtendMapper;

    @Override
    public int add(AutoControlMaterial material) {
        if (StrUtil.hasBlank(material.getMaterialName())) {
            throw new BaseException(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        material.setGraphNo("zk_" + RandomUtils.orderNoStr());
        int loginUserId = getLoginUserId();
        material.setCreateUser(loginUserId);
        int i = autoControlMaterialMapper.insertSelective(material);
        if (i > 0 && material.getQuantity() > 0f) {
            // 添加入库详情
            AutoControlEntryOutRecord record = new AutoControlEntryOutRecord();
            record.setType(CommonEnum.OperationType.ENTRY.code);
            record.setAutoControlId(material.getId());
            record.setGraphNo(material.getGraphNo());
            record.setQuantity(material.getQuantity());
            record.setCreateUser(loginUserId);
            autoControlEntryOutRecordMapper.insertSelective(record);
        }
        return i;
    }

    @Override
    public int update(AutoControlMaterial material) {
        if (material == null || material.getId() == null || material.getId() <= 0) {
            throw new BaseException(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        material.setUpdateUser(getLoginUserId());
        return autoControlMaterialMapper.updateByPrimaryKeySelective(material);
    }

    @Override
    public int del(int id) {
        return autoControlMaterialMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageDTO<AutoControlMaterial> pageList(AutoControlMaterialPageDto pageDto) {
        AutoControlMaterialExample example = new AutoControlMaterialExample();
        AutoControlMaterialExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(pageDto.getClassifyName())) {
            criteria.andClassifyNameLike("%" + pageDto.getClassifyName() + "%");
        }
        if (StringUtils.isNotBlank(pageDto.getMaterialName())) {
            criteria.andMaterialNameLike("%" + pageDto.getMaterialName() + "%");
        }
        if (StringUtils.isNotBlank(pageDto.getModel())) {
            criteria.andModelLike("%" + pageDto.getModel() + "%");
        }
        if (StringUtils.isNotBlank(pageDto.getSpecifications())) {
            criteria.andSpecificationsLike("%" + pageDto.getSpecifications() + "%");
        }
        example.setOrderByClause("id desc");
        Page<AutoControlMaterial> autoControlMaterials = PageHelper.startPage(pageDto.getPageNum(), pageDto.getPageSize())
            .doSelectPage(() -> autoControlMaterialMapper.selectByExample(example));
        PageDTO<AutoControlMaterial> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(autoControlMaterials, pageDTO);
        pageDTO.setList(autoControlMaterials);
        return pageDTO;
    }

    @Override
    public AutoControlMaterial infoByNo(String graphNo) {
        if (StrUtil.isBlank(graphNo)) {
            return null;
        }
        AutoControlMaterialExample example = new AutoControlMaterialExample();
        example.or().andGraphNoEqualTo(graphNo);
        List<AutoControlMaterial> autoControlMaterials = autoControlMaterialMapper.selectByExample(example);
        return CollectionUtil.isNotEmpty(autoControlMaterials) ? autoControlMaterials.get(0) : null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int entry(AutoControlEntryOutDto entryOutDto) {
        log.info("autoControl entry param start,{}", entryOutDto.toString());
        Integer autoControlId = entryOutDto.getAutoControlId();
        AutoControlMaterial autoControlMaterial = autoControlMaterialMapper.selectByPrimaryKey(autoControlId);
        if (autoControlMaterial == null) {
            throw new BaseException(CommonEnum.ResponseEnum.DATA_NOT_FOUND);
        }
        if (entryOutDto.getQuantity() <= 0) {
            throw new BaseException(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        entryOutDto.setQuantity(Math.abs(entryOutDto.getQuantity()));
        AutoControlEntryOutRecord record = new AutoControlEntryOutRecord();
        BeanUtil.copyProperties(entryOutDto, record);
        record.setCreateUser(getLoginUserId());
        record.setType(CommonEnum.OperationType.ENTRY.code);
        int insert = autoControlEntryOutRecordMapper.insertSelective(record);
        if (insert > 0) {
            // 更新库存数据
            Float quantity = autoControlMaterial.getQuantity();
            AutoControlMaterial updateSp = new AutoControlMaterial();
            updateSp.setQuantity(entryOutDto.getQuantity() + quantity);
            updateSp.setId(autoControlId);
            autoControlMaterialMapper.updateByPrimaryKeySelective(updateSp);
        }
        return insert;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int out(AutoControlEntryOutDto entryOutDto) {
        log.info("autoControl out param start,{}", entryOutDto.toString());
        Integer autoControlId = entryOutDto.getAutoControlId();
        AutoControlMaterial autoControlMaterial = autoControlMaterialMapper.selectByPrimaryKey(autoControlId);
        if (autoControlMaterial == null) {
            throw new BaseException(CommonEnum.ResponseEnum.DATA_NOT_FOUND);
        }
        if (entryOutDto.getQuantity() > autoControlMaterial.getQuantity()) {
            throw new BaseException(CommonEnum.ResponseEnum.MATERIAL_NOT_ENOUGH);
        }
        entryOutDto.setQuantity(Math.abs(entryOutDto.getQuantity()));
        AutoControlEntryOutRecord record = new AutoControlEntryOutRecord();
        BeanUtil.copyProperties(entryOutDto, record);
        record.setCreateUser(getLoginUserId());
        record.setType(CommonEnum.OperationType.OUT.code);
        int insert = autoControlEntryOutRecordMapper.insertSelective(record);
        if (insert > 0) {
            // 更新库存数据
            Float quantity = autoControlMaterial.getQuantity();
            AutoControlMaterial updateSp = new AutoControlMaterial();
            updateSp.setId(autoControlId);
            updateSp.setQuantity(quantity - entryOutDto.getQuantity());
            // 扣减的数量要小于等于库存数量
            AutoControlMaterialExample example = new AutoControlMaterialExample();
            AutoControlMaterialExample.Criteria criteria = example.createCriteria();
            criteria.andIdEqualTo(autoControlId).andQuantityGreaterThanOrEqualTo(entryOutDto.getQuantity());
            autoControlMaterialMapper.updateByPrimaryKeySelective(updateSp);
        }
        return insert;
    }

    @Override
    public PageDTO<AutoControlEntryOutRecordRespVo> entryOutPage(AutoControlEntryOutPage pageDto) {
        AutoControlEntryOutRecordExample example = new AutoControlEntryOutRecordExample();
        AutoControlEntryOutRecordExample.Criteria criteria = example.createCriteria();

        if (pageDto.getAutoControlId() == null || pageDto.getAutoControlId() <= 0) {
            throw new BaseException(CommonEnum.ResponseEnum.PARAM_ERROR);
        }

        example.setOrderByClause("id desc");
        Page<AutoControlEntryOutRecordRespVo> autoControlMaterials = PageHelper.startPage(pageDto.getPageNum(), pageDto.getPageSize())
            .doSelectPage(() -> autoControlMaterialExtendMapper.pageRecord(pageDto));
        if (CollectionUtil.isEmpty(autoControlMaterials)) {
            return new PageDTO<>();
        }

        PageDTO<AutoControlEntryOutRecordRespVo> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(autoControlMaterials, pageDTO);
        pageDTO.setList(autoControlMaterials.getResult());
        return pageDTO;
    }

}
