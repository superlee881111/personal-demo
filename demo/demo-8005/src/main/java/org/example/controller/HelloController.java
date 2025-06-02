package org.example.controller;

import org.example.entity.SysDatabaseInfo;
import org.example.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RefreshScope
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("hello")
    String hello(){
        return "hello world";
    }

    @Value("${server.port}")
    String port;

    @Value("${spring.cloud.nacos.config.server-addr}")
    String config;

    @RequestMapping("/gatewayApp/home")
    public String home(String name) {
        return "home reload refresh:" + port;
    }

    @RequestMapping("/config")
    public String config(String conf) {
        return "config:" + config ;
    }

    @RequestMapping("getSysDB/{id}")
    public String getSysDatabaseInfo(@PathVariable("id") Long id){
        String result = helloService.getSysDB(id);
        return result;
    }

    @RequestMapping("getSysDB1/{id}")
    public SysDatabaseInfo getSysDatabaseInfo1(@PathVariable("id") Long id){
        SysDatabaseInfo result = helloService.getSysDB1(id);
        return result;
    }
}
