package org.example.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "minio")
public class MinioProp {
    /**
     连接地址
     */
    private String endpoint;
    /**
     * 用户名
     */
    private String accesskey;
    /**
     * 密码
     */
    private String secretkey;
    /**
     * 桶名
     */
    private String bucketName;

    @Override
    public String toString() {
        return "MinioProp{" +
                "endpoint='" + endpoint + '\'' +
                ", accesskey='" + accesskey + '\'' +
                ", secretkey='" + secretkey + '\'' +
                ", bucketName='" + bucketName + '\'' +
                '}';
    }
}
