package com.deepsoft.haolifa.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.BizSubjectsMapper;
import com.deepsoft.haolifa.enums.DictEnum;
import com.deepsoft.haolifa.model.domain.BizSubjects;
import com.deepsoft.haolifa.model.domain.BizSubjectsExample;
import com.deepsoft.haolifa.model.domain.SysDict;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.subjects.BizSubjectsAddDTO;
import com.deepsoft.haolifa.model.dto.finance.subjects.BizSubjectsRQDTO;
import com.deepsoft.haolifa.model.dto.finance.subjects.BizSubjectsRSDTO;
import com.deepsoft.haolifa.service.SubjectService;
import com.deepsoft.haolifa.service.SysDictService;
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
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SubjectsServiceImpl implements SubjectService {

    @Autowired
    private BizSubjectsMapper subjectsMapper;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysDictService sysDictService;

    @Override
    public ResultBean save(BizSubjectsAddDTO model) {
        log.info("BizSubjects saveInfo start|{}", JSONObject.toJSON(model));
        if (StringUtils.isAnyBlank()) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        BizSubjects bizSubjects = new BizSubjects();
        BeanUtils.copyProperties(model, bizSubjects);
        bizSubjects.setCreateTime(new Date());
        bizSubjects.setUpdateTime(new Date());
        bizSubjects.setCreateUser(sysUserService.selectLoginUser().getId());
        bizSubjects.setUpdateUser(sysUserService.selectLoginUser().getId());
        int insertId = subjectsMapper.insertSelective(bizSubjects);
        return ResultBean.success(insertId);
    }

    @Override
    public ResultBean delete(Integer id) {
        int delete = subjectsMapper.deleteByPrimaryKey(id);
        return ResultBean.success(delete);
    }

    @Override
    public ResultBean update(BizSubjects bizSubjects) {
        bizSubjects.setUpdateTime(new Date());
        bizSubjects.setUpdateUser(sysUserService.selectLoginUser().getId());
        int update = subjectsMapper.updateByPrimaryKeySelective(bizSubjects);
        return ResultBean.success(update);
    }

    @Override
    public ResultBean getInfo(Integer id) {
        BizSubjects bizSubjects = subjectsMapper.selectByPrimaryKey(id);
        return ResultBean.success(bizSubjects);
    }

    @Override
    public ResultBean<PageDTO<BizSubjectsRSDTO>> getList(BizSubjectsRQDTO model) {
        if (model.getPageNum() == null || model.getPageNum() == 0) {
            model.setPageNum(1);
        }
        if (model.getPageSize() == null || model.getPageSize() == 0) {
            model.setPageSize(10);
        }
        BizSubjectsExample bizSubjectsExample = new BizSubjectsExample();
        BizSubjectsExample.Criteria criteria = bizSubjectsExample.createCriteria();
        if (StringUtils.isNotEmpty(model.getType()) ) {
            criteria.andTypeEqualTo(model.getType());
        }

        bizSubjectsExample.setOrderByClause("id desc");
        Page<BizSubjects> pageData = PageHelper.startPage(model.getPageNum(), model.getPageSize()).doSelectPage(() -> {
            subjectsMapper.selectByExample(bizSubjectsExample);
        });

        Map<String, String> dictMap = sysDictService.getSysDictByTypeCode(DictEnum.SUBJECTS_TYPE.getCode()).stream()
            .collect(Collectors.toMap(SysDict::getCode, SysDict::getName, (a, b) -> a));

        PageDTO<BizSubjectsRSDTO> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);
        List<BizSubjectsRSDTO> bizSubjectsRSDTOList = pageData.getResult().stream()
            .map(subject -> {
                BizSubjectsRSDTO bizSubjectsRSDTO = new BizSubjectsRSDTO();
                BeanUtils.copyProperties(subject, bizSubjectsRSDTO);
                bizSubjectsRSDTO.setTypeCN(dictMap.get(subject.getType()));
                return bizSubjectsRSDTO;
            })
            .collect(Collectors.toList());

        pageDTO.setList(bizSubjectsRSDTOList);
        return ResultBean.success(pageDTO);
    }

    @Override
    public ResultBean<List<BizSubjectsRSDTO>> getSubjectsListAll() {
        BizSubjectsExample bizSubjectsExample = new BizSubjectsExample();
        bizSubjectsExample.setOrderByClause("id desc");
        List<BizSubjects> bizSubjects = subjectsMapper.selectByExample(bizSubjectsExample);

        Map<String, String> dictMap = sysDictService.getSysDictByTypeCode(DictEnum.SUBJECTS_TYPE.getCode()).stream()
            .collect(Collectors.toMap(SysDict::getCode, SysDict::getName, (a, b) -> a));

        List<BizSubjectsRSDTO> bizSubjectsRSDTOList = bizSubjects.stream().map(c -> {
            BizSubjectsRSDTO subjectsRSDTO = new BizSubjectsRSDTO();
            BeanUtils.copyProperties(c, subjectsRSDTO);
            subjectsRSDTO.setTypeCN(dictMap.get(c.getType()));
            return subjectsRSDTO;
        }).collect(Collectors.toList());
        return ResultBean.success(bizSubjectsRSDTOList);
    }
}
