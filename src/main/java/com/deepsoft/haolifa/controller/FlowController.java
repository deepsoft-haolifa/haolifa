package com.deepsoft.haolifa.controller;


import com.deepsoft.haolifa.model.dto.AllotPersonsDTO;
import com.deepsoft.haolifa.model.dto.AllotRolesDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.FlowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "流程管理")
@RestController
@RequestMapping("/flow")
public class FlowController {

  @Autowired
  private FlowService flowService;

  @ApiOperation("查询流程列表")
  @GetMapping("/list")
  public ResultBean list() {
    return flowService.list();
  }

  @ApiOperation("获取流程节点列表")
  @GetMapping("/steps/{flowId}")
  public ResultBean steps(@ApiParam("流程id") @PathVariable("flowId") int flowId) {
    return flowService.steps(flowId);
  }

  @ApiOperation("分配流程节点审核角色")
  @PostMapping("allotRoles")
  public ResultBean allotRoles(@RequestBody AllotRolesDTO model) {
    return flowService.allotRoles(model);
  }

  @ApiOperation("分配流程节点审核人")
  @PostMapping("allotPersons")
  public ResultBean allotPersons(@RequestBody AllotPersonsDTO model) {
    return flowService.allotPersons(model);
  }

  @ApiOperation("获取角色列表")
  @GetMapping("/roles")
  public ResultBean roles() {
    return flowService.roles();
  }

  @ApiOperation("获取某一角色下用户列表")
  @GetMapping("/users/{roleId}")
  public ResultBean users(@ApiParam("角色id") @PathVariable("roleId") int roleId) {
    return flowService.users(roleId);
  }
}
