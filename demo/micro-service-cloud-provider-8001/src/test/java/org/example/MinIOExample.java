package org.example;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.MinioException;

import java.io.FileInputStream;

public class MinIOExample {

    public static void main(String[] args){
        try{
            MinioClient minioClient = MinioClient.builder()
                    .endpoint("http://127.0.0.1:9000")
                    .credentials("minioadmin", "minioadmin")
                    .build();
            boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket("my-bucket").build());
            // 如果不存在，那么此时就创建一个新的桶
            if (!found) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket("my-bucket").build());
            } else {  // 如果存在打印信息
                System.out.println("Bucket 'my-bucket' already exists.");
            }
            FileInputStream fis = new FileInputStream("E:/src/demo02/upload/test_minio01.txt") ;
            PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                    .bucket("my-bucket")
                    .stream(fis, fis.available(), -1)
                    .object("test_minio01.txt")
                    .build();
            minioClient.putObject(putObjectArgs) ;

            // 构建fileUrl
            String fileUrl = "http://127.0.0.1:9000/my-bucket/test_minio01.txt" ;
            System.out.println(fileUrl);

        } catch (MinioException e){
            System.out.println("Error MinioException occurred: " + e);

        } catch (Exception e){
            System.out.println("Error Exception occurred: " + e);
        }
    }
}
