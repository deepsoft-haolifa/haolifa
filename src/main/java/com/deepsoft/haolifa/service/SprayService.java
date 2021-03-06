package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.SprayInspectHistory;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.spray.SprayDto;
import com.deepsoft.haolifa.model.dto.spray.SprayInspectDto;
import com.deepsoft.haolifa.model.dto.spray.SprayInspectListDto;
import com.deepsoft.haolifa.model.dto.spray.SprayListDto;

public interface SprayService {

    ResultBean save(SprayDto sprayDto);

    ResultBean delete(String sprayNo);

    ResultBean update(SprayDto sprayDto);

    ResultBean getSprayInfo(String sprayNo);

    ResultBean forms(SprayListDto listDto);

    ResultBean updateStatus(String sprayNo, int status);

    ResultBean getInspectList(String sprayNo);

    ResultBean getItemsList(String sprayNo);

    ResultBean saveInspect(SprayInspectDto inspectDto);

    ResultBean getInspectToRooms(SprayInspectListDto inspectListDto);

    ResultBean updateHistoryStatus(Integer historyId);

    ResultBean updateInspectStatus(String sprayNo, int status);


    /**
     * 获取正在喷涂的数量（除去已经入库的数量）
     *
     * @param materialGraphNo
     * @return
     */
    int obtainNumber(String materialGraphNo);

    SprayInspectHistory getHistoryInfo(Integer historyId);
}
