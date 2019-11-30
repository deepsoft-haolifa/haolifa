package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.TaskRemind;
import com.deepsoft.haolifa.model.domain.TaskRemindExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskRemindMapper {
    int countByExample(TaskRemindExample example);

    int deleteByExample(TaskRemindExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TaskRemind record);

    int insertSelective(TaskRemind record);

    List<TaskRemind> selectByExample(TaskRemindExample example);

    TaskRemind selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TaskRemind record, @Param("example") TaskRemindExample example);

    int updateByExample(@Param("record") TaskRemind record, @Param("example") TaskRemindExample example);

    int updateByPrimaryKeySelective(TaskRemind record);

    int updateByPrimaryKey(TaskRemind record);
}