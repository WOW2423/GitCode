package com.enter.entercustomerservice.dto.entity;

import com.enter.entercustomerservice.dto.Convertible;
import com.enter.entercustomerservice.entity.Feedback;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * @author Liquid
 * @类名： FeedbackDTO
 * @描述：
 * @date 2019/9/28
 */
@Data
public class FeedbackDTO implements Serializable {

    private static final long serialVersionUID = -74181585496455239L;

    /**
     * 反馈id
     */
    private Integer id;

    /**
     * 说明哪个项目的反馈
     */
    private String projectType;

    /**
     * 反馈电话（可为null）
     */
    private String phoneNumber;

    /**
     * 反馈图片地址列表（可为null 用;分割）
     */
    private String imgPaths;

    /**
     * 反馈人微信号
     */
    private String wechatNumber;


    /**
     * 反馈内容
     */
    private String content;


    private static FeedbackConvert feedbackConvert;

    static {
        feedbackConvert = new FeedbackConvert();
    }

    public Feedback convertToDo() {

        return feedbackConvert.convertToDO(this);
    }

    public FeedbackDTO convertToDto(Feedback feedback) {
        return feedbackConvert.convertToDTO(feedback);
    }

    public static class FeedbackConvert implements Convertible<Feedback, FeedbackDTO> {

        @Override
        public Feedback convertToDO(FeedbackDTO feedbackDTO) {
            Feedback feedback = new Feedback();
            BeanUtils.copyProperties(feedbackDTO, feedback);
            return feedback;
        }

        @Override
        public FeedbackDTO convertToDTO(Feedback feedback) {
            FeedbackDTO feedbackDTO = new FeedbackDTO();
            BeanUtils.copyProperties(feedback, feedbackDTO);
            return feedbackDTO;
        }
    }
}
