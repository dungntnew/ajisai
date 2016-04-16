package com.ajisai.boom.config.setting;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "myconfig")
public class MySetting {
    private List<String> types;

}
