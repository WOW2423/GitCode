package com.enter.entercustomerservice.service.impl;

import com.enter.entercustomerservice.dao.database.mysql.mybatis.BadReportMapper;
import com.enter.entercustomerservice.dto.entity.BadReportDTO;
import com.enter.entercustomerservice.service.BadReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Liquid
 * @类名： BadReportServiceImpl
 * @描述：
 * @date 2019/9/29
 */
@Service("badReportService")
public class BadReportServiceImpl implements BadReportService {

    @Autowired
    private BadReportMapper badReportMapper;

    @Override
    public void insert(BadReportDTO badReportDTO) throws Exception {

    }

    @Override
    public List<BadReportDTO> selectAll() {
        return null;
    }

    @Override
    public BadReportDTO selectByPrimary(BadReportDTO badReportDTO) {
        return null;
    }

    @Override
    public void updateByPrimary(BadReportDTO badReportDTO) {

    }

    @Override
    public void deleteByPrimary(BadReportDTO badReportDTO) {

    }
}
