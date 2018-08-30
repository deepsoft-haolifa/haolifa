package com.deepsoft.haolifa.model.vo;

import com.deepsoft.haolifa.config.CustomGrantedAuthority;
import com.deepsoft.haolifa.model.dto.CustomPermission;
import com.deepsoft.haolifa.model.dto.PermissionNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
public class UserInfoVO {

    private String username;

    private String realName;

    private Collection<GrantedAuthority> roles;

    private List<PermissionNode> menus;

}
