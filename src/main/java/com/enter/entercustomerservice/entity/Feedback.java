package com.enter.entercustomerservice.entity;

import com.enter.entercustomerservice.entity.infc.TimeSet;
import com.enter.entercustomerservice.utils.TimeUtils;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Table(name = "enter_feedback")
public class Feedback implements TimeSet{
    /**
     * 反馈id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 说明哪个项目的反馈
     */
    @Column(name = "project_type")
    private String projectType;

    /**
     * 反馈电话（可为null）
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * 反馈图片地址列表（可为null 用;分割）
     */
    @Column(name = "img_paths")
    private String imgPaths;

    /**
     * 反馈人微信号
     */
    @Column(name = "wechat_number")
    private String wechatNumber;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 最后修改时间
     */
    @Column(name = "last_update_time")
    private Date lastUpdateTime;

    /**
     * 反馈内容
     */
    private String content;


    @Override
    public void setAllTime() {
        Date currentTime = TimeUtils.getCurrentTime();
        this.setCreateTime(currentTime);
        this.setLastUpdateTime(currentTime);
    }

    @Override
    public void refreshLastUpdateTime()  {
        this.setLastUpdateTime(TimeUtils.getCurrentTime());
    }
}