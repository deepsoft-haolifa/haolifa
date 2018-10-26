package com.deepsoft.haolifa.dao.repository.extend;

import com.deepsoft.haolifa.model.domain.ApplyBuy;
import com.deepsoft.haolifa.model.domain.ApplyBuyExample;
import com.deepsoft.haolifa.model.dto.ApplyBuyListDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ApplyBuyExtendMapper {

    /**
     * 分组查询
     *
     * @param model
     * @return
     */
    List<Map<String, Object>> selectByGroup(ApplyBuyListDTO model);
}