package com.deepsoft.haolifa.dao.repository.extend;


import com.deepsoft.haolifa.model.domain.FlowInstanceWrapper;
import com.deepsoft.haolifa.model.dto.BackStepDTO;
import com.deepsoft.haolifa.model.dto.HistoryInfo;
import com.deepsoft.haolifa.model.vo.QuickStartVO;
import com.deepsoft.haolifa.model.vo.TodoItemVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FlowInstanceHistoryMapper {

    List<HistoryInfo> selectInstanceHistory(HistoryInfo historyInfo);

    FlowInstanceWrapper selectByPrimaryKey(@Param("instanceId") Integer instaceId);

    List<BackStepDTO> selectBackStepsByFlowIdAndStepId(@Param("flowId") Integer flowId, @Param("stepId") Integer currentStepId);

    List<QuickStartVO> selectFlowByUserRoles(@Param("userId")Integer userId);

    List<TodoItemVO> selectToDoItems(@Param("userId")Integer userId);
}
