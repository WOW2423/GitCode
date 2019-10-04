package com.enter.entercustomerservice.entity;

import com.enter.entercustomerservice.controller.BadReportController;
import com.enter.entercustomerservice.dto.entity.BadReportDTO;
import com.enter.entercustomerservice.service.BadReportService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
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