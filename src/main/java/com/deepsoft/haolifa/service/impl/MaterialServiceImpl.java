package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.MaterialClassifyMapper;
import com.deepsoft.haolifa.dao.repository.MaterialMapper;
import com.deepsoft.haolifa.dao.repository.extend.MaterialExtendMapper;
import com.deepsoft.haolifa.model.domain.Material;
import com.deepsoft.haolifa.model.domain.MaterialClassify;
import com.deepsoft.haolifa.model.domain.MaterialClassifyExample;
import com.deepsoft.haolifa.model.domain.MaterialExample;
import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.service.MaterialService;
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

@Service
@Slf4j
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialClassifyMapper materialClassifyMapper;

    @Autowired
    private MaterialMapper materialMapper;

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private MaterialExtendMapper materialExtendMapper;


    @Override
    public ResultBean saveClassify(MaterialClassifyRequestDTO model) {
        if (StringUtils.isBlank(model.getClassifyName())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        CustomUser customUser = sysUserService.selectLoginUser();
        int createUser = customUser != null ? customUser.getId() : 1;
        MaterialClassify materialClassify = new MaterialClassify();
        materialClassify.setCreateUser(createUser);
        materialClassify.setClassifyName(model.getClassifyName());
        materialClassify.setRemark(model.getRemark());
        int insert = materialClassifyMapper.insertSelective(materialClassify);
        return ResultBean.success(insert);
    }

    @Override
    public ResultBean updateClassify(MaterialClassifyRequestDTO model) {
        if (model.getId() == 0 || StringUtils.isBlank(model.getClassifyName())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        MaterialClassify materialClassify = new MaterialClassify();
        CustomUser customUser = sysUserService.selectLoginUser();
        int updateUser = customUser != null ? customUser.getId() : 1;
        materialClassify.setUpdateUser(updateUser);
        materialClassify.setUpdateTime(new Date());
        materialClassify.setId(model.getId());
        materialClassify.setRemark(model.getRemark());
        materialClassify.setClassifyName(model.getClassifyName());
        int update = materialClassifyMapper.updateByPrimaryKeySelective(materialClassify);
        return ResultBean.success(update);
    }

    @Override
    public ResultBean deleteClassify(int id) {
        if (id == 0) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        MaterialClassify record = new MaterialClassify() {{
            setId(id);
            setIsDelete(CommonEnum.Consts.YES.code);
        }};
        int update = materialClassifyMapper.updateByPrimaryKeySelective(record);
        return ResultBean.success(update);
    }

    @Override
    public List<MaterialClassify> listClassify() {
        MaterialClassifyExample example = new MaterialClassifyExample();
        example.or().andIsDeleteEqualTo(CommonEnum.Consts.NO.code);
        List<MaterialClassify> materialClassifies = materialClassifyMapper.selectByExample(example);
        return materialClassifies;
    }

    @Override
    public ResultBean pageInfoClassify(Integer currentPage, Integer pageSize, String classifyNameLike) {
        currentPage = currentPage == null ? 1 : currentPage;
        pageSize = pageSize == null ? 20 : pageSize;

        MaterialClassifyExample example = new MaterialClassifyExample();
        MaterialClassifyExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(classifyNameLike)) {
            criteria.andClassifyNameLike("%" + classifyNameLike + "%");
        }
        example.setOrderByClause("create_time desc");
        Page<MaterialClassify> materialClassifies = PageHelper.startPage(currentPage, pageSize)
                .doSelectPage(() -> materialClassifyMapper.selectByExample(example));

        PageDTO<MaterialClassify> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(materialClassifies, pageDTO);
        pageDTO.setList(materialClassifies);
        return ResultBean.success(pageDTO);
    }

    @Override
    public ResultBean save(MaterialRequestDTO model) {
        CustomUser customUser = sysUserService.selectLoginUser();
        int createUser = customUser != null ? customUser.getId() : 1;
        Material record = new Material();
        BeanUtils.copyProperties(model, record);
        record.setCreateUser(createUser);
        int insert = materialMapper.insertSelective(record);
        return ResultBean.success(insert);
    }

    @Override
    public ResultBean update(MaterialRequestDTO model) {
        Material record = new Material();
        CustomUser customUser = sysUserService.selectLoginUser();
        int updateUser = customUser != null ? customUser.getId() : 1;
        record.setUpdateUser(updateUser);
        record.setUpdateTime(new Date());
        BeanUtils.copyProperties(model, record);
        int update = materialMapper.updateByPrimaryKeySelective(record);
        return ResultBean.success(update);
    }

    @Override
    public ResultBean delete(int id) {
        if (id == 0) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        Material record = new Material() {{
            setId(id);
            setIsDelete(CommonEnum.Consts.YES.code);
        }};
        int update = materialMapper.updateByPrimaryKeySelective(record);
        return ResultBean.success(update);
    }

    @Override
    public Material getInfoByGraphNo(String graphNo) {
        MaterialExample example = new MaterialExample();
        example.or().andGraphNoEqualTo(graphNo);
        List<Material> materials = materialMapper.selectByExample(example);
        if (materials.size() > 0) {
            return materials.get(0);
        }
        return null;
    }

    @Override
    public Material getInfoById(int id) {
        return materialMapper.selectByPrimaryKey(id);
    }

    @Override
    public ResultBean pageInfo(Integer currentPage, Integer pageSize, String classifyNameLike, String nameLike, String graphNoLike, int status) {
        currentPage = currentPage == null ? 1 : currentPage;
        pageSize = pageSize == null ? 20 : pageSize;

        MaterialExample example = new MaterialExample();
        MaterialExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(classifyNameLike)) {
            criteria.andMaterialClassifyNameLike("%" + classifyNameLike + "%");
        }
        if (StringUtils.isNotBlank(nameLike)) {
            criteria.andNameLike("%" + nameLike + "%");
        }
        if (StringUtils.isNotBlank(graphNoLike)) {
            criteria.andGraphNoLike("%" + graphNoLike + "%");
        }
        // 告警状态1（库存数量<预警值）
        if (status == 1) {
            criteria.andCurrentQuantityLessThan("safe_quantity");
        }
        // 正常状态2（库存数量>预警值）
        if (status == 2) {
            criteria.andCurrentQuantityGreaterThanOrEqualTo("safe_quantity");
        }
        criteria.andIsDeleteEqualTo(CommonEnum.Consts.NO.code);
        example.setOrderByClause("create_time desc");
        Page<Material> materials = PageHelper.startPage(currentPage, pageSize)
                .doSelectPage(() -> materialMapper.selectByExample(example));

        PageDTO<Material> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(materials, pageDTO);
        pageDTO.setList(materials);
        return ResultBean.success(pageDTO);
    }

    @Override
    public int updateCurrentQuantity(String graphNo, int quantity) {
        log.info("update current quantity start,graphNo:{},quantity:{}", graphNo, quantity);
        return materialExtendMapper.updateCurrentQuantity(graphNo, quantity);
    }

}
