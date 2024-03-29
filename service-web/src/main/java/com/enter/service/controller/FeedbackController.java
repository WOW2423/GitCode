package com.enter.service.controller;

import com.enter.service.pojo.dto.entity.FeedbackDTO;
import com.enter.service.result.ResultBean;
import com.enter.service.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Liquid
 * @version 1.0
 * @date 2019/10/2
 */

@RestController
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @RequestMapping("/insertFeedback")
    public void insertFeedback(FeedbackDTO feedbackDTO) throws Exception {
        feedbackService.insert(feedbackDTO);
    }

    @RequestMapping("/selectAllFeedback")
    public ResultBean selectAllFeedback() {
        return new ResultBean<>(feedbackService.selectAll());
    }

    @RequestMapping("/selectByFeedbackPrimaryKey")
    public ResultBean selectByFeedbackPrimaryKey(FeedbackDTO feedbackDTO) {
        return new ResultBean<>(feedbackService.selectByPrimary(feedbackDTO));
    }

    @RequestMapping("/updateFeedback")
    public void updateFeedback(FeedbackDTO feedbackDTO) {
        feedbackService.updateByPrimary(feedbackDTO);
    }

    @RequestMapping("/deleteFeedbackByPrimaryKey")
    public void deleteFeedback(FeedbackDTO feedbackDTO) {
        feedbackService.deleteByPrimary(feedbackDTO);
    }
}
