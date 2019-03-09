package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.model.dto.storage.EntryMaterialStorageDTO;
import com.deepsoft.haolifa.model.dto.storage.EntryProductStorageDTO;
import com.deepsoft.haolifa.model.dto.storage.OutMaterialStorageDTO;
import com.deepsoft.haolifa.model.dto.storage.OutProductStorageDTO;
import com.deepsoft.haolifa.model.dto.stormRoom.StoreRoomRackRequestDTO;
import com.deepsoft.haolifa.model.dto.stormRoom.StoreRoomRequestDTO;
import com.deepsoft.haolifa.service.EntryOutStoreRecordService;
import com.deepsoft.haolifa.service.StockService;
import com.deepsoft.haolifa.service.StoreRoomRackService;
import com.deepsoft.haolifa.service.StoreRoomService;
import io.swagger.annotations.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation("批次号列表（根据库房，库位，零件图号），用于零件出库选择批次号")
    @GetMapping("/material-batch-nos/{roomNo}/{rackNo}/{materialGraphNo}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roomNo", value = "库房No", dataType = "String", paramType = "path", required = true),
            @ApiImplicitParam(name = "rackNo", value = "库位No", dataType = "String", paramType = "path", required = true),
            @ApiImplicitParam(name = "materialGraphNo", value = "零件图号", dataType = "String", paramType = "path", required = true)
    })
    public ResultBean getMaterialBatchNos(@PathVariable String roomNo, @PathVariable String rackNo, @PathVariable String materialGraphNo) {
        return new ResultBean(stockService.listMaterialBatchNos(roomNo, rackNo, materialGraphNo));
    }


    @ApiOperation("成品入库")
    @PutMapping("/entryOut/entryProduct")
    public ResultBean updateRack(@RequestBody EntryProductStorageDTO model) {
        if (StringUtils.isAnyBlank(model.getProductNo())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        return ResultBean.success(entryOutStoreRecordService.entryProduct(model));
    }

    @ApiOperation("成品出库")
    @PutMapping("/entryOut/outProduct")
    public ResultBean updateRack(@RequestBody OutProductStorageDTO model) {
        if (StringUtils.isAnyBlank(model.getProductNo())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        return ResultBean.success(entryOutStoreRecordService.outProduct(model));
    }

    @ApiOperation("零件入库")
    @PutMapping("/entryOut/entryMaterial")
    public ResultBean updateRack(@RequestBody EntryMaterialStorageDTO model) {
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
    public ResultBean updateRack(@RequestBody OutMaterialStorageDTO model) {
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

}
