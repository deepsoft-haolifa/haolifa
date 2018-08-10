package com.deepsoft.haolifa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Set;

public class CustomUser extends User {

    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    private final Integer id;
    private final Set<CustomPermission> permissions;

    public CustomUser(Integer id, String username, String password,
                      Collection<? extends GrantedAuthority> authorities,
                       Set<CustomPermission> permissions) {
        super(username, password, authorities);
        this.id = id;
        this.permissions = permissions;
    }

    public Integer getId() {
        return id;
    }

    public Set<CustomPermission> getPermissions() {
        return permissions;
    }

    @Override
    public String toString() {
        return super.toString()+
                "id=" + id +
                ", permissions=" + permissions ;
    }
}
