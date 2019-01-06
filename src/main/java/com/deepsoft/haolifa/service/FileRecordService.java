package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.FileRecord;
import com.deepsoft.haolifa.model.dto.file.FileRecordConditionDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.file.FileRecordDTO;

public interface FileRecordService {


    /**
     * 保存文件
     *
     * @param model
     * @return
     */
    ResultBean save(FileRecordDTO model);


    /**
     * 更新文件
     *
     * @param model
     * @return
     */
    ResultBean update(FileRecordDTO model);


    /**
     * 删除文件详情
     *
     * @param id
     * @return
     */
    ResultBean delete(int id);

    /**
     * 获取文件详情
     *
     * @param id
     * @return
     */
    FileRecord info(int id);

    /**
     * 获取文件列表(分页)
     *
     * @param conditionDTO
     * @return
     */
    ResultBean pageInfo(FileRecordConditionDTO conditionDTO);
}
