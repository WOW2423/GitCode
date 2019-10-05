package com.enter.entercustomerservice.utils;

import com.enter.entercustomerservice.exception.FileException;
import lombok.extern.slf4j.Slf4j;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class fdfsUploadUtil {

    public static String uploadImage(MultipartFile multipartFile) {
        final String TYPE = "GIF,PNG,JPG,JPEG";
        String imgUrl = "http://106.15.248.81";

        // 上传图片到服务器
        // 配置fdfs的全局链接地址
        String tracker = fdfsUploadUtil.class.getResource("/tracker.conf").getPath();// 获得配置文件的路径

        try {
            ClientGlobal.init(tracker);
        } catch (Exception e) {
            e.printStackTrace();
        }

        TrackerClient trackerClient = new TrackerClient();

        // 获得一个trackerServer的实例
        TrackerServer trackerServer = null;
        try {
            trackerServer = trackerClient.getConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 通过tracker获得一个Storage链接客户端
        StorageClient storageClient = new StorageClient(trackerServer, null);

        try {

            byte[] bytes = multipartFile.getBytes();// 获得上传的二进制对象

            // 获得文件后缀名
            String originalFilename = multipartFile.getOriginalFilename();// 123.jpg
            System.out.println(originalFilename);
            int i = originalFilename.lastIndexOf(".");
            String extName = originalFilename.substring(i + 1);
            log.debug("图片初始名称为：" + originalFilename + " 类型为：" + extName);
            List<String> typelist = Arrays.asList(TYPE.split(","));
            if (typelist.contains(extName.toUpperCase())) {

                String[] uploadInfos = storageClient.upload_file(bytes, extName, null);

                for (String uploadInfo : uploadInfos) {
                    imgUrl += "/" + uploadInfo;
                }
            } else {
                throw new FileException("不是我们想要的文件类型,请按要求重新上传");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }   //http://106.15.248.81/group1/M00/00/00/rBE3vl2VeNyAfMS5AAkvPir3brE513_big.jpg 测试地址
        return imgUrl;
    }
}
