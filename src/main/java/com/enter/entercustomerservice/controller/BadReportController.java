package com.enter.entercustomerservice.controller;

import com.enter.entercustomerservice.pojo.dto.entity.BadReportDTO;
import com.enter.entercustomerservice.service.BadReportService;
import com.enter.entercustomerservice.vo.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
