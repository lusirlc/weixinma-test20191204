package pers.luchuan.weixinma.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * redis属性配置
 * Created by luchuan on 2019/12/13
 */
@Data
@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperties {
    private String host;
    private Integer port;
    private String password;
    private Integer timeout;
}
