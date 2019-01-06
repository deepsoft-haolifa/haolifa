package com.deepsoft.haolifa.model.dto.sys;

import com.deepsoft.haolifa.util.TreeEntity;
import lombok.Data;

import java.util.List;

@Data
public class DepartmentTree implements TreeEntity<DepartmentTree> {
    public String id;
    public String name;
    public String parentId;
    public List<DepartmentTree> childList;

}
