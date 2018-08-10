package com.deepsoft.haolifa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.security.core.SpringSecurityCoreVersion;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class CustomPermission implements Serializable {

    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    private String permName;

    private String url;

}
