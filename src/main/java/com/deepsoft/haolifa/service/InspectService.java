package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.InspectDTO;
import com.deepsoft.haolifa.model.dto.InspectListDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;

import java.util.List;

public interface InspectService {
    /**
     * 创建送检单
     * @param modelList
     * @return
     */
    ResultBean save(List<InspectDTO> modelList);

    /**
     * 删除送检信息
     * @param inspectNo
     * @param materialGraphNo
     * @param productModel
     * @return
     */
    ResultBean delete(String inspectNo, String materialGraphNo, String productModel);

    /**
     * 更新送检单
     * @param model
     * @return
     */
    ResultBean update(InspectDTO model);

    /**
     * 获取详情
     * @param inspectNo
     * @return
     */
    ResultBean getInfo(String inspectNo);

    /**
     * 查询列表
     * @param model
     * @return
     */
    ResultBean getList(InspectListDTO model);

    /**
     * 更新状态
     * @param inspectNo
     * @param status
     * @return
     */
    ResultBean updateStatus(String inspectNo, Integer status);
}
