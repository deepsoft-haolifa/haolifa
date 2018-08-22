package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.MaterialInspectResultMapper;
import com.deepsoft.haolifa.dao.repository.ProInspectResultMapper;
import com.deepsoft.haolifa.model.domain.MaterialInspectResult;
import com.deepsoft.haolifa.model.domain.MaterialInspectResultExample;
import com.deepsoft.haolifa.model.dto.MaterialInspectResDTO;
import com.deepsoft.haolifa.model.dto.MaterialInspectResListDTO;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.MaterialInspectResultService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MaterialInspectResultServiceImpl extends BaseService implements MaterialInspectResultService {

    @Autowired
    MaterialInspectResultMapper materialInspectResultMapper;

    @Override
    public ResultBean save(MaterialInspectResDTO model) {
        MaterialInspectResult materialInspectResult = new MaterialInspectResult();
        BeanUtils.copyProperties(model, materialInspectResult);
        materialInspectResult.setCreateUserId(getLoginUserId());
        int insert = materialInspectResultMapper.insertSelective(materialInspectResult);
        return ResultBean.success(insert);
    }

    @Override
    public ResultBean delete(Integer id) {
        MaterialInspectResult materialInspectResult = new MaterialInspectResult();
        materialInspectResult.setIsDelete(CommonEnum.Consts.YES.code);
        materialInspectResult.setId(id);
        int delete = materialInspectResultMapper.updateByPrimaryKey(materialInspectResult);
        return ResultBean.success(delete);
    }

    @Override
    public ResultBean update(MaterialInspectResDTO model) {
        MaterialInspectResult materialInspectResult = new MaterialInspectResult();
        BeanUtils.copyProperties(model, materialInspectResult);
        int update = materialInspectResultMapper.updateByPrimaryKey(materialInspectResult);
        return ResultBean.success(update);
    }

    @Override
    public ResultBean getInfo(String inspectNo) {
        if(StringUtils.isEmpty(inspectNo)) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        MaterialInspectResultExample materialInspectResultExample= new MaterialInspectResultExample();
        materialInspectResultExample.or().andInspectNoEqualTo(inspectNo);
        List<MaterialInspectResult> materialInspectResultList = materialInspectResultMapper.selectByExample(materialInspectResultExample);
        if(materialInspectResultList == null || materialInspectResultList.size() == 0) {
            return ResultBean.error(CommonEnum.ResponseEnum.RESOURCE_NOT_EXIST);
        }
        return ResultBean.success(materialInspectResultList.get(0));
    }

    @Override
    public ResultBean getList(MaterialInspectResListDTO model) {
        if(model.getPageNum() == null || model.getPageNum() == 0 ) {
            model.setPageNum(1);
        }
        if(model.getPageSize() == null || model.getPageSize() == 0) {
            model.setPageSize(10);
        }
        MaterialInspectResultExample example = new MaterialInspectResultExample();
        if (!StringUtils.isEmpty(model.getInspectNo())) {
            example.or().andInspectNoLike("%" + model.getInspectNo() + "%");
        }
        Page<MaterialInspectResult> pageData = PageHelper.startPage(model.getPageNum(), model.getPageSize()).doSelectPage(() -> {
            materialInspectResultMapper.selectByExample(example);
        });
        PageDTO<MaterialInspectResult> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData,pageDTO);
        pageDTO.setList(pageData.getResult());
        return ResultBean.success(pageDTO);
    }
}
