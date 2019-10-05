package com.enter.entercustomerservice.utils;

import com.enter.entercustomerservice.exception.UnCheckedException;
import com.enter.entercustomerservice.exception.UserException;
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
public class FdfsUploadUtil {

    private static final String TYPE = "GIF,PNG,JPG,JPEG";

    public static String uploadImage(MultipartFile multipartFile) {

        // 上传图片到服务器
        // 配置fdfs的全局链接地址
        // 获得配置文件的路径
        String tracker = FdfsUploadUtil.class.getResource("/tracker.conf").getPath();

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

        StringBuilder imgUrl = new StringBuilder("http://106.15.248.81");
        try {
            // 获得上传的二进制对象
            byte[] bytes = multipartFile.getBytes();

            // 获得文件后缀名
            String originalFilename = multipartFile.getOriginalFilename();
            System.out.println(originalFilename);
            if (originalFilename == null) {
                throw new UnCheckedException("非法文件");
            }
            int i = originalFilename.lastIndexOf(".");
            String extName = originalFilename.substring(i + 1);
            log.debug("图片初始名称为：" + originalFilename + " 类型为：" + extName);
            List<String> typeList = Arrays.asList(TYPE.split(","));

            if (typeList.contains(extName.toUpperCase())) {

                String[] uploadInfos = storageClient.upload_file(bytes, extName, null);

                for (String uploadInfo : uploadInfos) {
                    imgUrl.append("/").append(uploadInfo);
                }
            } else {
                throw new UserException("不是我们想要的文件类型,请按要求重新上传");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }   //http://106.15.248.81/group1/M00/00/00/rBE3vl2VeNyAfMS5AAkvPir3brE513_big.jpg 测试地址
        return imgUrl.toString();
    }
}
