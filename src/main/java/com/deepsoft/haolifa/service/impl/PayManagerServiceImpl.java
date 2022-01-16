package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.PayManagerCalMapper;
import com.deepsoft.haolifa.model.domain.PayManagerCal;
import com.deepsoft.haolifa.model.domain.PayManagerCalExample;
import com.deepsoft.haolifa.model.dto.PayManagerCalDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.PayManagerCalService;
import com.github.pagehelper.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PayManagerServiceImpl extends BaseService implements PayManagerCalService {

    @Resource
    private PayManagerCalMapper payManagerCalMapper;
    @Override
    public PayManagerCal getInfo(PayManagerCalDTO payManagerCalDTO) {
        PayManagerCalExample example  = new PayManagerCalExample();
        PayManagerCalExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(payManagerCalDTO.getPostName())) {
            criteria.andPostNameEqualTo(payManagerCalDTO.getPostName());
        }
        if (StringUtils.isNotEmpty(payManagerCalDTO.getAppModel())) {
            criteria.andAppModelEqualTo(payManagerCalDTO.getAppModel());
        }
        if (StringUtils.isNotEmpty(payManagerCalDTO.getAppSpecifications())) {
            criteria.andAppSpecificationsEqualTo(payManagerCalDTO.getAppSpecifications());
        }
        List<PayManagerCal> payManagerCals = payManagerCalMapper.selectByExample(example);
        return CollectionUtils.isEmpty(payManagerCals) ? null : payManagerCals.get(0);
    }
}
