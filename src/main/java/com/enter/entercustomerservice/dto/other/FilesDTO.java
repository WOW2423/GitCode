package com.enter.entercustomerservice.dto.other;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Administrator on 2019/9/30.
 */
@Data
public class FilesDTO {
    String realPath;

    MultipartFile[] multipartFiles;

    String folderName;

    String secondFolderName;

    List<String> fileNames;

    List<String> paths;
}
