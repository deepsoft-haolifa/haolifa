package com.deepsoft.haolifa.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.ProInspectResultMapper;
import com.deepsoft.haolifa.dao.repository.ProInspectUnqualifiedMapper;
import com.deepsoft.haolifa.model.domain.ProInspectResult;
import com.deepsoft.haolifa.model.domain.ProInspectResultExample;
import com.deepsoft.haolifa.model.domain.ProInspectUnqualified;
import com.deepsoft.haolifa.model.domain.ProInspectUnqualifiedExample;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.proInspect.ProInspectConditionDTO;
import com.deepsoft.haolifa.model.dto.proInspect.ProInspectResDTO;
import com.deepsoft.haolifa.model.dto.proInspect.ProInspectUnqualifiedDTO;
import com.deepsoft.haolifa.service.ProInspectResultService;
import com.deepsoft.haolifa.util.RandomUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ProInspectResultServiceImpl extends BaseService implements ProInspectResultService {

    @Autowired
    private ProInspectResultMapper proInspectResultMapper;
    @Autowired
    private ProInspectUnqualifiedMapper proInspectUnqualifiedMapper;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultBean save(ProInspectResDTO model) {
        String orderNo = model.getOrderNo();
        String inspectNo = "pis_" + RandomUtils.orderNoStr();
        ProInspectResult proInspectResult = new ProInspectResult();
        BeanUtils.copyProperties(model, proInspectResult);
        proInspectResult.setCreateUserId(getLoginUserId());
        proInspectResult.setInspectNo(inspectNo);
        proInspectResult.setStorageStatus((byte) 1);
        int insert = proInspectResultMapper.insertSelective(proInspectResult);
        if (insert > 0) {
            // 添加成品不合格记录
            if (model.getUnqualifiedList() != null && !model.getUnqualifiedList().isEmpty()) {
                for (ProInspectUnqualifiedDTO e : model.getUnqualifiedList()) {
                    ProInspectUnqualified record = new ProInspectUnqualified() {{
                        setCreateUserId(getLoginUserId());
                        setOrderNo(orderNo);
                        setInspectNo(inspectNo);
                        setProductModel(e.getProductModel());
                        setProductSpecifications(e.getProductSpecifications());
                        setUnqualifiedNumber(e.getUnqualifiedNumber());
                        setReason(e.getReason());
                    }};
                    proInspectUnqualifiedMapper.insertSelective(record);
                }
            }
        }
        return ResultBean.success(insert);
    }

    @Override
    public ResultBean delete(Integer id) {
        return ResultBean.success(proInspectResultMapper.deleteByPrimaryKey(id));
    }

    @Override
    public ResultBean update(ProInspectResDTO model) {
        ProInspectResult proInspectResult = new ProInspectResult();
        BeanUtils.copyProperties(model, proInspectResult);
        // 更新基础信息
        int update = proInspectResultMapper.updateByPrimaryKeySelective(proInspectResult);
        if (update > 0) {
            String orderNo = model.getOrderNo();
            String inspectNo = model.getInspectNo();
            // 删除原有的不合格记录
            proInspectUnqualifiedMapper.deleteByExample(new ProInspectUnqualifiedExample() {{
                or().andInspectNoEqualTo(inspectNo);
            }});
            // 重新添加成品不合格记录
            if (model.getUnqualifiedList() != null && !model.getUnqualifiedList().isEmpty()) {
                for (ProInspectUnqualifiedDTO e : model.getUnqualifiedList()) {
                    ProInspectUnqualified record = new ProInspectUnqualified() {{
                        setCreateUserId(getLoginUserId());
                        setOrderNo(orderNo);
                        setInspectNo(inspectNo);
                        setProductModel(e.getProductModel());
                        setProductSpecifications(e.getProductSpecifications());
                        setUnqualifiedNumber(e.getUnqualifiedNumber());
                        setReason(e.getReason());
                    }};
                    proInspectUnqualifiedMapper.insertSelective(record);
                }
            }
        }
        return ResultBean.success(update);
    }

    @Override
    public ResultBean getInfo(String inspectNo) {
        ProInspectResDTO proInspectResDTO = new ProInspectResDTO();
        ProInspectResultExample proInspectResultExample = new ProInspectResultExample();
        proInspectResultExample.or().andInspectNoEqualTo(inspectNo);
        List<ProInspectResult> proInspectResultList = proInspectResultMapper.selectByExample(proInspectResultExample);
        if (proInspectResultList == null || proInspectResultList.size() == 0) {
            return ResultBean.error(CommonEnum.ResponseEnum.RESOURCE_NOT_EXIST);
        }
        ProInspectResult proInspectResult = proInspectResultList.get(0);
        BeanUtils.copyProperties(proInspectResult, proInspectResDTO);

        // 获取不合格数据
        List<ProInspectUnqualified> proInspectUnqualifieds = proInspectUnqualifiedMapper.selectByExample(new ProInspectUnqualifiedExample() {{
            or().andInspectNoEqualTo(inspectNo);
        }});
        List<ProInspectUnqualifiedDTO> list = new ArrayList<>();
        list = JSONObject.parseArray(JSONObject.toJSONString(proInspectUnqualifieds), ProInspectUnqualifiedDTO.class);
        proInspectResDTO.setUnqualifiedList(list);

        return ResultBean.success(proInspectResDTO);
    }

    @Override
    public ResultBean pageInfo(ProInspectConditionDTO model) {
        ProInspectResultExample example = new ProInspectResultExample();
        ProInspectResultExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(model.getInspectNo())) {
            criteria.andInspectNoLike("%" + model.getInspectNo() + "%");
        }
        if (model.getStorageStatus() > 0) {
            criteria.andStorageStatusEqualTo(model.getStorageStatus());
        }
        if (StringUtils.isNotBlank(model.getOrderNo())) {
            criteria.andOrderNoLike("%" + model.getOrderNo() + "%");
        }
        example.setOrderByClause("id desc");
        Page<ProInspectResult> pageData = PageHelper.startPage(model.getPageNum(), model.getPageSize()).doSelectPage(() -> {
            proInspectResultMapper.selectByExample(example);
        });
        PageDTO<ProInspectResult> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);
        pageDTO.setList(pageData.getResult());
        return ResultBean.success(pageDTO);
    }

    @Override
    public int updateStorageStatus(String inspectNo, Byte storageStatus) {
        return proInspectResultMapper.updateByExampleSelective(new ProInspectResult() {{
            setStorageStatus(storageStatus);
        }}, new ProInspectResultExample() {{
            or().andInspectNoEqualTo(inspectNo);
        }});
    }
}
