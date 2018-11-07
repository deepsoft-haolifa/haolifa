package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.DeliveryRecord;
import com.deepsoft.haolifa.model.domain.DeliveryRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeliveryRecordMapper {
    long countByExample(DeliveryRecordExample example);

    int deleteByExample(DeliveryRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DeliveryRecord record);

    int insertSelective(DeliveryRecord record);

    List<DeliveryRecord> selectByExample(DeliveryRecordExample example);

    DeliveryRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DeliveryRecord record, @Param("example") DeliveryRecordExample example);

    int updateByExample(@Param("record") DeliveryRecord record, @Param("example") DeliveryRecordExample example);

    int updateByPrimaryKeySelective(DeliveryRecord record);

    int updateByPrimaryKey(DeliveryRecord record);
}