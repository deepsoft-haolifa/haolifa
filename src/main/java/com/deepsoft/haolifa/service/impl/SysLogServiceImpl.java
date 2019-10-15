package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.SysLogMapper;
import com.deepsoft.haolifa.model.domain.SysLog;
import com.deepsoft.haolifa.model.domain.SysLogExample;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.SysLogConditionDTO;
import com.deepsoft.haolifa.service.SysLogService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysLogServiceImpl implements SysLogService {

    @Resource
    private SysLogMapper sysLogMapper;

    @Override
    public void save(SysLog sysLog) {
        sysLogMapper.insertSelective(sysLog);
    }

    @Override
    public PageDTO<SysLog> pageList(SysLogConditionDTO sysLogConditionDTO) {
        SysLogExample example = new SysLogExample();
        SysLogExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(sysLogConditionDTO.getRealName())) {
            criteria.andRealNameLike("%" + sysLogConditionDTO.getRealName() + "%");
        }

        if (sysLogConditionDTO.getType() != null && sysLogConditionDTO.getType() > 0) {
            criteria.andTypeEqualTo(sysLogConditionDTO.getType());
        }
        example.setOrderByClause("id desc");
        Page<SysLog> logs = PageHelper.startPage(sysLogConditionDTO.getPageNum(), sysLogConditionDTO.getPageSize())
                .doSelectPage(() -> sysLogMapper.selectByExample(example));

        PageDTO<SysLog> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(logs, pageDTO);
        pageDTO.setList(logs);
        return pageDTO;
    }
}
