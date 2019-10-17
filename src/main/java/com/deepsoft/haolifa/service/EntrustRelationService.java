package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.EntrustGraphNoRelation;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.entrust.EntrustRelationDto;

import java.util.List;

public interface EntrustRelationService {

    ResultBean save(EntrustRelationDto dto);

    ResultBean delete(Integer id);

    ResultBean getRelations(String originalGraphNo);

    ResultBean getList(Integer pageNum, Integer pageSize);

    /**
     * 根据机加工零件获取毛坯零件
     */
    EntrustGraphNoRelation findByGraphNoJ(String graphNoJ);

    /**
     * 根据毛坯零件获取机加工零件
     *
     * @param graphNoM
     * @return
     */
    List<EntrustGraphNoRelation> listByGraphNoM(String graphNoM);


}
