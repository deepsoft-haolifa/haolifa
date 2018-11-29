package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.DeliveryNotice;
import com.deepsoft.haolifa.model.domain.DeliveryNoticeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeliveryNoticeMapper {
    long countByExample(DeliveryNoticeExample example);

    int deleteByExample(DeliveryNoticeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DeliveryNotice record);

    int insertSelective(DeliveryNotice record);

    List<DeliveryNotice> selectByExample(DeliveryNoticeExample example);

    DeliveryNotice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DeliveryNotice record, @Param("example") DeliveryNoticeExample example);

    int updateByExample(@Param("record") DeliveryNotice record, @Param("example") DeliveryNoticeExample example);

    int updateByPrimaryKeySelective(DeliveryNotice record);

    int updateByPrimaryKey(DeliveryNotice record);
}