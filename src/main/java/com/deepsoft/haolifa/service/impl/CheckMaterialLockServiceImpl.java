package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.CheckMaterialLockMapper;
import com.deepsoft.haolifa.model.domain.CheckMaterialLock;
import com.deepsoft.haolifa.model.domain.CheckMaterialLockExample;
import com.deepsoft.haolifa.model.dto.order.CheckMaterialLockDTO;
import com.deepsoft.haolifa.service.CheckMaterialLockService;
import com.deepsoft.haolifa.util.BeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class CheckMaterialLockServiceImpl implements CheckMaterialLockService {

    @Resource
    private CheckMaterialLockMapper checkMaterialLockMapper;

    @Override
    public void add(String orderNo, CheckMaterialLockDTO checkMaterialLockDTO) {
        CheckMaterialLock checkMaterialLock = new CheckMaterialLock();
        BeanUtils.copyProperties(checkMaterialLockDTO, checkMaterialLock);
        checkMaterialLock.setOrderNo(orderNo);
        checkMaterialLockMapper.insert(checkMaterialLock);
    }

    @Override
    public List<CheckMaterialLock> findByMaterialAndType(String materialGraphNo, Byte type) {
        CheckMaterialLockExample example = new CheckMaterialLockExample();
        CheckMaterialLockExample.Criteria criteria = example.createCriteria();
        criteria.andMaterialGraphNoEqualTo(materialGraphNo);
        criteria.andTypeEqualTo(type);
        // 锁定数量大于0
        criteria.andLockQuantityGreaterThan(0);
        return checkMaterialLockMapper.selectByExample(example);
    }

    @Override
    public void delByOrderNo(String orderNo) {
        CheckMaterialLockExample example = new CheckMaterialLockExample();
        example.or().andOrderNoEqualTo(orderNo);
        checkMaterialLockMapper.deleteByExample(example);
    }

    @Override
    public void updateLockQuantity(CheckMaterialLockDTO checkMaterialLockDTO) {
        int lockQuantity = checkMaterialLockDTO.getLockQuantity();
        String materialGraphNo = checkMaterialLockDTO.getMaterialGraphNo();
        byte type = checkMaterialLockDTO.getType();

        List<CheckMaterialLock> checkMaterialLocks = this.findByMaterialAndType(materialGraphNo, type);
        if (CollectionUtils.isEmpty(checkMaterialLocks)) {
            return;
        }

        for (CheckMaterialLock checkMaterialLock : checkMaterialLocks) {
            Integer quantity = checkMaterialLock.getLockQuantity();
            int reduce = quantity - lockQuantity;
            log.info("update lock quantity info,materialNo:{},type:{},storeCount:{},reduce:{}", materialGraphNo, type, lockQuantity, reduce);
            if (reduce > 0) {
                checkMaterialLock.setLockQuantity(reduce);
                checkMaterialLockMapper.updateByPrimaryKeySelective(checkMaterialLock);
                break;
            } else {
                checkMaterialLock.setLockQuantity(0);
                checkMaterialLockMapper.updateByPrimaryKeySelective(checkMaterialLock);
                lockQuantity = Math.abs(reduce);
            }
        }

    }
}
