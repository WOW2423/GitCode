package com.enter.entercustomerservice.pojo.dto.other;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Administrator on 2019/9/30.
 */

@Data
public class FileDTO {
    String realPath;

    MultipartFile multipartFile;

    String folderName;

    String secondFolderName;

    String fileName;

    String path;
}
