package com.enter.entercustomerservice.controller;

import com.enter.entercustomerservice.dto.entity.FeedbackDTO;
import com.enter.entercustomerservice.result.ResultBean;
import com.enter.entercustomerservice.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @className FeedbackController
 * @auther DylanChan
 * @description
 * @date 2019/9/29
 */
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/selectAllFeedBack")
    public ResultBean getAllFeedBack(){
        return new ResultBean<>(feedbackService.selectAll());
    }
    @PostMapping("/insertFeedBack")
    public void  insert(FeedbackDTO feedbackDTO) throws Exception {
        feedbackService.insert(feedbackDTO);
    }
    @GetMapping("/selectFeedBackByPrimary")
    public ResultBean selectByPrimary(FeedbackDTO feedbackDTO){
        return new ResultBean(feedbackService.selectByPrimary(feedbackDTO));
    }
    @PostMapping("/updateFeedBackByPrimary")
    public ResultBean  updateByPrimary(FeedbackDTO feedbackDTO){
        feedbackService.updateByPrimary(feedbackDTO);
        return new ResultBean(feedbackService.selectByPrimary(feedbackDTO));
    }
    @PostMapping("/deleteFeedBackByPrimary")
    public void deleteByPrimary(FeedbackDTO feedbackDTO){
        feedbackService.deleteByPrimary(feedbackDTO);
    }
}
