package com.enter.entercustomerservice.service.impl;

import com.enter.entercustomerservice.dao.database.mysql.mybatis.BadReportMapper;
import com.enter.entercustomerservice.dto.entity.BadReportDTO;
import com.enter.entercustomerservice.entity.BadReport;
import com.enter.entercustomerservice.service.BadReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        BadReport badReport = badReportDTO.convertToDo();
        badReport.setAllTime();
        badReportMapper.insert(badReport);
        System.out.println("插入成功");
    }

    @Override
    public List<BadReportDTO> selectAll() {
        List<BadReport> badReports = badReportMapper.selectAll();
        List<BadReportDTO> badReportDTOSList=new ArrayList<>();
        for (BadReport badReport : badReports) {
            BadReportDTO badReportDTO = new BadReportDTO().convertToDto(badReport);
            badReportDTOSList.add(badReportDTO);
        }
        return badReportDTOSList;
    }

    @Override
    public BadReportDTO selectByPrimary(BadReportDTO badReportDTO) {
        BadReport badReport = badReportDTO.convertToDo();
        badReport.setAllTime();
        BadReport b = badReportMapper.selectByPrimaryKey(badReport.getId());
        return new BadReportDTO().convertToDto(b);
    }
/*
public BadReportDTO select(BadReportDTO badReportDTO){
        BadReport badReport=badReportDTO.convertToDo();
        badReport.setAllTime();
        List<BadReport> select = badReportMapper.select(badReport);
    }
 */

    @Override
    public void updateByPrimary(BadReportDTO badReportDTO) {
        BadReport badReport = badReportDTO.convertToDo();
        badReport.setAllTime();
        badReportMapper.updateByPrimaryKey(badReport);
    }

    @Override
    public void deleteByPrimary(BadReportDTO badReportDTO) {
        BadReport badReport = badReportDTO.convertToDo();
        badReport.setAllTime();
        badReportMapper.deleteByPrimaryKey(badReport.getId());
        System.out.println("删除成功");
    }
}
