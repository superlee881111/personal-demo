package org.example.service.impl;

import org.example.entity.SysDatabaseInfo;
import org.example.mapper.HelloMapper;
import org.example.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    HelloMapper helloMapper;

    @Override
    public String getSysDB(Long id){
        try{
            SysDatabaseInfo sysInfo = helloMapper.selectByPrimaryKey(id);

            if(sysInfo == null) {
                throw new RuntimeException("id=>" + id +",该用户不存在。或者信息无法找到");
            }
            return sysInfo.getDbName();
//            return "3333";
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong.");
        }
        return "2222";
    }
    @Override
    public SysDatabaseInfo getSysDB1(Long id){
        try{
            SysDatabaseInfo sysInfo = helloMapper.selectByPrimaryKey(id);

            if(sysInfo == null) {
                throw new RuntimeException("id=>" + id +",该用户不存在。或者信息无法找到");
            }
            return sysInfo;
//            return "3333";
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong.");
        }
        return new SysDatabaseInfo();
    }

    public String hystrixGet(){
        return "hystrixGet";
    }
}
