package org.example.config;


import io.minio.MinioClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.HttpURLConnection;

@Configuration
@EnableConfigurationProperties(MinioProp.class)
@Slf4j
public class MinioConfig {

    @Value("${minio.endpoint}")
    private String minioEndpoint;

    @Value("${minio.accessKey}")
    private String minioAccessKey;

    @Value("${minio.secretKey}")
    private String minioSecretKey;

    /**
     * 桶名
     */
    @Value("${minio.bucketName}")
    private String bucketName;

    @Autowired
    private MinioProp minioProp;

    /**
     * 获取MinioClient
     */
    @Bean
    public MinioClient minioClient()  {
        try {
            log.info("minioClient create start");
//            MinioClient minioClient = MinioClient.builder().endpoint(minioProp.getEndpoint()).credentials(minioProp.getAccesskey(), minioProp.getSecretkey())
//                    .build();
            MinioClient minioClient = MinioClient.builder().endpoint(minioEndpoint).credentials(minioAccessKey, minioSecretKey)
                    .build();
            log.info("minioClient create end");
            return minioClient;
        } catch (Exception e) {
            log.error("连接MinIO服务器异常：{}", e);
            return null;
        }
    }

//    @Bean
//    public MinioClient minioClient() {
//
//        return MinioClient.builder()
//                .credentials(minioAccessKey, minioSecretKey)
//                .endpoint(minioEndpoint)
//                .build();
//    }

//    @Override
//    public String toString() {
//        return "MinioProp{" +
//                "endpoint='" + minioEndpoint + '\'' +
//                ", accesskey='" + minioAccessKey + '\'' +
//                ", secretkey='" + minioSecretKey + '\'' +
//                ", bucketName='" + bucketName + '\'' +
//                '}';
//    }

}
