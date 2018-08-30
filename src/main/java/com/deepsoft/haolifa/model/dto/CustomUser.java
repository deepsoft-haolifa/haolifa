package com.deepsoft.haolifa.model.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;

public class CustomUser extends User {

    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    private final Integer id;
    private final String realName;
    private final List<CustomPermission> permissions;

    public CustomUser(Integer id, String username, String realName,String password,
                      Collection<? extends GrantedAuthority> authorities,
                       List<CustomPermission> permissions) {
        super(username, password, authorities);
        this.id = id;
        this.realName = realName;
        this.permissions = permissions;
    }

    public Integer getId() {
        return id;
    }

    public List<CustomPermission> getPermissions() {
        return permissions;
    }

    public String getRealName(){
        return realName;
    }

    @Override
    public String toString() {
        return super.toString()+
                "id=" + id +
                ", permissions=" + permissions ;
    }
}
