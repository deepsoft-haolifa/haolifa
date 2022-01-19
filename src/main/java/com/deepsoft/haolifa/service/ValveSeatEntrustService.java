package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.ValveSeatEntrust;
import com.deepsoft.haolifa.model.domain.ValveSeatInspectHistory;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.autoControl.AutoControlInspectDto;
import com.deepsoft.haolifa.model.dto.autoControl.AutoControlInspectHistoryDto;
import com.deepsoft.haolifa.model.dto.valveSeat.*;

import java.util.List;

/**
 * @author murphy.he
 **/
public interface ValveSeatEntrustService {
    /**
     * 新增
     */
    public int add(ValveSeatEntrustReqDto reqDto);
    /**
     * 更新
     */
    public int update(ValveSeatEntrustReqDto reqDto);


    /**
     * 分页查询
     */
    public PageDTO<ValveSeatEntrust> pageList(ValveSeatEntrustConditionDto pageDto);

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
     * @param autoControlInspectDto
     * @return
     */
    int saveInspect(ValveSeatInspectDto autoControlInspectDto);


    /**
     * 查询质检记录
     * @param no
     * @return
     */
    List<ValveSeatInspectHistoryDto> getInspectList(String no);

    /**
     * 阀座待入库
     * @param pageDto
     * @return
     */
    PageDTO<ValveSeatInspectHistory> historyList(HistoryConditionDto pageDto);

    /**
     * 入库后更新入库状态
     */
    int updateHistoryStatus(Integer historyId);
}
