package com.enter.entercustomerservice.controller;

import com.enter.entercustomerservice.dto.entity.FeedbackDTO;
import com.enter.entercustomerservice.result.ResultBean;
import com.enter.entercustomerservice.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @RequestMapping("/insertFeedback")
    public void insertFeebdack(FeedbackDTO feedbackDTO) throws Exception {
        feedbackService.insert(feedbackDTO);
    }

    @RequestMapping("/selectAllFeedback")
    public ResultBean selectAllFeeback(){
        return new ResultBean(feedbackService.selectAll());
    }

    @RequestMapping("/selectByFeedbackPrimaryKey")
    public ResultBean selectByFeedbackPrimaryKey(FeedbackDTO feedbackDTO){
        return new ResultBean(feedbackService.selectByPrimary(feedbackDTO));
    }

    @RequestMapping("/updateFeedback")
    public void updateFeedback(FeedbackDTO feedbackDTO){
        feedbackService.updateByPrimary(feedbackDTO);
    }

    @RequestMapping("/deleteFeedbackByPrimaryKey")
    public void deleteFeedback(FeedbackDTO feedbackDTO){
        feedbackService.deleteByPrimary(feedbackDTO);
    }
}
