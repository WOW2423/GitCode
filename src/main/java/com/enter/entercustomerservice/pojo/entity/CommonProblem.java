package com.enter.entercustomerservice.pojo.entity;

import com.enter.entercustomerservice.pojo.entity.infc.TimeSet;
import com.enter.entercustomerservice.utils.TimeUtils;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Liquid
 * @version 1.0
 * @date 2019/9/28
 */

@Data
@Table(name = "enter_common_problem")
public class CommonProblem implements TimeSet {
    /**
     * 常见问题id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 归属的项目类型
     */
    @Column(name = "project_type")
    private Integer projectType;

    /**
     * 问题标题
     */
    private String item;

    /**
     * 问题回答
     */
    private String content;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 最后更新时间
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
    public void refreshLastUpdateTime() {
        this.setLastUpdateTime(TimeUtils.getCurrentTime());
    }
}