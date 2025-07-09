package org.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 应用配置
 */
@Configuration
@Import(value = {
        RedisConfig.class,
        SwaggerConfig.class,
})
public class Appconfig {

}
