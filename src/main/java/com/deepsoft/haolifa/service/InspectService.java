package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.InspectHistory;
import com.deepsoft.haolifa.model.dto.InspectDTO;
import com.deepsoft.haolifa.model.dto.InspectItemDTO;
import com.deepsoft.haolifa.model.dto.InspectItemUpdateDTO;
import com.deepsoft.haolifa.model.dto.InspectListDTO;
import com.deepsoft.haolifa.model.dto.InspectResDTO;
import com.deepsoft.haolifa.model.dto.InspectUpdateDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;

import java.util.List;

public interface InspectService {
    /**
     * 创建送检单
     * @param model
     * @return
     */
    ResultBean save(InspectDTO model);

    /**
     * 删除送检信息
     * @param inspectId
     * @return
     */
    ResultBean delete(Integer inspectId);

    /**
     * 更新送检单
     * @param inspectId
     * @param model
     * @return
     */
    ResultBean update(int inspectId,InspectDTO model);

    /**
     * 获取详情
     * @param inspectId
     * @return
     */
    ResultBean getInfo(int inspectId);

    /**
     * 查询列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    ResultBean getList(int type,int pageNum, int pageSize,String inspectNo);

    /**
     * 更新状态
     * @param inspectId
     * @param status
     * @return
     */
    ResultBean updateStatus(Integer inspectId, Integer status);

    /**
     * 删除质检单项
     * @param itemId
     * @return
     */
    ResultBean deleteItem(int itemId);

    /**
     * 更新送检单项
     * @param itemId
     * @param model
     * @return
     */
    ResultBean updateItem(int itemId, InspectItemUpdateDTO model);

    /**
     * 添加质检结果
     * @param itemId
     * @param model
     * @return
     */
    ResultBean inspectRes(int itemId, InspectResDTO model);

    /**
     * 质检记录保存
     * @param model
     * @return
     */
    ResultBean historySave(InspectHistory model);

    /**
     * 质检记录删除
     * @param id
     * @return
     */
    ResultBean historyDelete(Integer id);


    /**
     * 质检记录列表
     * @param inspectNo
     * @return
     */
    ResultBean historyList(String inspectNo);
}
