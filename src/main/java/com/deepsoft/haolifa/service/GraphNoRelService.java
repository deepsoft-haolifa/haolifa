package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.GraphNoRel;

import java.util.List;

public interface GraphNoRelService {

    // 根据机加工零件获取毛坯零件
    GraphNoRel listByGraphNoJ(String graphNoJ);

    // 根据毛坯零件获取机加工零件
    List<GraphNoRel>  listByGraphNoM(String graphNoM);
}
