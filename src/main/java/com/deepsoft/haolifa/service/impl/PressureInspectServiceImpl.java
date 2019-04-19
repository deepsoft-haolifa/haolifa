package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.PressureInspectRecordMapper;
import com.deepsoft.haolifa.model.domain.PressureInspectRecord;
import com.deepsoft.haolifa.model.domain.PressureInspectRecordExample;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pressureInspect.PressureInspectConditionDTO;
import com.deepsoft.haolifa.model.dto.pressureInspect.PressureInspectRecordDTO;
import com.deepsoft.haolifa.service.PressureInspectService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class PressureInspectServiceImpl extends BaseService implements PressureInspectService {

    @Autowired
    private PressureInspectRecordMapper pressureInspectRecordMapper;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultBean save(PressureInspectRecordDTO model) {
        PressureInspectRecord pressureInspectRecord = new PressureInspectRecord();
        BeanUtils.copyProperties(model, pressureInspectRecord);
        pressureInspectRecord.setCreateUserId(getLoginUserId());
        int insert = pressureInspectRecordMapper.insertSelective(pressureInspectRecord);
        return ResultBean.success(insert);
    }

    @Override
    public ResultBean update(PressureInspectRecordDTO model) {
        PressureInspectRecord pressureInspectRecord = new PressureInspectRecord();
        BeanUtils.copyProperties(model, pressureInspectRecord);
        int update = pressureInspectRecordMapper.updateByPrimaryKeySelective(pressureInspectRecord);
        return ResultBean.success(update);
    }

    @Override
    public ResultBean delete(Integer id) {
        return ResultBean.success(pressureInspectRecordMapper.deleteByPrimaryKey(id));
    }

    @Override
    public ResultBean pageInfo(PressureInspectConditionDTO model) {
        PressureInspectRecordExample example = new PressureInspectRecordExample();
        PressureInspectRecordExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(model.getOrderNo())) {
            criteria.andOrderNoLike("%" + model.getOrderNo() + "%");
        }
        example.setOrderByClause("id desc");
        Page<PressureInspectRecord> pageData = PageHelper.startPage(model.getPageNum(), model.getPageSize()).doSelectPage(() -> {
            pressureInspectRecordMapper.selectByExample(example);
        });
        PageDTO<PressureInspectRecord> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);
        pageDTO.setList(pageData.getResult());
        return ResultBean.success(pageDTO);
    }
}
