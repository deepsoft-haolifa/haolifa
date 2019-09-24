package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.GraphNoRelMapper;
import com.deepsoft.haolifa.model.domain.GraphNoRel;
import com.deepsoft.haolifa.model.domain.GraphNoRelExample;
import com.deepsoft.haolifa.service.GraphNoRelService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
public class GraphNoRelServiceImpl implements GraphNoRelService {

    @Resource
    private GraphNoRelMapper graphNoRelMapper;

    @Override
    public GraphNoRel listByGraphNoJ(String graphNoJ) {
        GraphNoRelExample example = new GraphNoRelExample();
        example.or().andGraphNoJEqualTo(graphNoJ);
        List<GraphNoRel> graphNoRels = graphNoRelMapper.selectByExample(example);
        return CollectionUtils.isEmpty(graphNoRels) ? null : graphNoRels.get(0);
    }

    @Override
    public List<GraphNoRel> listByGraphNoM(String graphNoM) {
        GraphNoRelExample example = new GraphNoRelExample();
        example.or().andGraphNoMEqualTo(graphNoM);
        return graphNoRelMapper.selectByExample(example);
    }
}
