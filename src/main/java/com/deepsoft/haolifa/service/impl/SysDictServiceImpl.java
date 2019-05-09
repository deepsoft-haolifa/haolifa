package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.SysDictMapper;
import com.deepsoft.haolifa.model.domain.SysDict;
import com.deepsoft.haolifa.model.domain.SysDictExample;
import com.deepsoft.haolifa.service.SysDictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysDictServiceImpl implements SysDictService {

    @Resource
    private SysDictMapper sysDictMapper;

    @Override
    public List<SysDict> getSysDictByTypeCode(String typeCode) {
        SysDictExample example = new SysDictExample();
        example.or().andTypeCodeEqualTo(typeCode);
        return sysDictMapper.selectByExample(example);
    }
}
