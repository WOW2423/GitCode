package com.enter.entercustomerservice.controller;

import com.enter.entercustomerservice.pojo.dto.entity.CommonProblemDTO;
import com.enter.entercustomerservice.result.ResultBean;
import com.enter.entercustomerservice.service.CommonProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DELL
 * @className CommonProblemController
 * @auther DylanChan
 * @description
 * @date 2019/9/29
 */
@RestController
public class CommonProblemController {
    @Autowired
    private CommonProblemService commonProblemService;

    @GetMapping("/selectAllCommonProblems")
    public ResultBean getAllCommonProblems(){
        return new ResultBean<>(commonProblemService.selectAll());
    }
    @PostMapping("/insertCommonProblem")
    public void  insert(CommonProblemDTO commonProblemDTO) throws Exception {
        commonProblemService.insert(commonProblemDTO);
    }
    @GetMapping("/selectCommonProblemByPrimary")
    public ResultBean selectByPrimary(CommonProblemDTO commonProblemDTO){
        return new ResultBean(commonProblemService.selectByPrimary(commonProblemDTO));
    }
    @PostMapping ("/updateCommonProblemByPrimary")
    public ResultBean  updateByPrimary(CommonProblemDTO commonProblemDTO){
        commonProblemService.updateByPrimary(commonProblemDTO);
        return new ResultBean(commonProblemService.selectByPrimary(commonProblemDTO));
    }
    @PostMapping("/deleteCommonProblemByPrimary")
    public void deleteByPrimary(CommonProblemDTO commonProblemDTO){
        commonProblemService.deleteByPrimary(commonProblemDTO);
        System.out.println("删除成功");
    }
}
