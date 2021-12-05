package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.PayManagerCalMapper;
import com.deepsoft.haolifa.model.domain.PayManagerCal;
import com.deepsoft.haolifa.model.domain.PayManagerCalExample;
import com.deepsoft.haolifa.model.dto.PayManagerCalDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.PayManagerCalService;
import lombok.extern.slf4j.Slf4j;
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
        example.createCriteria().andPostNameEqualTo(payManagerCalDTO.getPostName())
            .andAppModelEqualTo(payManagerCalDTO.getAppModel())
            .andAppSpecificationsEqualTo(payManagerCalDTO.getAppSpecifications())
            .andWorkTypeEqualTo(payManagerCalDTO.getWorkType());
        List<PayManagerCal> payManagerCals = payManagerCalMapper.selectByExample(example);
        return CollectionUtils.isEmpty(payManagerCals) ? new PayManagerCal() : payManagerCals.get(0);
    }
}
