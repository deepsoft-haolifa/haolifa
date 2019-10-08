package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.CheckMaterialLock;
import com.deepsoft.haolifa.model.dto.order.CheckMaterialLockDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CheckMaterialLockService {

    /**
     * 添加数据
     *
     * @param checkMaterialLockDTO
     */
    void add(String orderNo, CheckMaterialLockDTO checkMaterialLockDTO);

    /**
     * 根据图号和类型，获取锁定的列表（锁定数量大于0）
     *
     * @param materialGraphNo
     * @param type
     * @return
     */
    List<CheckMaterialLock> findByMaterialAndType(String materialGraphNo, Byte type);

    /**
     * 根据 订单号，删除记录
     *
     * @param orderNo
     */
    void delByOrderNo(String orderNo);


    /**
     * 更新图号的锁定数量
     */
    void updateLockQuantity(CheckMaterialLockDTO checkMaterialLockDTO);

}
