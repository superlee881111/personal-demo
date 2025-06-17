//package org.example;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.StringRedisTemplate;
//
//import java.util.concurrent.TimeUnit;
//
//@SpringBootTest
//public class RedisTest {
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//
//    @Test
//        //测试redis
//    public void contextLoads2() {
//        //添加缓存键值对name:mijiu并设置过期时间为1小时
//        stringRedisTemplate.opsForValue().set("name","mijiu",10, TimeUnit.SECONDS);
//        System.out.println(stringRedisTemplate.opsForValue().get("name"));
//
//    }
//}
