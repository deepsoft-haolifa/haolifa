package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.PermissionNode;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public interface PermissionService {

    boolean authorized(List<GrantedAuthority> roles, String url, String permission);

    List<String> getMenu(String menuType);

}
