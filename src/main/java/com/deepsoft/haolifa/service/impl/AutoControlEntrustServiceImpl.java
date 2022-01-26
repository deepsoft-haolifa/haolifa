package com.deepsoft.haolifa.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.AutoControlEntrustMapper;
import com.deepsoft.haolifa.dao.repository.AutoControlInspectHistoryMapper;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.model.dto.autoControl.AutoControlEntrustConditionDto;
import com.deepsoft.haolifa.model.dto.autoControl.AutoControlEntrustReqDto;
import com.deepsoft.haolifa.model.dto.autoControl.AutoControlInspectDto;
import com.deepsoft.haolifa.model.dto.autoControl.AutoControlInspectHistoryDto;
import com.deepsoft.haolifa.service.AutoControlEntrustService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.deepsoft.haolifa.constant.CacheKey.AC_ENTRUST_NO_KEY;
import static com.deepsoft.haolifa.constant.Constant.SerialNumberPrefix.AC_NO_PREFIX_AC;

/**
 * @author murphy.he
 **/
@Slf4j
@Service
public class AutoControlEntrustServiceImpl extends BaseService implements AutoControlEntrustService {

    @Autowired
    private AutoControlEntrustMapper autoControlEntrustMapper;
    @Autowired
    private AutoControlInspectHistoryMapper inspectHistoryMapper;


    @Override
    public int add(AutoControlEntrustReqDto reqDto) {
        AutoControlEntrust model = new AutoControlEntrust();
        String acNo = createSerialNumber(AC_NO_PREFIX_AC, AC_ENTRUST_NO_KEY);
        BeanUtil.copyProperties(reqDto, model);
        model.setEntrustNo(acNo);
        return autoControlEntrustMapper.insertSelective(model);
    }

    @Override
    public int update(AutoControlEntrustReqDto reqDto) {
        AutoControlEntrust model = autoControlEntrustMapper.selectByPrimaryKey(reqDto.getId());
        if(!model.getStatus().equals(CommonEnum.SprayStatus.SPRAY_CREATE.code)){
            throw new BaseException("只有待加工才能操作");
        }
        BeanUtil.copyProperties(reqDto, model);
        return autoControlEntrustMapper.updateByPrimaryKeySelective(model);

    }

    @Override
    public int delete(Integer id) {
        AutoControlEntrust autoControlEntrust = autoControlEntrustMapper.selectByPrimaryKey(id);
        if(!autoControlEntrust.getStatus().equals(CommonEnum.SprayStatus.SPRAY_CREATE.code)){
            throw new BaseException("只有待加工才能操作");
        }
        return autoControlEntrustMapper.deleteByPrimaryKey(id);

    }

    @Override
    public PageDTO<AutoControlEntrust> pageList(AutoControlEntrustConditionDto pageDto) {
        AutoControlEntrustExample example = new AutoControlEntrustExample();
        AutoControlEntrustExample.Criteria criteria = example.createCriteria();
        if (null != pageDto.getStatus() && pageDto.getStatus() != -1) {
            criteria.andStatusEqualTo(pageDto.getStatus());
        }
        if (null != pageDto.getInspectStatus() && pageDto.getInspectStatus() != -1) {
            criteria.andInspectStatusEqualTo(pageDto.getInspectStatus());
        }
        if (null != pageDto.getType() && pageDto.getType() == 1) {
            criteria.andStatusIn(Arrays.asList((byte) 1, (byte) 2, (byte) 3));
        }
        if (StringUtils.isNotEmpty(pageDto.getEntrustNo())) {
            criteria.andEntrustNoEqualTo("%" + pageDto.getEntrustNo() + "%");
        }
        if (StringUtils.isNotEmpty(pageDto.getGraphNo())) {
            criteria.andGraphNoEqualTo("%" + pageDto.getGraphNo() + "%");
        }
        Page<AutoControlEntrust> pageList = PageHelper.startPage(pageDto.getPageNum(), pageDto.getPageSize(), "id desc")
            .doSelectPage(() -> autoControlEntrustMapper.selectByExample(example));
        PageDTO<AutoControlEntrust> pageDtos = new PageDTO<>();
        BeanUtils.copyProperties(pageList, pageDtos);
        pageDtos.setList(pageList);
        return pageDtos;
    }

    @Override
    public int updateStatus(Integer id, int status) {
        AutoControlEntrust autoControlEntrust = new AutoControlEntrust();
        autoControlEntrust.setId(id);
        autoControlEntrust.setStatus(Integer.valueOf(status).byteValue());
        return autoControlEntrustMapper.updateByPrimaryKeySelective(autoControlEntrust);
    }

    @Override
    public int updateInspectStatus(Integer id, int status) {
        AutoControlEntrust autoControlEntrust = new AutoControlEntrust();
        autoControlEntrust.setId(id);
        autoControlEntrust.setInspectStatus(Integer.valueOf(status).byteValue());
        return autoControlEntrustMapper.updateByPrimaryKeySelective(autoControlEntrust);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveInspect(AutoControlInspectDto autoControlInspectDto) {
        if (autoControlInspectDto.getTestNumber() == 0) {
            throw new BaseException(CommonEnum.ResponseEnum.INSPECT_TESTNUMBER_IS_ZERO);
        }
        // 不合格原因
        AutoControlInspectHistory history = new AutoControlInspectHistory();
        BeanUtils.copyProperties(autoControlInspectDto, history);
        boolean isEmpty = CollectionUtils.isEmpty(autoControlInspectDto.getReasonList());
        if (!isEmpty) {
            int unqualifiedNum = autoControlInspectDto.getReasonList().stream().mapToInt(InspectReason::getNumber).sum();
            autoControlInspectDto.setUnqualifiedNumber(unqualifiedNum);
            history.setUnqualifiedNumber(unqualifiedNum);
            history.setReasons(JSON.toJSONString(autoControlInspectDto.getReasonList()));
        } else {
            autoControlInspectDto.setUnqualifiedNumber(0);
            history.setUnqualifiedNumber(0);
        }
        if (autoControlInspectDto.getQualifiedNumber() + autoControlInspectDto.getUnqualifiedNumber() != autoControlInspectDto.getTestNumber()) {
            throw new BaseException(CommonEnum.ResponseEnum.INSPECT_RECORD_DATA_ERROR);
        }
        // 质检附件
        if (!CollectionUtils.isEmpty(autoControlInspectDto.getAccessoryList())) {
            history.setAccessory(JSON.toJSONString(autoControlInspectDto.getAccessoryList()));
        }
        AutoControlEntrust entrust = autoControlEntrustMapper.selectByPrimaryKey(autoControlInspectDto.getAutoControlId());
        entrust.setQualifiedNumber(entrust.getQualifiedNumber() + autoControlInspectDto.getQualifiedNumber());
        if (entrust.getQty() < entrust.getQualifiedNumber()) {
            throw new BaseException(CommonEnum.ResponseEnum.ENTRUST_QUALIFIED_NUMBER_ERROR);
        }
        autoControlEntrustMapper.updateByPrimaryKeySelective(entrust);
        return inspectHistoryMapper.insertSelective(history);
    }

    @Override
    public List<AutoControlInspectHistoryDto> getInspectList(String no) {
        AutoControlInspectHistoryExample inspectHistoryExample = new AutoControlInspectHistoryExample();
        inspectHistoryExample.createCriteria().andNoEqualTo(no);
        List<AutoControlInspectHistory> inspectHistories = inspectHistoryMapper.selectByExample(inspectHistoryExample);
        List<AutoControlInspectHistoryDto> autoControlInspectHistoryDtos = new ArrayList<>(inspectHistories.size());
        for (AutoControlInspectHistory history : inspectHistories) {
            AutoControlInspectHistoryDto dto = new AutoControlInspectHistoryDto();
            BeanUtils.copyProperties(history, dto);
            if (StringUtils.isNotEmpty(history.getAccessory())) {
                dto.setAccessoryList(JSON.parseArray(history.getAccessory(), Accessory.class));
            }
            if (StringUtils.isNotEmpty(history.getReasons())) {
                dto.setReasonList(JSON.parseArray(history.getReasons(), InspectReason.class));
            } else if (history.getUnqualifiedNumber() > 0) {
                dto.setReasonList(Collections.singletonList(new InspectReason(history.getRemark(), history.getUnqualifiedNumber())));
            } else {
                dto.setReasonList(Collections.emptyList());
            }
            autoControlInspectHistoryDtos.add(dto);
        }
        return autoControlInspectHistoryDtos;
    }
}
