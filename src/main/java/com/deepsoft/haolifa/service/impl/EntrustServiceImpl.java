package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.EntrustMapper;
import com.deepsoft.haolifa.model.domain.Entrust;
import com.deepsoft.haolifa.model.domain.EntrustExample;
import com.deepsoft.haolifa.model.dto.EntrustDTO;
import com.deepsoft.haolifa.model.dto.EntrustListDTO;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.EntrustService;
import com.deepsoft.haolifa.util.RandomUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class EntrustServiceImpl extends BaseService implements EntrustService {

    @Autowired
    EntrustMapper entrustMapper;

    @Override
    public ResultBean save(EntrustDTO model) {
        String entrustNo = "en_" + RandomUtils.orderNoStr();
        Entrust entrust = new Entrust();
        BeanUtils.copyProperties(model, entrust);
        entrust.setCreateUserId(getLoginUserId());
        entrust.setEntrustNo(entrustNo);
        entrustMapper.insertSelective(entrust);
        Map<String,Object> result = new HashMap<>(8);
        result.put("formId",entrust.getId());
        result.put("formNo",entrust.getEntrustNo());
        result.put("formType",CommonEnum.FormType.ENTRUST_TYPE.code);
        return ResultBean.success(entrustNo);
    }

    @Override
    public ResultBean delete(String entrustNo) {
        Entrust entrust = new Entrust();
        entrust.setIsDelete(CommonEnum.Consts.YES.code);
        EntrustExample entrustExample = new EntrustExample();
        entrustExample.or().andEntrustNoEqualTo(entrustNo);
        entrustMapper.updateByExampleSelective(entrust, entrustExample);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean update(String entrustNo,EntrustDTO model) {
        Entrust entrust = new Entrust();
        BeanUtils.copyProperties(model, entrust);
        EntrustExample entrustExample = new EntrustExample();
        entrustExample.or().andEntrustNoEqualTo(entrustNo);
        entrustMapper.updateByExampleSelective(entrust, entrustExample);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean getInfo(String entrustNo) {
        EntrustExample entrustExample = new EntrustExample();
        entrustExample.or().andEntrustNoEqualTo(entrustNo);
        List<Entrust> entrustList = entrustMapper.selectByExample(entrustExample);
        if (entrustList == null || entrustList.size() == 0) {
            return ResultBean.success(new HashMap<>());
        }
        return ResultBean.success(entrustList.get(0));
    }

    @Override
    public ResultBean getList(EntrustListDTO model) {
        if (model.getPageNum() == null || model.getPageNum() == 0) {
            model.setPageNum(1);
        }
        if (model.getPageSize() == null || model.getPageSize() == 0) {
            model.setPageSize(10);
        }
        EntrustExample entrustExample = new EntrustExample();
        EntrustExample.Criteria criteria = entrustExample.createCriteria();
        if (StringUtils.isNotEmpty(model.getEntrustNo())) {
            criteria.andEntrustNoLike("%" + model.getEntrustNo() + "%");
        }
        if (null != model.getStatus()) {
            criteria.andStatusEqualTo(model.getStatus().byteValue());
        }
        Page<Entrust> pageData = PageHelper.startPage(model.getPageNum(), model.getPageSize()).doSelectPage(() ->
                entrustMapper.selectByExample(entrustExample));
        PageDTO<Entrust> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);
        pageDTO.setList(pageData.getResult());
        return ResultBean.success(pageDTO);
    }

    @Override
    public ResultBean updateStatus(String entrustNo, Integer status) {
        if (StringUtils.isEmpty(entrustNo) || status == null) {
            return ResultBean.success(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        Entrust entrust = new Entrust();
        entrust.setStatus(status.byteValue());
        EntrustExample entrustExample = new EntrustExample();
        entrustExample.or().andEntrustNoEqualTo(entrustNo);
        entrustMapper.updateByExampleSelective(entrust, entrustExample);
        return ResultBean.success(1);
    }
}
