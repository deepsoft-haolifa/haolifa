package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.extend.MyPermissionMapper;
import com.deepsoft.haolifa.model.dto.CustomPermission;
import com.deepsoft.haolifa.model.dto.PermissionNode;
import com.deepsoft.haolifa.service.PermissionService;
import com.deepsoft.haolifa.service.SysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private MyPermissionMapper myPermissionMapper;
    @Autowired
    private SysUserService userService;


    @Override
    public boolean authorized(List<GrantedAuthority> roles, String url, String permission) {
        List<CustomPermission> permissiosByRoles = myPermissionMapper.findPermissiosByRoles(
                roles.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
        return permissiosByRoles.stream().anyMatch(p -> p.getPermName().equals(permission) && p.getUrl().equals(url));
    }

    @Override
    public List<String> getMenu() {
        return
                userService.selectLoginUser().getPermissions().stream()
                .filter(p -> p.getPermName().equals("m")).map(CustomPermission::getUrl).collect(Collectors.toList());
    }

    private List<PermissionNode> generatorPermissions(List<CustomPermission> permissions){
        List<PermissionNode> permissionNodes = new ArrayList<>();
        for (CustomPermission customPermission: permissions) {
            if(customPermission.getPid() == 0){
                permissionNodes.add(getPermissionNode(customPermission, permissions));
            }
        }
        return permissionNodes;
    }

    private PermissionNode getPermissionNode(CustomPermission customPerm, List<CustomPermission> customPermissions){
        PermissionNode permissionNode = new PermissionNode();
        BeanUtils.copyProperties(customPerm, permissionNode);
        for (CustomPermission customPermission: customPermissions) {
            if(customPermission.getPid().equals(customPerm.getId())){
                permissionNode.getChild().add(getPermissionNode(customPermission, customPermissions));
            }
        }
        return permissionNode;
    }
}