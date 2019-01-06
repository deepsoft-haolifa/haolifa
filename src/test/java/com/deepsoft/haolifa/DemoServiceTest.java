package com.deepsoft.haolifa;

import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.dao.repository.SysDepartmentMapper;
import com.deepsoft.haolifa.model.domain.SysDepartment;
import com.deepsoft.haolifa.model.domain.SysDepartmentExample;
import com.deepsoft.haolifa.model.domain.SysUser;
import com.deepsoft.haolifa.model.dto.sys.DepartmentTree;
import com.deepsoft.haolifa.service.DemoService;
import com.deepsoft.haolifa.util.TreeUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @className: DemoServiceTest
 * @description:
 * @author: hedong@ibeesaas.com
 * @date: 2018-07-10 17:08
 **/
public class DemoServiceTest extends BaseApplicationTests {

    @Resource
    private DemoService demoService;

    @Test
    public void test() {
        List<SysUser> list = demoService.list();
        System.out.println("123456");
    }

    @Autowired
    private SysDepartmentMapper sysDepartmentMapper;

    @Test
    public void testtree() {
        List<SysDepartment> sysDepartments = sysDepartmentMapper.selectByExample(new SysDepartmentExample());

        ;
        List<DepartmentTree> departmentTrees = new ArrayList<>();
        sysDepartments.stream().forEach(e -> {
            DepartmentTree departmentTree = new DepartmentTree();
            departmentTree.setId(String.valueOf(e.getId()));
            departmentTree.setName(e.getDeptName());
            departmentTree.setParentId(String.valueOf(e.getPid()));
            departmentTrees.add(departmentTree);

        });
        List<DepartmentTree> treeList = TreeUtils.getTreeList("0", departmentTrees);
        System.out.println(JSONObject.toJSONString(treeList));
    }

}
