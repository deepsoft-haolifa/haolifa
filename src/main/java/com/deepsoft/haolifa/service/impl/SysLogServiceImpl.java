package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.SysLoginLogMapper;
import com.deepsoft.haolifa.model.domain.SysLoginLog;
import com.deepsoft.haolifa.model.domain.SysLoginLogExample;
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
    private SysLoginLogMapper sysLoginLogMapper;

    @Override
    public void saveLogin(SysLoginLog sysLog) {
        sysLoginLogMapper.insertSelective(sysLog);
    }

    @Override
    public PageDTO<SysLoginLog> pageLoginList(SysLogConditionDTO sysLogConditionDTO) {
        SysLoginLogExample example = new SysLoginLogExample();
        SysLoginLogExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(sysLogConditionDTO.getRealName())) {
            criteria.andRealNameLike("%" + sysLogConditionDTO.getRealName() + "%");
        }

        example.setOrderByClause("id desc");
        Page<SysLoginLog> logs = PageHelper.startPage(sysLogConditionDTO.getPageNum(), sysLogConditionDTO.getPageSize())
                .doSelectPage(() -> sysLoginLogMapper.selectByExample(example));
        PageDTO<SysLoginLog> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(logs, pageDTO);
        pageDTO.setList(logs);
        return pageDTO;
    }
}
