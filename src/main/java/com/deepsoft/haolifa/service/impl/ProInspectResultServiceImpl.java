package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.ProInspectResultMapper;
import com.deepsoft.haolifa.model.domain.ProInspectResult;
import com.deepsoft.haolifa.model.domain.ProInspectResultExample;
import com.deepsoft.haolifa.model.dto.MaterialInspectResListDTO;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ProInspectResDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.ProInspectResultService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProInspectResultServiceImpl extends BaseService implements ProInspectResultService {

    @Autowired
    private ProInspectResultMapper proInspectResultMapper;

    @Override
    public ResultBean save(ProInspectResDTO model) {
        ProInspectResult proInspectResult = new ProInspectResult();
        BeanUtils.copyProperties(model, proInspectResult);
        proInspectResult.setCreateUserId(getLoginUserId());
        int insert = proInspectResultMapper.insertSelective(proInspectResult);
        // 看接口入参怎么设计
        return ResultBean.success(insert);
    }

    @Override
    public ResultBean delete(Integer id) {
        return ResultBean.success(proInspectResultMapper.deleteByPrimaryKey(id));
    }

    @Override
    public ResultBean update(ProInspectResDTO model) {
        ProInspectResult proInspectResult = new ProInspectResult();
        BeanUtils.copyProperties(model, proInspectResult);
        int update = proInspectResultMapper.updateByPrimaryKeySelective(proInspectResult);
        return ResultBean.success(update);
    }

    @Override
    public ResultBean getInfo(String inspectNo) {
        ProInspectResultExample proInspectResultExample = new ProInspectResultExample();
        proInspectResultExample.or().andInspectNoEqualTo(inspectNo);
        List<ProInspectResult> proInspectResultList = proInspectResultMapper.selectByExample(proInspectResultExample);
        if (proInspectResultList == null || proInspectResultList.size() == 0) {
            return ResultBean.error(CommonEnum.ResponseEnum.RESOURCE_NOT_EXIST);
        }
        return ResultBean.success(proInspectResultList.get(0));
    }

    @Override
    public ResultBean getList(MaterialInspectResListDTO model) {
        if (model.getPageNum() == null || model.getPageNum() == 0) {
            model.setPageNum(1);
        }
        if (model.getPageSize() == null || model.getPageSize() == 0) {
            model.setPageSize(10);
        }
        ProInspectResultExample example = new ProInspectResultExample();
        if (!StringUtils.isNotEmpty(model.getInspectNo())) {
            example.or().andInspectNoLike("%" + model.getInspectNo() + "%");
        }
        Page<ProInspectResult> pageData = PageHelper.startPage(model.getPageNum(), model.getPageSize()).doSelectPage(() -> {
            proInspectResultMapper.selectByExample(example);
        });
        PageDTO<ProInspectResult> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);
        pageDTO.setList(pageData.getResult());
        return ResultBean.success(pageDTO);
    }
}
