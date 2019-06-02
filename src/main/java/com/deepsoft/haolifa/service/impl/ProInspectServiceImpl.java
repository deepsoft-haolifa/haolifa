package com.deepsoft.haolifa.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.constant.CommonEnum.ResponseEnum;
import com.deepsoft.haolifa.dao.repository.ProInspectRecordMapper;
import com.deepsoft.haolifa.dao.repository.ProInspectResultMapper;
import com.deepsoft.haolifa.dao.repository.ProInspectUnqualifiedMapper;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.proInspect.ProInspectConditionDTO;
import com.deepsoft.haolifa.model.dto.proInspect.ProInspectRecordDTO;
import com.deepsoft.haolifa.model.dto.proInspect.ProInspectResDTO;
import com.deepsoft.haolifa.model.dto.proInspect.ProInspectUnqualifiedDTO;
import com.deepsoft.haolifa.service.ProInspectResultService;
import com.deepsoft.haolifa.service.ProInspectService;
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

@Slf4j
@Service
public class ProInspectServiceImpl extends BaseService implements ProInspectService {

    @Autowired
    private ProInspectRecordMapper proInspectRecordMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultBean save(ProInspectRecordDTO model) {
        if(model.getTestingNumber() == 0) {
            return ResultBean.error(ResponseEnum.INSPECT_TESTNUMBER_IS_ZERO);
        }
        ProInspectRecord proInspectRecord = new ProInspectRecord();
        BeanUtils.copyProperties(model, proInspectRecord);
        proInspectRecord.setCreateUserId(getLoginUserId());
        proInspectRecord.setStorageStatus((byte) 1);
        int insert = proInspectRecordMapper.insertSelective(proInspectRecord);
        return ResultBean.success(insert);
    }

    @Override
    public ResultBean update(ProInspectRecordDTO model) {
        ProInspectRecord proInspectRecord = new ProInspectRecord();
        BeanUtils.copyProperties(model, proInspectRecord);
        int update = proInspectRecordMapper.updateByPrimaryKeySelective(proInspectRecord);
        return ResultBean.success(update);    }

    @Override
    public ResultBean delete(Integer id) {
        return ResultBean.success(proInspectRecordMapper.deleteByPrimaryKey(id));
    }

    @Override
    public ResultBean pageInfo(ProInspectConditionDTO model) {
        ProInspectRecordExample example = new ProInspectRecordExample();
        ProInspectRecordExample.Criteria criteria = example.createCriteria();
        if (model.getStorageStatus()!=null&&model.getStorageStatus() > 0) {
            criteria.andStorageStatusEqualTo(model.getStorageStatus());
        }
        if (StringUtils.isNotBlank(model.getOrderNo())) {
            criteria.andOrderNoLike("%" + model.getOrderNo() + "%");
        }
        example.setOrderByClause("id desc");
        Page<ProInspectRecord> pageData = PageHelper.startPage(model.getPageNum(), model.getPageSize()).doSelectPage(() -> {
            proInspectRecordMapper.selectByExample(example);
        });
        PageDTO<ProInspectRecord> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);
        pageDTO.setList(pageData.getResult());
        return ResultBean.success(pageDTO);
    }

    @Override
    public int updateStorageStatus(int id, Byte storageStatus) {
        return proInspectRecordMapper.updateByPrimaryKeySelective(new ProInspectRecord() {{
            setStorageStatus(storageStatus);
            setId(id);
        }});
    }
}
