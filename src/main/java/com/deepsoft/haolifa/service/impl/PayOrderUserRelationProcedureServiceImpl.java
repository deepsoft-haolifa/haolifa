package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.PayOrderUserRelationProcedureMapper;
import com.deepsoft.haolifa.dao.repository.PayWorkingProcedureMapper;
import com.deepsoft.haolifa.model.domain.PayOrderUserRelationProcedure;
import com.deepsoft.haolifa.model.domain.PayOrderUserRelationProcedureExample;
import com.deepsoft.haolifa.model.domain.PayWorkingProcedure;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayOrderUserRelationProcedureDTO;
import com.deepsoft.haolifa.model.vo.pay.PayOrderUserRelationProcedureVO;
import com.deepsoft.haolifa.service.OrderProductService;
import com.deepsoft.haolifa.service.PayOrderUserRelationProcedureService;
import com.deepsoft.haolifa.service.SprayService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
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
    @Resource
    private PayWorkingProcedureMapper payWorkingProcedureMapper;
    @Resource
    private OrderProductService orderProductService;
    @Resource
    private SprayService sprayService;
    @Override
    public List<PayOrderUserRelationProcedure> getPayOrderUserRelationProcedureList() {
        List<PayOrderUserRelationProcedure> payOrderUserRelationProcedures = payOrderUserRelationProcedureMapper.selectByExample(new PayOrderUserRelationProcedureExample());
        return payOrderUserRelationProcedures;
    }

    @Override
    public ResultBean insertSelective(PayOrderUserRelationProcedureVO procedureVO) {
        List<PayOrderUserRelationProcedureDTO> payOrderUserRelationProcedureList = procedureVO.getPayOrderUserRelationProcedureList();
        if (CollectionUtils.isEmpty(payOrderUserRelationProcedureList)) {
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL, "传的数据为空");
        }
        for (PayOrderUserRelationProcedureDTO payOrderUserRelationProcedureDTO : payOrderUserRelationProcedureList) {
            PayOrderUserRelationProcedure procedure = new PayOrderUserRelationProcedure();
            BeanUtils.copyProperties(payOrderUserRelationProcedureDTO, procedure);
            PayWorkingProcedure payWorkingProcedure = payWorkingProcedureMapper.selectByPrimaryKey(procedure.getId());
            String workshopName = payWorkingProcedure.getWorkshopName();
            if (CommonEnum.WorkShopTypeEnum.PRODUCT.name.equals(workshopName)) {
                orderProductService.updateOrderTaskStatus(procedure.getOrderId(), 1);
            } else if (CommonEnum.WorkShopTypeEnum.SPRAY.name.equals(workshopName)) {
                sprayService.updateTaskStatus(procedure.getOrderId(), 1);
            }
            procedure.setProcedureId(payOrderUserRelationProcedureDTO.getId());
            procedure.setCreateUser(getLoginUserName());
            procedure.setUpdateUser(getLoginUserName());
            procedure.setCreateTime(new Date());
            procedure.setUpdateTime(new Date());
            payOrderUserRelationProcedureMapper.insertSelective(procedure);
        }
        return ResultBean.success(1);

    }
}
