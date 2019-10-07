package com.enter.service.impl;

import com.enter.service.database.mysql.mybatis.BadReportMapper;
import com.enter.service.pojo.dto.entity.BadReportDTO;
import com.enter.service.pojo.entity.BadReport;
import com.enter.service.service.BadReportService;
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
@com.alibaba.dubbo.config.annotation.Service(
        version = "1.0",
        timeout = 10000
)
@Service("BadReportService")
public class BadReportServiceImpl implements BadReportService {

    @Autowired
    private BadReportMapper badReportMapper;

    @Override
    public void insert(BadReportDTO badReportDTO) throws Exception {
        BadReport badReport = badReportDTO.convertToDo();
        badReport.setAllTime();
        badReportMapper.insert(badReport);
    }

    @Override
    public List<BadReportDTO> selectAll() {
        List<BadReport> badReports = badReportMapper.selectAll();
        List<BadReportDTO> badReportDTOSList = new ArrayList<>();
        for (BadReport badReport : badReports) {
            BadReportDTO badReportDTO = new BadReportDTO().convertToDto(badReport);
            badReportDTOSList.add(badReportDTO);
            System.out.println(badReportDTO);
        }
        return badReportDTOSList;

    }

    @Override
    public BadReportDTO selectByPrimary(BadReportDTO badReportDTO) {
        BadReport badReport = badReportDTO.convertToDo();
        badReport.setAllTime();
        BadReport b = badReportMapper.selectByPrimaryKey(badReport.getId());
        BadReportDTO bb = new BadReportDTO().convertToDto(b);
        return bb;
    }

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
