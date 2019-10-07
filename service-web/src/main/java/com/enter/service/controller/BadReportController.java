package com.enter.service.controller;

import com.enter.service.pojo.dto.entity.BadReportDTO;
import com.enter.service.result.ResultBean;
import com.enter.service.service.BadReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/9/30.
 */

@RestController
public class BadReportController {
    @Autowired
    private BadReportService badReportService;

    @PostMapping("/addBadReport")
    public ResultBean addOne(BadReportDTO badReportDTO) throws Exception {
        badReportService.insert(badReportDTO);
        return new ResultBean<>();
    }

    @DeleteMapping("/deleteBadReport")
    public ResultBean deleteOne(BadReportDTO badReportDTO) {
        badReportService.deleteByPrimary(badReportDTO);
        return new ResultBean<>();
    }

    @PostMapping("/updateBadReport")
    public ResultBean updateOne(BadReportDTO badReportDTO) throws Exception {
        badReportService.updateByPrimary(badReportDTO);
        return new ResultBean<>();
    }

    @GetMapping("/getBadReport")
    public ResultBean getOne(BadReportDTO badReportDTO) {
        badReportService.selectByPrimary(badReportDTO);
        return new ResultBean<>();
    }

    @GetMapping("/getBadReports")
    public ResultBean getAll() {
        return new ResultBean<>(badReportService.selectAll());
    }

}
