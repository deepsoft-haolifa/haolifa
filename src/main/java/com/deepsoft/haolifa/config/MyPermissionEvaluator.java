package com.deepsoft.haolifa.config;

import com.deepsoft.haolifa.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Component
public class MyPermissionEvaluator implements PermissionEvaluator {

    @Autowired
    private PermissionService permissionService;

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        List<GrantedAuthority> authorities = (List<GrantedAuthority>)authentication.getAuthorities();
        return permissionService.authorized(authorities, targetDomainObject.toString(), permission.toString());
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }
}
