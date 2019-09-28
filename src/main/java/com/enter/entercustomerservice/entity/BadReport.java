package com.enter.entercustomerservice.entity;

import com.enter.entercustomerservice.entity.infc.TimeSet;
import com.enter.entercustomerservice.utils.TimeUtils;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Table(name = "enter_badreport")
public class BadReport implements TimeSet{
    /**
     * 举报id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 说明举报所属的项目
     */
    @Column(name = "project_type")
    private Integer projectType;

    /**
     * 举报的图片列表
     */
    @Column(name = "img_paths")
    private String imgPaths;

    /**
     * 举报人微信号
     */
    @Column(name = "wechat_number")
    private String wechatNumber;

    /**
     * 举报内容
     */
    private String content;

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