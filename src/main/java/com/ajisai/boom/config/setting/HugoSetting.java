package com.ajisai.boom.config.setting;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "hugo")
public class HugoSetting {

    private String name;
    private Integer age;
}
