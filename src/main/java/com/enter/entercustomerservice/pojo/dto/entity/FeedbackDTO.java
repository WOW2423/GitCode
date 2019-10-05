package com.enter.entercustomerservice.pojo.dto.entity;

import com.enter.entercustomerservice.pojo.dto.DoConvertible;
import com.enter.entercustomerservice.pojo.dto.VoConvertible;
import com.enter.entercustomerservice.pojo.entity.Feedback;
import com.enter.entercustomerservice.pojo.vo.FeedbackVO;
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


    private static FeedbackDoConvert feedbackDoConvert;
    private static FeedbackVoConvert feedbackVoConvert;

    static {
        feedbackDoConvert = new FeedbackDoConvert();
        feedbackVoConvert=new FeedbackVoConvert();
    }

    public Feedback convertToDo() {

        return feedbackDoConvert.convertToDO(this);
    }

    public FeedbackDTO convertToDTO(Feedback feedback) {
        return feedbackDoConvert.convertToDTO(feedback);
    }

    public FeedbackVO convertToVo() {
        return feedbackVoConvert.convertToVO(this);
    }

    public FeedbackDTO feedbackToDTO(FeedbackVO feedbackVO) {
        return feedbackVoConvert.convertToDTO(feedbackVO);
    }

    public static class FeedbackDoConvert implements DoConvertible<Feedback, FeedbackDTO> {

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
    public static class FeedbackVoConvert implements VoConvertible<FeedbackVO, FeedbackDTO> {
        @Override
        public FeedbackVO convertToVO(FeedbackDTO feedbackDTO) {
            FeedbackVO feedbackVO = new FeedbackVO();
            BeanUtils.copyProperties(feedbackDTO, feedbackVO);
            return feedbackVO;
        }

        @Override
        public FeedbackDTO convertToDTO(FeedbackVO feedbackVO) {
            FeedbackDTO feedbackDTO = new FeedbackDTO();
            BeanUtils.copyProperties(feedbackVO, feedbackDTO);
            return feedbackDTO;
        }
    }
}
