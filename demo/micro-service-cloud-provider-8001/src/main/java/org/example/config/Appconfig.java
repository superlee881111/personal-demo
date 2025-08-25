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
        MinioConfig.class,
        CustomFieldConfig.class,
})
public class Appconfig {

}
