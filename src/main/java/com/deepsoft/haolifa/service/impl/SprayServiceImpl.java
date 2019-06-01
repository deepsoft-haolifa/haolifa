package com.deepsoft.haolifa.service.impl;

import static com.deepsoft.haolifa.constant.CacheKey.SPRAY_NO_KEY;
import static com.deepsoft.haolifa.constant.Constant.SerialNumberPrefix.SPRAY_NO_PREFIX_PT;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.constant.CommonEnum.ResponseEnum;
import com.deepsoft.haolifa.dao.repository.SprayItemMapper;
import com.deepsoft.haolifa.dao.repository.SprayMapper;
import com.deepsoft.haolifa.dao.repository.SprayInspectHistoryMapper;
import com.deepsoft.haolifa.model.domain.Spray;
import com.deepsoft.haolifa.model.domain.SprayExample;
import com.deepsoft.haolifa.model.domain.SprayItem;
import com.deepsoft.haolifa.model.domain.SprayItemExample;
import com.deepsoft.haolifa.model.domain.SprayInspectHistory;
import com.deepsoft.haolifa.model.domain.SprayInspectHistoryExample;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.spray.SprayDto;
import com.deepsoft.haolifa.model.dto.spray.SprayInspectDto;
import com.deepsoft.haolifa.model.dto.spray.SprayInspectListDto;
import com.deepsoft.haolifa.model.dto.spray.SprayItemDto;
import com.deepsoft.haolifa.model.dto.spray.SprayListDto;
import com.deepsoft.haolifa.service.SprayService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SprayServiceImpl extends BaseService implements SprayService {


  @Autowired
  private SprayMapper sprayMapper;

  @Autowired
  private SprayItemMapper sprayItemMapper;

  @Autowired
  private SprayInspectHistoryMapper inspectHistoryMapper;

  @Transactional(rollbackFor = Exception.class)
  @Override
  public ResultBean save(SprayDto sprayDto) {
    if (sprayDto.getItems().isEmpty()) {
      return ResultBean.error(ResponseEnum.PARAM_ERROR);
    }
    String sprayNo = createSerialNumber(SPRAY_NO_PREFIX_PT, SPRAY_NO_KEY);
    Spray spray = new Spray();
    spray.setSprayNo(sprayNo);
    spray.setPlanner(sprayDto.getPlanner());
    spray.setTotalNumber(0);
    sprayMapper.insertSelective(spray);
    sprayDto.getItems().forEach(sprayItemDto -> {
      SprayItem sprayItem = new SprayItem();
      BeanUtils.copyProperties(sprayItemDto, sprayItem);
      sprayItem.setSprayNo(sprayNo);
      spray.setTotalNumber(spray.getTotalNumber() + sprayItemDto.getNumber());
      sprayItemMapper.insertSelective(sprayItem);
    });
    SprayExample sprayExample = new SprayExample();
    sprayExample.createCriteria().andSprayNoEqualTo(sprayNo);
    sprayMapper.updateByExampleSelective(spray, sprayExample);
    return ResultBean.success(sprayNo);
  }

  @Async("threadPoolTaskExecutor")
  public void createSprayFormFile(SprayDto sprayDto) {

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("喷涂委托单");
//    QiniuUtil.uploadFile();

  }

  @Transactional(rollbackFor = Exception.class)
  @Override
  public ResultBean delete(String sprayNo) {
    SprayExample sprayExample = new SprayExample();
    sprayExample.createCriteria().andSprayNoEqualTo(sprayNo);
    sprayMapper.deleteByExample(sprayExample);
    SprayItemExample itemExample = new SprayItemExample();
    itemExample.createCriteria().andSprayNoEqualTo(sprayNo);
    sprayItemMapper.deleteByExample(itemExample);
    return ResultBean.success(1);
  }

  @Transactional(rollbackFor = Exception.class)
  @Override
  public ResultBean update(SprayDto sprayDto) {
    SprayItemExample itemExample = new SprayItemExample();
    itemExample.createCriteria().andSprayNoEqualTo(sprayDto.getSprayNo());
    Spray spray = new Spray();
    spray.setPlanner(sprayDto.getPlanner());
    SprayExample example = new SprayExample();
    example.createCriteria().andSprayNoEqualTo(sprayDto.getSprayNo());
    sprayItemMapper.deleteByExample(itemExample);
    spray.setTotalNumber(0);
    sprayDto.getItems().forEach(sprayItemDto -> {
      SprayItem sprayItem = new SprayItem();
      BeanUtils.copyProperties(sprayItemDto, sprayItem);
      sprayItem.setSprayNo(sprayDto.getSprayNo());
      spray.setTotalNumber(spray.getTotalNumber() + sprayItemDto.getNumber());
      sprayItemMapper.insertSelective(sprayItem);
    });
    sprayMapper.updateByExampleSelective(spray, example);
    return ResultBean.success(1);
  }

  @Override
  public ResultBean getSprayInfo(String sprayNo) {
    SprayExample sprayExample = new SprayExample();
    sprayExample.createCriteria().andSprayNoEqualTo(sprayNo);
    Spray spray = sprayMapper.selectByExample(sprayExample).get(0);
    SprayDto sprayDto = new SprayDto();
    BeanUtils.copyProperties(spray, sprayDto);
    SprayItemExample itemExample = new SprayItemExample();
    itemExample.createCriteria().andSprayNoEqualTo(spray.getSprayNo());
    List<SprayItem> sprayItems = sprayItemMapper.selectByExample(itemExample);
    List<SprayItemDto> sprayItemDtos = new ArrayList<>();
    sprayItems.forEach(sprayItem -> {
      SprayItemDto sprayItemDto = new SprayItemDto();
      BeanUtils.copyProperties(sprayItem, sprayItemDto);
      sprayItemDtos.add(sprayItemDto);
    });
    sprayDto.setItems(sprayItemDtos);
    return ResultBean.success(sprayDto);
  }

  @Override
  public ResultBean forms(SprayListDto listDto) {
    SprayExample example = new SprayExample();
    SprayExample.Criteria criteria = example.createCriteria();
    if (listDto.getStatus() != -1) {
      criteria.andStatusEqualTo(listDto.getStatus().byteValue());
    }
    // 计划管理 type=0

    // 质检管理 type =1 status in (加工中，质检完成， 加工完成)
    if (listDto.getType() == 1) {
      criteria.andStatusIn(Arrays.asList((byte) 1, (byte) 2, (byte) 3));
    }
    if (StringUtils.isNotEmpty(listDto.getSprayNo())) {
      criteria.andSprayNoLike("%" + listDto.getSprayNo() + "%");
    }
    Page<Spray> sprayList = PageHelper.startPage(listDto.getPageNum(), listDto.getPageSize(), "create_time desc")
        .doSelectPage(() -> sprayMapper.selectByExample(example));
    PageDTO<Spray> sprayPageDTOs = new PageDTO<>();
    BeanUtils.copyProperties(sprayList, sprayPageDTOs);
    sprayPageDTOs.setList(sprayList.getResult());
    return ResultBean.success(sprayPageDTOs);
  }

  @Transactional(rollbackFor = Exception.class)
  @Override
  public ResultBean updateStatus(String sprayNo, int status) {
    SprayExample example = new SprayExample();
    SprayExample.Criteria criteria = example.createCriteria();
    criteria.andSprayNoEqualTo(sprayNo);
    Spray spray = new Spray();
    spray.setStatus(Integer.valueOf(status).byteValue());
    sprayMapper.updateByExampleSelective(spray, example);
    return ResultBean.success(1);
  }

  @Override
  public ResultBean getInspectList(String sprayNo) {
    SprayInspectHistoryExample inspectHistoryExample = new SprayInspectHistoryExample();
    inspectHistoryExample.createCriteria().andSprayNoEqualTo(sprayNo);
    List<SprayInspectHistory> inspectHistories = inspectHistoryMapper.selectByExample(inspectHistoryExample);
    return ResultBean.success(inspectHistories);
  }

  @Override
  public ResultBean getItemsList(String sprayNo) {
    SprayItemExample itemExample = new SprayItemExample();
    itemExample.createCriteria().andSprayNoEqualTo(sprayNo);
    List<SprayItem> sprayItems = sprayItemMapper.selectByExample(itemExample);
    return ResultBean.success(sprayItems);
  }

  @Transactional(rollbackFor = Exception.class)
  @Override
  public ResultBean saveInspect(SprayInspectDto inspectDto) {
    if (StringUtils.isAnyBlank(inspectDto.getOriginalGraphNo(), inspectDto.getMaterialGraphNo(),
        inspectDto.getMaterialGraphName())) {
      return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
    }
    SprayInspectHistory history = new SprayInspectHistory();
    BeanUtils.copyProperties(inspectDto, history);
    SprayExample example = new SprayExample();
    example.createCriteria().andSprayNoEqualTo(inspectDto.getSprayNo());
    List<Spray> sprays = sprayMapper.selectByExample(example);
    if (sprays != null && sprays.size() > 0) {
      Spray spray = sprays.get(0);
      spray.setQualifiedNumber(spray.getQualifiedNumber() + inspectDto.getQualifiedNumber());
      sprayMapper.updateByExampleSelective(spray, example);
    }
    inspectHistoryMapper.insertSelective(history);
    return ResultBean.success(history.getId());
  }

  @Override
  public ResultBean getInspectToRooms(SprayInspectListDto inspectListDto) {
    SprayInspectHistoryExample historyExample = new SprayInspectHistoryExample();
    SprayInspectHistoryExample.Criteria criteria = historyExample.createCriteria();
    if (StringUtils.isNotEmpty(inspectListDto.getSprayNo())) {
      criteria.andSprayNoLike("%" + inspectListDto.getSprayNo() + "%");
    }
    // 0 全部
    if (inspectListDto.getStatus() != 0) {
      criteria.andStatusEqualTo(inspectListDto.getStatus().byteValue());
    }
    criteria.andQualifiedNumberGreaterThan(0);
    Page<SprayInspectHistory> page = PageHelper
        .startPage(inspectListDto.getPageNum(), inspectListDto.getPageSize())
        .doSelectPage(() -> inspectHistoryMapper.selectByExample(historyExample));
    PageDTO<SprayInspectHistory> sprayInspectHistoryPageDTO = new PageDTO<>();
    BeanUtils.copyProperties(page, sprayInspectHistoryPageDTO);
    sprayInspectHistoryPageDTO.setList(page.getResult());
    return ResultBean.success(sprayInspectHistoryPageDTO);
  }

  @Override
  public ResultBean updateHistoryStatus(Integer historyId) {
    SprayInspectHistory sprayInspectHistory = new SprayInspectHistory();
    sprayInspectHistory.setId(historyId);
    // 2 已入库
    sprayInspectHistory.setStatus((byte) 2);
    inspectHistoryMapper.updateByPrimaryKeySelective(sprayInspectHistory);
    return ResultBean.success(1);
  }

  @Override
  public ResultBean updateInspectStatus(String sprayNo, int status) {
    SprayExample example = new SprayExample();
    SprayExample.Criteria criteria = example.createCriteria();
    criteria.andSprayNoEqualTo(sprayNo);
    Spray spray = new Spray();
    spray.setInspectStatus(Integer.valueOf(status).byteValue());
    sprayMapper.updateByExampleSelective(spray, example);
    return ResultBean.success(1);
  }
}
