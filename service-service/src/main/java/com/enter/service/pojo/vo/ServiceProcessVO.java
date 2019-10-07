package com.enter.service.pojo.vo;

import java.io.Serializable;

/**
 * @className ServiceProcessVO
 * @auther DylanChan
 * @description
 * @date 2019/10/4
 */
public class ServiceProcessVO implements Serializable {

    private static final long serialVersionUID = -3706073544146909136L;
    /**
     * 服务流程id
     */

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
    private String projectType;

    /**
     * 顺序
     */
    private Integer index;
}
