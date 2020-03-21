package com.deepsoft.haolifa.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.SporadicEntryOutRecordMapper;
import com.deepsoft.haolifa.dao.repository.SporadicMaterialMapper;
import com.deepsoft.haolifa.dao.repository.extend.SporadicMaterialExtendMapper;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.BaseException;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.sporadic.SporadicEntryOutDto;
import com.deepsoft.haolifa.model.dto.sporadic.SporadicEntryOutPage;
import com.deepsoft.haolifa.model.dto.sporadic.SporadicEntryOutRecordRespVo;
import com.deepsoft.haolifa.model.dto.sporadic.SporadicMaterialPageDto;
import com.deepsoft.haolifa.service.SporadicMaterialService;
import com.deepsoft.haolifa.util.RandomUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author murphy.he
 **/
@Service
@Slf4j
public class SporadicMaterialServiceImpl extends BaseService implements SporadicMaterialService {

    @Autowired
    private SporadicMaterialMapper sporadicMaterialMapper;
    @Autowired
    private SporadicEntryOutRecordMapper sporadicEntryOutRecordMapper;
    @Autowired
    private SporadicMaterialExtendMapper sporadicMaterialExtendMapper;

    @Override
    public int add(SporadicMaterial material) {
        if (StrUtil.hasBlank(material.getMaterialName())) {
            throw new BaseException(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        material.setGraphNo("lx_" + RandomUtils.orderNoStr());
        material.setCreateUser(getLoginUserId());
        return sporadicMaterialMapper.insertSelective(material);
    }

    @Override
    public int update(SporadicMaterial material) {
        if (material == null || material.getId() == null || material.getId() <= 0) {
            throw new BaseException(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        material.setUpdateUser(getLoginUserId());
        return sporadicMaterialMapper.updateByPrimaryKeySelective(material);
    }

    @Override
    public int del(int id) {
        return sporadicMaterialMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageDTO<SporadicMaterial> pageList(SporadicMaterialPageDto pageDto) {
        SporadicMaterialExample example = new SporadicMaterialExample();
        SporadicMaterialExample.Criteria criteria = example.createCriteria();
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
        Page<SporadicMaterial> sporadicMaterials = PageHelper.startPage(pageDto.getPageNum(), pageDto.getPageSize())
            .doSelectPage(() -> sporadicMaterialMapper.selectByExample(example));
        PageDTO<SporadicMaterial> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(sporadicMaterials, pageDTO);
        pageDTO.setList(sporadicMaterials);
        return pageDTO;
    }

    @Override
    public SporadicMaterial infoByNo(String graphNo) {
        if (StrUtil.isBlank(graphNo)) {
            return null;
        }
        SporadicMaterialExample example = new SporadicMaterialExample();
        example.or().andGraphNoEqualTo(graphNo);
        List<SporadicMaterial> sporadicMaterials = sporadicMaterialMapper.selectByExample(example);
        return CollectionUtil.isNotEmpty(sporadicMaterials) ? sporadicMaterials.get(0) : null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int entry(SporadicEntryOutDto entryOutDto) {
        log.info("sporadic entry param start,{}", entryOutDto.toString());
        Integer sporadicId = entryOutDto.getSporadicId();
        SporadicMaterial sporadicMaterial = sporadicMaterialMapper.selectByPrimaryKey(sporadicId);
        if (sporadicMaterial == null) {
            throw new BaseException(CommonEnum.ResponseEnum.DATA_NOT_FOUND);
        }
        if (entryOutDto.getQuantity() <= 0) {
            throw new BaseException(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        entryOutDto.setQuantity(Math.abs(entryOutDto.getQuantity()));
        SporadicEntryOutRecord record = new SporadicEntryOutRecord();
        BeanUtil.copyProperties(entryOutDto, record);
        record.setCreateUser(getLoginUserId());
        record.setType(CommonEnum.OperationType.ENTRY.code);
        int insert = sporadicEntryOutRecordMapper.insertSelective(record);
        if (insert > 0) {
            // 更新库存数据
            Float quantity = sporadicMaterial.getQuantity();
            SporadicMaterial updateSp = new SporadicMaterial();
            updateSp.setQuantity(entryOutDto.getQuantity() + quantity);
            updateSp.setId(sporadicId);
            sporadicMaterialMapper.updateByPrimaryKeySelective(updateSp);
        }
        return insert;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int out(SporadicEntryOutDto entryOutDto) {
        log.info("sporadic out param start,{}", entryOutDto.toString());
        Integer sporadicId = entryOutDto.getSporadicId();
        SporadicMaterial sporadicMaterial = sporadicMaterialMapper.selectByPrimaryKey(sporadicId);
        if (sporadicMaterial == null) {
            throw new BaseException(CommonEnum.ResponseEnum.DATA_NOT_FOUND);
        }
        if (entryOutDto.getQuantity() > sporadicMaterial.getQuantity()) {
            throw new BaseException(CommonEnum.ResponseEnum.MATERIAL_NOT_ENOUGH);
        }
        entryOutDto.setQuantity(Math.abs(entryOutDto.getQuantity()));
        SporadicEntryOutRecord record = new SporadicEntryOutRecord();
        BeanUtil.copyProperties(entryOutDto, record);
        record.setCreateUser(getLoginUserId());
        record.setType(CommonEnum.OperationType.OUT.code);
        int insert = sporadicEntryOutRecordMapper.insertSelective(record);
        if (insert > 0) {
            // 更新库存数据
            Float quantity = sporadicMaterial.getQuantity();
            SporadicMaterial updateSp = new SporadicMaterial();
            updateSp.setId(sporadicId);
            updateSp.setQuantity(quantity - entryOutDto.getQuantity());
            // 扣减的数量要小于等于库存数量
            SporadicMaterialExample example = new SporadicMaterialExample();
            SporadicMaterialExample.Criteria criteria = example.createCriteria();
            criteria.andIdEqualTo(sporadicId).andQuantityGreaterThanOrEqualTo(entryOutDto.getQuantity());
            sporadicMaterialMapper.updateByPrimaryKeySelective(updateSp);
        }
        return insert;
    }

    @Override
    public PageDTO<SporadicEntryOutRecordRespVo> entryOutPage(SporadicEntryOutPage pageDto) {
        SporadicEntryOutRecordExample example = new SporadicEntryOutRecordExample();
        SporadicEntryOutRecordExample.Criteria criteria = example.createCriteria();

        if (pageDto.getSporadicId() == null || pageDto.getSporadicId() <= 0) {
            throw new BaseException(CommonEnum.ResponseEnum.PARAM_ERROR);
        }

        example.setOrderByClause("id desc");
        Page<SporadicEntryOutRecordRespVo> sporadicMaterials = PageHelper.startPage(pageDto.getPageNum(), pageDto.getPageSize())
            .doSelectPage(() -> sporadicMaterialExtendMapper.pageRecord(pageDto));
        if (CollectionUtil.isEmpty(sporadicMaterials)) {
            return new PageDTO<>();
        }

        PageDTO<SporadicEntryOutRecordRespVo> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(sporadicMaterials, pageDTO);
        pageDTO.setList(sporadicMaterials.getResult());
        return pageDTO;
    }

}
