package com.enter.entercustomerservice.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Liquid
 * @description
 * @date 2019/9/20
 */
@Data
@Table(name = "enter_test")
public class Test implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "information")
    private String information;


}