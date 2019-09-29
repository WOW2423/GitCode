package com.enter.entercustomerservice.service.impl;

import com.enter.entercustomerservice.dao.database.mysql.mybatis.FeedbackMapper;
import com.enter.entercustomerservice.dto.entity.FeedbackDTO;
import com.enter.entercustomerservice.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    }

    @Override
    public List<FeedbackDTO> selectAll() {
        return null;
    }

    @Override
    public FeedbackDTO selectByPrimary(FeedbackDTO feedbackDTO) {
        return null;
    }

    @Override
    public void updateByPrimary(FeedbackDTO feedbackDTO) {

    }

    @Override
    public void deleteByPrimary(FeedbackDTO feedbackDTO) {

    }
}
