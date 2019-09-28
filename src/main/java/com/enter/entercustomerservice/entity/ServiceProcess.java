package com.enter.entercustomerservice.entity;

import com.enter.entercustomerservice.entity.infc.TimeSet;
import com.enter.entercustomerservice.utils.TimeUtils;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Table(name = "enter_service_process")
public class ServiceProcess implements TimeSet{
    /**
     * 服务流程id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 流程标题
     */
    private String item;

    /**
     * 流程内容
     */
    private String content;

    /**
     * 归属的项目类型
     */
    @Column(name = "project_type")
    private Integer projectType;

    /**
     * 顺序
     */
    private Integer index;

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