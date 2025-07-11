package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger使用的配置文件
 **/

@Configuration
@Lazy(value = false)
public class SwaggerConfig {

    @Bean
    public Docket webApiConfig(){
        return new Docket(DocumentationType.OAS_30)
                // 如果配置多个文档的时候，那么需要配置groupName来分组标识
                .groupName("webApi")
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.example.modular.mst"))
                .build();
    }

    @Bean
    public Docket webApiConfigG1(){
        return new Docket(DocumentationType.OAS_30)
                // 如果配置多个文档的时候，那么需要配置groupName来分组标识
                .groupName("webApi2")
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.example.modular.sys"))
                .build();
    }
}
