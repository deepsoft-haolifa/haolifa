package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.MaterialClassifyMapper;
import com.deepsoft.haolifa.model.domain.MaterialClassify;
import com.deepsoft.haolifa.model.domain.MaterialClassifyExample;
import com.deepsoft.haolifa.model.dto.CustomUser;
import com.deepsoft.haolifa.model.dto.MaterialClassifyRequestDTO;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
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
    private SysUserService sysUserService;

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
    public ResultBean updateClassify(int id, String classifyName) {
        if (id == 0 || StringUtils.isBlank(classifyName)) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        MaterialClassify materialClassify = new MaterialClassify();
        CustomUser customUser = sysUserService.selectLoginUser();
        int updateUser = customUser != null ? customUser.getId() : 1;
        materialClassify.setUpdateUser(updateUser);
        materialClassify.setUpdateTime(new Date());
        materialClassify.setClassifyName(classifyName);
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
        Page<MaterialClassify> materialClassifies = PageHelper.startPage(currentPage, pageSize)
                .doSelectPage(() -> materialClassifyMapper.selectByExample(example));

        PageDTO<MaterialClassify> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(materialClassifies, pageDTO);
        pageDTO.setList(materialClassifies);
        return ResultBean.success(pageDTO);
    }

}
