package com.enter.entercustomerservice.controller;

import com.enter.entercustomerservice.result.ResultBean;
import com.enter.entercustomerservice.utils.FdfsUploadUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@RestController
public class FileController {

    @PostMapping("/uploadFile")
    public ResultBean uploadForFeedback(@RequestParam(value = "file", required = false) MultipartFile file){
        return new ResultBean<>(FdfsUploadUtil.uploadImage(file));
    }
}
