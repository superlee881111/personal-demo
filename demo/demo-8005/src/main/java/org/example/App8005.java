package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@ComponentScan("org.example.*")
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class App8005
{
    public static void main( String[] args )
    {
        System.out.println( "demo-8005!" );
        SpringApplication.run(App8005.class, args);
    }
}
