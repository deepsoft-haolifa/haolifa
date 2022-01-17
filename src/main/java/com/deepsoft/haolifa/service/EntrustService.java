package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.AllotEntrustDTO;
import com.deepsoft.haolifa.model.dto.EntrustDTO;
import com.deepsoft.haolifa.model.dto.EntrustListDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;

public interface EntrustService {
    /**
     * 添加机加委托申请
     * @param model
     * @return
     */
    ResultBean save(EntrustDTO model);

    /**
     * 删除机加委托申请
     * @param entrustNo
     * @return
     */
    ResultBean delete(String entrustNo);

    /**
     * 修改机加委托申请
     * @param model
     * @return
     */
    ResultBean update(String entrustNo,EntrustDTO model);

    /**
     * 查询详情
     * @param entrustNo
     * @return
     */
    ResultBean getInfo(String entrustNo);

    /**
     * 查询列表
     * @param model
     * @return
     */
    ResultBean getList(EntrustListDTO model);

    /**
     * 更新状态
     * @param entrustNo
     * @param status
     * @return
     */
    ResultBean updateStatus(String entrustNo, Integer status);

    /**
     * 分配车间
     * @param allotEntrustDTO
     * @return
     */
    ResultBean allotEntrust(AllotEntrustDTO allotEntrustDTO);

    /**
     * 获取正在机加工的数量（排除机加工已入库的数据）
     * @param materialGraphNo 机加工之前的图号
     * @param processedGraphNo 机加工之后的图号
     * @return
     */
    int obtainEntrustNumber(String materialGraphNo, String processedGraphNo);

    ResultBean updateInspectStatus(String entrustNo, Integer status);

    /**
     * 修改分配任务状态
     * @param entrustNo
     * @param taskStatus
     * @return
     */
    ResultBean updateInspectTaskStatus(String entrustNo, Integer taskStatus);

    }
