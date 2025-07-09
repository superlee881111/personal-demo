package org.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@ComponentScan("org.example.*")
@SpringBootApplication(exclude = {RedisRepositoriesAutoConfiguration.class})
//@SpringBootApplication
@EnableDiscoveryClient
public class ProviderApp8001
{
    public static void main( String[] args )
    {
        System.out.println( "Hello ProviderApp8001!" );
        SpringApplication.run(ProviderApp8001.class,args);
    }
}
