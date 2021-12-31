package com.deepsoft.haolifa.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.MaterialRequisitionMapper;
import com.deepsoft.haolifa.dao.repository.extend.CommonExtendMapper;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.BaseException;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.storage.BatchNoListDTO;
import com.deepsoft.haolifa.model.dto.storage.MaterialBatchNoDTO;
import com.deepsoft.haolifa.model.dto.storage.OutMaterialStorageDTO;
import com.deepsoft.haolifa.model.dto.stormRoom.WholeOutboundReqDTO;
import com.deepsoft.haolifa.model.vo.PreOutMaterialPageVo;
import com.deepsoft.haolifa.model.vo.PreOutMaterialVo;
import com.deepsoft.haolifa.service.*;
import com.deepsoft.haolifa.util.RandomUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 领料单表 服务实现类
 * </p>
 *
 * @author murphy.he
 * @since 2019-11-23
 */
@Service
@Slf4j
public class MaterialRequisitionServiceImpl implements MaterialRequisitionService {

    @Resource
    private MaterialService materialService;
    @Resource
    private OrderProductService orderProductService;
    @Resource
    private EntryOutStoreRecordService entryOutStoreRecordService;
    @Resource
    private StockService stockService;
    @Resource
    private MaterialRequisitionMapper materialRequisitionMapper;
    @Resource
    private CommonExtendMapper commonExtendMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addBatch(List<MaterialRequisition> list) {
        // 判断图号是否在图号库中
        String orderNo = "";
        for (MaterialRequisition materialRequisition : list) {
            orderNo = materialRequisition.getOrderNo();
            String graphNo = materialRequisition.getGraphNo();
            boolean existsGraphNo = materialService.existsGraphNo(graphNo);
            if (!existsGraphNo) {
                throw new BaseException(CommonEnum.ResponseEnum.MATERIAL_GRAPH_NO_NOT_EXIST_1, (Object) graphNo);
            }
        }
        // 判断是否已经保存过领料单
        MaterialRequisitionExample materialRequisitionExample = new MaterialRequisitionExample();
        materialRequisitionExample.or().andOrderNoEqualTo(orderNo);
        int count = materialRequisitionMapper.countByExample(materialRequisitionExample);
        if (count > 0) {
            throw new BaseException(CommonEnum.ResponseEnum.MATERIAL_REQUISITION_EXIST);
        }

        for (MaterialRequisition materialRequisition : list) {
            materialRequisition.setRequisitionNo("ll_" + RandomUtils.orderNoStr());
            materialRequisition.setOutRoomStatus(CommonEnum.OutRoomStatus.NOT_OUT.type);
            materialRequisitionMapper.insertSelective(materialRequisition);
        }

        // 将订单的 是否生成领料单状态修改
        orderProductService.updateGenPickList(orderNo, CommonEnum.Consts.YES.code);

        return true;
    }

    @Override
    public List<MaterialRequisition> detailList(String orderNo) {
        MaterialRequisitionExample example = new MaterialRequisitionExample();
        example.or().andOrderNoEqualTo(orderNo);
        List<MaterialRequisition> materialRequisitions = materialRequisitionMapper.selectByExample(example);
        return materialRequisitions;
    }

    @Override
    public PageDTO<PreOutMaterialVo> preOutMaterialPage(PreOutMaterialPageVo vo) {
        Page<PreOutMaterialVo> preOutMaterialVos = PageHelper.startPage(vo.getPageNum(), vo.getPageSize())
            .doSelectPage(() -> commonExtendMapper.pagePreOutMaterial(vo));

        PageDTO<PreOutMaterialVo> pageDTO = new PageDTO();
        BeanUtils.copyProperties(preOutMaterialVos, pageDTO);
        pageDTO.setList(preOutMaterialVos);
        return pageDTO;
    }

    @Override
    public int wholeOutbound(WholeOutboundReqDTO reqDTO) {
        int result;
        String busNo = reqDTO.getBusNo();
        Byte type = reqDTO.getType();
        List<String> busNoList = Arrays.asList(StrUtil.split(busNo, StrUtil.COMMA));
        if (CommonEnum.materialOutType.MATERIAL_REQUISITION.type == type) {
            result = handleMaterialRequisition(busNoList, reqDTO);
        } else {
            throw new BaseException("暂不支持此类型的整单出库，敬请期待");
        }
        return result;
    }

    private int handleMaterialRequisition(List<String> busNoList, WholeOutboundReqDTO reqDTO) {
        int result = 0;
        MaterialRequisitionExample example = new MaterialRequisitionExample();
        example.or().andOrderNoIn(busNoList).andOutRoomStatusEqualTo(CommonEnum.OutRoomStatus.NOT_OUT.type);
        List<MaterialRequisition> materialRequisitions = materialRequisitionMapper.selectByExample(example);
        if (CollectionUtil.isEmpty(materialRequisitions)) {
            throw new BaseException("没有找到未出库的订单号");
        }
        // 获取每个零件的单价
        Map<String, BigDecimal> materialPriceMap = this.mapMaterialPrice(materialRequisitions.stream().map(MaterialRequisition::getGraphNo).collect(Collectors.toSet()));
        for (MaterialRequisition materialRequisition : materialRequisitions) {
            try {
                OutMaterialStorageDTO outMaterialStorageDTO = new OutMaterialStorageDTO();
                outMaterialStorageDTO.setMaterialGraphNo(materialRequisition.getGraphNo());
                outMaterialStorageDTO.setType(CommonEnum.materialOutType.MATERIAL_REQUISITION.type);
                outMaterialStorageDTO.setReceiveDepartment(reqDTO.getReceiveDepartment());
                outMaterialStorageDTO.setBusId(materialRequisition.getId());
                outMaterialStorageDTO.setBusNo(materialRequisition.getOrderNo());
                outMaterialStorageDTO.setOrderNo(materialRequisition.getOrderNo());
                outMaterialStorageDTO.setQuantity(materialRequisition.getQuantity());
                outMaterialStorageDTO.setPrice(materialPriceMap.getOrDefault(materialRequisition.getGraphNo(), null));
                //获取batchNoList
                BatchNoListDTO batchNoListDTO = new BatchNoListDTO();
                batchNoListDTO.setQty(materialRequisition.getQuantity());
                batchNoListDTO.setGraphNo(materialRequisition.getGraphNo());
                List<MaterialBatchNoDTO> batchNoList = stockService.batchListNo(batchNoListDTO);
                if (CollectionUtil.isEmpty(batchNoList)) {
                    log.error("whole out bound out no stock:{}", JSONUtil.toJsonStr(outMaterialStorageDTO));
                    continue;
                }
                outMaterialStorageDTO.setBatchNoDTOList(batchNoList);
                int i = entryOutStoreRecordService.outMaterial(outMaterialStorageDTO);
                if (i < 1) {
                    log.error("whole out bound out material error:{}", JSONUtil.toJsonStr(outMaterialStorageDTO));
                }
                result++;
            } catch (Exception e) {
                log.error("whole out bound out material exception:", e);
            }
        }
        return result;
    }

    private Map<String, BigDecimal> mapMaterialPrice(Set<String> graphNoList) {
        List<Material> materials = materialService.listByGraphNos(new ArrayList<>(graphNoList));
        return materials.stream().collect(Collectors.toMap(Material::getGraphNo, Material::getPrice));
    }


}
