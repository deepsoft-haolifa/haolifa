package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.InspectMapper;
import com.deepsoft.haolifa.dao.repository.extend.InspectExtendMapper;
import com.deepsoft.haolifa.model.domain.Inspect;
import com.deepsoft.haolifa.model.domain.InspectExample;
import com.deepsoft.haolifa.model.dto.InspectDTO;
import com.deepsoft.haolifa.model.dto.InspectListDTO;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.InspectService;
import com.deepsoft.haolifa.util.RandomUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class InspectServiceImpl extends BaseService implements InspectService {

    @Autowired
    InspectMapper inspectMapper;
    @Autowired
    InspectExtendMapper inspectExtendMapper;

    @Override
    public ResultBean save(List<InspectDTO> modelList) {
        int createUserId = getLoginUserId();
        String inspectNo = "in_" + RandomUtils.orderNoStr();
        List<Inspect> inspectList = modelList.stream().map(inspectDTO -> {
            Inspect inspect = new Inspect();
            BeanUtils.copyProperties(inspectDTO, inspect);
            inspect.setCreateUserId(createUserId);
            inspect.setInspectNo(inspectNo);
            return inspect;
        }).collect(Collectors.toList());
        inspectExtendMapper.batchInsertInspect(inspectList);
        Map<String,Object> result = new HashMap<>(8);
        result.put("formId",0);
        result.put("formNo",inspectNo);
        result.put("formType",CommonEnum.FormType.INSPECT_TYPE.code);
        return ResultBean.success(result);
    }

    @Override
    public ResultBean delete(String inspectNo, String materialGraphNo, String productModel) {
        if (StringUtils.isEmpty(inspectNo)) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        InspectExample inspectExample = new InspectExample();
        inspectExample.or().andInspectNoEqualTo(inspectNo)
                .andMaterialGraphNoEqualTo(materialGraphNo)
                .andProductModelEqualTo(productModel);
        inspectMapper.deleteByExample(inspectExample);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean update(InspectDTO model) {
        InspectExample inspectExample = new InspectExample();
        inspectExample.or().andInspectNoEqualTo(model.getInspectNo())
                .andProductModelEqualTo(model.getProductModel())
                .andMaterialGraphNoEqualTo(model.getMaterialGraphNo());
        Inspect inspect = new Inspect();
        inspect.setNumber(model.getNumber());
        inspectMapper.updateByExampleSelective(inspect, inspectExample);
        return ResultBean.success(1);
    }

    @Override
    public ResultBean getInfo(String inspectNo) {
        InspectExample inspectExample = new InspectExample();
        inspectExample.or().andInspectNoEqualTo(inspectNo);
        List<Inspect> inspects = inspectMapper.selectByExample(inspectExample);
        return ResultBean.success(inspects);
    }

    @Override
    public ResultBean getList(InspectListDTO model) {
        if (model.getPageNum() == null || model.getPageNum() == 0) {
            model.setPageNum(1);
        }
        if (model.getPageSize() == null || model.getPageSize() == 0) {
            model.setPageSize(10);
        }
        Page<Inspect> pageData = PageHelper.startPage(model.getPageNum(), model.getPageSize()).doSelectPage(() ->
                inspectExtendMapper.selectInspectDistinctList(model));
        PageDTO<Inspect> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);
        pageDTO.setList(pageData.getResult());
        return ResultBean.success(pageDTO);
    }

    @Override
    public ResultBean updateStatus(String inspectNo, Integer status) {
        if (StringUtils.isEmpty(inspectNo) || status == null) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        Inspect inspect = new Inspect();
        inspect.setStatus(status.byteValue());
        InspectExample inspectExample = new InspectExample();
        inspectExample.or().andInspectNoEqualTo(inspectNo);
        inspectMapper.updateByExampleSelective(inspect, inspectExample);
        return ResultBean.success(1);
    }
}
