package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.model.dto.storage.*;
import com.deepsoft.haolifa.model.dto.stormRoom.StoreRoomRackRequestDTO;
import com.deepsoft.haolifa.model.dto.stormRoom.StoreRoomRequestDTO;
import com.deepsoft.haolifa.model.vo.PreOutMaterialPageVo;
import com.deepsoft.haolifa.model.vo.PreOutMaterialVo;
import com.deepsoft.haolifa.service.*;
import com.github.pagehelper.Page;
import io.swagger.annotations.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"库房管理"})
@RestController
@RequestMapping("/store-room")
public class StoreRoomController {

    @Autowired
    private StoreRoomService storeRoomService;
    @Autowired
    private StoreRoomRackService storeRoomRackService;
    @Autowired
    private EntryOutStoreRecordService entryOutStoreRecordService;
    @Autowired
    private StockService stockService;

    @Autowired
    private MaterialRequisitionService materialRequisitionService;

    @ApiOperation("新增库房信息")
    @PostMapping("/save")
    public ResultBean save(@RequestBody StoreRoomRequestDTO model) {
        return storeRoomService.saveInfo(model);
    }

    @ApiOperation("更新库房信息")
    @PutMapping("/update")
    public ResultBean update(@RequestBody StoreRoomRequestDTO model) {
        return storeRoomService.updateInfo(model);
    }

    @ApiOperation("删除库房信息")
    @ApiImplicitParam(name = "id", value = "库房id", dataType = "int", paramType = "path", required = true)
    @DeleteMapping("/delete/{id}")
    public ResultBean delete(@PathVariable int id) {
        return storeRoomService.delete(id);
    }


    @ApiOperation("获取库房详情")
    @ApiImplicitParam(name = "id", value = "库房id", dataType = "int", paramType = "path", required = true)
    @GetMapping("/getInfo/{id}")
    public ResultBean getInfo(@PathVariable int id) {
        return ResultBean.success(storeRoomService.getInfo(id));
    }

    @ApiOperation("获取库房列表")
    @ApiImplicitParam(name = "type", value = "库房类型（0.所有库；1.原料库；2：成品库；）", dataType = "int", paramType = "query")
    @GetMapping("/listInfo")
    public ResultBean listInfo(@RequestParam int type) {
        return storeRoomService.listInfo(type);
    }


    @ApiOperation("获取库房分页列表")
    @ApiImplicitParams({
        @ApiImplicitParam(required = true, value = "当前页面", name = "currentPage", dataType = "int", paramType = "query"),
        @ApiImplicitParam(required = true, value = "每页数量", name = "pageSize", dataType = "int", paramType = "query"),
        @ApiImplicitParam(value = "库房名称", name = "nameLike", dataType = "string", paramType = "query"),
        @ApiImplicitParam(value = "库房类型（0所有，1原料库；2成品库）", name = "type", dataType = "int", paramType = "query"),
    })
    @GetMapping("/pageInfo")
    public ResultBean pageInfo(@RequestParam(defaultValue = "1") Integer currentPage,
                               @RequestParam(defaultValue = "20") Integer pageSize,
                               @RequestParam(required = false) String nameLike,
                               @RequestParam(required = false) Byte type) {
        return storeRoomService.pageInfo(currentPage, pageSize, nameLike, type);
    }


    @ApiOperation("新增库房库位")
    @PostMapping("/rack/save")
    public ResultBean saveRack(@RequestBody StoreRoomRackRequestDTO model) {
        return storeRoomRackService.saveRackInfo(model);
    }

    @ApiOperation("更新库房库位")
    @PutMapping("/rack/update")
    public ResultBean updateRack(@RequestBody StoreRoomRackRequestDTO model) {
        return storeRoomRackService.updateRackInfo(model);
    }

    @ApiOperation("删除库房库位")
    @DeleteMapping("/rack/delete/{id}")
    @ApiImplicitParam(name = "id", value = "库房货位id", dataType = "int", paramType = "path", required = true)
    public ResultBean deleteRack(@PathVariable int id) {
        return storeRoomRackService.delete(id);
    }

    @ApiOperation("获取库房库位详情")
    @DeleteMapping("/rack/getInfo/{id}")
    @ApiImplicitParam(name = "id", value = "库房货位id", dataType = "int", paramType = "path", required = true)
    public ResultBean getListRack(@PathVariable int id) {
        return new ResultBean(storeRoomRackService.getInfo(id));
    }

    @ApiOperation("库位列表（根据库房No）")
    @GetMapping("/rack/list/{roomNo}")
    @ApiImplicitParam(name = "roomNo", value = "库房No", dataType = "String", paramType = "path", required = true)
    public ResultBean getListByStormNo(@PathVariable String roomNo) {
        return new ResultBean(storeRoomRackService.getListByRoomNo(roomNo));
    }


    @ApiOperation("获取库位分页列表")
    @ApiImplicitParams({
        @ApiImplicitParam(required = true, value = "当前页面", name = "currentPage", dataType = "int", paramType = "query"),
        @ApiImplicitParam(required = true, value = "每页数量", name = "pageSize", dataType = "int", paramType = "query"),
        @ApiImplicitParam(value = "库房号", name = "roomNo", dataType = "string", paramType = "query"),
        @ApiImplicitParam(value = "库位名称", name = "rackNameLike", dataType = "string", paramType = "query")
    })
    @GetMapping("/rack/pageInfo")
    public ResultBean pageRackInfo(@RequestParam(defaultValue = "1") Integer currentPage,
                                   @RequestParam(defaultValue = "20") Integer pageSize,
                                   @RequestParam(required = false) String roomNo,
                                   @RequestParam(required = false) String rackNameLike) {
        return storeRoomRackService.pageRackInfo(currentPage, pageSize, roomNo, rackNameLike);
    }

    @ApiOperation("批次号列表（根据库房，库位，零件图号），用于零件出库，喷涂等选择批次号")
    @GetMapping("/material-batch-nos")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "roomNo", value = "库房No", dataType = "String", paramType = "query", required = false),
        @ApiImplicitParam(name = "rackNo", value = "库位No", dataType = "String", paramType = "query", required = false),
        @ApiImplicitParam(name = "graphNo", value = "零件图号", dataType = "String", paramType = "query", required = true)
    })
    public ResultBean<List<MaterialBatchNoDTO>> getMaterialBatchNos(@RequestParam(required = false) String roomNo, @RequestParam(required = false) String rackNo, @RequestParam String graphNo) {
        return new ResultBean(stockService.listMaterialBatchNos(roomNo, rackNo, graphNo));
    }


    @ApiOperation("批次号列表")
    @PostMapping("/batch-no-list")
    public ResultBean<List<MaterialBatchNoDTO>> batchNoList(@RequestBody BatchNoListDTO dto) {
        return new ResultBean(stockService.batchListNo(dto));
    }


    @ApiOperation("成品入库")
    @PutMapping("/entryOut/entryProduct")
    public ResultBean entryProduct(@RequestBody EntryProductStorageDTO model) {
        if (StringUtils.isAnyBlank(model.getProductNo())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        return ResultBean.success(entryOutStoreRecordService.entryProduct(model));
    }

    @ApiOperation("成品出库")
    @PutMapping("/entryOut/outProduct")
    public ResultBean outProduct(@RequestBody OutProductStorageDTO model) {
        if (StringUtils.isAnyBlank(model.getProductNo())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        return entryOutStoreRecordService.outProduct(model);
    }

    @ApiOperation("成品出库已经数量")
    @PutMapping("/entryOut/outProduct-already-count")
    public ResultBean outProductAlreadyCount(@RequestBody ProductStorageDto model) {
        if (StringUtils.isAnyBlank(model.getProductNo(), model.getOrderNo())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        return ResultBean.success(entryOutStoreRecordService.getOutProductCountByOrderNo(model.getOrderNo(), model.getProductNo()));
    }

    @ApiOperation("零件入库")
    @PutMapping("/entryOut/entryMaterial")
    public ResultBean entryMaterial(@RequestBody EntryMaterialStorageDTO model) {
        if (StringUtils.isAnyBlank(model.getMaterialGraphNo())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        int result = entryOutStoreRecordService.entryMaterial(model);
        if (result > 0) {
            return ResultBean.success(result);
        } else {
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }

    @ApiOperation("零件出库")
    @PutMapping("/entryOut/outMaterial")
    public ResultBean outMaterial(@RequestBody OutMaterialStorageDTO model) {
        if (StringUtils.isAnyBlank(model.getMaterialGraphNo())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        int result = entryOutStoreRecordService.outMaterial(model);
        if (result > 0) {
            return ResultBean.success(result);
        } else {
            return ResultBean.error(CommonEnum.ResponseEnum.MATERIAL_NOT_ENOUGH);
        }
    }


    @ApiOperation("获取零件，成品出入库分页列表")
    @ApiImplicitParams({
        @ApiImplicitParam(value = "类型：0.全部;1.成品；2：零件;", name = "type", dataType = "int", paramType = "query", required = true),
        @ApiImplicitParam(value = "操作类型：0.全部;1.出库；2：入库;", name = "operationType", dataType = "int", paramType = "query", required = true),
        @ApiImplicitParam(value = "产品号", name = "productNo", dataType = "string", paramType = "query"),
        @ApiImplicitParam(value = "零件图号", name = "materialGraphNo", dataType = "string", paramType = "query"),
        @ApiImplicitParam(value = "订单号", name = "orderNo", dataType = "string", paramType = "query"),
        @ApiImplicitParam(value = "当前页面", name = "currentPage", dataType = "int", paramType = "query", required = true),
        @ApiImplicitParam(value = "每页数量", name = "pageSize", dataType = "int", paramType = "query", required = true)
    })
    @GetMapping("/entryOut/pageInfo")
    public ResultBean pageInfoEntryOutRecord(@RequestParam(defaultValue = "1") Integer currentPage,
                                             @RequestParam(defaultValue = "20") Integer pageSize,
                                             @RequestParam Integer type,
                                             @RequestParam Integer operationType,
                                             @RequestParam(required = false) String productNo,
                                             @RequestParam(required = false) String materialGraphNo,
                                             @RequestParam(required = false) String orderNo) {
        return entryOutStoreRecordService.pageInfoEntryOutRecord(currentPage, pageSize, type, operationType, productNo, materialGraphNo, orderNo);
    }


    @PostMapping("/pre-material-out/page")
    @ApiOperation("零件待出库列表")
    public ResultBean<Page<PreOutMaterialVo>> pageInfoEntryOutRecord(@RequestBody PreOutMaterialPageVo preOutMaterialPageVo) {
        return ResultBean.success(materialRequisitionService.preOutMaterialPage(preOutMaterialPageVo));
    }


}
