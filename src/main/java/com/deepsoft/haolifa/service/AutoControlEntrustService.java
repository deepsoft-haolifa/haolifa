package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.AutoControlEntrust;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.autoControlEntrust.AutoControlEntrustConditionDto;
import com.deepsoft.haolifa.model.dto.autoControlEntrust.AutoControlEntrustReqDto;
import com.deepsoft.haolifa.model.dto.autoControlEntrust.InspectDto;
import com.deepsoft.haolifa.model.dto.autoControlEntrust.InspectHistoryDto;

import java.util.List;

/**
 * @author murphy.he
 **/
public interface AutoControlEntrustService {
    /**
     * 新增
     */
    public int add(AutoControlEntrustReqDto reqDto);
    /**
     * 更新
     */
    public int update(AutoControlEntrustReqDto reqDto);


    /**
     * 分页查询
     */
    public PageDTO<AutoControlEntrust> pageList(AutoControlEntrustConditionDto pageDto);

    /**
     * 更新状态
     * @param id
     * @param status
     * @return
     */
    int updateStatus(Integer id, int status);


    /**
     * 更新质检状态
     * @param id
     * @param status
     * @return
     */
    int updateInspectStatus(Integer id, int status);


    /**
     * 保存质检记录
     * @param inspectDto
     * @return
     */
    int saveInspect(InspectDto inspectDto);


    /**
     * 查询质检记录
     * @param no
     * @return
     */
    List<InspectHistoryDto> getInspectList(String no);
}
