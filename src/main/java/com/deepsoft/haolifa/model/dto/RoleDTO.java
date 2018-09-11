package com.deepsoft.haolifa.model.dto;

import lombok.Data;

@Data
public class RoleDTO {

    private Integer id;

    private DepartmentDTO department;

    private String roleName;

    private String description;

}
