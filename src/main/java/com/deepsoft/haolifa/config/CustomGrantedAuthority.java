package com.deepsoft.haolifa.config;

import com.deepsoft.haolifa.model.domain.SysPermission;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;

/**
 * @author zhaozhihong
 * @create 2018-07-11 20:48
 * @desc
 **/
@Data
@AllArgsConstructor
public class CustomGrantedAuthority implements GrantedAuthority  {

    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    private final String role;

    private final String roleName;

    @Override
    public String getAuthority() {
        return role;
    }

}
