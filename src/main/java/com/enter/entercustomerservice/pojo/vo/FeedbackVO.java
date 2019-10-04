package com.enter.entercustomerservice.pojo.vo;

import java.io.Serializable;

/**
 * @className FeedbackVO
 * @auther DylanChan
 * @description
 * @date 2019/10/4
 */
public class FeedbackVO implements Serializable {

    private static final long serialVersionUID = -9164814852284107924L;
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
}
