package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.PayOrderUserRelationProcedureMapper;
import com.deepsoft.haolifa.model.domain.PayOrderUserRelationProcedure;
import com.deepsoft.haolifa.model.domain.PayOrderUserRelationProcedureExample;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.PayOrderUserRelationProcedureService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author liuyaofei
 * @Date create in 下午4:51 2021/9/11
 * @description 订单人员工序关联表
 */
@Service
public class PayOrderUserRelationProcedureServiceImpl extends BaseService implements PayOrderUserRelationProcedureService {
    @Resource
    private PayOrderUserRelationProcedureMapper payOrderUserRelationProcedureMapper;

    @Override
    public List<PayOrderUserRelationProcedure> getPayOrderUserRelationProcedureList() {
        List<PayOrderUserRelationProcedure> payOrderUserRelationProcedures = payOrderUserRelationProcedureMapper.selectByExample(new PayOrderUserRelationProcedureExample());
        return payOrderUserRelationProcedures;
    }
}
