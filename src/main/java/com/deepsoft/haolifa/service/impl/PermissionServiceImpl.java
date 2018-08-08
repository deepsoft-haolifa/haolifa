package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.extend.MyPermissionMapper;
import com.deepsoft.haolifa.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private MyPermissionMapper myPermissionMapper;


    @Override
    public boolean authorized(List<GrantedAuthority> roles, String url, String permission) {
        return myPermissionMapper.findPermissiosByRoles(
                roles.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()),
                url,
                permission
        )>0;
    }
}
