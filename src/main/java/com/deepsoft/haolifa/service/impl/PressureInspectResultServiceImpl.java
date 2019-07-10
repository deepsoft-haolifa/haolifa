package com.deepsoft.haolifa.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.PressureInspectResultMapper;
import com.deepsoft.haolifa.dao.repository.PressureInspectUnqualifiedMapper;
import com.deepsoft.haolifa.model.domain.PressureInspectResult;
import com.deepsoft.haolifa.model.domain.PressureInspectResultExample;
import com.deepsoft.haolifa.model.domain.PressureInspectUnqualified;
import com.deepsoft.haolifa.model.domain.PressureInspectUnqualifiedExample;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pressureInspect.PressureInspectConditionDTO;
import com.deepsoft.haolifa.model.dto.pressureInspect.PressureInspectResDTO;
import com.deepsoft.haolifa.model.dto.pressureInspect.PressureInspectUnqualifiedDTO;
import com.deepsoft.haolifa.service.PressureInspectResultService;
import com.deepsoft.haolifa.util.RandomUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PressureInspectResultServiceImpl extends BaseService implements PressureInspectResultService {

    @Autowired
    private PressureInspectResultMapper pressureInspectResultMapper;
    @Autowired
    private PressureInspectUnqualifiedMapper pressureInspectUnqualifiedMapper;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultBean save(PressureInspectResDTO model) {
        String orderNo = model.getOrderNo();
        String inspectNo = "prs_" + RandomUtils.orderNoStr();
        PressureInspectResult result = new PressureInspectResult();
        BeanUtils.copyProperties(model, result);
        result.setInspectNo(inspectNo);
        int insert = pressureInspectResultMapper.insertSelective(result);
        if (insert > 0) {
            // 添加成品不合格记录
            if (model.getUnqualifiedList() != null && !model.getUnqualifiedList().isEmpty()) {
                for (PressureInspectUnqualifiedDTO e : model.getUnqualifiedList()) {
                    PressureInspectUnqualified record = new PressureInspectUnqualified() {{
                        setCreateUserId(getLoginUserId());
                        setOrderNo(orderNo);
                        setInspectNo(inspectNo);
                        setUnqualifiedNumber(e.getUnqualifiedNumber());
                        setReason(e.getReason());
                    }};
                    pressureInspectUnqualifiedMapper.insertSelective(record);
                }
            }
        }
        return ResultBean.success(insert);
    }

    @Override
    public ResultBean delete(Integer id) {
        return ResultBean.success(pressureInspectResultMapper.deleteByPrimaryKey(id));
    }

    @Override
    public ResultBean update(PressureInspectResDTO model) {
        if (model.getId() == null || model.getId() <= 0) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        if (StringUtils.isBlank(model.getInspectNo())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        PressureInspectResult result = new PressureInspectResult();
        BeanUtils.copyProperties(model, result);
        // 更新基础信息
        int update = pressureInspectResultMapper.updateByPrimaryKeySelective(result);
        if (update > 0) {
            String orderNo = model.getOrderNo();
            String inspectNo = model.getInspectNo();
            // 删除原有的不合格记录
            pressureInspectUnqualifiedMapper.deleteByExample(new PressureInspectUnqualifiedExample() {{
                or().andInspectNoEqualTo(inspectNo);
            }});
            // 重新添加成品不合格记录
            if (model.getUnqualifiedList() != null && !model.getUnqualifiedList().isEmpty()) {
                for (PressureInspectUnqualifiedDTO e : model.getUnqualifiedList()) {
                    PressureInspectUnqualified record = new PressureInspectUnqualified() {{
                        setCreateUserId(getLoginUserId());
                        setOrderNo(orderNo);
                        setInspectNo(inspectNo);
                        setUnqualifiedNumber(e.getUnqualifiedNumber());
                        setReason(e.getReason());
                    }};
                    pressureInspectUnqualifiedMapper.insertSelective(record);
                }
            }
        }
        return ResultBean.success(update);
    }

    @Override
    public ResultBean getInfo(String inspectNo) {
        PressureInspectResDTO resDTO = new PressureInspectResDTO();
        PressureInspectResultExample example = new PressureInspectResultExample();
        example.or().andInspectNoEqualTo(inspectNo);
        List<PressureInspectResult> pressureInspectResultList = pressureInspectResultMapper.selectByExample(example);
        if (pressureInspectResultList == null || pressureInspectResultList.size() == 0) {
            return ResultBean.error(CommonEnum.ResponseEnum.RESOURCE_NOT_EXIST);
        }
        PressureInspectResult result = pressureInspectResultList.get(0);
        BeanUtils.copyProperties(result, resDTO);

        // 获取不合格数据
        List<PressureInspectUnqualified> proInspectUnqualifieds = pressureInspectUnqualifiedMapper.selectByExample(new PressureInspectUnqualifiedExample() {{
            or().andInspectNoEqualTo(inspectNo);
        }});
        List<PressureInspectUnqualifiedDTO> list = new ArrayList<>();
        list = JSONObject.parseArray(JSONObject.toJSONString(proInspectUnqualifieds), PressureInspectUnqualifiedDTO.class);
        resDTO.setUnqualifiedList(list);

        return ResultBean.success(resDTO);
    }

    @Override
    public ResultBean pageInfo(PressureInspectConditionDTO model) {
        PressureInspectResultExample example = new PressureInspectResultExample();
        PressureInspectResultExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(model.getInspectNo())) {
            criteria.andInspectNoLike("%" + model.getInspectNo() + "%");
        }
        if (StringUtils.isNotBlank(model.getOrderNo())) {
            criteria.andOrderNoLike("%" + model.getOrderNo() + "%");
        }
        example.setOrderByClause("id desc");
        Page<PressureInspectResult> pageData = PageHelper.startPage(model.getPageNum(), model.getPageSize()).doSelectPage(() -> {
            pressureInspectResultMapper.selectByExample(example);
        });
        PageDTO<PressureInspectResult> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);
        pageDTO.setList(pageData.getResult());
        return ResultBean.success(pageDTO);
    }
}
