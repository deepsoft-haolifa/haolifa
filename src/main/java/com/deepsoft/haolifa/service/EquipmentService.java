package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.Equipment;
import com.deepsoft.haolifa.model.dto.*;

public interface EquipmentService {
    /**
     * 好利阀设备添加
     * @param model
     * @return
     */
    ResultBean save(Equipment model);

    /**
     * 好利阀设备删除
     * @param id
     * @return
     */
    ResultBean delete(Integer id);

    /**
     * 好利阀设备更新
     * @param model
     * @return
     */
    ResultBean update(Equipment model);

    /**
     * 好利阀设备详情
     * @param id
     * @return
     */
    ResultBean getInfo(Integer id);

    /**
     * 好利阀设备列表
     * @param model
     * @return
     */
    ResultBean getList(EquipmentListDTO model);

    /**
     * 好利阀设备维修记录保存
     * @param model
     * @return
     */
    ResultBean saveMaintainRecord(EquipRepairedRecordDTO model);

    /**
     * 好利阀设备维修记录列表
     * @param equipmentNo
     * @return
     */
    ResultBean getMaintainRecordList(String equipmentNo);
}
