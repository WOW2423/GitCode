package com.enter.entercustomerservice.service.impl;

import com.enter.entercustomerservice.dao.database.mysql.mybatis.FeedbackMapper;
import com.enter.entercustomerservice.dto.entity.BadReportDTO;
import com.enter.entercustomerservice.dto.entity.FeedbackDTO;
import com.enter.entercustomerservice.entity.Feedback;
import com.enter.entercustomerservice.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


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
    public List<BadReportDTO> selectAll() {
        List<Feedback> feedbacks =feedbackMapper.selectAll();
        List<FeedbackDTO> feedbackDTOS =new ArrayList<>();
        for(Feedback feedback :feedbacks){
            FeedbackDTO feedbackDTO =new FeedbackDTO().convertToDto(feedback);
            feedbackDTOS.add(feedbackDTO);
        }
        //return feedbackDTOS;
        return null;
    }

    @Override
    public FeedbackDTO selectByPrimary(FeedbackDTO feedbackDTO) {
        Feedback feedback = feedbackMapper.selectByPrimaryKey(feedbackDTO.getId());
        return new FeedbackDTO().convertToDto(feedback);
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
