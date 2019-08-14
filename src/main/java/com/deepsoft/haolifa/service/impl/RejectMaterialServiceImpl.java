package com.deepsoft.haolifa.service.impl;

import static com.deepsoft.haolifa.constant.CacheKey.REJECT_MATERIAL_NO_KEY;
import static com.deepsoft.haolifa.constant.Constant.SerialNumberPrefix.REJECT_MATERIAL_NO_PREFIX_BHG;

import com.deepsoft.haolifa.constant.CommonEnum.ResponseEnum;
import com.deepsoft.haolifa.dao.repository.RejectMaterialRecordMapper;
import com.deepsoft.haolifa.model.domain.RejectMaterialRecord;
import com.deepsoft.haolifa.model.domain.RejectMaterialRecordExample;
import com.deepsoft.haolifa.model.dto.BaseException;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.rejectMaterial.RejectMaterialListDto;
import com.deepsoft.haolifa.model.dto.rejectMaterial.RejectMaterialSaveDto;
import com.deepsoft.haolifa.service.RejectMaterialService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
@Slf4j
public class RejectMaterialServiceImpl extends BaseService implements RejectMaterialService {

  @Autowired
  private RejectMaterialRecordMapper rejectMaterialRecordMapper;

  @Override
  public ResultBean save(RejectMaterialSaveDto dto) {
    if (StringUtils.isAnyBlank(dto.getBatchNumber(), dto.getMaterialGraphNo(), dto.getPurchaseOrderNo())
        || dto.getNumber() == null || dto.getNumber() == 0) {
      throw new BaseException(ResponseEnum.PARAM_ERROR);
    }
    RejectMaterialRecord rejectMaterialRecord = new RejectMaterialRecord();
    BeanUtils.copyProperties(dto, rejectMaterialRecord);
    rejectMaterialRecord.setCreateUserId(getLoginUserId());
    rejectMaterialRecord.setRecordNo(createSerialNumber(REJECT_MATERIAL_NO_PREFIX_BHG, REJECT_MATERIAL_NO_KEY));
    rejectMaterialRecord.setStatus(dto.getStatus().byteValue());
    rejectMaterialRecordMapper.insertSelective(rejectMaterialRecord);
    return ResultBean.success(rejectMaterialRecord.getId());
  }

  @Override
  public ResultBean delete(String recordNo) {
    RejectMaterialRecordExample recordExample = new RejectMaterialRecordExample();
    recordExample.createCriteria().andRecordNoEqualTo(recordNo);
    rejectMaterialRecordMapper.deleteByExample(recordExample);
    return ResultBean.success(1);
  }

  @Override
  public ResultBean updateRecordStatus(String recordNo, Integer status) {
    RejectMaterialRecordExample recordExample = new RejectMaterialRecordExample();
    recordExample.createCriteria().andRecordNoEqualTo(recordNo);
    RejectMaterialRecord record = new RejectMaterialRecord();
    record.setStatus(status.byteValue());
    rejectMaterialRecordMapper.updateByExampleSelective(record, recordExample);
    return ResultBean.success(1);
  }

  @Override
  public ResultBean info(String recordNo) {
    RejectMaterialRecordExample recordExample = new RejectMaterialRecordExample();
    recordExample.createCriteria().andRecordNoEqualTo(recordNo);
    List<RejectMaterialRecord> rejectMaterialRecords = rejectMaterialRecordMapper.selectByExample(recordExample);
    if (CollectionUtils.isEmpty(rejectMaterialRecords)) {
      return ResultBean.success(null);
    }
    return ResultBean.success(rejectMaterialRecords.get(0));
  }

  @Override
  public ResultBean list(RejectMaterialListDto listDto) {
    RejectMaterialRecordExample recordExample = new RejectMaterialRecordExample();
    RejectMaterialRecordExample.Criteria criteria = recordExample.createCriteria();
    if (StringUtils.isNotEmpty(listDto.getBatchNumber())) {
      criteria.andBatchNumberLike("%" + listDto.getBatchNumber() + "%");
    }
    if (StringUtils.isNotEmpty(listDto.getMaterialGraphNo())) {
      criteria.andMaterialGraphNoLike("%" + listDto.getMaterialGraphNo() + "%");
    }
    if (StringUtils.isNotEmpty(listDto.getPurchaseOrderNo())) {
      criteria.andPurchaseOrderNoLike("%" + listDto.getPurchaseOrderNo() + "%");
    }
    recordExample.setOrderByClause("id desc");
    Page<RejectMaterialRecord> rejectMaterialRecordPage = PageHelper.startPage(listDto.getPageNum(), listDto.getPageSize()).doSelectPage(() -> {
      rejectMaterialRecordMapper.selectByExample(recordExample);
    });
    PageDTO<RejectMaterialRecord> rejectMaterialRecordPageDTO = new PageDTO<>();
    BeanUtils.copyProperties(rejectMaterialRecordPage, rejectMaterialRecordPageDTO);
    rejectMaterialRecordPageDTO.setList(rejectMaterialRecordPage.getResult());
    return ResultBean.success(rejectMaterialRecordPageDTO);
  }
}
