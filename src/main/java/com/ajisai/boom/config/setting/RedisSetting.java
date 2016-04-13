package com.ajisai.boom.config.setting;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "redis")
public class RedisSetting {

    private String keyPrefix;
    private Setting redisCache;

    @Data
    public static class Setting {
        private String host;
        private int port;
        private Expires expires;
    }

    @Data
    public static class Expires {
        private Long time;
    }
}
