package org.example.modular.mst.mst0002.controller;

//import com.alibaba.fastjson.JSONObject;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.MinioException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.example.config.MinioProp;
import org.example.modular.mst.mst0001.parameter.paramOut.Mst0001InitResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@Api(tags = "[MST0002]mino文件上传")
@RequestMapping(name = "[MST0002]mino文件上传", value = "/mst0001")
public class MinioDemoController {

    @Autowired
    MinioClient minioClient;

    @Value("${minio.endpoint}")
    private String minioEndpoint;

    @Value("${minio.accessKey}")
    private String minioAccessKey;

    @Value("${minio.secretKey}")
    private String minioSecretKey;
    @Value("${minio.bucketname}")
    private String bucketName;

    @RequestMapping(name = "文件上传", value = "/upload", method = RequestMethod.POST)
    @ApiOperation(value = "文件上传", response = String.class, notes = "文件上传notes")
    public String uploadFile(@ApiParam(value = "图片文件", required = false) MultipartFile file) {
        try {
            MinioClient minioClient = MinioClient.builder()
                .credentials(minioAccessKey, minioSecretKey)
                .endpoint(minioEndpoint)
                .build();
//            InputStream inputStream = file.getInputStream();
            FileInputStream inputStream = new FileInputStream("D:/src/personal-demo/demo/upload/test_minio01.txt") ;
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
//                            .object(file.getOriginalFilename())
                            .object("test_minio01.txt")
                            .stream(inputStream, inputStream.available(), -1)
//                            .contentType(file.getContentType())
                            .build()
            );
            System.out.println(minioEndpoint);
            System.out.println(minioAccessKey);
            System.out.println(minioSecretKey);
            System.out.println(bucketName);
            return "File uploaded successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error uploading file to MinIO: " + e.getMessage();
        }
    }

//    @Autowired
//    private MinioProp minioProp;
//    @Autowired
//    private MinioUtils minioUtils;
//
//    @PostMapping("/uploadFile")
//    @ResponseBody
//    public List<FileUploadLog> uploadFile(@RequestParam(value = "files", required = true) MultipartFile[] files) throws Exception {
//        for (MultipartFile file : files) {
//            JSONObject o = new JSONObject();
//            o = minioUtils.uploadFile(file, minioProp.getBucketName());
//        }
//        return  null;
//    }
}
