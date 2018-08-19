package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.service.ProductService;
import com.deepsoft.haolifa.service.StoreRoomRackService;
import com.deepsoft.haolifa.service.StoreRoomService;
import io.swagger.annotations.*;
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


    @ApiOperation("新增库房库位信息")
    @PostMapping("/saveRack")
    public ResultBean saveRack(@RequestBody StoreRoomRackRequestDTO model) {
        return storeRoomRackService.saveRackInfo(model);
    }

    @ApiOperation("更新库房货位信息")
    @PutMapping("/updateRack")
    public ResultBean updateRack(@RequestBody StoreRoomRackRequestDTO model) {
        return storeRoomRackService.updateRackInfo(model);
    }

    @ApiOperation("删除库房货位信息")
    @DeleteMapping("/deleteRack/{id}")
    @ApiImplicitParam(name = "id", value = "库房货位id", dataType = "int", paramType = "path", required = true)
    public ResultBean deleteRack(@PathVariable int id) {
        return storeRoomRackService.delete(id);
    }

    @ApiOperation("获取库房货位分页列表")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "库房Id", name = "roomId", dataType = "int", paramType = "query"),
            @ApiImplicitParam(required = true, value = "当前页面", name = "currentPage", dataType = "int", paramType = "query"),
            @ApiImplicitParam(required = true, value = "每页数量", name = "pageSize", dataType = "int", paramType = "query")
    })
    @GetMapping("/pageRackInfo")
    public ResultBean pageRackInfo(@RequestParam(defaultValue = "1") Integer currentPage,
                                   @RequestParam(defaultValue = "20") Integer pageSize,
                                   @RequestParam(required = false) Integer roomId) {
        return storeRoomRackService.pageRackInfo(currentPage, pageSize, roomId);
    }


}
