package com.deepsoft.haolifa.validator.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@Data
public class SecurityImageProperties {

    private int width = 60;

    private int height = 40;

    private int length = 4;

    private int expireSec = 60;

}
