package com.deepsoft.haolifa.controller;


import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.model.domain.SysDict;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.SysDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = {"系统字典数据"})
@RestController
@RequestMapping("/sys-dict")
public class SysDictController {

    @Autowired
    private SysDictService sysDictService;


    @ApiOperation("根据字典类型获取列表")
    @GetMapping("/getDictListByType/{typeCode}")
    public ResultBean getDictListByType(@PathVariable("typeCode") String typeCode) {

        List<SysDict> sysDictByTypeCode = sysDictService.getSysDictByTypeCode(typeCode);
        List<Map<String, Object>> list = new ArrayList<>();
        if (sysDictByTypeCode.size() > 0) {
            for (SysDict sysDict : sysDictByTypeCode) {
                Map<String, Object> map = new HashMap<>();
                map.put("code", sysDict.getCode());
                map.put("desc", sysDict.getName());
                list.add(map);
            }
        }
        return ResultBean.success(list);
    }

}
