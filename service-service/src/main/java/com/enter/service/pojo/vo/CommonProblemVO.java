package com.enter.service.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @className CommonProblemVO
 * @auther DylanChan
 * @description
 * @date 2019/10/4
 */
@Data
public class CommonProblemVO implements Serializable {

    private static final long serialVersionUID = 1063870363235467370L;
    /**
     * 常见问题id
     */
    private Integer id;

    /**
     * 归属的项目类型
     */
    private String projectType;

    /**
     * 问题标题
     */
    private String item;

    /**
     * 问题回答
     */
    private String content;
}
