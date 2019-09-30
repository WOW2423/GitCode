package com.enter.entercustomerservice.controller;

import com.enter.entercustomerservice.dto.entity.BadReportDTO;
import com.enter.entercustomerservice.result.ResultBean;
import com.enter.entercustomerservice.service.BadReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className BadReportController
 * @auther DylanChan
 * @description
 * @date 2019/9/29
 */
@RestController
public class BadReportController {
    @Autowired
    private BadReportService badReportService;

    /**
     * @param
     * @auther Liquid
     * @description
     * @date 2019/9/29
     */
    @GetMapping("/selectAllBadReport")
    public ResultBean getAllBadReports() {
        return new ResultBean<>(badReportService.selectAll());
    }
    @PostMapping("/insertBadReport")
    public void  insert(BadReportDTO badReportDTO) throws Exception {
        badReportService.insert(badReportDTO);
    }
    @GetMapping("/selectBadReportByPrimary")
    public ResultBean selectByPrimary(BadReportDTO badReportDTO){
        return new ResultBean(badReportService.selectByPrimary(badReportDTO));
    }
    @PostMapping("/updateBadReportByPrimary")
    public ResultBean  updateByPrimary(BadReportDTO badReportDTO){
        badReportService.updateByPrimary(badReportDTO);
        return new ResultBean(badReportService.selectByPrimary(badReportDTO));
    }
    @PostMapping("/deleteBadReportByPrimary")
    public void deleteByPrimary(BadReportDTO badReportDTO){
        badReportService.deleteByPrimary(badReportDTO);
    }
}
