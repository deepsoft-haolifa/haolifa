package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.PayWorkAttendance;
import com.deepsoft.haolifa.model.domain.PayWorkAttendanceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PayWorkAttendanceMapper {
    int countByExample(PayWorkAttendanceExample example);

    int deleteByExample(PayWorkAttendanceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayWorkAttendance record);

    int insertSelective(PayWorkAttendance record);

    List<PayWorkAttendance> selectByExample(PayWorkAttendanceExample example);

    PayWorkAttendance selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayWorkAttendance record, @Param("example") PayWorkAttendanceExample example);

    int updateByExample(@Param("record") PayWorkAttendance record, @Param("example") PayWorkAttendanceExample example);

    int updateByPrimaryKeySelective(PayWorkAttendance record);

    int updateByPrimaryKey(PayWorkAttendance record);
}
