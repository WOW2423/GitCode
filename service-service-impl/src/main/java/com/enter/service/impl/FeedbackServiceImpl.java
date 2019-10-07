package com.enter.service.impl;

import com.enter.service.database.mysql.mybatis.FeedbackMapper;
import com.enter.service.pojo.dto.entity.FeedbackDTO;
import com.enter.service.pojo.entity.Feedback;
import com.enter.service.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@com.alibaba.dubbo.config.annotation.Service(
        version = "1.0",
        timeout = 10000
)
@Service("FeedbackService")
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackMapper feedbackMapper;

    @Override
    public void insert(FeedbackDTO feedbackDTO) throws Exception {
        Feedback feedback = feedbackDTO.convertToDo();
        feedback.setAllTime();
        feedbackMapper.insert(feedback);
    }

    @Override
    public List<FeedbackDTO> selectAll() {
        List<Feedback> feedbacks =feedbackMapper.selectAll();
        List<FeedbackDTO> feedbackDTOS =new ArrayList<>();
        for(Feedback feedback :feedbacks){
            FeedbackDTO feedbackDTO =new FeedbackDTO().convertToDTO(feedback);
            feedbackDTOS.add(feedbackDTO);
        }
        return feedbackDTOS;
    }

    @Override
    public FeedbackDTO selectByPrimary(FeedbackDTO feedbackDTO) {
        Feedback feedback = feedbackMapper.selectByPrimaryKey(feedbackDTO.getId());
        return new FeedbackDTO().convertToDTO(feedback);
    }

    @Override
    public void updateByPrimary(FeedbackDTO feedbackDTO) {
        Feedback feedback = feedbackDTO.convertToDo();
        feedback.setAllTime();
        feedbackMapper.updateByPrimaryKey(feedback);
    }

    @Override
    public void deleteByPrimary(FeedbackDTO feedbackDTO) {
        Feedback feedback = feedbackDTO.convertToDo();
        feedback.setAllTime();
        feedbackMapper.deleteByPrimaryKey(feedback.getId());
    }
}
