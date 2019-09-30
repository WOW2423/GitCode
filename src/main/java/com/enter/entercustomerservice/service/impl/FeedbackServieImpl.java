package com.enter.entercustomerservice.service.impl;

import com.enter.entercustomerservice.dao.database.mysql.mybatis.FeedbackMapper;
import com.enter.entercustomerservice.dto.entity.FeedbackDTO;
import com.enter.entercustomerservice.entity.Feedback;
import com.enter.entercustomerservice.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liquid
 * @类名： FeedbackServieImpl
 * @描述：
 * @date 2019/9/29
 */
@Service("feedbackService")
public class FeedbackServieImpl implements FeedbackService {

    @Autowired
    private FeedbackMapper feedbackMapper;

    @Override
    public void insert(FeedbackDTO feedbackDTO) throws Exception {
        Feedback feedback = feedbackDTO.convertToDo();
        feedback.setAllTime();
        feedbackMapper.insert(feedback);
        System.out.println("插入成功");
    }

    @Override
    public List<FeedbackDTO> selectAll() {
        List<Feedback> feedbacks = feedbackMapper.selectAll();
        List<FeedbackDTO> feedbackDTOList=new ArrayList<>();
        for (Feedback feedback : feedbacks) {
            FeedbackDTO feedbackDTO = new FeedbackDTO().convertToDto(feedback);
            feedbackDTOList.add(feedbackDTO);
        }
        return feedbackDTOList;
    }

    @Override
    public FeedbackDTO selectByPrimary(FeedbackDTO feedbackDTO) {
        Feedback feedback = feedbackDTO.convertToDo();
        feedback.setAllTime();
        Feedback f = feedbackMapper.selectByPrimaryKey(feedback.getId());
        return new FeedbackDTO().convertToDto(f);
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
        System.out.println("删除成功");
    }
}
