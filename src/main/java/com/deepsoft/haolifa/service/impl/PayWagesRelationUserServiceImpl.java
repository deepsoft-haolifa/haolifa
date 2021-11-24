package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.PayWagesRelationUserMapper;
import com.deepsoft.haolifa.model.domain.PayWagesRelationUser;
import com.deepsoft.haolifa.model.domain.PayWagesRelationUserExample;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.PayWagesRelationUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @Author liuyaofei
 * @Date create in 下午4:51 2021/9/11
 * @description 人员工资关联关系
 */
@Service
public class PayWagesRelationUserServiceImpl extends BaseService implements PayWagesRelationUserService {
    @Resource
    private PayWagesRelationUserMapper payWagesRelationUserMapper;

    @Override
    public List<PayWagesRelationUser> getList(PayWagesRelationUser model) {
        PayWagesRelationUserExample example = new PayWagesRelationUserExample();
        PayWagesRelationUserExample.Criteria criteria = example.createCriteria();
        if (Objects.nonNull(model.getUserId())) {
            criteria.andUserIdEqualTo(model.getUserId());
        }
        if (Objects.nonNull(model.getWagesId())) {
            criteria.andWagesIdEqualTo(model.getWagesId());
        }
        List<PayWagesRelationUser> payWagesRelationUsers = payWagesRelationUserMapper.selectByExample(example);
        return payWagesRelationUsers;
    }

    @Override
    public ResultBean save(PayWagesRelationUser payUser) {
        payUser.setCreateTime(new Date());
        payUser.setUpdateTime(new Date());
        payUser.setCreateUser(getLoginUserName());
        payUser.setUpdateUser(getLoginUserName());
        payWagesRelationUserMapper.insert(payUser);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean getInfo(Integer userId) {
        return ResultBean.success(payWagesRelationUserMapper.selectByPrimaryKey(userId));
    }

    @Override
    public ResultBean edit(PayWagesRelationUser payUser) {
        payUser.setUpdateTime(new Date());
        payUser.setUpdateUser(getLoginUserName());
        payWagesRelationUserMapper.updateByPrimaryKeySelective(payUser);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean delete(Integer userId) {
        return ResultBean.success(payWagesRelationUserMapper.deleteByPrimaryKey(userId));
    }
}
