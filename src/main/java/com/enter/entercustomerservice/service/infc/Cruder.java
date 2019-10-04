package com.enter.entercustomerservice.service.infc;

import com.enter.entercustomerservice.dto.entity.BadReportDTO;

import java.util.List;

/**
 * @author Liquid
 * @version 1.0
 * @date 2019/9/25
 */
public interface Cruder<T> {
    void insert(T t) throws Exception;

    List<BadReportDTO> selectAll();

    T selectByPrimary(T t);

    void updateByPrimary(T t);

    void deleteByPrimary(T t);
}
