package com.enter.entercustomerservice.controller;

import com.enter.entercustomerservice.dto.entity.BadReportDTO;
import com.enter.entercustomerservice.service.BadReportService;
import com.enter.entercustomerservice.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2019/9/30.
 */

@RestController
@RequestMapping("/badreports")
public class BadReportController {
    @Autowired
    private BadReportService badReportService;

    @PostMapping("/addBadReport")
    public ResultVO addOne(BadReportDTO badReportDTO) throws Exception {
        badReportService.insertBadReportDTO(badReportDTO);
        return new ResultVO<>();
    }

    @DeleteMapping("/deleteBadReport")
    public ResultVO deleteOne(BadReportDTO badReportDTO) {
        badReportService.deleteByPrimary(badReportDTO);
        return new ResultVO<>();
    }

    @PostMapping("/updateBadReport")
    public ResultVO updateOne(BadReportDTO badReportDTO) throws Exception {
        badReportService.updateByPrimary(badReportDTO);
        return new ResultVO<>();
    }

    @GetMapping("/getBadReport")
    public ResultVO getOne(BadReportDTO badReportDTO) {
        badReportService.selectByPrimary(badReportDTO);
        return new ResultVO<>();
    }

    @GetMapping("/getBadReports")
    public ResultVO getAll() {
        return new ResultVO<>(badReportService.selectAll());
    }

}
