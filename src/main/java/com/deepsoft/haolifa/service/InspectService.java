package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.InspectHistory;
import com.deepsoft.haolifa.model.dto.InspectHistoryDto;
import com.deepsoft.haolifa.model.dto.InspectDTO;
import com.deepsoft.haolifa.model.dto.InspectItemUpdateDTO;
import com.deepsoft.haolifa.model.dto.InspectResDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.vo.InspectItemQtyVo;

import java.util.List;

public interface InspectService {

    /**
     * 创建送检单
     */
    ResultBean save(InspectDTO model);

    /**
     * 删除送检信息
     */
    ResultBean delete(Integer inspectId);

    /**
     * 更新送检单
     */
    ResultBean update(int inspectId, InspectDTO model);

    /**
     * 获取详情
     */
    ResultBean getInfo(int inspectId);

    /**
     * 查询列表
     */
    ResultBean getList(int type, int pageNum, int pageSize, String inspectNo, String purchaseOrderNo,String supplierName,String batchNumber,Byte status);

    /**
     * 更新状态
     */
    ResultBean updateStatus(Integer inspectId, Integer status);

    /**
     * 删除质检单项
     */
    ResultBean deleteItem(int itemId);

    /**
     * 更新送检单项
     */
    ResultBean updateItem(int itemId, InspectItemUpdateDTO model);

    /**
     * 添加质检结果
     */
    ResultBean inspectRes(int itemId, InspectResDTO model);

    /**
     * 质检记录保存
     */
    ResultBean historySave(InspectHistoryDto model);

    /**
     * 质检记录删除
     */
    ResultBean historyDelete(Integer id);


    /**
     * 质检记录列表
     */
    ResultBean historyList(String inspectNo);

    /**
     * 分页
     */
    ResultBean historyList(Integer pageNum, Integer pageSize, Integer status);

    /**
     * 入库完成
     *
     * @param historyId
     * @return
     */
    ResultBean updateHistoryStatus(Integer historyId);

    /**
     * 获取机加工已入库的记录
     */
    List<InspectHistory> historyList(List<String> inspectNo, Byte status, Byte type);


    /**
     * 获取历史质检记录详情
     *
     * @param historyId
     * @return
     */
    InspectHistory getHistoryInfo(Integer historyId);
    /**
     * 根据采购订单号获取质检的相关数量
     *
     * @return
     */
    List<InspectItemQtyVo> getPurchaseAllQty(String purchaseNo);
}
