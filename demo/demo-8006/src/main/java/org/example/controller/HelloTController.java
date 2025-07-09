package org.example.controller;

import org.example.entity.SysDatabaseInfo;


import org.example.mapper.HelloTMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RefreshScope
public class HelloTController {

    @Value("${server.port}")
    String port;

    @Value("${spring.cloud.nacos.config.server-addr}")
    String config;

//    @Autowired
//    HelloTMapper helloTMapper;

    @RequestMapping("/gatewayApp/home")
    public String home(String name) {
        return "home" + port ;
    }

    @RequestMapping("/config")
    public String config(String conf) {
        return "config:"  + config + port;
    }

    @RequestMapping("getSysDB/{id}")
    public String getSysDatabaseInfo(@PathVariable("id") Long id){
        try{
//            SysDatabaseInfo sysInfo = helloMapper.selectByPrimaryKey(id);
//            return sysInfo.getDbName();
            return "3333";
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong.");
        }
        return "2222";
    }
}
