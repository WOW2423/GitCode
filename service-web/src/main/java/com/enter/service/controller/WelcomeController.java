package com.enter.service.controller;

import com.enter.service.database.mysql.mybatis.TestMapper;
import com.enter.service.pojo.entity.Test;
import com.enter.service.result.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Liquid
 * @description
 * @date 2019/9/20
 */
@RestController
public class WelcomeController {


    @Autowired
    private TestMapper testMapper;


    @RequestMapping("/welcome")
    public ResultBean welcome(){
        String information="部署失败";
        List<Test> tests = testMapper.selectAll();
        if (tests!=null && !tests.isEmpty()){
            information="部署成功";
        }
        return new ResultBean<>(information);
    }
}
